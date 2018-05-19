package gui.panel;

import gui.MainWindow;
import json.GestioneJsonOpzioni;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.NumberFormatter;

import Classi.Formati;
import cellRenderer.TextAreaRenderer;
import obj.OpzioniObj;
import obj.PgAbilitaObj;
import obj.PgArmiRiepilogoObj;
import obj.PgBabObj;
import obj.PgClasseArmaturaObj;
import obj.PgClasseObj;
import obj.PgDatiObj;
import obj.PgIniziativaObj;
import obj.PgPuntiFeritaObj;
import obj.PgStatisticheObj;
import obj.PgTalentiObj;
import obj.PgTiriSalvezzaObj;
import tableModels.PgAbilitaTableModel;
import tableModels.PgArmiRiepilogoTableModel;
import tableModels.PgClassiTableModel;
import tableModels.PgTalentiTableModel;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;

public class PgRiepilogoPanel extends JPanel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4704304511358885640L;
	private JTable tableClassi;
	Formati formati = new Formati();
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	OpzioniObj opzioniObj = new OpzioniObj();

	private MainWindow frame;
	private PgDatiObj pgDatiObj;
	private JFormattedTextField formattedTextFieldForzaMod;
	private JFormattedTextField formattedTextFieldForza;
	private JFormattedTextField formattedTextFieldDestrezza;
	private JFormattedTextField formattedTextFieldDestrezzaMod;
	private JFormattedTextField formattedTextFieldCostituzione;
	private JFormattedTextField formattedTextFieldCostituzioneMod;
	private JFormattedTextField formattedTextFieldIntelligenza;
	private JFormattedTextField formattedTextFieldIntelligenzaMod;
	private JFormattedTextField formattedTextFieldSaggezza;
	private JFormattedTextField formattedTextFieldSaggezzaMod;
	private JFormattedTextField formattedTextFieldCarisma;
	private JFormattedTextField formattedTextFieldCarismaMod;
	private JPanel panelPuntiFerita;
	private JLabel lblPuntiFerita;
	private JLabel lblPuntiFeritaTotali;
	private JFormattedTextField formattedTextFieldPuntiFeritaTotali;
	private JLabel lblPuntiFeritaRimanenti;
	private JFormattedTextField formattedTextFieldPuntiFeritaRimanenti;
	private JLabel lblFeriteAttuali;
	private JFormattedTextField formattedTextFieldFeriteAttuali;
	private JLabel lblDanniNonLetali;
	private JFormattedTextField formattedTextFieldDanniNonLetaliAttuali;
	private JPanel panelClasseArmatura;
	private JLabel lblClasseArmatura;
	private JLabel lblClasseArmaturaTotale;
	private JLabel lblCaColtoAlla;
	private JFormattedTextField formattedTextFieldCATotale;
	private JLabel lblCaAContatto;
	private JLabel lblFallimentoIncantesimiArcani;
	private JLabel lblPenalitProvaArmatura;
	private JFormattedTextField formattedTextFieldCAColtoAllaSprovvista;
	private JFormattedTextField formattedTextFieldCAContatto;
	private JFormattedTextField formattedTextFieldFallimentoIncantesimiArcani;
	private JFormattedTextField formattedTextFieldPenalitaProvaArmatura;
	private JPanel panelBab;
	private JLabel lblBab;
	private JLabel lblBab_1;
	private JLabel lblBabMischia;
	private JLabel lblBabDistanza;
	private JTextArea textAreaBab;
	private JTextArea textAreaBabMischia;
	private JTextArea textAreaBabDistanza;
	private JLabel lblLottare;
	private JTextArea textAreaBabLottare;
	private JPanel panelArmi;
	private JLabel lblIniziativa;
	private JFormattedTextField formattedTextFieldIniziativa;
	private JLabel lblTiriSalvezza;
	private JLabel lblTempra;
	private JFormattedTextField formattedTextFieldTempra;
	private JPanel panel_5;
	private JLabel lblRiflessi;
	private JFormattedTextField formattedTextFieldRiflessi;
	private JLabel lblVolont;
	private JFormattedTextField formattedTextFieldVolonta;
	private JLabel lblArmi;
	private JTable tableArmiRiepilogo;
	private JScrollPane scrollPaneArmi;
	private JPanel panelAbilita;
	private JLabel lblAbilita;
	private JTable tableAbilita;
	private JScrollPane scrollPaneAbilita;
	private JPanel panelTalenti;
	private JLabel lblTalenti;
	private JTable tableTalenti;
	private JScrollPane scrollPaneTalenti;

	/**
	 * Create the panel.
	 * 
	 * @param pgDatiObj
	 */
	public PgRiepilogoPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.pgDatiObj = pgDatiObj;

		NumberFormatter soloNumeri = formati.getSoloNumeri();
		NumberFormatter soloNumeriConSegno = formati.getSoloNumeriConSegno();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 385, 0 };
		gridBagLayout.rowHeights = new int[] { 224, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 161, 140, 235, 157, 0 };
		gbl_panel.rowHeights = new int[] { 0, 40, 0, 82, 61, 62, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblClassi = new JLabel("CLASSI");
		lblClassi.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblClassi = new GridBagConstraints();
		gbc_lblClassi.anchor = GridBagConstraints.WEST;
		gbc_lblClassi.gridwidth = 4;
		gbc_lblClassi.insets = new Insets(0, 0, 5, 0);
		gbc_lblClassi.gridx = 0;
		gbc_lblClassi.gridy = 0;
		panel.add(lblClassi, gbc_lblClassi);

		JScrollPane scrollPaneClassi = new JScrollPane();
		GridBagConstraints gbc_scrollPaneClassi = new GridBagConstraints();
		gbc_scrollPaneClassi.gridwidth = 4;
		gbc_scrollPaneClassi.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneClassi.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneClassi.gridx = 0;
		gbc_scrollPaneClassi.gridy = 1;
		panel.add(scrollPaneClassi, gbc_scrollPaneClassi);

		tableClassi = new JTable();
		tableClassi.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableClassi.setPreferredScrollableViewportSize(new Dimension(0, 0));
		tableClassi.setFillsViewportHeight(true);
		tableClassi.setBorder(null);
		tableClassi.setEnabled(false);
		PgClassiTableModel classiTableModel = new PgClassiTableModel();
		tableClassi.setModel(classiTableModel);
		scrollPaneClassi.setViewportView(tableClassi);
		TableColumnModel tcmClassi = tableClassi.getColumnModel();
		tcmClassi.removeColumn(tcmClassi.getColumn(6));
		tableClassi.getTableHeader().addMouseListener(this);
		tableClassi.getTableHeader().setReorderingAllowed(false);



		JPanel panelStatistiche = new JPanel();
		GridBagConstraints gbc_panelStatistiche = new GridBagConstraints();
		gbc_panelStatistiche.insets = new Insets(0, 0, 5, 5);
		gbc_panelStatistiche.fill = GridBagConstraints.BOTH;
		gbc_panelStatistiche.gridx = 0;
		gbc_panelStatistiche.gridy = 2;
		panel.add(panelStatistiche, gbc_panelStatistiche);
		GridBagLayout gbl_panelStatistiche = new GridBagLayout();
		gbl_panelStatistiche.columnWidths = new int[] { 0, 50, 50, 0 };
		gbl_panelStatistiche.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelStatistiche.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panelStatistiche.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelStatistiche.setLayout(gbl_panelStatistiche);
		
		JLabel lblStatistiche = new JLabel("STATISTICHE");
		lblStatistiche.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblStatistiche = new GridBagConstraints();
		gbc_lblStatistiche.gridwidth = 3;
		gbc_lblStatistiche.insets = new Insets(0, 0, 5, 0);
		gbc_lblStatistiche.gridx = 0;
		gbc_lblStatistiche.gridy = 0;
		panelStatistiche.add(lblStatistiche, gbc_lblStatistiche);

		JLabel lblFor = new JLabel("FOR");
		GridBagConstraints gbc_lblFor = new GridBagConstraints();
		gbc_lblFor.anchor = GridBagConstraints.EAST;
		gbc_lblFor.insets = new Insets(0, 0, 5, 5);
		gbc_lblFor.gridx = 0;
		gbc_lblFor.gridy = 1;
		panelStatistiche.add(lblFor, gbc_lblFor);
		lblFor.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		formattedTextFieldForza = new JFormattedTextField(soloNumeri);
		formattedTextFieldForza.setEnabled(false);
		formattedTextFieldForza.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldForza = new GridBagConstraints();
		gbc_formattedTextFieldForza.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldForza.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldForza.gridx = 1;
		gbc_formattedTextFieldForza.gridy = 1;
		panelStatistiche.add(formattedTextFieldForza, gbc_formattedTextFieldForza);
		
		formattedTextFieldForzaMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldForzaMod.setEnabled(false);
		formattedTextFieldForzaMod.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldForzaMod = new GridBagConstraints();
		gbc_formattedTextFieldForzaMod.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldForzaMod.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldForzaMod.gridx = 2;
		gbc_formattedTextFieldForzaMod.gridy = 1;
		panelStatistiche.add(formattedTextFieldForzaMod, gbc_formattedTextFieldForzaMod);
		
		JLabel lblDes = new JLabel("DES");
		lblDes.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblDes = new GridBagConstraints();
		gbc_lblDes.anchor = GridBagConstraints.EAST;
		gbc_lblDes.insets = new Insets(0, 0, 5, 5);
		gbc_lblDes.gridx = 0;
		gbc_lblDes.gridy = 2;
		panelStatistiche.add(lblDes, gbc_lblDes);
		
		formattedTextFieldDestrezza = new JFormattedTextField(soloNumeri);
		formattedTextFieldDestrezza.setEnabled(false);
		formattedTextFieldDestrezza.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldDestrezza = new GridBagConstraints();
		gbc_formattedTextFieldDestrezza.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldDestrezza.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldDestrezza.gridx = 1;
		gbc_formattedTextFieldDestrezza.gridy = 2;
		panelStatistiche.add(formattedTextFieldDestrezza, gbc_formattedTextFieldDestrezza);
		
		formattedTextFieldDestrezzaMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldDestrezzaMod.setEnabled(false);
		formattedTextFieldDestrezzaMod.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldDestrezzaMod = new GridBagConstraints();
		gbc_formattedTextFieldDestrezzaMod.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldDestrezzaMod.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldDestrezzaMod.gridx = 2;
		gbc_formattedTextFieldDestrezzaMod.gridy = 2;
		panelStatistiche.add(formattedTextFieldDestrezzaMod, gbc_formattedTextFieldDestrezzaMod);
		
		JLabel lblCos = new JLabel("COS");
		lblCos.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblCos = new GridBagConstraints();
		gbc_lblCos.anchor = GridBagConstraints.EAST;
		gbc_lblCos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCos.gridx = 0;
		gbc_lblCos.gridy = 3;
		panelStatistiche.add(lblCos, gbc_lblCos);
		
		formattedTextFieldCostituzione = new JFormattedTextField(soloNumeri);
		formattedTextFieldCostituzione.setEnabled(false);
		formattedTextFieldCostituzione.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldCostituzione = new GridBagConstraints();
		gbc_formattedTextFieldCostituzione.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldCostituzione.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldCostituzione.gridx = 1;
		gbc_formattedTextFieldCostituzione.gridy = 3;
		panelStatistiche.add(formattedTextFieldCostituzione, gbc_formattedTextFieldCostituzione);
		
		formattedTextFieldCostituzioneMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldCostituzioneMod.setEnabled(false);
		formattedTextFieldCostituzioneMod.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldCostituzioneMod = new GridBagConstraints();
		gbc_formattedTextFieldCostituzioneMod.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldCostituzioneMod.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldCostituzioneMod.gridx = 2;
		gbc_formattedTextFieldCostituzioneMod.gridy = 3;
		panelStatistiche.add(formattedTextFieldCostituzioneMod, gbc_formattedTextFieldCostituzioneMod);
		
		JLabel lblInt = new JLabel("INT");
		lblInt.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblInt = new GridBagConstraints();
		gbc_lblInt.anchor = GridBagConstraints.EAST;
		gbc_lblInt.insets = new Insets(0, 0, 5, 5);
		gbc_lblInt.gridx = 0;
		gbc_lblInt.gridy = 4;
		panelStatistiche.add(lblInt, gbc_lblInt);
		
		formattedTextFieldIntelligenza = new JFormattedTextField(soloNumeri);
		formattedTextFieldIntelligenza.setEnabled(false);
		formattedTextFieldIntelligenza.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldIntelligenza = new GridBagConstraints();
		gbc_formattedTextFieldIntelligenza.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldIntelligenza.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldIntelligenza.gridx = 1;
		gbc_formattedTextFieldIntelligenza.gridy = 4;
		panelStatistiche.add(formattedTextFieldIntelligenza, gbc_formattedTextFieldIntelligenza);
		
		formattedTextFieldIntelligenzaMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldIntelligenzaMod.setEnabled(false);
		formattedTextFieldIntelligenzaMod.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldIntelligenzaMod = new GridBagConstraints();
		gbc_formattedTextFieldIntelligenzaMod.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldIntelligenzaMod.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldIntelligenzaMod.gridx = 2;
		gbc_formattedTextFieldIntelligenzaMod.gridy = 4;
		panelStatistiche.add(formattedTextFieldIntelligenzaMod, gbc_formattedTextFieldIntelligenzaMod);
		
		JLabel lblSag = new JLabel("SAG");
		lblSag.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblSag = new GridBagConstraints();
		gbc_lblSag.anchor = GridBagConstraints.EAST;
		gbc_lblSag.insets = new Insets(0, 0, 5, 5);
		gbc_lblSag.gridx = 0;
		gbc_lblSag.gridy = 5;
		panelStatistiche.add(lblSag, gbc_lblSag);
		
		formattedTextFieldSaggezza = new JFormattedTextField(soloNumeri);
		formattedTextFieldSaggezza.setEnabled(false);
		formattedTextFieldSaggezza.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldSaggezza = new GridBagConstraints();
		gbc_formattedTextFieldSaggezza.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldSaggezza.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldSaggezza.gridx = 1;
		gbc_formattedTextFieldSaggezza.gridy = 5;
		panelStatistiche.add(formattedTextFieldSaggezza, gbc_formattedTextFieldSaggezza);
		
		formattedTextFieldSaggezzaMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldSaggezzaMod.setEnabled(false);
		formattedTextFieldSaggezzaMod.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldSaggezzaMod = new GridBagConstraints();
		gbc_formattedTextFieldSaggezzaMod.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldSaggezzaMod.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldSaggezzaMod.gridx = 2;
		gbc_formattedTextFieldSaggezzaMod.gridy = 5;
		panelStatistiche.add(formattedTextFieldSaggezzaMod, gbc_formattedTextFieldSaggezzaMod);
		
		JLabel lblCar = new JLabel("CAR");
		lblCar.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblCar = new GridBagConstraints();
		gbc_lblCar.anchor = GridBagConstraints.EAST;
		gbc_lblCar.insets = new Insets(0, 0, 5, 5);
		gbc_lblCar.gridx = 0;
		gbc_lblCar.gridy = 6;
		panelStatistiche.add(lblCar, gbc_lblCar);
		
		formattedTextFieldCarisma = new JFormattedTextField(soloNumeri);
		formattedTextFieldCarisma.setEnabled(false);
		formattedTextFieldCarisma.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldCarisma = new GridBagConstraints();
		gbc_formattedTextFieldCarisma.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldCarisma.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldCarisma.gridx = 1;
		gbc_formattedTextFieldCarisma.gridy = 6;
		panelStatistiche.add(formattedTextFieldCarisma, gbc_formattedTextFieldCarisma);
		
		formattedTextFieldCarismaMod = new JFormattedTextField(soloNumeriConSegno);
		formattedTextFieldCarismaMod.setEnabled(false);
		formattedTextFieldCarismaMod.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldCarismaMod = new GridBagConstraints();
		gbc_formattedTextFieldCarismaMod.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldCarismaMod.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldCarismaMod.gridx = 2;
		gbc_formattedTextFieldCarismaMod.gridy = 6;
		panelStatistiche.add(formattedTextFieldCarismaMod, gbc_formattedTextFieldCarismaMod);
		
		lblIniziativa = new JLabel("INIZIATIVA");
		GridBagConstraints gbc_lblIniziativa = new GridBagConstraints();
		gbc_lblIniziativa.insets = new Insets(0, 0, 5, 0);
		gbc_lblIniziativa.gridwidth = 3;
		gbc_lblIniziativa.gridx = 0;
		gbc_lblIniziativa.gridy = 7;
		panelStatistiche.add(lblIniziativa, gbc_lblIniziativa);
		lblIniziativa.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		formattedTextFieldIniziativa = new JFormattedTextField(soloNumeri);
		formattedTextFieldIniziativa.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldIniziativa.setEnabled(false);
		formattedTextFieldIniziativa.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldIniziativa = new GridBagConstraints();
		gbc_formattedTextFieldIniziativa.gridwidth = 3;
		gbc_formattedTextFieldIniziativa.insets = new Insets(0, 0, 0, 5);
		gbc_formattedTextFieldIniziativa.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldIniziativa.gridx = 0;
		gbc_formattedTextFieldIniziativa.gridy = 8;
		panelStatistiche.add(formattedTextFieldIniziativa, gbc_formattedTextFieldIniziativa);
		
		panelPuntiFerita = new JPanel();
		GridBagConstraints gbc_panelPuntiFerita = new GridBagConstraints();
		gbc_panelPuntiFerita.insets = new Insets(0, 0, 5, 5);
		gbc_panelPuntiFerita.fill = GridBagConstraints.BOTH;
		gbc_panelPuntiFerita.gridx = 1;
		gbc_panelPuntiFerita.gridy = 2;
		panel.add(panelPuntiFerita, gbc_panelPuntiFerita);
		GridBagLayout gbl_panelPuntiFerita = new GridBagLayout();
		gbl_panelPuntiFerita.columnWidths = new int[]{0, 70, 0, 0};
		gbl_panelPuntiFerita.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 142, 0};
		gbl_panelPuntiFerita.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelPuntiFerita.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPuntiFerita.setLayout(gbl_panelPuntiFerita);
		
		lblPuntiFerita = new JLabel("PUNTI FERITA");
		lblPuntiFerita.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblPuntiFerita = new GridBagConstraints();
		gbc_lblPuntiFerita.gridwidth = 2;
		gbc_lblPuntiFerita.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntiFerita.gridx = 0;
		gbc_lblPuntiFerita.gridy = 0;
		panelPuntiFerita.add(lblPuntiFerita, gbc_lblPuntiFerita);
		
		lblPuntiFeritaTotali = new JLabel("Punti Ferita Totali:");
		lblPuntiFeritaTotali.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPuntiFeritaTotali = new GridBagConstraints();
		gbc_lblPuntiFeritaTotali.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntiFeritaTotali.anchor = GridBagConstraints.EAST;
		gbc_lblPuntiFeritaTotali.gridx = 0;
		gbc_lblPuntiFeritaTotali.gridy = 1;
		panelPuntiFerita.add(lblPuntiFeritaTotali, gbc_lblPuntiFeritaTotali);
		
		formattedTextFieldPuntiFeritaTotali = new JFormattedTextField(soloNumeri);
		formattedTextFieldPuntiFeritaTotali.setEnabled(false);
		formattedTextFieldPuntiFeritaTotali.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldPuntiFeritaTotali = new GridBagConstraints();
		gbc_formattedTextFieldPuntiFeritaTotali.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldPuntiFeritaTotali.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldPuntiFeritaTotali.gridx = 1;
		gbc_formattedTextFieldPuntiFeritaTotali.gridy = 1;
		panelPuntiFerita.add(formattedTextFieldPuntiFeritaTotali, gbc_formattedTextFieldPuntiFeritaTotali);
		
		lblPuntiFeritaRimanenti = new JLabel("Punti Ferita Rimanenti:");
		lblPuntiFeritaRimanenti.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPuntiFeritaRimanenti = new GridBagConstraints();
		gbc_lblPuntiFeritaRimanenti.anchor = GridBagConstraints.EAST;
		gbc_lblPuntiFeritaRimanenti.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntiFeritaRimanenti.gridx = 0;
		gbc_lblPuntiFeritaRimanenti.gridy = 2;
		panelPuntiFerita.add(lblPuntiFeritaRimanenti, gbc_lblPuntiFeritaRimanenti);
		
		formattedTextFieldPuntiFeritaRimanenti = new JFormattedTextField(soloNumeri);
		formattedTextFieldPuntiFeritaRimanenti.setEnabled(false);
		formattedTextFieldPuntiFeritaRimanenti.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldPuntiFeritaRimanenti = new GridBagConstraints();
		gbc_formattedTextFieldPuntiFeritaRimanenti.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldPuntiFeritaRimanenti.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldPuntiFeritaRimanenti.gridx = 1;
		gbc_formattedTextFieldPuntiFeritaRimanenti.gridy = 2;
		panelPuntiFerita.add(formattedTextFieldPuntiFeritaRimanenti, gbc_formattedTextFieldPuntiFeritaRimanenti);
		
		lblFeriteAttuali = new JLabel("Ferite Attuali:");
		lblFeriteAttuali.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblFeriteAttuali = new GridBagConstraints();
		gbc_lblFeriteAttuali.anchor = GridBagConstraints.EAST;
		gbc_lblFeriteAttuali.insets = new Insets(0, 0, 5, 5);
		gbc_lblFeriteAttuali.gridx = 0;
		gbc_lblFeriteAttuali.gridy = 3;
		panelPuntiFerita.add(lblFeriteAttuali, gbc_lblFeriteAttuali);
		
		formattedTextFieldFeriteAttuali = new JFormattedTextField(soloNumeri);
		formattedTextFieldFeriteAttuali.setEnabled(false);
		formattedTextFieldFeriteAttuali.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldFeriteAttuali = new GridBagConstraints();
		gbc_formattedTextFieldFeriteAttuali.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldFeriteAttuali.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldFeriteAttuali.gridx = 1;
		gbc_formattedTextFieldFeriteAttuali.gridy = 3;
		panelPuntiFerita.add(formattedTextFieldFeriteAttuali, gbc_formattedTextFieldFeriteAttuali);
		
		lblDanniNonLetali = new JLabel("Danni Non Letali Attuali:");
		lblDanniNonLetali.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblDanniNonLetali = new GridBagConstraints();
		gbc_lblDanniNonLetali.anchor = GridBagConstraints.EAST;
		gbc_lblDanniNonLetali.insets = new Insets(0, 0, 5, 5);
		gbc_lblDanniNonLetali.gridx = 0;
		gbc_lblDanniNonLetali.gridy = 4;
		panelPuntiFerita.add(lblDanniNonLetali, gbc_lblDanniNonLetali);
		
		formattedTextFieldDanniNonLetaliAttuali = new JFormattedTextField(soloNumeri);
		formattedTextFieldDanniNonLetaliAttuali.setEnabled(false);
		formattedTextFieldDanniNonLetaliAttuali.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldDanniNonLetaliAttuali = new GridBagConstraints();
		gbc_formattedTextFieldDanniNonLetaliAttuali.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldDanniNonLetaliAttuali.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldDanniNonLetaliAttuali.gridx = 1;
		gbc_formattedTextFieldDanniNonLetaliAttuali.gridy = 4;
		panelPuntiFerita.add(formattedTextFieldDanniNonLetaliAttuali, gbc_formattedTextFieldDanniNonLetaliAttuali);
		
		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridwidth = 2;
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 6;
		panelPuntiFerita.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 50, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		lblTiriSalvezza = new JLabel("TIRI SALVEZZA");
		GridBagConstraints gbc_lblTiriSalvezza = new GridBagConstraints();
		gbc_lblTiriSalvezza.gridwidth = 2;
		gbc_lblTiriSalvezza.insets = new Insets(0, 0, 5, 0);
		gbc_lblTiriSalvezza.gridx = 0;
		gbc_lblTiriSalvezza.gridy = 0;
		panel_5.add(lblTiriSalvezza, gbc_lblTiriSalvezza);
		lblTiriSalvezza.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblTempra = new JLabel("Tempra:");
		GridBagConstraints gbc_lblTempra = new GridBagConstraints();
		gbc_lblTempra.insets = new Insets(0, 0, 5, 5);
		gbc_lblTempra.gridx = 0;
		gbc_lblTempra.gridy = 1;
		panel_5.add(lblTempra, gbc_lblTempra);
		lblTempra.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		formattedTextFieldTempra = new JFormattedTextField(soloNumeri);
		GridBagConstraints gbc_formattedTextFieldTempra = new GridBagConstraints();
		gbc_formattedTextFieldTempra.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldTempra.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldTempra.gridx = 1;
		gbc_formattedTextFieldTempra.gridy = 1;
		panel_5.add(formattedTextFieldTempra, gbc_formattedTextFieldTempra);
		formattedTextFieldTempra.setEnabled(false);
		formattedTextFieldTempra.setEditable(false);
		
		lblRiflessi = new JLabel("Riflessi:");
		lblRiflessi.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblRiflessi = new GridBagConstraints();
		gbc_lblRiflessi.anchor = GridBagConstraints.EAST;
		gbc_lblRiflessi.insets = new Insets(0, 0, 5, 5);
		gbc_lblRiflessi.gridx = 0;
		gbc_lblRiflessi.gridy = 2;
		panel_5.add(lblRiflessi, gbc_lblRiflessi);
		
		formattedTextFieldRiflessi = new JFormattedTextField(soloNumeri);
		formattedTextFieldRiflessi.setEnabled(false);
		formattedTextFieldRiflessi.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldRiflessi = new GridBagConstraints();
		gbc_formattedTextFieldRiflessi.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldRiflessi.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldRiflessi.gridx = 1;
		gbc_formattedTextFieldRiflessi.gridy = 2;
		panel_5.add(formattedTextFieldRiflessi, gbc_formattedTextFieldRiflessi);
		
		lblVolont = new JLabel("Volont\u00E0:");
		lblVolont.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblVolont = new GridBagConstraints();
		gbc_lblVolont.anchor = GridBagConstraints.EAST;
		gbc_lblVolont.insets = new Insets(0, 0, 0, 5);
		gbc_lblVolont.gridx = 0;
		gbc_lblVolont.gridy = 3;
		panel_5.add(lblVolont, gbc_lblVolont);
		
		formattedTextFieldVolonta = new JFormattedTextField(soloNumeri);
		formattedTextFieldVolonta.setEnabled(false);
		formattedTextFieldVolonta.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldVolonta = new GridBagConstraints();
		gbc_formattedTextFieldVolonta.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldVolonta.gridx = 1;
		gbc_formattedTextFieldVolonta.gridy = 3;
		panel_5.add(formattedTextFieldVolonta, gbc_formattedTextFieldVolonta);
		
		panelClasseArmatura = new JPanel();
		GridBagConstraints gbc_panelClasseArmatura = new GridBagConstraints();
		gbc_panelClasseArmatura.insets = new Insets(0, 0, 5, 5);
		gbc_panelClasseArmatura.fill = GridBagConstraints.BOTH;
		gbc_panelClasseArmatura.gridx = 2;
		gbc_panelClasseArmatura.gridy = 2;
		panel.add(panelClasseArmatura, gbc_panelClasseArmatura);
		GridBagLayout gbl_panelClasseArmatura = new GridBagLayout();
		gbl_panelClasseArmatura.columnWidths = new int[]{0, 50, 0};
		gbl_panelClasseArmatura.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelClasseArmatura.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelClasseArmatura.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelClasseArmatura.setLayout(gbl_panelClasseArmatura);
		
		lblClasseArmatura = new JLabel("CLASSE ARMATURA");
		lblClasseArmatura.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblClasseArmatura = new GridBagConstraints();
		gbc_lblClasseArmatura.gridwidth = 2;
		gbc_lblClasseArmatura.insets = new Insets(0, 0, 5, 0);
		gbc_lblClasseArmatura.gridx = 0;
		gbc_lblClasseArmatura.gridy = 0;
		panelClasseArmatura.add(lblClasseArmatura, gbc_lblClasseArmatura);
		
		lblClasseArmaturaTotale = new JLabel("CA Totale:");
		lblClasseArmaturaTotale.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblClasseArmaturaTotale = new GridBagConstraints();
		gbc_lblClasseArmaturaTotale.insets = new Insets(0, 0, 5, 5);
		gbc_lblClasseArmaturaTotale.anchor = GridBagConstraints.EAST;
		gbc_lblClasseArmaturaTotale.gridx = 0;
		gbc_lblClasseArmaturaTotale.gridy = 1;
		panelClasseArmatura.add(lblClasseArmaturaTotale, gbc_lblClasseArmaturaTotale);
		
		formattedTextFieldCATotale = new JFormattedTextField(soloNumeri);
		formattedTextFieldCATotale.setEnabled(false);
		formattedTextFieldCATotale.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldCATotale = new GridBagConstraints();
		gbc_formattedTextFieldCATotale.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldCATotale.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldCATotale.gridx = 1;
		gbc_formattedTextFieldCATotale.gridy = 1;
		panelClasseArmatura.add(formattedTextFieldCATotale, gbc_formattedTextFieldCATotale);
		
		lblCaColtoAlla = new JLabel("CA Colto alla Sprovvista:");
		lblCaColtoAlla.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCaColtoAlla = new GridBagConstraints();
		gbc_lblCaColtoAlla.anchor = GridBagConstraints.EAST;
		gbc_lblCaColtoAlla.insets = new Insets(0, 0, 5, 5);
		gbc_lblCaColtoAlla.gridx = 0;
		gbc_lblCaColtoAlla.gridy = 2;
		panelClasseArmatura.add(lblCaColtoAlla, gbc_lblCaColtoAlla);
		
		formattedTextFieldCAColtoAllaSprovvista = new JFormattedTextField(soloNumeri);
		formattedTextFieldCAColtoAllaSprovvista.setEnabled(false);
		formattedTextFieldCAColtoAllaSprovvista.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldCAColtoAllaSprovvista = new GridBagConstraints();
		gbc_formattedTextFieldCAColtoAllaSprovvista.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldCAColtoAllaSprovvista.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldCAColtoAllaSprovvista.gridx = 1;
		gbc_formattedTextFieldCAColtoAllaSprovvista.gridy = 2;
		panelClasseArmatura.add(formattedTextFieldCAColtoAllaSprovvista, gbc_formattedTextFieldCAColtoAllaSprovvista);
		
		lblCaAContatto = new JLabel("CA a Contatto:");
		lblCaAContatto.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCaAContatto = new GridBagConstraints();
		gbc_lblCaAContatto.anchor = GridBagConstraints.EAST;
		gbc_lblCaAContatto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCaAContatto.gridx = 0;
		gbc_lblCaAContatto.gridy = 3;
		panelClasseArmatura.add(lblCaAContatto, gbc_lblCaAContatto);
		
		formattedTextFieldCAContatto = new JFormattedTextField(soloNumeri);
		formattedTextFieldCAContatto.setEnabled(false);
		formattedTextFieldCAContatto.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldCAContatto = new GridBagConstraints();
		gbc_formattedTextFieldCAContatto.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldCAContatto.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldCAContatto.gridx = 1;
		gbc_formattedTextFieldCAContatto.gridy = 3;
		panelClasseArmatura.add(formattedTextFieldCAContatto, gbc_formattedTextFieldCAContatto);
		
		lblFallimentoIncantesimiArcani = new JLabel("Fallimento Incantesimi Arcani:");
		lblFallimentoIncantesimiArcani.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblFallimentoIncantesimiArcani = new GridBagConstraints();
		gbc_lblFallimentoIncantesimiArcani.anchor = GridBagConstraints.EAST;
		gbc_lblFallimentoIncantesimiArcani.insets = new Insets(0, 0, 5, 5);
		gbc_lblFallimentoIncantesimiArcani.gridx = 0;
		gbc_lblFallimentoIncantesimiArcani.gridy = 4;
		panelClasseArmatura.add(lblFallimentoIncantesimiArcani, gbc_lblFallimentoIncantesimiArcani);
		
		formattedTextFieldFallimentoIncantesimiArcani = new JFormattedTextField(soloNumeri);
		formattedTextFieldFallimentoIncantesimiArcani.setEnabled(false);
		formattedTextFieldFallimentoIncantesimiArcani.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldFallimentoIncantesimiArcani = new GridBagConstraints();
		gbc_formattedTextFieldFallimentoIncantesimiArcani.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldFallimentoIncantesimiArcani.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldFallimentoIncantesimiArcani.gridx = 1;
		gbc_formattedTextFieldFallimentoIncantesimiArcani.gridy = 4;
		panelClasseArmatura.add(formattedTextFieldFallimentoIncantesimiArcani, gbc_formattedTextFieldFallimentoIncantesimiArcani);
		
		lblPenalitProvaArmatura = new JLabel("Penalit\u00E0 Prova Armatura:");
		lblPenalitProvaArmatura.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPenalitProvaArmatura = new GridBagConstraints();
		gbc_lblPenalitProvaArmatura.anchor = GridBagConstraints.EAST;
		gbc_lblPenalitProvaArmatura.insets = new Insets(0, 0, 5, 5);
		gbc_lblPenalitProvaArmatura.gridx = 0;
		gbc_lblPenalitProvaArmatura.gridy = 5;
		panelClasseArmatura.add(lblPenalitProvaArmatura, gbc_lblPenalitProvaArmatura);
		
		formattedTextFieldPenalitaProvaArmatura = new JFormattedTextField(soloNumeri);
		formattedTextFieldPenalitaProvaArmatura.setEnabled(false);
		formattedTextFieldPenalitaProvaArmatura.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldPenalitaProvaArmatura = new GridBagConstraints();
		gbc_formattedTextFieldPenalitaProvaArmatura.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldPenalitaProvaArmatura.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldPenalitaProvaArmatura.gridx = 1;
		gbc_formattedTextFieldPenalitaProvaArmatura.gridy = 5;
		panelClasseArmatura.add(formattedTextFieldPenalitaProvaArmatura, gbc_formattedTextFieldPenalitaProvaArmatura);
		
		panelBab = new JPanel();
		GridBagConstraints gbc_panelBab = new GridBagConstraints();
		gbc_panelBab.insets = new Insets(0, 0, 5, 0);
		gbc_panelBab.fill = GridBagConstraints.BOTH;
		gbc_panelBab.gridx = 3;
		gbc_panelBab.gridy = 2;
		panel.add(panelBab, gbc_panelBab);
		GridBagLayout gbl_panelBab = new GridBagLayout();
		gbl_panelBab.columnWidths = new int[]{0, 150, 0, 0};
		gbl_panelBab.rowHeights = new int[]{0, 60, 60, 60, 60, 0};
		gbl_panelBab.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelBab.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelBab.setLayout(gbl_panelBab);
		
		lblBab = new JLabel("BONUS ATTACCO");
		lblBab.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblBab = new GridBagConstraints();
		gbc_lblBab.gridwidth = 2;
		gbc_lblBab.insets = new Insets(0, 0, 5, 5);
		gbc_lblBab.gridx = 0;
		gbc_lblBab.gridy = 0;
		panelBab.add(lblBab, gbc_lblBab);
		
		lblBab_1 = new JLabel("BAB:");
		lblBab_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblBab_1 = new GridBagConstraints();
		gbc_lblBab_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblBab_1.gridx = 0;
		gbc_lblBab_1.gridy = 1;
		panelBab.add(lblBab_1, gbc_lblBab_1);
		
		textAreaBab = new JTextArea();
		textAreaBab.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_textAreaBab = new GridBagConstraints();
		gbc_textAreaBab.fill = GridBagConstraints.BOTH;
		gbc_textAreaBab.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaBab.gridx = 1;
		gbc_textAreaBab.gridy = 1;
		panelBab.add(textAreaBab, gbc_textAreaBab);
		textAreaBab.setBackground(UIManager.getColor("TextField.disabledBackground"));
		textAreaBab.setBorder(UIManager.getBorder("TextField.border"));
		textAreaBab.setEnabled(false);
		textAreaBab.setEditable(false);
		
		lblBabMischia = new JLabel("Mischia:");
		lblBabMischia.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblBabMischia = new GridBagConstraints();
		gbc_lblBabMischia.insets = new Insets(0, 0, 5, 5);
		gbc_lblBabMischia.gridx = 0;
		gbc_lblBabMischia.gridy = 2;
		panelBab.add(lblBabMischia, gbc_lblBabMischia);
		
		textAreaBabMischia = new JTextArea();
		textAreaBabMischia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textAreaBabMischia.setEnabled(false);
		textAreaBabMischia.setEditable(false);
		textAreaBabMischia.setBorder(UIManager.getBorder("TextField.border"));
		textAreaBabMischia.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaBabMischia = new GridBagConstraints();
		gbc_textAreaBabMischia.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaBabMischia.fill = GridBagConstraints.BOTH;
		gbc_textAreaBabMischia.gridx = 1;
		gbc_textAreaBabMischia.gridy = 2;
		panelBab.add(textAreaBabMischia, gbc_textAreaBabMischia);
		
		lblBabDistanza = new JLabel("Distanza:");
		lblBabDistanza.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblBabDistanza = new GridBagConstraints();
		gbc_lblBabDistanza.insets = new Insets(0, 0, 5, 5);
		gbc_lblBabDistanza.gridx = 0;
		gbc_lblBabDistanza.gridy = 3;
		panelBab.add(lblBabDistanza, gbc_lblBabDistanza);
		
		textAreaBabDistanza = new JTextArea();
		textAreaBabDistanza.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textAreaBabDistanza.setEnabled(false);
		textAreaBabDistanza.setEditable(false);
		textAreaBabDistanza.setBorder(UIManager.getBorder("TextField.border"));
		textAreaBabDistanza.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaBabDistanza = new GridBagConstraints();
		gbc_textAreaBabDistanza.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaBabDistanza.fill = GridBagConstraints.BOTH;
		gbc_textAreaBabDistanza.gridx = 1;
		gbc_textAreaBabDistanza.gridy = 3;
		panelBab.add(textAreaBabDistanza, gbc_textAreaBabDistanza);
		
		lblLottare = new JLabel("Lottare:");
		lblLottare.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblLottare = new GridBagConstraints();
		gbc_lblLottare.insets = new Insets(0, 0, 0, 5);
		gbc_lblLottare.gridx = 0;
		gbc_lblLottare.gridy = 4;
		panelBab.add(lblLottare, gbc_lblLottare);
		
		textAreaBabLottare = new JTextArea();
		textAreaBabLottare.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textAreaBabLottare.setEnabled(false);
		textAreaBabLottare.setEditable(false);
		textAreaBabLottare.setBorder(UIManager.getBorder("TextField.border"));
		textAreaBabLottare.setBackground(SystemColor.menu);
		GridBagConstraints gbc_textAreaBabLottare = new GridBagConstraints();
		gbc_textAreaBabLottare.insets = new Insets(0, 0, 0, 5);
		gbc_textAreaBabLottare.fill = GridBagConstraints.BOTH;
		gbc_textAreaBabLottare.gridx = 1;
		gbc_textAreaBabLottare.gridy = 4;
		panelBab.add(textAreaBabLottare, gbc_textAreaBabLottare);
		
		panelArmi = new JPanel();
		GridBagConstraints gbc_panelArmi = new GridBagConstraints();
		gbc_panelArmi.insets = new Insets(0, 0, 5, 0);
		gbc_panelArmi.gridwidth = 4;
		gbc_panelArmi.fill = GridBagConstraints.BOTH;
		gbc_panelArmi.gridx = 0;
		gbc_panelArmi.gridy = 3;
		panel.add(panelArmi, gbc_panelArmi);
		GridBagLayout gbl_panelArmi = new GridBagLayout();
		gbl_panelArmi.columnWidths = new int[]{0, 0};
		gbl_panelArmi.rowHeights = new int[]{0, 49, 0};
		gbl_panelArmi.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelArmi.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelArmi.setLayout(gbl_panelArmi);
		
		lblArmi = new JLabel("ARMI");
		lblArmi.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblArmi = new GridBagConstraints();
		gbc_lblArmi.anchor = GridBagConstraints.WEST;
		gbc_lblArmi.insets = new Insets(0, 0, 5, 0);
		gbc_lblArmi.gridx = 0;
		gbc_lblArmi.gridy = 0;
		panelArmi.add(lblArmi, gbc_lblArmi);
		
		scrollPaneArmi = new JScrollPane();
		GridBagConstraints gbc_scrollPaneArmi = new GridBagConstraints();
		gbc_scrollPaneArmi.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneArmi.gridx = 0;
		gbc_scrollPaneArmi.gridy = 1;
		panelArmi.add(scrollPaneArmi, gbc_scrollPaneArmi);
		
		tableArmiRiepilogo = new JTable();
		tableArmiRiepilogo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableArmiRiepilogo.setEnabled(false);
		tableArmiRiepilogo.setPreferredScrollableViewportSize(new Dimension(0, 0));
		scrollPaneArmi.setViewportView(tableArmiRiepilogo);
		PgArmiRiepilogoTableModel armiRiepilogoTableModel = new PgArmiRiepilogoTableModel();
		tableArmiRiepilogo.setModel(armiRiepilogoTableModel);
		tableArmiRiepilogo.getTableHeader().addMouseListener(this);
		tableArmiRiepilogo.getTableHeader().setReorderingAllowed(false);

		panelAbilita = new JPanel();
		GridBagConstraints gbc_panelAbilita = new GridBagConstraints();
		gbc_panelAbilita.insets = new Insets(0, 0, 5, 0);
		gbc_panelAbilita.gridwidth = 4;
		gbc_panelAbilita.fill = GridBagConstraints.BOTH;
		gbc_panelAbilita.gridx = 0;
		gbc_panelAbilita.gridy = 4;
		panel.add(panelAbilita, gbc_panelAbilita);
		GridBagLayout gbl_panelAbilita = new GridBagLayout();
		gbl_panelAbilita.columnWidths = new int[]{0, 0};
		gbl_panelAbilita.rowHeights = new int[]{0, 0, 0};
		gbl_panelAbilita.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelAbilita.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelAbilita.setLayout(gbl_panelAbilita);

		lblAbilita = new JLabel("ABILITA");
		lblAbilita.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblAbilita = new GridBagConstraints();
		gbc_lblAbilita.anchor = GridBagConstraints.WEST;
		gbc_lblAbilita.insets = new Insets(0, 0, 5, 0);
		gbc_lblAbilita.gridx = 0;
		gbc_lblAbilita.gridy = 0;
		panelAbilita.add(lblAbilita, gbc_lblAbilita);
		
		scrollPaneAbilita = new JScrollPane();
		GridBagConstraints gbc_scrollPaneAbilita = new GridBagConstraints();
		gbc_scrollPaneAbilita.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneAbilita.gridx = 0;
		gbc_scrollPaneAbilita.gridy = 1;
		panelAbilita.add(scrollPaneAbilita, gbc_scrollPaneAbilita);
		
		tableAbilita = new JTable();
		tableAbilita.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableAbilita.setEnabled(false);
		tableAbilita.setPreferredScrollableViewportSize(new Dimension(0, 0));
		scrollPaneAbilita.setViewportView(tableAbilita);
		PgAbilitaTableModel pgAbilitaTableModel = new PgAbilitaTableModel();
		tableAbilita.setModel(pgAbilitaTableModel);
		tableAbilita.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableAbilita.getColumnModel().getColumn(1).setPreferredWidth(10);
		tableAbilita.getColumnModel().getColumn(2).setPreferredWidth(200);
		
		TableColumnModel tcmAbilita = tableAbilita.getColumnModel();
		tcmAbilita.removeColumn(tcmAbilita.getColumn(10));
		tableAbilita.getTableHeader().addMouseListener(this);
		tableAbilita.getTableHeader().setReorderingAllowed(false);

		panelTalenti = new JPanel();
		GridBagConstraints gbc_panelTalenti = new GridBagConstraints();
		gbc_panelTalenti.gridwidth = 4;
		gbc_panelTalenti.fill = GridBagConstraints.BOTH;
		gbc_panelTalenti.gridx = 0;
		gbc_panelTalenti.gridy = 5;
		panel.add(panelTalenti, gbc_panelTalenti);
		GridBagLayout gbl_panelTalenti = new GridBagLayout();
		gbl_panelTalenti.columnWidths = new int[]{0, 0};
		gbl_panelTalenti.rowHeights = new int[]{0, 0, 0};
		gbl_panelTalenti.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelTalenti.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelTalenti.setLayout(gbl_panelTalenti);
		
		lblTalenti = new JLabel("TALENTI");
		lblTalenti.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblTalenti = new GridBagConstraints();
		gbc_lblTalenti.insets = new Insets(0, 0, 5, 0);
		gbc_lblTalenti.gridx = 0;
		gbc_lblTalenti.gridy = 0;
		panelTalenti.add(lblTalenti, gbc_lblTalenti);
		
		scrollPaneTalenti = new JScrollPane();
		GridBagConstraints gbc_scrollPaneTalenti = new GridBagConstraints();
		gbc_scrollPaneTalenti.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTalenti.gridx = 0;
		gbc_scrollPaneTalenti.gridy = 1;
		panelTalenti.add(scrollPaneTalenti, gbc_scrollPaneTalenti);
		
		tableTalenti = new JTable();
		tableTalenti.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableTalenti.setEnabled(false);
		tableTalenti.setPreferredScrollableViewportSize(new Dimension(0, 0));
		scrollPaneTalenti.setViewportView(tableTalenti);
		PgTalentiTableModel pgTalentiTableModel = new PgTalentiTableModel();
		tableTalenti.setModel(pgTalentiTableModel);
		tableTalenti.getColumnModel().getColumn(0).setPreferredWidth(200);
		tableTalenti.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
		tableTalenti.getColumnModel().getColumn(1).setPreferredWidth(800);


		TableColumnModel tcmTalenti = tableTalenti.getColumnModel();
		tcmTalenti.removeColumn(tcmTalenti.getColumn(2));
		tableTalenti.getTableHeader().addMouseListener(this);
		tableTalenti.getTableHeader().setReorderingAllowed(false);


		
	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {
		
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();

		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		
		// TODO Popolamento Classi
		caricaClassi();

		// TODO Popolamento Statistiche
		caricaStatistiche();

		// TODO Popolamento Punti Ferita
		caricaPuntiFerita();

		// TODO Popolamento Classe Armatura
		caricaClasseArmatura();

		// TODO Popolamento Bonus Attacco
		caricaBonusAttacco();

		// TODO Popolamento Iniziativa
		caricaIniziativa();

		// TODO Popolamento Tiri Salvezza
		caricaTiriSalvezza();
		
		// TODO Popolamento Armi
		caricaArmi();
		
		// TODO Popolamento Abilita
		caricaAbilita();
		
		// TODO Popolamento Talenti
		caricaTalenti();
		
		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
	}

	private void caricaClassi() {
		
		ArrayList<Integer> arrayDimensioni = opzioniObj.getDimensioniTablePgClassi();
		if (arrayDimensioni.size() > 0) {
			for (int i = 0; i < tableClassi.getColumnCount(); i++) {
				tableClassi.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			tableClassi.getColumnModel().getColumn(0).setPreferredWidth(280);
			tableClassi.getColumnModel().getColumn(1).setPreferredWidth(75);
			tableClassi.getColumnModel().getColumn(2).setPreferredWidth(75);
			tableClassi.getColumnModel().getColumn(3).setPreferredWidth(75);
			tableClassi.getColumnModel().getColumn(4).setPreferredWidth(100);
			tableClassi.getColumnModel().getColumn(5).setPreferredWidth(120);

		}
		
		ArrayList<PgClasseObj> arrayPgClassi = pgDatiObj.getArrayClassi();

		TableModel model = new DefaultTableModel();
		model = tableClassi.getModel();
		int rigaSelezionata = tableClassi.getSelectedRow();

		((DefaultTableModel) tableClassi.getModel()).setRowCount(0);

		for (int i = 0; i < arrayPgClassi.size(); i++) {
			PgClasseObj pgClasseObj = new PgClasseObj();
			pgClasseObj = arrayPgClassi.get(i);
			((DefaultTableModel) model).addRow(new Object[] {
					pgClasseObj.getClasse(), pgClasseObj.getLivello(),
					pgClasseObj.getDadoVita(), pgClasseObj.getPuntiFerita(),
					pgClasseObj.isClasseDiPrestigio(),
					pgClasseObj.getBabClasse(), pgClasseObj.getPrg() });
		}
		if (tableClassi.getRowCount() > 0) {
			if (rigaSelezionata == -1) {

			} else {
				if (tableClassi.getRowCount() > rigaSelezionata) {
					tableClassi.setRowSelectionInterval(rigaSelezionata,
							rigaSelezionata);
				}
			}
		}
		tableClassi.setPreferredScrollableViewportSize(tableClassi.getPreferredSize());		
	}

	private void caricaStatistiche() {
		PgStatisticheObj pgStatisticheObj = pgDatiObj.getPgStatisticheObj();
		if (pgStatisticheObj.getForzaTemp()!= 0){
			formattedTextFieldForza.setValue(pgStatisticheObj.getForzaTemp());
			formattedTextFieldForzaMod.setValue(pgStatisticheObj.getForzaTempMod());
		} else {
			formattedTextFieldForza.setValue(pgStatisticheObj.getForza());
			formattedTextFieldForzaMod.setValue(pgStatisticheObj.getForzaMod());
		}
		if (pgStatisticheObj.getDestrezzaTemp()!= 0){
			formattedTextFieldDestrezza.setValue(pgStatisticheObj.getDestrezzaTemp());
			formattedTextFieldDestrezzaMod.setValue(pgStatisticheObj.getDestrezzaTempMod());
		} else {
			formattedTextFieldDestrezza.setValue(pgStatisticheObj.getDestrezza());
			formattedTextFieldDestrezzaMod.setValue(pgStatisticheObj.getDestrezzaMod());
		}
		
		if (pgStatisticheObj.getCostituzioneTemp()!= 0){
			formattedTextFieldCostituzione.setValue(pgStatisticheObj.getCostituzioneTemp());
			formattedTextFieldCostituzioneMod.setValue(pgStatisticheObj.getCostituzioneTempMod());
		} else {
			formattedTextFieldCostituzione.setValue(pgStatisticheObj.getCostituzione());
			formattedTextFieldCostituzioneMod.setValue(pgStatisticheObj.getCostituzioneMod());
		}
		if (pgStatisticheObj.getIntelligenzaTemp()!= 0){
			formattedTextFieldIntelligenza.setValue(pgStatisticheObj.getIntelligenzaTemp());
			formattedTextFieldIntelligenzaMod.setValue(pgStatisticheObj.getIntelligenzaTempMod());
		} else {
			formattedTextFieldIntelligenza.setValue(pgStatisticheObj.getIntelligenza());
			formattedTextFieldIntelligenzaMod.setValue(pgStatisticheObj.getIntelligenzaMod());
		}
		if (pgStatisticheObj.getSaggezzaTemp()!= 0){
			formattedTextFieldSaggezza.setValue(pgStatisticheObj.getSaggezzaTemp());
			formattedTextFieldSaggezzaMod.setValue(pgStatisticheObj.getSaggezzaTempMod());
		} else {
			formattedTextFieldSaggezza.setValue(pgStatisticheObj.getSaggezza());
			formattedTextFieldSaggezzaMod.setValue(pgStatisticheObj.getSaggezzaMod());
		}
		if (pgStatisticheObj.getCarismaTemp()!= 0){
			formattedTextFieldCarisma.setValue(pgStatisticheObj.getCarismaTemp());
			formattedTextFieldCarismaMod.setValue(pgStatisticheObj.getCarismaTempMod());
		} else {
			formattedTextFieldCarisma.setValue(pgStatisticheObj.getCarisma());
			formattedTextFieldCarismaMod.setValue(pgStatisticheObj.getCarismaMod());
		}

	}

	private void caricaPuntiFerita() {
		PgPuntiFeritaObj pgPuntiFeritaObj = pgDatiObj.getPgPuntiFeritaObj();

		formattedTextFieldPuntiFeritaTotali.setValue(pgPuntiFeritaObj.getPuntiFeritaTotali());
		formattedTextFieldPuntiFeritaRimanenti.setValue(pgPuntiFeritaObj.getPuntiFeritaRimanenti());
		formattedTextFieldFeriteAttuali.setValue(pgPuntiFeritaObj.getFeriteAttuali());
		formattedTextFieldDanniNonLetaliAttuali.setValue(pgPuntiFeritaObj.getDanniNonLetaliAttuali());

	}

	private void caricaClasseArmatura() {
		PgClasseArmaturaObj pgClasseArmaturaObj = pgDatiObj.getPgClasseArmaturaObj();
		
		formattedTextFieldCATotale.setValue(pgClasseArmaturaObj.getTotale());
		formattedTextFieldCAColtoAllaSprovvista.setValue(pgClasseArmaturaObj.getColtoAllaSprovvista());
		formattedTextFieldCAContatto.setValue(pgClasseArmaturaObj.getAttacchiAContatto());
		formattedTextFieldFallimentoIncantesimiArcani.setValue(pgClasseArmaturaObj.getFallimentoIncantesimiArcani());
		formattedTextFieldPenalitaProvaArmatura.setValue(pgClasseArmaturaObj.getPenalitaProvaArmatura());
	}

	private void caricaBonusAttacco() {

		PgBabObj pgBabObj = pgDatiObj.getPgBabObj();
		
		textAreaBab.setText(pgBabObj.getBab());
		textAreaBabMischia.setText(pgBabObj.getMischiaTotale());
		textAreaBabDistanza.setText(pgBabObj.getDistanzaTotale());
		textAreaBabLottare.setText(pgBabObj.getLottareTotale());

	}

	private void caricaIniziativa() {
		PgIniziativaObj pgIniziativaObj = pgDatiObj.getPgIniziativaObj();
		
		formattedTextFieldIniziativa.setValue(pgIniziativaObj.getTotale());
	}

	private void caricaTiriSalvezza() {
		PgTiriSalvezzaObj pgTiriSalvezzaObj = pgDatiObj.getPgTiriSalvezzaObj();
		
		formattedTextFieldTempra.setValue(pgTiriSalvezzaObj.getTempraTotale());
		formattedTextFieldRiflessi.setValue(pgTiriSalvezzaObj.getRiflessiTotale());
		formattedTextFieldVolonta.setValue(pgTiriSalvezzaObj.getVolontaTotale());
	}
	
	private void caricaArmi() {
		
		ArrayList<Integer> arrayDimensioni = opzioniObj.getDimensioniTablePgArmiRiepilogo();

		if (arrayDimensioni.size() > 0) {
			for (int i = 0; i < tableArmiRiepilogo.getColumnCount(); i++) {
				tableArmiRiepilogo.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			tableArmiRiepilogo.getColumnModel().getColumn(0).setPreferredWidth(450);
			tableArmiRiepilogo.getColumnModel().getColumn(1).setPreferredWidth(120);
			tableArmiRiepilogo.getColumnModel().getColumn(2).setPreferredWidth(120);
			tableArmiRiepilogo.getColumnModel().getColumn(3).setPreferredWidth(100);
			tableArmiRiepilogo.getColumnModel().getColumn(4).setPreferredWidth(120);
			tableArmiRiepilogo.getColumnModel().getColumn(5).setPreferredWidth(110);
			tableArmiRiepilogo.getColumnModel().getColumn(6).setPreferredWidth(110);
		}
		
		ArrayList<PgArmiRiepilogoObj> arrayPgArmiRiepilogo = pgDatiObj.getArrayArmiRiepilogo();

		TableModel modelArmiRiepilogo = new DefaultTableModel();
		modelArmiRiepilogo = tableArmiRiepilogo.getModel();

		((DefaultTableModel) tableArmiRiepilogo.getModel()).setRowCount(0);

		for (int i = 0; i < arrayPgArmiRiepilogo.size(); i++) {
			PgArmiRiepilogoObj pgArmiRiepilogoObj = arrayPgArmiRiepilogo.get(i);
			((DefaultTableModel) modelArmiRiepilogo).addRow(new Object[] { pgArmiRiepilogoObj.getArmaRiepilogo(),
					pgArmiRiepilogoObj.getBatSingoloAttacco(), pgArmiRiepilogoObj.getBatDoppioAttacco(),
					pgArmiRiepilogoObj.getIncrementoGittata(), pgArmiRiepilogoObj.getCritico(),
					pgArmiRiepilogoObj.getDannoTotale(), pgArmiRiepilogoObj.getTipo() });

		}

		tableArmiRiepilogo.setPreferredScrollableViewportSize(tableArmiRiepilogo.getPreferredSize());	
	}

	private void caricaAbilita() {

		ArrayList<Integer> arrayDimensioni = opzioniObj.getDimensioniTablePgAbilita();

		if (arrayDimensioni.size() > 0) {
			for (int i = 0; i < tableAbilita.getColumnCount(); i++) {
				tableAbilita.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			tableAbilita.getColumnModel().getColumn(0).setPreferredWidth(50);
			tableAbilita.getColumnModel().getColumn(1).setPreferredWidth(50);
			tableAbilita.getColumnModel().getColumn(2).setPreferredWidth(310);
			tableAbilita.getColumnModel().getColumn(3).setPreferredWidth(75);
			tableAbilita.getColumnModel().getColumn(4).setPreferredWidth(75);
			tableAbilita.getColumnModel().getColumn(5).setPreferredWidth(75);
			tableAbilita.getColumnModel().getColumn(6).setPreferredWidth(75);
			tableAbilita.getColumnModel().getColumn(7).setPreferredWidth(75);
			tableAbilita.getColumnModel().getColumn(8).setPreferredWidth(75);
			tableAbilita.getColumnModel().getColumn(9).setPreferredWidth(90);

		}
		
		ArrayList<PgAbilitaObj> arrayPgAbilita = pgDatiObj.getArrayAbilita();

		TableModel modelAbilita = new DefaultTableModel();
		modelAbilita = tableAbilita.getModel();

		// Valorizzazione delle righe in tabella e ripristino della riga
		// selezionata
		((DefaultTableModel) tableAbilita.getModel()).setRowCount(0);

		for (int i = 0; i < arrayPgAbilita.size(); i++) {
			PgAbilitaObj pgAbilitaObj = new PgAbilitaObj();
			pgAbilitaObj = arrayPgAbilita.get(i);
			if (pgAbilitaObj.getGrado() > 0 || pgAbilitaObj.getAltro() > 0){
				((DefaultTableModel) modelAbilita).addRow(new Object[] {
						pgAbilitaObj.isAbilitaDiClasse(),
						pgAbilitaObj.isAbilitaDiClasseIncrociata(),
						pgAbilitaObj.getNome(), pgAbilitaObj.getCaratteristica(),
						pgAbilitaObj.getTotale(),
						pgAbilitaObj.getModCaratteristica(),
						pgAbilitaObj.getGrado(), pgAbilitaObj.getAltro(),
						pgAbilitaObj.getBonus(),
						pgAbilitaObj.isRichiedeAddestramento(),
						pgAbilitaObj.getPrg() });
			}
		}
		tableAbilita.setPreferredScrollableViewportSize(tableAbilita.getPreferredSize());	
	}
	
	private void caricaTalenti() {

		ArrayList<Integer> arrayDimensioni = opzioniObj.getDimensioniTablePgTalenti();

		if (arrayDimensioni.size() > 0) {
			for (int i = 0; i < tableTalenti.getColumnCount(); i++) {
				tableTalenti.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			tableTalenti.getColumnModel().getColumn(0).setPreferredWidth(200);
			tableTalenti.getColumnModel().getColumn(1).setPreferredWidth(800);

		}
		
		ArrayList<PgTalentiObj> arrayPgTalenti = new ArrayList<PgTalentiObj>();
		arrayPgTalenti = pgDatiObj.getArrayTalenti();

		TableModel model = new DefaultTableModel();
		model = tableTalenti.getModel();

		((DefaultTableModel) tableTalenti.getModel()).setRowCount(0);

		for (int i = 0; i < arrayPgTalenti.size(); i++) {
			PgTalentiObj pgTalentiObj = arrayPgTalenti.get(i);
			((DefaultTableModel) model).addRow(
					new Object[] { pgTalentiObj.getNome(), pgTalentiObj.getDescrizione(), pgTalentiObj.getPrg() });
		}

		// Calcolo altezza riga sulla base del contenuto della descrizione
		for (int i=0; i < tableTalenti.getRowCount(); i++){
			JTextArea jTextArea = new JTextArea();
			jTextArea.setText(tableTalenti.getModel().getValueAt(i, 1).toString());
			//L'altezza base della riga è 16 (almeno da quanto testato). Moltiplichiamo per il numero righe
			int rowHeight = 16 * jTextArea.getLineCount();
			tableTalenti.setRowHeight(i, rowHeight);

		}

		
		tableTalenti.setPreferredScrollableViewportSize(tableTalenti.getPreferredSize());	
	}

	private void salvaDimensioniTableClassi() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableClassi.getColumnCount(); i++) {
			arrayDimensioni.add(tableClassi.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTablePgClassi(arrayDimensioni);
		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);
		frame.popolaFrame(pgDatiObj);
		
	}
	
	private void salvaDimensioniTableArmiRiepilogo() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableArmiRiepilogo.getColumnCount(); i++) {
			arrayDimensioni.add(tableArmiRiepilogo.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTablePgArmiRiepilogo(arrayDimensioni);
		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);
		frame.popolaFrame(pgDatiObj);
	}

	private void salvaDimensioniTableAbilita() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableAbilita.getColumnCount(); i++) {
			arrayDimensioni.add(tableAbilita.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTablePgAbilita(arrayDimensioni);
		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);
		frame.popolaFrame(pgDatiObj);
	}
	
	private void salvaDimensioniTableTalenti() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableTalenti.getColumnCount(); i++) {
			arrayDimensioni.add(tableTalenti.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTablePgTalenti(arrayDimensioni);
		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);
		frame.popolaFrame(pgDatiObj);
	}
	
	public MainWindow getFrame() {
		return frame;
	}

	public void setFrame(MainWindow frame) {
		this.frame = frame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTableHeader) {
			if ((JTableHeader) component == tableClassi.getTableHeader()) {
				salvaDimensioniTableClassi();
			}
			if ((JTableHeader) component == tableArmiRiepilogo.getTableHeader()) {
				salvaDimensioniTableArmiRiepilogo();
			}
			if ((JTableHeader) component == tableAbilita.getTableHeader()) {
				salvaDimensioniTableAbilita();
			}
			if ((JTableHeader) component == tableTalenti.getTableHeader()) {
				salvaDimensioniTableTalenti();
			}
		}		
	}

}
