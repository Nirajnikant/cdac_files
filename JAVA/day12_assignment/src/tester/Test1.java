package tester;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import com.app.customerManagement.Customer;
import com.app.customerManagement.CustomerType;

import custom_exception.CustomerHandlingException;
import custom_ordering.CustomerDOBDesc;

import static utils.ValidationRules.*;
import static utils.CollectionUtils.populateCustomer;


public class Test1 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the capacity :");
			//Customer[] customers = new Customer[sc.nextInt()];
			ArrayList<Customer> customers = populateCustomer();
//			int counter = 0;
			boolean exit = true;
			while(exit) {
				System.out.printf("Options\n1. Add Customers\n2. Display all\n3. Customer Login\n4. Aadhar card link\n"
						+ "5. Change Password\n6. Delete silver plan\n7. Arrange in ascending order of email\n"
						+ "8. Arrange in descending order of DOB\n10. Exit\n");
				try {
					switch (sc.nextInt()) {
					case 1:
//						if (counter < customers.length) {
							System.out.println(
									"Enter customer details : name, email, password, registrationAmount, dateOfBirth, type");
	//						Customer c1 = validate(sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(), customers);
//							validateCust(String name, String email, String password, double registrationAmount, String dateOfBirth, String type, ArrayList<Customer> customers, CustomerType type2)
							Customer c = validateCust(sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(), sc.next(),customers);
							//=> success
							//customers[counter++]=c1;
							customers.add(c);
							System.out.println("Registration Successfull");
//						} else
//							throw new CustomerHandlingException("Showroom full!!!!");
	//					System.out.println("Enter customer details : name, email, password, registrationAmount, dateOfBirth, type");
	//					Customer c1 = validate(sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(), customers);
						break;
						
					case 2:
						for(Customer c1 : customers)
								System.out.println(c1);
						break;
						
					case 3: //customer Login
						System.out.println("Customer Login ");
						System.out.println("Enter Registered EmailID and password");
						if(customerLoginPrompt(sc.next(), sc.next(), customers))
							System.out.println("Login Success");
						break;
						
					case 4://aadhar card link
						System.out.println("Enter Email");
						Customer c2 = validEmail(sc.next(), customers);
						System.out.println("Enter aadhar no and location");
						c2.assignAadhar(sc.next(), sc.next());
						break;
						
					case 5://change password
						System.out.printf("To change password : \nEnter Registered EmailID and old password\n");
						Customer c3 = validEmail(sc.next(), customers);
						if(passwordCheck(sc.next(), c3)) {
							System.out.println("Enter new password:");
							String password = sc.next();
							passwordValidate(password);
							c3.setPassword(password);
							System.out.println("Password changed");
						}
						break;
					
					case 6://remove silver
						System.out.println("Deleting silver plan");
						Iterator<Customer> customerListItr = customers.iterator();
						while(customerListItr.hasNext()) {
							if(customerListItr.next().getType() == CustomerType.SILVER)
								customerListItr.remove();
						}
						break;
						
					case 7: //sort customer details as per email asc : Use Natural Ordering
						Collections.sort(customers);
						break;
						
					case 8://sort customer details as per dob desc : Use Custom Ordering
//						ListIterator<Customer> customerItr = customers.listIterator();
						Collections.sort(customers, new CustomerDOBDesc());
						break;
						
					case 10:
						exit = false;
						break;
					} 
				} catch (Exception e) {
				e.printStackTrace();
			}
					sc.nextLine();//yeh nahi diya to stack overflow :: type ke vajaha se
		} 
	} catch (ParseException e1) {
		e1.printStackTrace();
	}

}
	}
