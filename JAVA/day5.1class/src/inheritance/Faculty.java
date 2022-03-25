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
	public String toString() {
		return "Faculty"+super.toString()+this.expInYrs+" "+this.sme;
	}
	
	//add new func : teach : firstName teaching courses under sme
	public void teach() {
		System.out.println(getFirstName()+" teaching courses under "+ sme);
//							^implicitly super.getFirstName() 
	}
}
