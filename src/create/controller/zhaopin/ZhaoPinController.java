package create.controller.zhaopin;

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
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import system.util.JacobReplaceText;
import create.controller.core.BaseController;
import create.controller.core.page.Page;
import create.model.hrm.User;
import create.model.waipai.JianLi;
import create.service.hrm.UserService;
import create.service.waipai.JianliService;

@Controller
@RequestMapping("/zhaoPinController")
public class ZhaoPinController extends BaseController {
	
	protected final Logger logger = Logger.getLogger(this.getClass());


	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private JianliService jianliService;

	public JianliService getJianliService() {
		return jianliService;
	}

	@Autowired
	public void setJianliService(JianliService jianliService) {
		this.jianliService = jianliService;
	}

	@RequestMapping("/download")
	public ModelAndView download(HttpServletRequest request,
			HttpServletResponse response, String pId) throws Exception {
		JianLi jl = jianliService.selectByPrimaryKey(Integer.valueOf(pId));
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;

		String ctxPath = jl.getJianliPath();

		// java 0 .net 1 ios 2 安卓 3 web前端 4 php 5 其他 6
		String filename = "柯锐特&";
		if (jl.getJianliName().split("&") != null
				&& jl.getJianliName().split("&").length > 0) {
			filename += jl.getJianliName().split("&")[0];
		}
		if (jl.getJishuLx() == 0) {
			filename = filename + "&java";
		} else if (jl.getJishuLx() == 1) {
			filename = filename + "&.net";
		} else if (jl.getJishuLx() == 2) {
			filename = filename + "&ios";
		} else if (jl.getJishuLx() == 3) {
			filename = filename + "&安卓";
		} else if (jl.getJishuLx() == 4) {
			filename = filename + "&web前端";
		} else if (jl.getJishuLx() == 5) {
			filename = filename + "&php";
		} else {
			filename = filename + "&.其他";
		}

		// 暂无工作经验 0 培训无实际工作经验 1 一年以下 2 1-2年工作经验 3 2-3年工作经验 4 3-5年工作经验 5 6年以上 6
		if (jl.getGznx() == 0) {
			filename = filename + "&暂无工作经验";
		} else if (jl.getGznx() == 1) {
			filename = filename + "&培训无实际工作经验";
		} else if (jl.getGznx() == 2) {
			filename = filename + "&一年以下";
		} else if (jl.getGznx() == 3) {
			filename = filename + "&1-2年工作经验";
		} else if (jl.getGznx() == 4) {
			filename = filename + "&2-3年工作经验";
		} else if (jl.getGznx() == 5) {
			filename = filename + "&3-5年工作经验";
		} else {
			filename = filename + "&.6年以上";
		}
		filename = filename + ".doc";
		String downLoadPath = ctxPath + '/' + jl.getJianliName();
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

	@RequestMapping("/seeJianLi")
	public ModelAndView seeJianLi(HttpServletRequest request,
			HttpServletResponse response, String pId) throws Exception {
		JianLi jl = jianliService.selectByPrimaryKey(Integer.valueOf(pId));
		response.setContentType("text/html;charset=GBK");
		request.setCharacterEncoding("GBK");
		String ctxPath = jl.getJianliPath();
		// java 0 .net 1 ios 2 安卓 3 web前端 4 php 5 其他 6
		String filename = "柯锐特&";
		if (jl.getJianliName().split("&") != null
				&& jl.getJianliName().split("&").length > 0) {
			filename += jl.getJianliName().split("&")[0];
		}
		if (jl.getJishuLx() == 0) {
			filename = filename + "&java";
		} else if (jl.getJishuLx() == 1) {
			filename = filename + "&.net";
		} else if (jl.getJishuLx() == 2) {
			filename = filename + "&ios";
		} else if (jl.getJishuLx() == 3) {
			filename = filename + "&安卓";
		} else if (jl.getJishuLx() == 4) {
			filename = filename + "&web前端";
		} else if (jl.getJishuLx() == 5) {
			filename = filename + "&php";
		} else {
			filename = filename + "&.其他";
		}
		filename = filename + ".doc";
		String downLoadPath = ctxPath + '\\' + jl.getJianliName();

		JacobReplaceText jr = new JacobReplaceText();
		String newText = "******";
		// 建立名称规则 名字+邮箱地址(@之前的部分)+手机号+ QQ号+随机数
		// 替代建立中的联系方式
		if (jl.getJianliName() != null && jl.getJianliName() != "") {
			jr.wordFindReplaceAll(downLoadPath, jl.getJianliName(), newText,
					filename);
		}
		return null;
	}

	@RequestMapping("/toEditePage")
	public String toEditePage(HttpServletRequest request, String pId)
			throws Exception {
		JianLi jl = jianliService.selectByPrimaryKey(Integer.valueOf(pId));
		for (int i = 0; i < jl.getJianliName().split("&").length; i++) {

		}
		request.setAttribute("jl", jl);
		if (jl.getJianliName().split("&") != null
				&& jl.getJianliName().split("&").length > 0) {
			// 姓名
			request.setAttribute("xingming", jl.getJianliName().split("&")[0]);
			request.setAttribute("email", jl.getJianliName().split("&")[1]);
			request.setAttribute("mobile", jl.getJianliName().split("&")[2]);
			request.setAttribute("qq", jl.getJianliName().split("&")[3]);
		}
		return "mywork/xiugaiwaipaijianli";
	}

	@RequestMapping("/updateWaipaiJL")
	public ModelAndView updateWaipaiJL(
			@RequestParam(value = "file", required = false)
			MultipartFile file, HttpServletRequest request, JianLi jl)
			throws IOException {
		JianLi jianli = jianliService.selectByPrimaryKey(Integer.valueOf(jl
				.getpId()));

		Random random = new Random();
		// 取得当前上传文件的文件名称
		String myFileName = file.getOriginalFilename();
		// 上传的文件名字
		String fileName = "";
		// 定义上传路径
		String path = request.getSession().getServletContext().getRealPath(
				"jianli_download");// 上传的目录
		// 修改文件名
		File oldFile = new File(path + "//" + jianli.getJianliName());
		if (!oldFile.exists()) {
			oldFile.createNewFile();
		}
		// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
		if (myFileName.trim() != "") {
			// 重命名上传后的文件名,使用时间戳作为文件名称
			fileName = jl.getJianliName() + "&&" + System.currentTimeMillis()
					+ String.valueOf(random.nextInt(10000))
					+ myFileName.substring(myFileName.lastIndexOf("."));
			File targetFile = new File(path, fileName);
			// if (!targetFile.exists()) {
			// targetFile.mkdirs();
			// }
			try {
				file.transferTo(targetFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 删除原来文件
			if (oldFile.exists()) {
				oldFile.delete();
			}
		} else {
			// 重命名上传后的文件名,使用时间戳作为文件名称
			fileName = jl.getJianliName()
					+ "&&"
					+ System.currentTimeMillis()
					+ String.valueOf(random.nextInt(10000))
					+ jianli.getJianliName().substring(
							jianli.getJianliName().lastIndexOf("."));

			System.out.println("修改前文件名称是：" + oldFile.getName());
			String rootPath = oldFile.getParent();
			System.out.println("根路径是：" + rootPath);
			File newFile = new File(rootPath + File.separator + fileName);
			System.out.println("修改后文件名称是：" + newFile.getName());
			if (oldFile.renameTo(newFile)) {
				System.out.println("修改成功!");
			} else {
				System.out.println("修改失败");
			}
		}
		// 简历存放路径
		jianli.setJianliPath(path);
		jianli.setJianliName(fileName);
		jianliService.updateJianLi(jianli);
		return new ModelAndView(
				"redirect:/zhaoPinController/waipaijianliList.go");
	}

	@RequestMapping("/saveWaipaiJL")
	public ModelAndView saveWaipaiJL(
			@RequestParam(value = "file", required = false)
			MultipartFile file, HttpServletRequest request, JianLi jl) {
		ModelAndView mav = null;
		Random random = new Random();
		// 取得当前上传文件的文件名称
		String myFileName = jl.getJianliName();
		//判断权限获取角色权限
		HttpSession sessionMap = request.getSession(true);
		User user = (User)sessionMap.getAttribute("user");
		
		Map paramMap = new HashMap();
		paramMap.put("jianliName", myFileName);
		List<JianLi> jianliList = jianliService.pageListByParamMap(paramMap);
		if (jianliList == null || jianliList.size() == 0) {
			// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
			if (myFileName.trim() != "") {
				// 上传的文件名字
				String fileName = file.getOriginalFilename();
				// 定义上传路径
				String path = request.getSession().getServletContext()
						.getRealPath("jianli_download");// 上传的目录
//				myFileName.substring(myFileName.lastIndexOf("."));
				// 重命名上传后的文件名,使用时间戳作为文件名称
				fileName = jl.getJianliName() + "&&"
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
				// 简历存放路径
				jl.setJianliPath(path);
				jl.setJianliName(fileName);
				jl.setCreateTime(new Date());
				jl.setCreateBy(user.getId());
				
				jianliService.insertJianLi(jl);
			}
		} else {
			jl = jianliList.get(0);
		}

		// 更新简历user的简历id
		if (request.getParameter("userid") != null&&!"".equals(request.getParameter("userid"))) {
			 user = new User();
			user.setSalt(String.valueOf(jl.getpId()));
			user.setId(Integer.valueOf(request.getParameter("userid")));
			userService.upDateUser(user);
			mav = new ModelAndView(
			"redirect:/userController/showUsers.go?type=1");
		} else {
			mav = new ModelAndView(
			"redirect:/zhaoPinController/waipaijianliList.go");
		}

		return mav;
	}

	@RequestMapping("/waipaijianliList")
	public String waipaijianliList(JianLi jl, HttpServletRequest request) {
		try {
			HttpSession sessionMap = request.getSession(true);
			User user = (User)sessionMap.getAttribute("user");
			Map<String, Object> params = new HashMap<String, Object>();
			String pageNow = request.getParameter("pageNow");
			List<JianLi> jianLis = null;
			// 查询条件
			params.put("jianliName", jl.getJianliName());
			params.put("jishuLx", jl.getJishuLx());
			params.put("gznx", jl.getGznx());
			// 获取总条数
			Long totalCount = this.jianliService.pageCounts(params);
			// 设置分页对象
			Page page = executePage(request, totalCount);
			Map paramMap = new HashMap();
			paramMap.put("departid", 3);
			List<User> users = userService.pageListByParamMap(paramMap);
			request.setAttribute("users", users);
			// 设置分页页面信息
			params.put("startIndex", page.getBeginIndex());
			params.put("endIndex", page.getEndinIndex());
			// 如排序
			if (page.isSort()) {
				params.put("orderName", page.getSortName());
				params.put("descAsc", page.getSortState());
			} else {
				// 没有进行排序,默认排序方式
				params.put("orderName", "age");
				params.put("descAsc", "asc");
			}
			if(jl!=null&&jl.getCreateBy()!=null){
				params.put("createBy", jl.getCreateBy());
			}else{
				params.put("createBy", user.getId());
			}
			jianLis = jianliService.pageListByParamMap(params);
			request.setAttribute("jianLis", jianLis);
			request.setAttribute("page", page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "mywork/waipaijianliList";
	}

	@RequestMapping("/zengjiajianliInfo")
	public String zengjiajianliInfo(HttpServletRequest request, String userid) {
		try {
			if(userid!=null){
				request.setAttribute("userInfo", userService.getUserById(Integer
						.valueOf(userid)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "mywork/zengjiawaipaijianli";
	}

}
