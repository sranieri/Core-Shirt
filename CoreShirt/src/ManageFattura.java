
public class ManageFattura {
	
	String idFattura,idOrdine,indirizzoSpedizione,pagamento; 
	double totale,iva;

	public ManageFattura(){}
	
	public String getIdFattura(){
		return idFattura;
	}
	
	public void setIdFattura(String idFattura){
		this.idFattura=idFattura;
	}
	
	public String getIdOrdine(){
		return  idOrdine;
	}
	
	public void setIdOrdine(String idOrdine){
		this.idOrdine=idOrdine;
	}
	
	public String getIndirizzoSpedizione(){
		return indirizzoSpedizione;
	}
	
	public void setIndirizzoSpedizione(String indirizzoSpedizione){
		this.indirizzoSpedizione=indirizzoSpedizione;
	}
	
	public String getPagamento(){
		return pagamento;
	}
	
	public double getTotale(){
		return totale;
	}
	
	public void setTotale(double totale){
		this.totale=totale;
	}
	
	public double getIva(){
		return iva;
	}
	
	public void setIva(double iva){
		this.iva=iva;
	}

}
