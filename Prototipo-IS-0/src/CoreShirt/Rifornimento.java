package CoreShirt;

import java.util.ArrayList;

public class Rifornimento {


	public int getId_rifornimeto() {
		return Id_rifornimeto;
	}
	public void setId_rifornimeto(int id_rifornimeto) {
		Id_rifornimeto = id_rifornimeto;
	}
	public ArrayList getProdotti() {
		return Prodotti;
	}
	public void setProdotti(ArrayList prodotti) {
		Prodotti = prodotti;
	}
	public double getTotale() {
		return Totale;
	}
	public void setTotale(double totale) {
		Totale = totale;
	}
	public String getStato() {
		return Stato;
	}
	public void setStato(String stato) {
		Stato = stato;
	}
	
	private void Evadi(){};
	private int Id_rifornimeto;
	private 	ArrayList  Prodotti;
	private double Totale;
	private String Stato;

}
