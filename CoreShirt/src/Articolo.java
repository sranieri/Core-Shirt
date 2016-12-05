
public class Articolo {
	
	String idArticolo,nome,categoria;
	double prezzo;
	int quantita;
	
	public Articolo(String idArticolo,String nome,String categoria,double prezzo,int quantita){
		this.idArticolo=idArticolo;
		this.nome=nome;
		this.categoria=categoria;
		this.prezzo=prezzo;
		this.quantita=quantita;
	}
	
	public String getIdArticolo(){
		return idArticolo;
	}
	
	public void setIdArticolo(String idArticolo){
		this.idArticolo=idArticolo;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	public String getCategoria(){
		return categoria;
	}
	
	public void setCategoria(String categoria){
		this.categoria=categoria;
	}
	
	public double getPrezzo(){
		return prezzo;
	}
	
	public void setPrezzo(double prezzo){
		this.prezzo=prezzo;
	}
	
	public int getQuantita(){
		return quantita;
	}
	
	public void setQuantita(int quantita){
		this.quantita=quantita;
	}

}
