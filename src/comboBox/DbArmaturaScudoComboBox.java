package comboBox;

import javax.swing.JComboBox;

public class DbArmaturaScudoComboBox {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox creaComboBoxCategoria() {
		JComboBox comboBoxCaratteristica = new JComboBox();

		// Inseriamo la prima riga vuota
		comboBoxCaratteristica.addItem("");
		comboBoxCaratteristica.setSelectedIndex(0);

		comboBoxCaratteristica.addItem("Leggera");
		comboBoxCaratteristica.addItem("Media");
		comboBoxCaratteristica.addItem("Pesante");
		comboBoxCaratteristica.addItem("Scudo");

		return comboBoxCaratteristica;
	}
}
