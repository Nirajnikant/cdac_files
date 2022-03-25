package generic;

//create a Holder class to hold any type of the data type(prim/ref type)
public class Holder<T> {// parameterized class : generic class
//					holder is going to hold T type of reference
	private T reference;//state : heap
	
	public Holder(T reference) {
		super();
		this.reference = reference;
	}
	
	//getter
	public T getReference() {
		return reference;
	}
}