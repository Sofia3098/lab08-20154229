package controller.resources;
import java.util.*;
import java.io.IOException;  
import java.io.PrintWriter;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jws.WebService;
import javax.servlet.*;  
import javax.servlet.http.*;

import controller.PMF;
import model.entity.Resource;
import model.entity.Role;
import model.entity.Resource;  
@SuppressWarnings("serial")
public class ResourcesControllerAdd extends HttpServlet {
	@SuppressWarnings("unchecked")
	private final static int FETCH_MAX_RESULTS = 10;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String res = request.getParameter("action");
		boolean igual=false;
		if(res != null ) {
			List<Resource> resources= todosLosTutoriales();
			String condicion = "";
			for(int i = 0; i<resources.size();i++) {
				Resource s = (Resource) resources.get(i);
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
				Resource a = new Resource(
						request.getParameter("name"),
						activo
						);

				try {
					pm.makePersistent(a);
				} finally {
					pm.close();
				}
				response.sendRedirect("../resources");
			}else {
				request.setAttribute("condicion", condicion);
				request.getRequestDispatcher("../WEB-INF/Views/Resources/view.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("../WEB-INF/Views/Resources/add.jsp").forward(request, response);
		}
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
	public static List<Resource> todosLosTutoriales(){
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query query = pm.newQuery(Resource.class);
		query.setRange(0, FETCH_MAX_RESULTS);
		return (List<Resource>) query.execute();
	}
}
