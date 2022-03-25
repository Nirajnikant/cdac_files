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
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 .set cnt type
		response.setContentType("text/html");
		// 2. get PW
		try (PrintWriter pw = response.getWriter()) {
			// 3. get session from WC
			HttpSession session = request.getSession();
			System.out.println("from logout page : session is new ? " + session.isNew());// if cookies enabled : false ,
																							// disabled : true
			System.out.println("session id " + session.getId());// same session id or different ? if cookies enabled :
																// SAME , disabled : NEW
			// how to get user name : getAttribute
			User details = (User) session.getAttribute("user_details");
			if (details != null)
				pw.println("<h5> Hello , " + details.getName() + "</h5>");
			else
				pw.print("<h5> Session Tracking Failed : NEW Session : NO Cookies!!!!!!!!!!!!!!!!!!!!!</h5>");
			// invalidate session
			session.invalidate();
			pw.print("<h5> You have logged out....</h5>");
			// add a link to login again
			pw.print("<h5><a href='login.html'>Visit Again</a></h5>");

		}
	}

}
