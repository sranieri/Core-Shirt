package control;
import model.Articolo;
import java.util.ArrayList;
public class prova {
	public static void main(String args[]){
		ArrayList<Articolo> articoli;
		ManageArticolo ma=new ManageArticolo();
		articoli=ma.getArticoli();
		System.out.println(articoli.size());
		System.out.println(articoli.get(0).getidArticolo());
		System.out.println(articoli.get(0).getnome());

	}

}
