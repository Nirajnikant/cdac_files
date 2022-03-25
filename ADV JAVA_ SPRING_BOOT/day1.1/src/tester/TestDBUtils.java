package tester;
import static utils.DBUtils.getConnection;

import java.sql.Connection;
public class TestDBUtils {

	public static void main(String[] args) {
		try(Connection cn = getConnection()) {
			System.out.println("connected to db "+ cn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
