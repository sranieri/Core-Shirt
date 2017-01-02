package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path="";
		if(request.getParameter("logout")!=null){
			request.getSession().setAttribute("adminRoles", new Boolean(false));
			request.getSession().setAttribute("Contabile", new Boolean(false));
			request.getSession().setAttribute("Magazzino", new Boolean(false));
			request.getSession().setAttribute("AdminDip", new Boolean(false));
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
		else{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String tipo=new ManageDipendente().checkLogin(username, password);
		if(tipo == null){
			request.getSession().setAttribute("adminRoles", new Boolean(false));
			path="/login.jsp";
		}
		else{
		if(tipo.equals("Contabilita")){
			request.getSession().setAttribute("Contabile", new Boolean(true));
			path="/HomeContabile.jsp";
		}
		else if(tipo.equals("Magazzino")){
			request.getSession().setAttribute("Magazzino", new Boolean(true));
			path="/HomeMagazzino.jsp";
		}
		else if(tipo.equals("AdminDip")){
			request.getSession().setAttribute("AdminDip", new Boolean(true));
			request.getSession().setAttribute("dipendenti", new ManageDipendente().getDipendenti());
			path="/HomeDipendenti.jsp";
		}
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
