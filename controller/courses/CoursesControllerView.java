package controller.courses;
import model.entity.Course;

import java.util.*;
import java.io.IOException;  
import java.io.PrintWriter;
import com.google.appengine.api.datastore.Key;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jws.WebService;
import javax.servlet.*;  
import javax.servlet.http.*;

import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;  
@SuppressWarnings("serial")
public class CoursesControllerView extends HttpServlet {  
	private final static int FETCH_MAX_RESULTS = 10;
	@SuppressWarnings("unchecked")
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String res =request.getParameter("action");
		//String res =request.getParameter("id");
		Key k = KeyFactory.createKey(Course.class.getSimpleName(), new Long(request.getParameter("ID")).longValue());
		Course s =  pm.getObjectById(Course.class,k);
			
					
			request.setAttribute("course", s);
			
			request.getRequestDispatcher("../WEB-INF/Views/Cursos/view.jsp").forward(request, response);

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	} 

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	public static List<Course> todosLosTutoriales(){
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query query = pm.newQuery(Course.class);
		query.setRange(0, FETCH_MAX_RESULTS);
		return (List<Course>) query.execute();
	}
}