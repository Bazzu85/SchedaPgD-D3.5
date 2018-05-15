package Classi;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ENUM.ListaDbArmi;
import ENUM.ListaPgClasseArmatura;
import ENUM.ListaDbAbilita;
import ENUM.ListaDbArmaturaScudo;
import ENUM.ListaDbTaglie;
import ENUM.ListaPgAbilita;
import ENUM.ListaPgArmi;
import ENUM.ListaPgBab;
import ENUM.ListaPgBonus;
import ENUM.ListaPgClasse;
import ENUM.ListaPgDati;
import ENUM.ListaPgEquip;
import ENUM.ListaPgIniziativa;
import ENUM.ListaPgLingue;
import ENUM.ListaPgManovre;
import ENUM.ListaPgMovimento;
import ENUM.ListaPgPuntiFerita;
import ENUM.ListaPgStatistiche;
import ENUM.ListaPgTalenti;
import ENUM.ListaPgTiriSalvezza;
import json.GestioneJsonItems;
import obj.DbAbilitaObj;
import obj.DbArmaturaScudoObj;
import obj.DbArmiObj;
import obj.DbTaglieObj;
import obj.PgAbilitaObj;
import obj.PgArmiObj;
import obj.PgBabObj;
import obj.PgBonusCalcolati;
import obj.PgBonusObj;
import obj.PgClasseArmaturaObj;
import obj.PgClasseObj;
import obj.PgDatiObj;
import obj.PgEquipObj;
import obj.PgIniziativaObj;
import obj.PgLingueObj;
import obj.PgManovreObj;
import obj.PgMovimentoObj;
import obj.PgPuntiFeritaObj;
import obj.PgStatisticheObj;
import obj.PgTalentiObj;
import obj.PgTiriSalvezzaObj;

public class AggiornaOggetti {

	CalcolaDati calcolaDati = new CalcolaDati();
	GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();

	@SuppressWarnings("unchecked")
	public PgDatiObj aggiornaPgDatiObj(PgDatiObj pgDatiObj, ListaPgDati dato, Object valore) {
		switch (dato) {
		case NOME_PG:
			if (pgDatiObj.getNomePg().equals(valore)) {
			} else {
				pgDatiObj.setNomePg((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case NOME_GIOCATORE:
			if (pgDatiObj.getNomeGiocatore().equals(valore)) {
			} else {
				pgDatiObj.setNomeGiocatore((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case LUOGO_DATA_NASCITA:
			if (pgDatiObj.getLuogoDataNascita().equals(valore)) {
			} else {
				pgDatiObj.setLuogoDataNascita((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case RAZZA:
			if (pgDatiObj.getRazza().equals(valore)) {
			} else {
				pgDatiObj.setRazza((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case SESSO:
			if (pgDatiObj.getSesso().equals(valore)) {
			} else {
				pgDatiObj.setSesso((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case PELLE:
			if (pgDatiObj.getPelle().equals(valore)) {
			} else {
				pgDatiObj.setPelle((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case ETA:
			if (pgDatiObj.getEta().equals(valore)) {
			} else {
				pgDatiObj.setEta((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case ALTEZZA:
			if (pgDatiObj.getAltezza().equals(valore)) {
			} else {
				pgDatiObj.setAltezza((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case PESO:
			if (pgDatiObj.getPeso().equals(valore)) {
			} else {
				pgDatiObj.setPeso((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case CAPELLI:
			if (pgDatiObj.getCapelli().equals(valore)) {
			} else {
				pgDatiObj.setCapelli((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case OCCHI:
			if (pgDatiObj.getOcchi().equals(valore)) {
			} else {
				pgDatiObj.setOcchi((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case ALLINEAMENTO:
			if (pgDatiObj.getAllineamento().equals(valore)) {
			} else {
				pgDatiObj.setAllineamento((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case TAGLIA:
			if (pgDatiObj.getTaglia().equals(valore)) {
			} else {
				pgDatiObj.setTaglia((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case ARRAY_CLASSI:
			ArrayList<PgClasseObj> arrayClassi = new ArrayList<PgClasseObj>();
			arrayClassi = ((ArrayList<PgClasseObj>) valore);
			boolean arrayClassiVariato = false;

			if (arrayClassi.size()== 0){
				arrayClassiVariato = true;
			}
			for (int i = 0; i < arrayClassi.size(); i++) {
				if (arrayClassi.get(i).isDatiVariati()) {
					arrayClassiVariato = true;
				}
			}
			// Aggiorniamo la tabella delle classi solo se sono stati
			// variati dati
			if (arrayClassiVariato) {
				// Aggiornamento dei dati calcolati
				pgDatiObj = calcolaDati.calcola(pgDatiObj);
				pgDatiObj.setDatiCommittati(false);
			}
			pgDatiObj.setArrayClassi(arrayClassi);
			break;
		case PX:
			if (pgDatiObj.getPx() == Integer.parseInt((String) valore)) {
			} else {
				pgDatiObj.setPx(Integer.parseInt((String) valore));
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case PX_PENALITA:
			if (pgDatiObj.getPxPenalita() == Integer.parseInt((String) valore)) {
			} else {
				pgDatiObj.setPxPenalita(Integer.parseInt((String) valore));
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case ARRAY_BONUS:
			ArrayList<PgBonusObj> arrayPgBonus = ((ArrayList<PgBonusObj>) valore);
			boolean arrayBonusVariato = false;

			if (arrayPgBonus.size() == 0){
				arrayBonusVariato = true;
			}
			// System.out.println("arrayClassi.size(): " + arrayClassi.size());
			for (int i = 0; i < arrayPgBonus.size(); i++) {
				if (arrayPgBonus.get(i).isDatiVariati()) {
					// System.out.println("arrayClassiVariato");
					arrayBonusVariato = true;
				}
			}
			// Aggiorniamo la tabella delle classi solo se sono stati
			// variati dati
			if (arrayBonusVariato) {
				// Aggiornamento dei dati calcolati
				pgDatiObj = calcolaDati.calcola(pgDatiObj);
				pgDatiObj.setDatiCommittati(false);
			}

			// Ricalcolo oggetto dei bonus calcolati
			PgBonusCalcolati pgBonusCalcolati = new PgBonusCalcolati();
			pgBonusCalcolati = GestioneBonusCalcolati.calcola(arrayPgBonus);
			pgDatiObj.setPgBonusCalcolati(pgBonusCalcolati);
			pgDatiObj.setArrayBonus(arrayPgBonus);
			break;
		case ARRAY_ARMI:
			ArrayList<PgArmiObj> arrayPgArmi = new ArrayList<PgArmiObj>();
			arrayPgArmi = ((ArrayList<PgArmiObj>) valore);
			boolean arrayArmiVariato = false;

			if (arrayPgArmi.size()== 0){
				arrayArmiVariato = true;
			}
			// System.out.println("arrayClassi.size(): " + arrayClassi.size());
			for (int i = 0; i < arrayPgArmi.size(); i++) {
				if (arrayPgArmi.get(i).isDatiVariati()) {
					// System.out.println("arrayClassiVariato");
					arrayArmiVariato = true;
				}
			}
			// Aggiorniamo la tabella solo se sono stati
			// variati dati
			if (arrayArmiVariato) {
				// Aggiornamento dei dati calcolati
				pgDatiObj = calcolaDati.calcola(pgDatiObj);
				pgDatiObj.setDatiCommittati(false);
			}

			pgDatiObj.setArrayArmi(arrayPgArmi);
			break;
		case ARRAY_ABILITA:
			ArrayList<PgAbilitaObj> arrayPgAbilita = new ArrayList<PgAbilitaObj>();
			arrayPgAbilita = ((ArrayList<PgAbilitaObj>) valore);
			boolean arrayAbilitaVariato = false;

			if (arrayPgAbilita.size()== 0){
				arrayAbilitaVariato = true;
			}
			for (int i = 0; i < arrayPgAbilita.size(); i++) {
				if (arrayPgAbilita.get(i).isDatiVariati()) {
					arrayAbilitaVariato = true;
				}
			}
			if (arrayAbilitaVariato) {
				// Aggiornamento dei dati calcolati
				pgDatiObj = calcolaDati.calcola(pgDatiObj);
				pgDatiObj.setDatiCommittati(false);
			}

			pgDatiObj.setArrayAbilita(arrayPgAbilita);
			break;
		case ARRAY_TALENTI:
			ArrayList<PgTalentiObj> arrayPgTalenti = new ArrayList<PgTalentiObj>();
			arrayPgTalenti = ((ArrayList<PgTalentiObj>) valore);
			boolean arrayTalentiVariato = false;

			if (arrayPgTalenti.size()== 0){
				arrayTalentiVariato = true;
			}
			for (int i = 0; i < arrayPgTalenti.size(); i++) {
				if (arrayPgTalenti.get(i).isDatiVariati()) {
					arrayTalentiVariato = true;
				}
			}
			if (arrayTalentiVariato) {
				// Aggiornamento dei dati calcolati
				pgDatiObj = calcolaDati.calcola(pgDatiObj);
				pgDatiObj.setDatiCommittati(false);
			}

			pgDatiObj.setArrayTalenti(arrayPgTalenti);
			break;
		case TITOLI:
			if (pgDatiObj.getTitoli().equals(valore)) {
			} else {
				pgDatiObj.setTitoli((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case TRATTI_RAZZIALI:
			if (pgDatiObj.getTrattiRazziali().equals(valore)) {
			} else {
				pgDatiObj.setTrattiRazziali((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case PRIVILEGI_DI_CLASSE:
			if (pgDatiObj.getPrivilegiDiClasse().equals(valore)) {
			} else {
				pgDatiObj.setPrivilegiDiClasse((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case ARRAY_LINGUE:
			ArrayList<PgLingueObj> arrayLingue = ((ArrayList<PgLingueObj>) valore);
			boolean arrayLingueVariato = false;

			if (arrayLingue.size()== 0){
				arrayLingueVariato = true;
			}
			for (int i = 0; i < arrayLingue.size(); i++) {
				if (arrayLingue.get(i).isDatiVariati()) {
					arrayLingueVariato = true;
				}
			}
			// Aggiorniamo la tabella delle classi solo se sono stati
			// variati dati
			if (arrayLingueVariato) {
				// Aggiornamento dei dati calcolati
				pgDatiObj = calcolaDati.calcola(pgDatiObj);
				pgDatiObj.setDatiCommittati(false);
			}
			pgDatiObj.setArrayLingue(arrayLingue);
			break;
		case ARRAY_MANOVRE:
			ArrayList<PgManovreObj> arrayManovre = ((ArrayList<PgManovreObj>) valore);
			boolean arrayManovreVariato = false;

			if (arrayManovre.size()== 0){
				arrayManovreVariato = true;
			}
			for (int i = 0; i < arrayManovre.size(); i++) {
				if (arrayManovre.get(i).isDatiVariati()) {
					arrayManovreVariato = true;
				}
			}
			// Aggiorniamo la tabella solo se sono stati
			// variati dati
			if (arrayManovreVariato) {
				// Aggiornamento dei dati calcolati
				pgDatiObj = calcolaDati.calcola(pgDatiObj);
				pgDatiObj.setDatiCommittati(false);
			}
			pgDatiObj.setArrayManovre(arrayManovre);
			break;
		case MANOVRE_PANEL:
			if (pgDatiObj.isManovrePanel() == Boolean.valueOf(valore.toString())) {
			} else {
				pgDatiObj.setManovrePanel(Boolean.valueOf(valore.toString()));
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		case ARRAY_EQUIP:
			ArrayList<PgEquipObj> arrayEquip = ((ArrayList<PgEquipObj>) valore);
			boolean arrayEquipVariato = false;

			if (arrayEquip.size()== 0){
				arrayEquipVariato = true;
			}
			for (int i = 0; i < arrayEquip.size(); i++) {
				if (arrayEquip.get(i).isDatiVariati()) {
					arrayEquipVariato = true;
				}
			}
			// Aggiorniamo la tabella solo se sono stati
			// variati dati
			if (arrayEquipVariato) {
				// Aggiornamento dei dati calcolati
//				pgDatiObj = calcolaDati.calcola(pgDatiObj);
				pgDatiObj.setDatiCommittati(false);
			}
			pgDatiObj.setArrayEquip(arrayEquip);
			break;
		case INDEX_MANOVRE_PANEL:
			if (((String) valore).trim().isEmpty()) {
				pgDatiObj.setIndexManovrePanel(0);
			} else {
				if (pgDatiObj.getIndexManovrePanel() == Integer.parseInt((String) valore)) {
				} else {
					pgDatiObj.setIndexManovrePanel(Integer.parseInt((String) valore));
					pgDatiObj.setDatiVariati(true);
				}
			}
			break;
		case APPUNTI:
			if (pgDatiObj.getAppunti().equals(valore)) {
			} else {
				pgDatiObj.setAppunti((String) valore);
				pgDatiObj.setDatiVariati(true);
				pgDatiObj.setDatiCommittati(false);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return pgDatiObj;
	}

	public PgDatiObj aggiornaStatistiche(PgDatiObj pgDatiObj, ListaPgStatistiche dato, Object valore) {
		PgStatisticheObj pgStatisticheObj = new PgStatisticheObj();
		pgStatisticheObj = pgDatiObj.getPgStatisticheObj();
		switch (dato) {
		case FORZA:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setForza(0);
			} else {
				if (pgStatisticheObj.getForza() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setForza(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case FORZA_TEMP:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setForzaTemp(0);
			} else {
				if (pgStatisticheObj.getForzaTemp() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setForzaTemp(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case FORZA_MOD_CONDIZIONE:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setForzaModCondizione(0);
			} else {
				if (pgStatisticheObj.getForzaModCondizione() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setForzaModCondizione(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case FORZA_MOD_CONDIZIONE_NOTA:
			if (pgStatisticheObj.getForzaModCondizioneNota().equals(valore)) {
			} else {
				pgStatisticheObj.setForzaModCondizioneNota((String) valore);
				pgStatisticheObj.setDatiVariati(true);
			}
			break;
		case DESTREZZA:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setDestrezza(0);
			} else {
				if (pgStatisticheObj.getDestrezza() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setDestrezza(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case DESTREZZA_TEMP:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setDestrezzaTemp(0);
			} else {
				if (pgStatisticheObj.getDestrezzaTemp() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setDestrezzaTemp(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case DESTREZZA_MOD_CONDIZIONE:
			// System.out.println("Aggiornamento DESTREZZA_MOD_CONDIZIONE" );
			// System.out.println("(String) valore: " + (String) valore);
			// System.out.println("pgStatisticheObj.getDestrezzaModCondizione():
			// "
			// + pgStatisticheObj.getDestrezzaModCondizione());
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setDestrezzaModCondizione(0);
			} else {
				if (pgStatisticheObj.getDestrezzaModCondizione() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setDestrezzaModCondizione(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case DESTREZZA_MOD_CONDIZIONE_NOTA:
			if (pgStatisticheObj.getDestrezzaModCondizioneNota().equals(valore)) {
			} else {
				pgStatisticheObj.setDestrezzaModCondizioneNota((String) valore);
				pgStatisticheObj.setDatiVariati(true);
			}
			break;
		case COSTITUZIONE:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setCostituzione(0);
			} else {
				if (pgStatisticheObj.getCostituzione() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setCostituzione(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case COSTITUZIONE_TEMP:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setCostituzioneTemp(0);
			} else {
				if (pgStatisticheObj.getCostituzioneTemp() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setCostituzioneTemp(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case COSTITUZIONE_MOD_CONDIZIONE:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setCostituzioneModCondizione(0);
			} else {
				if (pgStatisticheObj.getCostituzioneModCondizione() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setCostituzioneModCondizione(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case COSTITUZIONE_MOD_CONDIZIONE_NOTA:
			if (pgStatisticheObj.getCostituzioneModCondizioneNota().equals(valore)) {
			} else {
				pgStatisticheObj.setCostituzioneModCondizioneNota((String) valore);
				pgStatisticheObj.setDatiVariati(true);
			}
			break;
		case INTELLIGENZA:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setIntelligenza(0);
			} else {
				if (pgStatisticheObj.getIntelligenza() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setIntelligenza(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case INTELLIGENZA_TEMP:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setIntelligenzaTemp(0);
			} else {
				if (pgStatisticheObj.getIntelligenzaTemp() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setIntelligenzaTemp(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case INTELLIGENZA_MOD_CONDIZIONE:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setIntelligenzaModCondizione(0);
			} else {
				if (pgStatisticheObj.getIntelligenzaModCondizione() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setIntelligenzaModCondizione(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case INTELLIGENZA_MOD_CONDIZIONE_NOTA:
			if (pgStatisticheObj.getIntelligenzaModCondizioneNota().equals(valore)) {
			} else {
				pgStatisticheObj.setIntelligenzaModCondizioneNota((String) valore);
				pgStatisticheObj.setDatiVariati(true);
			}
			break;
		case SAGGEZZA:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setSaggezza(0);
			} else {
				if (pgStatisticheObj.getSaggezza() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setSaggezza(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case SAGGEZZA_TEMP:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setSaggezzaTemp(0);
			} else {
				if (pgStatisticheObj.getSaggezzaTemp() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setSaggezzaTemp(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case SAGGEZZA_MOD_CONDIZIONE:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setSaggezzaModCondizione(0);
			} else {
				if (pgStatisticheObj.getSaggezzaModCondizione() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setSaggezzaModCondizione(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case SAGGEZZA_MOD_CONDIZIONE_NOTA:
			if (pgStatisticheObj.getSaggezzaModCondizioneNota().equals(valore)) {
			} else {
				pgStatisticheObj.setSaggezzaModCondizioneNota((String) valore);
				pgStatisticheObj.setDatiVariati(true);
			}
			break;
		case CARISMA:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setCarisma(0);
			} else {
				if (pgStatisticheObj.getCarisma() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setCarisma(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case CARISMA_TEMP:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setCarismaTemp(0);
			} else {
				if (pgStatisticheObj.getCarismaTemp() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setCarismaTemp(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case CARISMA_MOD_CONDIZIONE:
			if (((String) valore).trim().isEmpty()) {
				pgStatisticheObj.setCarismaModCondizione(0);
			} else {
				if (pgStatisticheObj.getCarismaModCondizione() == Integer.parseInt((String) valore)) {
				} else {
					pgStatisticheObj.setCarismaModCondizione(Integer.parseInt((String) valore));
					pgStatisticheObj.setDatiVariati(true);
				}
			}
			break;
		case CARISMA_MOD_CONDIZIONE_NOTA:
			if (pgStatisticheObj.getCarismaModCondizioneNota().equals(valore)) {
			} else {
				pgStatisticheObj.setCarismaModCondizioneNota((String) valore);
				pgStatisticheObj.setDatiVariati(true);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		pgDatiObj.setPgStatisticheObj(pgStatisticheObj);
		if (pgStatisticheObj.isDatiVariati()) {
			pgDatiObj.setDatiCommittati(false);
		}
		return pgDatiObj;
	}

	public PgDatiObj aggiornaPuntiFerita(PgDatiObj pgDatiObj, ListaPgPuntiFerita dato, Object valore) {

		PgPuntiFeritaObj pgPuntiFeritaObj = new PgPuntiFeritaObj();
		pgPuntiFeritaObj = pgDatiObj.getPgPuntiFeritaObj();
		switch (dato) {
		case FERITE_ATTUALI:
			if (((String) valore).trim().isEmpty()) {
				pgPuntiFeritaObj.setFeriteAttuali(0);
			} else {
				if (pgPuntiFeritaObj.getFeriteAttuali() == Integer.parseInt((String) valore)) {
				} else {
					pgPuntiFeritaObj.setFeriteAttuali(Integer.parseInt((String) valore));
					pgPuntiFeritaObj.setDatiVariati(true);
				}
			}
			break;
		case FERITE:
			if (((String) valore).trim().isEmpty()) {
				pgPuntiFeritaObj.setFerite(0);
			} else {
				if (pgPuntiFeritaObj.getFerite() == Integer.parseInt((String) valore)) {
				} else {
					pgPuntiFeritaObj.setFerite(Integer.parseInt((String) valore));
					pgPuntiFeritaObj.setDatiVariati(true);
				}
			}
			break;
		case DANNI_NON_LETALI_ATTUALI:
			if (((String) valore).trim().isEmpty()) {
				pgPuntiFeritaObj.setDanniNonLetaliAttuali(0);
			} else {
				if (pgPuntiFeritaObj.getDanniNonLetaliAttuali() == Integer.parseInt((String) valore)) {
				} else {
					pgPuntiFeritaObj.setDanniNonLetaliAttuali(Integer.parseInt((String) valore));
					pgPuntiFeritaObj.setDatiVariati(true);
				}
			}
			break;
		case DANNI_NON_LETALI:
			if (((String) valore).trim().isEmpty()) {
				pgPuntiFeritaObj.setDanniNonLetali(0);
			} else {
				if (pgPuntiFeritaObj.getDanniNonLetali() == Integer.parseInt((String) valore)) {
				} else {
					pgPuntiFeritaObj.setDanniNonLetali(Integer.parseInt((String) valore));
					pgPuntiFeritaObj.setDatiVariati(true);
				}
			}
			break;
		case RIDUZIONE_DEL_DANNO:
			if (pgPuntiFeritaObj.getRiduzioneDelDanno().equals(valore)) {
			} else {
				pgPuntiFeritaObj.setRiduzioneDelDanno((String) valore);
				pgPuntiFeritaObj.setDatiVariati(true);
			}
			break;
		case RESISTENZE1:
			if (pgPuntiFeritaObj.getResistenze1().equals(valore)) {
			} else {
				pgPuntiFeritaObj.setResistenze1((String) valore);
				pgPuntiFeritaObj.setDatiVariati(true);
			}
			break;
		case RESISTENZE2:
			if (pgPuntiFeritaObj.getResistenze2().equals(valore)) {
			} else {
				pgPuntiFeritaObj.setResistenze2((String) valore);
				pgPuntiFeritaObj.setDatiVariati(true);
			}
			break;
		case RESISTENZE3:
			if (pgPuntiFeritaObj.getResistenze3().equals(valore)) {
			} else {
				pgPuntiFeritaObj.setResistenze3((String) valore);
				pgPuntiFeritaObj.setDatiVariati(true);
			}
			break;
		case RESISTENZE4:
			if (pgPuntiFeritaObj.getResistenze4().equals(valore)) {
			} else {
				pgPuntiFeritaObj.setResistenze4((String) valore);
				pgPuntiFeritaObj.setDatiVariati(true);
			}
			break;
		case RESISTENZE5:
			if (pgPuntiFeritaObj.getResistenze5().equals(valore)) {
			} else {
				pgPuntiFeritaObj.setResistenze5((String) valore);
				pgPuntiFeritaObj.setDatiVariati(true);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		if (pgPuntiFeritaObj.isDatiVariati()) {
			pgDatiObj.setDatiCommittati(false);
		}
		return pgDatiObj;
	}

	public PgDatiObj aggiornaClasseArmatura(PgDatiObj pgDatiObj, ListaPgClasseArmatura dato, Object valore) {
		DbArmaturaScudoObj armaturaScudoObj = new DbArmaturaScudoObj();

		PgClasseArmaturaObj pgClasseArmaturaObj = new PgClasseArmaturaObj();
		pgClasseArmaturaObj = pgDatiObj.getPgClasseArmaturaObj();
		switch (dato) {
		case BONUS_TAGLIA:
			if (((String) valore).trim().isEmpty()) {
				pgClasseArmaturaObj.setBonusTaglia(0);
			} else {
				if (pgClasseArmaturaObj.getBonusTaglia() == Integer.parseInt((String) valore)) {
				} else {
					pgClasseArmaturaObj.setBonusTaglia(Integer.parseInt((String) valore));
					pgClasseArmaturaObj.setDatiVariati(true);
				}
			}
			break;
		case BONUS_NATURALE:
			if (((String) valore).trim().isEmpty()) {
				pgClasseArmaturaObj.setBonusNaturale(0);
			} else {
				if (pgClasseArmaturaObj.getBonusNaturale() == Integer.parseInt((String) valore)) {
				} else {
					pgClasseArmaturaObj.setBonusNaturale(Integer.parseInt((String) valore));
					pgClasseArmaturaObj.setDatiVariati(true);
				}
			}
			break;
		case BONUS_DEVIAZIONE:
			if (((String) valore).trim().isEmpty()) {
				pgClasseArmaturaObj.setBonusDeviazione(0);
			} else {
				if (pgClasseArmaturaObj.getBonusDeviazione() == Integer.parseInt((String) valore)) {
				} else {
					pgClasseArmaturaObj.setBonusDeviazione(Integer.parseInt((String) valore));
					pgClasseArmaturaObj.setDatiVariati(true);
				}
			}
			break;
		case BONUS_ALTRO:
			if (((String) valore).trim().isEmpty()) {
				pgClasseArmaturaObj.setBonusAltro(0);
			} else {
				if (pgClasseArmaturaObj.getBonusAltro() == Integer.parseInt((String) valore)) {
				} else {
					pgClasseArmaturaObj.setBonusAltro(Integer.parseInt((String) valore));
					pgClasseArmaturaObj.setDatiVariati(true);
				}
			}
			break;
		case BONUS_TEMP:
			if (((String) valore).trim().isEmpty()) {
				pgClasseArmaturaObj.setBonusTemp(0);
			} else {
				if (pgClasseArmaturaObj.getBonusTemp() == Integer.parseInt((String) valore)) {
				} else {
					pgClasseArmaturaObj.setBonusTemp(Integer.parseInt((String) valore));
					pgClasseArmaturaObj.setDatiVariati(true);
				}
			}
			break;
		case ARMATURA_SCUDO1:
			if (((String) valore).trim().isEmpty()) {
				pgClasseArmaturaObj.setArmaturaScudo1("");
				pgClasseArmaturaObj.setArmaturaScudoStatistica1(0);
				pgClasseArmaturaObj.setArmaturaScudoBonus1(0);
				pgClasseArmaturaObj.setArmatura1(false);
				pgClasseArmaturaObj.setScudo1(false);
				pgClasseArmaturaObj.setDatiVariati(true);
			} else {
				if (pgClasseArmaturaObj.getArmaturaScudo1() == (String) valore) {
				} else {
					pgClasseArmaturaObj.setArmaturaScudo1((String) valore);
					// Recupero dati della specifica Armatura/Scudo
					armaturaScudoObj = gestioneJsonItems.getArmaturaScudoByName((String) valore);
					pgClasseArmaturaObj.setArmaturaScudoStatistica1(armaturaScudoObj.getBonus());
					pgClasseArmaturaObj.setArmatura1(armaturaScudoObj.isArmatura());
					pgClasseArmaturaObj.setScudo1(armaturaScudoObj.isScudo());
					pgClasseArmaturaObj.setDatiVariati(true);
				}
			}
			break;
		case ARMATURA_SCUDO_BONUS1:
			if (((String) valore).trim().isEmpty()) {
				pgClasseArmaturaObj.setArmaturaScudoBonus1(0);
			} else {
				if (pgClasseArmaturaObj.getArmaturaScudoBonus1() == Integer.parseInt((String) valore)) {
				} else {
					pgClasseArmaturaObj.setArmaturaScudoBonus1(Integer.parseInt((String) valore));
					pgClasseArmaturaObj.setDatiVariati(true);
				}
			}
			break;
		case ARMATURA_SCUDO2:
			if (((String) valore).trim().isEmpty()) {
				pgClasseArmaturaObj.setArmaturaScudo2("");
				pgClasseArmaturaObj.setArmaturaScudoStatistica2(0);
				pgClasseArmaturaObj.setArmaturaScudoBonus2(0);
				pgClasseArmaturaObj.setArmatura2(false);
				pgClasseArmaturaObj.setScudo2(false);
				pgClasseArmaturaObj.setDatiVariati(true);
			} else {
				if (pgClasseArmaturaObj.getArmaturaScudo2() == (String) valore) {
				} else {
					pgClasseArmaturaObj.setArmaturaScudo2((String) valore);
					// Recupero dati della specifica Armatura/Scudo
					armaturaScudoObj = gestioneJsonItems.getArmaturaScudoByName((String) valore);
					pgClasseArmaturaObj.setArmaturaScudoStatistica2(armaturaScudoObj.getBonus());
					pgClasseArmaturaObj.setArmatura2(armaturaScudoObj.isArmatura());
					pgClasseArmaturaObj.setScudo2(armaturaScudoObj.isScudo());
					pgClasseArmaturaObj.setDatiVariati(true);
				}
			}
			break;
		case ARMATURA_SCUDO_BONUS2:
			if (((String) valore).trim().isEmpty()) {
				pgClasseArmaturaObj.setArmaturaScudoBonus2(0);
			} else {
				if (pgClasseArmaturaObj.getArmaturaScudoBonus2() == Integer.parseInt((String) valore)) {
				} else {
					pgClasseArmaturaObj.setArmaturaScudoBonus2(Integer.parseInt((String) valore));
					pgClasseArmaturaObj.setDatiVariati(true);
				}
			}
			break;
		case ARMATURA_SCUDO3:
			if (((String) valore).trim().isEmpty()) {
				pgClasseArmaturaObj.setArmaturaScudo3("");
				pgClasseArmaturaObj.setArmaturaScudoStatistica3(0);
				pgClasseArmaturaObj.setArmaturaScudoBonus3(0);
				pgClasseArmaturaObj.setArmatura3(false);
				pgClasseArmaturaObj.setScudo3(false);
				pgClasseArmaturaObj.setDatiVariati(true);
			} else {
				if (pgClasseArmaturaObj.getArmaturaScudo3() == (String) valore) {
				} else {
					pgClasseArmaturaObj.setArmaturaScudo3((String) valore);
					// System.out.println("pgClasseArmaturaObj.getArmaturaScudo3():
					// "
					// + pgClasseArmaturaObj.getArmaturaScudo3());
					// Recupero dati della specifica Armatura/Scudo
					armaturaScudoObj = gestioneJsonItems.getArmaturaScudoByName((String) valore);
					pgClasseArmaturaObj.setArmaturaScudoStatistica3(armaturaScudoObj.getBonus());
					pgClasseArmaturaObj.setArmatura3(armaturaScudoObj.isArmatura());
					pgClasseArmaturaObj.setScudo3(armaturaScudoObj.isScudo());
					pgClasseArmaturaObj.setDatiVariati(true);
				}
			}
			break;
		case ARMATURA_SCUDO_BONUS3:
			if (((String) valore).trim().isEmpty()) {
				pgClasseArmaturaObj.setArmaturaScudoBonus3(0);
			} else {
				if (pgClasseArmaturaObj.getArmaturaScudoBonus3() == Integer.parseInt((String) valore)) {
				} else {
					pgClasseArmaturaObj.setArmaturaScudoBonus3(Integer.parseInt((String) valore));
					pgClasseArmaturaObj.setDatiVariati(true);
				}
			}
			break;
		case FALLIMENTO_INCANTESIMI_ARCANI:
			if (((String) valore).trim().isEmpty()) {
				pgClasseArmaturaObj.setFallimentoIncantesimiArcani(0);
			} else {
				if (pgClasseArmaturaObj.getFallimentoIncantesimiArcani() == Integer.parseInt((String) valore)) {
				} else {
					pgClasseArmaturaObj.setFallimentoIncantesimiArcani(Integer.parseInt((String) valore));
					pgClasseArmaturaObj.setDatiVariati(true);
				}
			}
			break;
		case FLAG_FALLIMENTO_INCANTESIMI_ARCANI:
			if (pgClasseArmaturaObj.isFlagFallimentoIncantesimiArcani() == Boolean.valueOf(valore.toString())) {
			} else {
				pgClasseArmaturaObj.setFlagFallimentoIncantesimiArcani(Boolean.valueOf(valore.toString()));
				pgClasseArmaturaObj.setDatiVariati(true);
			}
			break;
		case PENALITA_PROVA_ARMATURA:
			if (((String) valore).trim().isEmpty()) {
				pgClasseArmaturaObj.setPenalitaProvaArmatura(0);
			} else {
				if (pgClasseArmaturaObj.getPenalitaProvaArmatura() == Integer.parseInt((String) valore)) {
				} else {
					pgClasseArmaturaObj.setPenalitaProvaArmatura(Integer.parseInt((String) valore));
					pgClasseArmaturaObj.setDatiVariati(true);
				}
			}
			break;
		case FLAG_PENALITA_PROVA_ARMATURA:
			if (pgClasseArmaturaObj.isFlagPenalitaProvaArmatura() == Boolean.valueOf(valore.toString())) {
			} else {
				pgClasseArmaturaObj.setFlagPenalitaProvaArmatura(Boolean.valueOf(valore.toString()));
				pgClasseArmaturaObj.setDatiVariati(true);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		pgDatiObj.setPgClasseArmaturaObj(pgClasseArmaturaObj);
		if (pgClasseArmaturaObj.isDatiVariati()) {
			pgDatiObj.setDatiCommittati(false);
		}
		return pgDatiObj;
	}

	public PgDatiObj aggiornaBab(PgDatiObj pgDatiObj, ListaPgBab dato, Object valore) {
		PgBabObj pgBabObj = new PgBabObj();
		pgBabObj = pgDatiObj.getPgBabObj();

		switch (dato) {
		case BAB_CLASSE1:
			if (((String) valore).trim().isEmpty()) {
				pgBabObj.setBabClasse1(0);
			} else {
				if (pgBabObj.getBabClasse1() == Integer.parseInt((String) valore)) {
				} else {
					pgBabObj.setBabClasse1(Integer.parseInt((String) valore));
					pgBabObj.setDatiVariati(true);
				}
			}
			break;
		case BAB_CLASSE2:
			if (((String) valore).trim().isEmpty()) {
				pgBabObj.setBabClasse2(0);
			} else {
				if (pgBabObj.getBabClasse2() == Integer.parseInt((String) valore)) {
				} else {
					pgBabObj.setBabClasse2(Integer.parseInt((String) valore));
					pgBabObj.setDatiVariati(true);
				}
			}
			break;
		case BAB_CLASSE3:
			if (((String) valore).trim().isEmpty()) {
				pgBabObj.setBabClasse3(0);
			} else {
				if (pgBabObj.getBabClasse3() == Integer.parseInt((String) valore)) {
				} else {
					pgBabObj.setBabClasse3(Integer.parseInt((String) valore));
					pgBabObj.setDatiVariati(true);
				}
			}
			break;
		case BAB_CLASSE4:
			if (((String) valore).trim().isEmpty()) {
				pgBabObj.setBabClasse4(0);
			} else {
				if (pgBabObj.getBabClasse4() == Integer.parseInt((String) valore)) {
				} else {
					pgBabObj.setBabClasse4(Integer.parseInt((String) valore));
					pgBabObj.setDatiVariati(true);
				}
			}
			break;
		case BAB_CLASSE5:
			if (((String) valore).trim().isEmpty()) {
				pgBabObj.setBabClasse5(0);
			} else {
				if (pgBabObj.getBabClasse5() == Integer.parseInt((String) valore)) {
				} else {
					pgBabObj.setBabClasse5(Integer.parseInt((String) valore));
					pgBabObj.setDatiVariati(true);
				}
			}
			break;
		case BAB_CLASSE6:
			if (((String) valore).trim().isEmpty()) {
				pgBabObj.setBabClasse6(0);
			} else {
				if (pgBabObj.getBabClasse6() == Integer.parseInt((String) valore)) {
				} else {
					pgBabObj.setBabClasse6(Integer.parseInt((String) valore));
					pgBabObj.setDatiVariati(true);
				}
			}
			break;
		case MISCHIA_TAGLIA:
			if (((String) valore).trim().isEmpty()) {
				pgBabObj.setMischiaTaglia(0);
			} else {
				if (pgBabObj.getMischiaTaglia() == Integer.parseInt((String) valore)) {
				} else {
					pgBabObj.setMischiaTaglia(Integer.parseInt((String) valore));
					pgBabObj.setDatiVariati(true);
				}
			}
			break;
		case MISCHIA_ALTRO:
			if (((String) valore).trim().isEmpty()) {
				pgBabObj.setMischiaAltro(0);
			} else {
				if (pgBabObj.getMischiaAltro() == Integer.parseInt((String) valore)) {
				} else {
					pgBabObj.setMischiaAltro(Integer.parseInt((String) valore));
					pgBabObj.setDatiVariati(true);
				}
			}
			break;
		case DISTANZA_ALTRO:
			if (((String) valore).trim().isEmpty()) {
				pgBabObj.setDistanzaAltro(0);
			} else {
				if (pgBabObj.getDistanzaAltro() == Integer.parseInt((String) valore)) {
				} else {
					pgBabObj.setDistanzaAltro(Integer.parseInt((String) valore));
					pgBabObj.setDatiVariati(true);
				}
			}
			break;
		case LOTTARE_TAGLIA:
			if (((String) valore).trim().isEmpty()) {
				pgBabObj.setLottareTaglia(0);
			} else {
				if (pgBabObj.getLottareTaglia() == Integer.parseInt((String) valore)) {
				} else {
					pgBabObj.setLottareTaglia(Integer.parseInt((String) valore));
					pgBabObj.setDatiVariati(true);
				}
			}
			break;
		case PENALITÀ_2ARMI_PRIMARIA:
			if (((String) valore).trim().isEmpty()) {
				pgBabObj.setPenalità2ArmiPrimaria(0);
			} else {
				if (pgBabObj.getPenalità2ArmiPrimaria() == Integer.parseInt((String) valore)) {
				} else {
					pgBabObj.setPenalità2ArmiPrimaria(Integer.parseInt((String) valore));
					pgBabObj.setDatiVariati(true);
				}
			}
			break;
		case PENALITÀ_2ARMI_SECONDARIA:
			if (((String) valore).trim().isEmpty()) {
				pgBabObj.setPenalità2ArmiSecondaria(0);
			} else {
				if (pgBabObj.getPenalità2ArmiSecondaria() == Integer.parseInt((String) valore)) {
				} else {
					pgBabObj.setPenalità2ArmiSecondaria(Integer.parseInt((String) valore));
					pgBabObj.setDatiVariati(true);
				}
			}
			break;
		case TALENTO_2_ARMI:
			if (pgBabObj.isTalento2Armi() == Boolean.valueOf(valore.toString())) {
			} else {
				pgBabObj.setTalento2Armi(Boolean.valueOf(valore.toString()));
				pgBabObj.setDatiVariati(true);
			}
			break;
		case NOTE:
			if (pgBabObj.getNote().equals(valore)) {
			} else {
				pgBabObj.setNote((String) valore);
				pgBabObj.setDatiVariati(true);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}

		pgDatiObj.setPgBabObj(pgBabObj);
		if (pgBabObj.isDatiVariati()) {
			pgDatiObj.setDatiCommittati(false);
		}

		return pgDatiObj;
	}

	public PgDatiObj aggiornaTiriSalvezza(PgDatiObj pgDatiObj, ListaPgTiriSalvezza dato, Object valore) {
		PgTiriSalvezzaObj pgTiriSalvezzaObj = new PgTiriSalvezzaObj();
		pgTiriSalvezzaObj = pgDatiObj.getPgTiriSalvezzaObj();

		switch (dato) {
		case TEMPRA_BASE:
			if (((String) valore).trim().isEmpty()) {
				pgTiriSalvezzaObj.setTempraBase(0);
			} else {
				if (pgTiriSalvezzaObj.getTempraBase() == Integer.parseInt((String) valore)) {
				} else {
					pgTiriSalvezzaObj.setTempraBase(Integer.parseInt((String) valore));
					pgTiriSalvezzaObj.setDatiVariati(true);
				}
			}
			break;
		case TEMPRA_MAGIA:
			if (((String) valore).trim().isEmpty()) {
				pgTiriSalvezzaObj.setTempraMagia(0);
			} else {
				if (pgTiriSalvezzaObj.getTempraMagia() == Integer.parseInt((String) valore)) {
				} else {
					pgTiriSalvezzaObj.setTempraMagia(Integer.parseInt((String) valore));
					pgTiriSalvezzaObj.setDatiVariati(true);
				}
			}
			break;
		case RIFLESSI_BASE:
			if (((String) valore).trim().isEmpty()) {
				pgTiriSalvezzaObj.setRiflessiBase(0);
			} else {
				if (pgTiriSalvezzaObj.getRiflessiBase() == Integer.parseInt((String) valore)) {
				} else {
					pgTiriSalvezzaObj.setRiflessiBase(Integer.parseInt((String) valore));
					pgTiriSalvezzaObj.setDatiVariati(true);
				}
			}
			break;
		case RIFLESSI_MAGIA:
			if (((String) valore).trim().isEmpty()) {
				pgTiriSalvezzaObj.setRiflessiMagia(0);
			} else {
				if (pgTiriSalvezzaObj.getRiflessiMagia() == Integer.parseInt((String) valore)) {
				} else {
					pgTiriSalvezzaObj.setRiflessiMagia(Integer.parseInt((String) valore));
					pgTiriSalvezzaObj.setDatiVariati(true);
				}
			}
			break;
		case VOLONTA_BASE:
			if (((String) valore).trim().isEmpty()) {
				pgTiriSalvezzaObj.setVolontaBase(0);
			} else {
				if (pgTiriSalvezzaObj.getVolontaBase() == Integer.parseInt((String) valore)) {
				} else {
					pgTiriSalvezzaObj.setVolontaBase(Integer.parseInt((String) valore));
					pgTiriSalvezzaObj.setDatiVariati(true);
				}
			}
			break;
		case VOLONTA_MAGIA:
			if (((String) valore).trim().isEmpty()) {
				pgTiriSalvezzaObj.setVolontaMagia(0);
			} else {
				if (pgTiriSalvezzaObj.getVolontaMagia() == Integer.parseInt((String) valore)) {
				} else {
					pgTiriSalvezzaObj.setVolontaMagia(Integer.parseInt((String) valore));
					pgTiriSalvezzaObj.setDatiVariati(true);
				}
			}
			break;
		case RESISTENZA_INCANTESIMI:
			if (((String) valore).trim().isEmpty()) {
				pgTiriSalvezzaObj.setResistenzaIncantesimi(0);
			} else {
				if (pgTiriSalvezzaObj.getResistenzaIncantesimi() == Integer.parseInt((String) valore)) {
				} else {
					pgTiriSalvezzaObj.setResistenzaIncantesimi(Integer.parseInt((String) valore));
					pgTiriSalvezzaObj.setDatiVariati(true);
				}
			}
			break;
		case NOTE:
			if (pgTiriSalvezzaObj.getNote().equals(valore)) {
			} else {
				pgTiriSalvezzaObj.setNote((String) valore);
				pgTiriSalvezzaObj.setDatiVariati(true);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}

		pgDatiObj.setPgTiriSalvezzaObj(pgTiriSalvezzaObj);
		if (pgTiriSalvezzaObj.isDatiVariati()) {
			pgDatiObj.setDatiCommittati(false);
		}

		return pgDatiObj;
	}

	public PgDatiObj aggiornaIniziativa(PgDatiObj pgDatiObj, ListaPgIniziativa dato, Object valore) {
		PgIniziativaObj pgIniziativaObj = new PgIniziativaObj();
		pgIniziativaObj = pgDatiObj.getPgIniziativaObj();

		switch (dato) {
		case TALENTI:
			if (((String) valore).trim().isEmpty()) {
				pgIniziativaObj.setTalenti(0);
			} else {
				if (pgIniziativaObj.getTalenti() == Integer.parseInt((String) valore)) {
				} else {
					pgIniziativaObj.setTalenti(Integer.parseInt((String) valore));
					pgIniziativaObj.setDatiVariati(true);
				}
			}
			break;
		case MAGIA:
			if (((String) valore).trim().isEmpty()) {
				pgIniziativaObj.setMagia(0);
			} else {
				if (pgIniziativaObj.getMagia() == Integer.parseInt((String) valore)) {
				} else {
					pgIniziativaObj.setMagia(Integer.parseInt((String) valore));
					pgIniziativaObj.setDatiVariati(true);
				}
			}
			break;
		case NOTE:
			if (pgIniziativaObj.getNote().equals(valore)) {
			} else {
				pgIniziativaObj.setNote((String) valore);
				pgIniziativaObj.setDatiVariati(true);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}

		pgDatiObj.setPgIniziativaObj(pgIniziativaObj);
		if (pgIniziativaObj.isDatiVariati()) {
			pgDatiObj.setDatiCommittati(false);
		}

		return pgDatiObj;
	}

	public PgArmiObj aggiornaArmi(PgArmiObj pgArmiObj, ListaPgArmi dato, Object valore) {
		switch (dato) {
		case ARMA:
			if (pgArmiObj.getArma().equals(valore)) {
			} else {
				pgArmiObj.setArma((String) valore);
				pgArmiObj.setDatiVariati(true);
			}
			break;
		case TAGLIA:
			if (pgArmiObj.getTaglia().equals(valore)) {
			} else {
				pgArmiObj.setTaglia((String) valore);
				pgArmiObj.setDatiVariati(true);
			}
			break;
		case QUALITA:
			if (pgArmiObj.getQualita().equals(valore)) {
			} else {
				pgArmiObj.setQualita((String) valore);
				pgArmiObj.setDatiVariati(true);
			}
			break;
		case MOD:
			if (((String) valore).trim().isEmpty()) {
				pgArmiObj.setMod(0);
			} else {
				if (pgArmiObj.getMod() == Integer.parseInt((String) valore)) {
				} else {
					pgArmiObj.setMod(Integer.parseInt((String) valore));
					pgArmiObj.setDatiVariati(true);
				}
			}
			break;
		case INCANTAMENTI:
			if (pgArmiObj.getIncantamenti().equals(valore)) {
			} else {
				pgArmiObj.setIncantamenti((String) valore);
				pgArmiObj.setDatiVariati(true);
			}
			break;
		case BONUS_INCANTAMENTI:
			if (pgArmiObj.getBonusIncantamenti().equals(valore)) {
			} else {
				pgArmiObj.setBonusIncantamenti((String) valore);
				pgArmiObj.setDatiVariati(true);
			}
			break;
		case MOD_BAB:
			if (((String) valore).trim().isEmpty()) {
				pgArmiObj.setModBab(0);
			} else {
				if (pgArmiObj.getModBab() == Integer.parseInt((String) valore)) {
				} else {
					pgArmiObj.setModBab(Integer.parseInt((String) valore));
					pgArmiObj.setDatiVariati(true);
				}
			}
			break;
		case MOD_BAB_DESCRIZIONE:
			if (pgArmiObj.getModBabDescrizione().equals(valore)) {
			} else {
				pgArmiObj.setModBabDescrizione((String) valore);
				pgArmiObj.setDatiVariati(true);
			}
			break;
		case MOD_DANNO:
			if (((String) valore).trim().isEmpty()) {
				pgArmiObj.setModDanno(0);
			} else {
				if (pgArmiObj.getModDanno() == Integer.parseInt((String) valore)) {
				} else {
					pgArmiObj.setModDanno(Integer.parseInt((String) valore));
					pgArmiObj.setDatiVariati(true);
				}
			}
			break;
		case MOD_DANNO_DESCRIZIONE:
			if (pgArmiObj.getModDannoDescrizione().equals(valore)) {
			} else {
				pgArmiObj.setModDannoDescrizione((String) valore);
				pgArmiObj.setDatiVariati(true);
			}
			break;
		case A_2MANI:
			if (pgArmiObj.isA2Mani() == Boolean.valueOf(valore.toString())) {
			} else {
				pgArmiObj.setA2Mani(Boolean.valueOf(valore.toString()));
				pgArmiObj.setDatiVariati(true);
			}
			break;
		case DOPPIA_ARMA:
			if (pgArmiObj.isDoppiaArma() == Boolean.valueOf(valore.toString())) {
			} else {
				pgArmiObj.setDoppiaArma(Boolean.valueOf(valore.toString()));
				pgArmiObj.setDatiVariati(true);
			}
			break;
		case PRIMARIA_SECONDARIA:
			if (pgArmiObj.getPrimariaSecondaria().equals(valore)) {
			} else {
				pgArmiObj.setPrimariaSecondaria((String) valore);
				pgArmiObj.setDatiVariati(true);
			}
			break;
		case EQUIPAGGIATA:
			if (pgArmiObj.isEquipaggiata() == Boolean.valueOf(valore.toString())) {
			} else {
				pgArmiObj.setEquipaggiata(Boolean.valueOf(valore.toString()));
				pgArmiObj.setDatiVariati(true);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return pgArmiObj;

	}

	public PgClasseObj aggiornaClasse(PgClasseObj pgClasseObj, ListaPgClasse dato, Object valore) {
		switch (dato) {
		case CLASSE:
			if (pgClasseObj.getClasse().equals(valore)) {
			} else {
				pgClasseObj.setClasse((String) valore);
				pgClasseObj.setDatiVariati(true);
			}
			break;
		case LIVELLO:
			if (((String) valore).trim().isEmpty()) {
				pgClasseObj.setLivello(0);
			} else {
				if (pgClasseObj.getLivello() == Integer.parseInt((String) valore)) {
				} else {
					pgClasseObj.setLivello(Integer.parseInt((String) valore));
					pgClasseObj.setDatiVariati(true);
				}
			}
			break;
		case DADO_VITA:
			if (pgClasseObj.getDadoVita().equals(valore)) {
			} else {
				pgClasseObj.setDadoVita((String) valore);
				pgClasseObj.setDatiVariati(true);
			}
			break;
		case PUNTI_FERITA:
			if (((String) valore).trim().isEmpty()) {
				pgClasseObj.setPuntiFerita(0);
			} else {
				if (pgClasseObj.getPuntiFerita() == Integer.parseInt((String) valore)) {
				} else {
					pgClasseObj.setPuntiFerita(Integer.parseInt((String) valore));
					pgClasseObj.setDatiVariati(true);
				}
			}
			break;
		case IS_CLASSE_DI_PRESTIGIO:
			if (pgClasseObj.isClasseDiPrestigio() == Boolean.valueOf(valore.toString())) {
			} else {
				pgClasseObj.setClasseDiPrestigio(Boolean.valueOf(valore.toString()));
				pgClasseObj.setDatiVariati(true);
			}
			break;
		case BAB_CLASSE:
			if (((String) valore).trim().isEmpty()) {
				pgClasseObj.setBabClasse(0);
			} else {
				if (pgClasseObj.getBabClasse() == Integer.parseInt((String) valore)) {
				} else {
					pgClasseObj.setBabClasse(Integer.parseInt((String) valore));
					pgClasseObj.setDatiVariati(true);
				}
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return pgClasseObj;

	}

	public PgBonusObj aggiornaBonus(PgBonusObj pgBonusObj, ListaPgBonus dato, Object valore) {
		switch (dato) {
		case BONUS:
			if (pgBonusObj.getBonus().equals(valore)) {
			} else {
				pgBonusObj.setBonus((String) valore);
				pgBonusObj.setDatiVariati(true);
			}
			break;
		case MODIFICATORE:
			if (((String) valore).trim().isEmpty()) {
				pgBonusObj.setModificatore(0);
			} else {
				if (pgBonusObj.getModificatore() == Integer.parseInt((String) valore)) {
				} else {
					pgBonusObj.setModificatore(Integer.parseInt((String) valore));
					pgBonusObj.setDatiVariati(true);
				}
			}
			break;
		case DESCRIZIONE:
			if (pgBonusObj.getDescrizione().equals(valore)) {
			} else {
				pgBonusObj.setDescrizione((String) valore);
				pgBonusObj.setDatiVariati(true);
			}
			break;
		case BONUS_ABILITATO:
			if (pgBonusObj.isBonusAbilitato() == Boolean.valueOf(valore.toString())) {
			} else {
				pgBonusObj.setBonusAbilitato(Boolean.valueOf(valore.toString()));
				pgBonusObj.setDatiVariati(true);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return pgBonusObj;

	}

	public DbTaglieObj aggiornaTaglie(DbTaglieObj dbTaglieObj, ListaDbTaglie dato, Object valore) {
		switch (dato) {
		case NOME:
			if (dbTaglieObj.getNome().equals(valore)) {
			} else {
				dbTaglieObj.setNome((String) valore);
				dbTaglieObj.setDatiVariati(true);
			}
			break;
		case MOD_TAGLIA:
			if (((String) valore).trim().isEmpty()) {
				dbTaglieObj.setModTaglia(0);
			} else {
				if (dbTaglieObj.getModTaglia() == Integer.parseInt((String) valore)) {
				} else {
					dbTaglieObj.setModTaglia(Integer.parseInt((String) valore));
					dbTaglieObj.setDatiVariati(true);
				}
			}
			break;
		case MOD_TAGLIA_SPECIALE:
			if (((String) valore).trim().isEmpty()) {
				dbTaglieObj.setModTagliaSpeciale(0);
			} else {
				if (dbTaglieObj.getModTagliaSpeciale() == Integer.parseInt((String) valore)) {
				} else {
					dbTaglieObj.setModTagliaSpeciale(Integer.parseInt((String) valore));
					dbTaglieObj.setDatiVariati(true);
				}
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return dbTaglieObj;
	}

	public DbAbilitaObj aggiornaAbilita(DbAbilitaObj dbAbilitaObj, ListaDbAbilita dato, String valore) {
		switch (dato) {
		case NOME:
			if (dbAbilitaObj.getNome().equals(valore)) {
			} else {
				dbAbilitaObj.setNome((String) valore);
			}
			break;
		case RICHIEDE_ADDESTRAMENTO:
			if (dbAbilitaObj.isRichiedeAddestramento() == Boolean.valueOf(valore.toString())) {
			} else {
				dbAbilitaObj.setRichiedeAddestramento(Boolean.valueOf(valore.toString()));
			}
			break;
		case CARATTERISTICA:
			if (dbAbilitaObj.getCaratteristica().equals(valore)) {
			} else {
				dbAbilitaObj.setCaratteristica((String) valore);
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return dbAbilitaObj;
	}

	public PgAbilitaObj aggiornaAbilita(PgAbilitaObj pgAbilitaObj, ListaPgAbilita dato, String valore) {
		switch (dato) {
		case DI_CLASSE:
			if (pgAbilitaObj.isAbilitaDiClasse() == Boolean.valueOf(valore.toString())) {
			} else {
				pgAbilitaObj.setAbilitaDiClasse(Boolean.valueOf(valore.toString()));
				pgAbilitaObj.setDatiVariati(true);
			}
			break;
		case DI_CLASSE_INCROCIATA:
			if (pgAbilitaObj.isAbilitaDiClasseIncrociata() == Boolean.valueOf(valore.toString())) {
			} else {
				pgAbilitaObj.setAbilitaDiClasseIncrociata(Boolean.valueOf(valore.toString()));
				pgAbilitaObj.setDatiVariati(true);
			}
			break;
		case GRADO:
			if (((String) valore).trim().isEmpty()) {
				pgAbilitaObj.setGrado(0);
			} else {
				if (pgAbilitaObj.getGrado() == Integer.parseInt((String) valore)) {
				} else {
					pgAbilitaObj.setGrado(Integer.parseInt((String) valore));
					pgAbilitaObj.setDatiVariati(true);
				}
			}
			break;
		case ALTRO:
			if (((String) valore).trim().isEmpty()) {
				pgAbilitaObj.setAltro(0);
			} else {
				if (pgAbilitaObj.getAltro() == Integer.parseInt((String) valore)) {
				} else {
					pgAbilitaObj.setAltro(Integer.parseInt((String) valore));
					pgAbilitaObj.setDatiVariati(true);
				}
			}
			break;
		case ALTRO_DESCRIZIONE:
			if (pgAbilitaObj.getAltroDescrizione().equals(valore)) {
			} else {
				pgAbilitaObj.setAltroDescrizione((String) valore);
				pgAbilitaObj.setDatiVariati(true);
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return pgAbilitaObj;
	}

	public PgTalentiObj aggiornaTalenti(PgTalentiObj pgTalentiObj,
			ListaPgTalenti dato, Object valore) {
		switch (dato) {
		case NOME:
			if (pgTalentiObj.getNome().equals(valore)) {
			} else {
				pgTalentiObj.setNome((String) valore);
				pgTalentiObj.setDatiVariati(true);
			}
			break;
		case DESCRIZIONE:
			if (pgTalentiObj.getDescrizione().equals(valore)) {
			} else {
				pgTalentiObj.setDescrizione((String) valore);
				pgTalentiObj.setDatiVariati(true);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return pgTalentiObj;
	}

	public DbArmaturaScudoObj aggiornaDbArmaturaScudo(DbArmaturaScudoObj dbArmaturaScudoObj, ListaDbArmaturaScudo dato, Object valore) {
		switch (dato) {
		case NOME:
			if (dbArmaturaScudoObj.getNome().equals(valore)) {
			} else {
				dbArmaturaScudoObj.setNome((String) valore);
				dbArmaturaScudoObj.setDatiVariati(true);
			}
			break;
		case CATEGORIA:
			if (dbArmaturaScudoObj.getCategoria().equals(valore)) {
			} else {
				dbArmaturaScudoObj.setCategoria((String) valore);
				dbArmaturaScudoObj.setDatiVariati(true);
			}
			break;
		case ARMATURA:
			if (dbArmaturaScudoObj.isArmatura() == Boolean.valueOf(valore.toString())) {
			} else {
				dbArmaturaScudoObj.setArmatura(Boolean.valueOf(valore.toString()));
				dbArmaturaScudoObj.setDatiVariati(true);
			}
			break;
		case SCUDO:
			if (dbArmaturaScudoObj.isScudo() == Boolean.valueOf(valore.toString())) {
			} else {
				dbArmaturaScudoObj.setScudo(Boolean.valueOf(valore.toString()));
				dbArmaturaScudoObj.setDatiVariati(true);
			}
			break;
		case COSTO:
			if (dbArmaturaScudoObj.getCosto().equals(valore)) {
			} else {
				dbArmaturaScudoObj.setCosto((String) valore);
				dbArmaturaScudoObj.setDatiVariati(true);
			}
			break;
		case BONUS:
			if (((String) valore).trim().isEmpty()) {
				dbArmaturaScudoObj.setBonus(0);
			} else {
				if (dbArmaturaScudoObj.getBonus() == Integer.parseInt((String) valore)) {
				} else {
					dbArmaturaScudoObj.setBonus(Integer.parseInt((String) valore));
					dbArmaturaScudoObj.setDatiVariati(true);
				}
			}
			break;
		case BONUS_DES_MAX:
			if (((String) valore).trim().isEmpty()) {
				dbArmaturaScudoObj.setBonusDesMax(0);
			} else {
				if (dbArmaturaScudoObj.getBonusDesMax() == Integer.parseInt((String) valore)) {
				} else {
					dbArmaturaScudoObj.setBonusDesMax(Integer.parseInt((String) valore));
					dbArmaturaScudoObj.setDatiVariati(true);
				}
			}
			break;
		case PENALITA_PROVA_ARMATURA:
			if (((String) valore).trim().isEmpty()) {
				dbArmaturaScudoObj.setPenalitaProvaArmatura(0);
			} else {
				if (dbArmaturaScudoObj.getPenalitaProvaArmatura() == Integer.parseInt((String) valore)) {
				} else {
					dbArmaturaScudoObj.setPenalitaProvaArmatura(Integer.parseInt((String) valore));
					dbArmaturaScudoObj.setDatiVariati(true);
				}
			}
			break;
		case FALLIMENTO_INCANTESIMI_ARCANI:
			if (((String) valore).trim().isEmpty()) {
				dbArmaturaScudoObj.setFallimentoIncantesimiArcani(0);
			} else {
				if (dbArmaturaScudoObj.getFallimentoIncantesimiArcani() == Integer.parseInt((String) valore)) {
				} else {
					dbArmaturaScudoObj.setFallimentoIncantesimiArcani(Integer.parseInt((String) valore));
					dbArmaturaScudoObj.setDatiVariati(true);
				}
			}
			break;
		case VELOCITA_9M:
			if (((String) valore).trim().isEmpty()) {
				dbArmaturaScudoObj.setVelocita9M(0);
			} else {
				if (dbArmaturaScudoObj.getVelocita9M() == Double.parseDouble((String) valore)) {
				} else {
					dbArmaturaScudoObj.setVelocita9M(Double.parseDouble((String) valore));
					dbArmaturaScudoObj.setDatiVariati(true);
				}
			}
			break;
		case VELOCITA_6M:
			if (((String) valore).trim().isEmpty()) {
				dbArmaturaScudoObj.setVelocita6M(0);
			} else {
				if (dbArmaturaScudoObj.getVelocita6M() == Double.parseDouble((String) valore)) {
				} else {
					dbArmaturaScudoObj.setVelocita6M(Double.parseDouble((String) valore));
					dbArmaturaScudoObj.setDatiVariati(true);
				}
			}
			break;
		case PESO:
			if (((String) valore).trim().isEmpty()) {
				dbArmaturaScudoObj.setPeso(0);
			} else {
				if (dbArmaturaScudoObj.getPeso() == Double.parseDouble((String) valore)) {
				} else {
					dbArmaturaScudoObj.setPeso(Double.parseDouble((String) valore));
					dbArmaturaScudoObj.setDatiVariati(true);
				}
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return dbArmaturaScudoObj;
	}

	public DbArmiObj aggiornaDbArmi(DbArmiObj dbArmiObj, ListaDbArmi dato,
			Object valore) {
		switch (dato) {
		case NOME:
			if (dbArmiObj.getNome().equals(valore)) {
			} else {
				dbArmiObj.setNome((String) valore);
				dbArmiObj.setDatiVariati(true);
			}
			break;
		case CATEGORIA1:
			if (dbArmiObj.getCategoria1().equals(valore)) {
			} else {
				dbArmiObj.setCategoria1((String) valore);
				dbArmiObj.setDatiVariati(true);
			}
			break;
		case CATEGORIA2:
			if (dbArmiObj.getCategoria2().equals(valore)) {
			} else {
				dbArmiObj.setCategoria2((String) valore);
				dbArmiObj.setDatiVariati(true);
			}
			break;
		case MISCHIA:
			if (dbArmiObj.isMischia() == Boolean.valueOf(valore.toString())) {
			} else {
				dbArmiObj.setMischia(Boolean.valueOf(valore.toString()));
				dbArmiObj.setDatiVariati(true);
			}
			break;
		case DISTANZA:
			if (dbArmiObj.isDistanza() == Boolean.valueOf(valore.toString())) {
			} else {
				dbArmiObj.setDistanza(Boolean.valueOf(valore.toString()));
				dbArmiObj.setDatiVariati(true);
			}
			break;
		case COSTO:
			if (dbArmiObj.getCosto().equals(valore)) {
			} else {
				dbArmiObj.setCosto((String) valore);
				dbArmiObj.setDatiVariati(true);
			}
			break;
		case DANNIP:
			if (dbArmiObj.getDanniP().equals(valore)) {
			} else {
				dbArmiObj.setDanniP((String) valore);
				dbArmiObj.setDatiVariati(true);
			}
			break;
		case DANNIM:
			if (dbArmiObj.getDanniM().equals(valore)) {
			} else {
				dbArmiObj.setDanniM((String) valore);
				dbArmiObj.setDatiVariati(true);
			}
			break;
		case DANNIG:
			if (dbArmiObj.getDanniG().equals(valore)) {
			} else {
				dbArmiObj.setDanniG((String) valore);
				dbArmiObj.setDatiVariati(true);
			}
			break;
		case CRITICO:
			if (dbArmiObj.getCritico().equals(valore)) {
			} else {
				dbArmiObj.setCritico((String) valore);
				dbArmiObj.setDatiVariati(true);
			}
			break;
		case INCREMENTO_GITTATA:
			if (dbArmiObj.getIncrementoGittata().equals(valore)) {
			} else {
				dbArmiObj.setIncrementoGittata((String) valore);
				dbArmiObj.setDatiVariati(true);
			}
			break;
		case PESO:
			if (((String) valore).trim().isEmpty()) {
				dbArmiObj.setPeso(0.00);
			} else {
				if (dbArmiObj.getPeso() == Double.parseDouble((String) valore)) {
				} else {
					dbArmiObj.setPeso(Double.parseDouble((String) valore));
					dbArmiObj.setDatiVariati(true);
				}
			}
			break;
		case TIPO:
			if (dbArmiObj.getTipo().equals(valore)) {
			} else {
				dbArmiObj.setTipo((String) valore);
				dbArmiObj.setDatiVariati(true);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return dbArmiObj;

	}

	public PgLingueObj aggiornaLingua(PgLingueObj pgLingueObj,
			ListaPgLingue dato, String valore) {
		switch (dato) {
		case PUNTI_ABILITA:
			if (((String) valore).trim().isEmpty()) {
				pgLingueObj.setPuntiAbilita(0);
			} else {
				if (pgLingueObj.getPuntiAbilita() == Integer.parseInt((String) valore)) {
				} else {
					pgLingueObj.setPuntiAbilita(Integer.parseInt((String) valore));
					pgLingueObj.setDatiVariati(true);
				}
			}
			break;
		case LINGUA_PARLATA:
			if (pgLingueObj.getLinguaParlata().equals(valore)) {
			} else {
				pgLingueObj.setLinguaParlata((String) valore);
				pgLingueObj.setDatiVariati(true);
			}
			break;
		case ALFABETO:
			if (pgLingueObj.getAlfabeto().equals(valore)) {
			} else {
				pgLingueObj.setAlfabeto((String) valore);
				pgLingueObj.setDatiVariati(true);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return pgLingueObj;

	}

	public PgManovreObj aggiornaManovre(PgManovreObj pgManovreObj, ListaPgManovre dato, Object valore) {
		switch (dato) {
		case NOME:
			if (pgManovreObj.getNome().equals(valore)) {
			} else {
				pgManovreObj.setNome((String) valore);
				pgManovreObj.setDatiVariati(true);
			}
			break;
		case TIPO:
			if (pgManovreObj.getTipo().equals(valore)) {
			} else {
				pgManovreObj.setTipo((String) valore);
				pgManovreObj.setDatiVariati(true);
			}
			break;
		case DISCIPLINA:
			if (pgManovreObj.getDisciplina().equals(valore)) {
			} else {
				pgManovreObj.setDisciplina((String) valore);
				pgManovreObj.setDatiVariati(true);
			}
			break;
		case LVL:
			if (((String) valore).trim().isEmpty()) {
				pgManovreObj.setLvl(0);
			} else {
				if (pgManovreObj.getLvl() == Integer.parseInt((String) valore)) {
				} else {
					pgManovreObj.setLvl(Integer.parseInt((String) valore));
					pgManovreObj.setDatiVariati(true);
				}
			}
			break;
		case PRONTA:
			if (pgManovreObj.isPronta() == Boolean.valueOf(valore.toString())) {
			} else {
				pgManovreObj.setPronta(Boolean.valueOf(valore.toString()));
				pgManovreObj.setDatiVariati(true);
			}
			break;
		case DESCRIZIONE:
			if (pgManovreObj.getDescrizione().equals(valore)) {
			} else {
				pgManovreObj.setDescrizione((String) valore);
				pgManovreObj.setDatiVariati(true);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return pgManovreObj;
	}

	public PgEquipObj aggiornaEquip(PgEquipObj pgEquipObj, ListaPgEquip dato, Object valore) {
		switch (dato) {
		case NOME:
			if (pgEquipObj.getNome().equals(valore)) {
			} else {
				pgEquipObj.setNome((String) valore);
				pgEquipObj.setDatiVariati(true);
			}
			break;
		case NUMERO:
			if (((String) valore).trim().isEmpty()) {
				pgEquipObj.setNumero(0);
			} else {
				if (pgEquipObj.getNumero() == Integer.parseInt((String) valore)) {
				} else {
					pgEquipObj.setNumero(Integer.parseInt((String) valore));
					pgEquipObj.setDatiVariati(true);
				}
			}
			break;
		case PESO:
			if (((String) valore).trim().isEmpty()) {
				pgEquipObj.setPeso(0.00);
			} else {
				if (pgEquipObj.getPeso() == Double.parseDouble((String) valore)) {
				} else {
					pgEquipObj.setPeso(Double.parseDouble((String) valore));
					pgEquipObj.setDatiVariati(true);
				}
			}
			break;
		case INDOSSATO:
			if (pgEquipObj.isIndossato() == Boolean.valueOf(valore.toString())) {
			} else {
				pgEquipObj.setIndossato(Boolean.valueOf(valore.toString()));
				pgEquipObj.setDatiVariati(true);
			}
			break;
		case ZAINO:
			if (pgEquipObj.isZaino() == Boolean.valueOf(valore.toString())) {
			} else {
				pgEquipObj.setZaino(Boolean.valueOf(valore.toString()));
				pgEquipObj.setDatiVariati(true);
			}
			break;
		case TRASPORTATO:
			if (pgEquipObj.isTascaDaCintura() == Boolean.valueOf(valore.toString())) {
			} else {
				pgEquipObj.setTascaDaCintura(Boolean.valueOf(valore.toString()));
				pgEquipObj.setDatiVariati(true);
			}
			break;
		case ALTRO:
			if (pgEquipObj.isAltro() == Boolean.valueOf(valore.toString())) {
			} else {
				pgEquipObj.setAltro(Boolean.valueOf(valore.toString()));
				pgEquipObj.setDatiVariati(true);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return pgEquipObj;
	}

	public PgDatiObj aggiornaPgMovimento(PgDatiObj pgDatiObj, ListaPgMovimento dato,
			Object valore) {
		PgMovimentoObj pgMovimentoObj = pgDatiObj.getPgMovimentoObj();
		
		switch (dato) {
		case VELOCITA_DI_BASE:
			if (((String) valore).trim().isEmpty()) {
				pgMovimentoObj.setVelocitaDiBase(0.00);
			} else {
				if (pgMovimentoObj.getVelocitaDiBase() == Double.parseDouble((String) valore)) {
				} else {
					pgMovimentoObj.setVelocitaDiBase(Double.parseDouble((String) valore));
					pgMovimentoObj.setDatiVariati(true);
				}
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Campo " + dato + " non gestito", "Errore", JOptionPane.ERROR_MESSAGE);
			break;
		}
		pgDatiObj.setPgMovimentoObj(pgMovimentoObj);
		if (pgMovimentoObj.isDatiVariati()) {
			pgDatiObj.setDatiCommittati(false);
		}
		return pgDatiObj;
	}
	

}
