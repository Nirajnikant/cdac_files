package tester;

import static utils.DBUtils.getConnection;
import java.sql.*;
import java.util.Scanner;

public class TestPST {

	public static void main(String[] args) {
		String sql = "select empid, name , salary, join_date from my_emp where deptid=? and join_date > ? order by salary";
		try (Scanner sc = new Scanner(System.in);
				// get cn
				Connection cn = getConnection();
				// create pre-parsed and pre-compiled statement, meant for repetative queries,
				// supporting IN params and avoid SQL injection attack
				PreparedStatement pst = cn.prepareStatement(sql);

		) {
			while (true) {
				// UI
				System.out.println("Enter dept id and join date (year-month-date)");
				String dept = sc.next();
				if(dept.equalsIgnoreCase("stop"))
					return ;
				// set in parameters
				pst.setString(1, dept);// dept
				pst.setDate(2, Date.valueOf(sc.next()));

				// exec method : select => executeQuery
				try (ResultSet rst = pst.executeQuery()) {
					while (rst.next()) {
						System.out.printf("Emp ID %d Name %s Salary %.2f Join Date %s %n", rst.getInt(1),
								rst.getString(2), rst.getDouble(3), rst.getDate(4));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
