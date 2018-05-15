package comboBox;

import java.util.ArrayList;

import javax.swing.JComboBox;

import json.GestioneJsonItems;
import obj.DbArmiObj;

public class PgManovreComboBox {
	GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox creaComboBoxTipo() {
		JComboBox comboBoxTipo = new JComboBox();

		// Inseriamo la prima riga vuota
		comboBoxTipo.addItem("");
		comboBoxTipo.addItem("Manovra");
		comboBoxTipo.addItem("Stance");
		comboBoxTipo.setSelectedIndex(0);

		return comboBoxTipo;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox creaComboBoxDisciplina() {
		JComboBox comboBoxDisciplina = new JComboBox();

		comboBoxDisciplina.addItem("");
		comboBoxDisciplina.addItem("Desert Wind");
		comboBoxDisciplina.addItem("Devoted Spirit");
		comboBoxDisciplina.addItem("Diamond Mind");
		comboBoxDisciplina.addItem("Iron Heart");
		comboBoxDisciplina.addItem("Setting Sun");
		comboBoxDisciplina.addItem("Shadow Hand");
		comboBoxDisciplina.addItem("Stone Dragon");
		comboBoxDisciplina.addItem("Tiger Claw");
		comboBoxDisciplina.addItem("White Raven");

		return comboBoxDisciplina;
		}

}
