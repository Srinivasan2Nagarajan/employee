package com.jspiders.jdbcDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class GettEmbyJobId {
	public static void main(String[] args) {

		Properties props = new Properties();
		FileReader fr = null;

		Connection con = null;
		Statement stmt = null;

		try {
			fr = new FileReader("config/dbconstants.properties");
			props.load(fr);

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alineemployee",
					props.getProperty("user"), props.getProperty("password"));

			stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT * FROM alineemployee.JOBS LEFT OUTER JOIN EMPLOYEES ON JOBS.`JOB_ID`= employees.`JOB_ID`;");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " 
			+ rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getInt(5) + " " + rs.getString(6)
			+ " " + rs.getString(7)+ " " + rs.getString(8)+ " " + rs.getInt(9)+ " " + rs.getDate(10)
			+ " " + rs.getInt(11)+ " " + rs.getInt(12)+ " " + rs.getInt(13)+ " " + rs.getInt(14)
			+ " " + rs.getInt(15));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
