package controller.courses;
import model.entity.Access;
import model.entity.Course;
import model.entity.Resource;
import model.entity.User;

import java.util.*;
import java.io.IOException;  
import java.io.PrintWriter;

import javax.jdo.PersistenceManager;
import javax.jws.WebService;
import javax.servlet.*;  
import javax.servlet.http.*;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
@SuppressWarnings("serial")
public class CoursesControllerEdit extends HttpServlet {  
	@SuppressWarnings("unchecked")
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		com.google.appengine.api.users.User ugGoogle = UserServiceFactory.getUserService().getCurrentUser();
		String query1 = "select from "+ User.class.getName() +
				" where email=='"+ugGoogle.getEmail()+"'" +
				" && status==true";
		List<User> uSearch = (List<User>)pm.newQuery(query1).execute();
		String query2 = "select from "+ Resource.class.getName() +
				" where name=='" + request.getServletPath() + "'"+
				" && status==true";
		List<Resource> rSearch = (List<Resource>) pm.newQuery(query2).execute();
		if(rSearch.isEmpty()) {
			String error = "sinPermisoEdit";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/WEB-INF/Views/Errors/deny.jsp").forward(request, response);
		}else {
			String IDResource = Long.toString(rSearch.get(0).getId());
			String query3 = "select from "+ Access.class.getName()+
					" where nameRole=='"+uSearch.get(0).getRole() +"'"+
					" && nameResource=='"+ IDResource+"'"+
					" && status==true";
			List<Access> aSearch = (List<Access>)pm.newQuery(query3).execute();
			if(aSearch.isEmpty()) {
				String error = "sinAccesoEdit";
				request.setAttribute("error", error);
				request.getRequestDispatcher("/WEB-INF/Views/Errors/deny.jsp").forward(request, response);
			}else{
				String res = request.getParameter("action");
				if(res != null && request.getParameter("action").equals("edit")) {
					Key k = KeyFactory.createKey(Course.class.getSimpleName(), new Long(request.getParameter("ID")).longValue());
					Course c = pm.getObjectById(Course.class,k);
					c.setName(request.getParameter("name"));
					c.setDepa(request.getParameter("depa"));
					c.setNivel(request.getParameter("nivel"));
					c.setProfe(request.getParameter("profe"));
					c.setHab(request.getParameter("hab"));
					response.sendRedirect("/courses");
				}else {
					Key k = KeyFactory.createKey(Course.class.getSimpleName(), new Long(request.getParameter("ID")).longValue());
					Course c =  pm.getObjectById(Course.class,k);
					String query = "select from " +
							Course.class + " where id =="+request.getParameter("Id");
					request.setAttribute("course", c);
					request.getRequestDispatcher("../WEB-INF/Views/Cursos/edit.jsp").forward(request, response);
				}
			}
		}
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			processRequest(request, response);
		} 

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			processRequest(request, response);
		}  
	}
