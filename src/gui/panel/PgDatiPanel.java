package gui.panel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Classi.AggiornaOggetti;
import ENUM.ListaPgDati;
import comboBox.PgDatiComboBox;
import gui.MainWindow;
import obj.OpzioniObj;
import obj.PgDatiObj;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.util.Locale;
import java.util.ResourceBundle;

public class PgDatiPanel extends JPanel implements FocusListener {
//	Locale locale = new Locale(Locale.ENGLISH);
//	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("gui.panel.messages", Locale.ENGLISH); //$NON-NLS-1$
	/**
	 * 
	 */
	private static final long serialVersionUID = -1540403598764873630L;

	private MainWindow frame;

	private JTextField textFieldNomePg;
	private JTextField textFieldNomeGiocatore;
	private JTextField textFieldLuogoDataNascita;
	private JTextField textFieldRazza;
	private JTextField textFieldSesso;
	private JTextField textFieldPelle;
	private JTextField textFieldEta;
	private JTextField textFieldAltezza;
	private JTextField textFieldPeso;
	private JTextField textFieldCapelli;
	private JTextField textFieldOcchi;
	private JTextField textFieldAllineamento;
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	PgDatiComboBox pgDatiComboBox = new PgDatiComboBox();

	private PgDatiObj pgDatiObj;
	OpzioniObj opzioniObj;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxTaglie;

	private JTextArea textAreaTitoli;

	/**
	 * Create the panel.
	 * 
	 * @param pgDatiObj
	 * @param opzioniObj 
	 */
	@SuppressWarnings("rawtypes")
	public PgDatiPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {

//		ResourceBundle BUNDLE = ResourceBundle.getBundle("gui.panel.messages", opzioniObj.getLingua()); //$NON-NLS-1$
		ResourceBundle BUNDLE = ResourceBundle.getBundle("gui.panel.messages", new Locale(opzioniObj.getLingua())); //$NON-NLS-1$

		frame = getFrame();
		this.pgDatiObj = pgDatiObj;
		
		GridBagLayout gbl_panelDatiPersonaggio = new GridBagLayout();
		gbl_panelDatiPersonaggio.columnWidths = new int[] { 0, 476 };
		gbl_panelDatiPersonaggio.rowHeights = new int[] { 124, 0 };
		gbl_panelDatiPersonaggio.columnWeights = new double[] { 0.0, 1.0 };
		gbl_panelDatiPersonaggio.rowWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		this.setLayout(gbl_panelDatiPersonaggio);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		add(scrollPane_1, gbc_scrollPane_1);
		
		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel lblNomeDelPersonaggio = new JLabel(BUNDLE.getString("PgDatiPanel.lblNomeDelPersonaggio.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNomeDelPersonaggio = new GridBagConstraints();
		gbc_lblNomeDelPersonaggio.anchor = GridBagConstraints.EAST;
		gbc_lblNomeDelPersonaggio.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeDelPersonaggio.gridx = 0;
		gbc_lblNomeDelPersonaggio.gridy = 0;
		panel.add(lblNomeDelPersonaggio, gbc_lblNomeDelPersonaggio);

		textFieldNomePg = new JTextField();
		GridBagConstraints gbc_textFieldNomePg = new GridBagConstraints();
		gbc_textFieldNomePg.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomePg.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNomePg.gridx = 1;
		gbc_textFieldNomePg.gridy = 0;
		panel.add(textFieldNomePg, gbc_textFieldNomePg);
		textFieldNomePg.addFocusListener(this);
		textFieldNomePg.setColumns(10);
		this.setTextFieldNomePg(textFieldNomePg);
		
		JLabel labelTitoli = new JLabel(BUNDLE.getString("PgDatiPanel.labelTitoli.text")); //$NON-NLS-1$
		GridBagConstraints gbc_labelTitoli = new GridBagConstraints();
		gbc_labelTitoli.anchor = GridBagConstraints.EAST;
		gbc_labelTitoli.insets = new Insets(0, 0, 5, 5);
		gbc_labelTitoli.gridx = 0;
		gbc_labelTitoli.gridy = 1;
		panel.add(labelTitoli, gbc_labelTitoli);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 1;
		panel.add(scrollPane_2, gbc_scrollPane_2);
		
		textAreaTitoli = new JTextArea();
		scrollPane_2.setViewportView(textAreaTitoli);
		textAreaTitoli.addFocusListener(this);
		textAreaTitoli.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblNomeDelGiocatore = new JLabel(BUNDLE.getString("PgDatiPanel.lblNomeDelGiocatore.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNomeDelGiocatore = new GridBagConstraints();
		gbc_lblNomeDelGiocatore.anchor = GridBagConstraints.EAST;
		gbc_lblNomeDelGiocatore.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeDelGiocatore.gridx = 0;
		gbc_lblNomeDelGiocatore.gridy = 2;
		panel.add(lblNomeDelGiocatore, gbc_lblNomeDelGiocatore);

		textFieldNomeGiocatore = new JTextField();
		GridBagConstraints gbc_textFieldNomeGiocatore = new GridBagConstraints();
		gbc_textFieldNomeGiocatore.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomeGiocatore.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNomeGiocatore.gridx = 1;
		gbc_textFieldNomeGiocatore.gridy = 2;
		panel.add(textFieldNomeGiocatore, gbc_textFieldNomeGiocatore);
		textFieldNomeGiocatore.addFocusListener(this);
		textFieldNomeGiocatore.setColumns(10);
		
				JLabel lblLuogoEData = new JLabel(BUNDLE.getString("PgDatiPanel.lblLuogoEData.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblLuogoEData = new GridBagConstraints();
				gbc_lblLuogoEData.anchor = GridBagConstraints.EAST;
				gbc_lblLuogoEData.insets = new Insets(0, 0, 5, 5);
				gbc_lblLuogoEData.gridx = 0;
				gbc_lblLuogoEData.gridy = 3;
				panel.add(lblLuogoEData, gbc_lblLuogoEData);

		textFieldLuogoDataNascita = new JTextField();
		GridBagConstraints gbc_textFieldLuogoDataNascita = new GridBagConstraints();
		gbc_textFieldLuogoDataNascita.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLuogoDataNascita.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldLuogoDataNascita.gridx = 1;
		gbc_textFieldLuogoDataNascita.gridy = 3;
		panel.add(textFieldLuogoDataNascita, gbc_textFieldLuogoDataNascita);
		textFieldLuogoDataNascita.addFocusListener(this);
		textFieldLuogoDataNascita.setColumns(10);
		
				JLabel lblNewLabel = new JLabel(BUNDLE.getString("PgDatiPanel.lblNewLabel.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 4;
				panel.add(lblNewLabel, gbc_lblNewLabel);

		textFieldRazza = new JTextField();
		GridBagConstraints gbc_textFieldRazza = new GridBagConstraints();
		gbc_textFieldRazza.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRazza.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRazza.gridx = 1;
		gbc_textFieldRazza.gridy = 4;
		panel.add(textFieldRazza, gbc_textFieldRazza);
		textFieldRazza.addFocusListener(this);
		textFieldRazza.setColumns(10);
		
				JLabel lblSesso = new JLabel(BUNDLE.getString("PgDatiPanel.lblSesso.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblSesso = new GridBagConstraints();
				gbc_lblSesso.anchor = GridBagConstraints.EAST;
				gbc_lblSesso.insets = new Insets(0, 0, 5, 5);
				gbc_lblSesso.gridx = 0;
				gbc_lblSesso.gridy = 5;
				panel.add(lblSesso, gbc_lblSesso);

		textFieldSesso = new JTextField();
		GridBagConstraints gbc_textFieldSesso = new GridBagConstraints();
		gbc_textFieldSesso.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSesso.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSesso.gridx = 1;
		gbc_textFieldSesso.gridy = 5;
		panel.add(textFieldSesso, gbc_textFieldSesso);
		textFieldSesso.addFocusListener(this);
		textFieldSesso.setColumns(10);
		
				JLabel lblPelle = new JLabel(BUNDLE.getString("PgDatiPanel.lblPelle.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblPelle = new GridBagConstraints();
				gbc_lblPelle.anchor = GridBagConstraints.EAST;
				gbc_lblPelle.insets = new Insets(0, 0, 5, 5);
				gbc_lblPelle.gridx = 0;
				gbc_lblPelle.gridy = 6;
				panel.add(lblPelle, gbc_lblPelle);

		textFieldPelle = new JTextField();
		GridBagConstraints gbc_textFieldPelle = new GridBagConstraints();
		gbc_textFieldPelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPelle.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPelle.gridx = 1;
		gbc_textFieldPelle.gridy = 6;
		panel.add(textFieldPelle, gbc_textFieldPelle);
		textFieldPelle.addFocusListener(this);
		textFieldPelle.setColumns(10);
		
				JLabel lblEt = new JLabel(BUNDLE.getString("PgDatiPanel.lblEt.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblEt = new GridBagConstraints();
				gbc_lblEt.anchor = GridBagConstraints.EAST;
				gbc_lblEt.insets = new Insets(0, 0, 5, 5);
				gbc_lblEt.gridx = 0;
				gbc_lblEt.gridy = 7;
				panel.add(lblEt, gbc_lblEt);

		textFieldEta = new JTextField();
		GridBagConstraints gbc_textFieldEta = new GridBagConstraints();
		gbc_textFieldEta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEta.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldEta.gridx = 1;
		gbc_textFieldEta.gridy = 7;
		panel.add(textFieldEta, gbc_textFieldEta);
		textFieldEta.addFocusListener(this);
		textFieldEta.setColumns(10);
		
				JLabel lblAltezza = new JLabel(BUNDLE.getString("PgDatiPanel.lblAltezza.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblAltezza = new GridBagConstraints();
				gbc_lblAltezza.anchor = GridBagConstraints.EAST;
				gbc_lblAltezza.insets = new Insets(0, 0, 5, 5);
				gbc_lblAltezza.gridx = 0;
				gbc_lblAltezza.gridy = 8;
				panel.add(lblAltezza, gbc_lblAltezza);

		textFieldAltezza = new JTextField();
		GridBagConstraints gbc_textFieldAltezza = new GridBagConstraints();
		gbc_textFieldAltezza.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAltezza.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAltezza.gridx = 1;
		gbc_textFieldAltezza.gridy = 8;
		panel.add(textFieldAltezza, gbc_textFieldAltezza);
		textFieldAltezza.addFocusListener(this);
		textFieldAltezza.setColumns(10);
		
				JLabel lblPeso = new JLabel(BUNDLE.getString("PgDatiPanel.lblPeso.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblPeso = new GridBagConstraints();
				gbc_lblPeso.anchor = GridBagConstraints.EAST;
				gbc_lblPeso.insets = new Insets(0, 0, 5, 5);
				gbc_lblPeso.gridx = 0;
				gbc_lblPeso.gridy = 9;
				panel.add(lblPeso, gbc_lblPeso);

		textFieldPeso = new JTextField();
		GridBagConstraints gbc_textFieldPeso = new GridBagConstraints();
		gbc_textFieldPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPeso.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPeso.gridx = 1;
		gbc_textFieldPeso.gridy = 9;
		panel.add(textFieldPeso, gbc_textFieldPeso);
		textFieldPeso.addFocusListener(this);
		textFieldPeso.setColumns(10);
		
				JLabel lblCapelli = new JLabel(BUNDLE.getString("PgDatiPanel.lblCapelli.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblCapelli = new GridBagConstraints();
				gbc_lblCapelli.anchor = GridBagConstraints.EAST;
				gbc_lblCapelli.insets = new Insets(0, 0, 5, 5);
				gbc_lblCapelli.gridx = 0;
				gbc_lblCapelli.gridy = 10;
				panel.add(lblCapelli, gbc_lblCapelli);

		textFieldCapelli = new JTextField();
		GridBagConstraints gbc_textFieldCapelli = new GridBagConstraints();
		gbc_textFieldCapelli.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCapelli.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCapelli.gridx = 1;
		gbc_textFieldCapelli.gridy = 10;
		panel.add(textFieldCapelli, gbc_textFieldCapelli);
		textFieldCapelli.addFocusListener(this);
		textFieldCapelli.setColumns(10);
		
				JLabel lblOcchi = new JLabel(BUNDLE.getString("PgDatiPanel.lblOcchi.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblOcchi = new GridBagConstraints();
				gbc_lblOcchi.anchor = GridBagConstraints.EAST;
				gbc_lblOcchi.insets = new Insets(0, 0, 5, 5);
				gbc_lblOcchi.gridx = 0;
				gbc_lblOcchi.gridy = 11;
				panel.add(lblOcchi, gbc_lblOcchi);

		textFieldOcchi = new JTextField();
		GridBagConstraints gbc_textFieldOcchi = new GridBagConstraints();
		gbc_textFieldOcchi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOcchi.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldOcchi.gridx = 1;
		gbc_textFieldOcchi.gridy = 11;
		panel.add(textFieldOcchi, gbc_textFieldOcchi);
		textFieldOcchi.addFocusListener(this);
		textFieldOcchi.setColumns(10);
		
				JLabel lblAllineamento = new JLabel(BUNDLE.getString("PgDatiPanel.lblAllineamento.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblAllineamento = new GridBagConstraints();
				gbc_lblAllineamento.anchor = GridBagConstraints.EAST;
				gbc_lblAllineamento.insets = new Insets(0, 0, 5, 5);
				gbc_lblAllineamento.gridx = 0;
				gbc_lblAllineamento.gridy = 12;
				panel.add(lblAllineamento, gbc_lblAllineamento);

		textFieldAllineamento = new JTextField();
		GridBagConstraints gbc_textFieldAllineamento = new GridBagConstraints();
		gbc_textFieldAllineamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAllineamento.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAllineamento.gridx = 1;
		gbc_textFieldAllineamento.gridy = 12;
		panel.add(textFieldAllineamento, gbc_textFieldAllineamento);
		textFieldAllineamento.addFocusListener(this);
		textFieldAllineamento.setColumns(10);

		JLabel lblTaglia = new JLabel(BUNDLE.getString("PgDatiPanel.lblTaglia.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblTaglia = new GridBagConstraints();
		gbc_lblTaglia.anchor = GridBagConstraints.EAST;
		gbc_lblTaglia.insets = new Insets(0, 0, 0, 5);
		gbc_lblTaglia.gridx = 0;
		gbc_lblTaglia.gridy = 13;
		panel.add(lblTaglia, gbc_lblTaglia);
		
		comboBoxTaglie = new JComboBox();
		GridBagConstraints gbc_comboBoxTaglie = new GridBagConstraints();
		gbc_comboBoxTaglie.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTaglie.gridx = 1;
		gbc_comboBoxTaglie.gridy = 13;
		panel.add(comboBoxTaglie, gbc_comboBoxTaglie);
		comboBoxTaglie.addFocusListener(this);

	}

	@SuppressWarnings("unchecked")
	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {

		//Salvataggio dell'oggetto nella classe per giri successivi (chiamati da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;

		// TODO Popolamento scheda "Dati Personaggio"
		textFieldNomePg.setText(pgDatiObj.getNomePg());
		textFieldNomeGiocatore.setText(pgDatiObj.getNomeGiocatore());
		textFieldLuogoDataNascita.setText(pgDatiObj.getLuogoDataNascita());
		textFieldRazza.setText(pgDatiObj.getRazza());
		textFieldSesso.setText(pgDatiObj.getSesso());
		textFieldPelle.setText(pgDatiObj.getPelle());
		textFieldEta.setText(pgDatiObj.getEta());
		textFieldAltezza.setText(pgDatiObj.getAltezza());
		textFieldPeso.setText(pgDatiObj.getPeso());
		textFieldCapelli.setText(pgDatiObj.getCapelli());
		textFieldOcchi.setText(pgDatiObj.getOcchi());
		textFieldAllineamento.setText(pgDatiObj.getAllineamento());
		
		//Carica combobox Taglie
		comboBoxTaglie.setModel(pgDatiComboBox.creaComboBoxTaglie().getModel());

		if (comboBoxTaglie.getItemCount() != 0) {
			comboBoxTaglie.setSelectedIndex(0);
			for (int i = 0; i < comboBoxTaglie.getItemCount(); i++) {
				if (comboBoxTaglie.getItemAt(i).toString().equals(pgDatiObj.getTaglia())) {
					comboBoxTaglie.setSelectedIndex(i);
				}
			}
		}

		textAreaTitoli.setText(pgDatiObj.getTitoli());
		textAreaTitoli.setCaretPosition(0);

	}

	@Override
	public void focusGained(FocusEvent e) {
	
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void focusLost(FocusEvent e) {
	
		Component component = e.getComponent();
	
		if (component instanceof JTextField) {
			if ((JTextField) component == textFieldNomePg) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.NOME_PG,
						textFieldNomePg.getText());
				if (pgDatiObj.isDatiVariati()){
					frame.popolaFrame(pgDatiObj);
				}
			}
			
			if ((JTextField) component == textFieldNomeGiocatore) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.NOME_GIOCATORE,
						textFieldNomeGiocatore.getText());
			}
			if ((JTextField) component == textFieldLuogoDataNascita) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.LUOGO_DATA_NASCITA,
						textFieldLuogoDataNascita.getText());
			}
			if ((JTextField) component == textFieldRazza) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.RAZZA, textFieldRazza.getText());
			}
			if ((JTextField) component == textFieldSesso) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.SESSO, textFieldSesso.getText());
			}
			if ((JTextField) component == textFieldPelle) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.PELLE, textFieldPelle.getText());
			}
			if ((JTextField) component == textFieldEta) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.ETA, textFieldEta.getText());
			}
			if ((JTextField) component == textFieldAltezza) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.ALTEZZA,
						textFieldAltezza.getText());
			}
			if ((JTextField) component == textFieldPeso) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.PESO, textFieldPeso.getText());
			}
			if ((JTextField) component == textFieldCapelli) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.CAPELLI,
						textFieldCapelli.getText());
			}
			if ((JTextField) component == textFieldOcchi) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.OCCHI, textFieldOcchi.getText());
			}
			if ((JTextField) component == textFieldAllineamento) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.ALLINEAMENTO,
						textFieldAllineamento.getText());
			}

		}
		if (component instanceof JComboBox) {
			if ((JComboBox) component == comboBoxTaglie) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.TAGLIA, comboBoxTaglie.getSelectedItem().toString());
				frame.popolaFrame(pgDatiObj);
			}
		}
		if (component instanceof JTextArea) {
			if ((JTextArea) component == textAreaTitoli) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.TITOLI,
						textAreaTitoli.getText());
			}
		}
	
	}

	public JTextField getTextFieldNomePg() {
		return textFieldNomePg;
	}

	public void setTextFieldNomePg(JTextField textFieldNomePg) {
		this.textFieldNomePg = textFieldNomePg;
	}

	public MainWindow getFrame() {
		return frame;
	}

	public void setFrame(MainWindow frame) {
		this.frame = frame;
	}

	
}

