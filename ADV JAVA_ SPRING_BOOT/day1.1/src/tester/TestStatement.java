package tester;

import java.sql.*;
import static utils.DBUtils.getConnection;

public class TestStatement {
//	TestStatement is dependent on DBUtils for getting Fixed database statement
	public static void main(String[] args) {
		// display all employee details
		try (Connection cn = getConnection();
				Statement st = cn.createStatement(); // createStatement creates empty statement/query holder
				ResultSet rst = st.executeQuery("select * from my_emp order by salary desc")) {
			while (rst.next()) {
				System.out.printf("ID %d Name %s Address %s Salary %.1f Dept %s Join on %s%n", 
						rst.getInt(1),rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getString(5),
						rst.getDate(6));
			}
		} //rst.close(), st.close(), cn.close()
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
