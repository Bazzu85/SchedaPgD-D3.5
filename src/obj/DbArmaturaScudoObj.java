package obj;

public class DbArmaturaScudoObj {
	boolean datiVariati = false;
	String nome = "";
	String categoria = "";
	boolean armatura = false;
	boolean scudo = false;
	String costo = "";
	int bonus = 0;
	int bonusDesMax = 0;
	int penalitaProvaArmatura = 0;
	int fallimentoIncantesimiArcani = 0;
	double velocita9M = 0.00;
	double velocita6M = 0.00;
	double peso = 0.00;
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
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public boolean isArmatura() {
		return armatura;
	}
	public void setArmatura(boolean armatura) {
		this.armatura = armatura;
	}
	public boolean isScudo() {
		return scudo;
	}
	public void setScudo(boolean scudo) {
		this.scudo = scudo;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getBonusDesMax() {
		return bonusDesMax;
	}
	public void setBonusDesMax(int bonusDesMax) {
		this.bonusDesMax = bonusDesMax;
	}
	public int getPenalitaProvaArmatura() {
		return penalitaProvaArmatura;
	}
	public void setPenalitaProvaArmatura(int penalitaProvaArmatura) {
		this.penalitaProvaArmatura = penalitaProvaArmatura;
	}
	public int getFallimentoIncantesimiArcani() {
		return fallimentoIncantesimiArcani;
	}
	public void setFallimentoIncantesimiArcani(int fallimentoIncantesimiArcani) {
		this.fallimentoIncantesimiArcani = fallimentoIncantesimiArcani;
	}
	public double getVelocita9M() {
		return velocita9M;
	}
	public void setVelocita9M(double velocita9m) {
		velocita9M = velocita9m;
	}
	public double getVelocita6M() {
		return velocita6M;
	}
	public void setVelocita6M(double velocita6m) {
		velocita6M = velocita6m;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
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
