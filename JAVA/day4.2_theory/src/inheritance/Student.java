package inheritance;

public class Student extends Person{
//	constructor invocation error
//	when your are in subclass and you are in subclass constructor
//	javac supplies default argument subcalls constructor
//	first statement of this default constructor super()
//	control goes to immediate super class and then if you have gievn some contructor code will compile 
	
	
	//student specific state = non static data members(instance vars) = properties = attributes
	private int gradYear;
	private String courseName;
	private int marks;
	private int fees;
	public Student(String fn, String ln, int yr, String courseName, int marks, int fees) {
		//super(); not desirable!!!!!!!!!!
//		System.out.println("2"); compiler error ::SUPER() must be the first call in the constructor
		super(fn,ln);//invoking explicitly, immediate superclass's MATCHING constructor
		System.out.println("2");
		gradYear = yr;
		this.courseName = courseName;
		this.marks = marks;
		this.fees = fees;
	}
	//getStudentDetails : String : additional behaviour :not required!!!
	//use inherited getDetails and modify it further :YES : method overridding
	public String toString() {
		return "Student " + super.toString()+ " "+gradYear+" course "+courseName+" marks" + marks+" fees " + fees;
	}
}
