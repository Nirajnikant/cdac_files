package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import pojos.Employee;

public interface IEmployeeDao {
	// display all emp details using some criteria (dept, date)
	List<Employee> getSelectedEmpDetails(String dept, Date joinDate) throws SQLException; 
	//	 ^^ pojo is used as DTO(Data Transfer Object)
}