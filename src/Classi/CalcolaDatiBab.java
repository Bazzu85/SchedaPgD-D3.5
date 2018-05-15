package Classi;

import java.util.ArrayList;

import json.GestioneJsonItems;
import obj.DbTaglieObj;
import obj.PgBabObj;
import obj.PgBonusCalcolati;
import obj.PgClasseObj;
import obj.PgDatiObj;

public class CalcolaDatiBab {

	GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();

	public PgDatiObj calcola(PgDatiObj pgDatiObj) {
		PgBabObj pgBabObj = pgDatiObj.getPgBabObj();
	
		// Recupero bonus settati dall'utente
		PgBonusCalcolati pgBonusCalcolati = pgDatiObj.getPgBonusCalcolati();
		
		// Recupero dati delle classi
		ArrayList<PgClasseObj> arrayClassi = pgDatiObj.getArrayClassi();
	
		pgBabObj.setBabClasse1(0);
		pgBabObj.setBabClasse2(0);
		pgBabObj.setBabClasse3(0);
		pgBabObj.setBabClasse4(0);
		pgBabObj.setBabClasse5(0);
		pgBabObj.setBabClasse6(0);
	
		// Valorizzazione BAB classi
		for (int i=0; i <arrayClassi.size(); i++){
			switch (i){
			case 0:
				pgBabObj.setBabClasse1(arrayClassi.get(i).getBabClasse());
				break;
			case 1:
				pgBabObj.setBabClasse2(arrayClassi.get(i).getBabClasse());
				break;
			case 2:
				pgBabObj.setBabClasse3(arrayClassi.get(i).getBabClasse());
				break;
			case 3:
				pgBabObj.setBabClasse4(arrayClassi.get(i).getBabClasse());
				break;
			case 4:
				pgBabObj.setBabClasse5(arrayClassi.get(i).getBabClasse());
				break;
			case 5:
				pgBabObj.setBabClasse6(arrayClassi.get(i).getBabClasse());
				break;
			}
		}
		
		pgBabObj.setMischiaAltro(pgBonusCalcolati.getModificatoreBabMischia());
		pgBabObj.setDistanzaAltro(pgBonusCalcolati.getModificatoreBabDistanza());
	
		// Somma BAB classi per BAB totale e divisione nei vari attacchi
		int babSommato = 0;
		babSommato = pgBabObj.getBabClasse1() + pgBabObj.getBabClasse2() + pgBabObj.getBabClasse3()
				+ pgBabObj.getBabClasse4() + pgBabObj.getBabClasse5() + pgBabObj.getBabClasse6();
		int babRimanente = babSommato;
	
		// Pulizia campi di attacchi base per ricalcolo
		pgBabObj.setAttaccoBase1(0);
		pgBabObj.setAttaccoBase2(0);
		pgBabObj.setAttaccoBase3(0);
		pgBabObj.setAttaccoBase4(0);
		pgBabObj.setAttaccoBase5(0);
		pgBabObj.setAttaccoBase6(0);
		pgBabObj.setAttaccoBase7(0);
		pgBabObj.setAttaccoBase8(0);
	
		pgBabObj.setAttaccoBase1(babRimanente);
		babRimanente = babRimanente - 5;
		int i = 1;
		while (babRimanente > 0) {
			i = i + 1;
			switch (i) {
			case 2:
				pgBabObj.setAttaccoBase2(babRimanente);
				babRimanente = babRimanente - 5;
				break;
			case 3:
				pgBabObj.setAttaccoBase3(babRimanente);
				babRimanente = babRimanente - 5;
				break;
			case 4:
				pgBabObj.setAttaccoBase4(babRimanente);
				babRimanente = babRimanente - 5;
				break;
			case 5:
				pgBabObj.setAttaccoBase5(babRimanente);
				babRimanente = babRimanente - 5;
				break;
			case 6:
				pgBabObj.setAttaccoBase6(babRimanente);
				babRimanente = babRimanente - 5;
				break;
			case 7:
				pgBabObj.setAttaccoBase7(babRimanente);
				babRimanente = babRimanente - 5;
				break;
			case 8:
				pgBabObj.setAttaccoBase8(babRimanente);
				babRimanente = babRimanente - 5;
				break;
			default:
				babRimanente = 0;
				break;
			}
		}
		
		String bab = calcolaBab(pgBabObj);
		pgBabObj.setBab(bab);

		// Calcolo bonus di taglia per mischia
		if (!pgDatiObj.getTaglia().trim().isEmpty()){
			DbTaglieObj dbTaglieObj = gestioneJsonItems.getTagliaByName(pgDatiObj.getTaglia());
			pgBabObj.setMischiaTaglia(dbTaglieObj.getModTaglia());
		} else {
			pgBabObj.setMischiaTaglia(0);
		}
	
	
		// Calcolo bonus di forza per mischia
		if (pgDatiObj.getPgStatisticheObj().getForzaTempMod() > 0) {
			pgBabObj.setMischiaForza(pgDatiObj.getPgStatisticheObj().getForzaTempMod());
		} else {
			pgBabObj.setMischiaForza(pgDatiObj.getPgStatisticheObj().getForzaMod());
		}
	
		// Calcolo bonus attacco in mischia
		String babMischia = calcolaBabMischiaTotale(pgBabObj, 0);
		pgBabObj.setMischiaTotale(babMischia);
	
		// Calcolo bonus di destezza per attacco a distanza
		if (pgDatiObj.getPgStatisticheObj().getDestrezzaTempMod() > 0) {
			pgBabObj.setDistanzaDestrezza(pgDatiObj.getPgStatisticheObj().getDestrezzaTempMod());
		} else {
			pgBabObj.setDistanzaDestrezza(pgDatiObj.getPgStatisticheObj().getDestrezzaMod());
		}
		
		// Calcolo bonus attacco a distanza
		String babDistanza = calcolaBabDistanzaTotale(pgBabObj, 0);
		pgBabObj.setDistanzaTotale(babDistanza);
	
		// Calcolo bonus di taglia speciale per lottare
		if (!pgDatiObj.getTaglia().trim().isEmpty()){
			DbTaglieObj dbTaglieObj = gestioneJsonItems.getTagliaByName(pgDatiObj.getTaglia());
			pgBabObj.setLottareTaglia(dbTaglieObj.getModTagliaSpeciale());
		} else {
			pgBabObj.setLottareTaglia(0);
		}
	
		// Calcolo bonus forza per lottare
		if (pgDatiObj.getPgStatisticheObj().getForzaTempMod() > 0) {
			pgBabObj.setLottareForza(pgDatiObj.getPgStatisticheObj().getForzaTempMod());
		} else {
			pgBabObj.setLottareForza(pgDatiObj.getPgStatisticheObj().getForzaMod());
		}
	
		// Calcolo bonus totale lottare
		String babLottare = calcolaBabLottareTotale(pgBabObj, 0);
		pgBabObj.setLottareTotale(babLottare);
	
		// Calcolo penalità combattere a 2 armi
		if (pgBabObj.isTalento2Armi()){
			pgBabObj.setPenalità2ArmiPrimaria(-4);
			pgBabObj.setPenalità2ArmiSecondaria(-4);
		} else {
			pgBabObj.setPenalità2ArmiPrimaria(-6);
			pgBabObj.setPenalità2ArmiSecondaria(-10);
		}

		pgDatiObj.setPgBabObj(pgBabObj);
		
		return pgDatiObj;
	}

	private String calcolaBab(PgBabObj pgBabObj) {
		// Calcolo stringa Bonus Attacco Base
		String bab = "";
		if (pgBabObj.getAttaccoBase1() > 0) {
			bab = bab + "+" + pgBabObj.getAttaccoBase1();
		}
		if (pgBabObj.getAttaccoBase2() > 0) {
			bab = bab + "/" + "+" + pgBabObj.getAttaccoBase2();
		}
		if (pgBabObj.getAttaccoBase3() > 0) {
			bab = bab + "/" + "+" + pgBabObj.getAttaccoBase3();
		}
		if (pgBabObj.getAttaccoBase4() > 0) {
			bab = bab + "/" + "+" + pgBabObj.getAttaccoBase4();
		}
		if (pgBabObj.getAttaccoBase5() > 0) {
			bab = bab + "/" + "+" + pgBabObj.getAttaccoBase5();
		}
		if (pgBabObj.getAttaccoBase6() > 0) {
			bab = bab + "/" + "+" + pgBabObj.getAttaccoBase6();
		}
		if (pgBabObj.getAttaccoBase7() > 0) {
			bab = bab + "/" + "+" + pgBabObj.getAttaccoBase7();
		}
		if (pgBabObj.getAttaccoBase8() > 0) {
			bab = bab + "/" + "+" + pgBabObj.getAttaccoBase8();
		}
		return bab;
	
	}

	public String calcolaBabMischiaTotale(PgBabObj pgBabObj, int modCalcolato) {
		
		String babTotale = "";
		int totale = 0;
		
		int bonusTotale = pgBabObj.getMischiaTaglia() + pgBabObj.getMischiaForza() + pgBabObj.getMischiaAltro()
				+ modCalcolato;

		if (pgBabObj.getAttaccoBase1() > 0) {
			totale = pgBabObj.getAttaccoBase1() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "+" + totale;
			} else {
				babTotale = babTotale + totale;
			}
		}
		if (pgBabObj.getAttaccoBase2() > 0) {
			totale = pgBabObj.getAttaccoBase2() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase3() > 0) {
			totale = pgBabObj.getAttaccoBase3() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase4() > 0) {
			totale = pgBabObj.getAttaccoBase4() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase5() > 0) {
			totale = pgBabObj.getAttaccoBase5() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase6() > 0) {
			totale = pgBabObj.getAttaccoBase6() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase7() > 0) {
			totale = pgBabObj.getAttaccoBase7() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase8() > 0) {
			totale = pgBabObj.getAttaccoBase8() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		return babTotale;
	}

	public String calcolaBabDistanzaTotale(PgBabObj pgBabObj, int modCalcolato) {
		String babTotale = "";
		int totale = 0;
		int bonusTotale = pgBabObj.getDistanzaDestrezza() + pgBabObj.getDistanzaAltro() + modCalcolato;

		if (pgBabObj.getAttaccoBase1() > 0) {
			totale = pgBabObj.getAttaccoBase1() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "+" + totale;
			} else {
				babTotale = babTotale + totale;
			}
		}
		if (pgBabObj.getAttaccoBase2() > 0) {
			totale = pgBabObj.getAttaccoBase2() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase3() > 0) {
			totale = pgBabObj.getAttaccoBase3() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase4() > 0) {
			totale = pgBabObj.getAttaccoBase4() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase5() > 0) {
			totale = pgBabObj.getAttaccoBase5() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase6() > 0) {
			totale = pgBabObj.getAttaccoBase6() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase7() > 0) {
			totale = pgBabObj.getAttaccoBase7() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase8() > 0) {
			totale = pgBabObj.getAttaccoBase8() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		return babTotale;

	}

	private String calcolaBabLottareTotale(PgBabObj pgBabObj, int modCalcolato) {
		String babTotale = "";
		int totale = 0;
		int bonusTotale = pgBabObj.getLottareTaglia() + pgBabObj.getLottareForza() + modCalcolato;
	
		if (pgBabObj.getAttaccoBase1() > 0) {
			totale = pgBabObj.getAttaccoBase1() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "+" + totale;
			} else {
				babTotale = babTotale + totale;
			}

		}
		if (pgBabObj.getAttaccoBase2() > 0) {
			totale = pgBabObj.getAttaccoBase2() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase3() > 0) {
			totale = pgBabObj.getAttaccoBase3() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase4() > 0) {
			totale = pgBabObj.getAttaccoBase4() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase5() > 0) {
			totale = pgBabObj.getAttaccoBase5() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase6() > 0) {
			totale = pgBabObj.getAttaccoBase6() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase7() > 0) {
			totale = pgBabObj.getAttaccoBase7() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		if (pgBabObj.getAttaccoBase8() > 0) {
			totale = pgBabObj.getAttaccoBase8() + bonusTotale;
			if (totale > 0){
				babTotale = babTotale + "/" + "+" + totale;
			} else {
				babTotale = babTotale + "/" + totale;
			}
		}
		return babTotale;
	}

}
