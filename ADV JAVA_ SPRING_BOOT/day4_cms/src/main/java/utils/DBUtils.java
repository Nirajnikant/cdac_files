package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
//ensure SINGLETON DB connection instance
	private static Connection connection;

	public static Connection getConnection() throws SQLException {
		return connection;
	}

	public static void openConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/dac22?useSSL=false&allowPublicKeyRetrieval=true";
		connection = DriverManager.getConnection(url, "root", "root");
	}

	public static void closeConnection() throws SQLException {
		if (connection != null)
			connection.close();
	}

}
