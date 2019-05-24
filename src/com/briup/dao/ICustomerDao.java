package com.briup.dao;

import com.briup.bean.Customer;

public interface ICustomerDao {
	//保存或更新用户
	void saveOrupdateCustomer(Customer customer) throws Exception;
	//�����û�
	Customer findCustomerByName(String name) throws Exception;
}
