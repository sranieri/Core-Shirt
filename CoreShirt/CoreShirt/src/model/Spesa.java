package model;
import java.util.Date;
public class Spesa {
	public String idSpesa;
	public String descrizione;
	public Date data;
	public double ammontare;
	
	public Spesa(double ammontare,Date data,String descrizione){
		this.ammontare=ammontare;
		this.data=data;
		this.descrizione=descrizione;
	}
	
	public String getIdSpesa(){
		return idSpesa;
	}
	
	public void setIdSpesa(String idSpesa){
		this.idSpesa=idSpesa;
	}
	
	public double getAmmontare(){
		return ammontare;
	}
	
	public void setAmmontare(double ammontare){
		this.ammontare=ammontare;
	}
	
	public String getDescrizione(){
		return descrizione;
	}
	
	public void setDescrizione(String descrizione){
		this.descrizione=descrizione;
	}
	
	public Date getData(){
		return data;
	}
	
	public void setDate(Date data){
		this.data=data;
	}

}
