package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class GestisciDipendente
 */
@WebServlet(name="GestisciDipendente",urlPatterns={"/GestisciDipendente"})
public class GestisciDipendente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestisciDipendente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		ManageDipendente md=new ManageDipendente();
		
		//elimina dipendente
				
		if(request.getParameter("nome")!=""){
			if(md.updateNome(Integer.parseInt(request.getParameter("id")),request.getParameter("nome"))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("cognome")!=""){
			System.out.println("cognome:"+request.getParameter("cognome"));
			if(md.updateCognome(Integer.parseInt(request.getParameter("id")),request.getParameter("cognome"))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("cf")!=""){
			if(md.updateCodiceFiscale(Integer.parseInt(request.getParameter("id")),request.getParameter("cf"))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("stipendio")!=""){
			if(md.updateStipendio(Integer.parseInt(request.getParameter("id")),Double.parseDouble(request.getParameter("stipendio")))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("tipo")!=""){
			if(md.updateTipo(Integer.parseInt(request.getParameter("id")),request.getParameter("tipo"))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("username")!=""){
			if(md.updateUsername(Integer.parseInt(request.getParameter("id")),request.getParameter("username"))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("password")!=""){
			if(md.updatePassword(Integer.parseInt(request.getParameter("id")),request.getParameter("password"))){
				System.out.println("modificato");
			}
		}


		
		response.sendRedirect("GestioneDipendenti.jsp");



	}
}


