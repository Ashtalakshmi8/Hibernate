package com.xworkz.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class UseOfProperties {
	private static Connection connection = null;
	static {

		try {
			Properties properties = new Properties();
			InputStream inputstream = new FileInputStream(
					new File("src/main/resources/Database.properties"));
			properties.load(inputstream);// to load properties from properties file into java properties object
			String driverClassName = properties.getProperty("driver.class.name");
			String dburl = properties.getProperty("db.url");
			String dbUserName = properties.getProperty("db.Username");
			String dbpassword = properties.getProperty("db.password");
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(dburl, dbUserName, dbpassword);
		} catch (ClassNotFoundException | SQLException | IOException exception) {
			exception.printStackTrace();
		}
	}
	public static Connection getMySQLConnection() {
		// TODO Auto-generated method stub
		return null;
	}

}

//		Statement state=connection.createStatement();
//		ResultSet result=state.executeQuery("select*from road");
//		System.out.println("roadId\type\name\services");
//		System.out.println("************");
//		while(result.next())
//		{
//			System.out.println(result.getInt(1)+"\t"+ result.getString(2)+"\t"+result.getString(3)+"\t"+result.getInt(4));
//		}
//		connection.close();
//	}
