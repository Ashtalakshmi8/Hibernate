package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class PropertiesTester {
	public static void main(String[] args) {
		Connection  connection = null;
		try {
			connection =  UseOfProperties.getMySQLConnection();
			if (connection != null) {
				System.out.println(connection);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
