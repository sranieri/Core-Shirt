package model;

public class Dipendente {
	
	String nome,cognome,codiceFiscale,tipo,username,password,id;
	double stipendio;
	
	public Dipendente(){}
	
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
	
	public void setCodiceFiscale(String codiceFiscale){
		this.codiceFiscale=codiceFiscale;
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	
	public double getStipendio(){
		return stipendio;
	}
	
	public void setStipendio(double stipendio){
		this.stipendio=stipendio;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	

	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public void evadiOrdine(Ordine ordine){
		
	}
	
	public void evadiRifornimento(Rifornimento rifornimento){
		
	}
	

}
