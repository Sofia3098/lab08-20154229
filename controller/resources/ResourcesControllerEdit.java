package controller.resources;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;
import model.entity.Resource;

public class ResourcesControllerEdit  extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		response.setContentType("text/plain");
		String res =request.getParameter("action");
		if(res != null && request.getParameter("action").equals("edit")) {

			Key k = KeyFactory.createKey(Resource.class.getSimpleName(), new Long(request.getParameter("ID")).longValue());
			Resource s =  pm.getObjectById(Resource.class,k);

			String query = "select from " +
					Resource.class + " where accountId =="+request.getParameter("ID");
			s.setName(request.getParameter("name"));
			if(request.getParameter("status") != null) {
				s.setStatus(true);
			}else {
				s.setStatus(false);
			}
			response.sendRedirect("../resources");

		}else {
			Key k = KeyFactory.createKey(Resource.class.getSimpleName(), new Long(request.getParameter("ID")).longValue());
			Resource s =  pm.getObjectById(Resource.class,k);

			String query = "select from " +
					Resource.class + " where id =="+request.getParameter("ID");

			request.setAttribute("resource", s);

			request.getRequestDispatcher("/WEB-INF/Views/Resources/edit.jsp").forward(request, response);
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


