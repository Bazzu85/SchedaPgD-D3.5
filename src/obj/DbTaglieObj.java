package obj;

public class DbTaglieObj {
	boolean datiVariati = false;
	String nome = "";
	int modTaglia = 0;
	int modTagliaSpeciale = 0;
	boolean rigaBloccata = false;
	int prg = 0;
	
	
	public boolean isDatiVariati() {
		return datiVariati;
	}
	public void setDatiVariati(boolean datiVariati) {
		this.datiVariati = datiVariati;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getModTaglia() {
		return modTaglia;
	}
	public void setModTaglia(int modTaglia) {
		this.modTaglia = modTaglia;
	}
	public int getModTagliaSpeciale() {
		return modTagliaSpeciale;
	}
	public void setModTagliaSpeciale(int modTagliaSpeciale) {
		this.modTagliaSpeciale = modTagliaSpeciale;
	}
	public boolean isRigaBloccata() {
		return rigaBloccata;
	}
	public void setRigaBloccata(boolean rigaBloccata) {
		this.rigaBloccata = rigaBloccata;
	}
	public int getPrg() {
		return prg;
	}
	public void setPrg(int prg) {
		this.prg = prg;
	}

}
