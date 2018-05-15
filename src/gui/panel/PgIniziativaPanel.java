package gui.panel;

import gui.MainWindow;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaPgIniziativa;
import obj.OpzioniObj;
import obj.PgDatiObj;
import obj.PgIniziativaObj;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.NumberFormatter;
import javax.swing.SwingConstants;

public class PgIniziativaPanel extends JPanel implements FocusListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3675511109841270793L;
	Formati formati = new Formati();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();

	private PgDatiObj pgDatiObj;
	private MainWindow frame;

	private JTextField textFieldAltroDescrizione;
	private JFormattedTextField formattedTextFieldDestrezza;
	private JFormattedTextField formattedTextFieldTalenti;
	private JFormattedTextField formattedTextFieldMagia;
	private JFormattedTextField formattedTextFieldAltro;
	private JFormattedTextField formattedTextFieldTotale;
	private JTextPane textPaneNote;
	private JTextField textFieldTalentiDescrizione;
	private OpzioniObj opzioniObj;

	/**
	 * Create the panel.
	 * 
	 * @param pgDatiObj
	 */
	public PgIniziativaPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.setPgDatiObj(pgDatiObj);

		NumberFormatter soloNumeri = formati.getSoloNumeri();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 50, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblDes = new JLabel("DES");
		lblDes.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblDes = new GridBagConstraints();
		gbc_lblDes.insets = new Insets(0, 0, 5, 5);
		gbc_lblDes.gridx = 0;
		gbc_lblDes.gridy = 0;
		add(lblDes, gbc_lblDes);

		formattedTextFieldDestrezza = new JFormattedTextField(soloNumeri);
		formattedTextFieldDestrezza.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldDestrezza.setEnabled(false);
		formattedTextFieldDestrezza.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldDestrezza = new GridBagConstraints();
		gbc_formattedTextFieldDestrezza.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldDestrezza.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldDestrezza.gridx = 1;
		gbc_formattedTextFieldDestrezza.gridy = 0;
		add(formattedTextFieldDestrezza, gbc_formattedTextFieldDestrezza);

		JLabel label = new JLabel("+");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		add(label, gbc_label);

		JLabel lblTalenti = new JLabel("TALENTI");
		lblTalenti.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblTalenti = new GridBagConstraints();
		gbc_lblTalenti.anchor = GridBagConstraints.EAST;
		gbc_lblTalenti.insets = new Insets(0, 5, 5, 5);
		gbc_lblTalenti.gridx = 0;
		gbc_lblTalenti.gridy = 2;
		add(lblTalenti, gbc_lblTalenti);

		formattedTextFieldTalenti = new JFormattedTextField(soloNumeri);
		formattedTextFieldTalenti.setEnabled(false);
		formattedTextFieldTalenti.setEditable(false);
		formattedTextFieldTalenti.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldTalenti.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldTalenti = new GridBagConstraints();
		gbc_formattedTextFieldTalenti.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldTalenti.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldTalenti.gridx = 1;
		gbc_formattedTextFieldTalenti.gridy = 2;
		add(formattedTextFieldTalenti, gbc_formattedTextFieldTalenti);
		
		textFieldTalentiDescrizione = new JTextField();
		textFieldTalentiDescrizione.setEnabled(false);
		textFieldTalentiDescrizione.setEditable(false);
		textFieldTalentiDescrizione.setColumns(10);
		GridBagConstraints gbc_textFieldTalentiDescrizione = new GridBagConstraints();
		gbc_textFieldTalentiDescrizione.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTalentiDescrizione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTalentiDescrizione.gridx = 2;
		gbc_textFieldTalentiDescrizione.gridy = 2;
		add(textFieldTalentiDescrizione, gbc_textFieldTalentiDescrizione);

		JLabel label_1 = new JLabel("+");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 3;
		add(label_1, gbc_label_1);

		JLabel lblMagia = new JLabel("MAGIA");
		lblMagia.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblMagia = new GridBagConstraints();
		gbc_lblMagia.insets = new Insets(0, 0, 5, 5);
		gbc_lblMagia.gridx = 0;
		gbc_lblMagia.gridy = 4;
		add(lblMagia, gbc_lblMagia);

		formattedTextFieldMagia = new JFormattedTextField(soloNumeri);
		formattedTextFieldMagia.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldMagia.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldMagia = new GridBagConstraints();
		gbc_formattedTextFieldMagia.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldMagia.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldMagia.gridx = 1;
		gbc_formattedTextFieldMagia.gridy = 4;
		add(formattedTextFieldMagia, gbc_formattedTextFieldMagia);

		JLabel label_2 = new JLabel("+");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 5;
		add(label_2, gbc_label_2);

		JLabel lblAltro = new JLabel("ALTRO");
		lblAltro.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblAltro = new GridBagConstraints();
		gbc_lblAltro.insets = new Insets(0, 0, 5, 5);
		gbc_lblAltro.gridx = 0;
		gbc_lblAltro.gridy = 6;
		add(lblAltro, gbc_lblAltro);

		formattedTextFieldAltro = new JFormattedTextField(soloNumeri);
		formattedTextFieldAltro.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldAltro.setEnabled(false);
		formattedTextFieldAltro.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldAltro = new GridBagConstraints();
		gbc_formattedTextFieldAltro.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldAltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldAltro.gridx = 1;
		gbc_formattedTextFieldAltro.gridy = 6;
		add(formattedTextFieldAltro, gbc_formattedTextFieldAltro);

		textFieldAltroDescrizione = new JTextField();
		textFieldAltroDescrizione.setEnabled(false);
		textFieldAltroDescrizione.setEditable(false);
		GridBagConstraints gbc_textFieldAltroDescrizione = new GridBagConstraints();
		gbc_textFieldAltroDescrizione.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAltroDescrizione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAltroDescrizione.gridx = 2;
		gbc_textFieldAltroDescrizione.gridy = 6;
		add(textFieldAltroDescrizione, gbc_textFieldAltroDescrizione);
		textFieldAltroDescrizione.setColumns(10);
		
		JLabel label_3 = new JLabel("=");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 7;
		add(label_3, gbc_label_3);
		
		JLabel lblTotale = new JLabel("TOTALE");
		lblTotale.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblTotale = new GridBagConstraints();
		gbc_lblTotale.anchor = GridBagConstraints.EAST;
		gbc_lblTotale.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotale.gridx = 0;
		gbc_lblTotale.gridy = 8;
		add(lblTotale, gbc_lblTotale);
		
		formattedTextFieldTotale = new JFormattedTextField(soloNumeri);
		formattedTextFieldTotale.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextFieldTotale.setEnabled(false);
		formattedTextFieldTotale.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldTotale = new GridBagConstraints();
		gbc_formattedTextFieldTotale.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldTotale.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldTotale.gridx = 1;
		gbc_formattedTextFieldTotale.gridy = 8;
		add(formattedTextFieldTotale, gbc_formattedTextFieldTotale);

		JLabel lblNote = new JLabel("Note");
		GridBagConstraints gbc_lblNote = new GridBagConstraints();
		gbc_lblNote.anchor = GridBagConstraints.WEST;
		gbc_lblNote.insets = new Insets(0, 5, 5, 5);
		gbc_lblNote.gridx = 0;
		gbc_lblNote.gridy = 9;
		add(lblNote, gbc_lblNote);

		textPaneNote = new JTextPane();
		textPaneNote.addFocusListener(this);
		textPaneNote.setBorder(UIManager.getBorder("TextField.border"));
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridwidth = 3;
		gbc_textPane.insets = new Insets(0, 5, 5, 5);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 0;
		gbc_textPane.gridy = 10;
		add(textPaneNote, gbc_textPane);

	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {

		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		
		// TODO Popolamento scheda "Tiri Salvezza"
		PgIniziativaObj pgIniziativaObj = new PgIniziativaObj();
		pgIniziativaObj = pgDatiObj.getPgIniziativaObj();

		formattedTextFieldDestrezza.setValue(pgIniziativaObj.getDestrezza());
		formattedTextFieldTalenti.setValue(pgIniziativaObj.getTalenti());
		textFieldTalentiDescrizione.setText(pgIniziativaObj.getTalentiDescrizione());
		formattedTextFieldMagia.setValue(pgIniziativaObj.getMagia());
		formattedTextFieldAltro.setValue(pgIniziativaObj.getAltro());
		textFieldAltroDescrizione.setText(pgIniziativaObj.getAltroDescrizione());
		formattedTextFieldTotale.setValue(pgIniziativaObj.getTotale());
		textPaneNote.setText(pgIniziativaObj.getNote());


	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();

		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldTalenti) {
				pgDatiObj = aggiornaOggetti.aggiornaIniziativa(pgDatiObj,
						ListaPgIniziativa.TALENTI,
						formattedTextFieldTalenti.getText());
				if (pgDatiObj.getPgIniziativaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
			if ((JFormattedTextField) component == formattedTextFieldMagia) {
				pgDatiObj = aggiornaOggetti.aggiornaIniziativa(pgDatiObj,
						ListaPgIniziativa.MAGIA,
						formattedTextFieldMagia.getText());
				if (pgDatiObj.getPgIniziativaObj().isDatiVariati()) {
					frame.popolaFrame(pgDatiObj);
				}
			}
		}

		if (component instanceof JTextPane) {
			if ((JTextPane) component == textPaneNote) {
				pgDatiObj = aggiornaOggetti.aggiornaIniziativa(pgDatiObj,
						ListaPgIniziativa.NOTE, textPaneNote.getText());
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
