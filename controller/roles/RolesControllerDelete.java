package controller.roles;

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
import model.entity.Access;
import model.entity.Role;
import model.entity.User;

public class RolesControllerDelete extends HttpServlet{
	private final static int FETCH_MAX_RESULTS = 10;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Role.class.getSimpleName(), new Long(request.getParameter("ID")).longValue());
		Role s =  pm.getObjectById(Role.class,k);
		if(s.getName().equalsIgnoreCase("Administrador")) {
			String error = "deleteA";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/WEB-INF/Views/Errors/deny.jsp").forward(request, response);
		}else {
			Long id = s.getId();
			String idRole = Long.toString(s.getId());
			String query1 = "select from "+ User.class.getName() +
					" where role=='"+ idRole+"'" +
					" && status==true";
			List<User> uSearch = (List<User>)pm.newQuery(query1).execute();
			for(int i = 0; i< uSearch.size(); i++) {
				pm.deletePersistent(uSearch.get(i));
			}
			String query3 = "select from "+ Access.class.getName()+
					" where nameRole=='"+ idRole +"'"+
					" && status==true";
			List<Access> aSearch = (List<Access>)pm.newQuery(query3).execute();
			for(int i = 0; i< aSearch.size(); i++) {
				System.out.println(aSearch.get(i));
				pm.deletePersistent(aSearch.get(i));
			}
			pm.deletePersistent(s);
			response.sendRedirect("/roles");
			pm.close();
		}
		

	}
	public static List<Role> todosLosTutoriales(){
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
