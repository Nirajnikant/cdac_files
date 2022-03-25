package method_overloading;
class Test3 
{
	public static void main(String[] args) 
	{
		test(null);
	}
	
//	compiler goes for narrowest match
	static void test(Object o)
	{
		System.out.println("in obj version");
	}
	static void test(String o)
	{
		System.out.println("in string version");
	}

//	un commenting scanner method it gives error because of ambiguity as 
//	String and Scanner are not in hiearchy
	
//	static void test(Scanner o)
//	{
//		System.out.println("in scanner version");
//	}
	
	static void test(Integer o)
	{
		System.out.println("in scanner version");
	}
}
