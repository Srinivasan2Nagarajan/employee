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

public class GetJobTitle {
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
					.executeQuery("SELECT FIRST_NAME, LAST_NAME, JOB_TITLE, START_DATE, DEPARTMENT_NAME, CITY, COUNTRY_NAME, REGION_NAME FROM EMPLOYEES LEFT OUTER JOIN JOBS ON employees.`JOB_ID` = JOBS.`JOB_ID`LEFT OUTER JOIN job_history ON employees.`EMPLOYEE_ID` = job_history.`EMPLOYEE_ID`LEFT OUTER JOIN DEPARTMENTS ON employees.`DEPARTMENT_ID` = DEPARTMENTS.`DEPARTMENT_ID`INNER JOIN LOCATIONS ON DEPARTMENTS.`LOCATION_ID` = LOCATIONS.`LOCATION_ID`INNER JOIN countries ON countries.`COUNTRY_ID` = LOCATIONS.`COUNTRY_ID`INNER JOIN REGIONS ON countries.`REGION_ID` = REGIONS.`REGION_ID`");

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " 
			+ rs.getString(3) + " " + rs.getDate(4) + " " + rs.getString(5) + " " + rs.getString(6)
			+ " " + rs.getString(7)+ " " + rs.getString(8));
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
