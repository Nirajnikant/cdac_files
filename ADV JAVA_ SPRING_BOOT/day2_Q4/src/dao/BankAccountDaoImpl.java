package dao;

import java.sql.*;
import pojos.BankAccount;
import static utils.DBUtils.getConnection;

public class BankAccountDaoImpl implements IBankAccountDao {
	private Connection cn;
	private CallableStatement cst1;

	public BankAccountDaoImpl() throws SQLException {
		cn = getConnection();
		// update_account_fn (sid int ,did int,amt double)
//		cst1 = cn.prepareCall("{call update_account_fn(?,?,?)}");
		cst1 = cn.prepareCall("{? = call update_account_fn(?,?,?)}");
		cst1.registerOutParameter(1, Types.DOUBLE);
		System.out.println("Account DAO Created");
	}

	@Override
	public String update_account(int srcId, int destId, double amount) throws SQLException {
		BankAccount b = new BankAccount();
		cst1.setInt(2, srcId);
		cst1.setInt(3, destId);
		cst1.setDouble(4, amount);

		cst1.execute();
		//how to get results from out param ? getters
		
		return "Updated balance" + cst1.getDouble(1);
	}

	public void cleanUp() throws SQLException
	{
		if(cst1 != null)
			cst1.close();
		if(cn != null)
			cn.close();
		System.out.println("emp dao cleaned up....");
	}

}
