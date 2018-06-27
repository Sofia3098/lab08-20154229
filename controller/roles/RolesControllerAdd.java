package controller.roles;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.Role;
import model.entity.User;

public class RolesControllerAdd extends HttpServlet{
	private final static int FETCH_MAX_RESULTS = 10;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PersistenceManager pm = PMF.get().getPersistenceManager();

		String res = request.getParameter("action");
		boolean igual= false; 
		if(res != null ) {
			List<Role> students = todosLosTutoriales();
			String condicion = "";
			for(int i = 0; i<students.size();i++) {
				Role s = (Role) students.get(i);
				if(s.getName().equalsIgnoreCase(request.getParameter("name"))) {
					condicion= "name";
					igual = true;
					break;
				}
			}
			if(!igual) {
				boolean activo;
				if(request.getParameter("status")!= null) {
					activo = true;
				}else {
					activo = false;
				}
				Role a = new Role(
						request.getParameter("name"),
						activo
						);

				try {
					pm.makePersistent(a);
				} finally {
					pm.close();
				}
				response.sendRedirect("../roles");
			}else {
				request.setAttribute("condicion", condicion);
				request.getRequestDispatcher("../WEB-INF/Views/Roles/view.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("../WEB-INF/Views/Roles/add.jsp").forward(request, response);
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
