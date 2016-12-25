package model;
import java.util.Date;
public class Fattura {
	private String idFattura,indirizzoSpedizione,pagamento;
	Ordine ordine;
	private double iva,totale;
	private Date data;
	
	public Fattura(String idFattura,Ordine ordine,String indirizzoSpedizione,double totale,Date data,double iva){
		this.idFattura=idFattura; //numero fattura
		this.ordine=ordine;
		this.indirizzoSpedizione=indirizzoSpedizione;
		this.totale=totale;
		this.iva=iva;
		this.data=data;
	}
	
	public String getIdFattura(){
		return idFattura;
	}
	
	public void setIdFattura(String idFattura){
		this.idFattura=idFattura;
	}
	
	public Ordine getIdOrdine(){
		return ordine;
	}
	
	public void setIdOrdine(Ordine ordine){
		this.ordine=ordine;
	}

	public String getIndirizzoSpedizione(){
		return indirizzoSpedizione;
	}
	
	public void setIndirizzoSpedizione(String indirizzoSpedizione){
		this.indirizzoSpedizione=indirizzoSpedizione;
	}
	
	public double getTotale(){
		return totale;
	}
	
	public void setTotale(double totale){
		this.totale=totale;
	}
	
	public String getPagamento(){
		return pagamento;
	}
	
	public void setPagamento(String pagamento){
		this.pagamento=pagamento;
	}
	
	public double getIva(){
		return iva;
	}
	
	public void setIva(double iva){
		this.iva=iva;
	}
	

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
