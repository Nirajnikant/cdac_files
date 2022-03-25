package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		// start SC in Java SE , using xml based instructions(meta data) , placed in run
		// time cls path (eg : src/main/resources)
		try(ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("bean-config.xml"))
		{
			System.out.println("SC started...");
			//get ready-to-use atm bean to exec B.L from SC
			ATMImpl bean1=ctx.getBean("my_atm", ATMImpl.class);
			//B.L
			bean1.deposit(12345);
			ATMImpl bean2=ctx.getBean("my_atm", ATMImpl.class);
			System.out.println(bean1 == bean2);
			
		} //ctx.close => shutting of SC -- SC chks for singleton beans --if destroy-method is present --invokes it.
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
