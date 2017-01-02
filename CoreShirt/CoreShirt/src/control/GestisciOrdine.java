package control;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestisciOrdine
 */
@WebServlet(name="GestisciOrdine",urlPatterns={"/GestisciOrdine"})
public class GestisciOrdine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestisciOrdine() {
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
		ManageOrdine mo=new ManageOrdine();

		if(request.getParameter("cambiaStato")!=""){
			if(mo.evadi(request.getParameter("idOrdine")))
				System.out.println("Modificato!");
		}
		if(request.getParameter("eliminaOrdine")!=null){
			if(mo.deleteOrdine((request.getParameter("eliminaOrdine"))))
				System.out.println("Eliminato");
		}
		response.sendRedirect("GestioneOrdini.jsp");


	}

}
