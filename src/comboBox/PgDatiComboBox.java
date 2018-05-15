package comboBox;

import java.util.ArrayList;

import javax.swing.JComboBox;

import json.GestioneJsonItems;
import obj.DbArmaturaScudoObj;
import obj.DbTaglieObj;

public class PgDatiComboBox {

	GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox creaComboBoxTaglie() {
		JComboBox comboBoxTaglie = new JComboBox();

		// Inseriamo la prima riga vuota
		comboBoxTaglie.addItem("");
		comboBoxTaglie.setSelectedIndex(0);

		// Recuperiamo la lista delle armi
		ArrayList<DbTaglieObj> arrayTaglie = gestioneJsonItems.getListaTaglie();
		for (int i = 0; i < arrayTaglie.size(); i++) {
			comboBoxTaglie.addItem(arrayTaglie.get(i).getNome());
		}

		return comboBoxTaglie;
	}

}
