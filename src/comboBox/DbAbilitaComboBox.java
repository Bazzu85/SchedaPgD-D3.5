package comboBox;

import javax.swing.JComboBox;

public class DbAbilitaComboBox {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JComboBox creaComboBoxCaratteristica() {
		JComboBox comboBoxCaratteristica = new JComboBox();

		// Inseriamo la prima riga vuota
		comboBoxCaratteristica.addItem("");
		comboBoxCaratteristica.setSelectedIndex(0);

		comboBoxCaratteristica.addItem("FOR");
		comboBoxCaratteristica.addItem("DES");
		comboBoxCaratteristica.addItem("COS");
		comboBoxCaratteristica.addItem("INT");
		comboBoxCaratteristica.addItem("SAG");
		comboBoxCaratteristica.addItem("CAR");

		return comboBoxCaratteristica;
	}


}
