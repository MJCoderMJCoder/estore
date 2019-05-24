package com.briup.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.briup.bean.Customer;
import com.briup.common.Connector;
import com.briup.dao.ICustomerDao;

public class CustomerDaoImpl implements ICustomerDao{
	private Connection conn = Connector.getConnection();
	@Override
	public void saveOrupdateCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into customer values(customer_seq.nextval,?,?,?,?,?,?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, customer.getName());
		pre.setString(2, customer.getPassword());
		pre.setString(3, customer.getZip());
		pre.setString(4, customer.getAddress());
		pre.setString(5, customer.getTelephone());
		pre.setString(6, customer.getEmail());
		pre.executeUpdate();
		conn.commit();
		pre.close();
	}

	@Override
	public Customer findCustomerByName(String name) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from customer where name='"+name+"'";
		Statement st = conn.createStatement();
		ResultSet re = st.executeQuery(sql);
		Customer cus = null;
		while(re.next()){
			Long id = re.getLong("id");
			String username = re.getString("name");
			String password = re.getString("password");
			String zip = re.getString("zip");
			String telephone = re.getString("telephone");
		    String address = re.getString("address");
		    String email = re.getString("email");
		    cus = new Customer(id,username,password,zip,address,telephone,email);
		}
		return cus;
	}

}
