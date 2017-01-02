package control;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import model.Articolo;

/**
 * Servlet implementation class ServletInsertArticolo
 */
@WebServlet("/ServletInsertArticolo")
@MultipartConfig
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
		if(request.getParameter("insertNome")!=""&&request.getParameter("insertCategoria")!=""&&request.getParameter("insertPrezzo")!=""&&request.getParameter("insertQuantita")!=""){
			System.out.println(request.getParameter("insertNome")+(request.getParameter("insertPrezzo"))+(request.getParameter("insertQuantita"))+request.getParameter("insertCategoria"));
			Articolo a=new Articolo(request.getParameter("insertNome"),Double.parseDouble(request.getParameter("insertPrezzo")),Integer.parseInt(request.getParameter("insertQuantita")),request.getParameter("insertCategoria"));
			int num;
			if((num=ma.insertArticolo(a))>0) System.out.println("Inserimento effettuato");
			else System.out.println("Inserimento non effettuato");
			Upload(request.getPart("upfile"),num);
			response.sendRedirect("GestioneArticoli.jsp");

		}
	}

	private void Upload(Part filePart,int num) {
		String fileName = filePart.getSubmittedFileName(); // fileName è un oggetto di tipo String
        InputStream is;
		try {
			is = filePart.getInputStream();
			String fileExt = fileName.substring(fileName.lastIndexOf(".")); // fileExt è un oggetto di tipo String
	        String destinationPath = getServletContext().getInitParameter("filepath") +num+fileExt;
	        OutputStream os = new FileOutputStream(destinationPath);
			IOUtils.copy(is, os);
			is.close();
	        os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
