package model;
import java.util.ArrayList;
import java.util.Date;
public class Rifornimento {

	public String idRifornimento,stato,idDipendente;
	public ArrayList<TShirt> listaArticoli;
	public double totale;
	public Date dataRichiesta,dataEffettuazione,dataConsegna;
	
	public Rifornimento(String idRifornimento,double totale,String stato,String idDipendente,Date dataRichiesta,Date dataEffettuazione,Date dataConsegna){
		this.idRifornimento=idRifornimento;
		this.listaArticoli=new ArrayList<TShirt>();
		this.totale=totale;
		this.stato=stato;
		this.idDipendente=idDipendente;
		this.dataRichiesta=dataRichiesta;
		this.dataEffettuazione=dataEffettuazione;
		this.dataConsegna=dataConsegna;
	}
	
	public String getIdRifornimento(){
		return idRifornimento;
	}
	
	public void setIdRifornimento(String idRifornimento){
		this.idRifornimento=idRifornimento;
	}
	
	public ArrayList<TShirt> getListaArticoli(){
		return listaArticoli;
	}
	
	public void setListaArticolo(ArrayList<TShirt> listaArticoli){
		this.listaArticoli=listaArticoli;
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
	
	public Date getDataRichiesta(){
		return dataRichiesta;
	}
	
	public void setDataRichiesta(Date data){
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
	
	public void add(TShirt t){
		listaArticoli.add(t);
	}
	
}
