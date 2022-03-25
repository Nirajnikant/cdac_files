package sorting;
import static utils.CollectionUtils.populateVehicleList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import com.app.vehicles.*;

import com.app.vehicles.Vehicle;

import custom_ordering.VehicleDatePriceComparator;
import custom_ordering.VehiclePriceDescComparator;
//Print vehicle details sorted as per chasis no
public class TestISorting3 {

	public static void main(String[] args) {
		try {
			// get populated ArrayList<Vehicle>, filled with sample data from another layer(class) : CollectionUtils
			ArrayList<Vehicle> vehicleList = populateVehicleList();
			//display ordered list
			System.out.println("Ordered List");
			for(Vehicle v : vehicleList)
				System.out.println(v);
//			NATURAL 
//			Collections.sort(vehicleList);//earlier :  Vehicle is not comparable
//			javac error since Vehicle is not yet comparable

			
//			custom ordering
//			api of collections class
//			public static void sort(List<T> list, Comparator<T> comp)
			Collections.sort(vehicleList, new VehicleDatePriceComparator());
			//sort(...) will implicitly call VehicleDatePriceComparator' compare
			
			System.out.println("VehicleList List sorted as per price (desc)");
			for(Vehicle v : vehicleList)
				System.out.println(v);
			} catch (Exception e) {
				e.printStackTrace();
			}
		System.out.println("main over...");
	}
}