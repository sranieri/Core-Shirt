package model;


public class Ordine {
	
	String stato,indirizzoSpedizione,metodoP,pagamento;
	double totale;
	String data,cap;
	int idOrdine,idCliente;
	
	public Ordine(){
		
	}
	
	public int getIdOrdine(){
		return idOrdine;
	}
	
	public void setIdOrdine(int idOrdine){
		this.idOrdine=idOrdine;
	}
	
	public double getTotale(){
		return totale;
	}
	public String getIndirizzoSpedizione(){
		return indirizzoSpedizione;
	}
	
	public void setIndirizzoSpedizione(String indirizzoSpedizione){
		this.indirizzoSpedizione=indirizzoSpedizione;
	}
	
	public void setTotale(double totale){
		this.totale=totale;
	}
	
	public String getStato(){
		return stato;
	}
	
	public void setStato(String stato){
		this.stato=stato;
	}
	
	public int getIdCliente(){
		return idCliente;
	}
	
	public void setIdCliente(int idCliente){
		this.idCliente=idCliente;
	}
	
	public String getMetodoP(){
		return metodoP;
	}
	
	public void setMetodoP(String metodoP){
		this.metodoP=metodoP;
	}
	
	public void setCap(String cap){
		this.cap=cap;
	}
	
	public String getCap(){
		return cap;
	}
	
	public String getData(){
		return data;
	}
	
	public void setData(String data){
		this.data=data;
	}
	
	public void setPagamento(String pagamento){
		this.pagamento=pagamento;
	}
	
	public String getPagamento(){
		return pagamento;
	}

}
