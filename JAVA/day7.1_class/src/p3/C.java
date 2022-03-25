package p3;
//Same method name with different signatures
//---needs to implement all the interfaces methods as compiler resolves methods
// by method signature so method are totally different from each other
public class C implements A,B {

	@Override
	public double add(double d1, double d2) {
		
		//Will you face ambiguity issue with duplicate data members ? YES 
//		System.out.println(DATA); field data is ambigious
		System.out.println(A.DATA+" "+B.DATA);
		return d1+d2;
	}

	@Override
	public double add(int d1, int d2) {
		// TODO Auto-generated method stub
		return d1+d2;
	}
	
	
}