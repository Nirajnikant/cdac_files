package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TopicDaoImpl;
import dao.UserDaoImpl;
import pojos.User;
import utils.DBUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/validate", "/auth" }, loadOnStartup = 3)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	private TopicDaoImpl topicDao;

	/**
	 * @see Servlet#init()
	 */
	// Can't add SqlException in the throws clause : since overrding form of the
	// method DOES NOT allow any NEW CHECKED excs.
	public void init() throws ServletException {
		// dao instance
		try {
			DBUtils.openConnection();
			userDao = new UserDaoImpl();
			topicDao=new TopicDaoImpl();
		} catch (Exception e) {
			// centralized exc handling in servlets
			// javax.servlet.ServletException(String mesg,Throwable cause)
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// dao's cleanup
		try {
			userDao.cleanUp();
			topicDao.cleanUp();
			DBUtils.closeConnection();
		} catch (Exception e) {
			// System.out.println("err in destroy of "+getClass()+" err "+e);
			throw new RuntimeException("err in destroy of " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set resp cont type
		response.setContentType("text/html");
		// pw
		try (PrintWriter pw = response.getWriter()) {
			// read request data (req parameters) sent ffrom clnt ---> server
			// API of javax.servlet.ServletRequest : public String getParameter(String name)
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			// Servlet invokes DAO's for authentication
			User user = userDao.authenticateUser(email, password);
			// chk the outcome
			if (user == null) // send retry link with err mesg
				pw.print("<h5> Invalid Login Please <a href='login.html'>Retry</a></h5>");
			else {
				// pw.print("<h5> Login Successful : mesg from LoginServlet </h5>");
				// in case of successful login , request WC to get HttpSession object.
				// API of HttpServletRequest : HttpSession getSession()
				HttpSession session = request.getSession();
				System.out.println("from login : session is new ? " + session.isNew());// true
				System.out.println("session id "+session.getId());
				System.out.println("session's imple class " + session.getClass());// catatlina jar
				// WC creates EMPTY session obj in WC's heap n creates a cookie
				// name : JSESSIONID value : string generated by WC / clnt eg : dgadf65765dhf
				/*
				 * 2. : How to save data in HttpSession?(scope=entire session) API of
				 * HttpSession i/f public void setAttribute(String attrName,Object attrVal)
				 * 
				 */
				session.setAttribute("user_details", user);
				//add dao instances under session scope
				session.setAttribute("user_dao", userDao);
				session.setAttribute("topic_dao", topicDao);			

				// role based authorization
				if (user.getRole().equals("ADMIN"))
					// How to redirect the clnt from one servelt to another ?
					// Method of javax.servlet.http.HttpServletResponse : public void
					// sendRedirect(String location) throws IOExc
					response.sendRedirect("admin");
				else
					response.sendRedirect("topics");// WC temp redirect resp : SC 302 | Location : topics, set-cookie :
													// cookie : JSESSIONID : gfdjg687466 | Body : EMPTY
				// clnt browser chks for privacy settings --cookies enabled --age =-1 => cookie
				// will be stored in the browser's cache.
				// clnt browser sends NEXT redirect request : method =GET , URL :
				// http://host:port/day4.1/topics
				// req header : cookie : JSESSIONID : gfdjg687466
			}

		} catch (Exception e) {
			throw new ServletException("err in do-post of " + getClass(), e);
		}
	}

}
