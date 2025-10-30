package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	
	private static DBUtility instance;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not LOaded");
		}
	}
	
	private DBUtility() {}
	
	public static DBUtility getInstance() {
		if(instance == null)
		instance=new DBUtility();
		
		return instance;
	}
	
	
	
private static final String URL="jdbc:mysql://localhost:3306/employeedetails";
	
	private static final String USER="root";
	
	private static final String PASS="pratham";
	
	
  public Connection getDbConnection() {
	  Connection con=null;
	  try {
	  con=DriverManager.getConnection(URL,USER,PASS);
	  }catch(SQLException e) {
		  System.out.println("DataBase Connection Issue");
	  }
	  return con;
  }

}
