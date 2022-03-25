package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pojos.User;
import utils.HibernateUtils;

class TestUserDaoImpl {
	private static UserDaoImpl dao;
	@BeforeAll
	public static  void init123()
	{
		HibernateUtils.getFactory();
		dao=new UserDaoImpl();
	}

	@Test
	void testAuthenticateUser() {
		User user = dao.authenticateUser("rama@gmail.com", "1234");
		System.out.println(user);
		assertEquals(1, user.getId());
		assertEquals("ADMIN", user.getRole());
	}
	
	@AfterAll
	public static void destroy123()
	{
		HibernateUtils.getFactory().close();
	}

}
