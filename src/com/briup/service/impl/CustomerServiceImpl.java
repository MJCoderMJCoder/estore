package com.briup.service.impl;

import com.briup.bean.Customer;
import com.briup.common.exception.CustomerServiceException;
import com.briup.dao.ICustomerDao;
import com.briup.dao.impl.CustomerDaoImpl;
import com.briup.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService{
	private ICustomerDao dao = new CustomerDaoImpl();
	@Override
	public void register(Customer customer) throws CustomerServiceException {
		    // 1.通过用户名查找用户
		try {
			Customer cus = dao.findCustomerByName(customer.getName());
			//2.判断
			if(cus!=null){
				throw new CustomerServiceException("用户名已被占用！");
			}
			//3.保存
			dao.saveOrupdateCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomerServiceException(e.getMessage(),e);
		}
	}

	@Override
	public Customer login(String name, String password)
			throws CustomerServiceException {
		Customer cus = null;
		try{
			cus = dao.findCustomerByName(name);
			if(cus==null){
				throw new CustomerServiceException("当前用户名不存在！");
			}else if(!cus.getPassword().equals(password)){
				{
					throw new CustomerServiceException("密码不正确!");
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new CustomerServiceException(e.getMessage(),e);
		}
		return cus;
	}

	@Override
	public void update(Customer customer) throws CustomerServiceException {
		// TODO Auto-generated method stub
		
	}

}
