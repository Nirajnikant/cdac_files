package p4;
//Same signature same method name different return type: NO 
// Because compiler resolves method by method signature and as here signature of both methods are
/// same they are creating ambiguity
public class C implements A,B {

	@Override
	public double add(double d1, double d2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int add(double d1, double d2) {
		// TODO Auto-generated method stub
		return 0;
	}

}