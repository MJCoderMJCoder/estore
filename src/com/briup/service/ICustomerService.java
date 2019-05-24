package com.briup.service;

import com.briup.bean.Customer;
import com.briup.common.exception.CustomerServiceException;

public interface ICustomerService {
	//�û�ע��
	void register(Customer customer) throws CustomerServiceException; 
	//�û���½
	Customer login(String name,String password) throws CustomerServiceException;
	//�û�����
	void update(Customer customer) throws CustomerServiceException; 
}
