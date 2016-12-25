package model;

import java.io.Serializable;

public class Articolo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int idArticolo;
	String nome;
	String sesso;
	double prezzo;
	int quantita;

	String categoria;

	public Articolo(int idArticolo, String nome, double prezzo, int quantita, String categoria) {
		this.idArticolo = idArticolo;
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.categoria = categoria;
	}

	public Articolo() {
		idArticolo = -1;
		nome = "";
		sesso="";
		prezzo=12;
		quantita=0;
		categoria="";
	}

	public int getidArticolo() {
		return idArticolo;
	}

	public void setId(int idArticolo) {
		this.idArticolo = idArticolo;
	}
	
	public int getquantita() {
		return quantita;
	}

	public void setquantita(int quantita) {
		this.quantita = quantita;
	}
	
	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}
	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public double getprezzo() {
		return prezzo;
	}
	public String getcategoria(){
		return categoria;
	}
	public void setcategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return nome + " (" + idArticolo +" "+sesso+ "), "+ prezzo+" "+quantita;
	}

}
