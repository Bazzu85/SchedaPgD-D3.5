package comboBox;

import java.util.ArrayList;

import javax.swing.JComboBox;

import json.GestioneJsonItems;
import obj.DbArmaturaScudoObj;

public class PgClasseArmaturaComboBox {

	GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox creaComboBoxArmature() {
		JComboBox comboBoxArmature = new JComboBox();

		// Inseriamo la prima riga vuota
		comboBoxArmature.addItem("");
		comboBoxArmature.setSelectedIndex(0);

		// Recuperiamo la lista delle armi
		ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo = gestioneJsonItems.getListaArmaturaScudo();
		for (int i = 0; i < arrayArmaturaScudo.size(); i++) {
			comboBoxArmature.addItem(arrayArmaturaScudo.get(i).getNome());
		}

		return comboBoxArmature;
	}

}
