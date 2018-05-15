package obj;

public class PgBonusObj {
	boolean datiVariati = false;
	String bonus = "";
	int modificatore = 0;
	String descrizione = "";
	boolean bonusAbilitato = false;
	int prg = 0;
	
	
	public boolean isDatiVariati() {
		return datiVariati;
	}
	public void setDatiVariati(boolean datiVariati) {
		this.datiVariati = datiVariati;
	}
	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	public int getModificatore() {
		return modificatore;
	}
	public void setModificatore(int modificatore) {
		this.modificatore = modificatore;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public boolean isBonusAbilitato() {
		return bonusAbilitato;
	}
	public void setBonusAbilitato(boolean bonusAbilitato) {
		this.bonusAbilitato = bonusAbilitato;
	}
	public int getPrg() {
		return prg;
	}
	public void setPrg(int prg) {
		this.prg = prg;
	}
	
	
}
