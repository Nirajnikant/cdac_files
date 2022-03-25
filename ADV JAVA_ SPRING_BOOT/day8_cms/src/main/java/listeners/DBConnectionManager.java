package listeners;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.DBUtils;

/**
 * Application Lifecycle Listener implementation class DBConnectionManager
 *
 */
@WebListener
public class DBConnectionManager implements ServletContextListener {

//	/**
//	 * Default constructor.
//	 */
//	public DBConnectionManager() {
//		// TODO Auto-generated constructor stub
//	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			DBUtils.closeConnection();
		} catch (SQLException e) {
			System.out.println("err in ctx destoryed "+e);
		}
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// how to get servlet ctx in web app listener? : use ServletContextEvent
		ServletContext ctx = sce.getServletContext();
		// access ctx params from ServletContext : getInitParameter(nm) --> value
		try {
			DBUtils.openConnection(ctx.getInitParameter("db_url"), ctx.getInitParameter("user_name"),
					ctx.getInitParameter("password"));
		} catch (SQLException e) {
			System.out.println("err in ctx inited "+e);
		}
	}

}
