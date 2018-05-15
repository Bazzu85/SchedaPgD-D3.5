package gui.panel;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaPgStatistiche;
import gui.MainWindow;
import obj.OpzioniObj;
import obj.PgDatiObj;

public class PgStatistichePanel extends JPanel implements FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6978324125629560496L;
	Formati formati = new Formati();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();

	private JFormattedTextField formattedTextFieldForza;
	private JFormattedTextField formattedTextFieldForzaMod;
	private JFormattedTextField formattedTextFieldForzaTemp;
	private JFormattedTextField formattedTextFieldForzaTempMod;
	private JFormattedTextField formattedTextFieldForzaModCondizione;
	private JFormattedTextField formattedTextFieldDestrezza;
	private JFormattedTextField formattedTextFieldDestrezzaMod;
	private JFormattedTextField formattedTextFieldDestrezzaTemp;
	private JFormattedTextField formattedTextFieldDestrezzaTempMod;
	private JFormattedTextField formattedTextFieldDestrezzaModCondizione;
	private JFormattedTextField formattedTextFieldCostituzione;
	private JFormattedTextField formattedTextFieldCostituzioneMod;
	private JFormattedTextField formattedTextFieldCostituzioneTemp;
	private JFormattedTextField formattedTextFieldCostituzioneTempMod;
	private JFormattedTextField formattedTextFieldCostituzioneModCondizione;
	private JFormattedTextField formattedTextFieldIntelligenza;
	private JFormattedTextField formattedTextFieldIntelligenzaMod;
	private JFormattedTextField formattedTextFieldIntelligenzaTemp;
	private JFormattedTextField formattedTextFieldIntelligenzaTempMod;
	private JFormattedTextField formattedTextFieldIntelligenzaModCondizione;
	private JFormattedTextField formattedTextFieldSaggezza;
	private JFormattedTextField formattedTextFieldSaggezzaMod;
	private JFormattedTextField formattedTextFieldSaggezzaTemp;
	private JFormattedTextField formattedTextFieldSaggezzaTempMod;
	private JFormattedTextField formattedTextFieldSaggezzaModCondizione;
	private JFormattedTextField formattedTextFieldCarisma;
	private JFormattedTextField formattedTextFieldCarismaMod;
	private JFormattedTextField formattedTextFieldCarismaTemp;
	private JFormattedTextField formattedTextFieldCarismaTempMod;
	private JFormattedTextField formattedTextFieldCarismaModCondizione;
	private JTextField textFieldSaggezzaModCondizioneNota;
	private JTextField textFieldCarismaModCondizioneNota;
	private JTextField textFieldIntelligenzaModCondizioneNota;
	private JTextField textFieldCostituzioneModCondizioneNota;
	private JTextField textFieldDestrezzaModCondizioneNota;
	private JTextField textFieldForzaModCondizioneNota;
	private PgDatiObj pgDatiObj;
	OpzioniObj opzioniObj;
	private MainWindow frame;

	public PgStatistichePanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.pgDatiObj = pgDatiObj;

		NumberFormatter soloNumeri = formati.getSoloNumeri();
		NumberFormatter soloNumeriConSegno = formati.getSoloNumeriConSegno();

		GridBagLayout gbl_panelStatistiche = new GridBagLayout();
		gbl_panelStatistiche.columnWidths = new int[] { 30, 70, 70, 70, 70, 70, 30, 0 };
		gbl_panelStatistiche.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 30, 30, 0 };
		gbl_panelStatistiche.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelStatistiche.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.setLayout(gbl_panelStatistiche);

		JLabel lblNewLabel_2 = new JLabel("VALORE");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblModificatore = new JLabel("MOD.");
		GridBagConstraints gbc_lblModificatore = new GridBagConstraints();
		gbc_lblModificatore.insets = new Insets(0, 0, 5, 5);
		gbc_lblModificatore.gridx = 2;
		gbc_lblModificatore.gridy = 0;
		this.add(lblModificatore, gbc_lblModificatore);

		JLabel lblValoreTemp = new JLabel("<html>VALORE<br>TEMP.</html>");
		GridBagConstraints gbc_lblValoreTemp = new GridBagConstraints();
		gbc_lblValoreTemp.insets = new Insets(0, 0, 5, 5);
		gbc_lblValoreTemp.gridx = 3;
		gbc_lblValoreTemp.gridy = 0;
		this.add(lblValoreTemp, gbc_lblValoreTemp);

		JLabel lblModTemp = new JLabel("<html>MOD. <br>TEMP.</html>");
		GridBagConstraints gbc_lblModTemp = new GridBagConstraints();
		gbc_lblModTemp.insets = new Insets(0, 0, 5, 5);
		gbc_lblModTemp.gridx = 4;
		gbc_lblModTemp.gridy = 0;
		this.add(lblModTemp, gbc_lblModTemp);

		JLabel lblModificatorIDiCondizione = new JLabel("MODIFICATORI DI CONDIZIONE");
		GridBagConstraints gbc_lblModificatorIDiCondizione = new GridBagConstraints();
		gbc_lblModificatorIDiCondizione.anchor = GridBagConstraints.WEST;
		gbc_lblModificatorIDiCondizione.gridwidth = 2;
		gbc_lblModificatorIDiCondizione.insets = new Insets(0, 0, 5, 5);
		gbc_lblModificatorIDiCondizione.gridx = 5;
		gbc_lblModificatorIDiCondizione.gridy = 0;
		this.add(lblModificatorIDiCondizione, gbc_lblModificatorIDiCondizione);

		JLabel lblFor = new JLabel("FOR");
		lblFor.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblFor = new GridBagConstraints();
		gbc_lblFor.insets = new Insets(0, 0, 5, 5);
		gbc_lblFor.gridx = 0;
		gbc_lblFor.gridy = 1;
		this.add(lblFor, gbc_lblFor);

		formattedTextFieldForza = new JFormattedTextField(soloNumeri);
		formattedTextFieldForza.addFocusListener(this);
		GridBagConstraints gbc_TextFieldForza = new GridBagConstraints();
		gbc_TextFieldForza.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldForza.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldForza.gridx = 1;
		gbc_TextFieldForza.gridy = 1;
		this.add(formattedTextFieldForza, gbc_TextFieldForza);

		formattedTextFieldForzaMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldForzaMod.setEditable(false);
		formattedTextFieldForzaMod.setEnabled(false);
		GridBagConstraints gbc_TextFieldForzaMod = new GridBagConstraints();
		gbc_TextFieldForzaMod.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldForzaMod.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldForzaMod.gridx = 2;
		gbc_TextFieldForzaMod.gridy = 1;
		this.add(formattedTextFieldForzaMod, gbc_TextFieldForzaMod);

		formattedTextFieldForzaTemp = new JFormattedTextField(soloNumeri);
		formattedTextFieldForzaTemp.setEditable(false);
		formattedTextFieldForzaTemp.setEnabled(false);
		formattedTextFieldForzaTemp.addFocusListener(this);
		GridBagConstraints gbc_TextFieldForzaTemp = new GridBagConstraints();
		gbc_TextFieldForzaTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldForzaTemp.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldForzaTemp.gridx = 3;
		gbc_TextFieldForzaTemp.gridy = 1;
		this.add(formattedTextFieldForzaTemp, gbc_TextFieldForzaTemp);

		formattedTextFieldForzaTempMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldForzaTempMod.setEnabled(false);
		formattedTextFieldForzaTempMod.setEditable(false);
		GridBagConstraints gbc_TextFieldForzaModTemp = new GridBagConstraints();
		gbc_TextFieldForzaModTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldForzaModTemp.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldForzaModTemp.gridx = 4;
		gbc_TextFieldForzaModTemp.gridy = 1;
		this.add(formattedTextFieldForzaTempMod, gbc_TextFieldForzaModTemp);

		formattedTextFieldForzaModCondizione = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldForzaModCondizione.setEnabled(false);
		formattedTextFieldForzaModCondizione.setEditable(false);
		formattedTextFieldForzaModCondizione.addFocusListener(this);
		GridBagConstraints gbc_textFieldForzaModCondizione = new GridBagConstraints();
		gbc_textFieldForzaModCondizione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldForzaModCondizione.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldForzaModCondizione.gridx = 5;
		gbc_textFieldForzaModCondizione.gridy = 1;
		this.add(formattedTextFieldForzaModCondizione, gbc_textFieldForzaModCondizione);
		formattedTextFieldForzaModCondizione.setColumns(10);

		textFieldForzaModCondizioneNota = new JTextField();
		textFieldForzaModCondizioneNota.setEnabled(false);
		textFieldForzaModCondizioneNota.setEditable(false);
		textFieldForzaModCondizioneNota.addFocusListener(this);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 6;
		gbc_textField_5.gridy = 1;
		this.add(textFieldForzaModCondizioneNota, gbc_textField_5);
		textFieldForzaModCondizioneNota.setColumns(10);

		JLabel lblDes = new JLabel("DES");
		lblDes.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblDes = new GridBagConstraints();
		gbc_lblDes.insets = new Insets(0, 0, 5, 5);
		gbc_lblDes.gridx = 0;
		gbc_lblDes.gridy = 2;
		this.add(lblDes, gbc_lblDes);

		formattedTextFieldDestrezza = new JFormattedTextField(soloNumeri);
		formattedTextFieldDestrezza.addFocusListener(this);
		GridBagConstraints gbc_textFieldDestrezza = new GridBagConstraints();
		gbc_textFieldDestrezza.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDestrezza.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDestrezza.gridx = 1;
		gbc_textFieldDestrezza.gridy = 2;
		this.add(formattedTextFieldDestrezza, gbc_textFieldDestrezza);

		formattedTextFieldDestrezzaMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldDestrezzaMod.setEnabled(false);
		formattedTextFieldDestrezzaMod.setEditable(false);
		GridBagConstraints gbc_TextFieldDestrezzaMod = new GridBagConstraints();
		gbc_TextFieldDestrezzaMod.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldDestrezzaMod.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldDestrezzaMod.gridx = 2;
		gbc_TextFieldDestrezzaMod.gridy = 2;
		this.add(formattedTextFieldDestrezzaMod, gbc_TextFieldDestrezzaMod);

		formattedTextFieldDestrezzaTemp = new JFormattedTextField(soloNumeri);
		formattedTextFieldDestrezzaTemp.setEditable(false);
		formattedTextFieldDestrezzaTemp.setEnabled(false);
		formattedTextFieldDestrezzaTemp.addFocusListener(this);
		GridBagConstraints gbc_TextFieldDestrezzaTemp = new GridBagConstraints();
		gbc_TextFieldDestrezzaTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldDestrezzaTemp.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldDestrezzaTemp.gridx = 3;
		gbc_TextFieldDestrezzaTemp.gridy = 2;
		this.add(formattedTextFieldDestrezzaTemp, gbc_TextFieldDestrezzaTemp);

		formattedTextFieldDestrezzaTempMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldDestrezzaTempMod.setEnabled(false);
		formattedTextFieldDestrezzaTempMod.setEditable(false);
		GridBagConstraints gbc_TextFieldDestrezzaTempMod = new GridBagConstraints();
		gbc_TextFieldDestrezzaTempMod.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldDestrezzaTempMod.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldDestrezzaTempMod.gridx = 4;
		gbc_TextFieldDestrezzaTempMod.gridy = 2;
		this.add(formattedTextFieldDestrezzaTempMod, gbc_TextFieldDestrezzaTempMod);

		formattedTextFieldDestrezzaModCondizione = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldDestrezzaModCondizione.setEnabled(false);
		formattedTextFieldDestrezzaModCondizione.setEditable(false);
		formattedTextFieldDestrezzaModCondizione.addFocusListener(this);
		formattedTextFieldDestrezzaModCondizione.setColumns(10);
		GridBagConstraints gbc_textFieldDestrezzaModCondizione = new GridBagConstraints();
		gbc_textFieldDestrezzaModCondizione.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDestrezzaModCondizione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDestrezzaModCondizione.gridx = 5;
		gbc_textFieldDestrezzaModCondizione.gridy = 2;
		this.add(formattedTextFieldDestrezzaModCondizione, gbc_textFieldDestrezzaModCondizione);

		textFieldDestrezzaModCondizioneNota = new JTextField();
		textFieldDestrezzaModCondizioneNota.setEnabled(false);
		textFieldDestrezzaModCondizioneNota.setEditable(false);
		textFieldDestrezzaModCondizioneNota.addFocusListener(this);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 6;
		gbc_textField_4.gridy = 2;
		this.add(textFieldDestrezzaModCondizioneNota, gbc_textField_4);
		textFieldDestrezzaModCondizioneNota.setColumns(10);

		JLabel lblCos = new JLabel("COS");
		lblCos.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblCos = new GridBagConstraints();
		gbc_lblCos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCos.gridx = 0;
		gbc_lblCos.gridy = 3;
		this.add(lblCos, gbc_lblCos);

		formattedTextFieldCostituzione = new JFormattedTextField(soloNumeri);
		formattedTextFieldCostituzione.addFocusListener(this);
		GridBagConstraints gbc_TextFieldCostituzione = new GridBagConstraints();
		gbc_TextFieldCostituzione.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldCostituzione.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldCostituzione.gridx = 1;
		gbc_TextFieldCostituzione.gridy = 3;
		this.add(formattedTextFieldCostituzione, gbc_TextFieldCostituzione);

		formattedTextFieldCostituzioneMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldCostituzioneMod.setEnabled(false);
		formattedTextFieldCostituzioneMod.setEditable(false);
		GridBagConstraints gbc_TextFieldCostituzioneMod = new GridBagConstraints();
		gbc_TextFieldCostituzioneMod.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldCostituzioneMod.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldCostituzioneMod.gridx = 2;
		gbc_TextFieldCostituzioneMod.gridy = 3;
		this.add(formattedTextFieldCostituzioneMod, gbc_TextFieldCostituzioneMod);

		formattedTextFieldCostituzioneTemp = new JFormattedTextField(soloNumeri);
		formattedTextFieldCostituzioneTemp.setEditable(false);
		formattedTextFieldCostituzioneTemp.setEnabled(false);
		formattedTextFieldCostituzioneTemp.addFocusListener(this);
		GridBagConstraints gbc_TextFieldCostituzioneTemp = new GridBagConstraints();
		gbc_TextFieldCostituzioneTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldCostituzioneTemp.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldCostituzioneTemp.gridx = 3;
		gbc_TextFieldCostituzioneTemp.gridy = 3;
		this.add(formattedTextFieldCostituzioneTemp, gbc_TextFieldCostituzioneTemp);

		formattedTextFieldCostituzioneTempMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldCostituzioneTempMod.setEnabled(false);
		formattedTextFieldCostituzioneTempMod.setEditable(false);
		GridBagConstraints gbc_TextFieldCostituzioneModTemp = new GridBagConstraints();
		gbc_TextFieldCostituzioneModTemp.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldCostituzioneModTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldCostituzioneModTemp.gridx = 4;
		gbc_TextFieldCostituzioneModTemp.gridy = 3;
		this.add(formattedTextFieldCostituzioneTempMod, gbc_TextFieldCostituzioneModTemp);

		formattedTextFieldCostituzioneModCondizione = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldCostituzioneModCondizione.setEnabled(false);
		formattedTextFieldCostituzioneModCondizione.setEditable(false);
		formattedTextFieldCostituzioneModCondizione.addFocusListener(this);
		formattedTextFieldCostituzioneModCondizione.setColumns(10);
		GridBagConstraints gbc_textFieldCostituzioneModCondizione = new GridBagConstraints();
		gbc_textFieldCostituzioneModCondizione.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCostituzioneModCondizione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCostituzioneModCondizione.gridx = 5;
		gbc_textFieldCostituzioneModCondizione.gridy = 3;
		this.add(formattedTextFieldCostituzioneModCondizione, gbc_textFieldCostituzioneModCondizione);

		textFieldCostituzioneModCondizioneNota = new JTextField();
		textFieldCostituzioneModCondizioneNota.setEnabled(false);
		textFieldCostituzioneModCondizioneNota.setEditable(false);
		textFieldCostituzioneModCondizioneNota.addFocusListener(this);
		GridBagConstraints gbc_textFieldCostituzioneModCondizioneNota = new GridBagConstraints();
		gbc_textFieldCostituzioneModCondizioneNota.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCostituzioneModCondizioneNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCostituzioneModCondizioneNota.gridx = 6;
		gbc_textFieldCostituzioneModCondizioneNota.gridy = 3;
		this.add(textFieldCostituzioneModCondizioneNota, gbc_textFieldCostituzioneModCondizioneNota);
		textFieldCostituzioneModCondizioneNota.setColumns(10);

		JLabel lblInt = new JLabel("INT");
		lblInt.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblInt = new GridBagConstraints();
		gbc_lblInt.insets = new Insets(0, 0, 5, 5);
		gbc_lblInt.gridx = 0;
		gbc_lblInt.gridy = 4;
		this.add(lblInt, gbc_lblInt);

		formattedTextFieldIntelligenza = new JFormattedTextField(soloNumeri);
		formattedTextFieldIntelligenza.addFocusListener(this);
		GridBagConstraints gbc_TextFieldIntelligenza = new GridBagConstraints();
		gbc_TextFieldIntelligenza.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldIntelligenza.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldIntelligenza.gridx = 1;
		gbc_TextFieldIntelligenza.gridy = 4;
		this.add(formattedTextFieldIntelligenza, gbc_TextFieldIntelligenza);

		formattedTextFieldIntelligenzaMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldIntelligenzaMod.setEnabled(false);
		formattedTextFieldIntelligenzaMod.setEditable(false);
		GridBagConstraints gbc_TextFieldIntelligenzaMod = new GridBagConstraints();
		gbc_TextFieldIntelligenzaMod.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldIntelligenzaMod.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldIntelligenzaMod.gridx = 2;
		gbc_TextFieldIntelligenzaMod.gridy = 4;
		this.add(formattedTextFieldIntelligenzaMod, gbc_TextFieldIntelligenzaMod);

		formattedTextFieldIntelligenzaTemp = new JFormattedTextField(soloNumeri);
		formattedTextFieldIntelligenzaTemp.setEditable(false);
		formattedTextFieldIntelligenzaTemp.setEnabled(false);
		formattedTextFieldIntelligenzaTemp.addFocusListener(this);
		GridBagConstraints gbc_TextFieldIntelligenzaTemp = new GridBagConstraints();
		gbc_TextFieldIntelligenzaTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldIntelligenzaTemp.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldIntelligenzaTemp.gridx = 3;
		gbc_TextFieldIntelligenzaTemp.gridy = 4;
		this.add(formattedTextFieldIntelligenzaTemp, gbc_TextFieldIntelligenzaTemp);

		formattedTextFieldIntelligenzaTempMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldIntelligenzaTempMod.setEnabled(false);
		formattedTextFieldIntelligenzaTempMod.setEditable(false);
		GridBagConstraints gbc_TextFieldIntelligenzaModTemp = new GridBagConstraints();
		gbc_TextFieldIntelligenzaModTemp.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldIntelligenzaModTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldIntelligenzaModTemp.gridx = 4;
		gbc_TextFieldIntelligenzaModTemp.gridy = 4;
		this.add(formattedTextFieldIntelligenzaTempMod, gbc_TextFieldIntelligenzaModTemp);

		formattedTextFieldIntelligenzaModCondizione = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldIntelligenzaModCondizione.setEnabled(false);
		formattedTextFieldIntelligenzaModCondizione.setEditable(false);
		formattedTextFieldIntelligenzaModCondizione.addFocusListener(this);
		formattedTextFieldIntelligenzaModCondizione.setColumns(10);
		GridBagConstraints gbc_textFieldIntelligenzaModCondizione = new GridBagConstraints();
		gbc_textFieldIntelligenzaModCondizione.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIntelligenzaModCondizione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIntelligenzaModCondizione.gridx = 5;
		gbc_textFieldIntelligenzaModCondizione.gridy = 4;
		this.add(formattedTextFieldIntelligenzaModCondizione, gbc_textFieldIntelligenzaModCondizione);

		textFieldIntelligenzaModCondizioneNota = new JTextField();
		textFieldIntelligenzaModCondizioneNota.setEnabled(false);
		textFieldIntelligenzaModCondizioneNota.setEditable(false);
		textFieldIntelligenzaModCondizioneNota.addFocusListener(this);
		GridBagConstraints gbc_textFieldIntelligenzaModCondizioneNota = new GridBagConstraints();
		gbc_textFieldIntelligenzaModCondizioneNota.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldIntelligenzaModCondizioneNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIntelligenzaModCondizioneNota.gridx = 6;
		gbc_textFieldIntelligenzaModCondizioneNota.gridy = 4;
		this.add(textFieldIntelligenzaModCondizioneNota, gbc_textFieldIntelligenzaModCondizioneNota);
		textFieldIntelligenzaModCondizioneNota.setColumns(10);

		JLabel lblSag = new JLabel("SAG");
		lblSag.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblSag = new GridBagConstraints();
		gbc_lblSag.insets = new Insets(0, 0, 5, 5);
		gbc_lblSag.gridx = 0;
		gbc_lblSag.gridy = 5;
		this.add(lblSag, gbc_lblSag);

		formattedTextFieldSaggezza = new JFormattedTextField(soloNumeri);
		formattedTextFieldSaggezza.addFocusListener(this);
		GridBagConstraints gbc_TextFieldSaggezza = new GridBagConstraints();
		gbc_TextFieldSaggezza.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldSaggezza.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldSaggezza.gridx = 1;
		gbc_TextFieldSaggezza.gridy = 5;
		this.add(formattedTextFieldSaggezza, gbc_TextFieldSaggezza);

		formattedTextFieldSaggezzaMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldSaggezzaMod.setEnabled(false);
		formattedTextFieldSaggezzaMod.setEditable(false);
		GridBagConstraints gbc_TextFieldSaggezzaMod = new GridBagConstraints();
		gbc_TextFieldSaggezzaMod.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldSaggezzaMod.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldSaggezzaMod.gridx = 2;
		gbc_TextFieldSaggezzaMod.gridy = 5;
		this.add(formattedTextFieldSaggezzaMod, gbc_TextFieldSaggezzaMod);

		formattedTextFieldSaggezzaTemp = new JFormattedTextField(soloNumeri);
		formattedTextFieldSaggezzaTemp.setEditable(false);
		formattedTextFieldSaggezzaTemp.setEnabled(false);
		formattedTextFieldSaggezzaTemp.addFocusListener(this);
		GridBagConstraints gbc_TextFieldSaggezzaTemp = new GridBagConstraints();
		gbc_TextFieldSaggezzaTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldSaggezzaTemp.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldSaggezzaTemp.gridx = 3;
		gbc_TextFieldSaggezzaTemp.gridy = 5;
		this.add(formattedTextFieldSaggezzaTemp, gbc_TextFieldSaggezzaTemp);

		formattedTextFieldSaggezzaTempMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldSaggezzaTempMod.setEnabled(false);
		formattedTextFieldSaggezzaTempMod.setEditable(false);
		GridBagConstraints gbc_TextFieldSaggezzaModTemp = new GridBagConstraints();
		gbc_TextFieldSaggezzaModTemp.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldSaggezzaModTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldSaggezzaModTemp.gridx = 4;
		gbc_TextFieldSaggezzaModTemp.gridy = 5;
		this.add(formattedTextFieldSaggezzaTempMod, gbc_TextFieldSaggezzaModTemp);

		formattedTextFieldSaggezzaModCondizione = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldSaggezzaModCondizione.setEnabled(false);
		formattedTextFieldSaggezzaModCondizione.setEditable(false);
		formattedTextFieldSaggezzaModCondizione.addFocusListener(this);
		formattedTextFieldSaggezzaModCondizione.setColumns(10);
		GridBagConstraints gbc_textFieldSaggezzaModCondizione = new GridBagConstraints();
		gbc_textFieldSaggezzaModCondizione.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSaggezzaModCondizione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSaggezzaModCondizione.gridx = 5;
		gbc_textFieldSaggezzaModCondizione.gridy = 5;
		this.add(formattedTextFieldSaggezzaModCondizione, gbc_textFieldSaggezzaModCondizione);

		textFieldSaggezzaModCondizioneNota = new JTextField();
		textFieldSaggezzaModCondizioneNota.setEnabled(false);
		textFieldSaggezzaModCondizioneNota.setEditable(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 6;
		gbc_textField_2.gridy = 5;
		this.add(textFieldSaggezzaModCondizioneNota, gbc_textField_2);
		textFieldSaggezzaModCondizioneNota.setColumns(10);

		JLabel lblCar = new JLabel("CAR");
		lblCar.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblCar = new GridBagConstraints();
		gbc_lblCar.insets = new Insets(0, 0, 5, 5);
		gbc_lblCar.gridx = 0;
		gbc_lblCar.gridy = 6;
		this.add(lblCar, gbc_lblCar);

		formattedTextFieldCarisma = new JFormattedTextField(soloNumeri);
		formattedTextFieldCarisma.addFocusListener(this);
		GridBagConstraints gbc_TextFieldCarisma = new GridBagConstraints();
		gbc_TextFieldCarisma.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldCarisma.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldCarisma.gridx = 1;
		gbc_TextFieldCarisma.gridy = 6;
		this.add(formattedTextFieldCarisma, gbc_TextFieldCarisma);

		formattedTextFieldCarismaMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldCarismaMod.setEnabled(false);
		formattedTextFieldCarismaMod.setEditable(false);
		GridBagConstraints gbc_TextFieldCarismaMod = new GridBagConstraints();
		gbc_TextFieldCarismaMod.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldCarismaMod.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldCarismaMod.gridx = 2;
		gbc_TextFieldCarismaMod.gridy = 6;
		this.add(formattedTextFieldCarismaMod, gbc_TextFieldCarismaMod);

		formattedTextFieldCarismaTemp = new JFormattedTextField(soloNumeri);
		formattedTextFieldCarismaTemp.setEditable(false);
		formattedTextFieldCarismaTemp.setEnabled(false);
		formattedTextFieldCarismaTemp.addFocusListener(this);
		GridBagConstraints gbc_TextFieldCarismaTemp = new GridBagConstraints();
		gbc_TextFieldCarismaTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldCarismaTemp.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldCarismaTemp.gridx = 3;
		gbc_TextFieldCarismaTemp.gridy = 6;
		this.add(formattedTextFieldCarismaTemp, gbc_TextFieldCarismaTemp);

		formattedTextFieldCarismaTempMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldCarismaTempMod.setEnabled(false);
		formattedTextFieldCarismaTempMod.setEditable(false);
		GridBagConstraints gbc_TextFieldCarismaModTemp = new GridBagConstraints();
		gbc_TextFieldCarismaModTemp.insets = new Insets(0, 0, 5, 5);
		gbc_TextFieldCarismaModTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextFieldCarismaModTemp.gridx = 4;
		gbc_TextFieldCarismaModTemp.gridy = 6;
		this.add(formattedTextFieldCarismaTempMod, gbc_TextFieldCarismaModTemp);

		formattedTextFieldCarismaModCondizione = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldCarismaModCondizione.setEnabled(false);
		formattedTextFieldCarismaModCondizione.setEditable(false);
		formattedTextFieldCarismaModCondizione.addFocusListener(this);
		formattedTextFieldCarismaModCondizione.setColumns(10);
		GridBagConstraints gbc_textFieldCarismaModCondizione = new GridBagConstraints();
		gbc_textFieldCarismaModCondizione.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCarismaModCondizione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCarismaModCondizione.gridx = 5;
		gbc_textFieldCarismaModCondizione.gridy = 6;
		this.add(formattedTextFieldCarismaModCondizione, gbc_textFieldCarismaModCondizione);

		textFieldCarismaModCondizioneNota = new JTextField();
		textFieldCarismaModCondizioneNota.setEnabled(false);
		textFieldCarismaModCondizioneNota.setEditable(false);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 6;
		gbc_textField_3.gridy = 6;
		this.add(textFieldCarismaModCondizioneNota, gbc_textField_3);
		textFieldCarismaModCondizioneNota.setColumns(10);
	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {
		
		//Salvataggio dell'oggetto nella classe per giri successivi (chiamati da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		
		// TODO Popolamento scheda "Statistiche"
		if (pgDatiObj.getPgStatisticheObj().getForza() > 0) {
			formattedTextFieldForza.setValue(pgDatiObj.getPgStatisticheObj().getForza());
		} else {
			formattedTextFieldForza.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getForzaMod() > 0) {
			formattedTextFieldForzaMod.setValue(pgDatiObj.getPgStatisticheObj().getForzaMod());
		} else {
			formattedTextFieldForzaMod.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getForzaTemp() > 0) {
			formattedTextFieldForzaTemp.setValue(pgDatiObj.getPgStatisticheObj().getForzaTemp());
		} else {
			formattedTextFieldForzaTemp.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getForzaTempMod() > 0) {
			formattedTextFieldForzaTempMod.setValue(pgDatiObj.getPgStatisticheObj().getForzaTempMod());
		} else {
			formattedTextFieldForzaTempMod.setValue(0);
		}
		formattedTextFieldForzaModCondizione.setValue(pgDatiObj.getPgStatisticheObj().getForzaModCondizione());
		textFieldForzaModCondizioneNota.setText(pgDatiObj.getPgStatisticheObj().getForzaModCondizioneNota());
		if (pgDatiObj.getPgStatisticheObj().getDestrezza() > 0) {
			formattedTextFieldDestrezza.setValue(pgDatiObj.getPgStatisticheObj().getDestrezza());
		} else {
			formattedTextFieldDestrezza.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getDestrezzaMod() > 0) {
			formattedTextFieldDestrezzaMod.setValue(pgDatiObj.getPgStatisticheObj().getDestrezzaMod());
		} else {
			formattedTextFieldDestrezzaMod.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getDestrezzaTemp() > 0) {
			formattedTextFieldDestrezzaTemp.setValue(pgDatiObj.getPgStatisticheObj().getDestrezzaTemp());
		} else {
			formattedTextFieldDestrezzaTemp.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getDestrezzaTempMod() > 0) {
			formattedTextFieldDestrezzaTempMod.setValue(pgDatiObj.getPgStatisticheObj().getDestrezzaTempMod());
		} else {
			formattedTextFieldDestrezzaTempMod.setValue(0);
		}
		formattedTextFieldDestrezzaModCondizione.setValue(pgDatiObj.getPgStatisticheObj().getDestrezzaModCondizione());
		textFieldDestrezzaModCondizioneNota.setText(pgDatiObj.getPgStatisticheObj().getDestrezzaModCondizioneNota());
		if (pgDatiObj.getPgStatisticheObj().getCostituzione() > 0) {
			formattedTextFieldCostituzione.setValue(pgDatiObj.getPgStatisticheObj().getCostituzione());
		} else {
			formattedTextFieldCostituzione.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getCostituzioneMod() > 0) {
			formattedTextFieldCostituzioneMod.setValue(pgDatiObj.getPgStatisticheObj().getCostituzioneMod());
		} else {
			formattedTextFieldCostituzioneMod.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getCostituzioneTemp() > 0) {
			formattedTextFieldCostituzioneTemp.setValue(pgDatiObj.getPgStatisticheObj().getCostituzioneTemp());
		} else {
			formattedTextFieldCostituzioneTemp.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getCostituzioneTempMod() > 0) {
			formattedTextFieldCostituzioneTempMod.setValue(pgDatiObj.getPgStatisticheObj().getCostituzioneTempMod());
		} else {
			formattedTextFieldCostituzioneTempMod.setValue(0);
		}
		formattedTextFieldCostituzioneModCondizione
				.setValue(pgDatiObj.getPgStatisticheObj().getCostituzioneModCondizione());
		textFieldCostituzioneModCondizioneNota
				.setText(pgDatiObj.getPgStatisticheObj().getCostituzioneModCondizioneNota());

		if (pgDatiObj.getPgStatisticheObj().getIntelligenza() > 0) {
			formattedTextFieldIntelligenza.setValue(pgDatiObj.getPgStatisticheObj().getIntelligenza());
		} else {
			formattedTextFieldIntelligenza.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getIntelligenzaMod() > 0) {
			formattedTextFieldIntelligenzaMod.setValue(pgDatiObj.getPgStatisticheObj().getIntelligenzaMod());
		} else {
			formattedTextFieldIntelligenzaMod.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getIntelligenzaTemp() > 0) {
			formattedTextFieldIntelligenzaTemp.setValue(pgDatiObj.getPgStatisticheObj().getIntelligenzaTemp());
		} else {
			formattedTextFieldIntelligenzaTemp.setValue(0);
		}
		formattedTextFieldIntelligenzaTempMod.setValue(pgDatiObj.getPgStatisticheObj().getIntelligenzaTempMod());
		textFieldIntelligenzaModCondizioneNota
				.setText(pgDatiObj.getPgStatisticheObj().getIntelligenzaModCondizioneNota());

		if (pgDatiObj.getPgStatisticheObj().getIntelligenzaModCondizione() > 0) {
			formattedTextFieldIntelligenzaModCondizione
					.setValue(pgDatiObj.getPgStatisticheObj().getIntelligenzaModCondizione());
		} else {
			formattedTextFieldIntelligenzaModCondizione.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getSaggezza() > 0) {
			formattedTextFieldSaggezza.setValue(pgDatiObj.getPgStatisticheObj().getSaggezza());
		} else {
			formattedTextFieldSaggezza.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getSaggezzaMod() > 0) {
			formattedTextFieldSaggezzaMod.setValue(pgDatiObj.getPgStatisticheObj().getSaggezzaMod());
		} else {
			formattedTextFieldSaggezzaMod.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getSaggezzaTemp() > 0) {
			formattedTextFieldSaggezzaTemp.setValue(pgDatiObj.getPgStatisticheObj().getSaggezzaTemp());
		} else {
			formattedTextFieldSaggezzaTemp.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getSaggezzaTempMod() > 0) {
			formattedTextFieldSaggezzaTempMod.setValue(pgDatiObj.getPgStatisticheObj().getSaggezzaTempMod());
		} else {
			formattedTextFieldSaggezzaTempMod.setValue(0);
		}
		formattedTextFieldSaggezzaModCondizione.setValue(pgDatiObj.getPgStatisticheObj().getSaggezzaModCondizione());
		textFieldSaggezzaModCondizioneNota.setText(pgDatiObj.getPgStatisticheObj().getSaggezzaModCondizioneNota());

		if (pgDatiObj.getPgStatisticheObj().getCarisma() > 0) {
			formattedTextFieldCarisma.setValue(pgDatiObj.getPgStatisticheObj().getCarisma());
		} else {
			formattedTextFieldCarisma.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getCarismaMod() > 0) {
			formattedTextFieldCarismaMod.setValue(pgDatiObj.getPgStatisticheObj().getCarismaMod());
		} else {
			formattedTextFieldCarismaMod.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getCarismaTemp() > 0) {
			formattedTextFieldCarismaTemp.setValue(pgDatiObj.getPgStatisticheObj().getCarismaTemp());
		} else {
			formattedTextFieldCarismaTemp.setValue(0);
		}
		if (pgDatiObj.getPgStatisticheObj().getCarismaTempMod() > 0) {
			formattedTextFieldCarismaTempMod.setValue(pgDatiObj.getPgStatisticheObj().getCarismaTempMod());
		} else {
			formattedTextFieldCarismaTempMod.setValue(0);
		}
		formattedTextFieldCarismaModCondizione.setValue(pgDatiObj.getPgStatisticheObj().getCarismaModCondizione());
		textFieldCarismaModCondizioneNota.setText(pgDatiObj.getPgStatisticheObj().getCarismaModCondizioneNota());
		

	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();

		if (component instanceof JTextField) {
			if ((JTextField) component == textFieldForzaModCondizioneNota) {
				pgDatiObj = aggiornaOggetti.aggiornaStatistiche(pgDatiObj, ListaPgStatistiche.FORZA_MOD_CONDIZIONE_NOTA,
						textFieldForzaModCondizioneNota.getText());
			}
			if ((JTextField) component == textFieldDestrezzaModCondizioneNota) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj,
						ListaPgStatistiche.DESTREZZA_MOD_CONDIZIONE_NOTA,
						textFieldDestrezzaModCondizioneNota.getText()));
			}
			if ((JTextField) component == textFieldCostituzioneModCondizioneNota) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj,
						ListaPgStatistiche.COSTITUZIONE_MOD_CONDIZIONE_NOTA,
						textFieldCostituzioneModCondizioneNota.getText()));
			}
			if ((JTextField) component == textFieldIntelligenzaModCondizioneNota) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj,
						ListaPgStatistiche.INTELLIGENZA_MOD_CONDIZIONE_NOTA,
						textFieldIntelligenzaModCondizioneNota.getText()));
			}
			if ((JTextField) component == textFieldSaggezzaModCondizioneNota) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj,
						ListaPgStatistiche.SAGGEZZA_MOD_CONDIZIONE_NOTA, textFieldSaggezzaModCondizioneNota.getText()));
			}
			if ((JTextField) component == textFieldCarismaModCondizioneNota) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj,
						ListaPgStatistiche.CARISMA_MOD_CONDIZIONE_NOTA, textFieldCarismaModCondizioneNota.getText()));
			}
		}

		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldForza) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj, ListaPgStatistiche.FORZA,
						formattedTextFieldForza.getText()));
				if (pgDatiObj.getPgStatisticheObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldForzaModCondizione) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj, ListaPgStatistiche.FORZA_MOD_CONDIZIONE,
						formattedTextFieldForzaModCondizione.getText()));
				if (pgDatiObj.getPgStatisticheObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldDestrezza) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj, ListaPgStatistiche.DESTREZZA,
						formattedTextFieldDestrezza.getText()));
				if (pgDatiObj.getPgStatisticheObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldDestrezzaModCondizione) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj, ListaPgStatistiche.DESTREZZA_MOD_CONDIZIONE,
						formattedTextFieldDestrezzaModCondizione.getText()));
				if (pgDatiObj.getPgStatisticheObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldCostituzione) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj, ListaPgStatistiche.COSTITUZIONE,
						formattedTextFieldCostituzione.getText()));
				if (pgDatiObj.getPgStatisticheObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldCostituzioneModCondizione) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj,
						ListaPgStatistiche.COSTITUZIONE_MOD_CONDIZIONE,
						formattedTextFieldCostituzioneModCondizione.getText()));
				if (pgDatiObj.getPgStatisticheObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldIntelligenza) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj, ListaPgStatistiche.INTELLIGENZA,
						formattedTextFieldIntelligenza.getText()));
				if (pgDatiObj.getPgStatisticheObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldIntelligenzaModCondizione) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj,
						ListaPgStatistiche.INTELLIGENZA_MOD_CONDIZIONE,
						formattedTextFieldIntelligenzaModCondizione.getText()));
				if (pgDatiObj.getPgStatisticheObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldSaggezza) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj, ListaPgStatistiche.SAGGEZZA,
						formattedTextFieldSaggezza.getText()));
				if (pgDatiObj.getPgStatisticheObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldSaggezzaModCondizione) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj, ListaPgStatistiche.SAGGEZZA_MOD_CONDIZIONE,
						formattedTextFieldSaggezzaModCondizione.getText()));
				if (pgDatiObj.getPgStatisticheObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldCarisma) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj, ListaPgStatistiche.CARISMA,
						formattedTextFieldCarisma.getText()));
				if (pgDatiObj.getPgStatisticheObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldCarismaModCondizione) {
				pgDatiObj = (aggiornaOggetti.aggiornaStatistiche(pgDatiObj, ListaPgStatistiche.CARISMA_MOD_CONDIZIONE,
						formattedTextFieldCarismaModCondizione.getText()));
				if (pgDatiObj.getPgStatisticheObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
		}

	}

	public MainWindow getFrame() {
		return frame;
	}

	public void setFrame(MainWindow frame) {
		this.frame = frame;
	}

}
