package comboBox;

import java.util.Locale;

import javax.swing.JComboBox;

public class LinguaComboBox {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox creaComboBoxLingua() {
		JComboBox comboBoxLingua = new JComboBox();

		// Inseriamo la prima riga vuota
		comboBoxLingua.addItem("");
		comboBoxLingua.setSelectedIndex(0);

		comboBoxLingua.addItem(Locale.ITALIAN);
		comboBoxLingua.addItem(Locale.ENGLISH);

		return comboBoxLingua;
	}
}
