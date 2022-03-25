package exc_handling;

public class TestUncheckedException {

	public static void main(String[] args) {
		String s = "abc12345";
		System.out.println("int value "+ Integer.parseInt(s));// exc : NumberFormatExc : un-checked exc :since 
															// extends RunTimeExc : javc Does NOT force handling
															// of unchecked err
		System.out.println("main over...");
	}

}
