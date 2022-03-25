package tester;

import java.util.Date;

import com.app.vehicles.Vehicle;

import custom_exception.VehicleValidateException;

import static utils.VehicleValidatationRules.checkForDuplicate;

public class Test1 {

	public static void main(String[] args) throws VehicleValidateException {
		Vehicle v1 = new Vehicle(12345,"silver",456879, new Date(), "petrol");
		Vehicle v2 = new Vehicle(12346,"silver",456879, new Date(), "petrol");
//		Vehicle v3 = new Vehicle(12345,"silver",456879, new Date(), "petrol");

		Vehicle[] vehicles = {v1,v2};
		checkForDuplicate(vehicles, 12347);
	}

}
