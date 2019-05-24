package com.briup.bean;

import java.math.BigDecimal;
import java.util.*;

public class ShoppingCart {
//<物品的id 订单明细>
	private Map<Long,OrderLine> cart = new TreeMap<Long,OrderLine>();
	public void addLine(OrderLine line){
		long bookid = line.getBook().getId();
		OrderLine line1 = cart.get(bookid);
		if(line1!=null){
			long num = line1.getNum()+line.getNum();
			line1.setNum(num);
		}else{
			cart.put(bookid, line);
		}
	}
	public void dropLine(Long lineid){
		cart.remove(lineid);
	}
	public OrderLine getOrderline(Long lineid){
		return cart.get(lineid);
	}
	public Collection getOrderlines(){
		return cart.values();
	}
	
	public double getCost(){
		BigDecimal cost = new BigDecimal(0);
		Collection<OrderLine>values = cart.values();
		Iterator<OrderLine> iter = values.iterator();
		while (iter.hasNext()) {
			OrderLine line = iter.next();
			long num = line.getNum();
			double price = line.getBook().getPrice();
			cost = cost.add(new BigDecimal(num*price));
		}
		return cost.doubleValue();
	}
	public void removeALL(){
		cart = new TreeMap<Long, OrderLine>();
	}
	public boolean isEmpty(){
		return cart.isEmpty();
	}
	
}

