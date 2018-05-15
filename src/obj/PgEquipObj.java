package obj;

public class PgEquipObj {
	boolean datiVariati = false;
	int prg = 0;
	String nome = "";
	int numero = 0;
	Double peso = 0.00;
	boolean indossato = false;
	boolean zaino = false;
	boolean tascaDaCintura = false;
	boolean altro = false;
	public boolean isDatiVariati() {
		return datiVariati;
	}
	public void setDatiVariati(boolean datiVariati) {
		this.datiVariati = datiVariati;
	}
	public int getPrg() {
		return prg;
	}
	public void setPrg(int prg) {
		this.prg = prg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public boolean isIndossato() {
		return indossato;
	}
	public void setIndossato(boolean indossato) {
		this.indossato = indossato;
	}
	public boolean isZaino() {
		return zaino;
	}
	public void setZaino(boolean zaino) {
		this.zaino = zaino;
	}
	public boolean isTascaDaCintura() {
		return tascaDaCintura;
	}
	public void setTascaDaCintura(boolean tascaDaCintura) {
		this.tascaDaCintura = tascaDaCintura;
	}
	public boolean isAltro() {
		return altro;
	}
	public void setAltro(boolean altro) {
		this.altro = altro;
	}


}
