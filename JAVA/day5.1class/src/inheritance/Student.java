package inheritance;

public class Student extends Person{
	//student specific state =non static data members(instance vars) =properties =attributes
	private int gradYear;
	private String courseName;
	private int marks;
	private int fees;
	public Student(String fn,String ln,int yr,String courseName,int marks,int fees) {
		super(fn,ln);//invoking explicitly ,immediate super cls' MATCHING ctor.
		System.out.println("2");
		gradYear=yr;
		this.courseName=courseName;
		this.marks=marks;
		this.fees=fees;
		
	}
//  is it possoble to : toString inherited from Person n modify it further : YES : method overriding
	public String toString()
	{
		return "Student " +super.toString()+" "+gradYear+" course "+courseName+"  marks "+marks+" fees "+fees;
	}
	
	//add student specific func : "study" : prints : last name of student studying in coursename
	public void study() {
		System.out.println(getLastName()+"  of student studying in "+courseName);
						//	^ not mandatory to use super.getLastName() as it first looks in the first class and then looks in the parent class
	}
}
