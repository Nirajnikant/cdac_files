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
	private PreparedStatement pst1, pst2, pst3, pst4;

	// ctor
	public EmployeeDaoImpl() throws SQLException {
		cn = getConnection();
		// pst1 :
		pst1 = cn.prepareStatement(
				"select empid , name,salary, join_date from my_emp where deptid=? and join_date > ? order by salary");

		pst2 = cn.prepareStatement("insert into my_emp values(default,?,?,?,?,?)");

		pst3 = cn.prepareStatement("update my_emp set deptid = ?, salary = salary+? where empid = ?");
		
		pst4 = cn.prepareStatement("delete from my_emp where empid = ?");
		
		System.out.println("emp dao created....");
	}

	@Override
	public List<Employee> getSelectedEmpDetails(String dept, Date joinDate) throws SQLException {
		List<Employee> emps = new ArrayList<>();
		// set IN params
		pst1.setString(1, dept);
		pst1.setDate(2, joinDate);
		// exec query
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				emps.add(new Employee(rst.getInt(1), rst.getString(2), rst.getDouble(3), rst.getDate(4)));
		}
		return emps;
	}

	@Override
	public String addEmpDetails(Employee empDTO) throws SQLException {
		pst2.setString(1, empDTO.getName());
		pst2.setString(2, empDTO.getAddress());
		pst2.setDouble(3, empDTO.getSalary());
		pst2.setString(4, empDTO.getDeptId());
		pst2.setDate(5, empDTO.getJoinDate());

		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "Added emp details";
		return "Adding emp details failed!!!!!";
	}

	@Override
	public String updateEmpDetails(int empId, String newDept, Double salIncerment) throws SQLException {
		pst3.setString(1, newDept); //dept
		pst3.setDouble(2, salIncerment); //salary
		pst3.setInt(3, empId);
		
		int updateCount = pst3.executeUpdate();
		if (updateCount == 1)
			return "Updating emp details";
		return "Update emp details failed!!!!!";
	}
	
	//DELETE
	@Override
	public String deleteEMpDetails(int empId) throws SQLException {
		pst4.setInt(1, empId);
		int updateCount = pst4.executeUpdate();
		if(updateCount == 1)
			return "Delete SuccessFull";
		return "Delete UnSuccessfull";
	}

	// cleaning up db resources
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (cn != null)
			cn.close();
		System.out.println("emp dao cleaned up....");
	}

	

}
