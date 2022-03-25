package tester;

import com.app.vehicles.DeliveryAddress;

public class Test2 {

	public static void main(String[] args) {
		DeliveryAddress address = new DeliveryAddress("Mh", "MG", "IN", "453678");//=> aggregation between Vehicle and Deliver Address
	
	// replace aggregation by Composition where : 3rd party code should nt be allowed to create the address instance without enclosing owning/enclosing entity : Vehicle
	// in core java : nested classes 
//	   in hibernate : will be done using annotation (@Embeddable)
	}

}
