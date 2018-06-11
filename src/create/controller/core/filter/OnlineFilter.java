package create.controller.core.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import create.model.hrm.User;
import create.service.hrm.UserService;

public class OnlineFilter extends HttpServlet implements Filter {
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 这里设置如果没有登陆将要转发到的页面
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/login_b/login.jsp");// 这里设置如果没有登陆将要转发到的页面
		HttpServletRequest req = (HttpServletRequest) request;
		String address = req.getRemoteAddr();
		HttpServletResponse res = (HttpServletResponse) response;
		ServletContext applicationMap = req.getSession().getServletContext();
		HttpSession session = req.getSession(true);
		String requestPath = req.getServletPath();
		User loanUser = (User) session.getAttribute("user");
		String currentSeesionId = session.getId();
		String loginAdress = (String) applicationMap
				.getAttribute("loginAdress");
		// 登陆页面无需过滤
		if (requestPath.indexOf("/login.go") > -1
				|| requestPath.indexOf("/list.go") > -1) {
			chain.doFilter(request, response);
			return;
		} else {
			if (loanUser == null) {
				toLertMessageToPage(res, "已经在IP：" + loginAdress
						+ " 处登录,本次登录将被强制退出！", req);
			} else {
				// 从session里取的用户名信息
				String userSessionId = (String) applicationMap
						.getAttribute(loanUser.getLoginid());
				if (userSessionId != null
						&& !currentSeesionId.equals(userSessionId)) {
					// 强制下线已经登录的账户
					applicationMap.removeAttribute(userSessionId);
					chain.doFilter(request, response);
					toLertMessage(res, "此用户已经在IP：" + loginAdress
							+ " 登录,确定登录将会使已经登录的账户强制退出！", req);
					return;
				}
				String username = (String) applicationMap
						.getAttribute(userSessionId);// 这里获取session，为了检查session里有没有保存用户信息，没有的话回转发到登陆页面
				// 判断如果没有取到用户信息,就跳转到登陆页面
				if (username == null || "".equals(username)) {
					// 跳转到登陆页面
					toLertMessageToPage(res, "没有用户登录信息,请重新登录！", req);
					return;
				} else {
					chain.doFilter(request, response);
				}
			}

		}
	}

	public void toLertMessageToPage(HttpServletResponse response,
			String message, HttpServletRequest request) {
		response.setContentType("text/html");
		PrintWriter out;
		try {
			response.setCharacterEncoding("utf-8");
			response.setHeader("Cache-Control", "no-store");
			response.setDateHeader("Expires", 0);
			response.setHeader("Pragma", "no-cache");
			out = response.getWriter();
			out.println(" <script type='text/javascript'> alert('" + message
					+ "')");
			out.println("window.parent.parent.location=http://127.0.0.1:8090/create");
			out.println("</script>");
			out.println("</HTML>");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void toLertMessage(HttpServletResponse response, String message,
			HttpServletRequest request) {
		response.setContentType("text/html");
		PrintWriter out;
		try {
			response.setCharacterEncoding("utf-8");
			response.setHeader("Cache-Control", "no-store");
			response.setDateHeader("Expires", 0);
			response.setHeader("Pragma", "no-cache");
			out = response.getWriter();
			out.println(" <script type='text/javascript'>alert('" + message
					+ "')");
			out.println("</script>");
			out.println("</HTML>");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroy() {
		// System.out.println("测试销毁信息");
	}
}
