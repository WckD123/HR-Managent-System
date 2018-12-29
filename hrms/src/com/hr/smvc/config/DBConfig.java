package com.hr.smvc.config;

//import java.io.FileInputStream;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;

//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;


public class DBConfig {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr_system","root" , "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
