package tester;

import java.util.Date;

import com.app.vehicles.Vehicle;

public class TestVehicle3 {

	public static void main(String[] args) {
		//indirect ref
		Object v1 = new Vehicle(12345, "red", 345678, new Date());
		Object v2 = new Vehicle(12345, "red", 345678, new Date());
		System.out.println(v1 == v2);//ref equality :false
		System.out.println(v1.equals(v2));//true

		Object v3 = null;
		System.out.println(v1.equals(v3));
		String s = "fhsg";
		System.out.println(v1.equals(s));
	}
}