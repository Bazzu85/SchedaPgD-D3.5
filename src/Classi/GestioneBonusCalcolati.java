package Classi;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import obj.PgBonusCalcolati;
import obj.PgBonusObj;

public class GestioneBonusCalcolati {

	public static PgBonusCalcolati calcola(ArrayList<PgBonusObj> arrayPgBonus) {
		PgBonusCalcolati pgBonusCalcolati = new PgBonusCalcolati();

		String modConSegno = "";
		for (int i = 0; i < arrayPgBonus.size(); i++) {
			switch (arrayPgBonus.get(i).getBonus()) {
			case "Modificatore Forza":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreForza(
							pgBonusCalcolati.getModificatoreForza() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreForzaDescrizione().trim().isEmpty()) {
							pgBonusCalcolati
									.setModificatoreForzaDescrizione(pgBonusCalcolati.getModificatoreForzaDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati
									.setModificatoreForzaDescrizione(pgBonusCalcolati.getModificatoreForzaDescrizione()
											+ " + " + arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore Destrezza":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreDestrezza(
							pgBonusCalcolati.getModificatoreDestrezza() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreDestrezzaDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreDestrezzaDescrizione(
									pgBonusCalcolati.getModificatoreDestrezzaDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreDestrezzaDescrizione(
									pgBonusCalcolati.getModificatoreDestrezzaDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore Costituzione":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreCostituzione(
							pgBonusCalcolati.getModificatoreCostituzione() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreCostituzioneDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreCostituzioneDescrizione(
									pgBonusCalcolati.getModificatoreCostituzioneDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreCostituzioneDescrizione(
									pgBonusCalcolati.getModificatoreCostituzioneDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore Intelligenza":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreIntelligenza(
							pgBonusCalcolati.getModificatoreIntelligenza() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreIntelligenzaDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreIntelligenzaDescrizione(
									pgBonusCalcolati.getModificatoreIntelligenzaDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreIntelligenzaDescrizione(
									pgBonusCalcolati.getModificatoreIntelligenzaDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore Saggezza":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreSaggezza(
							pgBonusCalcolati.getModificatoreSaggezza() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreSaggezzaDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreSaggezzaDescrizione(
									pgBonusCalcolati.getModificatoreSaggezzaDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreSaggezzaDescrizione(
									pgBonusCalcolati.getModificatoreSaggezzaDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore Carisma":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreCarisma(
							pgBonusCalcolati.getModificatoreCarisma() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreCarismaDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreCarismaDescrizione(
									pgBonusCalcolati.getModificatoreCarismaDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreCarismaDescrizione(
									pgBonusCalcolati.getModificatoreCarismaDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore Classe Armatura":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreClasseArmatura(
							pgBonusCalcolati.getModificatoreClasseArmatura() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreClasseArmaturaDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreClasseArmaturaDescrizione(
									pgBonusCalcolati.getModificatoreClasseArmaturaDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreClasseArmaturaDescrizione(
									pgBonusCalcolati.getModificatoreClasseArmaturaDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore Bab Mischia":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreBabMischia(
							pgBonusCalcolati.getModificatoreBabMischia() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreBabMischiaDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreBabMischiaDescrizione(
									pgBonusCalcolati.getModificatoreBabMischiaDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreBabMischiaDescrizione(
									pgBonusCalcolati.getModificatoreBabMischiaDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore Bab Distanza":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreBabDistanza(
							pgBonusCalcolati.getModificatoreBabDistanza() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreBabDistanzaDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreBabDistanzaDescrizione(
									pgBonusCalcolati.getModificatoreBabDistanzaDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreBabDistanzaDescrizione(
									pgBonusCalcolati.getModificatoreBabDistanzaDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore Tiro Salvezza su Tempra":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreTiroSalvezzaTempra(pgBonusCalcolati.getModificatoreTiroSalvezzaTempra() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreTiroSalvezzaTempraDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreTiroSalvezzaTempraDescrizione(
									pgBonusCalcolati.getModificatoreTiroSalvezzaTempraDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreTiroSalvezzaTempraDescrizione(
									pgBonusCalcolati.getModificatoreTiroSalvezzaTempraDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore Tiro Salvezza su Riflessi":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreTiroSalvezzaRiflessi(pgBonusCalcolati.getModificatoreTiroSalvezzaRiflessi() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreTiroSalvezzaRiflessiDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreTiroSalvezzaRiflessiDescrizione(
									pgBonusCalcolati.getModificatoreTiroSalvezzaRiflessiDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreTiroSalvezzaRiflessiDescrizione(
									pgBonusCalcolati.getModificatoreTiroSalvezzaRiflessiDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore Tiro Salvezza su Volonta":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreTiroSalvezzaVolonta(pgBonusCalcolati.getModificatoreTiroSalvezzaVolonta() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreTiroSalvezzaVolontaDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreTiroSalvezzaVolontaDescrizione(
									pgBonusCalcolati.getModificatoreTiroSalvezzaVolontaDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreTiroSalvezzaVolontaDescrizione(
									pgBonusCalcolati.getModificatoreTiroSalvezzaVolontaDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore a tutti i Tiri Salvezza":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreTuttiTiriSalvezza(pgBonusCalcolati.getModificatoreTuttiTiriSalvezza() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreTuttiTiriSalvezzaDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreTuttiTiriSalvezzaDescrizione(
									pgBonusCalcolati.getModificatoreTuttiTiriSalvezzaDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreTuttiTiriSalvezzaDescrizione(
									pgBonusCalcolati.getModificatoreTuttiTiriSalvezzaDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore a Iniziativa (Talenti)":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreIniziativaTalenti(pgBonusCalcolati.getModificatoreIniziativaTalenti() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreIniziativaTalentiDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreIniziativaTalentiDescrizione(
									pgBonusCalcolati.getModificatoreIniziativaTalentiDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreIniziativaTalentiDescrizione(
									pgBonusCalcolati.getModificatoreIniziativaTalentiDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore a Iniziativa (Altro)":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreIniziativaAltro(pgBonusCalcolati.getModificatoreIniziativaAltro() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreIniziativaAltroDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreIniziativaAltroDescrizione(
									pgBonusCalcolati.getModificatoreIniziativaAltroDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreIniziativaAltroDescrizione(
									pgBonusCalcolati.getModificatoreIniziativaAltroDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			case "Modificatore Abilità":
				// Se il bonus è abilitato
				if (arrayPgBonus.get(i).isBonusAbilitato()) {
					// Impostiamo il modificatore
					pgBonusCalcolati.setModificatoreAbilita(pgBonusCalcolati.getModificatoreAbilita() + arrayPgBonus.get(i).getModificatore());
					if (arrayPgBonus.get(i).getModificatore() > 0) {
						modConSegno = "+" + arrayPgBonus.get(i).getModificatore();
					} else {
						modConSegno = "" + arrayPgBonus.get(i).getModificatore();
					}
					// Impostiamo la descrizione
					if (!arrayPgBonus.get(i).getDescrizione().trim().isEmpty()) {
						if (pgBonusCalcolati.getModificatoreAbilitaDescrizione().trim().isEmpty()) {
							pgBonusCalcolati.setModificatoreAbilitaDescrizione(
									pgBonusCalcolati.getModificatoreAbilitaDescrizione()
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						} else {
							pgBonusCalcolati.setModificatoreAbilitaDescrizione(
									pgBonusCalcolati.getModificatoreAbilitaDescrizione() + " + "
											+ arrayPgBonus.get(i).getDescrizione() + " (" + modConSegno + ")");
						}
					}
				}
				break;
			default:
				break;
			}
		}
		return pgBonusCalcolati;
	}

	public static ArrayList<String> getArray() {
		ArrayList<String> arrayBonusLabel = new ArrayList<String>();
		arrayBonusLabel.add("Modificatore Forza");
		arrayBonusLabel.add("Modificatore Destrezza");
		arrayBonusLabel.add("Modificatore Costituzione");
		arrayBonusLabel.add("Modificatore Intelligenza");
		arrayBonusLabel.add("Modificatore Saggezza");
		arrayBonusLabel.add("Modificatore Carisma");
		arrayBonusLabel.add("Modificatore Classe Armatura");
		arrayBonusLabel.add("Modificatore Bab Mischia");
		arrayBonusLabel.add("Modificatore Bab Distanza");
		arrayBonusLabel.add("Modificatore Tiro Salvezza su Tempra");
		arrayBonusLabel.add("Modificatore Tiro Salvezza su Riflessi");
		arrayBonusLabel.add("Modificatore Tiro Salvezza su Volonta");
		arrayBonusLabel.add("Modificatore a tutti i Tiri Salvezza");
		arrayBonusLabel.add("Modificatore a Iniziativa (Talenti)");
		arrayBonusLabel.add("Modificatore a Iniziativa (Altro)");
		arrayBonusLabel.add("Modificatore Abilità");

		return arrayBonusLabel;
	}

}
