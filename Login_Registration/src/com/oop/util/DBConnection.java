package com.oop.util;

import java.sql.Connection;
import java.sql .DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection conn;
	
	//Constructor 
	public  DBConnection()
	{
		
	}
	
	//Method 
	public static Connection getDBConnection()  
	{
		
		if(conn == null)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestingdb","root", "root");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return conn;
		
	}
}
