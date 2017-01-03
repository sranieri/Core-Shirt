package model;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Rifornimento {

	public String idRifornimento,stato,idDipendente;
	public TShirt tshirt;
	public double totale;
	String dataRichiesta;
	public Date dataEffettuazione,dataConsegna;
	
	public Rifornimento(String idRifornimento,double totale,String stato,String idDipendente,String dataRichiesta,Date dataEffettuazione,Date dataConsegna){
		this.idRifornimento=idRifornimento;
		this.totale=totale;
		this.stato=stato;
		this.idDipendente=idDipendente;
		this.dataRichiesta=dataRichiesta;
		this.dataEffettuazione=dataEffettuazione;
		this.dataConsegna=dataConsegna;
	}
	
	public Rifornimento(String idDipendente, String articolo, String sesso, String taglia, String colore,String quantita) {
		tshirt=new TShirt(Integer.parseInt(articolo), sesso, "", colore, taglia, Integer.parseInt(quantita));
		this.totale=7.0*Integer.parseInt(quantita);
		this.stato="inevaso";
		this.idDipendente=idDipendente;
		this.dataRichiesta=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		this.dataEffettuazione=null;
		this.dataConsegna=null;
	}

	public String getIdRifornimento(){
		return idRifornimento;
	}
	
	public void setIdRifornimento(String idRifornimento){
		this.idRifornimento=idRifornimento;
	}
	
	public double getTotale(){
		return totale;
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
	
	public String getIdDipendente(){
		return idDipendente;
	}
	
	public void setIdDipendete(String idDipendente){
		this.idDipendente=idDipendente;
	}
	
	public String getDataRichiesta(){
		return dataRichiesta;
	}
	
	public void setDataRichiesta(String data){
		this.dataRichiesta=data;
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

	public TShirt getTshirt() {
		return tshirt;
	}

	public void setTshirt(TShirt tshirt) {
		this.tshirt = tshirt;
	}

	public void setIdDipendente(String idDipendente) {
		this.idDipendente = idDipendente;
	}
	
}
