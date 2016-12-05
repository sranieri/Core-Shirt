import java.sql.*;
import java.util.ArrayList;
public class Prova {
	public static void main(String args[]){
		
		ArrayList<Dipendente> dipendenti=new ArrayList<Dipendente>();
		ManageDipendente manageDipendente=new ManageDipendente();
		dipendenti=manageDipendente.getDipendenti();
		System.out.println(dipendenti.size());
		System.out.println(dipendenti.get(0).getNome());
		
	}

}
