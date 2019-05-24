package com.briup.service;

import java.util.Map;

import com.briup.bean.Book;
import com.briup.bean.Orderform;
import com.briup.common.exception.OrderServiceException;

public interface IOrderService {
	//���涩��
	void saveOrder(Orderform order) throws OrderServiceException;
	//ɾ������
	void delOrder(Long orderid) throws OrderServiceException;
	//�����û����ж���
	Map<Long,Orderform> listAllOrder(Long customerid) throws OrderServiceException;
	//���ҵ�������
	Orderform findOrderById(Long orderid) throws OrderServiceException;
	//���������鼮
	Map<Long,Book> listAllBook() throws OrderServiceException;
}
