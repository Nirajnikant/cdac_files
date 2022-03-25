package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;// = new SoapTransport();
	

	public ATMImpl() {
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}

	// life cycle hooks/methods
	public void myInit() {
		System.out.println("in init " + myTransport);// not null
	}

	public void myDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}

	public void setMyTransport(Transport myTransport) {
		System.out.println("in setter");
		this.myTransport = myTransport;
	}

	

}
