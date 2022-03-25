package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.Users;
import static utils.DBUtils.getConnection;

public class UserDaoImpl implements IUserDao {
//	1. state : cn , pst1
//	2. def ctor : get cn from utils , create pst1: sql 
//	3. CRUD method :
//	set IN params, execQuery ---> RST --> if(rst.next()) ---> return new User(.....);//fetch COMPLETE user details.
//	otherwise null.
//	4. clean up : pst close, cn close
	
	private Connection cn;
	private PreparedStatement pst1, pst2;
	
	public UserDaoImpl() throws SQLException {
		cn = getConnection();
		pst1 = cn.prepareStatement("select * from users where email = ? and password = ? ");
		pst2 = cn.prepareStatement("update users set password = ? where email = ? and password = ? ");
	}
	
	@Override
	public Users authenticateUser(String email, String pwd) throws SQLException {
		Users u = new Users();
		
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		
		try(ResultSet rst = pst1.executeQuery()) {
			while(rst.next()) {
				u.setId(rst.getInt(1));
				u.setEmail(rst.getString(2));
				u.setName(rst.getString(3));
				u.setPassword(rst.getString(4));
				u.setReg_amt(rst.getDouble(5));
				u.setReg_date(rst.getDate(6));
				u.setRole(rst.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	@Override
	public String changePassword(String email, String password, String new_password) throws SQLException {
		pst2.setString(1, new_password);
		pst2.setString(2, email);
		pst2.setString(3, password);
		
//		try(ResultSet rst2 = pst2.executeQuery()) {
//			if(authenticateUser(email, new_password).getPassword() == new_password)
//				return "PassWord updated";
//			else 
//				return "Operation Failed";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
		
		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "Updating password";
		return "Update password failed!!!!!";
	}

	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		if(cn != null)
			cn.close();
		System.out.println("emp dao cleaned up....");
	}

}
