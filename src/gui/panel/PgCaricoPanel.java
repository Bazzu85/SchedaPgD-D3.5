package gui.panel;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import Classi.AggiornaOggetti;
import Classi.Formati;
import gui.MainWindow;
import obj.OpzioniObj;
import obj.PgCaricoObj;
import obj.PgDatiObj;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PgCaricoPanel extends JPanel implements FocusListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7108403604924270001L;
	Formati formati = new Formati();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();

	private PgDatiObj pgDatiObj;
	private MainWindow frame;
	private OpzioniObj opzioniObj;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblLeggero;
	private JLabel lblM;
	private JLabel lblPesante;
	private JLabel lblcapacitDiTrasporto;
	private JLabel lblmaxbonusdes;
	private JLabel lblpenalitallaProvaarmatura;
	private JLabel lblCorsa;
	private JLabel lblvelocitmodificata;
	private JTextField txtX;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textFieldCaricoMedio;
	private JTextField textFieldCaricoPesante;
	private JTextField txtNessuno;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtX_1;
	private JTextField textField_6;
	private JTextField txtX_2;
	private JTextField txtBaseVelocitaBase;
	private JTextField textFieldCaricoLeggero;
	private JTextField textFieldVelocitaCaricoMedio;
	private JTextField textFieldVelocit‡CaricoPesante;
	private JLabel lblpenalitPerArmatura;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JLabel lblSollevareSopraLa;
	private JTextField textFieldSollevareSopraLaTesta;
	private JLabel lblsollevareDalTerrenocarico;
	private JTextField textFieldSollevareDalTerreno;
	private JLabel lblspingereOTrascinarecarico;
	private JTextField textFieldSpingereTrascinare;

	public PgCaricoPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.setPgDatiObj(pgDatiObj);


		GridBagLayout gbl_pgBonusAttaccoBasePanel = new GridBagLayout();
		gbl_pgBonusAttaccoBasePanel.columnWidths = new int[] { 87,
				0 };
		gbl_pgBonusAttaccoBasePanel.rowHeights = new int[] { 259, 0 };
		gbl_pgBonusAttaccoBasePanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pgBonusAttaccoBasePanel.rowWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		this.setLayout(gbl_pgBonusAttaccoBasePanel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 78, 50, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblcapacitDiTrasporto = new JLabel("<html><center>Capacit\u00E0 di<br>Trasporto (in Kg)</center></html>");
		GridBagConstraints gbc_lblcapacitDiTrasporto = new GridBagConstraints();
		gbc_lblcapacitDiTrasporto.insets = new Insets(0, 0, 5, 5);
		gbc_lblcapacitDiTrasporto.gridx = 1;
		gbc_lblcapacitDiTrasporto.gridy = 0;
		panel.add(lblcapacitDiTrasporto, gbc_lblcapacitDiTrasporto);
		
		lblmaxbonusdes = new JLabel("<html><center>MAX<br>BONUS<br>DES</center></html>");
		GridBagConstraints gbc_lblmaxbonusdes = new GridBagConstraints();
		gbc_lblmaxbonusdes.insets = new Insets(0, 0, 5, 5);
		gbc_lblmaxbonusdes.gridx = 2;
		gbc_lblmaxbonusdes.gridy = 0;
		panel.add(lblmaxbonusdes, gbc_lblmaxbonusdes);
		
		lblpenalitallaProvaarmatura = new JLabel("<html><center>Penalit\u00E0<br>alla prova<br>Armatura</center></html>");
		GridBagConstraints gbc_lblpenalitallaProvaarmatura = new GridBagConstraints();
		gbc_lblpenalitallaProvaarmatura.insets = new Insets(0, 0, 5, 5);
		gbc_lblpenalitallaProvaarmatura.gridx = 3;
		gbc_lblpenalitallaProvaarmatura.gridy = 0;
		panel.add(lblpenalitallaProvaarmatura, gbc_lblpenalitallaProvaarmatura);
		
		lblCorsa = new JLabel("Corsa");
		GridBagConstraints gbc_lblCorsa = new GridBagConstraints();
		gbc_lblCorsa.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorsa.gridx = 4;
		gbc_lblCorsa.gridy = 0;
		panel.add(lblCorsa, gbc_lblCorsa);
		
		lblvelocitmodificata = new JLabel("<html><center>Velocit\u00E0<br>modificata</center></html>");
		GridBagConstraints gbc_lblvelocitmodificata = new GridBagConstraints();
		gbc_lblvelocitmodificata.insets = new Insets(0, 0, 5, 0);
		gbc_lblvelocitmodificata.gridx = 5;
		gbc_lblvelocitmodificata.gridy = 0;
		panel.add(lblvelocitmodificata, gbc_lblvelocitmodificata);
		
		lblLeggero = new JLabel("LEGGERO");
		lblLeggero.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblLeggero = new GridBagConstraints();
		gbc_lblLeggero.anchor = GridBagConstraints.EAST;
		gbc_lblLeggero.insets = new Insets(0, 0, 5, 5);
		gbc_lblLeggero.gridx = 0;
		gbc_lblLeggero.gridy = 1;
		panel.add(lblLeggero, gbc_lblLeggero);
		
		textFieldCaricoLeggero = new JTextField();
		textFieldCaricoLeggero.setEnabled(false);
		textFieldCaricoLeggero.setEditable(false);
		textFieldCaricoLeggero.setColumns(10);
		GridBagConstraints gbc_textFieldCaricoLeggero = new GridBagConstraints();
		gbc_textFieldCaricoLeggero.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCaricoLeggero.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCaricoLeggero.gridx = 1;
		gbc_textFieldCaricoLeggero.gridy = 1;
		panel.add(textFieldCaricoLeggero, gbc_textFieldCaricoLeggero);
		
		txtX = new JTextField();
		txtX.setHorizontalAlignment(SwingConstants.CENTER);
		txtX.setText("senza limiti");
		txtX.setEnabled(false);
		txtX.setEditable(false);
		GridBagConstraints gbc_txtX = new GridBagConstraints();
		gbc_txtX.insets = new Insets(0, 0, 5, 5);
		gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX.gridx = 2;
		gbc_txtX.gridy = 1;
		panel.add(txtX, gbc_txtX);
		txtX.setColumns(10);
		
		txtNessuno = new JTextField();
		txtNessuno.setText("nessuno");
		txtNessuno.setHorizontalAlignment(SwingConstants.CENTER);
		txtNessuno.setEnabled(false);
		txtNessuno.setEditable(false);
		txtNessuno.setColumns(10);
		GridBagConstraints gbc_txtNessuno = new GridBagConstraints();
		gbc_txtNessuno.insets = new Insets(0, 0, 5, 5);
		gbc_txtNessuno.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNessuno.gridx = 3;
		gbc_txtNessuno.gridy = 1;
		panel.add(txtNessuno, gbc_txtNessuno);
		
		txtX_1 = new JTextField();
		txtX_1.setText("x4");
		txtX_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtX_1.setEnabled(false);
		txtX_1.setEditable(false);
		txtX_1.setColumns(10);
		GridBagConstraints gbc_txtX_1 = new GridBagConstraints();
		gbc_txtX_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtX_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX_1.gridx = 4;
		gbc_txtX_1.gridy = 1;
		panel.add(txtX_1, gbc_txtX_1);
		
		txtBaseVelocitaBase = new JTextField();
		txtBaseVelocitaBase.setText("BASE");
		txtBaseVelocitaBase.setHorizontalAlignment(SwingConstants.CENTER);
		txtBaseVelocitaBase.setEnabled(false);
		txtBaseVelocitaBase.setEditable(false);
		txtBaseVelocitaBase.setColumns(10);
		GridBagConstraints gbc_txtBaseVelocitaBase = new GridBagConstraints();
		gbc_txtBaseVelocitaBase.insets = new Insets(0, 0, 5, 0);
		gbc_txtBaseVelocitaBase.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBaseVelocitaBase.gridx = 5;
		gbc_txtBaseVelocitaBase.gridy = 1;
		panel.add(txtBaseVelocitaBase, gbc_txtBaseVelocitaBase);
		
		lblM = new JLabel("MEDIO");
		lblM.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblM = new GridBagConstraints();
		gbc_lblM.anchor = GridBagConstraints.EAST;
		gbc_lblM.insets = new Insets(0, 0, 5, 5);
		gbc_lblM.gridx = 0;
		gbc_lblM.gridy = 2;
		panel.add(lblM, gbc_lblM);
		
		textFieldCaricoMedio = new JTextField();
		textFieldCaricoMedio.setEnabled(false);
		textFieldCaricoMedio.setEditable(false);
		GridBagConstraints gbc_textFieldCaricoMedio = new GridBagConstraints();
		gbc_textFieldCaricoMedio.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCaricoMedio.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCaricoMedio.gridx = 1;
		gbc_textFieldCaricoMedio.gridy = 2;
		panel.add(textFieldCaricoMedio, gbc_textFieldCaricoMedio);
		textFieldCaricoMedio.setColumns(10);
		
		textField = new JTextField();
		textField.setText("+3");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		
		textField_4 = new JTextField();
		textField_4.setText("-3");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 2;
		panel.add(textField_4, gbc_textField_4);
		
		textField_6 = new JTextField();
		textField_6.setText("x4");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEnabled(false);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 4;
		gbc_textField_6.gridy = 2;
		panel.add(textField_6, gbc_textField_6);
		
		textFieldVelocitaCaricoMedio = new JTextField();
		textFieldVelocitaCaricoMedio.setEnabled(false);
		textFieldVelocitaCaricoMedio.setEditable(false);
		textFieldVelocitaCaricoMedio.setColumns(10);
		GridBagConstraints gbc_textFieldVelocitaCaricoMedio = new GridBagConstraints();
		gbc_textFieldVelocitaCaricoMedio.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldVelocitaCaricoMedio.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVelocitaCaricoMedio.gridx = 5;
		gbc_textFieldVelocitaCaricoMedio.gridy = 2;
		panel.add(textFieldVelocitaCaricoMedio, gbc_textFieldVelocitaCaricoMedio);
		
		lblPesante = new JLabel("PESANTE");
		lblPesante.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPesante = new GridBagConstraints();
		gbc_lblPesante.insets = new Insets(0, 0, 5, 5);
		gbc_lblPesante.anchor = GridBagConstraints.EAST;
		gbc_lblPesante.gridx = 0;
		gbc_lblPesante.gridy = 3;
		panel.add(lblPesante, gbc_lblPesante);
		
		textFieldCaricoPesante = new JTextField();
		textFieldCaricoPesante.setEnabled(false);
		textFieldCaricoPesante.setEditable(false);
		textFieldCaricoPesante.setColumns(10);
		GridBagConstraints gbc_textFieldCaricoPesante = new GridBagConstraints();
		gbc_textFieldCaricoPesante.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCaricoPesante.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCaricoPesante.gridx = 1;
		gbc_textFieldCaricoPesante.gridy = 3;
		panel.add(textFieldCaricoPesante, gbc_textFieldCaricoPesante);
		
		textField_1 = new JTextField();
		textField_1.setText("+1");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		panel.add(textField_1, gbc_textField_1);
		
		textField_5 = new JTextField();
		textField_5.setText("-6");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEnabled(false);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 3;
		panel.add(textField_5, gbc_textField_5);
		
		txtX_2 = new JTextField();
		txtX_2.setText("x3");
		txtX_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtX_2.setEnabled(false);
		txtX_2.setEditable(false);
		txtX_2.setColumns(10);
		GridBagConstraints gbc_txtX_2 = new GridBagConstraints();
		gbc_txtX_2.insets = new Insets(0, 0, 5, 5);
		gbc_txtX_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX_2.gridx = 4;
		gbc_txtX_2.gridy = 3;
		panel.add(txtX_2, gbc_txtX_2);
		
		textFieldVelocit‡CaricoPesante = new JTextField();
		textFieldVelocit‡CaricoPesante.setEnabled(false);
		textFieldVelocit‡CaricoPesante.setEditable(false);
		textFieldVelocit‡CaricoPesante.setColumns(10);
		GridBagConstraints gbc_textFieldVelocit‡CaricoPesante = new GridBagConstraints();
		gbc_textFieldVelocit‡CaricoPesante.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldVelocit‡CaricoPesante.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVelocit‡CaricoPesante.gridx = 5;
		gbc_textFieldVelocit‡CaricoPesante.gridy = 3;
		panel.add(textFieldVelocit‡CaricoPesante, gbc_textFieldVelocit‡CaricoPesante);
		
		lblpenalitPerArmatura = new JLabel("<html><center>Penalit\u00E0 per armatura e scudo<br>(le penalit\u00E0 non si sommano, si usa la peggiore)</center></html>");
		GridBagConstraints gbc_lblpenalitPerArmatura = new GridBagConstraints();
		gbc_lblpenalitPerArmatura.gridwidth = 2;
		gbc_lblpenalitPerArmatura.insets = new Insets(0, 5, 5, 5);
		gbc_lblpenalitPerArmatura.gridx = 0;
		gbc_lblpenalitPerArmatura.gridy = 4;
		panel.add(lblpenalitPerArmatura, gbc_lblpenalitPerArmatura);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setEnabled(false);
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 2;
		gbc_textField_10.gridy = 4;
		panel.add(textField_10, gbc_textField_10);
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setEnabled(false);
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(0, 0, 5, 5);
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.gridx = 3;
		gbc_textField_11.gridy = 4;
		panel.add(textField_11, gbc_textField_11);
		
		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setEnabled(false);
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.insets = new Insets(0, 0, 5, 5);
		gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_12.gridx = 4;
		gbc_textField_12.gridy = 4;
		panel.add(textField_12, gbc_textField_12);
		
		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setEnabled(false);
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		GridBagConstraints gbc_textField_13 = new GridBagConstraints();
		gbc_textField_13.insets = new Insets(0, 0, 5, 0);
		gbc_textField_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_13.gridx = 5;
		gbc_textField_13.gridy = 4;
		panel.add(textField_13, gbc_textField_13);
		
		lblSollevareSopraLa = new JLabel("<html><center>Sollevare sopra la testa<br>(carico massimo)</center></html>");
		GridBagConstraints gbc_lblSollevareSopraLa = new GridBagConstraints();
		gbc_lblSollevareSopraLa.anchor = GridBagConstraints.EAST;
		gbc_lblSollevareSopraLa.insets = new Insets(0, 0, 5, 5);
		gbc_lblSollevareSopraLa.gridx = 1;
		gbc_lblSollevareSopraLa.gridy = 6;
		panel.add(lblSollevareSopraLa, gbc_lblSollevareSopraLa);
		
		textFieldSollevareSopraLaTesta = new JTextField();
		textFieldSollevareSopraLaTesta.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSollevareSopraLaTesta.setEnabled(false);
		textFieldSollevareSopraLaTesta.setEditable(false);
		textFieldSollevareSopraLaTesta.setColumns(10);
		GridBagConstraints gbc_textFieldSollevareSopraLaTesta = new GridBagConstraints();
		gbc_textFieldSollevareSopraLaTesta.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSollevareSopraLaTesta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSollevareSopraLaTesta.gridx = 2;
		gbc_textFieldSollevareSopraLaTesta.gridy = 6;
		panel.add(textFieldSollevareSopraLaTesta, gbc_textFieldSollevareSopraLaTesta);
		
		lblsollevareDalTerrenocarico = new JLabel("<html><center>Sollevare dal terreno<br>(carico massimo x2)</center></html>");
		GridBagConstraints gbc_lblsollevareDalTerrenocarico = new GridBagConstraints();
		gbc_lblsollevareDalTerrenocarico.anchor = GridBagConstraints.EAST;
		gbc_lblsollevareDalTerrenocarico.insets = new Insets(0, 0, 5, 5);
		gbc_lblsollevareDalTerrenocarico.gridx = 1;
		gbc_lblsollevareDalTerrenocarico.gridy = 7;
		panel.add(lblsollevareDalTerrenocarico, gbc_lblsollevareDalTerrenocarico);
		
		textFieldSollevareDalTerreno = new JTextField();
		textFieldSollevareDalTerreno.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSollevareDalTerreno.setEnabled(false);
		textFieldSollevareDalTerreno.setEditable(false);
		textFieldSollevareDalTerreno.setColumns(10);
		GridBagConstraints gbc_textFieldSollevareDalTerreno = new GridBagConstraints();
		gbc_textFieldSollevareDalTerreno.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSollevareDalTerreno.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSollevareDalTerreno.gridx = 2;
		gbc_textFieldSollevareDalTerreno.gridy = 7;
		panel.add(textFieldSollevareDalTerreno, gbc_textFieldSollevareDalTerreno);
		
		lblspingereOTrascinarecarico = new JLabel("<html><center>Spingere o Trascinare<br>(carico massimo x5)</center></html>");
		GridBagConstraints gbc_lblspingereOTrascinarecarico = new GridBagConstraints();
		gbc_lblspingereOTrascinarecarico.anchor = GridBagConstraints.EAST;
		gbc_lblspingereOTrascinarecarico.insets = new Insets(0, 0, 0, 5);
		gbc_lblspingereOTrascinarecarico.gridx = 1;
		gbc_lblspingereOTrascinarecarico.gridy = 8;
		panel.add(lblspingereOTrascinarecarico, gbc_lblspingereOTrascinarecarico);
		
		textFieldSpingereTrascinare = new JTextField();
		textFieldSpingereTrascinare.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSpingereTrascinare.setEnabled(false);
		textFieldSpingereTrascinare.setEditable(false);
		textFieldSpingereTrascinare.setColumns(10);
		GridBagConstraints gbc_textFieldSpingereTrascinare = new GridBagConstraints();
		gbc_textFieldSpingereTrascinare.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldSpingereTrascinare.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSpingereTrascinare.gridx = 2;
		gbc_textFieldSpingereTrascinare.gridy = 8;
		panel.add(textFieldSpingereTrascinare, gbc_textFieldSpingereTrascinare);

	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {
		
		//Salvataggio dell'oggetto nella classe per giri successivi (chiamati da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		
		// TODO Popolamento scheda "Bonus Attacco Base"
		PgCaricoObj pgCaricoObj = new PgCaricoObj();
		pgCaricoObj = pgDatiObj.getPgCaricoObj();

		textFieldCaricoLeggero.setText(pgCaricoObj.getCaricoLeggero());
		textFieldCaricoMedio.setText(pgCaricoObj.getCaricoMedio());
		textFieldCaricoPesante.setText(pgCaricoObj.getCaricoPesante());
		
		textFieldSollevareSopraLaTesta.setText(pgCaricoObj.getSollevareSopraLaTesta());
		textFieldSollevareDalTerreno.setText(pgCaricoObj.getSollevareDalTerreno());
		textFieldSpingereTrascinare.setText(pgCaricoObj.getSpingereTrascinare());

	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

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
