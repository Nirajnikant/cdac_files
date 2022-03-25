package utils;

import java.text.ParseException;
import java.util.Date;

import com.app.vehicles.Vehicle;
import static com.app.vehicles.Vehicle.sdf;

import custom_exception.VehicleValidateException;

public class VehicleValidatationRules {
	public static Date startDate, endDate;
	static {
		try {
			startDate = sdf.parse("1-4-2021");
			endDate = sdf.parse("31-0-2022");
		} catch (ParseException e) {
			System.out.println("err in static init block " + e);
		}

		// cannot us throws since it requires method declaration
	}

//add public static method to check for duplicate chasis no.
	public static void checkForDuplicate(Vehicle[] vehicles, int newChasisNo) throws VehicleValidateException {
//		/ pass by value i.e copy is made
		Vehicle newVehicle = new Vehicle(newChasisNo);
		for (Vehicle v : vehicles) {
			if (v != null)
				if (v.equals(newVehicle))// int->Integer->Object : javac upcasts primitive int to object class as equals
											// take only
//					Object as input
					// ==> duplicate detected --> throw custom exception
					throw new VehicleValidateException("Duplicate No. is Detected");
		}
		System.out.println("No Duplicate detected");
	}

	// add public static method for category validation
	public static void validateCategory(String category) throws VehicleValidateException {
		switch (category.toUpperCase()) {
		case "PETROL":
		case "DIESEL":
		case "EV":
			break;
		default:
			throw new VehicleValidateException("Invalid Category");
		}
	}

	// add static method : to validate manufactureDate : in this financial Year (1st
	// Apr 2021 to 31 Mar 2022)
	public static Date parseAndValidate(String date) throws ParseException, VehicleValidateException {
		// parsing
		Date d1 = sdf.parse(date);
		// => parsing success, proceed to validation
		if (d1.before(startDate) || d1.after(endDate))
			throw new VehicleValidateException("Invalide Date!!!!");
		// =>validation success
		return d1;
	}

	// add static method to invoke all validation rules and throw exception in case
	// of failures or return vehicle instance to the caller
	public static Vehicle validateAllInputs(int chasisNo, String color, double price, String manufactureDate,
			String category, Vehicle[] showroom) throws VehicleValidateException, ParseException{
		checkForDuplicate(showroom, chasisNo);
		Date d1 = parseAndValidate(manufactureDate);
		validateCategory(category);
		
//		=> all i/ps are val;d
		return new Vehicle(chasisNo, color, price, d1, category);
	}
}