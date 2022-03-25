package utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.app.customerManagement.Customer;
import com.app.customerManagement.CustomerType;

import static com.app.customerManagement.Customer.sdf;

import custom_exception.CustomerHandlingException;




public class ValidationRules {
	public static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}
	public static Date endDate;
	static {
		try {
			endDate = sdf.parse("1-1-1995");
		} catch (ParseException e) {
			System.out.println("err in static init block " + e);
		}

		// cannot us throws since it requires method declaration
	}
	private static void duplicateValidate(Customer[] customers,String email) throws CustomerHandlingException {
//		if(emailValidate(email)) {
		Customer newCustomer = new Customer(email);
		if(email.matches(".*[@]*.com$")) {
			System.out.println("email validated");
			for(Customer c : customers) {
				if(c!=null) {
					if(c.equals(newCustomer)) 
						throw new CustomerHandlingException("Duplicate Customer");
				}
			}
			
		}
		else
			throw new CustomerHandlingException("Email format wrong!!!");
		System.out.println(" No Duplicates found");

	}
	
	public static void passwordValidate(String password) throws CustomerHandlingException {
		if(password.length()<4 || password.length()>10)
			throw new CustomerHandlingException("INVALID PASSWORD LENGTH!!!!!!!!!!");
	}
	
	private static Date parseAndValidate(String date) throws ParseException, CustomerHandlingException {
		Date d1 = sdf.parse(date);
		System.out.println(d1);
		if(d1.after(endDate)) 
			throw new CustomerHandlingException("Invalid Date");
		
		return d1;
		
	}
	
	public static CustomerType valCustomerType(String type,double regAmount) throws CustomerHandlingException{
		CustomerType c1 = CustomerType.valueOf(type.toUpperCase());
		System.out.println("cust type success");
		if(c1.getRegAmount()<=regAmount)
			return c1;
		throw new CustomerHandlingException("Invalid registration amount for "+c1);
	}
	
	public static Customer validateCust(String name, String email, String password, double registrationAmount, String dateOfBirth, String type, Customer[] customers) throws CustomerHandlingException, ParseException {
		duplicateValidate(customers, email);
		passwordValidate(password);
		Date d1 = parseAndValidate(dateOfBirth);
		CustomerType type1 = valCustomerType(type,registrationAmount);
		
		return new Customer(name, email, password, registrationAmount, d1, type1);
	}
	
	//customer login
	public static boolean customerLoginPrompt(String email, String password, Customer[] customers) throws CustomerHandlingException{
		int count = 0;
		if(email.matches(".*[@]*.com$")) {
			for(Customer c : customers) {
				if(c!=null) {
					if(c.getEmail().equals(email) && c.getPassword().equals(password)) {
						count = 1;
						return true;
					}
				}
			}
		}
		if(count == 0)
			throw new CustomerHandlingException("Credentials are wrong");
		throw new CustomerHandlingException("Email wrong");
	}
	
	public static Customer validEmail(String email, Customer[] customers) throws CustomerHandlingException {
		if(email.matches(".*[@]*.com$")) {
			for(Customer c : customers) {
				if(c!=null) {
					if(c.getEmail().equals(email))
						return c;
				}
			}
		}
		throw new CustomerHandlingException("Email wrong");
	}
	
	public static boolean passwordCheck(String password, Customer c) throws CustomerHandlingException {		passwordValidate(password);
		if(c.getPassword().equals(password))
			return true;
		throw new CustomerHandlingException("Password not mached");
	}
}