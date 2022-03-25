package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import static utils.DBUtils.getConnection;

public class BankAccountDaoImpl implements IBankAccountDao {
	// state

	private Connection cn;
	// CST : for exec of stored Procedure
	private CallableStatement cst1;

	// ctor
	public BankAccountDaoImpl() throws SQLException {
		// get cn from DBUtils
		cn = getConnection();

		// cst
		cst1 = cn.prepareCall("{call transfer_funds(?,?,?,?,?)}");

		cst1.registerOutParameter(4, Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
		System.out.println("Account DAO Created");
	}

	@Override
	public String transferFunds(int srcId, int destId, double amount) throws SQLException {
		cst1.setInt(1, srcId);
		cst1.setInt(2, destId);
		cst1.setDouble(3, amount);
		
		cst1.execute();
		//how to get results from out param ? getters
		
		return "Updated src balance" + cst1.getDouble(4) + " destination balance " + cst1.getDouble(5);
	}

	public void cleanUp() throws SQLException {
		if (cst1 != null)
			cst1.close();
		if (cn != null)
			cn.close();
	}

}
