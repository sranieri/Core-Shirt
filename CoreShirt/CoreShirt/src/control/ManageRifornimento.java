package control;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Rifornimento;
import model.TShirt;
public class ManageRifornimento {
	private double totale;
	private String idRifornimento,idDipendente,stato;
	private Date dataRichiesta;
	private Date dataEffettuazione;
	private Date dataConsegna;
	private ArrayList<Rifornimento> rifornimenti=new ArrayList<Rifornimento>();
	
	public ManageRifornimento(){}
	public ArrayList<Rifornimento> getOrdini(){
		DbConnect.connect();
		rifornimenti=new ArrayList<Rifornimento>();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from rifornimento");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Rifornimento r=new Rifornimento(rs.getString("idRifornimento"),rs.getDouble("totale"),rs.getString("stato"),rs.getString("idDipendente"),""+rs.getDate("dataRichiesta"),rs.getDate("dataEffettuazione"),rs.getDate("dataConsegna"));
				rifornimenti.add(r);
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return rifornimenti;
	}
	
	
	public boolean insertRifornimento(Rifornimento r){
		int id=getOrdini().size()+1;
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("insert into rifornimento (idDipendente,dataRichiesta,dataEffettuazione,dataConsegnaPrevista,stato,totale) values(?,?,?,?,?,?)");
			ps.setString(1,r.getIdDipendente());
			ps.setString(2,r.getDataRichiesta());
			ps.setString(3,r.getDataRichiesta());
			ps.setString(4,r.getDataRichiesta());
			ps.setString(5,r.getStato());
			ps.setDouble(6,r.getTotale());	
			if(ps.executeUpdate()>0) flag=true;
			TShirt t=r.getTshirt();
			String tshirt=new ManageTshirt().getIdTshirt(t.getidArticolo(),t.getSesso(), t.getTaglia(), t.getColore());
			insertComposizione(id,tshirt,t.getquantita());
			ps.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		DbConnect.close();
		return flag;
	}
	
	private boolean insertComposizione(int id, String tshirt,int pezzi) {
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("insert into composizionerifornimento values(?,?,?)");
			ps.setInt(1,id);
			ps.setString(2,tshirt);
			ps.setInt(3, pezzi);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		DbConnect.close();
		return flag;
	}
	public boolean deleteRifornimento(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("delete from rifornimento where id=?");
			ps.setString(1,idRifornimento);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateIdDipendente(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update rifornimento set idDipendente=? where id=?");
			ps.setString(1,idDipendente);
			ps.setString(2,idRifornimento);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateDataEffettuazione(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update rifornimento set dataEffettuazione=? where id=?");
			//ps.setDate(1,dataEffettuazione);
			ps.setString(2,idRifornimento);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateDataRichiesta(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update rifornimento set dataRichiesta=? where id=?");
			//ps.setString(2,dataRichiesta);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateDataConsegna(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update rifornimento set dataConsegna=? where id=?");
			//ps.setString(1,dataConsegna);
			ps.setString(2,idRifornimento);
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
	
	
	
	

}
