package control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Ordine;

public class ManageOrdine {

	Date data;
	ArrayList<Ordine> ordini;

	public ManageOrdine(){}
	
	public ArrayList<Ordine> getOrdini(){
		DbConnect.connect();
		ordini=new ArrayList<Ordine>();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from ordine");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Ordine o=new Ordine();
				o.setIdOrdine(rs.getInt("idordine"));
				o.setIdCliente(rs.getInt("idcliente"));
				o.setStato(rs.getString("stato"));
				o.setData(rs.getString("data"));
				o.setIndirizzoSpedizione(rs.getString("indirizzoSpedizione"));
				o.setTotale(rs.getDouble("totale"));
				o.setCap(rs.getString("CAP"));
				o.setMetodoP(rs.getString("metodoP"));
				o.setPagamento(rs.getString("pagamento"));
				ordini.add(o);
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return ordini;
	}
	
	
/*	public boolean insertOrdine(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("insert into ordine values(?,?,?,?,?,?,?)");
			ps.setString(1,idOrdine);
			ps.setDouble(2,totale);
			ps.setString(3,stato);
			ps.setString(4,idCliente);
			ps.setString(5,indirizzoConsegna);
			ps.setString(5,metodoPagamento);
			//ps.setDate(7,data);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		DbConnect.close();
		return flag;
	}
	*/
	public boolean deleteOrdine(String idOrdine){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("delete from ordine where idordine=?");
			ps.setInt(1,Integer.parseInt(idOrdine));
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateIdCliente(int idOrdine,int idCliente){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update ordine set idCliente=? where idordine=?");
			ps.setInt(1,idCliente);
			ps.setInt(2,idOrdine);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateIndirizzoConsegna(int idOrdine,String indirizzoConsegna){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update articolo set indirizzoConsegna=? where idordine=?");
			ps.setString(1,indirizzoConsegna);
			ps.setInt(2,idOrdine);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateTotale(int idOrdine,double totale){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update ordine set totale=? where idordine=?");
			ps.setDouble(1,totale);
			ps.setInt(2,idOrdine);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateMetodoPagamento(int idOrdine,String metodoP){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update ordine set metodoP=? where idordine=?");
			ps.setString(1,metodoP);
			ps.setInt(2,idOrdine);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateStato(String idOrdine,String stato){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update ordine set stato=? where idordine=?");
			ps.setString(1,stato);
			ps.setInt(2,Integer.parseInt(idOrdine));
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	//public boolean updateData(){}
	public synchronized int getI(){
		String query="select max(idordine) from ordine;";
		DbConnect.connect();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = DbConnect.con.prepareStatement(query);
			ResultSet rs=preparedStatement.executeQuery();
			String x="";
			while(rs.next()){
				x=rs.getString(1);
			}
			DbConnect.close();
			if(x==null)
				return 0;
			else
				return Integer.parseInt(x);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
}
