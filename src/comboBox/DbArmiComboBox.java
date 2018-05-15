package comboBox;

import javax.swing.JComboBox;

public class DbArmiComboBox {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox creaComboBoxCategoria1() {
		JComboBox comboBoxCaratteristica1 = new JComboBox();

		// Inseriamo la prima riga vuota
		comboBoxCaratteristica1.addItem("");
		comboBoxCaratteristica1.setSelectedIndex(0);

		comboBoxCaratteristica1.addItem("Arma Semplice");
		comboBoxCaratteristica1.addItem("Arma da Guerra");
		comboBoxCaratteristica1.addItem("Arma Esotica");

		return comboBoxCaratteristica1;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox creaComboBoxCategoria2() {
		JComboBox comboBoxCaratteristica2 = new JComboBox();

		// Inseriamo la prima riga vuota
		comboBoxCaratteristica2.addItem("");
		comboBoxCaratteristica2.setSelectedIndex(0);

		comboBoxCaratteristica2.addItem("Senz'armi");
		comboBoxCaratteristica2.addItem("Leggera");
		comboBoxCaratteristica2.addItem("A una Mano");
		comboBoxCaratteristica2.addItem("A due Mani");
		comboBoxCaratteristica2.addItem("A distanza");

		return comboBoxCaratteristica2;
	}
}
