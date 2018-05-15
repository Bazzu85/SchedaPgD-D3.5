package gui.panel;

import java.awt.Color;
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
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.NumberFormatter;

import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaPgArmi;
import ENUM.ListaPgBab;
import gui.MainWindow;
import gui.VerticalLabel;
import obj.OpzioniObj;
import obj.PgBabObj;
import obj.PgDatiObj;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PgBabPanel extends JPanel implements FocusListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7108403604924270001L;
	Formati formati = new Formati();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();

	private PgDatiObj pgDatiObj;
	private MainWindow frame;

	private JFormattedTextField formattedTextFieldBabClasse1;
	private JFormattedTextField formattedTextFieldBabClasse2;
	private JFormattedTextField formattedTextFieldBabClasse3;
	private JFormattedTextField formattedTextFieldBabClasse4;
	private JFormattedTextField formattedTextFieldBabClasse5;
	private JFormattedTextField formattedTextFieldBabClasse6;
	private JPanel panel;
	private JLabel lblA;
	private JLabel lblB;
	private JLabel lblC;
	private JLabel lblD;
	private JLabel lblE;
	private JLabel lblF;
	private JPanel panel_1;
	private JLabel lblBonusAttaccoBase_1;
	private JTextArea textAreaBab;
	private JLabel label;
	private JFormattedTextField formattedTextFieldLottareTaglia;
	private JLabel label_1;
	private JFormattedTextField formattedTextFieldLottareForza;
	private JLabel label_2;
	private JTextArea textAreaLottareTotale;
	private JLabel label_3;
	private JFormattedTextField formattedTextFieldMischiaTaglia;
	private JLabel label_4;
	private JFormattedTextField formattedTextFieldMischiaForza;
	private JLabel lblTaglia;
	private JLabel lblForza;
	private JLabel label_5;
	private JFormattedTextField formattedTextFieldMischiaAltro;
	private JLabel lblAltro;
	private JLabel label_6;
	private JTextArea textAreaMischiaTotale;
	private JLabel lblBonusAttaccoMischia;
	private JFormattedTextField formattedTextFieldDistanzaDestrezza;
	private JLabel label_7;
	private JFormattedTextField formattedTextFieldDistanzaAltro;
	private JLabel label_8;
	private JTextArea textAreaDistanzaTotale;
	private JLabel lblBonusAttaccoDistanza;
	private JPanel panel_2;
	private JLabel lblPenalitACombattere;
	private JFormattedTextField formattedTextFieldPenalità2ArmiPrimaria;
	private JFormattedTextField formattedTextFieldPenalità2ArmiSecondaria;
	private JLabel lblPrimaria;
	private JLabel lblSecondaria;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JLabel lblAttacco;
	private JLabel lblAttacco_1;
	private JLabel lblAttacco_2;
	private JLabel lblAttacco_3;
	private JLabel lblAttacco_4;
	private JLabel lblAttacco_5;
	private JLabel lblAttacco_6;
	private JLabel lblAttacco_7;
	private JFormattedTextField formattedTextFieldAttaccoBase1;
	private JFormattedTextField formattedTextFieldAttaccoBase2;
	private JFormattedTextField formattedTextFieldAttaccoBase3;
	private JFormattedTextField formattedTextFieldAttaccoBase4;
	private JFormattedTextField formattedTextFieldAttaccoBase5;
	private JFormattedTextField formattedTextFieldAttaccoBase6;
	private JFormattedTextField formattedTextFieldAttaccoBase7;
	private JFormattedTextField formattedTextFieldAttaccoBase8;
	private JLabel lblDestrezza;
	private JLabel lbltagliaspeciale;
	private JLabel lblForza_1;
	private JLabel label_9;
	private JLabel label_10;
	private JPanel panel_4;
	private JLabel lblNote;
	private JTextPane textPaneNote;
	private JLabel lblLottare;
	private JLabel label_12;
	private JCheckBox chckbxTalentoCombattereA2Armi;
	private OpzioniObj opzioniObj;

	public PgBabPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.setPgDatiObj(pgDatiObj);

		NumberFormatter soloNumeri = formati.getSoloNumeri();
		NumberFormatter soloNumeriConSegno = formati.getSoloNumeriConSegno();

		GridBagLayout gbl_pgBonusAttaccoBasePanel = new GridBagLayout();
		gbl_pgBonusAttaccoBasePanel.columnWidths = new int[] { 87, 88, 460,
				0 };
		gbl_pgBonusAttaccoBasePanel.rowHeights = new int[] { 259, 0, 0 };
		gbl_pgBonusAttaccoBasePanel.columnWeights = new double[] { 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_pgBonusAttaccoBasePanel.rowWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		this.setLayout(gbl_pgBonusAttaccoBasePanel);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		this.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 19, 48, 0 };
		gbl_panel.rowHeights = new int[] { 40, 40, 40, 40, 40, 40, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		VerticalLabel lblBonusAttaccoBase = new VerticalLabel(
				"Bonus Attacco Base Classi");
		lblBonusAttaccoBase.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBonusAttaccoBase.setRotation(VerticalLabel.ROTATE_LEFT);
		GridBagConstraints gbc_lblBonusAttaccoBase = new GridBagConstraints();
		gbc_lblBonusAttaccoBase.gridheight = 6;
		gbc_lblBonusAttaccoBase.insets = new Insets(0, 0, 0, 5);
		gbc_lblBonusAttaccoBase.gridx = 0;
		gbc_lblBonusAttaccoBase.gridy = 0;
		panel.add(lblBonusAttaccoBase, gbc_lblBonusAttaccoBase);

		lblA = new JLabel("A");
		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.insets = new Insets(0, 0, 5, 5);
		gbc_lblA.gridx = 1;
		gbc_lblA.gridy = 0;
		panel.add(lblA, gbc_lblA);

		formattedTextFieldBabClasse1 = new JFormattedTextField(soloNumeri);
		formattedTextFieldBabClasse1.setEnabled(false);
		formattedTextFieldBabClasse1.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldBabClasse1 = new GridBagConstraints();
		gbc_formattedTextFieldBabClasse1.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldBabClasse1.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldBabClasse1.gridx = 2;
		gbc_formattedTextFieldBabClasse1.gridy = 0;
		panel.add(formattedTextFieldBabClasse1,
				gbc_formattedTextFieldBabClasse1);

		lblB = new JLabel("B");
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblB = new GridBagConstraints();
		gbc_lblB.insets = new Insets(0, 0, 5, 5);
		gbc_lblB.gridx = 1;
		gbc_lblB.gridy = 1;
		panel.add(lblB, gbc_lblB);

		formattedTextFieldBabClasse2 = new JFormattedTextField(soloNumeri);
		formattedTextFieldBabClasse2.setEnabled(false);
		formattedTextFieldBabClasse2.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldBabClasse2 = new GridBagConstraints();
		gbc_formattedTextFieldBabClasse2.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldBabClasse2.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldBabClasse2.gridx = 2;
		gbc_formattedTextFieldBabClasse2.gridy = 1;
		panel.add(formattedTextFieldBabClasse2,
				gbc_formattedTextFieldBabClasse2);

		lblC = new JLabel("C");
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblC = new GridBagConstraints();
		gbc_lblC.insets = new Insets(0, 0, 5, 5);
		gbc_lblC.gridx = 1;
		gbc_lblC.gridy = 2;
		panel.add(lblC, gbc_lblC);

		formattedTextFieldBabClasse3 = new JFormattedTextField(soloNumeri);
		formattedTextFieldBabClasse3.setEnabled(false);
		formattedTextFieldBabClasse3.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldBabClasse3 = new GridBagConstraints();
		gbc_formattedTextFieldBabClasse3.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldBabClasse3.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldBabClasse3.gridx = 2;
		gbc_formattedTextFieldBabClasse3.gridy = 2;
		panel.add(formattedTextFieldBabClasse3,
				gbc_formattedTextFieldBabClasse3);

		lblD = new JLabel("D");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblD = new GridBagConstraints();
		gbc_lblD.insets = new Insets(0, 0, 5, 5);
		gbc_lblD.gridx = 1;
		gbc_lblD.gridy = 3;
		panel.add(lblD, gbc_lblD);

		formattedTextFieldBabClasse4 = new JFormattedTextField(soloNumeri);
		formattedTextFieldBabClasse4.setEnabled(false);
		formattedTextFieldBabClasse4.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldBabClasse4 = new GridBagConstraints();
		gbc_formattedTextFieldBabClasse4.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldBabClasse4.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldBabClasse4.gridx = 2;
		gbc_formattedTextFieldBabClasse4.gridy = 3;
		panel.add(formattedTextFieldBabClasse4,
				gbc_formattedTextFieldBabClasse4);

		lblE = new JLabel("E");
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblE = new GridBagConstraints();
		gbc_lblE.insets = new Insets(0, 0, 5, 5);
		gbc_lblE.gridx = 1;
		gbc_lblE.gridy = 4;
		panel.add(lblE, gbc_lblE);

		formattedTextFieldBabClasse5 = new JFormattedTextField(soloNumeri);
		formattedTextFieldBabClasse5.setEnabled(false);
		formattedTextFieldBabClasse5.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldBabClasse5 = new GridBagConstraints();
		gbc_formattedTextFieldBabClasse5.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldBabClasse5.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldBabClasse5.gridx = 2;
		gbc_formattedTextFieldBabClasse5.gridy = 4;
		panel.add(formattedTextFieldBabClasse5,
				gbc_formattedTextFieldBabClasse5);

		lblF = new JLabel("F");
		lblF.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblF = new GridBagConstraints();
		gbc_lblF.insets = new Insets(0, 0, 0, 5);
		gbc_lblF.gridx = 1;
		gbc_lblF.gridy = 5;
		panel.add(lblF, gbc_lblF);

		formattedTextFieldBabClasse6 = new JFormattedTextField(soloNumeri);
		formattedTextFieldBabClasse6.setEnabled(false);
		formattedTextFieldBabClasse6.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldBabClasse6 = new GridBagConstraints();
		gbc_formattedTextFieldBabClasse6.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldBabClasse6.gridx = 2;
		gbc_formattedTextFieldBabClasse6.gridy = 5;
		panel.add(formattedTextFieldBabClasse6,
				gbc_formattedTextFieldBabClasse6);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		this.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 130, 20, 60, 20, 60, 20, 60, 20,
				150, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 60, 0, 60, 0, 0, 0, 60, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblBonusAttaccoBase_1 = new JLabel("Bonus Attacco Base");
		GridBagConstraints gbc_lblBonusAttaccoBase_1 = new GridBagConstraints();
		gbc_lblBonusAttaccoBase_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblBonusAttaccoBase_1.gridx = 0;
		gbc_lblBonusAttaccoBase_1.gridy = 0;
		panel_1.add(lblBonusAttaccoBase_1, gbc_lblBonusAttaccoBase_1);

		lblTaglia = new JLabel("TAGLIA");
		GridBagConstraints gbc_lblTaglia = new GridBagConstraints();
		gbc_lblTaglia.insets = new Insets(0, 0, 5, 5);
		gbc_lblTaglia.gridx = 2;
		gbc_lblTaglia.gridy = 0;
		panel_1.add(lblTaglia, gbc_lblTaglia);

		lblForza = new JLabel("FORZA");
		GridBagConstraints gbc_lblForza = new GridBagConstraints();
		gbc_lblForza.insets = new Insets(0, 0, 5, 5);
		gbc_lblForza.gridx = 4;
		gbc_lblForza.gridy = 0;
		panel_1.add(lblForza, gbc_lblForza);

		lblAltro = new JLabel("ALTRO");
		GridBagConstraints gbc_lblAltro = new GridBagConstraints();
		gbc_lblAltro.insets = new Insets(0, 0, 5, 5);
		gbc_lblAltro.gridx = 6;
		gbc_lblAltro.gridy = 0;
		panel_1.add(lblAltro, gbc_lblAltro);

		lblBonusAttaccoMischia = new JLabel("BONUS ATTACCO ");
		GridBagConstraints gbc_lblBonusAttaccoMischia = new GridBagConstraints();
		gbc_lblBonusAttaccoMischia.insets = new Insets(0, 0, 5, 0);
		gbc_lblBonusAttaccoMischia.gridx = 8;
		gbc_lblBonusAttaccoMischia.gridy = 0;
		panel_1.add(lblBonusAttaccoMischia, gbc_lblBonusAttaccoMischia);

		textAreaBab = new JTextArea();
		textAreaBab.setBackground(UIManager
				.getColor("TextField.disabledBackground"));
		textAreaBab.setBorder(UIManager.getBorder("TextField.border"));
		textAreaBab.setEnabled(false);
		textAreaBab.setEditable(false);
		textAreaBab.setLineWrap(true);
		textAreaBab.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_textAreaBab = new GridBagConstraints();
		gbc_textAreaBab.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaBab.fill = GridBagConstraints.BOTH;
		gbc_textAreaBab.gridx = 0;
		gbc_textAreaBab.gridy = 1;
		panel_1.add(textAreaBab, gbc_textAreaBab);

		label_3 = new JLabel("+");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 1;
		panel_1.add(label_3, gbc_label_3);

		formattedTextFieldMischiaTaglia = new JFormattedTextField(soloNumeri);
		formattedTextFieldMischiaTaglia.setEnabled(false);
		formattedTextFieldMischiaTaglia.setEditable(false);
		formattedTextFieldMischiaTaglia.addFocusListener(this);
		formattedTextFieldMischiaTaglia
				.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_formattedTextFieldMischiaTaglia = new GridBagConstraints();
		gbc_formattedTextFieldMischiaTaglia.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldMischiaTaglia.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldMischiaTaglia.gridx = 2;
		gbc_formattedTextFieldMischiaTaglia.gridy = 1;
		panel_1.add(formattedTextFieldMischiaTaglia,
				gbc_formattedTextFieldMischiaTaglia);

		label_4 = new JLabel("+");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 1;
		panel_1.add(label_4, gbc_label_4);

		formattedTextFieldMischiaForza = new JFormattedTextField(soloNumeri);
		formattedTextFieldMischiaForza
				.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldMischiaForza.setEditable(false);
		formattedTextFieldMischiaForza.setEnabled(false);
		GridBagConstraints gbc_formattedTextFieldMischiaForza = new GridBagConstraints();
		gbc_formattedTextFieldMischiaForza.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldMischiaForza.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldMischiaForza.gridx = 4;
		gbc_formattedTextFieldMischiaForza.gridy = 1;
		panel_1.add(formattedTextFieldMischiaForza,
				gbc_formattedTextFieldMischiaForza);

		label_5 = new JLabel("+");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 5;
		gbc_label_5.gridy = 1;
		panel_1.add(label_5, gbc_label_5);

		formattedTextFieldMischiaAltro = new JFormattedTextField(soloNumeri);
		formattedTextFieldMischiaAltro.setEnabled(false);
		formattedTextFieldMischiaAltro.setEditable(false);
		formattedTextFieldMischiaAltro
				.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldMischiaAltro.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldMischiaAltro = new GridBagConstraints();
		gbc_formattedTextFieldMischiaAltro.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldMischiaAltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldMischiaAltro.gridx = 6;
		gbc_formattedTextFieldMischiaAltro.gridy = 1;
		panel_1.add(formattedTextFieldMischiaAltro,
				gbc_formattedTextFieldMischiaAltro);

		label_6 = new JLabel("=");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 7;
		gbc_label_6.gridy = 1;
		panel_1.add(label_6, gbc_label_6);

		textAreaMischiaTotale = new JTextArea();
		textAreaMischiaTotale.setBackground(UIManager
				.getColor("TextField.disabledBackground"));
		textAreaMischiaTotale
				.setBorder(UIManager.getBorder("TextField.border"));
		textAreaMischiaTotale.setEnabled(false);
		textAreaMischiaTotale.setEditable(false);
		textAreaMischiaTotale.setLineWrap(true);
		textAreaMischiaTotale.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_textAreaMischiaTotale = new GridBagConstraints();
		gbc_textAreaMischiaTotale.insets = new Insets(0, 0, 5, 0);
		gbc_textAreaMischiaTotale.fill = GridBagConstraints.BOTH;
		gbc_textAreaMischiaTotale.gridx = 8;
		gbc_textAreaMischiaTotale.gridy = 1;
		panel_1.add(textAreaMischiaTotale, gbc_textAreaMischiaTotale);

		label = new JLabel("+");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		panel_1.add(label, gbc_label);

		formattedTextFieldLottareTaglia = new JFormattedTextField(soloNumeri);
		formattedTextFieldLottareTaglia.setEnabled(false);
		formattedTextFieldLottareTaglia.setEditable(false);
		formattedTextFieldLottareTaglia.addFocusListener(this);
		formattedTextFieldLottareTaglia
				.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_formattedTextFieldLottareTaglia = new GridBagConstraints();
		gbc_formattedTextFieldLottareTaglia.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldLottareTaglia.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldLottareTaglia.gridx = 0;
		gbc_formattedTextFieldLottareTaglia.gridy = 3;
		panel_1.add(formattedTextFieldLottareTaglia,
				gbc_formattedTextFieldLottareTaglia);

		label_10 = new JLabel("<-");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 1;
		gbc_label_10.gridy = 3;
		panel_1.add(label_10, gbc_label_10);

		lbltagliaspeciale = new JLabel(
				"<html><center>TAGLIA<br>SPECIALE</center></html>");
		GridBagConstraints gbc_lbltagliaspeciale = new GridBagConstraints();
		gbc_lbltagliaspeciale.insets = new Insets(0, 0, 5, 5);
		gbc_lbltagliaspeciale.gridx = 2;
		gbc_lbltagliaspeciale.gridy = 3;
		panel_1.add(lbltagliaspeciale, gbc_lbltagliaspeciale);

		formattedTextFieldDistanzaDestrezza = new JFormattedTextField(
				soloNumeri);
		formattedTextFieldDistanzaDestrezza.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldDistanzaDestrezza.setEditable(false);
		formattedTextFieldDistanzaDestrezza.setEnabled(false);
		GridBagConstraints gbc_formattedTextFieldDistanzaDestrezza = new GridBagConstraints();
		gbc_formattedTextFieldDistanzaDestrezza.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldDistanzaDestrezza.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldDistanzaDestrezza.gridx = 4;
		gbc_formattedTextFieldDistanzaDestrezza.gridy = 3;
		panel_1.add(formattedTextFieldDistanzaDestrezza,
				gbc_formattedTextFieldDistanzaDestrezza);

		label_7 = new JLabel("+");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 5;
		gbc_label_7.gridy = 3;
		panel_1.add(label_7, gbc_label_7);

		formattedTextFieldDistanzaAltro = new JFormattedTextField(soloNumeri);
		formattedTextFieldDistanzaAltro.setEnabled(false);
		formattedTextFieldDistanzaAltro.setEditable(false);
		formattedTextFieldDistanzaAltro.addFocusListener(this);
		formattedTextFieldDistanzaAltro
				.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_formattedTextFieldDistanzaAltro = new GridBagConstraints();
		gbc_formattedTextFieldDistanzaAltro.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldDistanzaAltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldDistanzaAltro.gridx = 6;
		gbc_formattedTextFieldDistanzaAltro.gridy = 3;
		panel_1.add(formattedTextFieldDistanzaAltro,
				gbc_formattedTextFieldDistanzaAltro);

		label_8 = new JLabel("=");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 7;
		gbc_label_8.gridy = 3;
		panel_1.add(label_8, gbc_label_8);

		textAreaDistanzaTotale = new JTextArea();
		textAreaDistanzaTotale.setBackground(UIManager
				.getColor("TextField.disabledBackground"));
		textAreaDistanzaTotale.setBorder(UIManager
				.getBorder("TextField.border"));
		textAreaDistanzaTotale.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textAreaDistanzaTotale.setEnabled(false);
		textAreaDistanzaTotale.setEditable(false);
		textAreaDistanzaTotale.setRows(1);
		textAreaDistanzaTotale.setLineWrap(true);
		GridBagConstraints gbc_textAreaDistanzaTotale = new GridBagConstraints();
		gbc_textAreaDistanzaTotale.insets = new Insets(0, 0, 5, 0);
		gbc_textAreaDistanzaTotale.fill = GridBagConstraints.BOTH;
		gbc_textAreaDistanzaTotale.gridx = 8;
		gbc_textAreaDistanzaTotale.gridy = 3;
		panel_1.add(textAreaDistanzaTotale, gbc_textAreaDistanzaTotale);

		label_1 = new JLabel("+");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 4;
		panel_1.add(label_1, gbc_label_1);

		lblDestrezza = new JLabel("DESTREZZA");
		lblDestrezza.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblDestrezza = new GridBagConstraints();
		gbc_lblDestrezza.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestrezza.gridx = 4;
		gbc_lblDestrezza.gridy = 4;
		panel_1.add(lblDestrezza, gbc_lblDestrezza);

		lblBonusAttaccoDistanza = new JLabel("BONUS ATTACCO DISTANZA");
		GridBagConstraints gbc_lblBonusAttaccoDistanza = new GridBagConstraints();
		gbc_lblBonusAttaccoDistanza.insets = new Insets(0, 0, 5, 0);
		gbc_lblBonusAttaccoDistanza.gridx = 8;
		gbc_lblBonusAttaccoDistanza.gridy = 4;
		panel_1.add(lblBonusAttaccoDistanza, gbc_lblBonusAttaccoDistanza);

		formattedTextFieldLottareForza = new JFormattedTextField(soloNumeri);
		formattedTextFieldLottareForza.setEnabled(false);
		formattedTextFieldLottareForza.setEditable(false);
		formattedTextFieldLottareForza
				.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_formattedTextFieldLottareForza = new GridBagConstraints();
		gbc_formattedTextFieldLottareForza.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldLottareForza.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldLottareForza.gridx = 0;
		gbc_formattedTextFieldLottareForza.gridy = 5;
		panel_1.add(formattedTextFieldLottareForza,
				gbc_formattedTextFieldLottareForza);

		label_9 = new JLabel("<-");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 1;
		gbc_label_9.gridy = 5;
		panel_1.add(label_9, gbc_label_9);

		lblForza_1 = new JLabel("FORZA");
		GridBagConstraints gbc_lblForza_1 = new GridBagConstraints();
		gbc_lblForza_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblForza_1.gridx = 2;
		gbc_lblForza_1.gridy = 5;
		panel_1.add(lblForza_1, gbc_lblForza_1);

		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 3;
		gbc_panel_2.gridwidth = 3;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 6;
		gbc_panel_2.gridy = 5;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 100, 100, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		lblPenalitACombattere = new JLabel(
				"Penalit\u00E0 al combattere con 2 armi");
		GridBagConstraints gbc_lblPenalitACombattere = new GridBagConstraints();
		gbc_lblPenalitACombattere.gridwidth = 2;
		gbc_lblPenalitACombattere.insets = new Insets(0, 0, 5, 0);
		gbc_lblPenalitACombattere.gridx = 0;
		gbc_lblPenalitACombattere.gridy = 0;
		panel_2.add(lblPenalitACombattere, gbc_lblPenalitACombattere);

		formattedTextFieldPenalità2ArmiPrimaria = new JFormattedTextField(
				soloNumeriConSegno);
		formattedTextFieldPenalità2ArmiPrimaria.setEnabled(false);
		formattedTextFieldPenalità2ArmiPrimaria.setEditable(false);
		formattedTextFieldPenalità2ArmiPrimaria.addFocusListener(this);
		formattedTextFieldPenalità2ArmiPrimaria
				.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_formattedTextFieldPenalità2ArmiPrimaria = new GridBagConstraints();
		gbc_formattedTextFieldPenalità2ArmiPrimaria.insets = new Insets(0, 0,
				5, 5);
		gbc_formattedTextFieldPenalità2ArmiPrimaria.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldPenalità2ArmiPrimaria.gridx = 0;
		gbc_formattedTextFieldPenalità2ArmiPrimaria.gridy = 1;
		panel_2.add(formattedTextFieldPenalità2ArmiPrimaria,
				gbc_formattedTextFieldPenalità2ArmiPrimaria);

		formattedTextFieldPenalità2ArmiSecondaria = new JFormattedTextField(
				soloNumeriConSegno);
		formattedTextFieldPenalità2ArmiSecondaria.setEnabled(false);
		formattedTextFieldPenalità2ArmiSecondaria.setEditable(false);
		formattedTextFieldPenalità2ArmiSecondaria.addFocusListener(this);
		formattedTextFieldPenalità2ArmiSecondaria
				.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_formattedTextFieldPenalità2ArmiSecondaria = new GridBagConstraints();
		gbc_formattedTextFieldPenalità2ArmiSecondaria.insets = new Insets(0, 0,
				5, 0);
		gbc_formattedTextFieldPenalità2ArmiSecondaria.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldPenalità2ArmiSecondaria.gridx = 1;
		gbc_formattedTextFieldPenalità2ArmiSecondaria.gridy = 1;
		panel_2.add(formattedTextFieldPenalità2ArmiSecondaria,
				gbc_formattedTextFieldPenalità2ArmiSecondaria);

		lblPrimaria = new JLabel("PRIMARIA");
		GridBagConstraints gbc_lblPrimaria = new GridBagConstraints();
		gbc_lblPrimaria.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimaria.gridx = 0;
		gbc_lblPrimaria.gridy = 2;
		panel_2.add(lblPrimaria, gbc_lblPrimaria);

		lblSecondaria = new JLabel("SECONDARIA");
		GridBagConstraints gbc_lblSecondaria = new GridBagConstraints();
		gbc_lblSecondaria.insets = new Insets(0, 0, 5, 0);
		gbc_lblSecondaria.gridx = 1;
		gbc_lblSecondaria.gridy = 2;
		panel_2.add(lblSecondaria, gbc_lblSecondaria);
		
		chckbxTalentoCombattereA2Armi = new JCheckBox("Talento Combattere a 2 Armi");
		chckbxTalentoCombattereA2Armi.addActionListener(this);
		GridBagConstraints gbc_chckbxTalentoCombattereA2Armi = new GridBagConstraints();
		gbc_chckbxTalentoCombattereA2Armi.gridwidth = 2;
		gbc_chckbxTalentoCombattereA2Armi.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxTalentoCombattereA2Armi.gridx = 0;
		gbc_chckbxTalentoCombattereA2Armi.gridy = 3;
		panel_2.add(chckbxTalentoCombattereA2Armi, gbc_chckbxTalentoCombattereA2Armi);

		label_2 = new JLabel("=");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 6;
		panel_1.add(label_2, gbc_label_2);

		textAreaLottareTotale = new JTextArea();
		textAreaLottareTotale.setBorder(UIManager.getBorder("TextField.border"));
		textAreaLottareTotale.setBackground(UIManager.getColor("TextField.disabledBackground"));
		textAreaLottareTotale.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textAreaLottareTotale.setLineWrap(true);
		textAreaLottareTotale.setEnabled(false);
		textAreaLottareTotale.setEditable(false);
		GridBagConstraints gbc_textAreaLottareTotale = new GridBagConstraints();
		gbc_textAreaLottareTotale.insets = new Insets(0, 0, 0, 5);
		gbc_textAreaLottareTotale.fill = GridBagConstraints.BOTH;
		gbc_textAreaLottareTotale.gridx = 0;
		gbc_textAreaLottareTotale.gridy = 7;
		panel_1.add(textAreaLottareTotale, gbc_textAreaLottareTotale);
		
		label_12 = new JLabel("<-");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 0, 5);
		gbc_label_12.gridx = 1;
		gbc_label_12.gridy = 7;
		panel_1.add(label_12, gbc_label_12);
		
		lblLottare = new JLabel("LOTTARE");
		GridBagConstraints gbc_lblLottare = new GridBagConstraints();
		gbc_lblLottare.insets = new Insets(0, 0, 0, 5);
		gbc_lblLottare.gridx = 2;
		gbc_lblLottare.gridy = 7;
		panel_1.add(lblLottare, gbc_lblLottare);

		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 2;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		this.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 40, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		lblNewLabel = new JLabel("TABELLA ATTACCHI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);

		lblAttacco = new JLabel("1\u00B0 Attacco: ");
		GridBagConstraints gbc_lblAttacco = new GridBagConstraints();
		gbc_lblAttacco.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttacco.gridx = 0;
		gbc_lblAttacco.gridy = 1;
		panel_3.add(lblAttacco, gbc_lblAttacco);

		formattedTextFieldAttaccoBase1 = new JFormattedTextField(
				soloNumeriConSegno);
		formattedTextFieldAttaccoBase1.setEnabled(false);
		formattedTextFieldAttaccoBase1.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldAttaccoBase1 = new GridBagConstraints();
		gbc_formattedTextFieldAttaccoBase1.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldAttaccoBase1.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldAttaccoBase1.gridx = 1;
		gbc_formattedTextFieldAttaccoBase1.gridy = 1;
		panel_3.add(formattedTextFieldAttaccoBase1,
				gbc_formattedTextFieldAttaccoBase1);

		lblAttacco_1 = new JLabel("2\u00B0 Attacco:");
		GridBagConstraints gbc_lblAttacco_1 = new GridBagConstraints();
		gbc_lblAttacco_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttacco_1.gridx = 0;
		gbc_lblAttacco_1.gridy = 2;
		panel_3.add(lblAttacco_1, gbc_lblAttacco_1);

		formattedTextFieldAttaccoBase2 = new JFormattedTextField(
				soloNumeriConSegno);
		formattedTextFieldAttaccoBase2.setEnabled(false);
		formattedTextFieldAttaccoBase2.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldAttaccoBase2 = new GridBagConstraints();
		gbc_formattedTextFieldAttaccoBase2.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldAttaccoBase2.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldAttaccoBase2.gridx = 1;
		gbc_formattedTextFieldAttaccoBase2.gridy = 2;
		panel_3.add(formattedTextFieldAttaccoBase2,
				gbc_formattedTextFieldAttaccoBase2);

		lblAttacco_2 = new JLabel("3\u00B0 Attacco:");
		GridBagConstraints gbc_lblAttacco_2 = new GridBagConstraints();
		gbc_lblAttacco_2.anchor = GridBagConstraints.EAST;
		gbc_lblAttacco_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttacco_2.gridx = 0;
		gbc_lblAttacco_2.gridy = 3;
		panel_3.add(lblAttacco_2, gbc_lblAttacco_2);

		formattedTextFieldAttaccoBase3 = new JFormattedTextField(
				soloNumeriConSegno);
		formattedTextFieldAttaccoBase3.setEnabled(false);
		formattedTextFieldAttaccoBase3.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldAttaccoBase3 = new GridBagConstraints();
		gbc_formattedTextFieldAttaccoBase3.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldAttaccoBase3.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldAttaccoBase3.gridx = 1;
		gbc_formattedTextFieldAttaccoBase3.gridy = 3;
		panel_3.add(formattedTextFieldAttaccoBase3,
				gbc_formattedTextFieldAttaccoBase3);

		lblAttacco_3 = new JLabel("4\u00B0 Attacco:");
		GridBagConstraints gbc_lblAttacco_3 = new GridBagConstraints();
		gbc_lblAttacco_3.anchor = GridBagConstraints.EAST;
		gbc_lblAttacco_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttacco_3.gridx = 0;
		gbc_lblAttacco_3.gridy = 4;
		panel_3.add(lblAttacco_3, gbc_lblAttacco_3);

		formattedTextFieldAttaccoBase4 = new JFormattedTextField(
				soloNumeriConSegno);
		formattedTextFieldAttaccoBase4.setEnabled(false);
		formattedTextFieldAttaccoBase4.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldAttaccoBase4 = new GridBagConstraints();
		gbc_formattedTextFieldAttaccoBase4.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldAttaccoBase4.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldAttaccoBase4.gridx = 1;
		gbc_formattedTextFieldAttaccoBase4.gridy = 4;
		panel_3.add(formattedTextFieldAttaccoBase4,
				gbc_formattedTextFieldAttaccoBase4);

		lblAttacco_4 = new JLabel("5\u00B0 Attacco:");
		GridBagConstraints gbc_lblAttacco_4 = new GridBagConstraints();
		gbc_lblAttacco_4.anchor = GridBagConstraints.EAST;
		gbc_lblAttacco_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttacco_4.gridx = 0;
		gbc_lblAttacco_4.gridy = 5;
		panel_3.add(lblAttacco_4, gbc_lblAttacco_4);

		formattedTextFieldAttaccoBase5 = new JFormattedTextField(
				soloNumeriConSegno);
		formattedTextFieldAttaccoBase5.setEnabled(false);
		formattedTextFieldAttaccoBase5.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldAttaccoBase5 = new GridBagConstraints();
		gbc_formattedTextFieldAttaccoBase5.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldAttaccoBase5.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldAttaccoBase5.gridx = 1;
		gbc_formattedTextFieldAttaccoBase5.gridy = 5;
		panel_3.add(formattedTextFieldAttaccoBase5,
				gbc_formattedTextFieldAttaccoBase5);

		lblAttacco_5 = new JLabel("6\u00B0 Attacco:");
		GridBagConstraints gbc_lblAttacco_5 = new GridBagConstraints();
		gbc_lblAttacco_5.anchor = GridBagConstraints.EAST;
		gbc_lblAttacco_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttacco_5.gridx = 0;
		gbc_lblAttacco_5.gridy = 6;
		panel_3.add(lblAttacco_5, gbc_lblAttacco_5);

		formattedTextFieldAttaccoBase6 = new JFormattedTextField(
				soloNumeriConSegno);
		formattedTextFieldAttaccoBase6.setEnabled(false);
		formattedTextFieldAttaccoBase6.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldAttaccoBase6 = new GridBagConstraints();
		gbc_formattedTextFieldAttaccoBase6.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldAttaccoBase6.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldAttaccoBase6.gridx = 1;
		gbc_formattedTextFieldAttaccoBase6.gridy = 6;
		panel_3.add(formattedTextFieldAttaccoBase6,
				gbc_formattedTextFieldAttaccoBase6);

		lblAttacco_6 = new JLabel("7\u00B0 Attacco:");
		GridBagConstraints gbc_lblAttacco_6 = new GridBagConstraints();
		gbc_lblAttacco_6.anchor = GridBagConstraints.EAST;
		gbc_lblAttacco_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttacco_6.gridx = 0;
		gbc_lblAttacco_6.gridy = 7;
		panel_3.add(lblAttacco_6, gbc_lblAttacco_6);

		formattedTextFieldAttaccoBase7 = new JFormattedTextField(
				soloNumeriConSegno);
		formattedTextFieldAttaccoBase7.setEnabled(false);
		formattedTextFieldAttaccoBase7.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldAttaccoBase7 = new GridBagConstraints();
		gbc_formattedTextFieldAttaccoBase7.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldAttaccoBase7.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldAttaccoBase7.gridx = 1;
		gbc_formattedTextFieldAttaccoBase7.gridy = 7;
		panel_3.add(formattedTextFieldAttaccoBase7,
				gbc_formattedTextFieldAttaccoBase7);

		lblAttacco_7 = new JLabel("8\u00B0 Attacco:");
		GridBagConstraints gbc_lblAttacco_7 = new GridBagConstraints();
		gbc_lblAttacco_7.anchor = GridBagConstraints.EAST;
		gbc_lblAttacco_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblAttacco_7.gridx = 0;
		gbc_lblAttacco_7.gridy = 8;
		panel_3.add(lblAttacco_7, gbc_lblAttacco_7);

		formattedTextFieldAttaccoBase8 = new JFormattedTextField(
				soloNumeriConSegno);
		formattedTextFieldAttaccoBase8.setEnabled(false);
		formattedTextFieldAttaccoBase8.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldAttaccoBase8 = new GridBagConstraints();
		gbc_formattedTextFieldAttaccoBase8.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldAttaccoBase8.gridx = 1;
		gbc_formattedTextFieldAttaccoBase8.gridy = 8;
		panel_3.add(formattedTextFieldAttaccoBase8,
				gbc_formattedTextFieldAttaccoBase8);

		panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 1;
		add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		lblNote = new JLabel("Note");
		lblNote.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNote = new GridBagConstraints();
		gbc_lblNote.anchor = GridBagConstraints.WEST;
		gbc_lblNote.insets = new Insets(0, 0, 5, 0);
		gbc_lblNote.gridx = 0;
		gbc_lblNote.gridy = 0;
		panel_4.add(lblNote, gbc_lblNote);

		textPaneNote = new JTextPane();
		textPaneNote.setBorder(UIManager.getBorder("TextField.border"));
		textPaneNote.setBackground(Color.WHITE);
		textPaneNote.addFocusListener(this);
		GridBagConstraints gbc_textPaneNote = new GridBagConstraints();
		gbc_textPaneNote.insets = new Insets(0, 0, 0, 5);
		gbc_textPaneNote.fill = GridBagConstraints.BOTH;
		gbc_textPaneNote.gridx = 0;
		gbc_textPaneNote.gridy = 1;
		panel_4.add(textPaneNote, gbc_textPaneNote);

	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {
		
		//Salvataggio dell'oggetto nella classe per giri successivi (chiamati da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		
		// TODO Popolamento scheda "Bonus Attacco Base"
		PgBabObj pgBabObj = new PgBabObj();
		pgBabObj = pgDatiObj.getPgBabObj();

		formattedTextFieldBabClasse1.setValue(pgBabObj.getBabClasse1());
		formattedTextFieldBabClasse2.setValue(pgBabObj.getBabClasse2());
		formattedTextFieldBabClasse3.setValue(pgBabObj.getBabClasse3());
		formattedTextFieldBabClasse4.setValue(pgBabObj.getBabClasse4());
		formattedTextFieldBabClasse5.setValue(pgBabObj.getBabClasse5());
		formattedTextFieldBabClasse6.setValue(pgBabObj.getBabClasse6());
		textAreaBab.setText(pgBabObj.getBab());
		formattedTextFieldLottareTaglia.setValue(pgBabObj.getLottareTaglia());
		formattedTextFieldLottareForza.setValue(pgBabObj.getLottareForza());
		textAreaLottareTotale.setText(pgBabObj.getLottareTotale());
		formattedTextFieldMischiaTaglia.setValue(pgBabObj.getMischiaTaglia());
		formattedTextFieldMischiaForza.setValue(pgBabObj.getMischiaForza());
		formattedTextFieldMischiaAltro.setValue(pgBabObj.getMischiaAltro());
		textAreaDistanzaTotale.setText(pgBabObj.getDistanzaTotale());
		textAreaMischiaTotale.setText(pgBabObj.getMischiaTotale());
		formattedTextFieldDistanzaDestrezza.setValue(pgBabObj
				.getDistanzaDestrezza());
		formattedTextFieldDistanzaAltro.setValue(pgBabObj.getDistanzaAltro());
		formattedTextFieldPenalità2ArmiPrimaria.setValue(pgBabObj
				.getPenalità2ArmiPrimaria());
		formattedTextFieldPenalità2ArmiSecondaria.setValue(pgBabObj
				.getPenalità2ArmiSecondaria());
		formattedTextFieldAttaccoBase1.setValue(pgBabObj.getAttaccoBase1());
		formattedTextFieldAttaccoBase2.setValue(pgBabObj.getAttaccoBase2());
		formattedTextFieldAttaccoBase3.setValue(pgBabObj.getAttaccoBase3());
		formattedTextFieldAttaccoBase4.setValue(pgBabObj.getAttaccoBase4());
		formattedTextFieldAttaccoBase5.setValue(pgBabObj.getAttaccoBase5());
		formattedTextFieldAttaccoBase6.setValue(pgBabObj.getAttaccoBase6());
		formattedTextFieldAttaccoBase7.setValue(pgBabObj.getAttaccoBase7());
		formattedTextFieldAttaccoBase8.setValue(pgBabObj.getAttaccoBase8());
		textPaneNote.setText(pgBabObj.getNote());

	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();

		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldMischiaTaglia) {
				pgDatiObj = aggiornaOggetti.aggiornaBab(pgDatiObj,
						ListaPgBab.MISCHIA_TAGLIA,
						formattedTextFieldMischiaTaglia.getText());
				if (pgDatiObj.getPgBabObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldMischiaAltro) {
				pgDatiObj = aggiornaOggetti.aggiornaBab(pgDatiObj,
						ListaPgBab.MISCHIA_ALTRO,
						formattedTextFieldMischiaAltro.getText());
				if (pgDatiObj.getPgBabObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldDistanzaAltro) {
				pgDatiObj = aggiornaOggetti.aggiornaBab(pgDatiObj,
						ListaPgBab.DISTANZA_ALTRO,
						formattedTextFieldDistanzaAltro.getText());
				if (pgDatiObj.getPgBabObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldLottareTaglia) {
				pgDatiObj = aggiornaOggetti.aggiornaBab(pgDatiObj,
						ListaPgBab.LOTTARE_TAGLIA,
						formattedTextFieldLottareTaglia.getText());
				if (pgDatiObj.getPgBabObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldPenalità2ArmiPrimaria) {
				pgDatiObj = aggiornaOggetti.aggiornaBab(pgDatiObj,
						ListaPgBab.PENALITÀ_2ARMI_PRIMARIA,
						formattedTextFieldPenalità2ArmiPrimaria.getText());
				if (pgDatiObj.getPgBabObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldPenalità2ArmiSecondaria) {
				pgDatiObj = aggiornaOggetti.aggiornaBab(pgDatiObj,
						ListaPgBab.PENALITÀ_2ARMI_SECONDARIA,
						formattedTextFieldPenalità2ArmiSecondaria.getText());
				if (pgDatiObj.getPgBabObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
		}
		if (component instanceof JTextPane) {
			if ((JTextPane) component == textPaneNote) {
				pgDatiObj = aggiornaOggetti.aggiornaBab(pgDatiObj,
						ListaPgBab.NOTE, textPaneNote.getText());
				if (pgDatiObj.getPgBabObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
		}

		textPaneNote = new JTextPane();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JCheckBox) {
			if (((JCheckBox) oggetto).getActionCommand() == chckbxTalentoCombattereA2Armi.getActionCommand()) {
				pgDatiObj = aggiornaOggetti.aggiornaBab(pgDatiObj, ListaPgBab.TALENTO_2_ARMI,
						Boolean.valueOf(chckbxTalentoCombattereA2Armi.isSelected()).toString());
				if (pgDatiObj.getPgBabObj().isDatiVariati()) {
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

	public PgDatiObj getPgDatiObj() {
		return pgDatiObj;
	}

	public void setPgDatiObj(PgDatiObj pgDatiObj) {
		this.pgDatiObj = pgDatiObj;
	}


}
