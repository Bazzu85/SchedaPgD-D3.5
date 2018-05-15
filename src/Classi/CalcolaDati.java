package Classi;

import java.util.ArrayList;

import json.GestioneJsonItems;
import obj.DbArmaturaScudoObj;
import obj.DbArmiObj;
import obj.DbTaglieObj;
import obj.PgAbilitaObj;
import obj.PgArmiObj;
import obj.PgBabObj;
import obj.PgBonusCalcolati;
import obj.PgCaricoObj;
import obj.PgClasseArmaturaObj;
import obj.PgClasseObj;
import obj.PgDatiObj;
import obj.PgEquipObj;
import obj.PgIniziativaObj;
import obj.PgMovimentoObj;
import obj.PgPuntiFeritaObj;
import obj.PgStatisticheObj;
import obj.PgTiriSalvezzaObj;

public class CalcolaDati {
	DbArmaturaScudoObj armaturaScudoObj = new DbArmaturaScudoObj();
	GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();

	public PgDatiObj calcola(PgDatiObj pgDatiObj) {

		pgDatiObj = calcolaLivelloTotalePg(pgDatiObj);
		pgDatiObj = calcolaPxLvlSucc(pgDatiObj);
		pgDatiObj = calcolaStatistiche(pgDatiObj);
		pgDatiObj = calcolaPuntiFerita(pgDatiObj);
		pgDatiObj = calcolaClasseArmatura(pgDatiObj);
		pgDatiObj = calcolaBab(pgDatiObj);
		pgDatiObj = calcolaTiriSalvezza(pgDatiObj);
		pgDatiObj = calcolaIniziativa(pgDatiObj);
		pgDatiObj = calcolaArmi(pgDatiObj);
		pgDatiObj = calcolaAbilita(pgDatiObj);
		pgDatiObj = calcolaPesi(pgDatiObj);
		pgDatiObj = calcolaMovimento(pgDatiObj);
		pgDatiObj = calcolaCarico(pgDatiObj);

		return pgDatiObj;
	}



	private PgDatiObj calcolaPuntiFerita(PgDatiObj pgDatiObj) {

		// Calcolo punti ferita totali
		PgPuntiFeritaObj pgPuntiFeritaObj = new PgPuntiFeritaObj();
		pgPuntiFeritaObj = pgDatiObj.getPgPuntiFeritaObj();
		int puntiFeritaTotali = 0;
		for (int i = 0; i < pgDatiObj.getArrayClassi().size(); i++) {
			if (pgDatiObj.getArrayClassi().get(i).getPuntiFerita() > 0) {
				puntiFeritaTotali = puntiFeritaTotali + pgDatiObj.getArrayClassi().get(i).getPuntiFerita();
			}
		}
		pgPuntiFeritaObj.setPuntiFeritaTotali(puntiFeritaTotali);

		// Calcolo punti ferita rimanenti
		int puntiFeritaRimanenti = pgPuntiFeritaObj.getPuntiFeritaTotali() - pgPuntiFeritaObj.getFeriteAttuali();
		pgPuntiFeritaObj.setPuntiFeritaRimanenti(puntiFeritaRimanenti);

		pgPuntiFeritaObj.setStatoPg("");

		if (pgPuntiFeritaObj.getFeriteAttuali() >= pgPuntiFeritaObj.getPuntiFeritaTotali() + 10) {
			pgPuntiFeritaObj.setStatoPg("Morto");
		} else {
			if (pgPuntiFeritaObj.getFeriteAttuali() > pgPuntiFeritaObj.getPuntiFeritaTotali()) {
				pgPuntiFeritaObj.setStatoPg("A terra");
			} else {
				if (pgPuntiFeritaObj.getDanniNonLetaliAttuali()
						+ pgPuntiFeritaObj.getFeriteAttuali() >= pgPuntiFeritaObj.getPuntiFeritaTotali()) {
					pgPuntiFeritaObj.setStatoPg("Svenuto");
				}
			}
		}

		pgDatiObj.setPgPuntiFeritaObj(pgPuntiFeritaObj);
		return pgDatiObj;
	}

	private PgDatiObj calcolaLivelloTotalePg(PgDatiObj pgDatiObj) {

		// Calcolo Livello Totale Pg
		int lvlTotPg = 0;
		for (int i = 0; i < pgDatiObj.getArrayClassi().size(); i++) {
			lvlTotPg = lvlTotPg + pgDatiObj.getArrayClassi().get(i).getLivello();
		}
		pgDatiObj.setLvlTotPg(lvlTotPg);

		return pgDatiObj;
	}

	private PgDatiObj calcolaPxLvlSucc(PgDatiObj pgDatiObj) {

		// Calcolo Punti esperienza per il livello successivo
		int pxLvlSucc = (pgDatiObj.getLvlTotPg() + 1) * pgDatiObj.getLvlTotPg() * 500;
		pgDatiObj.setPxLvlSucc(pxLvlSucc);
		return pgDatiObj;
	}

	private PgDatiObj calcolaStatistiche(PgDatiObj pgDatiObj) {
		// Calcolo modificatori per le statistiche
		PgStatisticheObj pgStatisticheObj = new PgStatisticheObj();
		pgStatisticheObj = pgDatiObj.getPgStatisticheObj();
		if (pgStatisticheObj.getForza() > 0) {
			pgStatisticheObj.setForzaMod(calcolcaModificatore(pgStatisticheObj.getForza()));
		} else {
			pgStatisticheObj.setForzaMod(0);
		}
		if (pgStatisticheObj.getDestrezza() > 0) {
			pgStatisticheObj.setDestrezzaMod(calcolcaModificatore(pgStatisticheObj.getDestrezza()));
		} else {
			pgStatisticheObj.setDestrezzaMod(0);
		}
		if (pgStatisticheObj.getCostituzione() > 0) {
			pgStatisticheObj.setCostituzioneMod(calcolcaModificatore(pgStatisticheObj.getCostituzione()));
		} else {
			pgStatisticheObj.setCostituzioneMod(0);
		}
		if (pgStatisticheObj.getIntelligenza() > 0) {
			pgStatisticheObj.setIntelligenzaMod(calcolcaModificatore(pgStatisticheObj.getIntelligenza()));
		} else {
			pgStatisticheObj.setIntelligenzaMod(0);
		}
		if (pgStatisticheObj.getSaggezza() > 0) {
			pgStatisticheObj.setSaggezzaMod(calcolcaModificatore(pgStatisticheObj.getSaggezza()));
		} else {
			pgStatisticheObj.setSaggezzaMod(0);
		}
		if (pgStatisticheObj.getCarisma() > 0) {
			pgStatisticheObj.setCarismaMod(calcolcaModificatore(pgStatisticheObj.getCarisma()));
		} else {
			pgStatisticheObj.setCarismaMod(0);
		}

		// Recupero bonus settati dall'utente
		PgBonusCalcolati pgBonusCalcolati = pgDatiObj.getPgBonusCalcolati();

		pgStatisticheObj.setForzaModCondizione(pgBonusCalcolati.getModificatoreForza());
		pgStatisticheObj.setForzaModCondizioneNota(pgBonusCalcolati.getModificatoreForzaDescrizione());
		pgStatisticheObj.setDestrezzaModCondizione(pgBonusCalcolati.getModificatoreDestrezza());
		pgStatisticheObj.setDestrezzaModCondizioneNota(pgBonusCalcolati.getModificatoreDestrezzaDescrizione());
		pgStatisticheObj.setCostituzioneModCondizione(pgBonusCalcolati.getModificatoreCostituzione());
		pgStatisticheObj.setCostituzioneModCondizioneNota(pgBonusCalcolati.getModificatoreCostituzioneDescrizione());
		pgStatisticheObj.setIntelligenzaModCondizione(pgBonusCalcolati.getModificatoreIntelligenza());
		pgStatisticheObj.setIntelligenzaModCondizioneNota(pgBonusCalcolati.getModificatoreIntelligenzaDescrizione());
		pgStatisticheObj.setSaggezzaModCondizione(pgBonusCalcolati.getModificatoreSaggezza());
		pgStatisticheObj.setSaggezzaModCondizioneNota(pgBonusCalcolati.getModificatoreSaggezzaDescrizione());
		pgStatisticheObj.setCarismaModCondizione(pgBonusCalcolati.getModificatoreCarisma());
		pgStatisticheObj.setCarismaModCondizioneNota(pgBonusCalcolati.getModificatoreCarismaDescrizione());

		// Calcolo modificatori di condizione

		if (pgStatisticheObj.getForzaModCondizione() != 0) {
			pgStatisticheObj.setForzaTemp(pgStatisticheObj.getForza() + pgStatisticheObj.getForzaModCondizione());
			pgStatisticheObj.setForzaTempMod(calcolcaModificatore(pgStatisticheObj.getForzaTemp()));
		} else {
			pgStatisticheObj.setForzaTemp(0);
			pgStatisticheObj.setForzaTempMod(0);
		}
		if (pgStatisticheObj.getDestrezzaModCondizione() != 0) {
			pgStatisticheObj
					.setDestrezzaTemp(pgStatisticheObj.getDestrezza() + pgStatisticheObj.getDestrezzaModCondizione());
			pgStatisticheObj.setDestrezzaTempMod(calcolcaModificatore(pgStatisticheObj.getDestrezzaTemp()));
		} else {
			pgStatisticheObj.setDestrezzaTemp(0);
			pgStatisticheObj.setDestrezzaTempMod(0);
		}
		if (pgStatisticheObj.getCostituzioneModCondizione() != 0) {
			pgStatisticheObj.setCostituzioneTemp(
					pgStatisticheObj.getCostituzione() + pgStatisticheObj.getCostituzioneModCondizione());
			pgStatisticheObj.setCostituzioneTempMod(calcolcaModificatore(pgStatisticheObj.getCostituzioneTemp()));
		} else {
			pgStatisticheObj.setCostituzioneTemp(0);
			pgStatisticheObj.setCostituzioneTempMod(0);
		}
		if (pgStatisticheObj.getIntelligenzaModCondizione() != 0) {
			pgStatisticheObj.setIntelligenzaTemp(
					pgStatisticheObj.getIntelligenza() + pgStatisticheObj.getIntelligenzaModCondizione());
			pgStatisticheObj.setIntelligenzaTempMod(calcolcaModificatore(pgStatisticheObj.getIntelligenzaTemp()));
		} else {
			pgStatisticheObj.setIntelligenzaTemp(0);
			pgStatisticheObj.setIntelligenzaTempMod(0);
		}
		if (pgStatisticheObj.getSaggezzaModCondizione() != 0) {
			pgStatisticheObj
					.setSaggezzaTemp(pgStatisticheObj.getSaggezza() + pgStatisticheObj.getSaggezzaModCondizione());
			pgStatisticheObj.setSaggezzaTempMod(calcolcaModificatore(pgStatisticheObj.getSaggezzaTemp()));
		} else {
			pgStatisticheObj.setSaggezzaTemp(0);
			pgStatisticheObj.setSaggezzaTempMod(0);
		}
		if (pgStatisticheObj.getCarismaModCondizione() != 0) {
			pgStatisticheObj.setCarismaTemp(pgStatisticheObj.getCarisma() + pgStatisticheObj.getCarismaModCondizione());
			pgStatisticheObj.setCarismaTempMod(calcolcaModificatore(pgStatisticheObj.getCarismaTemp()));
		} else {
			pgStatisticheObj.setCarismaTemp(0);
			pgStatisticheObj.setCarismaTempMod(0);
		}
		pgDatiObj.setPgStatisticheObj(pgStatisticheObj);
		return pgDatiObj;
	}

	private PgDatiObj calcolaClasseArmatura(PgDatiObj pgDatiObj) {
		// Calcolo dati per Classe Armatura

		PgClasseArmaturaObj pgClasseArmaturaObj = pgDatiObj.getPgClasseArmaturaObj();

		// Recupero bonus settati dall'utente
		PgBonusCalcolati pgBonusCalcolati = new PgBonusCalcolati();
		pgBonusCalcolati = pgDatiObj.getPgBonusCalcolati();

		pgClasseArmaturaObj.setBonusAltro(pgBonusCalcolati.getModificatoreClasseArmatura());

		// Calcolo Bonus Armatura e Scudo e valorizzazione statistiche
		int classeArmaturaBonusArmatura = 0;
		int classeArmaturaBonusScudo = 0;
		int fallimentoIncantesimiArcani = 0;
		int penalitaProvaArmatura = 0;
		if (!pgClasseArmaturaObj.getArmaturaScudo1().trim().isEmpty()) {
			armaturaScudoObj = gestioneJsonItems.getArmaturaScudoByName(pgClasseArmaturaObj.getArmaturaScudo1());
			pgClasseArmaturaObj.setArmaturaScudoStatistica1(armaturaScudoObj.getBonus());
			pgClasseArmaturaObj.setArmatura1(armaturaScudoObj.isArmatura());
			pgClasseArmaturaObj.setScudo1(armaturaScudoObj.isScudo());
			if (pgClasseArmaturaObj.isArmatura1()) {
				classeArmaturaBonusArmatura = classeArmaturaBonusArmatura
						+ pgClasseArmaturaObj.getArmaturaScudoStatistica1()
						+ pgClasseArmaturaObj.getArmaturaScudoBonus1();
			}
			if (pgClasseArmaturaObj.isScudo1()) {
				classeArmaturaBonusScudo = classeArmaturaBonusScudo + pgClasseArmaturaObj.getArmaturaScudoStatistica1()
						+ pgClasseArmaturaObj.getArmaturaScudoBonus1();
			}
			fallimentoIncantesimiArcani = fallimentoIncantesimiArcani
					+ armaturaScudoObj.getFallimentoIncantesimiArcani();
			penalitaProvaArmatura = penalitaProvaArmatura + armaturaScudoObj.getPenalitaProvaArmatura();
		}
		if (!pgClasseArmaturaObj.getArmaturaScudo2().trim().isEmpty()) {
			armaturaScudoObj = gestioneJsonItems.getArmaturaScudoByName(pgClasseArmaturaObj.getArmaturaScudo2());

			pgClasseArmaturaObj.setArmaturaScudoStatistica2(armaturaScudoObj.getBonus());
			pgClasseArmaturaObj.setArmatura2(armaturaScudoObj.isArmatura());
			pgClasseArmaturaObj.setScudo2(armaturaScudoObj.isScudo());
			if (pgClasseArmaturaObj.isArmatura2()) {
				classeArmaturaBonusArmatura = classeArmaturaBonusArmatura
						+ pgClasseArmaturaObj.getArmaturaScudoStatistica2()
						+ pgClasseArmaturaObj.getArmaturaScudoBonus2();
			}
			if (pgClasseArmaturaObj.isScudo2()) {
				classeArmaturaBonusScudo = classeArmaturaBonusScudo + pgClasseArmaturaObj.getArmaturaScudoStatistica2()
						+ pgClasseArmaturaObj.getArmaturaScudoBonus2();
			}
			fallimentoIncantesimiArcani = fallimentoIncantesimiArcani
					+ armaturaScudoObj.getFallimentoIncantesimiArcani();
			penalitaProvaArmatura = penalitaProvaArmatura + armaturaScudoObj.getPenalitaProvaArmatura();

		}
		if (!pgClasseArmaturaObj.getArmaturaScudo3().trim().isEmpty()) {
			armaturaScudoObj = gestioneJsonItems.getArmaturaScudoByName(pgClasseArmaturaObj.getArmaturaScudo3());
			pgClasseArmaturaObj.setArmaturaScudoStatistica3(armaturaScudoObj.getBonus());
			pgClasseArmaturaObj.setArmatura3(armaturaScudoObj.isArmatura());
			pgClasseArmaturaObj.setScudo3(armaturaScudoObj.isScudo());

			if (pgClasseArmaturaObj.isArmatura3()) {
				classeArmaturaBonusArmatura = classeArmaturaBonusArmatura
						+ pgClasseArmaturaObj.getArmaturaScudoStatistica3()
						+ pgClasseArmaturaObj.getArmaturaScudoBonus3();
			}
			if (pgClasseArmaturaObj.isScudo2()) {
				classeArmaturaBonusScudo = classeArmaturaBonusScudo + pgClasseArmaturaObj.getArmaturaScudoStatistica3()
						+ pgClasseArmaturaObj.getArmaturaScudoBonus3();
			}
			fallimentoIncantesimiArcani = fallimentoIncantesimiArcani
					+ armaturaScudoObj.getFallimentoIncantesimiArcani();
			penalitaProvaArmatura = penalitaProvaArmatura + armaturaScudoObj.getPenalitaProvaArmatura();
		}
		pgClasseArmaturaObj.setBonusArmatura(classeArmaturaBonusArmatura);
		pgClasseArmaturaObj.setBonusScudo(classeArmaturaBonusScudo);

		// Calcolo bonus taglia
		if (!pgDatiObj.getTaglia().trim().isEmpty()) {
			DbTaglieObj dbTaglieObj = gestioneJsonItems.getTagliaByName(pgDatiObj.getTaglia());
			pgClasseArmaturaObj.setBonusTaglia(dbTaglieObj.getModTaglia());
		} else {
			pgClasseArmaturaObj.setBonusTaglia(0);
		}

		// Calcolo Classe Armatura Bonus Destrezza
		if (pgDatiObj.getPgStatisticheObj().getDestrezzaTempMod() > pgDatiObj.getPgStatisticheObj().getDestrezzaMod()) {
			pgClasseArmaturaObj.setBonusDestrezza(pgDatiObj.getPgStatisticheObj().getDestrezzaTempMod());
		} else {
			pgClasseArmaturaObj.setBonusDestrezza(pgDatiObj.getPgStatisticheObj().getDestrezzaMod());
		}

		// Calcolo Classe Armatura Totale
		pgClasseArmaturaObj.setTotale(10 + pgClasseArmaturaObj.getBonusArmatura() + pgClasseArmaturaObj.getBonusScudo()
				+ pgClasseArmaturaObj.getBonusDestrezza() + pgClasseArmaturaObj.getBonusTaglia()
				+ pgClasseArmaturaObj.getBonusNaturale() + pgClasseArmaturaObj.getBonusDeviazione()
				+ pgClasseArmaturaObj.getBonusAltro() + pgClasseArmaturaObj.getBonusTemp());

		// Calcolo Classe Armatura Colto alla Sprovvista
		pgClasseArmaturaObj
				.setColtoAllaSprovvista(pgClasseArmaturaObj.getTotale() - pgClasseArmaturaObj.getBonusDestrezza());

		// Calcolo Classe Armatura Attacchi a Contatto
		pgClasseArmaturaObj
				.setAttacchiAContatto(pgClasseArmaturaObj.getTotale() - pgClasseArmaturaObj.getBonusArmatura()
						- pgClasseArmaturaObj.getBonusScudo() - pgClasseArmaturaObj.getBonusNaturale());

		// Calcolo Classe Armatura Bonus Massimo Destrezza
		if (pgDatiObj.getPgStatisticheObj().getDestrezzaTempMod() > pgDatiObj.getPgStatisticheObj().getDestrezzaMod()) {
			pgClasseArmaturaObj.setBonusMassimoDestrezza(pgDatiObj.getPgStatisticheObj().getDestrezzaTempMod());
		} else {
			pgClasseArmaturaObj.setBonusMassimoDestrezza(pgDatiObj.getPgStatisticheObj().getDestrezzaMod());
		}

		// Calcolo fallimento incantesimi arcani (se non editabile)
		if (!pgClasseArmaturaObj.isFlagFallimentoIncantesimiArcani()) {
			pgClasseArmaturaObj.setFallimentoIncantesimiArcani(fallimentoIncantesimiArcani);
		}
		// Calcolo penalita alla prova armatura (se non editabile)
		if (!pgClasseArmaturaObj.isFlagPenalitaProvaArmatura()) {
			pgClasseArmaturaObj.setPenalitaProvaArmatura(penalitaProvaArmatura);
		}

		pgDatiObj.setPgClasseArmaturaObj(pgClasseArmaturaObj);
		return pgDatiObj;
	}

	private PgDatiObj calcolaBab(PgDatiObj pgDatiObj) {
		// Calcolo dati per BAB
		CalcolaDatiBab calcolaDatiBab = new CalcolaDatiBab();
		pgDatiObj = calcolaDatiBab.calcola(pgDatiObj);

		return pgDatiObj;
	}

	private PgDatiObj calcolaTiriSalvezza(PgDatiObj pgDatiObj) {

		// Calcolo dati per Tiri Salvezza
		PgTiriSalvezzaObj pgTiriSalvezzaObj = new PgTiriSalvezzaObj();
		pgTiriSalvezzaObj = pgDatiObj.getPgTiriSalvezzaObj();

		// Recupero bonus settati dall'utente
		PgBonusCalcolati pgBonusCalcolati = new PgBonusCalcolati();
		pgBonusCalcolati = pgDatiObj.getPgBonusCalcolati();

		// Calcolo valori fissi per la colonna Abilita
		if (pgDatiObj.getPgStatisticheObj().getCostituzioneTempMod() > 0) {
			pgTiriSalvezzaObj.setTempraAbilita(pgDatiObj.getPgStatisticheObj().getCostituzioneTempMod());
		} else {
			pgTiriSalvezzaObj.setTempraAbilita(pgDatiObj.getPgStatisticheObj().getCostituzioneMod());
		}
		if (pgDatiObj.getPgStatisticheObj().getDestrezzaTempMod() > 0) {
			pgTiriSalvezzaObj.setRiflessiAbilita(pgDatiObj.getPgStatisticheObj().getDestrezzaTempMod());
		} else {
			pgTiriSalvezzaObj.setRiflessiAbilita(pgDatiObj.getPgStatisticheObj().getDestrezzaMod());
		}
		if (pgDatiObj.getPgStatisticheObj().getSaggezzaTempMod() > 0) {
			pgTiriSalvezzaObj.setVolontaAbilita(pgDatiObj.getPgStatisticheObj().getSaggezzaTempMod());
		} else {
			pgTiriSalvezzaObj.setVolontaAbilita(pgDatiObj.getPgStatisticheObj().getSaggezzaMod());
		}

		// Calcolo valori fissi per la colonna "Altro"

		pgTiriSalvezzaObj.setTempraAltro(pgBonusCalcolati.getModificatoreTiroSalvezzaTempra());

		pgTiriSalvezzaObj.setRiflessiAltro(pgBonusCalcolati.getModificatoreTiroSalvezzaRiflessi());
		pgTiriSalvezzaObj.setVolontaAltro(pgBonusCalcolati.getModificatoreTiroSalvezzaVolonta());
		// Aggiunta se presente il bonus a tutti i tiri salvezza
		pgTiriSalvezzaObj.setTempraAltro(
				pgTiriSalvezzaObj.getTempraAltro() + pgBonusCalcolati.getModificatoreTuttiTiriSalvezza());
		pgTiriSalvezzaObj.setRiflessiAltro(
				pgTiriSalvezzaObj.getRiflessiAltro() + pgBonusCalcolati.getModificatoreTuttiTiriSalvezza());
		pgTiriSalvezzaObj.setVolontaAltro(
				pgTiriSalvezzaObj.getVolontaAltro() + pgBonusCalcolati.getModificatoreTuttiTiriSalvezza());

		// Aggiunta descrizioni dei bonus
		pgTiriSalvezzaObj.setTempraAltroDescrizione("");
		if (!pgBonusCalcolati.getModificatoreTiroSalvezzaTempraDescrizione().trim().isEmpty()) {
			pgTiriSalvezzaObj
					.setTempraAltroDescrizione(pgBonusCalcolati.getModificatoreTiroSalvezzaTempraDescrizione());
		}
		if (!pgBonusCalcolati.getModificatoreTuttiTiriSalvezzaDescrizione().trim().isEmpty()) {
			if (pgTiriSalvezzaObj.getTempraAltroDescrizione().trim().isEmpty()) {
				pgTiriSalvezzaObj
						.setTempraAltroDescrizione(pgBonusCalcolati.getModificatoreTuttiTiriSalvezzaDescrizione());
			} else {
				pgTiriSalvezzaObj.setTempraAltroDescrizione(pgTiriSalvezzaObj.getTempraAltroDescrizione() + " + "
						+ pgBonusCalcolati.getModificatoreTuttiTiriSalvezzaDescrizione());
			}
		}
		pgTiriSalvezzaObj.setRiflessiAltroDescrizione("");
		if (!pgBonusCalcolati.getModificatoreTiroSalvezzaRiflessiDescrizione().trim().isEmpty()) {
			pgTiriSalvezzaObj
					.setRiflessiAltroDescrizione(pgBonusCalcolati.getModificatoreTiroSalvezzaRiflessiDescrizione());
		}
		if (!pgBonusCalcolati.getModificatoreTuttiTiriSalvezzaDescrizione().trim().isEmpty()) {
			if (pgTiriSalvezzaObj.getRiflessiAltroDescrizione().trim().isEmpty()) {
				pgTiriSalvezzaObj
						.setRiflessiAltroDescrizione(pgBonusCalcolati.getModificatoreTuttiTiriSalvezzaDescrizione());
			} else {
				pgTiriSalvezzaObj.setRiflessiAltroDescrizione(pgTiriSalvezzaObj.getRiflessiAltroDescrizione() + " + "
						+ pgBonusCalcolati.getModificatoreTuttiTiriSalvezzaDescrizione());
			}
		}
		pgTiriSalvezzaObj.setVolontaAltroDescrizione("");
		if (!pgBonusCalcolati.getModificatoreTiroSalvezzaVolontaDescrizione().trim().isEmpty()) {
			pgTiriSalvezzaObj
					.setVolontaAltroDescrizione(pgBonusCalcolati.getModificatoreTiroSalvezzaVolontaDescrizione());
		}
		if (!pgBonusCalcolati.getModificatoreTuttiTiriSalvezzaDescrizione().trim().isEmpty()) {
			if (pgTiriSalvezzaObj.getVolontaAltroDescrizione().trim().isEmpty()) {
				pgTiriSalvezzaObj
						.setVolontaAltroDescrizione(pgBonusCalcolati.getModificatoreTuttiTiriSalvezzaDescrizione());
			} else {
				pgTiriSalvezzaObj.setVolontaAltroDescrizione(pgTiriSalvezzaObj.getVolontaAltroDescrizione() + " + "
						+ pgBonusCalcolati.getModificatoreTuttiTiriSalvezzaDescrizione());
			}
		}

		// Calcolo totali
		int tempraTotale = pgTiriSalvezzaObj.getTempraBase() + pgTiriSalvezzaObj.getTempraAbilita()
				+ pgTiriSalvezzaObj.getTempraMagia() + pgTiriSalvezzaObj.getTempraAltro();
		pgTiriSalvezzaObj.setTempraTotale(tempraTotale);

		int riflessiTotale = pgTiriSalvezzaObj.getRiflessiBase() + pgTiriSalvezzaObj.getRiflessiAbilita()
				+ pgTiriSalvezzaObj.getRiflessiMagia() + pgTiriSalvezzaObj.getRiflessiAltro();
		pgTiriSalvezzaObj.setRiflessiTotale(riflessiTotale);

		int volontaTotale = pgTiriSalvezzaObj.getVolontaBase() + pgTiriSalvezzaObj.getVolontaAbilita()
				+ pgTiriSalvezzaObj.getVolontaMagia() + pgTiriSalvezzaObj.getVolontaAltro();
		pgTiriSalvezzaObj.setVolontaTotale(volontaTotale);

		pgDatiObj.setPgTiriSalvezzaObj(pgTiriSalvezzaObj);
		return pgDatiObj;
	}

	private PgDatiObj calcolaIniziativa(PgDatiObj pgDatiObj) {
		// Calcolo dati per Iniziativa
		PgIniziativaObj pgIniziativaObj = new PgIniziativaObj();
		pgIniziativaObj = pgDatiObj.getPgIniziativaObj();
		// Recupero bonus settati dall'utente
		PgBonusCalcolati pgBonusCalcolati = new PgBonusCalcolati();
		pgBonusCalcolati = pgDatiObj.getPgBonusCalcolati();

		// Calcolo valori fissi per la colonna Destrezza
		if (pgDatiObj.getPgStatisticheObj().getDestrezzaTempMod() > 0) {
			pgIniziativaObj.setDestrezza(pgDatiObj.getPgStatisticheObj().getDestrezzaTempMod());
		} else {
			pgIniziativaObj.setDestrezza(pgDatiObj.getPgStatisticheObj().getDestrezzaMod());
		}

		// Calcolo valori per la colonna Talenti dai bonus
		pgIniziativaObj.setTalenti(pgBonusCalcolati.getModificatoreIniziativaTalenti());
		pgIniziativaObj.setTalentiDescrizione("");
		if (!pgBonusCalcolati.getModificatoreIniziativaTalentiDescrizione().trim().isEmpty()) {
			pgIniziativaObj.setTalentiDescrizione(pgBonusCalcolati.getModificatoreIniziativaTalentiDescrizione());
		}

		// Calcolo valori per la colonna Altro dai bonus
		pgIniziativaObj.setAltro(pgBonusCalcolati.getModificatoreIniziativaAltro());
		pgIniziativaObj.setAltroDescrizione("");
		if (!pgBonusCalcolati.getModificatoreIniziativaAltroDescrizione().trim().isEmpty()) {
			pgIniziativaObj.setAltroDescrizione(pgBonusCalcolati.getModificatoreIniziativaAltroDescrizione());
		}

		// Calcolo totali
		int iniziativaTotale = pgIniziativaObj.getDestrezza() + pgIniziativaObj.getTalenti()
				+ pgIniziativaObj.getMagia() + pgIniziativaObj.getAltro();
		pgIniziativaObj.setTotale(iniziativaTotale);

		pgDatiObj.setPgIniziativaObj(pgIniziativaObj);
		return pgDatiObj;
	}

	private PgDatiObj calcolaArmi(PgDatiObj pgDatiObj) {

		// Calcolo dati per Armi
		CalcolaDatiArmi calcolaDatiArmi = new CalcolaDatiArmi();
		pgDatiObj = calcolaDatiArmi.calcola(pgDatiObj);
		return pgDatiObj;

	}

	private PgDatiObj calcolaAbilita(PgDatiObj pgDatiObj) {
		ArrayList<PgAbilitaObj> arrayPgAbilita = pgDatiObj.getArrayAbilita();

		// Recupero bonus settati dall'utente
		PgBonusCalcolati pgBonusCalcolati = pgDatiObj.getPgBonusCalcolati();

		for (int i = 0; i < arrayPgAbilita.size(); i++) {
			PgAbilitaObj pgAbilitaObj = arrayPgAbilita.get(i);
			PgStatisticheObj pgStatisticheObj = pgDatiObj.getPgStatisticheObj();
			switch (pgAbilitaObj.getCaratteristica()) {
			case "FOR":
				if (pgStatisticheObj.getForzaTempMod() > 0) {
					pgAbilitaObj.setModCaratteristica(pgStatisticheObj.getForzaTempMod());
				} else {
					pgAbilitaObj.setModCaratteristica(pgStatisticheObj.getForzaMod());
				}
				break;
			case "DES":
				if (pgStatisticheObj.getDestrezzaTempMod() > 0) {
					pgAbilitaObj.setModCaratteristica(pgStatisticheObj.getDestrezzaTempMod());
				} else {
					pgAbilitaObj.setModCaratteristica(pgStatisticheObj.getDestrezzaMod());
				}
				break;
			case "COS":
				if (pgStatisticheObj.getCostituzioneTempMod() > 0) {
					pgAbilitaObj.setModCaratteristica(pgStatisticheObj.getCostituzioneTempMod());
				} else {
					pgAbilitaObj.setModCaratteristica(pgStatisticheObj.getCostituzioneMod());
				}
				break;
			case "INT":
				if (pgStatisticheObj.getIntelligenzaTempMod() > 0) {
					pgAbilitaObj.setModCaratteristica(pgStatisticheObj.getIntelligenzaTempMod());
				} else {
					pgAbilitaObj.setModCaratteristica(pgStatisticheObj.getIntelligenzaMod());
				}
				break;
			case "SAG":
				if (pgStatisticheObj.getSaggezzaTempMod() > 0) {
					pgAbilitaObj.setModCaratteristica(pgStatisticheObj.getSaggezzaTempMod());
				} else {
					pgAbilitaObj.setModCaratteristica(pgStatisticheObj.getSaggezzaMod());
				}
				break;
			case "CAR":
				if (pgStatisticheObj.getCarismaTempMod() > 0) {
					pgAbilitaObj.setModCaratteristica(pgStatisticheObj.getCarismaTempMod());
				} else {
					pgAbilitaObj.setModCaratteristica(pgStatisticheObj.getCarismaMod());
				}
				break;
			}

			// Impostiamo il bonus utente
			pgAbilitaObj.setBonus(pgBonusCalcolati.getModificatoreAbilita());

			// Calcolo totale
			pgAbilitaObj.setTotale(pgAbilitaObj.getModCaratteristica() + pgAbilitaObj.getGrado()
					+ pgAbilitaObj.getAltro() + pgAbilitaObj.getBonus());
			arrayPgAbilita.set(i, pgAbilitaObj);
		}

		pgDatiObj.setArrayAbilita(arrayPgAbilita);

		return pgDatiObj;
	}

	private PgDatiObj calcolaPesi(PgDatiObj pgDatiObj) {

		ArrayList<PgEquipObj> arrayEquip = pgDatiObj.getArrayEquip();

		Double totalePesiIndossato = 0.00;
		Double totalePesiZaino = 0.00;
		Double totalePesiTascaDaCintura = 0.00;
		Double totalePesiAltro = 0.00;
		Double totalePesi = 0.00;
		for (int i = 0; i < arrayEquip.size(); i++) {
			PgEquipObj pgEquipObj = arrayEquip.get(i);
			if (pgEquipObj.getPeso() > 0) {
				if (pgEquipObj.isIndossato()) {
					totalePesiIndossato = totalePesiIndossato + pgEquipObj.getPeso();
				}
				if (pgEquipObj.isZaino()) {
					totalePesiZaino = totalePesiZaino + pgEquipObj.getPeso();
				}
				if (pgEquipObj.isTascaDaCintura()) {
					totalePesiTascaDaCintura = totalePesiTascaDaCintura + pgEquipObj.getPeso();
				}
				if (pgEquipObj.isAltro()) {
					totalePesiAltro = totalePesiAltro + pgEquipObj.getPeso();
				}
				totalePesi = totalePesi + pgEquipObj.getPeso();
			}
		}

		pgDatiObj.setTotalePesiIndossato(totalePesiIndossato);
		pgDatiObj.setTotalePesiZaino(totalePesiZaino);
		pgDatiObj.setTotalePesiTascaDaCintura(totalePesiTascaDaCintura);
		pgDatiObj.setTotalePesiAltro(totalePesiAltro);
		pgDatiObj.setTotalePesi(totalePesi);

		return pgDatiObj;
	}

	private PgDatiObj calcolaMovimento(PgDatiObj pgDatiObj) {
		PgMovimentoObj pgMovimentoObj = pgDatiObj.getPgMovimentoObj();
		
		Double tattico = pgMovimentoObj.getVelocitaDiBase();
		pgMovimentoObj.setTatticoX1(tattico);
		pgMovimentoObj.setTatticoX2(tattico * 2);
		pgMovimentoObj.setTatticoX3(tattico * 3);
		pgMovimentoObj.setTatticoX4(tattico * 4);
		
		Double locale = pgMovimentoObj.getVelocitaDiBase() * 10;
		pgMovimentoObj.setLocaleX1(locale);
		pgMovimentoObj.setLocaleX2(locale * 2);
		pgMovimentoObj.setLocaleX3(locale * 3);
		pgMovimentoObj.setLocaleX4(locale * 4);

		Double ora = (locale * 60) / 1000;
		pgMovimentoObj.setOraX1(ora);
		pgMovimentoObj.setOraX2(ora * 2);
		pgMovimentoObj.setOraX3("x");
		pgMovimentoObj.setOraX4("x");
		
		Double giorno = ora * 8;
		pgMovimentoObj.setGiornoX1(giorno);
		pgMovimentoObj.setGiornoX2("x");
		pgMovimentoObj.setGiornoX3("x");
		pgMovimentoObj.setGiornoX4("x");
		
		pgDatiObj.setPgMovimentoObj(pgMovimentoObj);
		return pgDatiObj;
	}
	private PgDatiObj calcolaCarico(PgDatiObj pgDatiObj) {

		PgCaricoObj pgCaricoObj = pgDatiObj.getPgCaricoObj();
		PgStatisticheObj pgStatisticheObj = pgDatiObj.getPgStatisticheObj();

		int forza = 0;
		if (pgStatisticheObj.getForzaTemp() > 0) {
			forza = pgStatisticheObj.getForzaTemp();
		} else {
			forza = pgStatisticheObj.getForza();
		}
		Double caricoLeggeroMin = 0.00;
		Double caricoLeggeroMax = 0.00;
		Double caricoMedioMin = 0.00;
		Double caricoMedioMax = 0.00;
		Double caricoPesanteMin = 0.00;
		Double caricoPesanteMax = 0.00;
		boolean altro = false;
		switch (forza) {
		case 1:
			caricoLeggeroMax = 1.50;
			caricoMedioMin = 2.00;
			caricoMedioMax = 3.00;
			caricoPesanteMin = 3.50;
			caricoPesanteMax = 5.00;
			break;
		case 2:
			caricoLeggeroMax = 3.00;
			caricoMedioMin = 3.50;
			caricoMedioMax = 6.50;
			caricoPesanteMin = 7.00;
			caricoPesanteMax = 10.00;
			break;
		case 3:
			caricoLeggeroMax = 5.00;
			caricoMedioMin = 5.50;
			caricoMedioMax = 10.00;
			caricoPesanteMin = 10.50;
			caricoPesanteMax = 15.00;
			break;
		case 4:
			caricoLeggeroMax = 6.50;
			caricoMedioMin = 7.00;
			caricoMedioMax = 13.00;
			caricoPesanteMin = 13.50;
			caricoPesanteMax = 20.00;
			break;
		case 5:
			caricoLeggeroMax = 8.00;
			caricoMedioMin = 8.50;
			caricoMedioMax = 16.50;
			caricoPesanteMin = 17.00;
			caricoPesanteMax = 25.00;
			break;
		case 6:
			caricoLeggeroMax = 10.00;
			caricoMedioMin = 10.50;
			caricoMedioMax = 20.00;
			caricoPesanteMin = 20.50;
			caricoPesanteMax = 30.00;
			break;
		case 7:
			caricoLeggeroMax = 11.50;
			caricoMedioMin = 12.00;
			caricoMedioMax = 23.00;
			caricoPesanteMin = 23.50;
			caricoPesanteMax = 35.00;
			break;
		case 8:
			caricoLeggeroMax = 13.00;
			caricoMedioMin = 13.50;
			caricoMedioMax = 26.50;
			caricoPesanteMin = 27.00;
			caricoPesanteMax = 40.00;
			break;
		case 9:
			caricoLeggeroMax = 15.00;
			caricoMedioMin = 15.50;
			caricoMedioMax = 30.00;
			caricoPesanteMin = 30.50;
			caricoPesanteMax = 45.00;
			break;
		case 10:
			caricoLeggeroMax = 16.50;
			caricoMedioMin = 17.00;
			caricoMedioMax = 33.00;
			caricoPesanteMin = 33.50;
			caricoPesanteMax = 50.00;
			break;
		case 11:
			caricoLeggeroMax = 19.00;
			caricoMedioMin = 19.50;
			caricoMedioMax = 38.00;
			caricoPesanteMin = 38.50;
			caricoPesanteMax = 57.50;
			break;
		case 12:
			caricoLeggeroMax = 21.50;
			caricoMedioMin = 22.00;
			caricoMedioMax = 43.00;
			caricoPesanteMin = 43.50;
			caricoPesanteMax = 65.00;
			break;
		case 13:
			caricoLeggeroMax = 25.00;
			caricoMedioMin = 25.50;
			caricoMedioMax = 50.00;
			caricoPesanteMin = 50.50;
			caricoPesanteMax = 75.00;
			break;
		case 14:
			caricoLeggeroMax = 29.00;
			caricoMedioMin = 29.50;
			caricoMedioMax = 58.00;
			caricoPesanteMin = 58.50;
			caricoPesanteMax = 87.50;
			break;
		case 15:
			caricoLeggeroMax = 33.00;
			caricoMedioMin = 33.50;
			caricoMedioMax = 66.50;
			caricoPesanteMin = 67.00;
			caricoPesanteMax = 100.00;
			break;
		case 16:
			caricoLeggeroMax = 38.00;
			caricoMedioMin = 38.50;
			caricoMedioMax = 76.50;
			caricoPesanteMin = 77.00;
			caricoPesanteMax = 115.00;
			break;
		case 17:
			caricoLeggeroMax = 43.00;
			caricoMedioMin = 43.50;
			caricoMedioMax = 86.50;
			caricoPesanteMin = 87.00;
			caricoPesanteMax = 130.00;
			break;
		case 18:
			caricoLeggeroMax = 50.00;
			caricoMedioMin = 50.50;
			caricoMedioMax = 100.00;
			caricoPesanteMin = 100.50;
			caricoPesanteMax = 150.00;
			break;
		case 19:
			caricoLeggeroMax = 58.00;
			caricoMedioMin = 58.50;
			caricoMedioMax = 116.50;
			caricoPesanteMin = 117.00;
			caricoPesanteMax = 175.00;
			break;
		case 20:
			caricoLeggeroMax = 66.50;
			caricoMedioMin = 67.00;
			caricoMedioMax = 133.00;
			caricoPesanteMin = 133.50;
			caricoPesanteMax = 200.00;
			break;
		case 21:
			caricoLeggeroMax = 76.50;
			caricoMedioMin = 77.00;
			caricoMedioMax = 153.00;
			caricoPesanteMin = 153.50;
			caricoPesanteMax = 230.00;
			break;
		case 22:
			caricoLeggeroMax = 86.50;
			caricoMedioMin = 87.00;
			caricoMedioMax = 173.00;
			caricoPesanteMin = 173.50;
			caricoPesanteMax = 260.00;
			break;
		case 23:
			caricoLeggeroMax = 100.00;
			caricoMedioMin = 100.50;
			caricoMedioMax = 200.00;
			caricoPesanteMin = 200.50;
			caricoPesanteMax = 300.00;
			break;
		case 24:
			caricoLeggeroMax = 116.50;
			caricoMedioMin = 117.00;
			caricoMedioMax = 233.00;
			caricoPesanteMin = 233.50;
			caricoPesanteMax = 350.00;
			break;
		case 25:
			caricoLeggeroMax = 133.00;
			caricoMedioMin = 133.50;
			caricoMedioMax = 266.50;
			caricoPesanteMin = 267.00;
			caricoPesanteMax = 400.00;
			break;
		case 26:
			caricoLeggeroMax = 153.00;
			caricoMedioMin = 153.50;
			caricoMedioMax = 306.50;
			caricoPesanteMin = 307.00;
			caricoPesanteMax = 460.00;
			break;
		case 27:
			caricoLeggeroMax = 173.00;
			caricoMedioMin = 173.50;
			caricoMedioMax = 346.50;
			caricoPesanteMin = 347.00;
			caricoPesanteMax = 520.00;
			break;
		case 28:
			caricoLeggeroMax = 200.00;
			caricoMedioMin = 200.50;
			caricoMedioMax = 400.00;
			caricoPesanteMin = 400.50;
			caricoPesanteMax = 600.00;
			break;
		case 29:
			caricoLeggeroMax = 233.00;
			caricoMedioMin = 233.50;
			caricoMedioMax = 466.50;
			caricoPesanteMin = 467.00;
			caricoPesanteMax = 700.00;
			break;
		case 30:
			caricoLeggeroMax = 66.50 * 4;
			caricoMedioMin = 67.00 * 4;
			caricoMedioMax = 133.00 * 4;
			caricoPesanteMin = 133.50 * 4;
			caricoPesanteMax  = 200.00 * 4;
			break;
		case 31:
			caricoLeggeroMax = 76.50 * 4;
			caricoMedioMin = 77.00 * 4;
			caricoMedioMax = 153.00 * 4;
			caricoPesanteMin = 153.50 * 4;
			caricoPesanteMax = 230.00 * 4;
			break;
		case 32:
			caricoLeggeroMax = 86.50 * 4;
			caricoMedioMin = 87.00 * 4;
			caricoMedioMax = 173.00 * 4;
			caricoPesanteMin = 173.50 * 4;
			caricoPesanteMax = 260.00 * 4;
			break;
		case 33:
			caricoLeggeroMax = 100.00 * 4;
			caricoMedioMin = 100.50 * 4;
			caricoMedioMax = 200.00 * 4;
			caricoPesanteMin = 200.50 * 4;
			caricoPesanteMax = 300.00 * 4;
			break;
		case 34:
			caricoLeggeroMax = 116.50 * 4;
			caricoMedioMin = 117.00 * 4;
			caricoMedioMax = 233.00 * 4;
			caricoPesanteMin = 233.50 * 4;
			caricoPesanteMax = 350.00 * 4;
			break;
		case 35:
			caricoLeggeroMax = 133.00 * 4;
			caricoMedioMin = 133.50 * 4;
			caricoMedioMax = 266.50 * 4;
			caricoPesanteMin = 267.00 * 4;
			caricoPesanteMax = 400.00 * 4;
			break;
		case 36:
			caricoLeggeroMax = 153.00 * 4;
			caricoMedioMin = 153.50 * 4;
			caricoMedioMax = 306.50 * 4;
			caricoPesanteMin = 307.00 * 4;
			caricoPesanteMax = 460.00 * 4;
			break;
		case 37:
			caricoLeggeroMax = 173.00 * 4;
			caricoMedioMin = 173.50 * 4;
			caricoMedioMax = 346.50 * 4;
			caricoPesanteMin = 347.00 * 4;
			caricoPesanteMax = 520.00 * 4;
			break;
		case 38:
			caricoLeggeroMax = 200.00 * 4;
			caricoMedioMin = 200.50 * 4;
			caricoMedioMax = 400.00 * 4;
			caricoPesanteMin = 400.50 * 4;
			caricoPesanteMax = 600.00 * 4;
			break;
		case 39:
			caricoLeggeroMax = 233.00 * 4;
			caricoMedioMin = 233.50 * 4;
			caricoMedioMax = 466.50 * 4;
			caricoPesanteMin = 467.00 * 4;
			caricoPesanteMax = 700.00 * 4;
			break;
		default:
			altro = true;
			break;
		}

		Double sollevareSopraLaTesta = caricoPesanteMax;
		Double sollevareDalTerreno = caricoPesanteMax * 2;
		Double spingereTrascinare = caricoPesanteMax * 5;
		
		if (altro) {
			pgCaricoObj.setCaricoLeggero("oltrepassato limite");
			pgCaricoObj.setCaricoMedio("oltrepassato limite");
			pgCaricoObj.setCaricoPesante("oltrepassato limite");
			pgCaricoObj.setSollevareSopraLaTesta("oltrepassato limite");
			pgCaricoObj.setSollevareDalTerreno("oltrepassato limite");
			pgCaricoObj.setSpingereTrascinare("oltrepassato limite");
		} else {
			pgCaricoObj.setCaricoLeggero("da 0 a " + caricoLeggeroMax);
			pgCaricoObj.setCaricoMedio("da " + caricoMedioMin + " a " + caricoMedioMax);
			pgCaricoObj.setCaricoPesante("da " + caricoPesanteMin + " a " + caricoPesanteMax);
			pgCaricoObj.setSollevareSopraLaTesta(sollevareSopraLaTesta + " Kg");
			pgCaricoObj.setSollevareDalTerreno(sollevareDalTerreno + " Kg");
			pgCaricoObj.setSpingereTrascinare(spingereTrascinare + " Kg");
		}
		
		
		pgDatiObj.setPgCaricoObj(pgCaricoObj);
		return pgDatiObj;
	}

	private int calcolcaModificatore(int valore) {
		int modificatore = (valore - 10) / 2;
		return modificatore;
	}

	public PgDatiObj aggiungiDanno(PgDatiObj pgDatiObj) {
		PgPuntiFeritaObj pgPuntiFeritaObj = pgDatiObj.getPgPuntiFeritaObj();
		int feriteAttuali = pgPuntiFeritaObj.getFeriteAttuali();
		int ferite = pgPuntiFeritaObj.getFerite();
		feriteAttuali = feriteAttuali + ferite;
		pgPuntiFeritaObj.setFeriteAttuali(feriteAttuali);
		pgPuntiFeritaObj.setDatiVariati(true);
		pgDatiObj.setDatiCommittati(false);
		return pgDatiObj;
	}

	public PgDatiObj aggiungiCura(PgDatiObj pgDatiObj) {
		PgPuntiFeritaObj pgPuntiFeritaObj = pgDatiObj.getPgPuntiFeritaObj();
		int feriteAttuali = pgPuntiFeritaObj.getFeriteAttuali();
		int ferite = pgPuntiFeritaObj.getFerite();
		feriteAttuali = feriteAttuali - ferite;
		pgPuntiFeritaObj.setFeriteAttuali(feriteAttuali);
		pgPuntiFeritaObj.setDatiVariati(true);
		pgDatiObj.setDatiCommittati(false);
		return pgDatiObj;
	}

	public PgDatiObj aggiungiDanniNonLetali(PgDatiObj pgDatiObj) {
		PgPuntiFeritaObj pgPuntiFeritaObj = pgDatiObj.getPgPuntiFeritaObj();
		int danniNonLetaliAttuali = pgPuntiFeritaObj.getDanniNonLetaliAttuali();
		int danniNonLetali = pgPuntiFeritaObj.getDanniNonLetali();
		danniNonLetaliAttuali = danniNonLetaliAttuali + danniNonLetali;
		pgPuntiFeritaObj.setDanniNonLetaliAttuali(danniNonLetaliAttuali);
		pgPuntiFeritaObj.setDatiVariati(true);
		pgDatiObj.setDatiCommittati(false);
		return pgDatiObj;
	}

	public PgDatiObj curaDanniNonLetali(PgDatiObj pgDatiObj) {
		PgPuntiFeritaObj pgPuntiFeritaObj = pgDatiObj.getPgPuntiFeritaObj();
		int danniNonLetaliAttuali = pgPuntiFeritaObj.getDanniNonLetaliAttuali();
		int danniNonLetali = pgPuntiFeritaObj.getDanniNonLetali();
		danniNonLetaliAttuali = danniNonLetaliAttuali - danniNonLetali;
		pgPuntiFeritaObj.setDanniNonLetaliAttuali(danniNonLetaliAttuali);
		pgPuntiFeritaObj.setDatiVariati(true);
		pgDatiObj.setDatiCommittati(false);
		return pgDatiObj;
	}

}
