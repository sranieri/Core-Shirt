package control;
import java.util.Date;

import model.Spesa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ManageSpesa {
	private String idSpesa;
	private double ammontare;
	private Date data;
	private String descrizione;
	
	public ArrayList<Spesa> spese=new ArrayList<Spesa>();
	
	public ManageSpesa(){}
	
	
	
	public String getIdSpesa(){
		return idSpesa;
	}
	
	public void setIdSpesa(String idSpesa){
		this.idSpesa=idSpesa;
	}
	
	public double getAmmontare(){
		return ammontare;
	}
	
	public Date getData(){
		return data;
	}
	
	public String getDescrizione(){
		return descrizione;
	}
	
	public void setAmmontare(double ammontare){
		this.ammontare=ammontare;
	}
	
	public void setData(Date data){
		this.data=data;
	}
	
	public void setDescrizione(String descrizione){
		this.descrizione=descrizione;
	}
	
	public ArrayList<Spesa> getSpese(){
		DbConnect.connect();
		spese=new ArrayList<Spesa>();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from spesa");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Spesa s=new Spesa(rs.getDouble("ammontare"),rs.getDate("data"),rs.getString("descrizione"));
				spese.add(s);
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return spese;
	}
	
	public boolean insertSpesa(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("insert into spesa values(?,?,?,?)");
			ps.setString(1,idSpesa);
			ps.setDouble(1,ammontare);
			//ps.setDate(2,data);
			ps.setString(3,descrizione);

			if(ps.executeUpdate()>0) flag=true;
			ps.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		DbConnect.close();
		return flag;
	}
	
	public boolean deleteIdSpesa(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("delete from spesa where id=?");
			ps.setString(1,idSpesa);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateDescrizione(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set descrizione=? where id=?");
			ps.setString(1,descrizione);
			ps.setString(2,idSpesa);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateAmmontare(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set ammontare=? where id=?");
			ps.setDouble(1,ammontare);
			ps.setString(2,idSpesa);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateData(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set data=? where id=?");
			//ps.setDate(1,data);
			ps.setString(2,idSpesa);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}

}
