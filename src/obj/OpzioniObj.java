package obj;

import java.util.ArrayList;

public class OpzioniObj {
	int windowX = 0;
	int windowY = 0;
	int windowWidth = 0;
	int windowHeight = 0;
	boolean maximized = false;
	boolean migToJson = true;
	int lastId = 0;
	String lastFileName = "";
	String lingua = "";
	int dbArmaturaScudoDialogX = 0;
	int dbArmaturaScudoDialogY = 0;
	int dbArmaturaScudoDialogWidth = 0;
	int dbArmaturaScudoDialogHeight = 0;
	int dbArmiDialogX = 0;
	int dbArmiDialogY = 0;
	int dbArmiDialogWidth = 0;
	int dbArmiDialogHeight = 0;
	int dbAbilitaDialogX = 0;
	int dbAbilitaDialogY = 0;
	int dbAbilitaDialogWidth = 0;
	int dbAbilitaDialogHeight = 0;
	int dbTaglieDialogX = 0;
	int dbTaglieDialogY = 0;
	int dbTaglieDialogWidth = 0;
	int dbTaglieDialogHeight = 0;

	ArrayList<Integer> dimensioniTableDbArmatureScudi = new ArrayList<Integer>();
	ArrayList<Integer> dimensioniTableDbArmi = new ArrayList<Integer>();
	ArrayList<Integer> dimensioniTableDbAbilita = new ArrayList<Integer>();
	ArrayList<Integer> dimensioniTableDbTaglie = new ArrayList<Integer>();
	ArrayList<Integer> dimensioniTablePgClassi = new ArrayList<Integer>();
	ArrayList<Integer> dimensioniTablePgBonus = new ArrayList<Integer>();
	ArrayList<Integer> dimensioniTablePgArmi = new ArrayList<Integer>();
	ArrayList<Integer> dimensioniTablePgArmiRiepilogo = new ArrayList<Integer>();
	ArrayList<Integer> dimensioniTablePgAbilita = new ArrayList<Integer>();
	ArrayList<Integer> dimensioniTablePgTalenti = new ArrayList<Integer>();
	ArrayList<Integer> dimensioniTablePgLingue = new ArrayList<Integer>();
	ArrayList<Integer> dimensioniTablePgManovre = new ArrayList<Integer>();
	ArrayList<Integer> dimensioniTablePgEquip = new ArrayList<Integer>();

	public int getWindowX() {
		return windowX;
	}
	public void setWindowX(int windowX) {
		this.windowX = windowX;
	}
	public int getWindowY() {
		return windowY;
	}
	public void setWindowY(int windowY) {
		this.windowY = windowY;
	}
	public int getWindowWidth() {
		return windowWidth;
	}
	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}
	public int getWindowHeight() {
		return windowHeight;
	}
	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}
	public boolean isMaximized() {
		return maximized;
	}
	public void setMaximized(boolean maximized) {
		this.maximized = maximized;
	}
	public boolean isMigToJson() {
		return migToJson;
	}
	public void setMigToJson(boolean migToJson) {
		this.migToJson = migToJson;
	}
	public int getLastId() {
		return lastId;
	}
	public void setLastId(int lastId) {
		this.lastId = lastId;
	}
	public String getLastFileName() {
		return lastFileName;
	}
	public void setLastFileName(String lastFileName) {
		this.lastFileName = lastFileName;
	}
	
	public String getLingua() {
		return lingua;
	}
	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
	public int getDbArmaturaScudoDialogX() {
		return dbArmaturaScudoDialogX;
	}
	public void setDbArmaturaScudoDialogX(int dbArmaturaScudoDialogX) {
		this.dbArmaturaScudoDialogX = dbArmaturaScudoDialogX;
	}
	public int getDbArmaturaScudoDialogY() {
		return dbArmaturaScudoDialogY;
	}
	public void setDbArmaturaScudoDialogY(int dbArmaturaScudoDialogY) {
		this.dbArmaturaScudoDialogY = dbArmaturaScudoDialogY;
	}
	public int getDbArmaturaScudoDialogWidth() {
		return dbArmaturaScudoDialogWidth;
	}
	public void setDbArmaturaScudoDialogWidth(int dbArmaturaScudoDialogWidth) {
		this.dbArmaturaScudoDialogWidth = dbArmaturaScudoDialogWidth;
	}
	public int getDbArmaturaScudoDialogHeight() {
		return dbArmaturaScudoDialogHeight;
	}
	public void setDbArmaturaScudoDialogHeight(int dbArmaturaScudoDialogHeight) {
		this.dbArmaturaScudoDialogHeight = dbArmaturaScudoDialogHeight;
	}
	public int getDbArmiDialogX() {
		return dbArmiDialogX;
	}
	public void setDbArmiDialogX(int dbArmiDialogX) {
		this.dbArmiDialogX = dbArmiDialogX;
	}
	public int getDbArmiDialogY() {
		return dbArmiDialogY;
	}
	public void setDbArmiDialogY(int dbArmiDialogY) {
		this.dbArmiDialogY = dbArmiDialogY;
	}
	public int getDbArmiDialogWidth() {
		return dbArmiDialogWidth;
	}
	public void setDbArmiDialogWidth(int dbArmiDialogWidth) {
		this.dbArmiDialogWidth = dbArmiDialogWidth;
	}
	public int getDbArmiDialogHeight() {
		return dbArmiDialogHeight;
	}
	public void setDbArmiDialogHeight(int dbArmiDialogHeight) {
		this.dbArmiDialogHeight = dbArmiDialogHeight;
	}
	public int getDbAbilitaDialogX() {
		return dbAbilitaDialogX;
	}
	public void setDbAbilitaDialogX(int dbAbilitaDialogX) {
		this.dbAbilitaDialogX = dbAbilitaDialogX;
	}
	public int getDbAbilitaDialogY() {
		return dbAbilitaDialogY;
	}
	public void setDbAbilitaDialogY(int dbAbilitaDialogY) {
		this.dbAbilitaDialogY = dbAbilitaDialogY;
	}
	public int getDbAbilitaDialogWidth() {
		return dbAbilitaDialogWidth;
	}
	public void setDbAbilitaDialogWidth(int dbAbilitaDialogWidth) {
		this.dbAbilitaDialogWidth = dbAbilitaDialogWidth;
	}
	public int getDbAbilitaDialogHeight() {
		return dbAbilitaDialogHeight;
	}
	public void setDbAbilitaDialogHeight(int dbAbilitaDialogHeight) {
		this.dbAbilitaDialogHeight = dbAbilitaDialogHeight;
	}
	public int getDbTaglieDialogX() {
		return dbTaglieDialogX;
	}
	public void setDbTaglieDialogX(int dbTaglieDialogX) {
		this.dbTaglieDialogX = dbTaglieDialogX;
	}
	public int getDbTaglieDialogY() {
		return dbTaglieDialogY;
	}
	public void setDbTaglieDialogY(int dbTaglieDialogY) {
		this.dbTaglieDialogY = dbTaglieDialogY;
	}
	public int getDbTaglieDialogWidth() {
		return dbTaglieDialogWidth;
	}
	public void setDbTaglieDialogWidth(int dbTaglieDialogWidth) {
		this.dbTaglieDialogWidth = dbTaglieDialogWidth;
	}
	public int getDbTaglieDialogHeight() {
		return dbTaglieDialogHeight;
	}
	public void setDbTaglieDialogHeight(int dbTaglieDialogHeight) {
		this.dbTaglieDialogHeight = dbTaglieDialogHeight;
	}
	public ArrayList<Integer> getDimensioniTableDbArmatureScudi() {
		return dimensioniTableDbArmatureScudi;
	}
	public void setDimensioniTableDbArmatureScudi(ArrayList<Integer> dimensioniTableDbArmatureScudi) {
		this.dimensioniTableDbArmatureScudi = dimensioniTableDbArmatureScudi;
	}
	public ArrayList<Integer> getDimensioniTableDbArmi() {
		return dimensioniTableDbArmi;
	}
	public void setDimensioniTableDbArmi(ArrayList<Integer> dimensioniTableDbArmi) {
		this.dimensioniTableDbArmi = dimensioniTableDbArmi;
	}
	public ArrayList<Integer> getDimensioniTableDbAbilita() {
		return dimensioniTableDbAbilita;
	}
	public void setDimensioniTableDbAbilita(ArrayList<Integer> dimensioniTableDbAbilita) {
		this.dimensioniTableDbAbilita = dimensioniTableDbAbilita;
	}
	public ArrayList<Integer> getDimensioniTableDbTaglie() {
		return dimensioniTableDbTaglie;
	}
	public void setDimensioniTableDbTaglie(ArrayList<Integer> dimensioniTableDbTaglie) {
		this.dimensioniTableDbTaglie = dimensioniTableDbTaglie;
	}
	public ArrayList<Integer> getDimensioniTablePgClassi() {
		return dimensioniTablePgClassi;
	}
	public void setDimensioniTablePgClassi(ArrayList<Integer> dimensioniTablePgClassi) {
		this.dimensioniTablePgClassi = dimensioniTablePgClassi;
	}
	public ArrayList<Integer> getDimensioniTablePgBonus() {
		return dimensioniTablePgBonus;
	}
	public void setDimensioniTablePgBonus(ArrayList<Integer> dimensioniTablePgBonus) {
		this.dimensioniTablePgBonus = dimensioniTablePgBonus;
	}
	public ArrayList<Integer> getDimensioniTablePgArmi() {
		return dimensioniTablePgArmi;
	}
	public void setDimensioniTablePgArmi(ArrayList<Integer> dimensioniTablePgArmi) {
		this.dimensioniTablePgArmi = dimensioniTablePgArmi;
	}
	public ArrayList<Integer> getDimensioniTablePgArmiRiepilogo() {
		return dimensioniTablePgArmiRiepilogo;
	}
	public void setDimensioniTablePgArmiRiepilogo(ArrayList<Integer> dimensioniTablePgArmiRiepilogo) {
		this.dimensioniTablePgArmiRiepilogo = dimensioniTablePgArmiRiepilogo;
	}
	public ArrayList<Integer> getDimensioniTablePgAbilita() {
		return dimensioniTablePgAbilita;
	}
	public void setDimensioniTablePgAbilita(ArrayList<Integer> dimensioniTablePgAbilita) {
		this.dimensioniTablePgAbilita = dimensioniTablePgAbilita;
	}
	public ArrayList<Integer> getDimensioniTablePgTalenti() {
		return dimensioniTablePgTalenti;
	}
	public void setDimensioniTablePgTalenti(ArrayList<Integer> dimensioniTablePgTalenti) {
		this.dimensioniTablePgTalenti = dimensioniTablePgTalenti;
	}
	public ArrayList<Integer> getDimensioniTablePgLingue() {
		return dimensioniTablePgLingue;
	}
	public void setDimensioniTablePgLingue(ArrayList<Integer> dimensioniTablePgLingue) {
		this.dimensioniTablePgLingue = dimensioniTablePgLingue;
	}
	public ArrayList<Integer> getDimensioniTablePgManovre() {
		return dimensioniTablePgManovre;
	}
	public void setDimensioniTablePgManovre(ArrayList<Integer> dimensioniTablePgManovre) {
		this.dimensioniTablePgManovre = dimensioniTablePgManovre;
	}
	public ArrayList<Integer> getDimensioniTablePgEquip() {
		return dimensioniTablePgEquip;
	}
	public void setDimensioniTablePgEquip(ArrayList<Integer> dimensioniTablePgEquip) {
		this.dimensioniTablePgEquip = dimensioniTablePgEquip;
	}


	
}
