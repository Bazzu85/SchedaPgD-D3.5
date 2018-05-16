package comboBox;

import java.util.ArrayList;

import javax.swing.JComboBox;

import Classi.GestioneBonusCalcolati;

public class PgBonusComboBox {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox creaComboBoxBonus() {
		JComboBox comboBoxBonus = new JComboBox();

		// Inseriamo la prima riga vuota
		comboBoxBonus.addItem("");
		comboBoxBonus.setSelectedIndex(0);

		// Recuperiamo la lista delle armi
		ArrayList<String> arrayBonusLabel = GestioneBonusCalcolati.getArray();
		for (int i=0; i< arrayBonusLabel.size(); i++){
			comboBoxBonus.addItem(arrayBonusLabel.get(i));
		}
		
		return comboBoxBonus;
	}

}
