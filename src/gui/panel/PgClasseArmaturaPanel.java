package gui.panel;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaPgClasseArmatura;
import comboBox.PgArmiComboBox;
import comboBox.PgClasseArmaturaComboBox;
import gui.MainWindow;
import obj.OpzioniObj;
import obj.PgClasseArmaturaObj;
import obj.PgDatiObj;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class PgClasseArmaturaPanel extends JPanel implements FocusListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 563704922805590548L;
	Formati formati = new Formati();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	PgClasseArmaturaComboBox pgClasseArmaturaComboBox = new PgClasseArmaturaComboBox();

	private JFormattedTextField formattedTextFieldClasseArmaturaTotale;
	private JLabel lblNewLabel_1;
	private JLabel lblArmatura;
	private JFormattedTextField formattedTextFieldClasseArmaturaBonusArmatura;
	private JLabel label;
	private JLabel lblScudo;
	private JFormattedTextField formattedTextFieldClasseArmaturaBonusScudo;
	private JLabel label_1;
	private JLabel lblDestrezza;
	private JFormattedTextField formattedTextFieldClasseArmaturaBonusDestrezza;
	private JLabel label_2;
	private JFormattedTextField formattedTextFieldBonusTaglia;
	private JLabel lblTaglia_1;
	private JLabel label_3;
	private JLabel lblNaturale;
	private JFormattedTextField formattedTextFieldClasseArmaturaBonusNaturale;
	private JLabel label_4;
	private JLabel lblDeviazione;
	private JFormattedTextField formattedTextFieldClasseArmaturaBonusDeviazione;
	private JLabel label_5;
	private JLabel lblAltro;
	private JFormattedTextField formattedTextFieldClasseArmaturaBonusAltro;
	private JLabel label_6;
	private JLabel lblTemp;
	private JFormattedTextField formattedTextFieldClasseArmaturaBonusTemp;
	private JPanel panelArmaturaScudoUsati;
	private JLabel lblArmaturaEScudo;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxArmaturaScudo1;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxArmaturaScudo2;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxArmaturaScudo3;
	private JFormattedTextField formattedTextFieldArmaturaScudoBonus1;
	private JFormattedTextField formattedTextFieldArmaturaScudoBonus2;
	private JFormattedTextField formattedTextFieldArmaturaScudoBonus3;
	private JPanel panelClasseArmatura2;
	private JLabel lblCa;
	private JFormattedTextField formattedTextFieldClasseArmaturaColtoAllaSprovvista;
	private JLabel lblcaAttacchiA;
	private JFormattedTextField formattedTextFieldClasseArmaturaAttacchiAContatto;
	private JPanel panel;
	private JLabel lblFallimentoIncantesimiArcani;
	private JFormattedTextField formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani;
	private JLabel label_7;
	private JLabel label_8;
	private JFormattedTextField formattedTextFieldClasseArmaturaPenalitaProvaArmatura;
	private JLabel label_9;
	private JFormattedTextField formattedTextFieldClasseArmaturaBonusMassimoDestrezza;
	GridBagConstraints gbc_formattedTextFieldClasseArmaturaPenalitaProvaArmatura;
	private JFormattedTextField formattedTextFieldArmaturaScudoBonusBase1;
	private JFormattedTextField formattedTextFieldArmaturaScudoBonusBase2;
	private JFormattedTextField formattedTextFieldArmaturaScudoBonusBase3;

	private PgDatiObj pgDatiObj;
	OpzioniObj opzioniObj;
	private MainWindow frame;
	private JCheckBox chckbxModificaFallimentoIncantesimiArcani;
	private JCheckBox chckbxModificaPenalitaProvaArmatura;

	@SuppressWarnings("rawtypes")
	public PgClasseArmaturaPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.pgDatiObj = pgDatiObj;

		NumberFormatter soloNumeri = formati.getSoloNumeri();
		NumberFormatter soloNumeriConSegno = formati.getSoloNumeriConSegno();

		GridBagLayout gbl_panelClasseArmatura = new GridBagLayout();
		gbl_panelClasseArmatura.columnWidths = new int[] { 67, 0, 70, 0, 70, 0, 70, 0, 70, 0, 70, 0, 70, 0, 70, 0, 70,
				0 };
		gbl_panelClasseArmatura.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panelClasseArmatura.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelClasseArmatura.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.setLayout(gbl_panelClasseArmatura);

		formattedTextFieldClasseArmaturaTotale = new JFormattedTextField(soloNumeri);
		formattedTextFieldClasseArmaturaTotale.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldClasseArmaturaTotale.setFont(new Font("Tahoma", Font.BOLD, 18));
		formattedTextFieldClasseArmaturaTotale.setEnabled(false);
		formattedTextFieldClasseArmaturaTotale.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldClasseArmaturaTotale = new GridBagConstraints();
		gbc_formattedTextFieldClasseArmaturaTotale.gridheight = 2;
		gbc_formattedTextFieldClasseArmaturaTotale.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldClasseArmaturaTotale.fill = GridBagConstraints.BOTH;
		gbc_formattedTextFieldClasseArmaturaTotale.gridx = 0;
		gbc_formattedTextFieldClasseArmaturaTotale.gridy = 0;
		this.add(formattedTextFieldClasseArmaturaTotale, gbc_formattedTextFieldClasseArmaturaTotale);
		formattedTextFieldClasseArmaturaTotale.setColumns(10);

		lblNewLabel_1 = new JLabel("=10 + ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridheight = 2;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);

		lblArmatura = new JLabel("Armatura");
		GridBagConstraints gbc_lblArmatura = new GridBagConstraints();
		gbc_lblArmatura.insets = new Insets(0, 0, 5, 5);
		gbc_lblArmatura.gridx = 2;
		gbc_lblArmatura.gridy = 0;
		this.add(lblArmatura, gbc_lblArmatura);

		lblScudo = new JLabel("Scudo");
		GridBagConstraints gbc_lblScudo = new GridBagConstraints();
		gbc_lblScudo.insets = new Insets(0, 0, 5, 5);
		gbc_lblScudo.gridx = 4;
		gbc_lblScudo.gridy = 0;
		this.add(lblScudo, gbc_lblScudo);

		lblDestrezza = new JLabel("Destrezza");
		GridBagConstraints gbc_lblDestrezza = new GridBagConstraints();
		gbc_lblDestrezza.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestrezza.gridx = 6;
		gbc_lblDestrezza.gridy = 0;
		this.add(lblDestrezza, gbc_lblDestrezza);

		lblTaglia_1 = new JLabel("Taglia");
		GridBagConstraints gbc_lblTaglia_1 = new GridBagConstraints();
		gbc_lblTaglia_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTaglia_1.gridx = 8;
		gbc_lblTaglia_1.gridy = 0;
		this.add(lblTaglia_1, gbc_lblTaglia_1);

		lblNaturale = new JLabel("Naturale");
		GridBagConstraints gbc_lblNaturale = new GridBagConstraints();
		gbc_lblNaturale.insets = new Insets(0, 0, 5, 5);
		gbc_lblNaturale.gridx = 10;
		gbc_lblNaturale.gridy = 0;
		this.add(lblNaturale, gbc_lblNaturale);

		lblDeviazione = new JLabel("Deviazione");
		GridBagConstraints gbc_lblDeviazione = new GridBagConstraints();
		gbc_lblDeviazione.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeviazione.gridx = 12;
		gbc_lblDeviazione.gridy = 0;
		this.add(lblDeviazione, gbc_lblDeviazione);

		lblAltro = new JLabel("Altro");
		GridBagConstraints gbc_lblAltro = new GridBagConstraints();
		gbc_lblAltro.insets = new Insets(0, 0, 5, 5);
		gbc_lblAltro.gridx = 14;
		gbc_lblAltro.gridy = 0;
		this.add(lblAltro, gbc_lblAltro);

		lblTemp = new JLabel("Temp");
		GridBagConstraints gbc_lblTemp = new GridBagConstraints();
		gbc_lblTemp.insets = new Insets(0, 0, 5, 0);
		gbc_lblTemp.gridx = 16;
		gbc_lblTemp.gridy = 0;
		this.add(lblTemp, gbc_lblTemp);

		formattedTextFieldClasseArmaturaBonusArmatura = new JFormattedTextField(soloNumeri);
		formattedTextFieldClasseArmaturaBonusArmatura.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldClasseArmaturaBonusArmatura.setEditable(false);
		formattedTextFieldClasseArmaturaBonusArmatura.setEnabled(false);
		GridBagConstraints gbc_formattedTextFieldClasseArmaturaBonusArmatura = new GridBagConstraints();
		gbc_formattedTextFieldClasseArmaturaBonusArmatura.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldClasseArmaturaBonusArmatura.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldClasseArmaturaBonusArmatura.gridx = 2;
		gbc_formattedTextFieldClasseArmaturaBonusArmatura.gridy = 1;
		this.add(formattedTextFieldClasseArmaturaBonusArmatura, gbc_formattedTextFieldClasseArmaturaBonusArmatura);
		formattedTextFieldClasseArmaturaBonusArmatura.setColumns(10);

		label = new JLabel("+");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 1;
		this.add(label, gbc_label);

		formattedTextFieldClasseArmaturaBonusScudo = new JFormattedTextField(soloNumeri);
		formattedTextFieldClasseArmaturaBonusScudo.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldClasseArmaturaBonusScudo.setEnabled(false);
		formattedTextFieldClasseArmaturaBonusScudo.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldClasseArmaturaBonusScudo = new GridBagConstraints();
		gbc_formattedTextFieldClasseArmaturaBonusScudo.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldClasseArmaturaBonusScudo.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldClasseArmaturaBonusScudo.gridx = 4;
		gbc_formattedTextFieldClasseArmaturaBonusScudo.gridy = 1;
		this.add(formattedTextFieldClasseArmaturaBonusScudo, gbc_formattedTextFieldClasseArmaturaBonusScudo);

		label_1 = new JLabel("+");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 5;
		gbc_label_1.gridy = 1;
		this.add(label_1, gbc_label_1);

		formattedTextFieldClasseArmaturaBonusDestrezza = new JFormattedTextField(soloNumeri);
		formattedTextFieldClasseArmaturaBonusDestrezza.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldClasseArmaturaBonusDestrezza.setEnabled(false);
		formattedTextFieldClasseArmaturaBonusDestrezza.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldClasseArmaturaBonusDestrezza = new GridBagConstraints();
		gbc_formattedTextFieldClasseArmaturaBonusDestrezza.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldClasseArmaturaBonusDestrezza.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldClasseArmaturaBonusDestrezza.gridx = 6;
		gbc_formattedTextFieldClasseArmaturaBonusDestrezza.gridy = 1;
		this.add(formattedTextFieldClasseArmaturaBonusDestrezza, gbc_formattedTextFieldClasseArmaturaBonusDestrezza);

		label_2 = new JLabel("+");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.gridx = 7;
		gbc_label_2.gridy = 1;
		this.add(label_2, gbc_label_2);

		formattedTextFieldBonusTaglia = new JFormattedTextField(soloNumeri);
		formattedTextFieldBonusTaglia.setEnabled(false);
		formattedTextFieldBonusTaglia.setEditable(false);
		formattedTextFieldBonusTaglia.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldBonusTaglia.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldClasseArmaturaBonusTaglia = new GridBagConstraints();
		gbc_formattedTextFieldClasseArmaturaBonusTaglia.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldClasseArmaturaBonusTaglia.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldClasseArmaturaBonusTaglia.gridx = 8;
		gbc_formattedTextFieldClasseArmaturaBonusTaglia.gridy = 1;
		this.add(formattedTextFieldBonusTaglia, gbc_formattedTextFieldClasseArmaturaBonusTaglia);

		label_3 = new JLabel("+");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 9;
		gbc_label_3.gridy = 1;
		this.add(label_3, gbc_label_3);

		formattedTextFieldClasseArmaturaBonusNaturale = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldClasseArmaturaBonusNaturale.addFocusListener(this);
		formattedTextFieldClasseArmaturaBonusNaturale.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_formattedTextFieldClasseArmaturaBonusNaturale = new GridBagConstraints();
		gbc_formattedTextFieldClasseArmaturaBonusNaturale.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldClasseArmaturaBonusNaturale.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldClasseArmaturaBonusNaturale.gridx = 10;
		gbc_formattedTextFieldClasseArmaturaBonusNaturale.gridy = 1;
		this.add(formattedTextFieldClasseArmaturaBonusNaturale, gbc_formattedTextFieldClasseArmaturaBonusNaturale);

		label_4 = new JLabel("+");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 11;
		gbc_label_4.gridy = 1;
		this.add(label_4, gbc_label_4);

		formattedTextFieldClasseArmaturaBonusDeviazione = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldClasseArmaturaBonusDeviazione.addFocusListener(this);
		formattedTextFieldClasseArmaturaBonusDeviazione.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_formattedTextFieldClasseArmaturaBonusDeviazione = new GridBagConstraints();
		gbc_formattedTextFieldClasseArmaturaBonusDeviazione.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldClasseArmaturaBonusDeviazione.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldClasseArmaturaBonusDeviazione.gridx = 12;
		gbc_formattedTextFieldClasseArmaturaBonusDeviazione.gridy = 1;
		this.add(formattedTextFieldClasseArmaturaBonusDeviazione, gbc_formattedTextFieldClasseArmaturaBonusDeviazione);

		label_5 = new JLabel("+");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 13;
		gbc_label_5.gridy = 1;
		this.add(label_5, gbc_label_5);

		formattedTextFieldClasseArmaturaBonusAltro = new JFormattedTextField(soloNumeri);
		formattedTextFieldClasseArmaturaBonusAltro.setEnabled(false);
		formattedTextFieldClasseArmaturaBonusAltro.setEditable(false);
		formattedTextFieldClasseArmaturaBonusAltro.addFocusListener(this);
		formattedTextFieldClasseArmaturaBonusAltro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_formattedTextFieldClasseArmaturaBonusAltro = new GridBagConstraints();
		gbc_formattedTextFieldClasseArmaturaBonusAltro.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldClasseArmaturaBonusAltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldClasseArmaturaBonusAltro.gridx = 14;
		gbc_formattedTextFieldClasseArmaturaBonusAltro.gridy = 1;
		this.add(formattedTextFieldClasseArmaturaBonusAltro, gbc_formattedTextFieldClasseArmaturaBonusAltro);

		label_6 = new JLabel("+");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 15;
		gbc_label_6.gridy = 1;
		this.add(label_6, gbc_label_6);

		formattedTextFieldClasseArmaturaBonusTemp = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldClasseArmaturaBonusTemp.addFocusListener(this);
		formattedTextFieldClasseArmaturaBonusTemp.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_formattedTextFieldClasseArmaturaBonusTemp = new GridBagConstraints();
		gbc_formattedTextFieldClasseArmaturaBonusTemp.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldClasseArmaturaBonusTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldClasseArmaturaBonusTemp.gridx = 16;
		gbc_formattedTextFieldClasseArmaturaBonusTemp.gridy = 1;
		this.add(formattedTextFieldClasseArmaturaBonusTemp, gbc_formattedTextFieldClasseArmaturaBonusTemp);

		panelArmaturaScudoUsati = new JPanel();
		GridBagConstraints gbc_panelArmaturaScudoUsati = new GridBagConstraints();
		gbc_panelArmaturaScudoUsati.gridwidth = 5;
		gbc_panelArmaturaScudoUsati.insets = new Insets(0, 0, 0, 5);
		gbc_panelArmaturaScudoUsati.fill = GridBagConstraints.BOTH;
		gbc_panelArmaturaScudoUsati.gridx = 0;
		gbc_panelArmaturaScudoUsati.gridy = 4;
		this.add(panelArmaturaScudoUsati, gbc_panelArmaturaScudoUsati);
		GridBagLayout gbl_panelArmaturaScudoUsati = new GridBagLayout();
		gbl_panelArmaturaScudoUsati.columnWidths = new int[] { 150, 38, 40, 0 };
		gbl_panelArmaturaScudoUsati.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelArmaturaScudoUsati.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelArmaturaScudoUsati.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelArmaturaScudoUsati.setLayout(gbl_panelArmaturaScudoUsati);

		lblArmaturaEScudo = new JLabel("Armatura e Scudo Usati");
		lblArmaturaEScudo.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblArmaturaEScudo = new GridBagConstraints();
		gbc_lblArmaturaEScudo.gridwidth = 3;
		gbc_lblArmaturaEScudo.insets = new Insets(0, 0, 5, 0);
		gbc_lblArmaturaEScudo.gridx = 0;
		gbc_lblArmaturaEScudo.gridy = 0;
		panelArmaturaScudoUsati.add(lblArmaturaEScudo, gbc_lblArmaturaEScudo);

		comboBoxArmaturaScudo1 = new JComboBox();
		comboBoxArmaturaScudo1.addFocusListener(this);
		// comboBoxArmaturaScudo1.addItemListener(this);
		GridBagConstraints gbc_comboBoxArmaturaScudo1 = new GridBagConstraints();
		gbc_comboBoxArmaturaScudo1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxArmaturaScudo1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxArmaturaScudo1.gridx = 0;
		gbc_comboBoxArmaturaScudo1.gridy = 1;
		panelArmaturaScudoUsati.add(comboBoxArmaturaScudo1, gbc_comboBoxArmaturaScudo1);

		formattedTextFieldArmaturaScudoBonus1 = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldArmaturaScudoBonus1.addFocusListener(this);

		formattedTextFieldArmaturaScudoBonusBase1 = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldArmaturaScudoBonusBase1.setEnabled(false);
		formattedTextFieldArmaturaScudoBonusBase1.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldArmaturaScudoBonusBase1 = new GridBagConstraints();
		gbc_formattedTextFieldArmaturaScudoBonusBase1.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldArmaturaScudoBonusBase1.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldArmaturaScudoBonusBase1.gridx = 1;
		gbc_formattedTextFieldArmaturaScudoBonusBase1.gridy = 1;
		panelArmaturaScudoUsati.add(formattedTextFieldArmaturaScudoBonusBase1,
				gbc_formattedTextFieldArmaturaScudoBonusBase1);
		GridBagConstraints gbc_formattedTextFieldArmaturaScudoBonus1 = new GridBagConstraints();
		gbc_formattedTextFieldArmaturaScudoBonus1.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldArmaturaScudoBonus1.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldArmaturaScudoBonus1.gridx = 2;
		gbc_formattedTextFieldArmaturaScudoBonus1.gridy = 1;
		panelArmaturaScudoUsati.add(formattedTextFieldArmaturaScudoBonus1, gbc_formattedTextFieldArmaturaScudoBonus1);

		comboBoxArmaturaScudo2 = new JComboBox();
		comboBoxArmaturaScudo2.addFocusListener(this);
		GridBagConstraints gbc_comboBoxArmaturaScudo2 = new GridBagConstraints();
		gbc_comboBoxArmaturaScudo2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxArmaturaScudo2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxArmaturaScudo2.gridx = 0;
		gbc_comboBoxArmaturaScudo2.gridy = 2;
		panelArmaturaScudoUsati.add(comboBoxArmaturaScudo2, gbc_comboBoxArmaturaScudo2);

		formattedTextFieldArmaturaScudoBonus2 = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldArmaturaScudoBonus2.addFocusListener(this);

		formattedTextFieldArmaturaScudoBonusBase2 = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldArmaturaScudoBonusBase2.setEnabled(false);
		formattedTextFieldArmaturaScudoBonusBase2.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldArmaturaScudoBonusBase2 = new GridBagConstraints();
		gbc_formattedTextFieldArmaturaScudoBonusBase2.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldArmaturaScudoBonusBase2.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldArmaturaScudoBonusBase2.gridx = 1;
		gbc_formattedTextFieldArmaturaScudoBonusBase2.gridy = 2;
		panelArmaturaScudoUsati.add(formattedTextFieldArmaturaScudoBonusBase2,
				gbc_formattedTextFieldArmaturaScudoBonusBase2);
		GridBagConstraints gbc_formattedTextFieldArmaturaScudoBonus2 = new GridBagConstraints();
		gbc_formattedTextFieldArmaturaScudoBonus2.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldArmaturaScudoBonus2.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldArmaturaScudoBonus2.gridx = 2;
		gbc_formattedTextFieldArmaturaScudoBonus2.gridy = 2;
		panelArmaturaScudoUsati.add(formattedTextFieldArmaturaScudoBonus2, gbc_formattedTextFieldArmaturaScudoBonus2);

		comboBoxArmaturaScudo3 = new JComboBox();
		comboBoxArmaturaScudo3.addFocusListener(this);
		GridBagConstraints gbc_comboBoxArmaturaScudo3 = new GridBagConstraints();
		gbc_comboBoxArmaturaScudo3.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxArmaturaScudo3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxArmaturaScudo3.gridx = 0;
		gbc_comboBoxArmaturaScudo3.gridy = 3;
		panelArmaturaScudoUsati.add(comboBoxArmaturaScudo3, gbc_comboBoxArmaturaScudo3);

		formattedTextFieldArmaturaScudoBonus3 = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldArmaturaScudoBonus3.addFocusListener(this);

		formattedTextFieldArmaturaScudoBonusBase3 = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldArmaturaScudoBonusBase3.setEnabled(false);
		formattedTextFieldArmaturaScudoBonusBase3.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldArmaturaScudoBonusBase3 = new GridBagConstraints();
		gbc_formattedTextFieldArmaturaScudoBonusBase3.insets = new Insets(0, 0, 0, 5);
		gbc_formattedTextFieldArmaturaScudoBonusBase3.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldArmaturaScudoBonusBase3.gridx = 1;
		gbc_formattedTextFieldArmaturaScudoBonusBase3.gridy = 3;
		panelArmaturaScudoUsati.add(formattedTextFieldArmaturaScudoBonusBase3,
				gbc_formattedTextFieldArmaturaScudoBonusBase3);
		GridBagConstraints gbc_formattedTextFieldArmaturaScudoBonus3 = new GridBagConstraints();
		gbc_formattedTextFieldArmaturaScudoBonus3.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldArmaturaScudoBonus3.gridx = 2;
		gbc_formattedTextFieldArmaturaScudoBonus3.gridy = 3;
		panelArmaturaScudoUsati.add(formattedTextFieldArmaturaScudoBonus3, gbc_formattedTextFieldArmaturaScudoBonus3);

		panelClasseArmatura2 = new JPanel();
		GridBagConstraints gbc_panelClasseArmatura2 = new GridBagConstraints();
		gbc_panelClasseArmatura2.gridwidth = 5;
		gbc_panelClasseArmatura2.insets = new Insets(0, 0, 0, 5);
		gbc_panelClasseArmatura2.fill = GridBagConstraints.BOTH;
		gbc_panelClasseArmatura2.gridx = 6;
		gbc_panelClasseArmatura2.gridy = 4;
		this.add(panelClasseArmatura2, gbc_panelClasseArmatura2);
		GridBagLayout gbl_panelClasseArmatura2 = new GridBagLayout();
		gbl_panelClasseArmatura2.columnWidths = new int[] { 150, 70, 0 };
		gbl_panelClasseArmatura2.rowHeights = new int[] { 70, 70, 0 };
		gbl_panelClasseArmatura2.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelClasseArmatura2.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelClasseArmatura2.setLayout(gbl_panelClasseArmatura2);

		lblCa = new JLabel("<html>CA Colto alla Sprovvista <br>(perdita del bonus DES)</html>");
		lblCa.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCa = new GridBagConstraints();
		gbc_lblCa.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCa.insets = new Insets(0, 0, 5, 5);
		gbc_lblCa.gridx = 0;
		gbc_lblCa.gridy = 0;
		panelClasseArmatura2.add(lblCa, gbc_lblCa);

		formattedTextFieldClasseArmaturaColtoAllaSprovvista = new JFormattedTextField(soloNumeri);
		formattedTextFieldClasseArmaturaColtoAllaSprovvista.setFont(new Font("Tahoma", Font.BOLD, 18));
		formattedTextFieldClasseArmaturaColtoAllaSprovvista.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldClasseArmaturaColtoAllaSprovvista.setEnabled(false);
		formattedTextFieldClasseArmaturaColtoAllaSprovvista.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldClasseArmaturaColtoAllaSprovvista = new GridBagConstraints();
		gbc_formattedTextFieldClasseArmaturaColtoAllaSprovvista.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldClasseArmaturaColtoAllaSprovvista.fill = GridBagConstraints.BOTH;
		gbc_formattedTextFieldClasseArmaturaColtoAllaSprovvista.gridx = 1;
		gbc_formattedTextFieldClasseArmaturaColtoAllaSprovvista.gridy = 0;
		panelClasseArmatura2.add(formattedTextFieldClasseArmaturaColtoAllaSprovvista,
				gbc_formattedTextFieldClasseArmaturaColtoAllaSprovvista);

		lblcaAttacchiA = new JLabel(
				"<html>CA Attacchi a Contatto <br>(perdita del bonus Armatura, Scudo, Naturale)</html>");
		lblcaAttacchiA.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblcaAttacchiA = new GridBagConstraints();
		gbc_lblcaAttacchiA.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblcaAttacchiA.insets = new Insets(0, 0, 0, 5);
		gbc_lblcaAttacchiA.gridx = 0;
		gbc_lblcaAttacchiA.gridy = 1;
		panelClasseArmatura2.add(lblcaAttacchiA, gbc_lblcaAttacchiA);

		formattedTextFieldClasseArmaturaAttacchiAContatto = new JFormattedTextField(soloNumeri);
		formattedTextFieldClasseArmaturaAttacchiAContatto.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldClasseArmaturaAttacchiAContatto.setFont(new Font("Tahoma", Font.BOLD, 18));
		formattedTextFieldClasseArmaturaAttacchiAContatto.setEnabled(false);
		formattedTextFieldClasseArmaturaAttacchiAContatto.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldClasseArmaturaAttacchiAContatto = new GridBagConstraints();
		gbc_formattedTextFieldClasseArmaturaAttacchiAContatto.fill = GridBagConstraints.BOTH;
		gbc_formattedTextFieldClasseArmaturaAttacchiAContatto.gridx = 1;
		gbc_formattedTextFieldClasseArmaturaAttacchiAContatto.gridy = 1;
		panelClasseArmatura2.add(formattedTextFieldClasseArmaturaAttacchiAContatto,
				gbc_formattedTextFieldClasseArmaturaAttacchiAContatto);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 6;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 11;
		gbc_panel.gridy = 4;
		this.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 70, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblFallimentoIncantesimiArcani = new JLabel("<html><center>Fallimento<br>Incantesimi Arcani</center></html>");
		lblFallimentoIncantesimiArcani.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblFallimentoIncantesimiArcani = new GridBagConstraints();
		gbc_lblFallimentoIncantesimiArcani.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFallimentoIncantesimiArcani.insets = new Insets(0, 0, 5, 5);
		gbc_lblFallimentoIncantesimiArcani.gridx = 0;
		gbc_lblFallimentoIncantesimiArcani.gridy = 0;
		panel.add(lblFallimentoIncantesimiArcani, gbc_lblFallimentoIncantesimiArcani);

		label_7 = new JLabel("%");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.gridx = 1;
		gbc_label_7.gridy = 0;
		panel.add(label_7, gbc_label_7);

		formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani = new JFormattedTextField(soloNumeri);
		formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani.setEnabled(false);
		formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani.setEditable(false);
		formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani = new GridBagConstraints();
		gbc_formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani.gridx = 2;
		gbc_formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani.gridy = 0;
		panel.add(formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani,
				gbc_formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani);
		formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani.setColumns(10);

		chckbxModificaFallimentoIncantesimiArcani = new JCheckBox("Abilita Fallimento Incantesimi Arcani");
		chckbxModificaFallimentoIncantesimiArcani.addActionListener(this);
		GridBagConstraints gbc_chckbxModificaFallimentoIncantesimiArcani = new GridBagConstraints();
		gbc_chckbxModificaFallimentoIncantesimiArcani.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxModificaFallimentoIncantesimiArcani.gridx = 3;
		gbc_chckbxModificaFallimentoIncantesimiArcani.gridy = 0;
		panel.add(chckbxModificaFallimentoIncantesimiArcani, gbc_chckbxModificaFallimentoIncantesimiArcani);

		label_8 = new JLabel("<html><center>Penalità alla<br>Prova Armatura</center></html>");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 2;
		panel.add(label_8, gbc_label_8);

		formattedTextFieldClasseArmaturaPenalitaProvaArmatura = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldClasseArmaturaPenalitaProvaArmatura.setEnabled(false);
		formattedTextFieldClasseArmaturaPenalitaProvaArmatura.setEditable(false);
		formattedTextFieldClasseArmaturaPenalitaProvaArmatura.addFocusListener(this);
		gbc_formattedTextFieldClasseArmaturaPenalitaProvaArmatura = new GridBagConstraints();
		gbc_formattedTextFieldClasseArmaturaPenalitaProvaArmatura.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldClasseArmaturaPenalitaProvaArmatura.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldClasseArmaturaPenalitaProvaArmatura.gridx = 2;
		gbc_formattedTextFieldClasseArmaturaPenalitaProvaArmatura.gridy = 2;
		panel.add(formattedTextFieldClasseArmaturaPenalitaProvaArmatura,
				gbc_formattedTextFieldClasseArmaturaPenalitaProvaArmatura);
		formattedTextFieldClasseArmaturaPenalitaProvaArmatura.setColumns(10);

		chckbxModificaPenalitaProvaArmatura = new JCheckBox("Abilita Penalità alla Prova Armatura");
		chckbxModificaPenalitaProvaArmatura.addActionListener(this);
		GridBagConstraints gbc_chckbxModificaPenalitaProvaArmatura = new GridBagConstraints();
		gbc_chckbxModificaPenalitaProvaArmatura.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxModificaPenalitaProvaArmatura.gridx = 3;
		gbc_chckbxModificaPenalitaProvaArmatura.gridy = 2;
		panel.add(chckbxModificaPenalitaProvaArmatura, gbc_chckbxModificaPenalitaProvaArmatura);

		label_9 = new JLabel("<html><center>Bonus Massimo<br>Destrezza</center></html>");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 0, 5);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 4;
		panel.add(label_9, gbc_label_9);

		formattedTextFieldClasseArmaturaBonusMassimoDestrezza = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldClasseArmaturaBonusMassimoDestrezza.setEnabled(false);
		formattedTextFieldClasseArmaturaBonusMassimoDestrezza.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldClasseArmaturaBonusMassimoDestrezza = new GridBagConstraints();
		gbc_formattedTextFieldClasseArmaturaBonusMassimoDestrezza.insets = new Insets(0, 0, 0, 5);
		gbc_formattedTextFieldClasseArmaturaBonusMassimoDestrezza.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldClasseArmaturaBonusMassimoDestrezza.gridx = 2;
		gbc_formattedTextFieldClasseArmaturaBonusMassimoDestrezza.gridy = 4;
		panel.add(formattedTextFieldClasseArmaturaBonusMassimoDestrezza,
				gbc_formattedTextFieldClasseArmaturaBonusMassimoDestrezza);

	}

	@SuppressWarnings("unchecked")
	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {

		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		
		PgClasseArmaturaObj pgClasseArmaturaObj = new PgClasseArmaturaObj();
		pgClasseArmaturaObj = pgDatiObj.getPgClasseArmaturaObj();
		formattedTextFieldClasseArmaturaTotale.setValue(pgClasseArmaturaObj.getTotale());
		formattedTextFieldClasseArmaturaBonusArmatura.setValue(pgClasseArmaturaObj.getBonusArmatura());
		formattedTextFieldClasseArmaturaBonusScudo.setValue(pgClasseArmaturaObj.getBonusScudo());
		formattedTextFieldClasseArmaturaBonusDestrezza.setValue(pgClasseArmaturaObj.getBonusDestrezza());
		formattedTextFieldBonusTaglia.setValue(pgClasseArmaturaObj.getBonusTaglia());
		formattedTextFieldClasseArmaturaBonusNaturale.setValue(pgClasseArmaturaObj.getBonusNaturale());
		formattedTextFieldClasseArmaturaBonusDeviazione.setValue(pgClasseArmaturaObj.getBonusDeviazione());
		formattedTextFieldClasseArmaturaBonusAltro.setValue(pgClasseArmaturaObj.getBonusAltro());
		formattedTextFieldClasseArmaturaBonusTemp.setValue(pgClasseArmaturaObj.getBonusTemp());

		comboBoxArmaturaScudo1.setModel(pgClasseArmaturaComboBox.creaComboBoxArmature().getModel());

		if (comboBoxArmaturaScudo1.getItemCount() != 0) {
			comboBoxArmaturaScudo1.setSelectedIndex(0);
			for (int i = 0; i < comboBoxArmaturaScudo1.getItemCount(); i++) {
				if (comboBoxArmaturaScudo1.getItemAt(i).toString().equals(pgClasseArmaturaObj.getArmaturaScudo1())) {
					comboBoxArmaturaScudo1.setSelectedIndex(i);
				}
			}
		}
		formattedTextFieldArmaturaScudoBonusBase1.setValue(pgClasseArmaturaObj.getArmaturaScudoStatistica1());
		formattedTextFieldArmaturaScudoBonus1.setValue(pgClasseArmaturaObj.getArmaturaScudoBonus1());

		comboBoxArmaturaScudo2.setModel(pgClasseArmaturaComboBox.creaComboBoxArmature().getModel());
		if (comboBoxArmaturaScudo2.getItemCount() != 0) {
			comboBoxArmaturaScudo2.setSelectedIndex(0);
			for (int i = 0; i < comboBoxArmaturaScudo2.getItemCount(); i++) {
				if (comboBoxArmaturaScudo2.getItemAt(i).toString().equals(pgClasseArmaturaObj.getArmaturaScudo2())) {
					comboBoxArmaturaScudo2.setSelectedIndex(i);
				}
			}
		}
		formattedTextFieldArmaturaScudoBonusBase2.setValue(pgClasseArmaturaObj.getArmaturaScudoStatistica2());
		formattedTextFieldArmaturaScudoBonus2.setValue(pgClasseArmaturaObj.getArmaturaScudoBonus2());

		comboBoxArmaturaScudo3.setModel(pgClasseArmaturaComboBox.creaComboBoxArmature().getModel());
		if (comboBoxArmaturaScudo3.getItemCount() != 0) {
			comboBoxArmaturaScudo3.setSelectedIndex(0);
			for (int i = 0; i < comboBoxArmaturaScudo3.getItemCount(); i++) {
				if (comboBoxArmaturaScudo3.getItemAt(i).toString().equals(pgClasseArmaturaObj.getArmaturaScudo3())) {
					comboBoxArmaturaScudo3.setSelectedIndex(i);
				}
			}
		}
		// System.out.println("pgClasseArmaturaObj.getArmaturaScudoStatistica3():
		// " + pgClasseArmaturaObj.getArmaturaScudoStatistica3());
		formattedTextFieldArmaturaScudoBonusBase3.setValue(pgClasseArmaturaObj.getArmaturaScudoStatistica3());
		formattedTextFieldArmaturaScudoBonus3.setValue(pgClasseArmaturaObj.getArmaturaScudoBonus3());
		formattedTextFieldClasseArmaturaColtoAllaSprovvista.setValue(pgClasseArmaturaObj.getColtoAllaSprovvista());
		formattedTextFieldClasseArmaturaAttacchiAContatto.setValue(pgClasseArmaturaObj.getAttacchiAContatto());

		chckbxModificaFallimentoIncantesimiArcani.setSelected(pgClasseArmaturaObj.isFlagFallimentoIncantesimiArcani());

		if (chckbxModificaFallimentoIncantesimiArcani.isSelected()) {
			formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani.setEnabled(true);
			formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani.setEditable(true);
		} else {
			formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani.setEnabled(false);
			formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani.setEditable(false);
		}

		formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani
				.setValue(pgClasseArmaturaObj.getFallimentoIncantesimiArcani());

		chckbxModificaPenalitaProvaArmatura.setSelected(pgClasseArmaturaObj.isFlagPenalitaProvaArmatura());

		if (chckbxModificaPenalitaProvaArmatura.isSelected()) {
			formattedTextFieldClasseArmaturaPenalitaProvaArmatura.setEnabled(true);
			formattedTextFieldClasseArmaturaPenalitaProvaArmatura.setEditable(true);
		} else {
			formattedTextFieldClasseArmaturaPenalitaProvaArmatura.setEnabled(false);
			formattedTextFieldClasseArmaturaPenalitaProvaArmatura.setEditable(false);
		}

		formattedTextFieldClasseArmaturaPenalitaProvaArmatura.setValue(pgClasseArmaturaObj.getPenalitaProvaArmatura());
		formattedTextFieldClasseArmaturaBonusMassimoDestrezza.setValue(pgClasseArmaturaObj.getBonusMassimoDestrezza());

	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();

		if (component instanceof JFormattedTextField) {

			if ((JFormattedTextField) component == formattedTextFieldBonusTaglia) {
				pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj, ListaPgClasseArmatura.BONUS_TAGLIA,
						formattedTextFieldBonusTaglia.getText());
				if (pgDatiObj.getPgClasseArmaturaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldClasseArmaturaBonusNaturale) {
				pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj, ListaPgClasseArmatura.BONUS_NATURALE,
						formattedTextFieldClasseArmaturaBonusNaturale.getText());
				if (pgDatiObj.getPgClasseArmaturaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldClasseArmaturaBonusDeviazione) {
				pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj, ListaPgClasseArmatura.BONUS_DEVIAZIONE,
						formattedTextFieldClasseArmaturaBonusDeviazione.getText());
				if (pgDatiObj.getPgClasseArmaturaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldClasseArmaturaBonusAltro) {
				pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj, ListaPgClasseArmatura.BONUS_ALTRO,
						formattedTextFieldClasseArmaturaBonusAltro.getText());
				if (pgDatiObj.getPgClasseArmaturaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldClasseArmaturaBonusTemp) {
				pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj, ListaPgClasseArmatura.BONUS_TEMP,
						formattedTextFieldClasseArmaturaBonusTemp.getText());
				if (pgDatiObj.getPgClasseArmaturaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldArmaturaScudoBonus1) {
				if (!formattedTextFieldArmaturaScudoBonus1.getValue().toString().equals("0")) {
					if (((String) comboBoxArmaturaScudo1.getItemAt(comboBoxArmaturaScudo1.getSelectedIndex())).trim()
							.isEmpty()) {
						formattedTextFieldArmaturaScudoBonus1.setValue(0);
						JOptionPane.showMessageDialog(null,
								"Scegliere una Armatura/Scudo per applicare il modificatore", "Errore",
								JOptionPane.ERROR_MESSAGE);
					} else {
						pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj,
								ListaPgClasseArmatura.ARMATURA_SCUDO_BONUS1,
								formattedTextFieldArmaturaScudoBonus1.getText());
						if (pgDatiObj.getPgClasseArmaturaObj().isDatiVariati()) {
							frame.popolaFrame(pgDatiObj);
						}
					}
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldArmaturaScudoBonus2) {
				if (!formattedTextFieldArmaturaScudoBonus2.getValue().toString().equals("0")) {
					if (((String) comboBoxArmaturaScudo2.getItemAt(comboBoxArmaturaScudo2.getSelectedIndex())).trim()
							.isEmpty()) {
						formattedTextFieldArmaturaScudoBonus2.setValue(0);
						JOptionPane.showMessageDialog(null,
								"Scegliere una Armatura/Scudo per applicare il modificatore", "Errore",
								JOptionPane.ERROR_MESSAGE);
					} else {
						pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj,
								ListaPgClasseArmatura.ARMATURA_SCUDO_BONUS2,
								formattedTextFieldArmaturaScudoBonus2.getText());
						if (pgDatiObj.getPgClasseArmaturaObj().isDatiVariati()) {
							frame.popolaFrame(pgDatiObj);
						}
					}
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldArmaturaScudoBonus3) {
				if (!formattedTextFieldArmaturaScudoBonus3.getValue().toString().equals("0")) {
					if (((String) comboBoxArmaturaScudo3.getItemAt(comboBoxArmaturaScudo3.getSelectedIndex())).trim()
							.isEmpty()) {
						formattedTextFieldArmaturaScudoBonus3.setValue(0);
						JOptionPane.showMessageDialog(null,
								"Scegliere una Armatura/Scudo per applicare il modificatore", "Errore",
								JOptionPane.ERROR_MESSAGE);
					} else {
						pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj,
								ListaPgClasseArmatura.ARMATURA_SCUDO_BONUS3,
								formattedTextFieldArmaturaScudoBonus3.getText());
						if (pgDatiObj.getPgClasseArmaturaObj().isDatiVariati()) {
							frame.popolaFrame(pgDatiObj);
						}
					}
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani) {
				pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj,
						ListaPgClasseArmatura.FALLIMENTO_INCANTESIMI_ARCANI,
						formattedTextFieldClasseArmaturaFallimentoIncantesimiArcani.getText());
				if (pgDatiObj.getPgClasseArmaturaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldClasseArmaturaPenalitaProvaArmatura) {
				pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj,
						ListaPgClasseArmatura.PENALITA_PROVA_ARMATURA,
						formattedTextFieldClasseArmaturaPenalitaProvaArmatura.getText());
				if (pgDatiObj.getPgClasseArmaturaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}

		}
		if (component instanceof JComboBox) {
			if ((JComboBox) component == comboBoxArmaturaScudo1) {
				pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj, ListaPgClasseArmatura.ARMATURA_SCUDO1,
						comboBoxArmaturaScudo1.getSelectedItem().toString());
				if (pgDatiObj.getPgClasseArmaturaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JComboBox) component == comboBoxArmaturaScudo2) {
				pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj, ListaPgClasseArmatura.ARMATURA_SCUDO2,
						comboBoxArmaturaScudo2.getSelectedItem().toString());
				if (pgDatiObj.getPgClasseArmaturaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JComboBox) component == comboBoxArmaturaScudo3) {
				pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj, ListaPgClasseArmatura.ARMATURA_SCUDO3,
						comboBoxArmaturaScudo3.getSelectedItem().toString());
				if (pgDatiObj.getPgClasseArmaturaObj().isDatiVariati()) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JCheckBox) {
			if (((JCheckBox) oggetto).getActionCommand() == chckbxModificaFallimentoIncantesimiArcani
					.getActionCommand()) {
				pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj,
						ListaPgClasseArmatura.FLAG_FALLIMENTO_INCANTESIMI_ARCANI,
						Boolean.valueOf(chckbxModificaFallimentoIncantesimiArcani.isSelected()).toString());
				frame.popolaFrame(pgDatiObj);
			}
			if (((JCheckBox) oggetto).getActionCommand() == chckbxModificaPenalitaProvaArmatura.getActionCommand()) {
				pgDatiObj = aggiornaOggetti.aggiornaClasseArmatura(pgDatiObj,
						ListaPgClasseArmatura.FLAG_PENALITA_PROVA_ARMATURA,
						Boolean.valueOf(chckbxModificaPenalitaProvaArmatura.isSelected()).toString());
				frame.popolaFrame(pgDatiObj);
			}
		}
	}

}
