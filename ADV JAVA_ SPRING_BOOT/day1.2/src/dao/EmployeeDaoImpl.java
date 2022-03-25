package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.Employee;
import static utils.DBUtils.getConnection;

public class EmployeeDaoImpl implements IEmployeeDao {
	// state
	private Connection cn;
	private PreparedStatement pst1;

	// ctor
	public EmployeeDaoImpl() throws SQLException {
		cn = getConnection();
		// pst1 :
		pst1 = cn.prepareStatement(
				"select empid , name,salary, join_date from my_emp where deptid=? and join_date > ? order by salary");
		System.out.println("emp dao created....");
	}

	@Override
	public List<Employee> getSelectedEmpDetails(String dept, Date joinDate) throws SQLException {
		List<Employee> emps=new ArrayList<>();
		// set IN params
		pst1.setString(1, dept);
		pst1.setDate(2, joinDate);
		//exec query 
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
				emps.add(new Employee(rst.getInt(1), rst.getString(2), rst.getDouble(3),rst.getDate(4)));				
		}		
		return emps;
	}
	//cleaning up db resources
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		if(cn != null)
			cn.close();
		System.out.println("emp dao cleaned up....");
	}
	

}
