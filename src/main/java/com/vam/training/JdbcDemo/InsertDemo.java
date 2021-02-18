package com.vam.training.JdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet rs;
		int cn=0;
		try {
			String str="insert into skills(name) values('Servlet')";
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc", "root", "india");

			stmt = con.createStatement(); 
			int cnt= stmt.executeUpdate(str);
			if(cnt>0) {
				System.out.println("Record inserted successfully");
			}
			String str1="Select count(id) from skills";
			rs=stmt.executeQuery(str1);
			while(rs.next()) {
			cn = rs.getInt(1);
			}
			System.out.println("Total no of records is:"+cn);
			con.close();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
					}
	}

}
