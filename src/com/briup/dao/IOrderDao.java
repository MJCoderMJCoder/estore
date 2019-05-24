package com.briup.dao;

import java.util.Map;

import com.briup.bean.Book;
import com.briup.bean.Orderform;

public interface IOrderDao {
	//���涩��
	void saveOrder(Orderform order) throws Exception;
	//ɾ������
	void deleteOrder(Long orderid) throws Exception;
	//�����û����ж���
	Map<Long,Orderform> findAllOrder(Long customerid) throws Exception;
	//���ҵ�������
	Orderform findOrderById(Long orderid) throws Exception;
	//���������鼮
	Map<Long,Book> findAllBook() throws Exception;
}
