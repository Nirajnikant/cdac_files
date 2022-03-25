package dao;

import java.sql.SQLException;

public interface IBankAccountDao {
	String update_account(int srcId, int destId, double amount) throws SQLException;
}
