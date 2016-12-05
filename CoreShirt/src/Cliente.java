
public class Cliente {
	
	public String idCliente,nome,cognome,email,recapito;
	
	public Cliente(String idCliente,String nome,String cognome,String email,String recapito){
		this.idCliente=idCliente;
		this.nome=nome;
		this.cognome=cognome;
		this.email=email;
		this.recapito=recapito;
	}
	
	public String getIdCliente(){
		return idCliente;
	}
	
	public void setIdCliente(String idCliente){
		this.idCliente=idCliente;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(){
		this.nome=nome;
	}
	
	public String getCognome(){
		return cognome;
	}
	
	public void setCognome(String cognome){
		this.cognome=cognome;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getRecapito(){
		return recapito;
	}
	
	public String setRecapito(String recapito){
		return recapito;
	}
	
	

}
