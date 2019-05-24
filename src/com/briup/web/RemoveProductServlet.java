package com.briup.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.ShoppingCart;


@WebServlet("/removeProduct")
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public RemoveProductServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long bookid=Long.parseLong(request.getParameter("bookid"));
		ShoppingCart cart=(ShoppingCart) request.getSession().getAttribute("cart");
		cart.dropLine(bookid);
		request.getSession().setAttribute("cart", cart);
		request.getRequestDispatcher("shopcart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
