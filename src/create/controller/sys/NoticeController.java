package create.controller.sys;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import system.convert.ConvertWordToHtml;
import create.model.hrm.SysNotice;
import create.model.hrm.User;
import create.model.waipai.InterviewInvitation;
import create.model.waipai.JianLi;
import create.service.hrm.NoticeService;
@Controller
@RequestMapping("/noticeController")
public class NoticeController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	private NoticeService noticeService;
	
	// pId 简历id 简历库页面的电话邀请按钮处理方法
	@RequestMapping("/seeNotice")
	public void seeNotice(HttpServletRequest request, String pId)
			throws Exception {
		SysNotice sNotice = null;
		Random random = new Random();
		if(pId!=null&&!"".equals(pId)){
			sNotice = noticeService.selectByPrimaryKey(Integer.valueOf(pId));
		}
		String inPath = sNotice.getNoticefilepath()+ '/';
		
		String inFileName = sNotice.getYl1();
		String randomHtmlJL_name = System.currentTimeMillis()
		+ String.valueOf(random.nextInt(10000)) + ".html";
//		poi word转换成html
		String outPath = request.getSession().getServletContext()
		.getRealPath("/") + '\\' + "notice_html" + '\\';
		String outFileName = randomHtmlJL_name;
		ConvertWordToHtml.cwth(inPath,inFileName,outPath,outFileName);
//		request.setAttribute("showNotice", randomHtmlJL_name.split(".html")[0]);
		request.setAttribute("showNotice", "notice_html"+'\\'+outFileName);
	}
	
	@RequestMapping("/saveSysNotice")
	public ModelAndView saveSysNotice(
			@RequestParam(value = "file", required = false)
			MultipartFile file, HttpServletRequest request, SysNotice notice) {
		Random random = new Random();
		// 取得当前上传文件的文件名称
		String myFileName = notice.getNoticename();
		//判断权限获取角色权限
		HttpSession sessionMap = request.getSession(true);
		User user = (User)sessionMap.getAttribute("user");
		Map paramMap = new HashMap();
		if (notice == null || !"".equals(myFileName)) {
			// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
			if (myFileName.trim() != "") {
				// 上传的文件名字
				String fileName = file.getOriginalFilename();
				// 定义上传路径
				String path = request.getSession().getServletContext()
						.getRealPath("notice_download")+"\\";// 上传的目录
				// 重命名上传后的文件名,使用时间戳作为文件名称
				fileName = notice.getNoticename() + "&&"
						+ System.currentTimeMillis()
						+ String.valueOf(random.nextInt(10000))+fileName;
//						+ myFileName.substring(myFileName.lastIndexOf("."));
				File targetFile = new File(path, fileName);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				try {
					file.transferTo(targetFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				notice.setReleasedate(new Date());
				notice.setNoticefilepath(path);
				//文件名称
				notice.setYl1(fileName);
				notice.setYl2(file.getOriginalFilename());
				notice.setYl3("0");
				noticeService.insertSelective(notice);
			}
		} 
		return new ModelAndView(
		"redirect:/noticeController/queryNotice.go");
	}
	
	@RequestMapping("/updataNotice")
	public ModelAndView updataNotice(HttpServletRequest request) throws Exception {
		String noticeid = request.getParameter("Noticeid");
		SysNotice sysNotice = null;
		if(noticeid!=null&&!"".equals(noticeid)){
			sysNotice = noticeService.selectByPrimaryKey(Integer.valueOf(noticeid));
			//1表示放在公告首页
			sysNotice.setYl3("1");
		}
		noticeService.updateByPrimaryKeySelective(sysNotice);
		
		List<SysNotice> notics= noticeService.querySysNoticeList(null);
		for(SysNotice s:notics){
			if(noticeid!=null&&!"".equals(noticeid)){
				if(s.getId()!=sysNotice.getId()){
					//0表示不放在公告首页
					s.setYl3("0");
					noticeService.updateByPrimaryKeySelective(s);
				}
			}
		}
		return new ModelAndView(
		"redirect:/noticeController/queryNotice.go");
	}
	
	@RequestMapping("/deleteNotice")
	public ModelAndView deleteNotice(HttpServletRequest request) throws Exception {
		String noticeid = request.getParameter("Noticeid");
		SysNotice sysNotice = null;
		if(noticeid!=null&&!"".equals(noticeid)){
			noticeService.deleteByPrimaryKey(Integer.valueOf(noticeid));
		}
		return new ModelAndView(
		"redirect:/noticeController/queryNotice.go");
	}
//	下载
	@RequestMapping("/download")
	public ModelAndView download(HttpServletRequest request,
			HttpServletResponse response, String Noticeid) throws Exception {
		SysNotice s = noticeService.selectByPrimaryKey(Integer.valueOf(Noticeid));
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;
		String filename = s.getYl2();
		String ctxPath = s.getNoticefilepath();
		String downLoadPath = ctxPath + s.getYl1();
		try {
			long fileLength = new File(downLoadPath).length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(filename.getBytes("utf-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;
	}
	
	@RequestMapping("/queryNotice")
	public String queryNotice(HttpServletRequest request, SysNotice notice) throws Exception {
		Map map = new HashMap();
		map.put("yl3", "1");
		List<SysNotice> notices= noticeService.querySysNoticeList(map);
		List<SysNotice> notics= noticeService.querySysNoticeList(null);
		request.setAttribute("notices", notics);
		String noticeid = request.getParameter("Noticeid");
		if(noticeid!=null&&!"".equals(noticeid)){
			this.seeNotice(request,noticeid);
		}else{
			if(notices!=null&&notices.size()>0){
				this.seeNotice(request,notices.get(0).getId().toString());
			}else{
				if(notices!=null&&notices.size()>0){
					this.seeNotice(request,notics.get(0).getId().toString());
				}
			}
		}
		
		return "sys/welcome";
	}

	public NoticeService getNoticeService() {
		return noticeService;
	}
	@Autowired
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}


}
