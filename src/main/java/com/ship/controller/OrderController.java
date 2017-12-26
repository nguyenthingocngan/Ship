package com.ship.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ship.dao.OrderDAO;
import com.ship.domain.City;
import com.ship.domain.District;
import com.ship.domain.Order;
import com.ship.domain.OrderStatus;
import com.ship.domain.User;
import com.ship.domain.Ward;

@Controller
public class OrderController extends AppController{

	@ResponseBody
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String createOrder(HttpServletRequest request, Model model) {
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
			orderDAO.insert(new Order(0, "1", name, address, Double.parseDouble(total), Double.parseDouble(shipFee),
					Double.parseDouble(productFee), note, new Date(), user, new OrderStatus(), new City(),
					new District(), new Ward()));
			returnHome(model);
		} else {
			return "Login";
		}
		
		return "Login";

	}
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
	
	public static void main(String[] args) {

		ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
		OrderDAO orderDAO = (OrderDAO) context.getBean("orderDAO");
		orderDAO.insert(new Order(0, "2", "Test1", "261 Tan Son", 200.0, 300.0,
				500.0, "", new Date(), new User(), new OrderStatus(), new City(),
				new District(), new Ward()));
	}
}
