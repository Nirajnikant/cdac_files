package tester;
import static utils.CollectionUtils.populateVehicleList;

import java.util.ArrayList;
import java.util.Iterator;
import com.app.vehicles.*;

import com.app.vehicles.Vehicle;
//remove all vehicles under dDesel category
public class TestIterator1 {

	public static void main(String[] args) {
		try {
			// get populated ArrayList<Vehicle>, filled with sample data from another layer(class) : CollectionUtils
			ArrayList<Vehicle> VehicleList = populateVehicleList();
			System.out.println("Original List");
			for(Vehicle v : VehicleList)
				System.out.println(v);
			//attach an iterator
			Iterator<Vehicle> vehicleIterator = VehicleList.iterator();
			//iterator  --> before the first element(index = -1)
			while(vehicleIterator.hasNext()) {
				if(vehicleIterator.next().getCategory()==Category1.DIESEL)
					vehicleIterator.remove();
			}
			System.out.println("Filtered List");
			for(Vehicle v : VehicleList)
				System.out.println(v);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("main over...");
	}

}
