package dependent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import dependency.Transport;

//singleton n eager , id=my_atm
@Component("my_atm")
public class ATMImpl implements ATM {
	@Autowired//(required = false) 
	@Qualifier("soapTransport")// autowire=byName
	
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
	@PostConstruct // init-method
	public void myInit() {
		System.out.println("in init " + myTransport);// not null
	}

	@PreDestroy // destroy-method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}

}
