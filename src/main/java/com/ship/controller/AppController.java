package com.ship.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ship.dao.OrderDAO;
import com.ship.dao.UserDAO;
import com.ship.dao.imp.Utils;
import com.ship.domain.Order;
import com.ship.domain.User;

public class AppController {
	
	private final ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

	public ApplicationContext getApplicationContext() {
		return context;
	}
	
	public OrderDAO getOrderDAO(){
		return (OrderDAO) getApplicationContext().getBean("orderDAO");
	}
	
	public UserDAO getUserDAO(){
		return (UserDAO) getApplicationContext().getBean("userDAO");
	}
		
		
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest request, Model model){
		String userName = request.getParameter("txtUserName");
		String passWord = request.getParameter("txtPassword");
		
		UserDAO userDAO = getUserDAO();
		User user = userDAO.getUserbyName(userName);
		if(user!= null){
			if(user.getUserName().equals(userName) && user.getPassWord().equals(passWord)) {
				HttpSession session = request.getSession() ;				
				session.setAttribute("user", user);
				session.setAttribute("role", user.getRole());
				return returnHome(model);
			}
			
			else{
				model.addAttribute("loginMessage", "Wrong Username or Password!");
				return "Login";
			}
		}
		else{
			model.addAttribute("loginMessage", "Wrong Username or Password!");
			return "Login";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(HttpServletRequest request, Model model){
			return "Login";
	}
	
	/**
	 * process logout action and remove session
	 * @author Ngan Nguyen
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String processLogout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("role");
		return "Login";
	}
	
	/**
	 * redirect to home page with user information
	 * @author Ngan Nguyen
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String returnHome(Model model) {
		OrderDAO orderDAO = getOrderDAO();
		//select within a day
		Date date = new Date(System.currentTimeMillis());
		List<Order> orderList = orderDAO.getOrder(null, null);
		model.addAttribute("orderList", orderList);
		return ("Home");
	}
	
	
	

}
