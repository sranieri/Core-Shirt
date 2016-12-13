package control;
import java.util.ArrayList;

import model.Dipendente;

import java.sql.*;
public class ManageDipendente {
	
	public ArrayList<Dipendente> dipendenti;
	
	public ManageDipendente(){}
	
	private String username,password,nome,cognome,tipo,idDipendente,codiceFiscale;
	private double stipendio;
	private boolean flag;
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	public String getCognome(){
		return cognome;
	}
	
	public void setCognome(String cognome){
		this.cognome=cognome;
	}
	
	public String getCodiceFiscale(){
		return codiceFiscale;
	}
	
	public void setCodiceFiscale(String cf){
		this.codiceFiscale=cf;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public String getIdDipendente(){
		return idDipendente;
	}
	
	public void setIdDipendente(String id){
		this.idDipendente=id;
	}
	
	public double getStipendio(){
		return stipendio;
	}
	
	public void setStipendio(double stipendio){
		this.stipendio=stipendio;
	}
	
	public ArrayList<Dipendente> getDipendenti(){
		DbConnect.connect();
		dipendenti=new ArrayList<Dipendente>();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from Dipendente");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Dipendente d=new Dipendente(rs.getString("nome"),rs.getString("cognome"),rs.getString("codiceFiscale"),rs.getString("idDipendente"),rs.getString("tipo"),rs.getInt("stipendio"),rs.getString("username"),rs.getString("password"));
				dipendenti.add(d);
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return dipendenti;
	}
	
	
	public boolean insertDipendente(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("insert into dipendente values(?,?,?,?,?,?,?,?)");
			ps.setString(1,idDipendente);
			ps.setString(2,nome);
			ps.setString(3,cognome);
			ps.setString(3,codiceFiscale);
			ps.setDouble(4,stipendio);
			ps.setString(5,tipo);
			ps.setString(6,username);
			ps.setString(7,password);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		DbConnect.close();
		return flag;
	}
	
	public boolean deleteDipendente(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("delete from amministratore where id=?");
			ps.setString(1,idDipendente);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateStipendio(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set stipendio=? where id=?");
			ps.setDouble(1,stipendio);
			ps.setString(2,idDipendente);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateTipo(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set tipo=? where id=?");
			ps.setString(1,tipo);
			ps.setString(2,idDipendente);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateNome(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set nome=? where id=?");
			ps.setString(1,nome);
			ps.setString(2,idDipendente);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateCognome(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set cognome=? where id=?");
			ps.setString(1,nome);
			ps.setString(2,idDipendente);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateCodiceFiscale(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set codiceFiscale=? where id=?");
			ps.setString(1,codiceFiscale);
			ps.setString(2,idDipendente);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateUsername(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set username=? where id=?");
			ps.setString(1,username);
			ps.setString(2,idDipendente);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updatePassword(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set password=? where id=?");
			ps.setString(1,nome);
			ps.setString(2,idDipendente);
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
