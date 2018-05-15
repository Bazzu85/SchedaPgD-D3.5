package obj;

import java.io.Serializable;

public class PgClasseObj  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 180828689437241655L;
	boolean datiVariati = false;
	int prg = 0;
	String classe = "";
	int livello = 0;
	String dadoVita = "";
	int puntiFerita = 0;
	boolean classeDiPrestigio = false;
	int babClasse = 0;
	
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
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getLivello() {
		return livello;
	}
	public void setLivello(int livello) {
		this.livello = livello;
	}
	public String getDadoVita() {
		return dadoVita;
	}
	public void setDadoVita(String dadoVita) {
		this.dadoVita = dadoVita;
	}
	public int getPuntiFerita() {
		return puntiFerita;
	}
	public void setPuntiFerita(int puntiFerita) {
		this.puntiFerita = puntiFerita;
	}
	public boolean isClasseDiPrestigio() {
		return classeDiPrestigio;
	}
	public void setClasseDiPrestigio(boolean classeDiPrestigio) {
		this.classeDiPrestigio = classeDiPrestigio;
	}
	public int getBabClasse() {
		return babClasse;
	}
	public void setBabClasse(int babClasse) {
		this.babClasse = babClasse;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
