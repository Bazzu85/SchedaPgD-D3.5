package obj;

import java.util.ArrayList;

public class PgDatiObj{
	boolean datiCommittati = true;
	boolean datiVariati = false;
	
	String fileName = "";
	int id = 0;
	String nomePg = "";
	String nomeGiocatore = "";
	String luogoDataNascita = "";
	String razza = "";
	String sesso = "";
	String pelle = "";
	String eta = "";
	String altezza = "";
	String peso = "";
	String capelli = "";
	String occhi = "";
	String allineamento = "";
	String taglia = "";
	ArrayList<PgClasseObj> arrayClassi = new ArrayList<PgClasseObj>();
	int lvlTotPg = 0;
	int px = 0;
	int pxLvlSucc = 0;
	int pxPenalita = 0;

	ArrayList<PgBonusObj> arrayBonus = new ArrayList<PgBonusObj>();
	PgBonusCalcolati pgBonusCalcolati = new PgBonusCalcolati();
	PgStatisticheObj pgStatisticheObj = new PgStatisticheObj();
	PgPuntiFeritaObj pgPuntiFeritaObj = new PgPuntiFeritaObj();
	PgClasseArmaturaObj pgClasseArmaturaObj = new PgClasseArmaturaObj();
	PgBabObj pgBabObj = new PgBabObj();
	PgTiriSalvezzaObj pgTiriSalvezzaObj = new PgTiriSalvezzaObj();
	PgIniziativaObj pgIniziativaObj = new PgIniziativaObj();
	ArrayList<PgArmiObj> arrayArmi = new ArrayList<PgArmiObj>();
	ArrayList<PgArmiRiepilogoObj> arrayArmiRiepilogo = new ArrayList<PgArmiRiepilogoObj>();
	ArrayList<PgAbilitaObj> arrayAbilita = new ArrayList<PgAbilitaObj>();
	ArrayList<PgTalentiObj> arrayTalenti = new ArrayList<PgTalentiObj>();
	
	String titoli = "";
	String trattiRazziali = "";
	String privilegiDiClasse = "";
	ArrayList<PgLingueObj> arrayLingue = new ArrayList<PgLingueObj>();
	int indexManovrePanel = 0;
	boolean manovrePanel = false;
	ArrayList<PgManovreObj> arrayManovre = new ArrayList<PgManovreObj>();
	ArrayList<PgEquipObj> arrayEquip = new ArrayList<PgEquipObj>();

	Double totalePesiIndossato = 0.00;
	Double totalePesiZaino = 0.00;
	Double totalePesiTascaDaCintura = 0.00;
	Double totalePesiAltro = 0.00;
	Double totalePesi = 0.00;
	PgMovimentoObj pgMovimentoObj = new PgMovimentoObj();
	PgCaricoObj pgCaricoObj = new PgCaricoObj();

	String appunti = "";

	public void consoleOut(PgDatiObj pgDatiObj) {
		System.out.println("Id: " + pgDatiObj.getId());
		System.out.println("Nome pg: " + pgDatiObj.getNomePg());
		System.out.println("Nome giocatore: " + pgDatiObj.getNomeGiocatore());
		System.out.println("Luogo e Data di nascita: " + pgDatiObj.getLuogoDataNascita());
		System.out.println("Razza: " + pgDatiObj.getRazza());
		System.out.println("Sesso: " + pgDatiObj.getSesso());
		System.out.println("Pelle: " + pgDatiObj.getPelle());
		System.out.println("Età: " + pgDatiObj.getEta());
		System.out.println("Altezza: " + pgDatiObj.getAltezza());
		System.out.println("Peso: " + pgDatiObj.getPeso());
		System.out.println("Capelli: " + pgDatiObj.getCapelli());
		System.out.println("Occhi: " + pgDatiObj.getOcchi());
		System.out.println("Allineamento: " + pgDatiObj.getAllineamento());
		System.out.println("Taglia: " + pgDatiObj.getTaglia());
		
	}

	public boolean isDatiCommittati() {
		return datiCommittati;
	}

	public void setDatiCommittati(boolean datiCommittati) {
		this.datiCommittati = datiCommittati;
	}

	public boolean isDatiVariati() {
		return datiVariati;
	}

	public void setDatiVariati(boolean datiVariati) {
		this.datiVariati = datiVariati;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomePg() {
		return nomePg;
	}

	public void setNomePg(String nomePg) {
		this.nomePg = nomePg;
	}

	public String getNomeGiocatore() {
		return nomeGiocatore;
	}

	public void setNomeGiocatore(String nomeGiocatore) {
		this.nomeGiocatore = nomeGiocatore;
	}

	public String getLuogoDataNascita() {
		return luogoDataNascita;
	}

	public void setLuogoDataNascita(String luogoDataNascita) {
		this.luogoDataNascita = luogoDataNascita;
	}

	public String getRazza() {
		return razza;
	}

	public void setRazza(String razza) {
		this.razza = razza;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getPelle() {
		return pelle;
	}

	public void setPelle(String pelle) {
		this.pelle = pelle;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getAltezza() {
		return altezza;
	}

	public void setAltezza(String altezza) {
		this.altezza = altezza;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getCapelli() {
		return capelli;
	}

	public void setCapelli(String capelli) {
		this.capelli = capelli;
	}

	public String getOcchi() {
		return occhi;
	}

	public void setOcchi(String occhi) {
		this.occhi = occhi;
	}

	public String getAllineamento() {
		return allineamento;
	}

	public void setAllineamento(String allineamento) {
		this.allineamento = allineamento;
	}

	public String getTaglia() {
		return taglia;
	}

	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}

	public ArrayList<PgClasseObj> getArrayClassi() {
		return arrayClassi;
	}

	public void setArrayClassi(ArrayList<PgClasseObj> arrayClassi) {
		this.arrayClassi = arrayClassi;
	}

	public int getLvlTotPg() {
		return lvlTotPg;
	}

	public void setLvlTotPg(int lvlTotPg) {
		this.lvlTotPg = lvlTotPg;
	}

	public int getPx() {
		return px;
	}

	public void setPx(int px) {
		this.px = px;
	}

	public int getPxLvlSucc() {
		return pxLvlSucc;
	}

	public void setPxLvlSucc(int pxLvlSucc) {
		this.pxLvlSucc = pxLvlSucc;
	}

	public int getPxPenalita() {
		return pxPenalita;
	}

	public void setPxPenalita(int pxPenalita) {
		this.pxPenalita = pxPenalita;
	}

	public ArrayList<PgBonusObj> getArrayBonus() {
		return arrayBonus;
	}

	public void setArrayBonus(ArrayList<PgBonusObj> arrayBonus) {
		this.arrayBonus = arrayBonus;
	}

	public PgBonusCalcolati getPgBonusCalcolati() {
		return pgBonusCalcolati;
	}

	public void setPgBonusCalcolati(PgBonusCalcolati pgBonusCalcolati) {
		this.pgBonusCalcolati = pgBonusCalcolati;
	}

	public PgStatisticheObj getPgStatisticheObj() {
		return pgStatisticheObj;
	}

	public void setPgStatisticheObj(PgStatisticheObj pgStatisticheObj) {
		this.pgStatisticheObj = pgStatisticheObj;
	}

	public PgPuntiFeritaObj getPgPuntiFeritaObj() {
		return pgPuntiFeritaObj;
	}

	public void setPgPuntiFeritaObj(PgPuntiFeritaObj pgPuntiFeritaObj) {
		this.pgPuntiFeritaObj = pgPuntiFeritaObj;
	}

	public PgClasseArmaturaObj getPgClasseArmaturaObj() {
		return pgClasseArmaturaObj;
	}

	public void setPgClasseArmaturaObj(PgClasseArmaturaObj pgClasseArmaturaObj) {
		this.pgClasseArmaturaObj = pgClasseArmaturaObj;
	}

	public PgBabObj getPgBabObj() {
		return pgBabObj;
	}

	public void setPgBabObj(PgBabObj pgBabObj) {
		this.pgBabObj = pgBabObj;
	}

	public PgTiriSalvezzaObj getPgTiriSalvezzaObj() {
		return pgTiriSalvezzaObj;
	}

	public void setPgTiriSalvezzaObj(PgTiriSalvezzaObj pgTiriSalvezzaObj) {
		this.pgTiriSalvezzaObj = pgTiriSalvezzaObj;
	}

	public PgIniziativaObj getPgIniziativaObj() {
		return pgIniziativaObj;
	}

	public void setPgIniziativaObj(PgIniziativaObj pgIniziativaObj) {
		this.pgIniziativaObj = pgIniziativaObj;
	}

	public ArrayList<PgArmiObj> getArrayArmi() {
		return arrayArmi;
	}

	public void setArrayArmi(ArrayList<PgArmiObj> arrayArmi) {
		this.arrayArmi = arrayArmi;
	}

	public ArrayList<PgArmiRiepilogoObj> getArrayArmiRiepilogo() {
		return arrayArmiRiepilogo;
	}

	public void setArrayArmiRiepilogo(
			ArrayList<PgArmiRiepilogoObj> arrayArmiRiepilogo) {
		this.arrayArmiRiepilogo = arrayArmiRiepilogo;
	}

	public ArrayList<PgAbilitaObj> getArrayAbilita() {
		return arrayAbilita;
	}

	public void setArrayAbilita(ArrayList<PgAbilitaObj> arrayAbilita) {
		this.arrayAbilita = arrayAbilita;
	}

	public ArrayList<PgTalentiObj> getArrayTalenti() {
		return arrayTalenti;
	}

	public void setArrayTalenti(ArrayList<PgTalentiObj> arrayTalenti) {
		this.arrayTalenti = arrayTalenti;
	}

	public String getTitoli() {
		return titoli;
	}

	public void setTitoli(String titoli) {
		this.titoli = titoli;
	}

	public String getTrattiRazziali() {
		return trattiRazziali;
	}

	public void setTrattiRazziali(String trattiRazziali) {
		this.trattiRazziali = trattiRazziali;
	}

	public String getPrivilegiDiClasse() {
		return privilegiDiClasse;
	}

	public void setPrivilegiDiClasse(String privilegiDiClasse) {
		this.privilegiDiClasse = privilegiDiClasse;
	}

	public ArrayList<PgLingueObj> getArrayLingue() {
		return arrayLingue;
	}

	public void setArrayLingue(ArrayList<PgLingueObj> arrayLingue) {
		this.arrayLingue = arrayLingue;
	}

	public int getIndexManovrePanel() {
		return indexManovrePanel;
	}

	public void setIndexManovrePanel(int indexManovrePanel) {
		this.indexManovrePanel = indexManovrePanel;
	}

	public boolean isManovrePanel() {
		return manovrePanel;
	}

	public void setManovrePanel(boolean manovrePanel) {
		this.manovrePanel = manovrePanel;
	}

	public ArrayList<PgManovreObj> getArrayManovre() {
		return arrayManovre;
	}

	public void setArrayManovre(ArrayList<PgManovreObj> arrayManovre) {
		this.arrayManovre = arrayManovre;
	}

	public ArrayList<PgEquipObj> getArrayEquip() {
		return arrayEquip;
	}

	public void setArrayEquip(ArrayList<PgEquipObj> arrayEquip) {
		this.arrayEquip = arrayEquip;
	}

	public Double getTotalePesiIndossato() {
		return totalePesiIndossato;
	}

	public void setTotalePesiIndossato(Double totalePesiIndossato) {
		this.totalePesiIndossato = totalePesiIndossato;
	}

	public Double getTotalePesiZaino() {
		return totalePesiZaino;
	}

	public void setTotalePesiZaino(Double totalePesiZaino) {
		this.totalePesiZaino = totalePesiZaino;
	}

	public Double getTotalePesiTascaDaCintura() {
		return totalePesiTascaDaCintura;
	}

	public void setTotalePesiTascaDaCintura(Double totalePesiTascaDaCintura) {
		this.totalePesiTascaDaCintura = totalePesiTascaDaCintura;
	}

	public Double getTotalePesiAltro() {
		return totalePesiAltro;
	}

	public void setTotalePesiAltro(Double totalePesiAltro) {
		this.totalePesiAltro = totalePesiAltro;
	}

	public Double getTotalePesi() {
		return totalePesi;
	}

	public void setTotalePesi(Double totalePesi) {
		this.totalePesi = totalePesi;
	}

	public PgMovimentoObj getPgMovimentoObj() {
		return pgMovimentoObj;
	}

	public void setPgMovimentoObj(PgMovimentoObj pgMovimentoObj) {
		this.pgMovimentoObj = pgMovimentoObj;
	}

	public PgCaricoObj getPgCaricoObj() {
		return pgCaricoObj;
	}

	public void setPgCaricoObj(PgCaricoObj pgCaricoObj) {
		this.pgCaricoObj = pgCaricoObj;
	}

	public String getAppunti() {
		return appunti;
	}

	public void setAppunti(String appunti) {
		this.appunti = appunti;
	}

	
}
