package controller.resources;
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
public class ResourcesControllerDelete extends HttpServlet { 
	private final static int FETCH_MAX_RESULTS = 10;
	@SuppressWarnings("unchecked")
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Resource.class.getSimpleName(), new Long(request.getParameter("ID")).longValue());
		Resource c = pm.getObjectById(Resource.class,k);
		Long id=c.getId();
		String idResource = Long.toString(c.getId());
		String query3 = "select from "+ Access.class.getName()+
				" where nameResource=='"+ idResource +"'"+
				" && status==true";
		List<Access> aSearch = (List<Access>)pm.newQuery(query3).execute();
		for(int i = 0; i< aSearch.size(); i++) {
			pm.deletePersistent(aSearch.get(i));
		}
		pm.deletePersistent(c);
		pm.close();
		response.sendRedirect("/resources");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	public static List<Resource> todosLosTutoriales(){
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query query = pm.newQuery(Resource.class);
		query.setRange(0, FETCH_MAX_RESULTS);
		return (List<Resource>) query.execute();
	}
}