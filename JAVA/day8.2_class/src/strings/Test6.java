package strings;

public class Test6 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("hello");//2 objects created
//		1 "hello" in literal string pool,, 2 string builder obj in ordinary in heap
		System.out.println("contents"+sb+" len "+sb.length()+" capa "+sb.capacity());
		//hello, 5+16=21
		sb.append(true);//applied onsame copy of stringBuilder
		sb.append(123.456);
		System.out.println(sb);
		sb.append(34).append(false).append(new char[] {'a','v','n'});
		System.out.println(sb);
		System.out.println("contents"+sb+" len "+sb.length()+" capa "+sb.capacity());//dynamically memory reallocated : only 21 character allowed initially\
		StringBuilder sb2 = sb.insert(0,  'z');
		System.out.println(sb);//z....
		System.out.println(sb2);//z....
		System.out.println(sb==sb2);//true :: no new object is created both are referring to the same object :Because both are pointing to same StingBuilder Object
		System.out.println(sb.equals(sb2));//true : ref equality : cause equals method is not overridden from OBjects class, it is as it in Object class
		StringBuilder sb3 = new StringBuilder("123456");
		StringBuilder sb4 = new StringBuilder("123456");
//		two different objects are created
		System.out.println(sb3 == sb4);//false : different ref address
		System.out.println(sb3.equals(sb4));//false : ref equality

	}

}
