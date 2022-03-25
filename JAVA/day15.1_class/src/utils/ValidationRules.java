package utils;

import custom_exception.BankingException;

public class ValidationRules {
	public static final double MIN_BALANCE;
	static {
		MIN_BALANCE = 5000;
	}
	
	public static void validateBalance(double balance) throws BankingException{
		if(balance < MIN_BALANCE)
			throw new BankingException("Insufficent Balance");
	}
}
