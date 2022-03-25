package dao;

import java.sql.SQLException;
import pojos.Users;

public interface IUserDao {
	Users authenticateUser(String email,String pwd) throws SQLException;
	String changePassword(String email ,String password ,String new_password) throws SQLException;
}