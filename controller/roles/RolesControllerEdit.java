package controller.roles;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;
import model.entity.Role;

public class RolesControllerEdit  extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		response.setContentType("text/plain");
		String res =request.getParameter("action");
		if(res != null && request.getParameter("action").equals("edit")) {

			Key k = KeyFactory.createKey(Role.class.getSimpleName(), new Long(request.getParameter("ID")).longValue());
			Role s =  pm.getObjectById(Role.class,k);

			String query = "select from " +
					Role.class + " where accountId =="+request.getParameter("ID");
			s.setName(request.getParameter("name"));
			if(request.getParameter("status") != null) {
				s.setStatus(true);
			}else {
				s.setStatus(false);
			}

			response.sendRedirect("../roles");
			//request.getRequestDispatcher("../WEB-INF/Views/Students/view.jsp").forward(request, response);

		}else {
			Key k = KeyFactory.createKey(Role.class.getSimpleName(), new Long(request.getParameter("ID")).longValue());
			Role s =  pm.getObjectById(Role.class,k);

			String query = "select from " +
					Role.class + " where id =="+request.getParameter("ID");

			request.setAttribute("student", s);

			request.getRequestDispatcher("/WEB-INF/Views/Roles/edit.jsp").forward(request, response);
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

