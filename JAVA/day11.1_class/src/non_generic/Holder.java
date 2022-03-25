package non_generic;

//create a Holder class to hold any type of the data type(prim/ref type)
public class Holder {
	private Object reference;//state : heap
	public Holder(Object reference) {
		super();
		this.reference = reference;
	}
	public Object getReference() {
		return reference;
	}
}