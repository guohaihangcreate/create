package create.controller.hrm;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import create.controller.core.BaseController;
import create.controller.core.page.Page;
import create.model.hrm.Payroll;
import create.model.hrm.User;
import create.service.hrm.PayrollService;
import create.service.hrm.UserService;


@Controller
@RequestMapping("/payrollController")
public class PayrollController extends BaseController{

	protected final Logger logger = Logger.getLogger(this.getClass());
	
	private PayrollService payrollService;

	public PayrollService getPayrollService() {
		return payrollService;
	}
	@Autowired
	public void setPayrollService(PayrollService payrollService) {
		this.payrollService = payrollService;
	}
	
	
	/*
	 * 查询此客户下的外派人员
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryPayrollReportResult")
	public String queryCustomerWaipenRenyuan(String id,
			HttpServletRequest request) {
		HashMap param = new HashMap();
		List<Payroll> payrollReportList = payrollService.pagePayrollReprotList(param);
		request.setAttribute("payrollReportList", payrollReportList);
		return "hrm/payrollReportResult";
	}
	
	/*
	 * 新增薪酬福利信息
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertPayrollInfro")
	public ModelAndView  insertPayrollInfro(Payroll payroll,
			HttpServletRequest request) {
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(payroll.getEnterdate_str()!=null&&!"".equals(payroll.getEnterdate_str())){
				payroll.setEnterdate(fmt.parse(payroll.getEnterdate_str()));
			}
			if(payroll.getZzdate_str()!=null&&!"".equals(payroll.getZzdate_str())){
				payroll.setZzdate(fmt.parse(payroll.getZzdate_str()));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		payrollService.insertSelective(payroll);
		return new ModelAndView("redirect:/payrollController/queryPayrollInfro.go");
	}
	
	/*
	 * 到修改薪酬福利信息页面
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/toEditePayrollInfro")
	public String toEditePayrollInfro(String id,
			HttpServletRequest request) {
		Payroll payroll = null;
		if(id!=null&&!"".equals(id)){
			payroll = payrollService.selectByPrimaryKey(Integer.valueOf(id));
		}
		request.setAttribute("payroll", payroll);
		request.setAttribute("type", 1);
		return "hrm/payrollInert_edite";
	}
	
	/*
	 * 修改薪酬福利信息
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/updatePayrollInfro")
	public ModelAndView updatePayrollInfro(Payroll payroll,
			HttpServletRequest request) {
		payrollService.updatePayrollByPrimaryKey(payroll);
		return new ModelAndView("redirect:/payrollController/queryPayrollInfro.go");
	}
	
	/*
	 * 删除薪酬福利信息
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/deletePayrollInfro")
	public ModelAndView toDeletePayrollInfro(String id,
			HttpServletRequest request) {
		Payroll payroll = null;
		if(id!=null&&!"".equals(id)){
			payrollService.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return new ModelAndView("redirect:/payrollController/queryPayrollInfro.go");
	}
	
	//判断该数据是否在数据库中已经存在
	@RequestMapping(value = "/validate_payroll", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> validate_payroll(@RequestParam(value = "userid", required = true)String userid,HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		userid = URLDecoder.decode(userid, "UTF-8");
		HashMap params = new HashMap();
		params.put("userid", request.getParameter("userid"));
		List<Payroll> payrollList = payrollService.pagePayrollListByParamMap(params);
		if (payrollList != null&&payrollList.size()>0) {
			modelMap.put("message", "1");
		} else {
			modelMap.put("message", "0");
		}
		return modelMap;
	}
	/*
	 * 查询薪酬福利信息
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryPayrollInfro")
	public String queryPayrollInfro(HttpServletRequest request) {
		String pageNow = request.getParameter("pageNow");
		HashMap params = new HashMap();
		// 获取总条数
		Long totalCount = this.payrollService.pageCounts(params);
		// 设置分页对象
		Page page = executePage(request, totalCount);
		// 设置分页页面信息
		params.put("username", request.getParameter("username"));
		if(request.getParameter("status")!=null&&!"".equals(request.getParameter("status"))){
			params.put("status", request.getParameter("status"));
		}
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
		HashMap param = new HashMap();
		if(request.getParameter("status")!=null&&!"".equals(request.getParameter("status"))){
			param.put("status", request.getParameter("status"));
		}
		param.put("status", request.getParameter("status"));
		param.put("username", request.getParameter("username"));
		//偏移量
		param.put("startIndex", page.getBeginIndex());
		//条数
		param.put("endIndex", page.getEveryPage());
		List<Payroll> payrollList = payrollService.pagePayrollListByParamMap(param);
		request.setAttribute("payrollList", payrollList);
		return "hrm/payrollListInfo";
	}
}
