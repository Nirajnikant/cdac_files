package inheritance;

public class Faculty extends Person {
	private int expInYrs;
	private String sme;// subject matter expertise
	public Faculty(String firstName,String lastName,int expInYrs ,String sme) {
		super(firstName,lastName);
		System.out.println("3");
		this.expInYrs=expInYrs;
		this.sme=sme;
	}
	//getFacultyDetails : String : new behavior : 	not required!!!!
		//use inherited getDetails n modify it further : YES : method overriding
}
