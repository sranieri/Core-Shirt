
public class Tshirt {
	
	String idTshirt,sesso,taglia,colore;
	int quantita;
	
	public Tshirt(String idTshirt,String sesso,String taglia,String colore,int quantita){
		this.idTshirt=idTshirt;
		this.sesso=sesso;
		this.taglia=taglia;
		this.colore=colore;
		this.quantita=quantita;
	}
	
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
	
	public int getQuantita(){
		return quantita;
	}
	
	public void setQuantita(int quantita){
		this.quantita=quantita;
	}

}
