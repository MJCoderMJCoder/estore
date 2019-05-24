package com.briup.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.common.exception.CustomerServiceException;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  
    private ICustomerService service = new CustomerServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userid");
		String password = request.getParameter("password");
		try{
			service.login(name, password);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch (CustomerServiceException e) {
			e.printStackTrace();
			request.setAttribute("exceptionMsg", e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
