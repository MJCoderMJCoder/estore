package com.briup.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.ShoppingCart;

@WebServlet(name = "updateProduct", urlPatterns = { "/updateProduct" })
public class UpdatrProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdatrProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long bookid=Long.parseLong(request.getParameter("bookid"));
		long num=Long.parseLong(request.getParameter("num"));
		ShoppingCart cart=(ShoppingCart) request.getSession().getAttribute("cart");
		cart.getOrderline(bookid).setNum(num);
		request.getRequestDispatcher("shopcart.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
