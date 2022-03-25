package utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

//creates singleton immutable heavy weight, inherently thread safe SessionFactory object
public class HibernateUtils {
	private static SessionFactory factory;
	static {
		System.out.println("In static init block");
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}
}