package create.controller.sys;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;
import create.model.hrm.Depart;
import create.model.system.CompanyInfo;
import create.service.hrm.CompanyInfoService;

@Controller
@RequestMapping("/companyController")
public class CompanyController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	private CompanyInfoService companyInfoService;
	
	List<CompanyInfo> companyInfos = null;
	
	
	@RequestMapping("/showCompanys")
	public String showCompanys(CompanyInfo company,HttpServletRequest request){
		companyInfos = companyInfoService.selectCompanyByPropterty(company);
		request.setAttribute("companyList", companyInfos);
		return "hrm/companyInfoList";
	}
	
	@RequestMapping("/addCompany")
	public ModelAndView addCompany(CompanyInfo company,HttpServletRequest request) {
		try {
			companyInfoService.insertSelective(company);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/deptController/showdeparts.go");
	}
	
	@RequestMapping("/editeCompany")
	public String editeCompany(CompanyInfo company, HttpServletRequest request) {
		try {
			companyInfoService.updateByPrimaryKeySelective(company);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hrm/dept_list";
	}
	
	@RequestMapping("/deleteCompany")
	public String deleteDept(Depart dept, HttpServletRequest request) {
		try {
			companyInfoService.deleteByPrimaryKey(dept.getDeptId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hrm/dept_list";
	}
	
	@RequestMapping("/queryCompanyList")
	public String queryCompanyList(CompanyInfo company,HttpServletRequest request) {
		try {
			companyInfos = companyInfoService.selectCompanyByPropterty(company);
			request.setAttribute("companyInfos", companyInfos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hrm/companyInfoList";
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}
	@Autowired
	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	
	
	


}
