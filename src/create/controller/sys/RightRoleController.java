package create.controller.sys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import system.util.StringUtils;
import create.model.hrm.Treenodes;
import create.service.system.TreeNodeService;

@Controller
@RequestMapping("/sysRightRoleController")
public class RightRoleController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping("/queryList")
	public String queryList() {
		return "system/querySysRightRoleList";
	}

	@RequestMapping("/toAddRightRoleInfoPage")
	public String toAddRightRoleInfoPage() {
		return "system/addRightRoleInfo";
	}

}
