package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	public static Connection getConnection() {
		String URL="jdbc:mysql://localhost:3306/demo";
		Connection con = null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","1234");
			if(con!=null)
				System.out.println("Connection Success..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
