package controller.access;
import model.entity.*;  
import java.util.*;
import java.io.IOException;  
import java.io.PrintWriter;

import javax.jdo.PersistenceManager;
import javax.jws.WebService;
import javax.servlet.*;  
import javax.servlet.http.*;
import com.google.appengine.api.datastore.Key;
import javax.jdo.Query;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;  
@SuppressWarnings("serial")
public class AccessControllerDelete extends HttpServlet {  
	@SuppressWarnings("unchecked")
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Access.class.getSimpleName(), new Long(request.getParameter("ID")).longValue());
		Access c = pm.getObjectById(Access.class,k);
		pm.deletePersistent(c);
		pm.close();
		response.sendRedirect("/access");
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