package wrappers;


public class Test1 {

	public static void main(String[] args) {
//		Integer i1 = new Integer(100);// boxing :::
		Integer i1 = Integer.valueOf(1234);//boxing (int --> Integer : exp)
		int data = i1.intValue();//un boxing (Integer --> int)
		i1 = 1234;// autoboxing : done by javac i1 = Integer.valueOf(1234);
		data = i1;// auto unboxing : doen by javac data = i1.intValue();
		String s = "45678";
//		s++;
//		Date d1 = new Date();
//		d1 +=1;
		i1++;//i1 is ref type and arithmatic operatiosn are not allowed on ref type vcariables
//		^^auto un boxing (int tmp = i1.intValue()), tmp++, auto boxing i1 = Integer.valueOf(tmp)
		System.out.println(i1);
		double d1 = data;//javac impl : WIDENING (int --> double) 
//		Double d2 = data;// first operation auto boxing data(int) :: int --> Integer --> Double
//		Integer type ref cannot be converted to Double type ref :: Integer and Double are at same hierarchy level
//		can be solved by typecasting
		Double d2 = (double)data;//type of data = int :: type of RHS = double || operation :- int -> double-> Double
//		                                                                                       typecast  autoBoxing
//		d2 = 123.456F;//javac : auto boxing float --> Float ---- Double
		Number n = 123.456F;//double IS-A Number  --javadocs ||auto boxing float --- Float ---Upcasting --> Number
		System.out.println("class loaded"+n.getClass().getName());//java.lang.Float : jvm goes by type of instance/object
		n = 1234.56;//double ---> Double ---> Number
		System.out.println("class loaded"+n.getClass().getName());// java.lang.Double
		Object o = 100;//int/byte --> Integer/Byte --> Object
		System.out.println("class loaded"+o.getClass());
		o = true;//boolean--> Boolean --> Object
		o = "fghgff";//upcasting
		o = 'c';//char--> Character --> Object   1. autoboxing 2. upcasting
		
	}

}
