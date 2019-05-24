package com.briup.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.common.exception.CustomerServiceException;
import com.briup.dao.impl.CustomerDaoImpl;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {       
    public RegisterServlet() {
        super();
    }
    private ICustomerService service = new CustomerServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userid");
		String password = request.getParameter("password");
		String address =  request.getParameter("street1");
		String zip = request.getParameter("zip");
		String cellphone = request.getParameter("cellphone");
		String email = request.getParameter("email");
		Customer customer = new Customer(name, password, zip, address, cellphone, email);
		try {
			service.register(customer);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (CustomerServiceException e) {
			e.printStackTrace();
			request.setAttribute("exceptionMsg", e.getMessage());
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
