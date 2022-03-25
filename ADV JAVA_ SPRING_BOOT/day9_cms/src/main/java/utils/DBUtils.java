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

	public static void openConnection(String url,String userName,String password) throws SQLException {
			connection = DriverManager.getConnection(url, userName, password);
	}

	public static void closeConnection() throws SQLException {
		if (connection != null)
			connection.close();
	}

}
