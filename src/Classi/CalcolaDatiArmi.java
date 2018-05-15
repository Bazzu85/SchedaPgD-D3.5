package Classi;

import java.util.ArrayList;

import json.GestioneJsonItems;
import obj.DbArmiObj;
import obj.PgArmiObj;
import obj.PgArmiRiepilogoObj;
import obj.PgBabObj;
import obj.PgDatiObj;

public class CalcolaDatiArmi {

	GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();
	boolean armaSecondariaLeggera = false;

	public PgDatiObj calcola(PgDatiObj pgDatiObj) {

		// Recupero dei dati del BAB
		PgBabObj pgBabObj = pgDatiObj.getPgBabObj();

		// Recupero array armi
		ArrayList<PgArmiObj> arrayPgArmi = pgDatiObj.getArrayArmi();
		ArrayList<PgArmiRiepilogoObj> arrayPgArmiRiepilogo = new ArrayList<PgArmiRiepilogoObj>();
		
		// Recupero se presente l'arma secondaria se è leggera
		for (int i = 0; i < arrayPgArmi.size(); i++) {
			PgArmiObj pgArmiObj = arrayPgArmi.get(i);

			if (pgArmiObj.getPrimariaSecondaria().equals("Secondaria")){
				DbArmiObj dbArmiObj = gestioneJsonItems.getArmaByName(pgArmiObj.getArma());
				if (dbArmiObj.getCategoria2().equals("Leggera")){
					armaSecondariaLeggera = true;
				}
			}
		}
		for (int i = 0; i < arrayPgArmi.size(); i++) {
			PgArmiObj pgArmiObj = arrayPgArmi.get(i);

			// Se l'arma è equipaggiata calcoliamo l'oggetto pgArmiRiepilogoObj
			if (pgArmiObj.isEquipaggiata()) {
				PgArmiRiepilogoObj pgArmiRiepilogoObj = calcolaPgArmiRiepilogo(pgArmiObj, pgBabObj);
				arrayPgArmiRiepilogo.add(pgArmiRiepilogoObj);
			}
		}

		pgDatiObj.setArrayArmiRiepilogo(arrayPgArmiRiepilogo);
		return pgDatiObj;

	}

	private PgArmiRiepilogoObj calcolaPgArmiRiepilogo(PgArmiObj pgArmiObj, PgBabObj pgBabObj) {

		PgArmiRiepilogoObj pgArmiRiepilogoObj = new PgArmiRiepilogoObj();

		// TODO TABELLA RIEPILOGO (solo per le armi equipaggiate)
		// Calcolo nome completo
		String armaRiepilogo = pgArmiObj.getArma();

		// Aggiungiamo la taglia
		armaRiepilogo = armaRiepilogo + " (" + pgArmiObj.getTaglia() + ")";

		// Aggiungiamo il modificatore
		if (pgArmiObj.getMod() != 0) {
			String mod = "";
			if (pgArmiObj.getMod() > 0) {
				mod = " (+" + pgArmiObj.getMod() + ")";
			} else {
				mod = " (-" + pgArmiObj.getMod() + ")";

			}
			armaRiepilogo = armaRiepilogo + mod;
		}

		// Aggiungiamo l'incantamento
		if (!pgArmiObj.getIncantamenti().trim().isEmpty()) {
			armaRiepilogo = armaRiepilogo + " / " + pgArmiObj.getIncantamenti();
		}

		pgArmiRiepilogoObj.setArmaRiepilogo(armaRiepilogo);

		// Recupero dal db dei dati dell'arma
		DbArmiObj dbArmiObj = gestioneJsonItems.getArmaByName(pgArmiObj.getArma());

		// CALCOLO BONUS ATTACCO TOTALE SINGOLO ATTACCO
		String batSingoloAttacco = calcolaBonusAttaccoTotaleSingoloAttacco(pgArmiObj, pgBabObj, dbArmiObj);
		pgArmiRiepilogoObj.setBatSingoloAttacco(batSingoloAttacco);

		// CALCOLO BONUS ATTACCO TOTALE DOPPIO ATTACCO
		String batDoppioAttacco = "";
		if (pgArmiObj.isDoppiaArma()){
			batDoppioAttacco = calcolaBonusAttaccoTotaleDoppioAttacco(pgArmiObj, pgBabObj, dbArmiObj);	
		} else {
			batDoppioAttacco = "-";
		}
		
		pgArmiRiepilogoObj.setBatDoppioAttacco(batDoppioAttacco);

		// Calcolo danno totale
		String dannoTotale = calcolaDannoTotale(pgArmiObj, dbArmiObj, pgBabObj);
		pgArmiRiepilogoObj.setDannoTotale(dannoTotale);

		// Valorizzazione incremento gittata
		pgArmiRiepilogoObj.setIncrementoGittata(dbArmiObj.getIncrementoGittata());
		// Valorizzazione critico
		pgArmiRiepilogoObj.setCritico(dbArmiObj.getCritico());
		// Valorizzazione tipo
		pgArmiRiepilogoObj.setTipo(dbArmiObj.getTipo());

		return pgArmiRiepilogoObj;

	}

	private String calcolaBonusAttaccoTotaleSingoloAttacco(PgArmiObj pgArmiObj, PgBabObj pgBabObj,
			DbArmiObj dbArmiObj) {
		// Calcolo modificatori settati per l'arma
		int modCalcolato = 0;
		if (pgArmiObj.getMod() == 0 && pgArmiObj.getQualita().equals("Perfetta")) {
			modCalcolato = modCalcolato + 1;
		} else {
			modCalcolato = modCalcolato + pgArmiObj.getMod();
		}
		modCalcolato = modCalcolato + pgArmiObj.getModBab();

		// Calcolo bonus attacco totale
		String babTotale = "";
		CalcolaDatiBab calcolaDatiBab = new CalcolaDatiBab();

		// Calcolo Bab in mischia
		if (dbArmiObj.isMischia()) {
			babTotale = calcolaDatiBab.calcolaBabMischiaTotale(pgBabObj, modCalcolato);
		}

		// Calcolo Bab a distanza
		if (dbArmiObj.isDistanza()) {
			babTotale = calcolaDatiBab.calcolaBabDistanzaTotale(pgBabObj, modCalcolato);

		}
		return babTotale;
	}

	private String calcolaBonusAttaccoTotaleDoppioAttacco(PgArmiObj pgArmiObj, PgBabObj pgBabObj, DbArmiObj dbArmiObj) {
		
	
		// Calcolo modificatori settati per l'arma
		int modCalcolato = 0;
		if (pgArmiObj.getMod() == 0 && pgArmiObj.getQualita().equals("Perfetta")) {
			modCalcolato = modCalcolato + 1;
		} else {
			modCalcolato = modCalcolato + pgArmiObj.getMod();
		}
		modCalcolato = modCalcolato + pgArmiObj.getModBab();

		// Calcolo modificatore per il doppio attacco
		// Tabella dei MALUS per il doppio attacco
		// Se arma secondaria leggera:
		//    Senza talento combattere a 2 armi -4/-8
		//    Con talento combattere a 2 armi -2/-2
		// Se arma secondaria NON leggera:
		//    Senza talento combattere a 2 armi -6/-10
		//    Con talento combattere a 2 armi -4/-8
		if (pgArmiObj.getPrimariaSecondaria().equals("Secondaria")){
			if (armaSecondariaLeggera){
				if (pgBabObj.isTalento2Armi()){
					modCalcolato = modCalcolato - 2;
				} else {
					modCalcolato = modCalcolato - 8;
				}
			} else {
				if (pgBabObj.isTalento2Armi()){
					modCalcolato = modCalcolato - 8;
				} else {
					modCalcolato = modCalcolato - 10;
				}
			}
		} else {
			if (armaSecondariaLeggera){
				if (pgBabObj.isTalento2Armi()){
					modCalcolato = modCalcolato - 2;
				} else {
					modCalcolato = modCalcolato - 4;
				}
			} else {
				if (pgBabObj.isTalento2Armi()){
					modCalcolato = modCalcolato - 4;
				} else {
					modCalcolato = modCalcolato - 6;
				}
			}
		}
		// Calcolo bonus attacco totale
		String babTotale = "";
		CalcolaDatiBab calcolaDatiBab = new CalcolaDatiBab();

		// Calcolo Bab in mischia
		if (dbArmiObj.isMischia()) {
			babTotale = calcolaDatiBab.calcolaBabMischiaTotale(pgBabObj, modCalcolato);
		}

		// Calcolo Bab a distanza
		if (dbArmiObj.isDistanza()) {
			babTotale = calcolaDatiBab.calcolaBabDistanzaTotale(pgBabObj, modCalcolato);

		}
		return babTotale;
	}

	private String calcolaDannoTotale(PgArmiObj pgArmiObj, DbArmiObj dbArmiObj, PgBabObj pgBabObj) {

		String dannoTotale = "";
		// impostiamo il danno base dell'arma sulla base della taglia
		switch (pgArmiObj.getTaglia()) {
		case "P":
			dannoTotale = dannoTotale + dbArmiObj.getDanniP();
			break;
		case "M":
			dannoTotale = dannoTotale + dbArmiObj.getDanniM();
			break;
		case "G":
			dannoTotale = dannoTotale + dbArmiObj.getDanniG();
			break;
		}

		// Calcolo bonus al danno
		int bonusDannoTotale = 0;

		// Per le armi da mischia il calcolo è Bonus magico +
		// modificatore forza + modificatore forza/2 se arma tenuta a 2
		// mani + modificatore danno utente
		if (dbArmiObj.isMischia()) {
			int bonusForza = 0;
			if (pgArmiObj.isA2Mani()) {
				bonusForza = pgBabObj.getMischiaForza() / 2;
			}
			bonusDannoTotale = bonusDannoTotale + pgArmiObj.getMod() + pgBabObj.getMischiaForza() + bonusForza
					+ pgArmiObj.getModDanno();
		}
		if (dbArmiObj.isDistanza()) {
			bonusDannoTotale = bonusDannoTotale + pgArmiObj.getMod() + pgArmiObj.getModDanno();
		}

		if (bonusDannoTotale != 0) {
			if (bonusDannoTotale > 0) {
				dannoTotale = dannoTotale + "+" + bonusDannoTotale;
			} else {
				dannoTotale = dannoTotale + bonusDannoTotale;
			}
		}

		// aggiungiamo evantuali d6 sulla base degli attributi
		if (!pgArmiObj.getBonusIncantamenti().trim().isEmpty()) {
			dannoTotale = dannoTotale + "+" + pgArmiObj.getBonusIncantamenti();
		}
		return dannoTotale;
	}

}
