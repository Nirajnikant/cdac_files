package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// populate the entry in the request mapping's map
	// key : /test1 value : pages.FirstServlet

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("In init of " + getClass() + " thread : " + Thread.currentThread());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("In destroy of " + getClass() + " thread : " + Thread.currentThread());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");// setting resp header
		// get o/p stream to send resp from server --> client(char, buffered o/p)
		try (PrintWriter pw = response.getWriter()) {
			// send dynamic response : sts code | headers | body
			pw.print("saying hello from " + getClass() + " time stamp " + new Date());
		}// pw.close() --> pw's buffer contents will be sent to the client
		
	}

}
