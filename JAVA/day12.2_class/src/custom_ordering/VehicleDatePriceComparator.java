package custom_ordering;

import java.util.Comparator;

import com.app.vehicles.Vehicle;

public class VehicleDatePriceComparator implements Comparator<Vehicle>{
	@Override
	public int compare(Vehicle v1, Vehicle v2) {
		System.out.println("in compare : date and price");
		int retValue = v1.getManufactureDate().compareTo(v2.getManufactureDate());
		if(retValue == 0) {
			return ((Double)v1.getPrice()).compareTo(v2.getPrice());//invoker : prog has to explicitly typecast
													// arg : javac implicitly : auto boxing
		}
		return retValue;
	}

	
}
