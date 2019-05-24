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
		    // 1.ͨ���û��������û�
		try {
			Customer cus = dao.findCustomerByName(customer.getName());
			//2.�ж�
			if(cus!=null){
				throw new CustomerServiceException("�û����ѱ�ռ�ã�");
			}
			//3.����
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
				throw new CustomerServiceException("��ǰ�û��������ڣ�");
			}else if(!cus.getPassword().equals(password)){
				{
					throw new CustomerServiceException("���벻��ȷ!");
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
