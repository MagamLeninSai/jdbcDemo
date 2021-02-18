package com.vam.training.JdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchDemo {

	public static void main(String[] args) throws Exception {
		Connection con;
		Statement stmt;

		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc", "root", "india");
		stmt = con.createStatement();

		// create batch
		stmt.addBatch("insert into candidate_skills values(100,5)");
		stmt.addBatch("Update skills set name='Ájax' where id=3");
		stmt.addBatch("delete from candidates where id=80");

		// disable auto_commit mode
		con.setAutoCommit(false);
		try {
			stmt.executeBatch();
			con.commit();
			System.out.println("Batch is successfully executed");
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("batch is failed");
				System.out.println("Exception is :" + e);
			} catch (Exception e1) {
				System.out.println("Exception is :" + e1);
			}
		}

	}

}
