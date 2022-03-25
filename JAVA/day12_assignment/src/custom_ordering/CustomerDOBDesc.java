package custom_ordering;

import java.util.Comparator;

import com.app.customerManagement.Customer;

public class CustomerDOBDesc implements Comparator<Customer> {
	@Override
	public int compare(Customer c1, Customer c2) {
		if(c1.getdateOfBirth().getTime()<c2.getdateOfBirth().getTime())
			return 1;
		if(c1.getdateOfBirth().getTime()==c2.getdateOfBirth().getTime())
			return 0;
		return -1;
	}
}
