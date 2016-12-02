package CoreShirt;

import java.util.ArrayList;

public class Carrello {

	
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
	public double getCostoSpedizione() {
		return costoSpedizione;
	}
	public void setCostoSpedizione(double costoSpedizione) {
		this.costoSpedizione = costoSpedizione;
	}
	private ArrayList prodotti;
	private double totale;
	private double costoSpedizione;
}
