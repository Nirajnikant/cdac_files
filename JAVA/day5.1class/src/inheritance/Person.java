package inheritance;

public class Person {
	private String firstName, lastName;

	public Person(String firstName, String lastName) {
		// super();
		System.out.println("1");
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// simply override (modify) , existing inherited func : to replace adr ret
	// version by actual details of the Person
	public String toString() {
		return firstName + " " + lastName;
	}
	
	//add a getter : to get last name of a person
	public String getLastName() {
		return this.lastName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
}
