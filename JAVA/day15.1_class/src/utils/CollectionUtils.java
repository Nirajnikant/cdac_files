package utils;

import java.util.HashMap;

import com.app.banking.BankAccount;

import custom_exception.BankingException;

import static com.app.banking.AccountType.*;
import static java.time.LocalDate.parse;

public class CollectionUtils {
	public static HashMap<Integer, BankAccount> populateMap() {
		HashMap<Integer, BankAccount> map = new HashMap<Integer, BankAccount>();
		System.out.println(map.put(101, new BankAccount(101, LOAN, 12345, parse("2020-01-01"), "Rama")));
		System.out.println(map.put(10, new BankAccount(10, CURRENT, 7425, parse("2019-11-21"), "Sara")));
		System.out.println(map.put(56, new BankAccount(56, FD, 50000, parse("2018-09-13"), "Nirali")));
		System.out.println(map.put(78, new BankAccount(78, LOAN, 62345, parse("2018-06-12"), "Dhanush")));
		System.out.println(map.put(34, new BankAccount(34, SAVING, 52315, parse("2020-07-24"), "Kashi")));
		return map;
	}
	
	//add static method to accept account no. and retrun account refernce in case of success otherwise throw exceptions
	public static BankAccount findByAccountNo(int acctNo, HashMap<Integer, BankAccount> map) throws BankingException{
		BankAccount a = map.get(acctNo);
		if(a == null)
			throw new BankingException("Invalid acct no");
		return a;
	}
}
