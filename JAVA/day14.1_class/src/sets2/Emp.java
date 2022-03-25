package sets2;

public class Emp {
	private int id;
	private String name;
	private String deptId;
	private double salary;
	public Emp(int id, String name, String deptId, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.salary = salary;
	}
	
//	follow Mandatory + optional part of the contract between overriding of hashcode and equals
//	1. primary key and override equals
	@Override
	public boolean equals(Object o) {
		System.out.println("in emp equals");
		if(o instanceof Emp) {
			Emp e = (Emp) o;
			//rather than making it single field based unique identity we are making multi field based
			return id == e.id && deptId.equals(e.deptId);
			
		}
		return false;
			
	}
	
	@Override
	public int hashCode() {
		System.out.println("in emp's hashCode");
//		whatever unique keys you used in generating the equals method will be used for hashcode
		return 17*(id+deptId.hashCode());//random formula
//		adding prime no. in multiplication improves the performance and ensures separation or uniform distribution of data in buckets 
	}
}
