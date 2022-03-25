package tester;
import static utils.CollectionUtils.populateVehicleList;

import java.util.ArrayList;
import java.util.Iterator;

import com.app.vehicles.Vehicle;

public class TestIterator3 {

	public static void main(String[] args) {
		try {
			// get populated ArrayList<Vehicle>, filled with sample data from another layer(class) : CollectionUtils
			ArrayList<Vehicle> VehicleList = populateVehicleList();
			//attach an iterator
			Iterator<Vehicle> vehicleIterator = VehicleList.iterator();
			while(vehicleIterator.hasNext()) {
				System.out.println(vehicleIterator.next());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("main over...");
	}

}
