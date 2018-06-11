package create.controller.hrm;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import system.util.StringUtils;
import system.util.StringUtils_;
import system.util.UtilCommon;

import create.model.hrm.Function;
import create.service.hrm.SysFunService;

@Controller
@RequestMapping("/sysfunController")
public class SysfunController {

	protected final Logger logger = Logger.getLogger(this.getClass());
	

	private SysFunService sysfunService;


	List<Function> treeList = null;

	
	@RequestMapping(value="/showMenues")
	@ResponseBody
	public void showMenues(HttpServletRequest request, HttpServletResponse response,String id, String funname) {
		String pId = request.getParameter("id");
		String pName =  StringUtils_.chineseStrUTF8(request.getParameter("n"));	
		String str = null;		
		if (pId == null) {			
			pId = "0";	
		} 		
		str = UtilCommon.getChild(pId);	
		try {
			reponse(request, response, str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			reponse(request, response, str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	@RequestMapping(value="/editMenues")
	@ResponseBody
	public void editMenues(HttpServletRequest request, HttpServletResponse response,String id, String funname) {
		String str = "[{\"id\":\"" + 96 + "\",\"name\":\"" + "ϵͳ��๦�ܲ˵�"
		+ "\",\"isParent\":" + false+ "}]";
		try {
			reponse(request, response, str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reponse(HttpServletRequest request,
			HttpServletResponse response, Object msg) throws Exception {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(msg.toString());
		out.flush();
		out.close();
	}

	@RequestMapping("/addMenue")
	public String addMenue(@RequestParam("icons") MultipartFile file,HttpServletRequest request,Function fun)  {
		try {
			sysfunService.insertFun(fun);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hrm/menuesEdite";
	}

	public SysFunService getSysfunService() {
		return sysfunService;
	}

	@Autowired
	public void setSysfunService(SysFunService sysfunService) {
		this.sysfunService = sysfunService;
	}

}
