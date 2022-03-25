package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;

/**
 * Servlet implementation class TopicsServlet
 */
@WebServlet("/topics")
public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw =  response.getWriter()) {
			pw.print("<h4>Welcome Customer....<h4>");
			// how to retrive user details from a HttpSession ? 
			// Method of HttpSession :
			// Object getAttribute(String attributeName)
			HttpSession hs = request.getSession();
			System.out.println("from topics page : session is new? " + hs.isNew()); //true or false : depends 
																						// if cookies enabled : false
																						// if cookie is disabled : true
			System.out.println("session id " + hs.getId()); // same session id or different  ^^^^same case
																	// if cookies enabled : SAME
																	// if cookie is disabled : NEW SESSION ID			

			User user123 = (User)hs.getAttribute("user_details");
			if(user123 != null)
				pw.print("<h5> User Details reterived from Session Object " + user123 + "</h5>");
			else
				pw.print("<h5> Session Tracking Failed : NO Cookies!!!!!!!</h5>");
				// add a link(temp) to logout the user
			pw.print("<h5> <A href='logout'>Log Me Out</a></h5>");
		}
	}

}
