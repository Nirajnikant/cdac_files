package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/hello", loadOnStartup = 2) // for mapping incoming request/url pattern of the request to a particular
						// servlet
public class HelloWorldServlet extends HttpServlet {
	// key : /hello
	// Value : F.Q servlet class name
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do get of " + getClass() + " invoked by " + Thread.currentThread());
		// set response content type
		// API of HttpServletResponse inherited from ServletResponse
		// Method public void setContentType(String type)
		resp.setContentType("text/html");
		// open the write stream to send response from server ---> client
		// Method of ServletResponse :
		// public PrintWriter getWriter()
		try (PrintWriter pw = resp.getWriter()) {
			// send dynamic response to client
			pw.print("<h5>Welcome 2 Servlets!!!!!!!, Server side Timestamp " + LocalDateTime.now() + "</h5>");
		} //pw.close()  ---> response is sent to client
	}

	@Override
	public void destroy() {
		System.out.println("in destroy of " + getClass() + " invoked by " + Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init of " + getClass() + " invoked by " + Thread.currentThread());
	}
}