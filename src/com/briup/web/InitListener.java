package com.briup.web;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import com.briup.bean.Book;
import com.briup.bean.ShoppingCart;
import com.briup.common.exception.OrderServiceException;
import com.briup.service.IOrderService;
import com.briup.service.impl.OrderServiceImpl;

@WebListener
public class InitListener implements ServletContextListener,
		HttpSessionListener {
	private IOrderService service = new OrderServiceImpl();
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Map<Long,Book> map = service.listAllBook();
			ServletContext context = sce.getServletContext();
			context.setAttribute("books", map);
			System.out.println(map.toString());
			System.out.println("查询所有的书籍，并存放在servletContext中");
		} catch (OrderServiceException e) {
			e.printStackTrace();
		}
	}
		
	public void sessionCreated(HttpSessionEvent sce) {
		ShoppingCart cart = new ShoppingCart();
	
		HttpSession session = sce.getSession();
		session.setAttribute("cart", cart);
		System.out.println("将购物车对象存放到session中");
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

	public void contextDestroyed(ServletContextEvent se) {
	
	}

}
