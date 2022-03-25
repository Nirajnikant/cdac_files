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

import dao.TutorialDaoImpl;

/**
 * Servlet implementation class TutorialsServlet
 */
//URL : http://host:port/day5_cms/tutorials?topic_id=4
@WebServlet("/tutorials")
public class TutorialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set cont type
		response.setContentType("text/html");
		//get writer
		try(PrintWriter pw=response.getWriter())
		{
			//get topic id from req parameter
			int topicId=Integer.parseInt(request.getParameter("topic_id"));
			pw.print("<h3>Tutorials under Topic ID "+topicId+"</h3>");
			//get HttpSession from WC , to get existing tut dao instance
			HttpSession session=request.getSession();
			// get existing tut dao instance from session scope
			TutorialDaoImpl tutDao=(TutorialDaoImpl)session.getAttribute("tut_dao");
			//chk for null
			if(tutDao != null)
			{
				//invoke dao's method to get all tut names exsiting under chosen topic
				List<String> tutorialNames = tutDao.getTutorialsByTopicId(topicId);
				//attach iterator(for-each) generate the links
				for(String s : tutorialNames)
					pw.print("<h5><a href='tutorial_details?tut_name="+s+"'>"+s+"</a></h5>");
				
			}
			else
				pw.print("<h5> Session Tracking Failed :  NO Cookies!!!!!!!!!!!!!!!!!!!!!</h5>");
		
			
			
		} catch (Exception e) {
			throw new ServletException("err in do-get of "+getClass(), e);
		}
	}

}
