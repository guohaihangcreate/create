/**
 * 
 */
package create.controller.crm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import create.model.crm.ContactInfro;
import create.model.crm.CustomerBankInfro;
import create.model.crm.CustomerInfo;
import create.service.crm.ContactInfroService;
import create.service.crm.CustomerBankInfroService;
import create.service.crm.CustomerInfoService;

/**
 * @author guohaihang
 * 
 */
@Controller
@RequestMapping("/customerBankInfroController")
public class CustomerBankInfroController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 
	 */
	public CustomerBankInfroController() {
		// TODO Auto-generated constructor stub
	}


	private ContactInfroService contactInfroService;

	public ContactInfroService getContactInfroService() {
		return contactInfroService;
	}

	@Autowired
	public void setContactInfroService(ContactInfroService contactInfroService) {
		this.contactInfroService = contactInfroService;
	}
	private CustomerBankInfroService customerBankInfroService;

	public CustomerBankInfroService getCustomerBankInfroService() {
		return customerBankInfroService;
	}

	@Autowired
	public void setCustomerBankInfroService(
			CustomerBankInfroService customerBankInfroService) {
		this.customerBankInfroService = customerBankInfroService;
	}

	private CustomerInfoService customerInfoService;

	public CustomerInfoService getCustomerInfoService() {
		return customerInfoService;
	}

	@Autowired
	public void setCustomerInfoService(CustomerInfoService customerInfoService) {
		this.customerInfoService = customerInfoService;
	}

	@RequestMapping("/insertCustomerBankInfro")
	public ModelAndView insertCustomerBankInfro(
			CustomerBankInfro customerBankInfro, HttpServletRequest request,
			String type) {
		ModelAndView modelAndView = null;
		try {
			customerBankInfroService
					.insertCustomerBankInfroSelective(customerBankInfro);
			CustomerInfo customerInfo = customerInfoService
					.selectByPrimaryKey(customerBankInfro.getCustomerid());
			// 客户开户行信息
			request.setAttribute("customerBankInfro", customerBankInfro);
			// 保存客户的联系信息
			request.setAttribute("customerInfo", customerInfo);
			if (type != null && "0".equals(type)) {
				modelAndView = new ModelAndView("crm/customerInfoInsert");
			} else {
				modelAndView = new ModelAndView(
						"redirect:/customerBankInfroController/customerBankInfoList.go?customerid="
								+ customerBankInfro.getCustomerid());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/editeOrInsertCustomerBankInfro")
	public ModelAndView editeOrInsertCustomerBankInfro(
			CustomerBankInfro customerBankInfro, HttpServletRequest request,
			String type) {
		ModelAndView modelAndView = null;
		try {
			if (type != null && "0".equals(type)) {
				customerBankInfroService
						.insertCustomerBankInfroSelective(customerBankInfro);
			}
			if (type != null && "1".equals(type)) {
				customerBankInfroService
						.updateCustomerBankInfroByPrimaryKeySelective(customerBankInfro);
			}
//			刪除
			if (type != null && "2".equals(type)) {
				customerBankInfroService
						.deleteCustomerById(customerBankInfro.getId());
			}
			CustomerInfo customerInfo = customerInfoService
					.selectByPrimaryKey(customerBankInfro.getCustomerid());
			String contactInfro_id = request.getParameter("contactInfro_id");
			if(contactInfro_id!=null&&!"".equals(contactInfro_id)){
				ContactInfro contactInfro = contactInfroService.selectByPrimaryKey(Integer.valueOf(contactInfro_id));
				request.setAttribute("contactInfro", contactInfro);
			}
			request.setAttribute("customerInfo", customerInfo);
			request.setAttribute("customerBankInfro", customerBankInfro);
			modelAndView = new ModelAndView(
					"redirect:/customerBankInfroController/customerBankInfoList.go?customerid="
							+ customerBankInfro.getCustomerid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/toEditeCustomerBankInfro")
	public String toEditeCustomerBankInfro(String bankid,
			HttpServletRequest request) {
		ModelAndView modelAndView = null;
		try {
			CustomerBankInfro customerBankInfro = customerBankInfroService
					.selectByPrimaryKey(Integer.valueOf(bankid));
			// 客户开户行信息0为新增，1为修改
			request.setAttribute("type", request.getParameter("type"));
			request.setAttribute("customerBankInfro", customerBankInfro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "crm/customerBankInfoInsert_edite";
	}

	@RequestMapping("/customerBankInfoList")
	public String customerBankInfoList(CustomerBankInfro customerBankInfro,
			HttpServletRequest request, String customerid) {
		try {
			customerBankInfro.setCustomerid(Integer.valueOf(customerid));
			List<CustomerBankInfro> customerBankInfroList = customerBankInfroService
					.searchCustomerBankByProperty(customerBankInfro);
			request
					.setAttribute("customerBankInfroList",
							customerBankInfroList);
			// 保存客户的联系信息
			request.setAttribute("customerid", customerid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "crm/customerBankInfoList";
	}

}
