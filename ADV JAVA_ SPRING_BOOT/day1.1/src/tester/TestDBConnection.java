package tester;

import java.sql.*;

public class TestDBConnection {

	public static void main(String[] args) {
		try {
			//load JDBC Driver in JVM's method area
			//API : Class.forName(String F.Q class Name) throws  ClassNotFoundException
//			Class.forName("com.mysql.cj.jdbc.Driver");//Optional Step
			System.out.println("Driver Class Loaded");
			String url = "jdbc:mysql://localhost:3306/dac22?useSSL=false&allowPublicKeyRetrieval=true";
			Connection cn = DriverManager.getConnection(url,"root","9373284318");  //cn = com.mysql.cj.jdbc.ConnectionImpl@515aebb0
//																							fully qualified class name @ hashcode 			
			System.out.println("Connected to DAtabase " + cn);
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}