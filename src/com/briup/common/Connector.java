package com.briup.common;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connector {
	public static Connection con = getConnection();
	public static Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username="liu";
			String password="zhifeng";
			conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
