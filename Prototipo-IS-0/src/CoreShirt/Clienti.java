package CoreShirt;

public class Clienti {

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getIndirizzoConsegna() {
		return indirizzoConsegna;
	}
	public void setIndirizzoConsegna(String indirizzoConsegna) {
		this.indirizzoConsegna = indirizzoConsegna;
	}
	public int getRecapito() {
		return recapito;
	}
	public void setRecapito(int recapito) {
		this.recapito = recapito;
	}
	private String nome;
	private String cognome;
	private String indirizzoConsegna;
	private int recapito;
}
