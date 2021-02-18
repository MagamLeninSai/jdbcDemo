package com.vam.training.JdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet rs;
		try {
			//String str="delete from skills where name='Servlet'";
			String str="Delete from candidates where rtrim(last_name) like \'y%g\'";
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc", "root", "india");

			stmt = con.createStatement(); 
			int cnt= stmt.executeUpdate(str);
			if(cnt>0) {
				System.out.println("Record Deleted successfully");
			}
			else {
				System.out.println("Record Not found");
			}
			System.out.println("Total no of records is:"+cnt);
			con.close();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
					}
	}

}
