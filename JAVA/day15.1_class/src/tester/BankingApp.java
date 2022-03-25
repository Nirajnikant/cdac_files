package tester;

import static com.app.banking.AccountType.valueOf;
import static java.time.LocalDate.parse;
import static utils.CollectionUtils.findByAccountNo;
import static utils.CollectionUtils.populateMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.app.banking.AccountType;
import com.app.banking.AccountType.*;
import com.app.banking.BankAccount;

import custom_exception.BankingException;

public class BankingApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// init phase
			// create suitable D.S.
			HashMap<Integer, BankAccount> accounts = populateMap();
			boolean exit = false;
			while (!exit) {
				System.out.printf(
						"Options\n1. Create A/C\n2. Display\n3. Get A/C Summary\n4. Transfer Funds\n5. Close Account\n6. Dispaly all account "
						+"details for a specific account type\n7. Get details for a balance\n8. Remove all loan\n10. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Account no.");
						int acctNo = sc.nextInt();
						if (accounts.containsKey(acctNo))
							throw new BankingException("Duplicate account !!!!");
						// => acct no is new
						System.out.println(
								"Enter a/c details : accountType, balance, creation date(year-month-date), customer name");
						accounts.put(acctNo, new BankAccount(acctNo, valueOf(sc.next().toUpperCase()), sc.nextDouble(),
								parse(sc.next()), sc.next()));
						System.out.println("A/c created");

						break;

					case 2:
						System.out.println("All A/C Details");
						for (BankAccount a : accounts.values())
							System.out.println(a);

						break;
					case 3:
						System.out.println("Enter A/c no., to get summary");
//						BankAccount acct = accounts.get(accounts);//int -> integer
//						if(acct == null)
//							throw new BankingException("Invalid account no.");
//						
//						System.out.println("Account summary" + acct);
						System.out.println(findByAccountNo(sc.nextInt(), accounts));
						break;
					case 4:// Funds Transfer
						System.out.println("Enter source, destination account no, and amount to tranfer");
						BankAccount src = findByAccountNo(sc.nextInt(), accounts);
						BankAccount dest = findByAccountNo(sc.nextInt(), accounts);
						// => src and destination account exist
						src.trnsferFunds(dest, sc.nextDouble());
						System.out.println("funds transferred");
						break;

					case 5:
						System.out.println("Enter a/c no to close a/c");
						src = accounts.remove(sc.nextInt());
						if (src == null)
							throw new BankingException("Invalid account no.");
						System.out.println(src + " Account closed");
						break;

					case 6:// Dispaly all account details for a specific account type
						System.out.println("Enter a/c type");
						AccountType type = valueOf(sc.next().toUpperCase());
						System.out.println("A/cs of type " + type);
						for (BankAccount b : accounts.values())
							if (b.getAcType() == type)
								System.out.println(b);
						break;

					case 7:
						System.out.println("Enter amount");
						int amt = sc.nextInt();
						for (BankAccount b : accounts.values())
							if (b.getBalance() >= amt)
								System.out.println(b);

						break;
						
					case 8://remove loan accounts
						Iterator<BankAccount> itr = accounts.values().iterator();
						System.out.println("Removing all loan accounts");
//						for (BankAccount b : accounts.values())
//							if(b.getAcType() == LOAN)
//								collection.remove(b);
						while(itr.hasNext()) {
							if(itr.next().getAcType()==AccountType.LOAN)
								itr.remove();
						}
						break;
					case 10:
						exit = true;
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				sc.nextLine();
			}
		}
	}

}
