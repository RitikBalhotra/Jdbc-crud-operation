package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerConection {
	
	public static Connection getConnection()
	{
		try {
		String url = "jdbc:mysql://localhost:3306/jdbc-statement-statics";
		String user = "root";
		String pass = "ritik@123";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection connection = DriverManager.getConnection(url, user, pass);
		
		
		return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return null;
		
		
	}


}
