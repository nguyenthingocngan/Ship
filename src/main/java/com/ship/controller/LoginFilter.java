package com.ship.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

import com.ship.dao.OrderDAO;
import com.ship.dao.UserDAO;
import com.ship.domain.User;

public class LoginFilter implements Filter {
	//private static final ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

	private ServletContext context;
	FilterConfig fConfig;
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
		this.context = fConfig.getServletContext();
		this.context.log("RequestLoggingFilter initialized");
	}
	/*
	 * public static ApplicationContext getApplicationContext() { return
	 * context; }
	 * 
	 * public static OrderDAO getOrderDAO(){ return (OrderDAO)
	 * getApplicationContext().getBean("orderDAO"); }
	 * 
	 * public static UserDAO getUserDAO(){ return (UserDAO)
	 * getApplicationContext().getBean("userDAO"); }
	 * 
	 * public static boolean isInSession(HttpServletRequest request, Model
	 * model){ HttpSession session = request.getSession(); User user = (User)
	 * session.getAttribute("user"); if(user != null){ User userDB =
	 * getUserDAO().getUserbyName(user.getUserName()); return
	 * user.equal(userDB); } return false; }
	 */

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		String uri = req.getRequestURI();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		if ("/Ship/doLogin.html".equals(uri)) {
			chain.doFilter(request, response);
			
			return;
		} else if (session != null) {
			User user = (User) session.getAttribute("user");
			if (user != null) {
				chain.doFilter(request, response);
			} else {
				/*
				 * this.context.log("nnguyen79 initialized " + res.toString());
				 * res.sendRedirect("../Login.html");
				 */
				String contextPath = req.getContextPath();
				// res.sendRedirect(res.encodeRedirectURL(contextPath +
				// "/Login.html"));
				RequestDispatcher rd = req.getRequestDispatcher("/login.html");
				rd.forward(request, response);
				response.setContentType("text/html;charset=UTF-8");
				request.setCharacterEncoding("utf-8");
				return;

			}
		} else {

			// res.sendRedirect(res.encodeRedirectURL(contextPath +
			// "/Login.html"));
			RequestDispatcher rd = req.getRequestDispatcher("/login.html");
			rd.forward(request, response);
			return;
		}

	}
	public void destroy(){
		//we can close resources here
	}

}
