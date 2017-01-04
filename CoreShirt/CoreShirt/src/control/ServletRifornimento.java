package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Rifornimento;

/**
 * Servlet implementation class ServletRifornimento
 */
@WebServlet("/ServletRifornimento")
public class ServletRifornimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRifornimento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("evadi")!=null){
			String idRifornimento=request.getParameter("richiesta");
			new ManageRifornimento().evadi(idRifornimento);
			response.sendRedirect("HomeContabilita.jsp");
		}
		else{
		String idDipendente=request.getParameter("dipendente");
		String articolo=request.getParameter("insertarticolo");
		String sesso=request.getParameter("sesso");
		String taglia=request.getParameter("taglia");
		String colore=request.getParameter("colore");
		String quantita=request.getParameter("quantita");
		Rifornimento r=new Rifornimento(idDipendente,articolo,sesso,taglia,colore,quantita);
	    new ManageRifornimento().insertRifornimento(r);
	    response.sendRedirect("HomeMagazzino.jsp");}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
