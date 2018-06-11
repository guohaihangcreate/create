/**
 * 
 */
package create.controller.crm;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.util.UtilCommon;
import create.model.crm.ContactInfro;
import create.model.crm.CustomerInfo;
import create.service.crm.ContactInfroService;
import create.service.crm.CustomerInfoService;

/**
 * @author guohaihang
 * 
 */
@Controller
@RequestMapping("/contactInfroController")
public class ContactInfroController {

	protected final Logger logger = Logger.getLogger(this.getClass());

	private ContactInfroService contactInfroService;

	public ContactInfroService getContactInfroService() {
		return contactInfroService;
	}

	@Autowired
	public void setContactInfroService(ContactInfroService contactInfroService) {
		this.contactInfroService = contactInfroService;
	}

	private CustomerInfoService customerInfoService;

	public CustomerInfoService getCustomerInfoService() {
		return customerInfoService;
	}

	@Autowired
	public void setCustomerInfoService(CustomerInfoService customerInfoService) {
		this.customerInfoService = customerInfoService;
	}

	@RequestMapping("/insertContactInfro")
	public ModelAndView insertContactInfro(ContactInfro contactInfro,
			HttpServletRequest request, String type) {
		String return_type = request.getParameter("return_type");
		ModelAndView  mv = null;
		try {
			CustomerInfo customerInfo = null;
			// 新增 0是新增，1是修改
			if (type != null && "0".equals(type)) {
				Date createtime = new Date();
				if (contactInfro.getShengri() != null&&!"".equals(contactInfro.getShengri())) {
					Date shengri = UtilCommon.StringToDate(contactInfro
							.getShengri(), "yyyy-MM-dd");
					contactInfro.setBrithday(shengri);
				}
				// 正常状态
				contactInfro.setAtt1("0");
				contactInfro.setCreatetime(createtime);

				contactInfroService.insertContactInfroSelective(contactInfro);
				customerInfo = customerInfoService
						.selectByPrimaryKey(contactInfro.getCustomerid());
				request.setAttribute("contactInfro", contactInfro);
				request.setAttribute("type", type);
				// 保存客户的联系信息
				request.setAttribute("customerInfo", customerInfo);
				
			} else {
				// 修改
				Date lastmodifytime = new Date();
				if (contactInfro.getShengri() != null&&!"".equals(contactInfro.getShengri())) {
					Date shengri = UtilCommon.StringToDate(contactInfro
							.getShengri(), "yyyy-MM-dd");
					contactInfro.setBrithday(shengri);
				}
				contactInfro.setLastmodifytime(lastmodifytime);
				contactInfroService
						.updateCustomerInfoByPrimaryKeySelective(contactInfro);
				customerInfo = customerInfoService
						.selectByPrimaryKey(contactInfro.getCustomerid());
				request.setAttribute("contactInfro", contactInfro);
				request.setAttribute("type", type);
				// 保存客户的联系信息
				request.setAttribute("customerInfo", customerInfo);
				
			}
			
			if("0".equals(return_type)){
				mv = new ModelAndView(
						"redirect:/contactInfroController/contactInfoList.go?customerid="
						+ contactInfro.getCustomerid());
			}else{
				mv = new ModelAndView(
				"redirect:/customerInfoController/insertContactInfro.go");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/toEditecontactInfo")
	public String toEditecontactInfo(HttpServletRequest request, String id) {
		if ("1".equals(request.getParameter("type"))) {
			request.setAttribute("contactInfro", contactInfroService
					.selectByPrimaryKey(Integer.valueOf(id)));
		}
		request.setAttribute("type", request.getParameter("type"));
		return "crm/contactInfoInsert_edite";
	}

	@RequestMapping("/editecontactInfo")
	public ModelAndView editecontactInfo(ContactInfro contactInfro,
			HttpServletRequest request) {
		try {
			// type=2表示删除
			if ("2".equals(request.getParameter("type"))) {
				// 0表示正常，1表示已经删除
				contactInfro.setAtt1("1");
				String contractid = (String) request.getParameter("id");
				String customerid = (String) request.getParameter("customerid");
				contactInfro.setCustomerid(Integer.valueOf(customerid));
				contactInfro.setId(Integer.valueOf(contractid));
			}
			contactInfroService
					.updateCustomerInfoByPrimaryKeySelective(contactInfro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView(
				"redirect:/contactInfroController/contactInfoList.go?customerid="
						+ contactInfro.getCustomerid());
	}

	@RequestMapping("/contactInfoList")
	public String contactInfoList(ContactInfro contactInfro,
			HttpServletRequest request, String customerid) {
		try {
			contactInfro.setCustomerid(Integer.valueOf(customerid));
			List<ContactInfro> contactInfroList = contactInfroService
					.searchCustomerByProperty(contactInfro);
			// 保存客户的联系信息
			request.setAttribute("customerid", customerid);
			request.setAttribute("contactInfroList", contactInfroList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "crm/contactInfoList";
	}

	@RequestMapping("/ajaxContactLit")
	@ResponseBody
	public void ajaxContactLit(HttpServletRequest request,
			HttpServletResponse response, ContactInfro contactInfro,
			String customerid) {
		String str = "";
		try {
			contactInfro.setCustomerid(Integer.valueOf(customerid));
			List<ContactInfro> contactInfroList = contactInfroService
					.searchCustomerByProperty(contactInfro);
			// 保存客户的联系信息
			if (contactInfroList != null && contactInfroList.size() > 0) {
				for (ContactInfro contact : contactInfroList) {
					str += "id:" + contact.getId() + ",name:"
							+ contact.getContactsname() + ";";
				}
			}else{
				str = "";
			}

			if (str != null && !"".equals(str)) {
				UtilCommon.reponse(request, response, str.substring(0, str
						.lastIndexOf(";")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
