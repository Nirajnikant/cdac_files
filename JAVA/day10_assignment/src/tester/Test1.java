package tester;

import java.util.Date;
import java.util.Scanner;
import com.app.customerManagement.Customer;
import custom_exception.CustomerHandlingException;
import static utils.ValidationRules.*;



public class Test1 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the capacity :");
			Customer[] customers = new Customer[sc.nextInt()];
			int counter = 0;
			boolean exit = true;
			while(exit) {
				System.out.printf("Options\n1. Add Customers\n2. Display all\n3. Customer Login\n4. Aadhar card link\n"
						+ "10. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						if (counter < customers.length) {
							System.out.println(
									"Enter customer details : name, email, password, registrationAmount, dateOfBirth, type");
	//						Customer c1 = validate(sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(), customers);
							Customer c1 = validateCust(sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(), sc.next(), customers);
							//=> success
							customers[counter++]=c1;
							System.out.println("Registration Successfull");
						} else
							throw new CustomerHandlingException("Showroom full!!!!");
	//					System.out.println("Enter customer details : name, email, password, registrationAmount, dateOfBirth, type");
	//					Customer c1 = validate(sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(), customers);
						break;
						
					case 2:
						for(Customer c : customers) {
							if(c!=null)
								System.out.println(c);
						}
						break;
						
					case 3: //customer Login
						System.out.println("Customer Login ");
						System.out.println("Enter Registered EmailID and password");
						if(customerLoginPrompt(sc.next(), sc.next(), customers))
							System.out.println("Login Success");
						break;
						
					case 4://aadhar card link
						System.out.println("Enter Email");
						Customer c1 = validEmail(sc.next(), customers);
						System.out.println("Enter aadhar no and location");
						c1.assignAadhar(sc.next(), sc.next());
						break;
						
//					case 5://change password
//						System.out.printf("To change password : \nEnter Registered EmailID and old password\n");
//						Customer c2 = validEmail(sc.next(), customers);
//						if(passwordCheck(sc.next(), c2)) {
//							System.out.println("Enter new password:");
//							String password = sc.next();
//							passwordValidate(password);
//							c2.setPassword(password);
//							System.out.println("Password changed");
//						}
//						break;						
						
					case 10:
						exit = false;
						break;
					} 
				} catch (Exception e) {
				e.printStackTrace();
			}
					sc.nextLine();//yeh nahi diya to stack overflow :: type ke vajaha se
		} 
	}

}
	}
