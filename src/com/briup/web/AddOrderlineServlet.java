package com.briup.web;

import java.io.IOException;
import java.nio.channels.FileChannel.MapMode;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Book;
import com.briup.bean.OrderLine;
import com.briup.bean.ShoppingCart;

@WebServlet("/addorderline")
public class AddOrderlineServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long bookid = Long.parseLong(request.getParameter("bookid"));
		long number = Long.parseLong(request.getParameter("number"));
		
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
		
		OrderLine line = new OrderLine();
		ServletContext context = getServletContext();
		Map<Long,Book> books=
				(Map<Long,Book>) context.getAttribute("books");
		Book book = books.get(bookid);
		line.setBook(book);
		line.setNum(number);
		cart.addLine(line);
		request.getRequestDispatcher("shopcart.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
