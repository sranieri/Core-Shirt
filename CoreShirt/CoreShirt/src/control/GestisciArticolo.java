package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Articolo;

/**
 * Servlet implementation class GestisciArticolo
 */
@WebServlet(name="GestisciArticolo",urlPatterns={"/GestisciArticolo"})
public class GestisciArticolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestisciArticolo() {
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
		
		if(request.getParameter("insertNome")!="" && request.getParameter("insertCategoria")!=""&&request.getParameter("insertPrezzo")!=""&&request.getParameter("insertQuantita")!=""){
			Articolo a=new Articolo(Integer.parseInt(request.getParameter("insertId")),request.getParameter("insertNome"),request.getParameter("insertCategoria"));
			ma.insertArticolo(a);
		}

		
		
		//gestisci articoli
		if(request.getParameter("nome")!=""){
			if(ma.updateNome(request.getParameter("id"),request.getParameter("nome"))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("categoria")!=""){
			if(ma.updateCategoria(request.getParameter("id"),request.getParameter("categoria"))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("prezzo")!=""){
			if(ma.updatePrezzo(request.getParameter("id"),request.getParameter("prezzo"))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("quantita")!=""){
			if(ma.updateQuantita(request.getParameter("id"),Integer.parseInt(request.getParameter("quantita")))){
				System.out.println("modificato");
			}
		}
		response.sendRedirect("/CoreShirt/j.jsp");
		if(request.getParameter("rimuoviArticolo")!=""){
			if(ma.deleteArticolo(request.getParameter("id"))){
				System.out.println("modificato");
			}
		}

		response.sendRedirect("/CoreShirt/j.jsp");

	}

}
