package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Articolo;

/**
 * Servlet implementation class ServletInsertArticolo
 */
@WebServlet("/ServletInsertArticolo")
public class ServletInsertArticolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInsertArticolo() {
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
		
		ManageArticolo ma=new ManageArticolo();
		if(request.getParameter("idArticolo")!=""&&request.getParameter("nome")!=""&&request.getParameter("categoria")!=""){
			Articolo a=new Articolo(Integer.parseInt(request.getParameter("idArticolo")),request.getParameter("nome"),Double.parseDouble(request.getParameter("prezzo")),Integer.parseInt(request.getParameter("quantita")),request.getParameter("categoria"));
			if(ma.insertArticolo(a)) System.out.println("Inserimento effettuato");
			else System.out.println("Inserimento non effettuato");
		}
	}

}
