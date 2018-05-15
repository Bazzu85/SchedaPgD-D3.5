package obj;

public class DbAbilitaObj {
	boolean datiVariati = false;
	String nome = "";
	boolean richiedeAddestramento = false;
	String caratteristica = "";
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
	public boolean isRichiedeAddestramento() {
		return richiedeAddestramento;
	}
	public void setRichiedeAddestramento(boolean richiedeAddestramento) {
		this.richiedeAddestramento = richiedeAddestramento;
	}
	public String getCaratteristica() {
		return caratteristica;
	}
	public void setCaratteristica(String caratteristica) {
		this.caratteristica = caratteristica;
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
