package com.briup.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.briup.bean.Book;
import com.briup.bean.OrderLine;
import com.briup.bean.Orderform;
import com.briup.common.Connector;
import com.briup.dao.IOrderDao;

public class OrderDaoImpl implements IOrderDao{
	private Connection conn = Connector.con;
	@Override
	public void saveOrder(Orderform order) throws Exception {
		String sql = "insert into orderform values(orderform_seq.nextval,????)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setDouble(1,order.getCost());
		pre.setDate(2, new Date(order.getOrderDate().getTime()));
		pre.setLong(3, order.getCust().getId());
		pre.executeUpdate();
		conn.commit();
		//Statement st = conn.createStatement();
		//
		//
		PreparedStatement pre2 = conn.prepareStatement("select * from orderform where orderdate=?");
		pre2.setDate(1, new Date(order.getOrderDate().getTime()));
		ResultSet rs = pre2.executeQuery();
		long orderid = 0;
		while(rs.next()){
			orderid = rs.getLong("id");
		}
		
		Set<OrderLine> set = order.getOrderLines();
		String sql1 = "insert into orderLine values()";
		for(OrderLine Line:set);
	}

	@Override
	public void deleteOrder(Long orderid) throws Exception {
		
	}

	@Override
	public Map<Long, Orderform> findAllOrder(Long customerid) throws Exception {
		return null;
	}

	@Override
	public Orderform findOrderById(Long orderid) throws Exception {
		return null;
	}

	@Override
	public Map<Long, Book> findAllBook() throws Exception {
		String sql = "select * from book";
		Statement st = conn.createStatement();
		ResultSet re = st.executeQuery(sql);
		Map<Long, Book> map = new TreeMap<>();
		while(re.next()){
			Long id = re.getLong("id");
			String name = re.getString("name");
			double price = re.getDouble("price");
			Book book = new Book(id, name, price); 
			map.put(id, book);
		}
		return map;
	}

}
