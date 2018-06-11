package create.controller.hrm;

import java.io.IOException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import test.SendMailUtil;
import create.model.hrm.SalaryDetail;
import create.model.hrm.User;
import create.model.system.CompanyInfo;
import create.model.system.SysRole;
import create.service.hrm.CompanyInfoService;
import create.service.hrm.SalaryDetailService;
import create.service.hrm.UserService;

@Controller
@RequestMapping("/SalaryDetailController")
public class SalaryDetailController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	 private CompanyInfoService companyInfoService;
	 
	 private SalaryDetailService salaryDetailService;
	 
	 
	 private UserService userService;

	 public UserService getUserService() {
			return userService;
		}

	@Autowired
	public void setUserService(UserService userService) {
			this.userService = userService;
		}
	 
	 private POIFSFileSystem fs;
	 private HSSFWorkbook wb;
	 private HSSFSheet sheet;
	 private HSSFRow row;
/*
 * columnSelect选择的列
 */
	@RequestMapping("/querySalarys")
	public String querySalaryList(HttpServletRequest request, HttpServletResponse response,SalaryDetail salaryDetail) {
		Map paramMap = new HashMap();
		//判断权限获取角色权限
		HttpSession sessionMap = request.getSession(true);
		User user = (User)sessionMap.getAttribute("user");
		List<SysRole> currentRoles = (List<SysRole>) sessionMap.getAttribute("currentRoles");
		Map authMap = (Map) sessionMap.getAttribute("role_authority");
		String query_mark = "";
		for(SysRole sr:currentRoles){
			//财务经理查询所有人员
			if("Financemanager".equals(sr.getRoleMark())){
				query_mark = "1";
			}
		}
		//查询所有人
		if(!"1".equals(query_mark)){
			paramMap.put("hr", user.getId());
		}
		String result = "";
		String position = request.getParameter("position");
		String yl3 = request.getParameter("yl3");
		String yl4 = request.getParameter("yl4");
		String staffname = request.getParameter("staffname");
		String myYear = request.getParameter("myYear");
		String myMonth = request.getParameter("myMonth");
		 
		Calendar cal = Calendar.getInstance();
		//默认查询上一个月
	    int month = cal.get(Calendar.MONTH)-1;
	    int year = cal.get(Calendar.YEAR);
		
		//查询分公司
		List<CompanyInfo> companys = companyInfoService.selectCompanyByPropterty(null);
		request.setAttribute("companys",companys);
		
		if(!"".equals(position)){
			paramMap.put("position",position);
		}
		if(!"".equals(yl3)){
			paramMap.put("yl3",yl3);
		}
		//查询选项，已经发放或者未发放
		if(!"".equals(yl4)){
			paramMap.put("yl4",yl4);
		}
		if(!"".equals(staffname)){
			paramMap.put("staffname",staffname);
		}
//		年
		if(myYear!=null&&!"".equals(myYear)){
			paramMap.put("yl1",myYear);
		}else{
	        paramMap.put("yl1",year);
		}
		if(myMonth!=null&&!"".equals(myMonth)){
			paramMap.put("yl2",myMonth);
		}else{
			//默认查询上个月的工资
			if(month==0){
				paramMap.put("yl2",11);
			}else{
				paramMap.put("yl2",month);
			}
		}
		List<SalaryDetail> salaryDetails = salaryDetailService.selectSalaryByParamMap(paramMap);
		for( SalaryDetail s:salaryDetails){
			if(s.getHr()!=null&&0!=s.getHr()){
				User use = userService.getUserById(s.getHr());
				s.setHr_Str(use.getUsername());
			}
		}
		request.setAttribute("salaryDetails",salaryDetails);
		if(request.getParameter("type")!=null&&"1".equals(request.getParameter("type"))){
			result = "hrm/salary_entemail_list";
		}else{
			result = "hrm/salary_list";
		}
		return result;
	}
	
	@RequestMapping("/wageStripEmail")
	public String wageStripEmail(HttpServletRequest request, HttpServletResponse response) {
		SalaryDetail salaryDetail = new SalaryDetail();
		String result = "";
		List<SalaryDetail> salaryDetails;
		String sentAll = request.getParameter("sentAll");
		if("1".equals(sentAll)){
			String position = request.getParameter("position");
			String yl3 = request.getParameter("yl3");
			String staffname = request.getParameter("staffname");
			String myYear = request.getParameter("myYear");
			String myMonth = request.getParameter("myMonth");
			Map paramMap = new HashMap();
			if(!"".equals(position)){
				paramMap.put("position",position);
			}
			if(!"".equals(yl3)){
				paramMap.put("yl3",yl3);
			}
			if(!"".equals(staffname)){
				paramMap.put("staffname",staffname);
			}
			if(!"".equals(myYear)){
				paramMap.put("yl",myYear);
			}
			if(!"".equals(myMonth)){
				paramMap.put("yl2",myMonth);
			}
			salaryDetails = salaryDetailService.selectSalaryByParamMap(paramMap);
		}if("2".equals(sentAll)){//单独发送一个邮件
			String sId = request.getParameter("sId");
			salaryDetails = new ArrayList();
			if(sId!=null&&!"".equals(sId)){
					salaryDetails.add(salaryDetailService.searchSalaryDetailByPrimaryKey(Integer.valueOf(sId)));
			}
		}
		else{//批量选择发放邮件
			String checkId = request.getParameter("checkId");
			String[] ids = request.getParameter("checkId").split(";");
			salaryDetails = new ArrayList();
			for(String id:ids){
				if(id!=null&&!"".equals(id)){
					salaryDetails.add(salaryDetailService.searchSalaryDetailByPrimaryKey(Integer.valueOf(id)));
				}
			}
		}
		String textTitle = "";
		//需要导出的列
		String[] columnSelect =null;
		for(SalaryDetail ss:salaryDetails){
			if(request.getParameter("selectcolum")!=null&&!"".equals(request.getParameter("selectcolum"))){
				columnSelect = request.getParameter("selectcolum").split(";");
				String text = "";
				if(columnSelect[0]!=null&&"staffname".equals(columnSelect[0])){
//						text += "姓名 ："+ss.getStaffname()+"<br>";
					 textTitle = ss.getYl1()+" 年 "+(Integer.valueOf(ss.getYl2())+1)+" 月份 "+"工资条";
				}
				if(columnSelect[1]!=null&&"idno".equals(columnSelect[1])){
					 text += "身份证号 ："+ss.getIdno()+"<br>";
				}
				if(columnSelect[2]!=null&&"fullsalary".equals(columnSelect[2])){
					 text += "转正以后工资 ："+ss.getFullsalary()+"<br>";
				}
				if(columnSelect[3]!=null&&"fullsalarydate".equals(columnSelect[3])){
					 text += "发全薪日期 ："+ss.getFullsalarydate()+"<br>";
				}
				if(columnSelect[4]!=null&&"paymentwage".equals(columnSelect[4])){
					 text += "当月应发 工资金额 ："+ss.getPaymentwage()+"<br>";
				}
				if(columnSelect[5]!=null&&"payday".equals(columnSelect[5])){
					 text += "各项目计薪天数 ："+ss.getPayday()+"<br>";
				}
				if(columnSelect[6]!=null&&"actualpayday".equals(columnSelect[6])){
					 text += " 计薪天数 ："+ss.getActualpayday()+"<br>";
				}
				if(columnSelect[7]!=null&&"subsidydebit".equals(columnSelect[7])){
					 text += " 加班费、补贴、扣款 ："+ss.getSubsidydebit()+"<br>";
				}
				if(columnSelect[8]!=null&&"subsidydebitexplain".equals(columnSelect[8])){
					text += " 补贴说明 ："+ss.getSubsidydebitexplain()+"<br>";
				}
				if(columnSelect[9]!=null&&"reimbursement".equals(columnSelect[9])){
					text += " 报销费用 ："+ss.getReimbursement()+"<br>";
				}
				if(columnSelect[10]!=null&&"socialsecurity".equals(columnSelect[10])){
					text += " 代扣社保 ："+ss.getSocialsecurity()+"<br>";
				}
				if(columnSelect[11]!=null&&"accumulationfund".equals(columnSelect[11])){
					text += " 代扣公积金 ："+ss.getAccumulationfund()+"<br>";
				}
				if(columnSelect[12]!=null&&"wages".equals(columnSelect[12])){
					text += " 考勤应发工资（考勤工资+调整补贴） ："+ss.getWages()+"<br>";
				}
//				if(columnSelect[13]!=null&&"actualwages".equals(columnSelect[13])){
//					text += " 实际应发工资（减去社保和公积金） ："+ss.getActualwages()+"<br>";
//				}
//				if(columnSelect[14]!=null&&"selftax".equals(columnSelect[14])){
//					text += " 计算个税金额（扣除报销款） ："+ss.getSelftax()+"<br>";
//				}
				if(columnSelect[15]!=null&&"incometax".equals(columnSelect[15])){
					text += " 个人所得税 ："+ss.getIncometax()+"<br>";
				}
				if(columnSelect[16]!=null&&"shifagongzi".equals(columnSelect[16])){
//					text += " 实发工资（应发-个税） ："+ss.getShifagongzi()+"<br>";
					text += " 实发工资 ："+ss.getShifagongzi()+"<br>";
				}
				Map paramMap = new HashMap();
				paramMap.put("idno", ss.getIdno());
				List<User> uer = userService.pageListByParamMap(paramMap);
				if(uer!=null&&uer.size()>0){
					if(uer.get(0).getIdno().equals(ss.getIdno())){
						/*
						 * to发送给谁,cs,ms密送，邮件主题，邮件主题
						 */
						SendMailUtil sendMailUtil = new SendMailUtil();
						String[] to = {uer.get(0).getEmail()};
						String[] cs = {"guohaihang@xiangmu.com","sunny@xiangmu.ren","pengfei@xiangmu.ren"};
						String[] ms = {"create@xiangmu.ren"};
						String[] fileList = null;
						try {
							sendMailUtil.send_(to, cs, ms, textTitle, text, "hr2@xiangmu.ren",
									fileList,"smtp.mxhichina.com","hr2@xiangmu.ren", "AAaa1234");
							//更新工资信息表  yl4表示邮件已经发送成功
							ss.setYl4(String.valueOf(1));
							salaryDetailService.updateSalaryDetail(ss);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		return "hrm/salary_entemail_list";
	}
	
	/*
	 * 跳转到修改页面
	 */
	@RequestMapping("/editeSalary")
	public ModelAndView editeSalary(HttpServletRequest request, HttpServletResponse response,SalaryDetail salaryDetail) {
		salaryDetailService.updateSalaryDetail(salaryDetail);
		return new ModelAndView("redirect:/SalaryDetailController/querySalarys.go?type="+request.getParameter("type"));
	}
	
	/*
	 * 跳转到修改页面
	 */
	@RequestMapping("/toEditeSalary")
	public String toEditeSalary(HttpServletRequest request, HttpServletResponse response) {
		String sId = request.getParameter("sId");
		if(sId!=null&&!"".equals(sId)){
			SalaryDetail salaryDetail = salaryDetailService.searchSalaryDetailByPrimaryKey(Integer.valueOf(sId));
			if(salaryDetail.getHr()!=null&&0!=salaryDetail.getHr()){
				User use = userService.getUserById(salaryDetail.getHr());
				salaryDetail.setHr_Str(use.getUsername());
			}
			//设置日期格式
			if(salaryDetail!=null&&salaryDetail.getEntrydateStr()!=null){
				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				 String dateString = formatter.format(salaryDetail.getEntrydateStr());
				 ParsePosition pos = new ParsePosition(8);
				 Date currentTime_2 = formatter.parse(dateString, pos);
				 salaryDetail.setEntrydate(currentTime_2);
			}
			request.setAttribute("salaryDetail", salaryDetail);
		}
		return "hrm/salary_add_oredite";
	}
	/*
	 * 修改数据
	 */
	@RequestMapping("/editeSalaryData")
	public ModelAndView EditeSalary(HttpServletRequest request, HttpServletResponse response,SalaryDetail salaryDetail) {
		String type = request.getParameter("type");
		salaryDetailService.updateSalaryDetail(salaryDetail);
		return new ModelAndView("redirect:/SalaryDetailController/querySalarys.go?type="+type);
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/importFinanceData")
	public ModelAndView importFinanceData(
			@RequestParam(value = "file", required = false)
			MultipartFile file,SalaryDetail salaryDetail) {
		//构建薪酬福利对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<Integer, String> content = new HashMap<Integer, String>();
        String str = "";
        SalaryDetail sd;
        try {
            fs = new POIFSFileSystem(file.getInputStream());
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            sd = new SalaryDetail();
            //职员姓名
            sd.setStaffname(getCellFormatValue(row.getCell((short) 0)).trim());
            //职  务
            sd.setPosition(getCellFormatValue(row.getCell((short) 1)).trim());
            if(getCellFormatValue(row.getCell((short) 2))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 2)).trim())){
            	User u = new User();
            	Map paramMap = new HashMap();
            	paramMap.put("username", getCellFormatValue(row.getCell((short) 2)).trim());
            	if(userService.pageListByParamMap(paramMap).size()>0){
            		sd.setHr(userService.pageListByParamMap(paramMap).get(0).getId());
            	}
            }
            //岗位
            if(getCellFormatValue(row.getCell((short) 3))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 3)).trim())){
            	sd.setYl3(getCellFormatValue(row.getCell((short) 3)).trim());
            }
            //身份证号码
            if(getCellFormatValue(row.getCell((short) 4))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 4)).trim())){
            	sd.setIdno(getCellFormatValue(row.getCell((short) 4)).trim());
            }
            //入职日期
            if(getCellFormatValue(row.getCell((short) 5))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 5)).trim())){
            	try {
					sd.setEntrydate(sdf.parse(getCellFormatValue(row.getCell((short) 5)).trim()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            //转正后金额
            if(getCellFormatValue(row.getCell((short) 6))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 6)).trim())){
            	sd.setFullsalary(Float.valueOf(getCellFormatValue(row.getCell((short) 6)).trim()));
            }
            //发全额薪水日期
            if(getCellFormatValue(row.getCell((short) 7))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 7)).trim())){
            	sd.setFullsalarydate(getCellFormatValue(row.getCell((short) 7)).trim());
            }
            //当月应发工资金额
            if(getCellFormatValue(row.getCell((short) 8))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 8)).trim())){
            	sd.setPaymentwage(Float.valueOf(getCellFormatValue(row.getCell((short) 8)).trim()));
            }
            //上社保时间及状态
            if(getCellFormatValue(row.getCell((short) 9))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 9)).trim())){
            	sd.setInsurancestatus(getCellFormatValue(row.getCell((short) 9)).trim());
            }
           //电脑押金情況說明
            if(getCellFormatValue(row.getCell((short) 10))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 10)).trim())){
            	sd.setPcdeposit(getCellFormatValue(row.getCell((short) 10)).trim());
            }
            //"各项目计薪天数"
            if(getCellFormatValue(row.getCell((short) 11))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 11)).trim())){
            	sd.setPayday(Float.valueOf(getCellFormatValue(row.getCell((short) 11)).trim()));
            }
          //实际计薪天数
            if(getCellFormatValue(row.getCell((short) 12))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 12)).trim())){
            	sd.setActualpayday(Float.valueOf(getCellFormatValue(row.getCell((short) 12)).trim()));
            }
            //加班费、补贴、扣款
            if(getCellFormatValue(row.getCell((short) 13))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 13)).trim())){
            	sd.setSubsidydebit(Float.valueOf(getCellFormatValue(row.getCell((short) 13)).trim()));
            }
            //补贴扣款说明
            if(getCellFormatValue(row.getCell((short) 14))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 14)).trim())){
            	sd.setSubsidydebitexplain(getCellFormatValue(row.getCell((short) 14)).trim());
            }
            //报销费用
            if(getCellFormatValue(row.getCell((short) 15))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 15)).trim())){
            	sd.setReimbursement(Float.valueOf(getCellFormatValue(row.getCell((short) 15)).trim()));
            }
            //社保代扣
            if(getCellFormatValue(row.getCell((short) 16))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 16)).trim())){
            	sd.setSocialsecurity(Float.valueOf(getCellFormatValue(row.getCell((short) 16)).trim()));
            }
            //公积金
            if(getCellFormatValue(row.getCell((short) 17))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 17)).trim())){
            	sd.setAccumulationfund(Float.valueOf(getCellFormatValue(row.getCell((short) 17)).trim()));
            }
            //工资
            if(getCellFormatValue(row.getCell((short) 18))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 18)).trim())){
            	sd.setWages(Float.valueOf(getCellFormatValue(row.getCell((short) 18)).trim()));
            }
            //实际应发工资
            if(getCellFormatValue(row.getCell((short) 19))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 19)).trim())){
            	sd.setActualwages(Float.valueOf(getCellFormatValue(row.getCell((short) 19)).trim()));
            }
            //计算个税金额
            if(getCellFormatValue(row.getCell((short) 20))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 20)).trim())){
            	sd.setSelftax(Float.valueOf(getCellFormatValue(row.getCell((short) 20)).trim()));
            }
          //个人所得税
            if(getCellFormatValue(row.getCell((short) 21))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 21)).trim())){
            	sd.setIncometax(Float.valueOf(getCellFormatValue(row.getCell((short) 21)).trim()));
            }
          //实发工资（应发-个税）
            if(getCellFormatValue(row.getCell((short) 22))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 22)).trim())){
            	sd.setShifagongzi(Float.valueOf(getCellFormatValue(row.getCell((short) 22)).trim()));
            }
          //已发薪资
            if(getCellFormatValue(row.getCell((short) 23))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 23)).trim())){
            	sd.setYifa(Float.valueOf(getCellFormatValue(row.getCell((short) 23)).trim()));
            }
          //补发
            if(getCellFormatValue(row.getCell((short) 24))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 24)).trim())){
            	sd.setBufa(Float.valueOf(getCellFormatValue(row.getCell((short) 24)).trim()));
            }
          //账户
            if(getCellFormatValue(row.getCell((short) 25))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 25)).trim())){
            	sd.setZhanghu(getCellFormatValue(row.getCell((short) 25)).trim());
            }
          //开户行名称
            if(getCellFormatValue(row.getCell((short) 26))!=null&&!"".equals(getCellFormatValue(row.getCell((short) 26)).trim())){
            	sd.setKaihuhangname(getCellFormatValue(row.getCell((short) 26)).trim());
            }
            //初始化为0表示邮件未发送
            sd.setYl4("0");
            /*
             * 根据工资条月份，年份，身份证 查询该数据是否已经存在，存在则更新相关数据，不存在则新增
             */
            Map paramMap = new HashMap();
    		if(!"".equals(salaryDetail.getYl1())){
    			//查询条件
    			paramMap.put("yl1",salaryDetail.getYl1());
    			sd.setYl1(salaryDetail.getYl1());
    		}
    		if(!"".equals(salaryDetail.getYl2())){
    			//查询条件
    			paramMap.put("yl2",salaryDetail.getYl2());
    			sd.setYl2(salaryDetail.getYl2());
    		}
    		if(!"".equals(sd.getYl2())){
    			paramMap.put("idno",sd.getIdno());
    		}
    		List<SalaryDetail> salaryDetails = salaryDetailService.selectSalaryByParamMap(paramMap);
			
    		if(salaryDetails!=null&&salaryDetails.size()==0){
    			salaryDetailService.insertSalaryDetail(sd);
    		}else{
    			if(salaryDetails!=null&&salaryDetails.size()>0){
    				sd.setId(salaryDetails.get(0).getId());
    			}
    			salaryDetailService.updateSalaryDetail(sd);
    		}
            str = "";
        }
        
		return new ModelAndView("redirect:/SalaryDetailController/querySalarys.go");
	}
	
	/**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    private String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
            case HSSFCell.CELL_TYPE_NUMERIC:
            case HSSFCell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 如果是Date类型则，转化为Data格式
                    
                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                    //cellvalue = cell.getDateCellValue().toLocaleString();
                    
                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellvalue = sdf.format(date);
                    
                }
                // 如果是纯数字
                else {
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            // 如果当前Cell的Type为STRIN
            case HSSFCell.CELL_TYPE_STRING:
                // 取得当前的Cell字符串
                cellvalue = cell.getRichStringCellValue().getString();
                break;
            // 默认的Cell值
            default:
                cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }
    
    public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

    @Autowired
	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public SalaryDetailService getSalaryDetailService() {
		return salaryDetailService;
	}
	@Autowired
	public void setSalaryDetailService(SalaryDetailService salaryDetailService) {
		this.salaryDetailService = salaryDetailService;
	}
}
