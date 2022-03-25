package utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.app.customerManagement.Customer;
import com.app.customerManagement.CustomerType;
import static utils.ValidationRules.sdf;

public class CollectionUtils {

	public static ArrayList<Customer> populateCustomer() throws ParseException {
//		String name, String email, String password, double registrationAmount, Date dateOfBirth, CustomerType type1
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("Niraj","niraj@gmail.com","123456",1500, sdf.parse("17-8-1993"),CustomerType.DIAMOND));
		customers.add(new Customer("Nirali","nirali@gmail.com","564785",2000, sdf.parse("15-9-1992"),CustomerType.PLATINUM));
		customers.add(new Customer("Arun","arun@outlook.com","987456",1000, sdf.parse("27-2-1990"),CustomerType.GOLD));
		customers.add(new Customer("Golu","golu@zohomail.com","132879",1500, sdf.parse("27-6-1963"),CustomerType.DIAMOND));
		customers.add(new Customer("Paku","paku@rediffmail.com","654741",500, sdf.parse("7-4-1954"),CustomerType.SILVER));
		customers.add(new Customer("Bhavesh","gunnu@gmail.com","4529812",2000, sdf.parse("10-5-1932"),CustomerType.PLATINUM));
		return customers;
		
	}
	
}
