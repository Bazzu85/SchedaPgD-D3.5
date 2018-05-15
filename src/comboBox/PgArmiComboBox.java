package comboBox;

import java.util.ArrayList;

import javax.swing.JComboBox;

import json.GestioneJsonItems;
import obj.DbArmiObj;

public class PgArmiComboBox {

	GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox creaComboBoxArmi() {
		JComboBox comboBoxArmi = new JComboBox();

		// Inseriamo la prima riga vuota
		comboBoxArmi.addItem("");
		comboBoxArmi.setSelectedIndex(0);

		// Recuperiamo la lista delle armi
		ArrayList<DbArmiObj> arrayArmi = gestioneJsonItems.getListaArmi();
		for (int i = 0; i < arrayArmi.size(); i++) {
			comboBoxArmi.addItem(arrayArmi.get(i).getNome());
		}

		return comboBoxArmi;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox creaComboBoxTaglia() {
		JComboBox comboBoxTaglia = new JComboBox();

		comboBoxTaglia.addItem("");
		comboBoxTaglia.addItem("P");
		comboBoxTaglia.addItem("M");
		comboBoxTaglia.addItem("G");

		return comboBoxTaglia;
		}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox creaComboBoxQualita() {
		JComboBox comboBoxQualita = new JComboBox();

		comboBoxQualita.addItem("");
		comboBoxQualita.addItem("Normale");
		comboBoxQualita.addItem("Perfetta");

		return comboBoxQualita;
		}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JComboBox creaComboBoxPrimariaSecondaria() {
		JComboBox comboBoxPrimariaSecondaria = new JComboBox();

		comboBoxPrimariaSecondaria.addItem("");
		comboBoxPrimariaSecondaria.addItem("Primaria");
		comboBoxPrimariaSecondaria.addItem("Secondaria");

		return comboBoxPrimariaSecondaria;

	}

}
