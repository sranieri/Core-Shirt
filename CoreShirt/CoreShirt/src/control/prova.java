package control;
import model.Articolo;

import java.sql.SQLException;
import java.util.ArrayList;
public class prova {
	public static void main(String args[]){
		ArrayList<Articolo> articoli;
		ManageArticolo ma=new ManageArticolo();
		try {
			articoli=(ArrayList<Articolo>) ma.doRetrieveMen();
			System.out.println(articoli.size());
			System.out.println(articoli.get(0).getidArticolo());
			System.out.println(articoli.get(0).getnome());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
