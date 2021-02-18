package com.vam.training.JdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlCon {
	
public static void main(String[] args) {
	Connection con;
	Statement stmt;
	ResultSet rs;
	try {
		// Register JDBC Driver
		Class.forName("com.mysql.cj.jdbc.Driver");	
		//Open a connection
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity","root","india");
		
		//Execute a query
		stmt=con.createStatement();
		rs=stmt.executeQuery("select * from shoppingmalls");
		
		//Execute data from resultSet
		while(rs.next()) {
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
		}
		con.close();
	}
	catch(Exception e) {
		e.getMessage();
	}
}
}
