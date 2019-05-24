package com.briup.service.impl;

import java.util.Map;

import com.briup.bean.Book;
import com.briup.bean.Orderform;
import com.briup.common.exception.OrderServiceException;
import com.briup.dao.IOrderDao;
import com.briup.dao.impl.OrderDaoImpl;
import com.briup.service.IOrderService;

public class OrderServiceImpl implements IOrderService{
	private IOrderDao dao = new OrderDaoImpl();
	@Override
	public void saveOrder(Orderform order) throws OrderServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delOrder(Long orderid) throws OrderServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Long, Orderform> listAllOrder(Long customerid)
			throws OrderServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orderform findOrderById(Long orderid) throws OrderServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Long, Book> listAllBook() throws OrderServiceException {
		Map<Long, Book> map = null;
		try {
			map = dao.findAllBook();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
