import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
public class ManageRifornimento {
	private double totale;
	private String idRifornimento,idDipendente,stato;
	private Date dataRichiesta;
	private Date dataEffettuazione;
	private Date dataConsegna;
	private ArrayList<Rifornimento> rifornimenti=new ArrayList<Rifornimento>();
	
	public ManageRifornimento(){}
	
	public String getIdRifornimento(String idRifornimento){
		return idRifornimento;
	}
	
	public void setIdRifornimento(String idRifornimento){
		this.idRifornimento=idRifornimento;
	}
	
	public String getIdDipendente(){
		return idDipendente;
	}
	
	public void setIdDipendete(String idDipendente){
		this.idDipendente=idDipendente;
	}
	
	public String getStato(){
		return stato;
	}
	
	public void setStato(String stato){
		this.stato=stato;
	}
	
	public Date getDataRichiesta(){
		return dataRichiesta;
	}
	
	public void setDataRichiesta(Date dataRichiesta){
		this.dataRichiesta=dataRichiesta;
	}
	
	public Date getDataEffettuazione(){
		return dataEffettuazione;
	}
	
	public void setDataEffettuazione(Date dataEffettuazione){
		this.dataEffettuazione=dataEffettuazione;
	}
	
	public Date getDataConsegna(){
		return dataConsegna;
	}
	
	public void setDataConsegna(Date dataConsegna){
		this.dataConsegna=dataConsegna;
	}
	
	public ArrayList<Rifornimento> getOrdini(){
		DbConnect.connect();
		rifornimenti=new ArrayList<Rifornimento>();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from rifornimento");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Rifornimento r=new Rifornimento(rs.getString("idRifornimento"),rs.getDouble("totale"),rs.getString("stato"),rs.getString("idDipendente"),rs.getDate("dataRichiesta"),rs.getDate("dataEffettuazione"),rs.getDate("dataConsegna"));
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
	
	
	public boolean insertRifornimento(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("insert into rifornimento values(?,?,?,?,?,?,?)");
			ps.setString(1,idRifornimento);
			ps.setDouble(2,totale);
			ps.setString(3,stato);
			ps.setString(4,stato);
			ps.setString(5,idDipendente);
		//	ps.setDate(5,dataRichiesta);
		//  ps.setDate(6,dataEffettuazione);
		//  ps.setDate(7,dataConsegna);	
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
