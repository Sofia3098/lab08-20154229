package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;
import model.entity.Role;
import model.entity.User;

public class UsersControllerEdit extends HttpServlet{
	private final static int FETCH_MAX_RESULTS = 10;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		String res =request.getParameter("action");
		if(res != null && request.getParameter("action").equals("edit")) {
			List<Role> roles = todosLosTutoriales2();

			Key k = KeyFactory.createKey(User.class.getSimpleName(), new Long(request.getParameter("ID")).longValue());
			User s =  pm.getObjectById(User.class,k);

			Role r = null;
			for (int i =0; i < roles.size();i++) {
				r = (Role)roles.get(i);
				if(r.getName().equals(request.getParameter("role"))) {
					break;
				}
			}
			String rol = Long.toString(r.getId());
			s.setEmail(request.getParameter("email"));
			s.setRole(rol);
			s.setBirth(request.getParameter("date"));
			s.setGender(request.getParameter("gender"));
			 boolean activo;
			 if(request.getParameter("status")!= null) {
				 activo = true;
			 }else {
				 activo = false;
			 }
			s.setStatus(activo);
			
			if(request.getParameter("status") != null) {
				s.setStatus(true);
			}else {
				s.setStatus(false);
			}

			response.sendRedirect("../users");

		}else {
			Key k = KeyFactory.createKey(User.class.getSimpleName(), new Long(request.getParameter("ID")).longValue());
			User s =  pm.getObjectById(User.class,k);
			List<Role> roles = todosLosTutoriales2();
			Role role = null;
			for(int i = 0; i < roles.size(); i++) {
				role = (Role)roles.get(i);
				String r = Long.toString(role.getId());
				if(r.equals(s.getRole())) {
					break;
				}
			}
			request.setAttribute("student", s);
			request.setAttribute("role", role);
			request.setAttribute("showAllRoles", roles);
			request.getRequestDispatcher("/WEB-INF/Views/Users/edit.jsp").forward(request, response);
		}
	}
	public static List<Role> todosLosTutoriales2(){
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query query = pm.newQuery(Role.class);
		query.setRange(0, FETCH_MAX_RESULTS);
		return (List<Role>) query.execute();
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
