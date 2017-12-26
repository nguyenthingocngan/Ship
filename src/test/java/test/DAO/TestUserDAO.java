/**
 * 
 */
package test.DAO;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ship.dao.OrderDAO;
import com.ship.dao.UserDAO;
import com.ship.dao.imp.UserImpl;
import com.ship.domain.User;

public class TestUserDAO {
	
	@Test
	public void testSelectUser() {
		ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
		UserDAO userDao = (UserDAO) context.getBean("userDAO");
		User user = userDao.getUserbyName("Sam");
		
		Assert.assertEquals("Sam", user.getUserName());
		System.out.println(user.getUserName());
		return;
	}
	


}
