package com.xworkz.jdbc;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ApplicationFile {
	private String name;
	private int id;

	public void readData() {
		try (Scanner input = new Scanner(new File("src/main/java/com/xworkz/jdbc/App.txt"))) {
			while (input.hasNextLine()) {
				name = "";
				String line;
				line = input.nextLine();

				// get name
				try (Scanner data = new Scanner(line)) {
					while (!data.hasNextInt()) {
						name += data.next() + "";
					}
					name = name.trim();
					// get id
					if (data.hasNextInt()) {
						id = data.nextInt();
					}

				}
				// check data//
				// System.out.println(name + "\t" + id);

				saveData();// call the method to save the data into database//
			}
		} catch (IOException e) {
			System.out.println("e");
		}
	}

	// save the data into database
	private void saveData() {
		try (Connection conn = connection();
				PreparedStatement pst = conn.prepareStatement("insert into ApplicationFile values(?,?)")) {
			pst.setString(1, name);
			pst.setInt(2, id);
			pst.executeLargeUpdate();
		} catch (SQLException e) {
			System.out.println("e");
		}
	}

// display
//
//	public void displayData() {
//		try (Connection conn = connection(); Statement sts = conn.createStatement()) {
//			boolean hasResultset = sts.execute("select* from ApplicationFile");
//			if (hasResultset) {
//				ResultSet result = sts.getResultSet();
//				ResultSetMetaData metaData = result.getMetaData();
//
//				// get no of column
//				int columnCount = metaData.getColumnCount();
//
//			}
//		}
//		System.out.println();
//		// display data
//
//		while (result.next()) {
//			System.out.printf(result.getString("name"), result.getInt(id));
//
//		}
//	}catch(
//
//	SQLException e)
//	{
//		System.out.println(e);
//	}
//
//	}
//	// display column lables
//	for(
//	int i = 1;i<=columnCount;i++)
//	{
//					System.out.println(metaData.getColumnLabel(i) + "\t\t");
//	

// create a connection to the database

	private Connection connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/ApplicationFile", "root", "root");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null;
		}
	}

}
