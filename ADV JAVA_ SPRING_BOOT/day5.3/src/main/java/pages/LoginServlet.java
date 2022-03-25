package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/validate", "/auth" }, loadOnStartup = 3)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	// cannot add SQLException in the throws clause : since overriding form of the
	// method DOES NOT allow any New ChECKED exceptions.
	public void init() throws ServletException {
		// dao instance
		try {
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			// centralized exception handling in servlets
			// javax.servlet.ServletException(String message, Throwable cause)
			throw new ServletException("err in init of" + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// dao's cleanUp
		try {
			userDao.cleanUp();
		} catch (Exception e) {
			// System.out.println("err in destroy of " + getClass() + " err " + e);
			throw new RuntimeException("err in destroy of" + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set response content type
		response.setContentType("text/html");
		// pw
		try (PrintWriter pw = response.getWriter()) {
			// read request data (request parameters) sent from client --> server
			// API of javax.servlet.ServletRequest : public String getParameter(String name)
			// --> dataStructure used -- HashMap
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			// Servlet invokes DAO's method for Authentication
			User user = userDao.authenticateUser(email, password);
			// check the outcome
			if (user == null) // send retry link with err message
				pw.print("<h5>Invalid Login Please <a href = 'login.html'>Retry</a></h5>");
			else {
				// pw.print("<h5> Login Successfull!! :: Message from Login Servlet");
				// in case of successful login, save validated user details under current request scope
				// HOW? request.setAttribute(name, value
				request.setAttribute("user_dtls", user);
				// role based authorization
				if(user.getRole().equals("ADMIN"))
					// How to reirect the client from one servlet to another?
					// Method of javax.servlet.http.HttpServletResponse : public void
					// sendRedirect(String location) throws IOException
					response.sendRedirect("admin");
				else {
					// replaceClientPull(redirect) bu Server pull : javax.servlet.RequestDispatcher 's forward technique
					// Steps 1: create Request Dispatcher object to wrap the next resource(eg. : Topics Page)
					RequestDispatcher rd = request.getRequestDispatcher("topics");
					// include
					rd.include(request, response);
					// WC PAUSES/SUSPENDS execution of this method(doPost) -- DOES NOT EMPTY response buffer -- invokes TopicServlet's doPost
					// doPost --> doGet --> respoonse generation --> control of execution comes back here.
					System.out.println("came back in do-post of "+ getClass());
					pw.print("<h5>sending post-include contents...</h5>");
				}
			}
		} catch (Exception e) {
			throw new ServletException("err in do-post of " + getClass(), e);
		}
	}

}
