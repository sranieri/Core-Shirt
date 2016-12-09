
public class Tshirt extends Articolo {
	
	String idTshirt,sesso,taglia,colore,categoria;
	
	public Tshirt(String idArticolo,String sesso,String taglia,String colore,int quantita,String nome,String categoria){	
		super(idArticolo,nome,categoria,12.0,quantita);
		this.sesso=sesso;
		this.taglia=taglia;
		this.colore=colore;
		this.nome=nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	public String getidArticolo(){
		return idArticolo;
	}
	
	public void getIdArticolo(String idArticolo){
		this.idArticolo=idArticolo;
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
