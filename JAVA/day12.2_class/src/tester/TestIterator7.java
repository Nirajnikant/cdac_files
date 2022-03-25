package tester;
import static utils.CollectionUtils.populateVehicleList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import com.app.vehicles.Vehicle;

public class TestIterator7 {

	public static void main(String[] args) {
		try {
			// get populated ArrayList<Vehicle>, filled with sample data from another layer(class) : CollectionUtils
			ArrayList<Vehicle> VehicleList = populateVehicleList();
			System.out.println("Original list");
			for(Vehicle v : VehicleList)
				System.out.println(v);
			
			System.out.println("");
			//display list in reverse order  : ListInterator
			//attach ListIterator, after the last element
			ListIterator<Vehicle> vehicleLItr = VehicleList.listIterator(VehicleList.size());//index range 0 - size-1
//			vehicleLItr.next();//NoSuchElementExceptionmain
			System.out.println("Reversed List");
			while(vehicleLItr.hasPrevious())
				System.out.println(vehicleLItr.previous());
			
			System.out.println("Class of ListInerface"+vehicleLItr.getClass());//ArrayList$ListItr

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("main over...");
	}

}
