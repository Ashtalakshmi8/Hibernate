package com.xworkz.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class AppProperties {
	// To store Data//outputstream//

//	public static void main(String[] args) throws Exception {
//		Properties properties = new Properties();
//		OutputStream os = new FileOutputStream("dataConfig.properties");
//		properties.setProperty("url", "localhost:3306/mysql");
//		properties.setProperty("uname", "root");
//		properties.setProperty("password", "root");
//		properties.store(os, null);
//	}
//
//}
	//how to read data//
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		InputStream is = new FileInputStream("dataConfig.properties");
		properties.load(is);
		System.out.println(properties.getProperty("uname"));
		System.out.println(properties.getProperty("url"));
		System.out.println(properties.getProperty("password"));
	}
}