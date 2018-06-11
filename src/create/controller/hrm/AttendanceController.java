package create.controller.hrm;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

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

import system.Constants;
import create.model.hrm.KaoqinDetail;
import create.model.hrm.User;
import create.service.hrm.KaoqinDetailService;
import create.service.hrm.UserService;

@Controller
@RequestMapping("/attendanceController")
public class AttendanceController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	 private POIFSFileSystem fs;
	 private HSSFWorkbook wb;
	 private HSSFSheet sheet;
	 private HSSFRow row;
	
	 
	 private UserService userService;
	 
	 private KaoqinDetailService kaoqinDetailService;
	 
	 public UserService getUserService() {
			return userService;
		}
	@Autowired
	public void setUserService(UserService userService) {
			this.userService = userService;
		}

	@SuppressWarnings("deprecation")
	@RequestMapping("/importAttendanceData")
	public ModelAndView importAttendanceData(
			@RequestParam(value = "file", required = false)
			MultipartFile file) throws Exception {
		
		//构建考勤明细对象;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<Integer, String> content = new HashMap<Integer, String>();
        String str = "";
        KaoqinDetail kqDetail = null;
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
        
        Map paraMap = null;
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 3; i <= rowNum; i++) {
            row = sheet.getRow(i);
            kqDetail = new KaoqinDetail();
            //职员姓名
            String username = getCellFormatValue(row.getCell((short) 0)).trim();
            paraMap = new HashMap();
            paraMap.put("username", username);
            List<User> users = userService.pageListByParamMap(paraMap);
            if(users!=null&&users.size()>0){
            	kqDetail.setUserid(users.get(0).getId());
            	//设置部门名称
            	kqDetail.setDepartmentName(users.get(0).getDepartName());
            	//设置部门id
            	kqDetail.setDepartmentId(users.get(0).getDepartid());
            }
            //考勤日期
          String kaoq_date =  getCellFormatValue(row.getCell((short) 5)).trim();
          String kaoq_time =  getCellFormatValue(row.getCell((short) 6)).trim();
          String dk_time =  getCellFormatValue(row.getCell((short) 7)).trim();
          String kq_jg =  getCellFormatValue(row.getCell((short) 8)).trim();
          String kaoq_date_rq = "";
          String kaoq_date_xq = "";
          if(kaoq_date!=null&&kaoq_date.split(" ")!=null){
        	  kaoq_date_rq = kaoq_date.split(" ")[0];
        	  if(kaoq_date_rq.split("-")!=null&&kaoq_date_rq.split("-").length>0){
        		  kaoq_date_rq = String.valueOf(2000+Integer.valueOf(kaoq_date_rq.split("-")[0]))+"-"+kaoq_date_rq.split("-")[1]+"-"+kaoq_date_rq.split("-")[2];
        	  }
        	  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			  kqDetail.setKqdate(simpleDateFormat.parse(kaoq_date_rq));
			//星期
        	  kaoq_date_xq = kaoq_date.split(" ")[1];
        	  kqDetail.setYl2(kaoq_date_xq);
          }
          if(kaoq_time!=null){
        	  Date kqtime_date = sdf.parse(kaoq_time);
				kqDetail.setKqtime(kqtime_date);
				
				
          }
          if(dk_time!=null){
        	//打卡时间
				Date dktime_date = sdf.parse(dk_time);
				kqDetail.setDktime(dktime_date);
          }if(kq_jg!=null){
        	//考勤结果
				if(kq_jg!=null&&Constants.KAOQIN_ZC.equals(kq_jg)){
					kqDetail.setState(Constants.KAOQIN_ZC_STATE);
				}
          }
          kaoqinDetailService.insertKaoqinDetailSelective(kqDetail);
        }
		return new ModelAndView("redirect:/SalaryDetailController/queryPayrollReportResult.go");
	}
	
	/*
	 * 根据员工ID和月份查询所在月份考勤结果
	 */
	@RequestMapping("/queryKaoQinReultByUserId")
	public String queryKaoQinReultByUserId(String userid,
			HttpServletRequest request,String myYear,String month) throws ParseException {
		String userN = request.getParameter("username");
		int year = 0;
		int mon = 0;
		if(myYear!=null&&"".equals(myYear)){
			year = Integer.valueOf(myYear);
		}
		if(month!=null&&!"".equals(month)){
			 mon  = Integer.valueOf(month);
		}
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));    //获取东八区时间
		c.set(year, mon, 1);
		int first = c.getActualMinimum(c.DAY_OF_MONTH);    //获取本月最小天数  
		int last = c.getActualMaximum(c.DAY_OF_MONTH);    //获取本月最大天数 
		String firstday_Month = "";
		if(first<10){
			firstday_Month = myYear +"-"+ Integer.valueOf(mon+1) + "-0" +first;
		}else{
			firstday_Month = myYear +"-"+ Integer.valueOf(mon+1) + "-" +first;
		}
		String lastday_bgMonth = myYear + "-"+Integer.valueOf(mon+1) + "-"+last;
		HashMap paraMap = new HashMap();
		paraMap.put("userid", userid);
		paraMap.put("firstday_MonthDate", firstday_Month);
		paraMap.put("lastday_bgMonthDate", lastday_bgMonth);
		List<KaoqinDetail> list_kqdetail =  kaoqinDetailService.pageKaoQinDetailListByParamMap(paraMap);
		for(KaoqinDetail kq:list_kqdetail){
			kq.setUserName(userN);
			if(kq.getState()!=null&&Constants.KAOQIN_ZC_STATE==kq.getState()){
				kq.setState_str(Constants.KAOQIN_ZC);
			}
			if(kq.getState()!=null&&Constants.KAOQIN_CD_STATE==kq.getState()){
				kq.setState_str(Constants.KAOQIN_CD);
			}
			if(kq.getState()!=null&&Constants.KAOQIN_ZT_STATE==kq.getState()){
				kq.setState_str(Constants.KAOQIN_ZT);
			}
			if(kq.getState()!=null&&Constants.KAOQIN_KG_STATE==kq.getState()){
				kq.setState_str(Constants.KAOQIN_KG);
			}
		}
		request.setAttribute("userid", userid);
		request.setAttribute("firstday", firstday_Month.toString());
		request.setAttribute("lastday", lastday_bgMonth.toString());
		request.setAttribute("list_kqdetail", list_kqdetail);
		return "hrm/staff_kaoqinjilu";
	}
	
	
	/*
	 * 根据员工ID和月份查询所在月份考勤结果
	 */
	@RequestMapping("/queryKaoQinReultByParamter")
	public String queryKaoQinReultByParamter(String userid,
			HttpServletRequest request,String kq_start,String kq_end,String cx_type) throws ParseException {
		String userN = request.getParameter("username");
		String firstday_Month = kq_start;
		String lastday_bgMonth = kq_end;
		HashMap paraMap = new HashMap();
		paraMap.put("userid", userid);
		paraMap.put("firstday_MonthDate", firstday_Month);
		paraMap.put("lastday_bgMonthDate", lastday_bgMonth);
		//如果查询异常加入状态条件，否则查询全部
		if("1".equals(cx_type)){
			paraMap.put("state", cx_type);
		}
		List<KaoqinDetail> list_kqdetail =  kaoqinDetailService.pageKaoQinDetailListByParamMap(paraMap);
		for(KaoqinDetail kq:list_kqdetail){
			kq.setUserName(userN);
			if(kq.getState()!=null&&Constants.KAOQIN_ZC_STATE==kq.getState()){
				kq.setState_str(Constants.KAOQIN_ZC);
			}
			if(kq.getState()!=null&&Constants.KAOQIN_CD_STATE==kq.getState()){
				kq.setState_str(Constants.KAOQIN_CD);
			}
			if(kq.getState()!=null&&Constants.KAOQIN_ZT_STATE==kq.getState()){
				kq.setState_str(Constants.KAOQIN_ZT);
			}
			if(kq.getState()!=null&&Constants.KAOQIN_KG_STATE==kq.getState()){
				kq.setState_str(Constants.KAOQIN_KG);
			}
		}
		request.setAttribute("userid", userid);
		request.setAttribute("firstday", firstday_Month);
		request.setAttribute("lastday", lastday_bgMonth);
		request.setAttribute("list_kqdetail", list_kqdetail);
		return "hrm/staff_kaoqinjilu";
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
    
	public KaoqinDetailService getKaoqinDetailService() {
		return kaoqinDetailService;
	}
	@Autowired
	public void setKaoqinDetailService(KaoqinDetailService kaoqinDetailService) {
		this.kaoqinDetailService = kaoqinDetailService;
	}
}
