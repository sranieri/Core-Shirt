package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.manage.ManageArticolo;
import control.manage.ManageTshirt;
import model.Articolo;
import model.TShirt;

/**
 * Servlet implementation class ServletTShirt
 */
@WebServlet("/ServletTShirt")
public class ServletTShirt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ManageTshirt mt;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTShirt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    mt=new ManageTshirt();
		    if(request.getParameter("rimuovi")!=null){
		    	String id=mt.getIdTshirt(Integer.parseInt(request.getParameter("insertarticolo")), request.getParameter("sesso"),request.getParameter("taglia"),request.getParameter("colore"));
		    	if(id.equals(""))
		    		request.setAttribute("presente",false);
		    	else{
		    	   if(mt.deleteTshirt(id)){
		    		   request.setAttribute("rimossa",true);
		    	   }
		        }
		    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HomeMagazzino.jsp");
				dispatcher.forward(request, response);
		    }
		    else{
		    int num=Integer.parseInt(request.getParameter("insertarticolo"));
			TShirt t= new TShirt(num,request.getParameter("sesso"),"",request.getParameter("colore"),request.getParameter("taglia"),Integer.parseInt(request.getParameter("insertQuantita")));
			mt.insertTshirt(t);
			ManageArticolo ma=new ManageArticolo();
			ma.updateQuantita(""+num, ma.getQuantita(num)+t.getquantita());
			response.sendRedirect("HomeMagazzino.jsp");
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
