package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TopicDaoImpl;
import pojos.Topic;
import pojos.User;

/**
 * Servlet implementation class TopicsServlet
 */
@WebServlet("/topics")
public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h4>Welcome Customer....</h4>");
			// how to retrieve user details from a HttpSession ?
			// Method of HttpSession :
			// Object getSAttribute(String attributeName)
			// step 1 : get session from WC
			HttpSession hs = request.getSession();
			System.out.println("from topics page : session is new ? " + hs.isNew());// if cookies enabled : false ,
																					// disabled : true
			System.out.println("session id " + hs.getId());// same session id or different ? if cookies enabled : SAME ,
															// disabled : NEW
			User user123 = (User) hs.getAttribute("user_details");
			if (user123 != null) {
				pw.print("<h5> User details retrieved from session " + user123 + "</h5>");
				// get topic dao instance from session scope
				TopicDaoImpl dao = (TopicDaoImpl) hs.getAttribute("topic_dao");
				// invoke topic dao's method to get all topics
				List<Topic> topics = dao.getAllTopics();
				// dyn form generation

				pw.print("<form action='tutorials'>");
				for (Topic t : topics)
					pw.print("<input type='radio' name='topic_id' value='" + t.getTopicId() + "' />" + t.getTopicName()
							+ "<br/>");
				pw.print("<input type='submit' value='Choose A Topic'/>");
				pw.print("</form>");
			}

			else
				pw.print("<h5> Session Tracking Failed : NEW Session : NO Cookies!!!!!!!!!!!!!!!!!!!!!</h5>");
		

		} catch (Exception e) {
			throw new ServletException("err in do-get of " + getClass(), e);
		}
	}

}
