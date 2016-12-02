package CoreShirt;

import java.util.ArrayList;

public class Ordine {
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public ArrayList getProdotti() {
		return prodotti;
	}
	public void setProdotti(ArrayList prodotti) {
		this.prodotti = prodotti;
	}
	public double getTotale() {
		return totale;
	}
	public void setTotale(double totale) {
		this.totale = totale;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	private String ID;
	private ArrayList prodotti;
	private double totale;
	private  String stato;
	

}
