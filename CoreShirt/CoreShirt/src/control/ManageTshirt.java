package control;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.TShirt;
public class ManageTshirt {
	
	String idTshirt,sesso,taglia,colore;
	int quantita;
	private ArrayList<TShirt> tshirts;
	
	public ManageTshirt(){}
	
	public String getIdTshirt(){
		return idTshirt;
	}
	
	public void setIdTshirt(String idTshirt){
		this.idTshirt=idTshirt;
	}
	
	public String getSesso(){
		return sesso;
	}
	
	public void setSesso(String sesso){
		this.sesso=sesso;
	}
	
	public String getTaglia(){
		return taglia;
	}
	
	public void setTaglia(String taglia){
		this.taglia=taglia;
	}
	
	public String getColore(){
		return colore;
	}
	
	public void setColore(String colore){
		this.colore=colore;
	}
	
	public ArrayList<TShirt> getTshirts(){
		DbConnect.connect();
		tshirts=new ArrayList<TShirt>();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from tshirt");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				TShirt t=new TShirt(rs.getInt("idArticolo"),rs.getString("sesso"),rs.getString("nome"),rs.getString("colore"),rs.getString("taglia"),rs.getInt("quantita"));
				tshirts.add(t);
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return tshirts;
	}
	
	
	public boolean insertTshirt(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("insert into tshirt values(?,?,?,?,?)");
			ps.setString(1,idTshirt);
			ps.setString(2,sesso);
			ps.setString(3,taglia);
			ps.setString(4,colore);
			ps.setInt(5,quantita);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		DbConnect.close();
		return flag;
	}
	
	public boolean deleteTshirt(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("delete from tshirt where id=?");
			ps.setString(1,idTshirt);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateSesso(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update tshirt set sesso=? where id=?");
			ps.setString(1,sesso);
			ps.setString(2,idTshirt);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateTaglia(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update tshirt set taglia=? where id=?");
			ps.setString(1,taglia);
			ps.setString(2,idTshirt);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateColore(){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update tshirt set colore=? where id=?");
			ps.setString(1,colore);
			ps.setString(2,idTshirt);
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
	

