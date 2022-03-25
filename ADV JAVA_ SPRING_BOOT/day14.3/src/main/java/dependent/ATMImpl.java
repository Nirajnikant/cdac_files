package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;// = new SoapTransport();

	private  ATMImpl(Transport t12345) {
		this.myTransport=t12345;
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
	
	//life cycle hooks/methods
	public void myInit()
	{
		System.out.println("in init "+myTransport);//not null
	}
	
	public void myDestroy()
	{
		System.out.println("in destroy "+myTransport);//not null
	}
	//factory method : public static DependentBeanInstance anyName(args...) : to be invoked by SC
	public static ATMImpl myFactory(Transport t45678)
	{
		System.out.println("in factory method");
		//invoke private ctor
		return new ATMImpl(t45678);
	}	

}
