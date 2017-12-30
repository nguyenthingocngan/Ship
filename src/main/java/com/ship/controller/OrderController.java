package com.ship.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ship.dao.OrderDAO;
import com.ship.domain.City;
import com.ship.domain.District;
import com.ship.domain.JsonResponse;
import com.ship.domain.Order;
import com.ship.domain.OrderStatus;
import com.ship.domain.User;
import com.ship.domain.Ward;


@Controller
public class OrderController extends AppController{

	
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public @ResponseBody String createOrder(@ModelAttribute(value = "order") Order order,
			BindingResult result, HttpServletRequest request) {
		HttpSession session = request.getSession();
		JsonResponse res = new JsonResponse();
		User user = (User) session.getAttribute("user");
		if(user != null){
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String shipFee = request.getParameter("shipFee");
			String productFee = request.getParameter("productFee");
			String total = request.getParameter("total");
			String note = request.getParameter("note");
			OrderDAO orderDAO = getOrderDAO();
			Order orderObj = new Order(0, "1", name, address, Double.parseDouble(total), Double.parseDouble(shipFee),
					Double.parseDouble(productFee), note, new Date(), user, new OrderStatus(), new City(),
					new District(), new Ward());
			orderDAO.insert(orderObj);
			res.setStatus("SUCCESS");
			res.setResult(orderObj);
		} else {
			return "Login";
		}
		
		try {
			return  new ObjectMapper().writeValueAsString(res);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}
	
/*	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String createOrder(HttpServletRequest request , Model model) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null){
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String shipFee = request.getParameter("shipFee");
			String productFee = request.getParameter("productFee");
			String total = request.getParameter("total");
			String note = request.getParameter("note");
			OrderDAO orderDAO = getOrderDAO();
			Order orderObj = new Order(0, "1", name, address, Double.parseDouble(total), Double.parseDouble(shipFee),
					Double.parseDouble(productFee), note, new Date(), user, new OrderStatus(), new City(),
					new District(), new Ward());
			orderDAO.insert(orderObj);
			model.addAttribute("orderObject" , orderObj);
			model.addAttribute("orderMessage", "Create Order successfully");
		} else {
			return "Login";
		}
		
		return returnHome(model);

	}*/
	/**
	 * process logout action and remove session
	 * @author Ngan Nguyen
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/gotoOder", method = RequestMethod.GET)
	public String goToOrder(HttpServletRequest request, Model model){
/*		if(ControllerUtil.isInSession(request, model)){
			return "CreateOrder";
		}*/
		return "CreateOrder";
	}
	
	public static void main(String[] args) {/*

		ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
		OrderDAO orderDAO = (OrderDAO) context.getBean("orderDAO");
		orderDAO.insert(new Order(0, "2", "Test1", "261 Tan Son", 200.0, 300.0,
				500.0, "", new Date(), new User(), new OrderStatus(), new City(),
				new District(), new Ward()));
	*/}
}
