package com.util.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionFactory implements ConnectionFactory {
	private static Connection con;
	private static String userName="system";
	private static  String password="root";
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			con=DriverManager.getConnection(url,userName,password);
	
			return con;
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("not load the driver"+e.getMessage());
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("db error"+e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("other error"+e.getMessage());
		}
		return null;
	}
	
}
