package inheritance;

public class Person {
	private String firstName,lastName;
	public Person(String firstName, String lastName) {
		//super();
		System.out.println("1");
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
//	public Person() {
//		
//	}
	//getDetails :fn ln
	//simply override(modify), existing inherited func : to replace adr ret
	//version by actual details of the object
	public String toString() {
		return firstName+" "+lastName;
	}
}