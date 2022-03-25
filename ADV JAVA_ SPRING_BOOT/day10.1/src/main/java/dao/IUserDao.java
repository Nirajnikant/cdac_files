package dao;

import java.time.LocalDate;
import java.util.List;

import pojo.Role;
import pojo.User;

public interface IUserDao {
	// add amethod to register new user
	String registerUser(User user);

	// add amethod to register new user via getCurrentSession
	String registerUserWithCurrentSession(User user);

	// add a method to retrive user deails by PK(id)
	User findByUser(int userId);// int --autoboxing----upcasting----Serializable

	// add a method to get all users details
	List<User> getAllUsers();

	// add a method to get selected users details
	List<User> getSelectedUsers(LocalDate startDate, LocalDate endDate, Role userRole);

	// add a method to get selected users details
	List<String> getSelectedUserName(LocalDate startDate, LocalDate endDate, Role userRole);

	// add a method to get selected users some details
	List<User> getSelectedUserDetails(LocalDate startDate, LocalDate endDate, Role userRole);
	
	// add a method to change password
	String changePassword(String email, String oldPwd, String newPwd);
	
}