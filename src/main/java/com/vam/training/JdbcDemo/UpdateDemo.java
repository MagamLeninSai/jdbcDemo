package com.vam.training.JdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateDemo {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		try {
			
			String str="update skills set id=7 where name='Servlet'";
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc", "root", "india");

			stmt = con.createStatement(); 
			int cnt= stmt.executeUpdate(str);
			if(cnt>0) {
				System.out.println("Record updated successfully");
			}
			System.out.println("Total no of records  affected is:"+cnt);
			con.close();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
					}
	}

}
