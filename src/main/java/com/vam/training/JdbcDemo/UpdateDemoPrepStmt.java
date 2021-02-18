package com.vam.training.JdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateDemoPrepStmt {

	public static void main(String[] args) {
		Connection con;
		PreparedStatement pstmt;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc", "root", "india");

			pstmt = con.prepareStatement("update candidates set last_name=? where id=? ");

			Scanner s = new Scanner(System.in);
			System.out.println("Enter employee Id :");
			int eid = s.nextInt();
			System.out.println("Enter employee new Last Name :");
			String lastname = s.next();

			pstmt.setString(1, lastname);
			pstmt.setInt(2, eid);
			int cnt = pstmt.executeUpdate();
			
			System.out.println("Affected Rows :"+cnt);
			//hard-code
			 lastname = "Grohe";
             eid = 101;
             pstmt.setString(1,lastname);
             pstmt.setInt(2,eid);

             int rowAffected = pstmt.executeUpdate();
             System.out.println(String.format("Row affected %d", rowAffected));
             
			con.close();
			s.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
