package tester;

import java.util.Date;
import java.util.Scanner;
import com.app.customerManagement.Customer;
import custom_exception.CustomerHandlingException;
import static utils.ValidationRules.validateCust;



public class Test1 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the capacity :");
			Customer[] customers = new Customer[sc.nextInt()];
			int counter = 0;
			boolean exit = true;
			while(exit) {
				System.out.printf("Options\n1. Add Customers\n2. Display all\n3. Exit");
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
							System.out.println("vehicle added to the showroom");
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
					case 3:
						exit = false;
						break;
					} 
				} catch (Exception e) {
				e.printStackTrace();
			}
				//clr off pending tokens from the scanner
				sc.nextLine();//to  aovid Input mismatch in case on entering wrong type
		} 
	}

}
	}
