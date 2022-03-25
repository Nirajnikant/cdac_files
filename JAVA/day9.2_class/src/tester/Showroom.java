package tester;

import java.util.Date;
import java.util.Scanner;

import com.app.vehicles.Vehicle;
import static utils.VehicleValidatationRules.validateAllInputs;
import custom_exception.VehicleValidateException;

public class Showroom {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the capacity :");
			Vehicle[] vehicles = new Vehicle[sc.nextInt()];
			int counter = 0;
			boolean exit = false;
			while(!exit) {
				System.out.printf("Options\n1. Add Vehicle\n2. Display all\n3. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						if(counter < vehicles.length) {
							System.out.println("Enter Vehicle details : chasisNo, color, price, manufactureDate, category");
							Vehicle v1 = validateAllInputs(sc.nextInt(), sc.next(), sc.nextDouble(), sc.next(), sc.next(), vehicles);
//							==> validation success
							vehicles[counter++] = v1;
							System.out.println("vehicle added to the showroom");
						}
						else
							throw new VehicleValidateException("SHOWROOM FULL!!!!!!!");
						break;
					case 2:
						for(Vehicle v : vehicles) {
							if(v != null)
								System.out.println(v);
						}
							
						break;
					case 3:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}