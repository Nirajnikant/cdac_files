package tester;

import dependency.HttpTransport;
import dependency.TestTransport;
import dependent.ATMImpl;

public class TestATM {

	public static void main(String[] args) {
		ATMImpl atm=new ATMImpl();
		atm.setMyTransport(new TestTransport());
		atm.deposit(1000);

	}

}
