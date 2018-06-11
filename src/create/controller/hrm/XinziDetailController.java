package create.controller.hrm;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import create.service.hrm.XinziService;

@Controller
@RequestMapping("/xinziDetailController")
public class XinziDetailController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	XinziService xinziService;

	public XinziService getXinziService() {
		return xinziService;
	}

	public void setXinziService(XinziService xinziService) {
		this.xinziService = xinziService;
	}

}
