package beans;

import java.sql.SQLException;

import dao.UserDaoImpl;
import pojos.User;

public class UserBean {
	//state / properties , representing clnt's conversational stagte(req params)	
	private String email;
	private String password;
	//dependency : UserDao
	private UserDaoImpl userDao;
	//results of B.L : validated user details
	private User validatedUserDetails;
	//add a property to hold status of auth.
	private String message;
	//def ctor : will be invoked by WC , when JSP : <jsp:useBean.../>
	public UserBean() throws SQLException{
		System.out.println("in user bean ctor");
		// create dependency : dao inst.
		userDao=new UserDaoImpl();
	}
	//setters n getters 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDaoImpl getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	public User getValidatedUserDetails() {
		return validatedUserDetails;
	}
	public void setValidatedUserDetails(User validatedUserDetails) {
		this.validatedUserDetails = validatedUserDetails;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	//add B.L method for user authentication
	public String validateUser() throws SQLException
	{
		System.out.println("in auth user "+email+" "+password);
		//bean invokes dao's method
		validatedUserDetails=userDao.authenticateUser(email, password);
		if(validatedUserDetails != null)
		{
			message="Login Successful!";
			//=> authetication success  --> proceed to role based authorization
			if(validatedUserDetails.getRole().equals("ADMIN"))
				return "add_new_tut";//dyn navigational outcome !
			//=>customer login successful
			return "topics";
		}
		//=> invalid login
		message="Bad Credentials , Please retry";
		return "login";
	}
	
	
	

}
