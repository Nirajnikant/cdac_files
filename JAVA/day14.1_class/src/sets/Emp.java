package sets;

public class Emp {
	private String id;
	private String name;
	private double salary;
	
	
	public Emp(String id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}		
	
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		System.out.println("in emp's equals");
		if(o instanceof Emp) 
			return this.id == ((Emp)o).id;
		return false;
	}
	
	@Override
	public int hashCode() {
		System.out.println("in hashCode");
		return id.hashCode();//100 not special anything can be added in place og it
//		id is of string type therefore it calls string's .hash method where 
//		hashcode is not based on address but on the character sequences  : check stirng.hashcode
	}
}