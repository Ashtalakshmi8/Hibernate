package com.xworkz.jdbc;

public class ApplicationTester {
	public static void main(String[] args) {
		ApplicationFile app=new ApplicationFile();
		try {
			app.readData();
			//app.displayData();
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
