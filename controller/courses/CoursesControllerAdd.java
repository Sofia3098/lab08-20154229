package controller.courses;
import java.util.*;
import java.io.IOException;  
import java.io.PrintWriter;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jws.WebService;
import javax.servlet.*;  
import javax.servlet.http.*;

import controller.PMF;
import model.entity.Course;
@SuppressWarnings("serial")

public class CoursesControllerAdd extends HttpServlet {  
	private final static int FETCH_MAX_RESULTS = 10;
	@SuppressWarnings("unchecked")
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String res = request.getParameter("action");
		boolean igual= false;
		if(res != null && request.getParameter("action").equals("create")) {
			List<Course>courses=todosLosTutoriales();
			String condicion="";
			for(int i = 0; i<courses.size();i++) {
				 Course s = (Course) courses.get(i);
				 if(s.getName().equals(request.getParameter("name"))) {
					 condicion= "name";
					 igual = true;
					 break;
				 }else if(s.getDepa().equals(request.getParameter("depa"))) {
					 condicion = "depa";
					 igual = true;
					 break;
				 }else if(s.getNivel().equals(request.getParameter("nivel"))){
					 condicion = "nivel";
					 igual = true;
					 break;
				 }
			 }
			if(!igual) {
				Course nuevo=new Course(
						request.getParameter("name"),
						request.getParameter("depa"),
						request.getParameter("nivel"),
						request.getParameter("profe"),
						request.getParameter("hab")); 
				try {
					pm.makePersistent(nuevo);
				}finally {
					pm.close();
				}
				response.sendRedirect("/courses");
			 }else{
				 request.setAttribute("condicion", condicion);
				 request.getRequestDispatcher("../WEB-INF/Views/Cursos/view.jsp").forward(request, response);
			 }
			
		}else {
			
			request.getRequestDispatcher("../WEB-INF/Views/Cursos/add.jsp").forward(request, response);
		}

		
	}  
	public static List<Course> todosLosTutoriales(){
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query query = pm.newQuery(Course.class);
		query.setRange(0, FETCH_MAX_RESULTS);
		return (List<Course>) query.execute();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	     processRequest(request, response);
	 } 
	 
	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	     processRequest(request, response);
	 }

}