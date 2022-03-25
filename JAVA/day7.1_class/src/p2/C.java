package p2;
// Will you face ambiguity issue with exact duplicate behaviour? : NO
// because there is only one implementation possible for Duplicate signatures
public class C implements A,B {

	@Override
	public double add(double d1, double d2) {
		return d1+d2;
	}
}