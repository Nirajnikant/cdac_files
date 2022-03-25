package dao;

import pojos.User;

public interface IUserDao {
User authenticateUser(String email,String password);
}
