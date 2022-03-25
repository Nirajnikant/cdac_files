package tester;
import static utils.CollectionUtils.populateVehicleList;

import java.util.ArrayList;
import java.util.Iterator;

import com.app.vehicles.Category1;
import com.app.vehicles.Vehicle;

public class TestIterator5 {

	public static void main(String[] args) {
		try {
			// get populated ArrayList<Vehicle>, filled with sample data from another layer(class) : CollectionUtils
			ArrayList<Vehicle> VehicleList = populateVehicleList();
			//attach an iterator
//			Iterator<Vehicle> vehicleIterator = VehicleList.iterator();
//			while(vehicleIterator.hasNext()) {
//				if(vehicleIterator.next().getCategory() == Category1.DIESEL)
//					vehicleIterator.remove();
//				
//			}
			for(Vehicle v : VehicleList)
				if(v.getCategory() ==  Category1.DIESEL)
					VehicleList.remove(v);
			System.out.println("Filtered list");
			for(Vehicle v : VehicleList)
				System.out.println(v);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("main over...");
	}

}
