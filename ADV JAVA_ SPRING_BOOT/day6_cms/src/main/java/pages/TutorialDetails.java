package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TutorialDaoImpl;
import pojos.Tutorial;

/**
 * Servlet implementation class TutorialDetails
 */
//URL : http://localhost:9090/day5_cms/tutorial_details?tut_name=Spring%20Core
@WebServlet("/tutorial_details")
public class TutorialDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type
		response.setContentType("text/html");
		// get PW
		try (PrintWriter pw = response.getWriter()) {
			// get selected tut name from request param
			String tutorialName = request.getParameter("tut_name");
			// get session from WC , to get tut dao
			HttpSession session = request.getSession();
			// get tut dao from HS
			TutorialDaoImpl tutDao = (TutorialDaoImpl) session.getAttribute("tut_dao");
			// null chking
			if (tutDao != null) {
				//invoke tut dao's method : update --> get tut details
				System.out.println("status : "+tutDao.updateVisits(tutorialName));
				//get updated tut details
				Tutorial tutorial = tutDao.getTutorialDetails(tutorialName);
				pw.print("<h5>"+tutorialName+"</h5>");
				pw.print("<h5> Author Name "+tutorial.getAuthor()+"</h5>");
				pw.print("<h5> Published on  "+tutorial.getPublishDate()+"</h5>");
				pw.print("<h5> Visits "+tutorial.getVisits()+"</h5>");
				pw.print("<h5> Contents  "+tutorial.getContents()+"</h5>");
				//back link
				pw.print("<h5><a href='tutorials?topic_id="+tutorial.getTopicId()+"'>Back</a></h5>");
				
				
			} else
				pw.print("<h5> Session Tracking Failed :  NO Cookies!!!!!!!!!!!!!!!!!!!!!</h5>");
			// add a link  to log out the user
			pw.print("<h5><a href='logout'>Log Me Out</a></h5>");

		} catch (Exception e) {
			throw new ServletException("err in do-get of "+getClass(), e);
		}

	}

}
