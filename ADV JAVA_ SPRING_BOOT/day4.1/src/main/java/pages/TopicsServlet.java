package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			// how to retrive user details from a cookie
			// Method of HttpServletRequest : Cookie[] getCookies();
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				// iterate through array
				for(Cookie c : cookies)
					if(c.getName().equals("user_details")) {
						pw.print("Retrived User details from the cookie " + c.getValue());
						break;
					}
			}
			else
				pw.print("<h5> Session Tracking Failed : NO Cookies!!!!!!!</h5>");
		}
	}

}
