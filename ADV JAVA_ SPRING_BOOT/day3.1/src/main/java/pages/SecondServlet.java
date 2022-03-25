package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@Override
	public void init() throws ServletException {
		System.out.println("in init of " + getClass() + " invoked by " + Thread.currentThread());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set cont type
		response.setContentType("text/html");
		//get writer : PW : for sending char data.
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("<h4>Testing servlet deployed using xml "+new Date()+"</h4>");
		}
	}

}
