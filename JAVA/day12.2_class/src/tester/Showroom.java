package tester;

import static utils.VehicleValidationRules.*;

import java.util.ArrayList;
import java.util.Scanner;

import com.app.vehicles.Vehicle;

public class Showroom {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			//create empty ArrayList to hold Vehicle type reference.
			ArrayList<Vehicle> vehicles = new ArrayList<>();//size = 0; capacity = 10;
			boolean exit = false;
			while(!exit) {
				System.out.printf("Options \n1. Add Vehicle \n2. Display all\n3. Fetch Vehicle details\n4. Update vehicle Price\n"
						+ "5. Delete vehicle details\n6. Apply discount\n7. Purchase a vehicle\n"
						+ "8. Display vehicle chasis no and price based on city\n10.Exit");
				try {
					switch(sc.nextInt()) {
					case 1://add a vehicle
						System.out.println(
								"Enter Vehicle details : chasisNo,  color,  price,  manufactureDate, category");
						Vehicle v1 = validateAllInputs(sc.nextInt(), sc.next(), sc.nextDouble(), sc.next(),
								sc.next(), vehicles);
						//=> success
						vehicles.add(v1);
						System.out.println("vehicle added to the showroom");
						break;
					case 2://display alll vehicles
						for(Vehicle v : vehicles)
							System.out.println(v);
						break;
					case 3://Fetch Vehicle details from AL
						System.out.println("Enter the chasis no.");
						System.out.println(findByChasisNo(sc.nextInt(), vehicles));
						break;
						
					case 4:// update vehicle Price
						System.out.println("Enter chasis no. and price");
						System.out.println(updatePrice(sc.nextInt(), sc.nextDouble(), vehicles));
						System.out.println("Vehicle price update");
						break;
						
					case 5://Delete vehicle details
						//2nd way get index from findbychasis then remove by index :: indexOf + removed
						System.out.println("To delete the vehicle Enter Chasis No.");
						Vehicle v = new Vehicle(sc.nextInt());
//						deleteVehicle(sc.nextInt(), vehicles);
						System.out.println("Vehicle removed"+vehicles.remove(v));
						break;
						
					case 6://Apply discount to all vehicles manufactured before a specific date and category
						System.out.println("Enter date and category to apply discount: ");
						discount(sc.next(),sc.next(), vehicles);
						System.out.println("Discount applied");
						break;
					
					case 7://Purchase a vehicle
						System.out.println("Enter chasis no. to check availability");
						Vehicle v2 = purchase(sc.nextInt(), vehicles);
//						Vehicle v2 = findByChasisNo(sc.nextInt(), vehicles);
//						System.out.println(v2);
//						System.out.println("is availabe");
						System.out.println("Enter Delivery address : city, state, country, zpiCode");
						v2.assignDeliveryAddress(sc.next(), sc.next(), sc.next(), sc.next());
						System.out.println(v2);
						break;
						
					case 8: //Display vehicle chasis no n price  ,of all the vehicles dispatched to a specific city
						System.out.println("Enter name of the city :");
						System.out.println(findByCity(sc.next(),vehicles));
						break;
						
					case 10:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//to read off pending tokens from the scanner : till end of the line
				sc.nextLine();
			}
		}

	}

}
