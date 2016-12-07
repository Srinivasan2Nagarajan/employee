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

public class GetDistinctId {
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
					.executeQuery(" SELECT * FROM LOCATIONS INNER JOIN DEPARTMENTS ON LOCATIONS.`LOCATION_ID` = DEPARTMENTS.`LOCATION_ID`INNER JOIN EMPLOYEES ON DEPARTMENTS.`DEPARTMENT_ID` = EMPLOYEES.`DEPARTMENT_ID`");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " 
			+ rs.getInt(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getInt(6)
			+ " " + rs.getInt(7)+ " " + rs.getString(8) + " " + rs.getInt(9) + " " 
					+ rs.getInt(10) + " " + rs.getInt(11) + " " + rs.getString(12) + " " + rs.getString(13)
					+ " " + rs.getString(14)+ " " + rs.getInt(15) + " " + rs.getDate(16) + " " + rs.getInt(17) + " " + rs.getInt(18)
					+ " " + rs.getInt(19)+ " " + rs.getInt(20));
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
