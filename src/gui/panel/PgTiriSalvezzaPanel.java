package gui.panel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.NumberFormatter;

import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaPgTiriSalvezza;
import gui.MainWindow;
import obj.OpzioniObj;
import obj.PgDatiObj;
import obj.PgTiriSalvezzaObj;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class PgTiriSalvezzaPanel extends JPanel implements FocusListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6029242623667629590L;
	Formati formati = new Formati();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();

	private PgDatiObj pgDatiObj;
	private MainWindow frame;
	private JFormattedTextField formattedTextFieldTempraTotale;
	private JFormattedTextField formattedTextFieldTempraBase;
	private JFormattedTextField formattedTextFieldTempraMagia;
	private JFormattedTextField formattedTextFieldTempraAbilita;
	private JFormattedTextField formattedTextFieldTempraAltro;
	private JFormattedTextField formattedTextFieldRiflessiTotale;
	private JFormattedTextField formattedTextFieldRiflessiBase;
	private JFormattedTextField formattedTextFieldRiflessiAbilita;
	private JFormattedTextField formattedTextFieldRiflessiMagia;
	private JFormattedTextField formattedTextFieldRiflessiAltro;
	private JFormattedTextField formattedTextFieldVolontaTotale;
	private JFormattedTextField formattedTextFieldVolontaBase;
	private JFormattedTextField formattedTextFieldVolontaAbilita;
	private JFormattedTextField formattedTextFieldVolontaAltro;
	private JFormattedTextField formattedTextFieldVolontaMagia;
	private JFormattedTextField formattedTextFieldResistenzaIncantesimi;
	private JTextPane textPaneNote;
	private JTextField textFieldTempraAltroDescrizione;
	private JTextField textFieldRiflessiAltroDescrizione;
	private JTextField textFieldVolontaAltroDescrizione;
	private OpzioniObj opzioniObj;

	/**
	 * Create the panel.
	 * 
	 * @param pgDatiObj
	 */
	public PgTiriSalvezzaPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.setPgDatiObj(pgDatiObj);

		NumberFormatter soloNumeri = formati.getSoloNumeri();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 50, 20, 50, 20, 50, 20, 50, 20, 50, 366, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 30, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblTotale = new JLabel("Totale");
		GridBagConstraints gbc_lblTotale = new GridBagConstraints();
		gbc_lblTotale.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotale.gridx = 1;
		gbc_lblTotale.gridy = 0;
		add(lblTotale, gbc_lblTotale);

		JLabel lblBase = new JLabel("Base");
		GridBagConstraints gbc_lblBase = new GridBagConstraints();
		gbc_lblBase.insets = new Insets(0, 0, 5, 5);
		gbc_lblBase.gridx = 3;
		gbc_lblBase.gridy = 0;
		add(lblBase, gbc_lblBase);

		JLabel lblAbilit = new JLabel("Abilit\u00E0");
		GridBagConstraints gbc_lblAbilit = new GridBagConstraints();
		gbc_lblAbilit.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_lblAbilit.insets = new Insets(0, 0, 5, 5);
		gbc_lblAbilit.gridx = 5;
		gbc_lblAbilit.gridy = 0;
		add(lblAbilit, gbc_lblAbilit);

		JLabel lblMagia = new JLabel("Magia");
		GridBagConstraints gbc_lblMagia = new GridBagConstraints();
		gbc_lblMagia.insets = new Insets(0, 0, 5, 5);
		gbc_lblMagia.gridx = 7;
		gbc_lblMagia.gridy = 0;
		add(lblMagia, gbc_lblMagia);

		JLabel lblAltro = new JLabel("Altro");
		GridBagConstraints gbc_lblAltro = new GridBagConstraints();
		gbc_lblAltro.insets = new Insets(0, 0, 5, 5);
		gbc_lblAltro.gridx = 9;
		gbc_lblAltro.gridy = 0;
		add(lblAltro, gbc_lblAltro);

		JLabel lblTempracos = new JLabel("Tempra (COS)");
		lblTempracos.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblTempracos = new GridBagConstraints();
		gbc_lblTempracos.anchor = GridBagConstraints.EAST;
		gbc_lblTempracos.insets = new Insets(0, 0, 5, 5);
		gbc_lblTempracos.gridx = 0;
		gbc_lblTempracos.gridy = 1;
		add(lblTempracos, gbc_lblTempracos);

		formattedTextFieldTempraTotale = new JFormattedTextField(soloNumeri);
		formattedTextFieldTempraTotale.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldTempraTotale.setEnabled(false);
		formattedTextFieldTempraTotale.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldTempraTotale = new GridBagConstraints();
		gbc_formattedTextFieldTempraTotale.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldTempraTotale.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldTempraTotale.gridx = 1;
		gbc_formattedTextFieldTempraTotale.gridy = 1;
		add(formattedTextFieldTempraTotale, gbc_formattedTextFieldTempraTotale);

		JLabel label = new JLabel("=");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		add(label, gbc_label);

		formattedTextFieldTempraBase = new JFormattedTextField(soloNumeri);
		formattedTextFieldTempraBase.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldTempraBase.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldTempraBase = new GridBagConstraints();
		gbc_formattedTextFieldTempraBase.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldTempraBase.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldTempraBase.gridx = 3;
		gbc_formattedTextFieldTempraBase.gridy = 1;
		add(formattedTextFieldTempraBase, gbc_formattedTextFieldTempraBase);

		JLabel label_3 = new JLabel("+");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 4;
		gbc_label_3.gridy = 1;
		add(label_3, gbc_label_3);

		formattedTextFieldTempraAbilita = new JFormattedTextField(soloNumeri);
		formattedTextFieldTempraAbilita.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldTempraAbilita.setEnabled(false);
		formattedTextFieldTempraAbilita.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldTempraAbilita = new GridBagConstraints();
		gbc_formattedTextFieldTempraAbilita.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldTempraAbilita.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldTempraAbilita.gridx = 5;
		gbc_formattedTextFieldTempraAbilita.gridy = 1;
		add(formattedTextFieldTempraAbilita, gbc_formattedTextFieldTempraAbilita);

		JLabel label_6 = new JLabel("+");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 6;
		gbc_label_6.gridy = 1;
		add(label_6, gbc_label_6);

		formattedTextFieldTempraMagia = new JFormattedTextField(soloNumeri);
		formattedTextFieldTempraMagia.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldTempraMagia.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldTempraMagia = new GridBagConstraints();
		gbc_formattedTextFieldTempraMagia.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldTempraMagia.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldTempraMagia.gridx = 7;
		gbc_formattedTextFieldTempraMagia.gridy = 1;
		add(formattedTextFieldTempraMagia, gbc_formattedTextFieldTempraMagia);

		JLabel label_9 = new JLabel("+");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 8;
		gbc_label_9.gridy = 1;
		add(label_9, gbc_label_9);

		formattedTextFieldTempraAltro = new JFormattedTextField(soloNumeri);
		formattedTextFieldTempraAltro.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldTempraAltro.setEnabled(false);
		formattedTextFieldTempraAltro.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldTempraAltro = new GridBagConstraints();
		gbc_formattedTextFieldTempraAltro.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldTempraAltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldTempraAltro.gridx = 9;
		gbc_formattedTextFieldTempraAltro.gridy = 1;
		add(formattedTextFieldTempraAltro, gbc_formattedTextFieldTempraAltro);

		textFieldTempraAltroDescrizione = new JTextField();
		textFieldTempraAltroDescrizione.setEditable(false);
		textFieldTempraAltroDescrizione.setEnabled(false);
		GridBagConstraints gbc_textFieldTempraAltroDescrizione = new GridBagConstraints();
		gbc_textFieldTempraAltroDescrizione.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTempraAltroDescrizione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTempraAltroDescrizione.gridx = 10;
		gbc_textFieldTempraAltroDescrizione.gridy = 1;
		add(textFieldTempraAltroDescrizione, gbc_textFieldTempraAltroDescrizione);
		textFieldTempraAltroDescrizione.setColumns(10);

		JLabel lblRiflessides = new JLabel("Riflessi (DES)");
		lblRiflessides.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblRiflessides = new GridBagConstraints();
		gbc_lblRiflessides.anchor = GridBagConstraints.EAST;
		gbc_lblRiflessides.insets = new Insets(0, 0, 5, 5);
		gbc_lblRiflessides.gridx = 0;
		gbc_lblRiflessides.gridy = 2;
		add(lblRiflessides, gbc_lblRiflessides);

		formattedTextFieldRiflessiTotale = new JFormattedTextField(soloNumeri);
		formattedTextFieldRiflessiTotale.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldRiflessiTotale.setEnabled(false);
		formattedTextFieldRiflessiTotale.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldRiflessiTotale = new GridBagConstraints();
		gbc_formattedTextFieldRiflessiTotale.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldRiflessiTotale.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldRiflessiTotale.gridx = 1;
		gbc_formattedTextFieldRiflessiTotale.gridy = 2;
		add(formattedTextFieldRiflessiTotale, gbc_formattedTextFieldRiflessiTotale);

		JLabel label_1 = new JLabel("=");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 2;
		add(label_1, gbc_label_1);

		formattedTextFieldRiflessiBase = new JFormattedTextField(soloNumeri);
		formattedTextFieldRiflessiBase.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldRiflessiBase.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldRiflessiformattedTextFieldTempraBase = new GridBagConstraints();
		gbc_formattedTextFieldRiflessiformattedTextFieldTempraBase.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldRiflessiformattedTextFieldTempraBase.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldRiflessiformattedTextFieldTempraBase.gridx = 3;
		gbc_formattedTextFieldRiflessiformattedTextFieldTempraBase.gridy = 2;
		add(formattedTextFieldRiflessiBase, gbc_formattedTextFieldRiflessiformattedTextFieldTempraBase);

		JLabel label_4 = new JLabel("+");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 4;
		gbc_label_4.gridy = 2;
		add(label_4, gbc_label_4);

		formattedTextFieldRiflessiAbilita = new JFormattedTextField(soloNumeri);
		formattedTextFieldRiflessiAbilita.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldRiflessiAbilita.setEnabled(false);
		formattedTextFieldRiflessiAbilita.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldRiflessiAbilita = new GridBagConstraints();
		gbc_formattedTextFieldRiflessiAbilita.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldRiflessiAbilita.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldRiflessiAbilita.gridx = 5;
		gbc_formattedTextFieldRiflessiAbilita.gridy = 2;
		add(formattedTextFieldRiflessiAbilita, gbc_formattedTextFieldRiflessiAbilita);

		JLabel label_7 = new JLabel("+");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 6;
		gbc_label_7.gridy = 2;
		add(label_7, gbc_label_7);

		formattedTextFieldRiflessiMagia = new JFormattedTextField(soloNumeri);
		formattedTextFieldRiflessiMagia.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldRiflessiMagia.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldRiflessiMagia = new GridBagConstraints();
		gbc_formattedTextFieldRiflessiMagia.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldRiflessiMagia.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldRiflessiMagia.gridx = 7;
		gbc_formattedTextFieldRiflessiMagia.gridy = 2;
		add(formattedTextFieldRiflessiMagia, gbc_formattedTextFieldRiflessiMagia);

		JLabel label_10 = new JLabel("+");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 8;
		gbc_label_10.gridy = 2;
		add(label_10, gbc_label_10);

		formattedTextFieldRiflessiAltro = new JFormattedTextField(soloNumeri);
		formattedTextFieldRiflessiAltro.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldRiflessiAltro.setEnabled(false);
		formattedTextFieldRiflessiAltro.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldRiflessiAltro = new GridBagConstraints();
		gbc_formattedTextFieldRiflessiAltro.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldRiflessiAltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldRiflessiAltro.gridx = 9;
		gbc_formattedTextFieldRiflessiAltro.gridy = 2;
		add(formattedTextFieldRiflessiAltro, gbc_formattedTextFieldRiflessiAltro);

		textFieldRiflessiAltroDescrizione = new JTextField();
		textFieldRiflessiAltroDescrizione.setEditable(false);
		textFieldRiflessiAltroDescrizione.setEnabled(false);
		GridBagConstraints gbc_textFieldRiflessiAltroDescrizione = new GridBagConstraints();
		gbc_textFieldRiflessiAltroDescrizione.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRiflessiAltroDescrizione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRiflessiAltroDescrizione.gridx = 10;
		gbc_textFieldRiflessiAltroDescrizione.gridy = 2;
		add(textFieldRiflessiAltroDescrizione, gbc_textFieldRiflessiAltroDescrizione);
		textFieldRiflessiAltroDescrizione.setColumns(10);

		JLabel lblVolontsag = new JLabel("Volont\u00E0 (SAG)");
		lblVolontsag.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblVolontsag = new GridBagConstraints();
		gbc_lblVolontsag.anchor = GridBagConstraints.EAST;
		gbc_lblVolontsag.insets = new Insets(0, 0, 5, 5);
		gbc_lblVolontsag.gridx = 0;
		gbc_lblVolontsag.gridy = 3;
		add(lblVolontsag, gbc_lblVolontsag);

		formattedTextFieldVolontaTotale = new JFormattedTextField(soloNumeri);
		formattedTextFieldVolontaTotale.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldVolontaTotale.setEnabled(false);
		formattedTextFieldVolontaTotale.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldVolontaTotale = new GridBagConstraints();
		gbc_formattedTextFieldVolontaTotale.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldVolontaTotale.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldVolontaTotale.gridx = 1;
		gbc_formattedTextFieldVolontaTotale.gridy = 3;
		add(formattedTextFieldVolontaTotale, gbc_formattedTextFieldVolontaTotale);

		JLabel label_2 = new JLabel("=");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 3;
		add(label_2, gbc_label_2);

		formattedTextFieldVolontaBase = new JFormattedTextField(soloNumeri);
		formattedTextFieldVolontaBase.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldVolontaBase.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldRiflessiformattedTextFieldVolontaBase = new GridBagConstraints();
		gbc_formattedTextFieldRiflessiformattedTextFieldVolontaBase.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldRiflessiformattedTextFieldVolontaBase.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldRiflessiformattedTextFieldVolontaBase.gridx = 3;
		gbc_formattedTextFieldRiflessiformattedTextFieldVolontaBase.gridy = 3;
		add(formattedTextFieldVolontaBase, gbc_formattedTextFieldRiflessiformattedTextFieldVolontaBase);

		JLabel label_5 = new JLabel("+");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 4;
		gbc_label_5.gridy = 3;
		add(label_5, gbc_label_5);

		formattedTextFieldVolontaAbilita = new JFormattedTextField(soloNumeri);
		formattedTextFieldVolontaAbilita.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldVolontaAbilita.setEnabled(false);
		formattedTextFieldVolontaAbilita.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldVolontaAbilita = new GridBagConstraints();
		gbc_formattedTextFieldVolontaAbilita.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldVolontaAbilita.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldVolontaAbilita.gridx = 5;
		gbc_formattedTextFieldVolontaAbilita.gridy = 3;
		add(formattedTextFieldVolontaAbilita, gbc_formattedTextFieldVolontaAbilita);

		JLabel label_8 = new JLabel("+");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 6;
		gbc_label_8.gridy = 3;
		add(label_8, gbc_label_8);

		formattedTextFieldVolontaMagia = new JFormattedTextField(soloNumeri);
		formattedTextFieldVolontaMagia.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldVolontaMagia.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldVolontaMagia = new GridBagConstraints();
		gbc_formattedTextFieldVolontaMagia.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldVolontaMagia.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldVolontaMagia.gridx = 7;
		gbc_formattedTextFieldVolontaMagia.gridy = 3;
		add(formattedTextFieldVolontaMagia, gbc_formattedTextFieldVolontaMagia);

		JLabel label_11 = new JLabel("+");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 8;
		gbc_label_11.gridy = 3;
		add(label_11, gbc_label_11);

		formattedTextFieldVolontaAltro = new JFormattedTextField(soloNumeri);
		formattedTextFieldVolontaAltro.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldVolontaAltro.setEnabled(false);
		formattedTextFieldVolontaAltro.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldVolontaAltro = new GridBagConstraints();
		gbc_formattedTextFieldVolontaAltro.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldVolontaAltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldVolontaAltro.gridx = 9;
		gbc_formattedTextFieldVolontaAltro.gridy = 3;
		add(formattedTextFieldVolontaAltro, gbc_formattedTextFieldVolontaAltro);

		textFieldVolontaAltroDescrizione = new JTextField();
		textFieldVolontaAltroDescrizione.setEditable(false);
		textFieldVolontaAltroDescrizione.setEnabled(false);
		GridBagConstraints gbc_textFieldVolontaAltroDescrizione = new GridBagConstraints();
		gbc_textFieldVolontaAltroDescrizione.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldVolontaAltroDescrizione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVolontaAltroDescrizione.gridx = 10;
		gbc_textFieldVolontaAltroDescrizione.gridy = 3;
		add(textFieldVolontaAltroDescrizione, gbc_textFieldVolontaAltroDescrizione);
		textFieldVolontaAltroDescrizione.setColumns(10);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 8;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 50, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblResistenzaAgliIncantesimi = new JLabel("Resistenza agli Incantesimi:");
		lblResistenzaAgliIncantesimi.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblResistenzaAgliIncantesimi = new GridBagConstraints();
		gbc_lblResistenzaAgliIncantesimi.insets = new Insets(0, 0, 0, 5);
		gbc_lblResistenzaAgliIncantesimi.anchor = GridBagConstraints.EAST;
		gbc_lblResistenzaAgliIncantesimi.gridx = 0;
		gbc_lblResistenzaAgliIncantesimi.gridy = 0;
		panel.add(lblResistenzaAgliIncantesimi, gbc_lblResistenzaAgliIncantesimi);

		formattedTextFieldResistenzaIncantesimi = new JFormattedTextField();
		formattedTextFieldResistenzaIncantesimi.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldResistenzaIncantesimi.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldResistenzaIncantesimi = new GridBagConstraints();
		gbc_formattedTextFieldResistenzaIncantesimi.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldResistenzaIncantesimi.gridx = 1;
		gbc_formattedTextFieldResistenzaIncantesimi.gridy = 0;
		panel.add(formattedTextFieldResistenzaIncantesimi, gbc_formattedTextFieldResistenzaIncantesimi);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 11;
		gbc_panel_1.gridheight = 6;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 6;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNote = new JLabel("Note");
		GridBagConstraints gbc_lblNote = new GridBagConstraints();
		gbc_lblNote.insets = new Insets(0, 0, 5, 0);
		gbc_lblNote.gridx = 0;
		gbc_lblNote.gridy = 0;
		panel_1.add(lblNote, gbc_lblNote);

		textPaneNote = new JTextPane();
		textPaneNote.addFocusListener(this);
		textPaneNote.setBorder(UIManager.getBorder("TextField.border"));
		GridBagConstraints gbc_textPaneNote = new GridBagConstraints();
		gbc_textPaneNote.fill = GridBagConstraints.BOTH;
		gbc_textPaneNote.gridx = 0;
		gbc_textPaneNote.gridy = 1;
		panel_1.add(textPaneNote, gbc_textPaneNote);

	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {
		
		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		
		// TODO Popolamento scheda "Tiri Salvezza"
		PgTiriSalvezzaObj pgTiriSalvezzaObj = new PgTiriSalvezzaObj();
		pgTiriSalvezzaObj = pgDatiObj.getPgTiriSalvezzaObj();

		formattedTextFieldTempraTotale.setValue(pgTiriSalvezzaObj.getTempraTotale());
		formattedTextFieldTempraBase.setValue(pgTiriSalvezzaObj.getTempraBase());
		formattedTextFieldTempraMagia.setValue(pgTiriSalvezzaObj.getTempraMagia());
		formattedTextFieldTempraAbilita.setValue(pgTiriSalvezzaObj.getTempraAbilita());
		formattedTextFieldTempraAltro.setValue(pgTiriSalvezzaObj.getTempraAltro());
		textFieldTempraAltroDescrizione.setText(pgTiriSalvezzaObj.getTempraAltroDescrizione());
		formattedTextFieldRiflessiTotale.setValue(pgTiriSalvezzaObj.getRiflessiTotale());
		formattedTextFieldRiflessiBase.setValue(pgTiriSalvezzaObj.getRiflessiBase());
		formattedTextFieldRiflessiAbilita.setValue(pgTiriSalvezzaObj.getRiflessiAbilita());
		formattedTextFieldRiflessiMagia.setValue(pgTiriSalvezzaObj.getRiflessiMagia());
		formattedTextFieldRiflessiAltro.setValue(pgTiriSalvezzaObj.getRiflessiAltro());
		textFieldRiflessiAltroDescrizione.setText(pgTiriSalvezzaObj.getRiflessiAltroDescrizione());
		formattedTextFieldVolontaTotale.setValue(pgTiriSalvezzaObj.getVolontaTotale());
		formattedTextFieldVolontaBase.setValue(pgTiriSalvezzaObj.getVolontaBase());
		formattedTextFieldVolontaMagia.setValue(pgTiriSalvezzaObj.getVolontaMagia());
		formattedTextFieldVolontaAbilita.setValue(pgTiriSalvezzaObj.getVolontaAbilita());
		formattedTextFieldVolontaAltro.setValue(pgTiriSalvezzaObj.getVolontaAltro());
		textFieldVolontaAltroDescrizione.setText(pgTiriSalvezzaObj.getVolontaAltroDescrizione());
		formattedTextFieldResistenzaIncantesimi.setValue(pgTiriSalvezzaObj.getResistenzaIncantesimi());
		textPaneNote.setText(pgTiriSalvezzaObj.getNote());


	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();

		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldTempraBase) {
				pgDatiObj = aggiornaOggetti.aggiornaTiriSalvezza(pgDatiObj, ListaPgTiriSalvezza.TEMPRA_BASE,
						formattedTextFieldTempraBase.getText());
				if (pgDatiObj.getPgTiriSalvezzaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldTempraMagia) {
				pgDatiObj = aggiornaOggetti.aggiornaTiriSalvezza(pgDatiObj, ListaPgTiriSalvezza.TEMPRA_MAGIA,
						formattedTextFieldTempraMagia.getText());
				if (pgDatiObj.getPgTiriSalvezzaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldRiflessiBase) {
				pgDatiObj = aggiornaOggetti.aggiornaTiriSalvezza(pgDatiObj, ListaPgTiriSalvezza.RIFLESSI_BASE,
						formattedTextFieldRiflessiBase.getText());
				if (pgDatiObj.getPgTiriSalvezzaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldRiflessiMagia) {
				pgDatiObj = aggiornaOggetti.aggiornaTiriSalvezza(pgDatiObj, ListaPgTiriSalvezza.RIFLESSI_MAGIA,
						formattedTextFieldRiflessiMagia.getText());
				if (pgDatiObj.getPgTiriSalvezzaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldVolontaBase) {
				pgDatiObj = aggiornaOggetti.aggiornaTiriSalvezza(pgDatiObj, ListaPgTiriSalvezza.VOLONTA_BASE,
						formattedTextFieldVolontaBase.getText());
				if (pgDatiObj.getPgTiriSalvezzaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldVolontaMagia) {
				pgDatiObj = aggiornaOggetti.aggiornaTiriSalvezza(pgDatiObj, ListaPgTiriSalvezza.VOLONTA_MAGIA,
						formattedTextFieldVolontaMagia.getText());
				if (pgDatiObj.getPgTiriSalvezzaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldResistenzaIncantesimi) {
				pgDatiObj = aggiornaOggetti.aggiornaTiriSalvezza(pgDatiObj, ListaPgTiriSalvezza.RESISTENZA_INCANTESIMI,
						formattedTextFieldResistenzaIncantesimi.getText());
			}
		}
		if (component instanceof JTextPane) {
			if ((JTextPane) component == textPaneNote) {
				pgDatiObj = aggiornaOggetti.aggiornaTiriSalvezza(pgDatiObj, ListaPgTiriSalvezza.NOTE,
						textPaneNote.getText());
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
