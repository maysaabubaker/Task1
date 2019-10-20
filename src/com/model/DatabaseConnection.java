package com.model;

import java.sql.*;

public class DatabaseConnection {
	private static Connection Con;
	private DatabaseConnection() {}
	public static Connection getConnection() {
		if(Con==null)
		{
		 try{
		     Class.forName("com.mysql.jdbc.Driver");  
			 Con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mgtsys","root","");
				
		 }
			catch (Exception e) {
			          System.out.println(e.toString());
			}
		}
		return Con;
	}
	}

