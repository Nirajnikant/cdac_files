package utils;
import java.sql.*;

public class DBUtils {
	// ensure SINGLETON DB connection Instance
	private static Connection connection;
	public static Connection getConnection() throws SQLException {
		if(connection == null) {
			String url = "jdbc:mysql://localhost:3306/dac22?useSSL=false&allowPublicKeyRetrieval=true";
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=9373284318"); 

			connection = DriverManager.getConnection(url,"root","9373284318");
			//creating dependecy
		}
		return connection;
	}
}