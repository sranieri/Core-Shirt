package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Cart;
import model.TShirt;

public class ManageCarrello {
	public synchronized void saveCart(Cart cart,ArrayList<String> x,int i){
		String nome=x.get(0);
		String cognome=x.get(1);
		String recapito=x.get(2);
		String indirizzo=x.get(3);
		String cap=x.get(4);
		String metodo=x.get(5);
		String pay=x.get(6);
		String totale=""+cart.getTotal();
		String data=(new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
		DbConnect.connect();
		Connection connection = DbConnect.con;
		PreparedStatement preparedStatement = null;
		String insertSQL="insert into cliente(idcliente,nome,cognome,recapito) values(?,"+"'"+nome+"','"+cognome+"','"+recapito+"');";
		String insertSQL2="insert into ordine(idordine,data,indirizzospedizione,idcliente,CAP,pagamento,metodoP,totale) values(?,"+"'"+data+"','"+indirizzo+"',?,'"+cap+"','"+pay+"','"+metodo+"','"+totale+"');";
		try {
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1,i);
		    preparedStatement.execute();
		    preparedStatement = connection.prepareStatement(insertSQL2);
		    preparedStatement.setInt(1,i);
		    preparedStatement.setInt(2,i);
		    preparedStatement.execute();
		    for(TShirt v:cart.getProducts()){
		    	String select="select idtshirt from tshirt where articolo="+v.getidArticolo()+" and sesso='"+v.getSesso()+"' and taglia='"+v.getTaglia()+"' and colore='"+v.getColore()+"';";
		    	preparedStatement = connection.prepareStatement(select);
		    	ResultSet rs=preparedStatement.executeQuery();
		    	String id="";
		    	while(rs.next()){
		    		id=rs.getString(1);
		    	}
		    	String insert="insert into composizioneordine(idordine,idtshirt,pezzi) values("+i+","+id+","+v.getquantita()+");";
		    	preparedStatement = connection.prepareStatement(insert);
		    	preparedStatement.execute();
		    }
		    cart.delete();
		}
        catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
