/**
 * 
 */
package create.controller.crm;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import system.util.UtilCommon;
import create.controller.core.BaseController;
import create.controller.core.page.Page;
import create.model.crm.ContactInfro;
import create.model.crm.CustomerInfo;
import create.model.crm.Zcproject;
import create.model.hrm.SalaryDetail;
import create.model.hrm.User;
import create.model.system.SysRole;
import create.service.crm.CustomerInfoService;
import create.service.crm.ZcprojectService;
import create.service.hrm.UserService;
import create.service.waipai.InterviewRecordService;

/**
 * @author user
 * 
 */
@Controller
@RequestMapping("/customerInfoController")
public class CustomerInfoController extends BaseController {

	protected final Logger logger = Logger.getLogger(this.getClass());
	
	public CustomerInfoController() {
		// TODO Auto-generated constructor stub
	}

	 private POIFSFileSystem fs;
	 private HSSFWorkbook wb;
	 private HSSFSheet sheet;
	 private HSSFRow row;
	
	
	private ZcprojectService zcprojectService;

	private InterviewRecordService interviewRecordService;
	
	private UserService userService;

	private CustomerInfoService customerInfoService;

	public CustomerInfoService getCustomerInfoService() {
		return customerInfoService;
	}

	@Autowired
	public void setCustomerInfoService(CustomerInfoService customerInfoService) {
		this.customerInfoService = customerInfoService;
	}

	@RequestMapping("/insertContactInfro")
	public String insertCustomerInfo(CustomerInfo customerInfo,
			HttpServletRequest request) {
		try {
			String province = customerInfo.getS_province();
			String city = customerInfo.getS_city();
			String county = customerInfo.getS_county();
			customerInfo.setArea(province + "," + city + "," + county);
			customerInfo.setAtt5(customerInfo.getSale_view());
			//设置删除标志
			customerInfo.setIsdeleted("0");
			customerInfoService.insertCustomerSelective(customerInfo);
			request.setAttribute("customerInfo", customerInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "crm/customerInfoInsert";
	}
	
	
	@RequestMapping("/importCustomer")
	public ModelAndView importCustomerDatas(
			@RequestParam(value = "file", required = false)
			MultipartFile file,HttpServletRequest request) throws Exception {
		HttpSession sessionMap = request.getSession(true);
		User user = (User)sessionMap.getAttribute("user");
		
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
        CustomerInfo customer = null;
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 2; i <= rowNum; i++) {
            row = sheet.getRow(i);
            customer = new  CustomerInfo();
            //公司名字
            customer.setCustomername(getCellFormatValue(row.getCell((short) 0)).trim());
            //地址
            customer.setAddress(getCellFormatValue(row.getCell((short) 1)).trim());
            customer.setNeedproducts(getCellFormatValue(row.getCell((short) 2)).trim());
           //沟通概况
            customer.setBusiness(getCellFormatValue(row.getCell((short) 3)).trim());
            if(user!=null){
            	customer.setAtt5(user.getUsername());
            }
            
           if(validate(customer.getCustomername(),customer,request)!=null){
        	   if("0".equals(validate(customer.getCustomername(),customer,request).get("message"))){
        		   customerInfoService.insertCustomerSelective(customer);
        	   };
           };
        }
		
		ModelAndView mv = new ModelAndView("redirect:/customerInfoController/queryCustomerInfoList.go");
		return mv;
	}

	// 修改驻场工程师信息
	@RequestMapping("/updateCustomerWaipenRenyuan")
	public ModelAndView updateCustomerWaipenRenyuan(HttpServletRequest request)
			throws Exception {
//		InterviewRecord interviewRecord = new InterviewRecord();
//		interviewRecord.setId(Integer.valueOf(request.getParameter(
//				"interviewId").trim()));
//		interviewRecord.setMsjg(Integer.valueOf(request.getParameter("msjg")
//				.trim()));
//		interviewRecordService.updateByPrimaryKeySelective(interviewRecord);
		User u = userService.getUserById(Integer.valueOf(request.getParameter("id")));
		u.setStatus(2);
		userService.upDateUser(u);
		return new ModelAndView(
				"redirect:/customerInfoController/queryCustomerWaipenRenyuan.go?customerid="
						+ request.getParameter("customerid"));
	}

	/*
	 * 查询此客户下的驻场项目
	 */
	@RequestMapping("/queryCustomerZcProjectList")
	public String queryCustomerZcProjectList(String id,
			HttpServletRequest request) {
		HashMap param = new HashMap();
		String cid = request.getParameter("cid");
		if(cid!=null&&!"".equals(cid)){
			param.put("cid", cid);
		}
		request.setAttribute("cid", cid);
		List<Zcproject> zcprojectList = zcprojectService.selectZcprojectByParamMap(param);
		request.setAttribute("zcprojectList", zcprojectList);
		return "crm/zcProjectList";
	}
	
	/*
	 * 新增客户的驻场项目信息
	 */
	@RequestMapping("/addCustomerZcProjectList")
	public ModelAndView addCustomerZcProjectList(Zcproject zcproject,
			HttpServletRequest request) throws ParseException {
		//新增数据默认0位有效数据，1位已经删除数据
		zcproject.setState(0);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date d =new Date(); String dd =format.format(d);
		HttpSession sessionMap = request.getSession(true);
		User new_user = (User)sessionMap.getAttribute("user");
		zcproject.setCreateby(new_user.getId());
		zcproject.setCreatetime(format.parse(dd));
		zcprojectService.insertZcprojectSelective(zcproject);
		return new ModelAndView(
				"redirect:/customerInfoController/queryCustomerZcProjectList.go?cid="
				+ zcproject.getCid());
	}
	
	/*
	 * 跳转到修改页面
	 */
	@RequestMapping("/toEditeCustomerZcProjectList")
	public String toEditeCustomerZcProjectList(HttpServletRequest request) throws ParseException {
		String id = request.getParameter("id");
		if(id!=null&&!"".equals(id)){
			Zcproject zcproject = zcprojectService.selectByPrimaryKey(Integer.valueOf(id));
			request.setAttribute("zcproject", zcproject);
			request.setAttribute("type", "edite");
		}
		return "crm/zcproject_add_or_edite";
	}
	

	
	/*
	 * Ajax获取客户下面的驻场项目
	 */
	@RequestMapping("/ajaxProjectIformations")
	@ResponseBody
	public void ajaxProjectIformations(HttpServletRequest request,
			HttpServletResponse response, ContactInfro contactInfro,
			String customerid) throws ParseException {
		Integer id = Integer.valueOf(customerid); 
		String data = "";
		if(id!=null){
			Map param = new HashMap();
			param.put("cid", id);
			List<Zcproject> zcprojects = zcprojectService.selectZcprojectByParamMap(param);
			for(Zcproject zcp:zcprojects){
				data = data +"id:"+zcp.getId()+",projectname:"+zcp.getProjectname()+";";
			}
		}else{
			data = "";
		}

		if (data != null && !"".equals(data)) {
			try {
				UtilCommon.reponse(request, response, data.substring(0, data
						.lastIndexOf(";")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * 删除客户的驻场项目信息
	 */
	@RequestMapping("/deleteCustomerZcProjectList")
	public ModelAndView deleteCustomerZcProjectList(Zcproject zcproject,
			HttpServletRequest request) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date d =new Date(); String dd =format.format(d);
		HttpSession sessionMap = request.getSession(true);
		User new_user = (User)sessionMap.getAttribute("user");
		zcproject.setModifyby(new_user.getId());
		zcproject.setModifytime(format.parse(dd));
		zcproject.setState(1);//state=0 表示数据逻辑是被删除
		zcprojectService.updateZcprojectByPrimaryKeySelective(zcproject);
		return new ModelAndView(
				"redirect:/customerInfoController/queryCustomerZcProjectList.go?cid="
				+ zcproject.getCid());
	}
	
	
	/*
	 * 修改客户的驻场项目信息
	 */
	@RequestMapping("/updateCustomerZcProjectList")
	public ModelAndView updateCustomerZcProjectList(Zcproject zcproject,
			HttpServletRequest request) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date d =new Date(); String dd =format.format(d);
		HttpSession sessionMap = request.getSession(true);
		User new_user = (User)sessionMap.getAttribute("user");
		zcproject.setModifyby(new_user.getId());
		zcproject.setModifytime(format.parse(dd));
		zcprojectService.updateZcprojectByPrimaryKeySelective(zcproject);
		return new ModelAndView(
				"redirect:/customerInfoController/queryCustomerZcProjectList.go?cid="
				+ zcproject.getCid());
	}
	
	/*
	 * 查询此客户下的外派人员
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryCustomerWaipenRenyuan")
	public String queryCustomerWaipenRenyuan(String id,
			HttpServletRequest request) {
		HashMap param = new HashMap();
		param.put("internalstaff", request.getParameter("customerid"));
		if(request.getParameter("status")!=null){
			param.put("status", 0);
		}
		List<User> users = userService.pageListByParamMap(param);
		request.setAttribute("users", users);
		return "crm/dispatchStuffList";
	}

	//判断该数据是否在数据库中已经存在
	@RequestMapping(value = "/validate", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> validate(@RequestParam(value = "customername", required = true)String customername,CustomerInfo customerInfo,HttpServletRequest request) throws UnsupportedEncodingException {
		Map param = new HashMap();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		customername = URLDecoder.decode(customername, "UTF-8");
		// 全匹配查询客户名称是否重复
		param.put("customername",customername);
		List<CustomerInfo> lists = customerInfoService
				.pageListByValidite(param);
		
		if (lists != null && lists.size() > 0) {
			modelMap.put("message", "1");
		} else {
			modelMap.put("message", "0");
		}
		return modelMap;
	}

	@RequestMapping("/toEditeCustomerInfo")
	public String toEditeCustomerInfo(String id, HttpServletRequest request) {
		try {
			CustomerInfo customerInfo = customerInfoService
					.selectByPrimaryKey(Integer.valueOf(id));
			if (customerInfo.getArea() != null
					&& customerInfo.getArea().split(",").length >= 1) {
				customerInfo
						.setS_province(customerInfo.getArea().split(",")[0]);
			}
			if (customerInfo.getArea() != null
					&& customerInfo.getArea().split(",").length >= 2) {
				customerInfo.setS_city(customerInfo.getArea().split(",")[1]);
			}
			if (customerInfo.getArea() != null
					&& customerInfo.getArea().split(",").length >= 3) {
				customerInfo.setS_county(customerInfo.getArea().split(",")[2]);
			}
			request.setAttribute("customerInfo", customerInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "crm/customerEdite";
	}

	@RequestMapping("/editeCustomerInfo")
	public ModelAndView editeCustomerInfo(CustomerInfo customerInfo,
			HttpServletRequest request) {
		ModelAndView mv = null;
		try {
			customerInfo.setAtt5(customerInfo.getSale_view());
			String type = request.getParameter("type");
			if("1".equals(type)){
				customerInfoService
				.updateCustomerInfoByPrimaryKeySelective(customerInfo);
				mv = new ModelAndView(
						"redirect:/customerInfoController/toEditeCustomerInfo.go?id="
								+ customerInfo.getId());
			}else{
				//1标识已经深处
				customerInfo.setIsdeleted("1");
				customerInfoService
				.updateCustomerInfoByPrimaryKeySelective(customerInfo);
				mv = new ModelAndView(
						"redirect:/customerInfoController/queryCustomerInfoList.go");
			}
			request.setAttribute("customerInfo", customerInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	

	@SuppressWarnings("unchecked")
	@RequestMapping("/queryCustomerInfoList")
	public String queryCustomerInfoList(CustomerInfo customerInfo,
			HttpServletRequest request) {
		try {
			//查询条件
			Map<String, Object> params = new HashMap<String, Object>();
			//判断权限获取角色权限
			HttpSession sessionMap = request.getSession(true);
			List<SysRole> currentRoles = (List<SysRole>) sessionMap.getAttribute("currentRoles");
			Map authMap = (Map) sessionMap.getAttribute("role_authority");
			//获取所有的有效用户
			@SuppressWarnings("unused")
			List<User> allUsers = (List<User>) sessionMap.getAttribute("allUsers");
			User user = (User)sessionMap.getAttribute("user");
			if(UtilCommon.checkAuthority("customer_query_all",currentRoles,authMap)){
				params.put("sale", null);
			}
			else if(UtilCommon.checkAuthority("customer_query_dept",currentRoles,authMap)){
				//得到部門下的員工id
				params.put("sale", UtilCommon.getDepartUserIDs(user,allUsers));
			}else if(UtilCommon.checkAuthority("customer_query_personal",currentRoles,authMap)){
				params.put("sale", sessionMap.getAttribute("userID").toString());
			}else{
//				yl3沒有分配任何權限,只有菜單權限
				params.put("sale", -1);
			}
			String pageNow = request.getParameter("pageNow");
			List<CustomerInfo> customerInfoList = null;
			// 查询条件
			if (customerInfo.getCustomername() != null
					&& !"".equals(customerInfo.getCustomername())) {
				params.put("customername", customerInfo.getCustomername());
			}
			if (customerInfo.getAddress() != null
					&& !"".equals(customerInfo.getAddress())) {
				params.put("address", customerInfo.getAddress());
			}
			if (customerInfo.getCustomerproperty() != null
					&& !"".equals(customerInfo.getCustomerproperty())) {
				params.put("customerproperty", customerInfo
						.getCustomerproperty());
			}
			if (customerInfo.getNeedproducts() != null
					&& !"".equals(customerInfo.getNeedproducts())) {
				params.put("needproducts", customerInfo.getNeedproducts());
			}
			// 获取总条数
			Long totalCount = this.customerInfoService.pageCounts(params);
			// 设置分页对象
			Page page = executePage(request, totalCount);
			// 设置分页页面信息
			//偏移量
			params.put("startIndex", page.getBeginIndex());
			//条数
			params.put("endIndex", page.getEveryPage());
			// 如排序
			if (page.isSort()) {
				params.put("orderName", page.getSortName());
				params.put("descAsc", page.getSortState());
			} else {
				// 没有进行排序,默认排序方式
				params.put("orderName", "age");
				params.put("descAsc", "asc");
			}
			customerInfoList = customerInfoService.pageListByParamMap(params);
			request.setAttribute("customerInfoList", customerInfoList);
			request.setAttribute("page", page);
			customerInfoService.pageListByParamMap(params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "crm/customerList";
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

	public InterviewRecordService getInterviewRecordService() {
		return interviewRecordService;
	}

	@Autowired
	public void setInterviewRecordService(
			InterviewRecordService interviewRecordService) {
		this.interviewRecordService = interviewRecordService;
	}

	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ZcprojectService getZcprojectService() {
		return zcprojectService;
	}
	@Autowired
	public void setZcprojectService(ZcprojectService zcprojectService) {
		this.zcprojectService = zcprojectService;
	}

}
