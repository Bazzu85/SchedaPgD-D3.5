package gui.panel;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import Classi.AggiornaOggetti;
import Classi.CalcolaDati;
import Classi.Formati;
import ENUM.ListaPgPuntiFerita;
import gui.MainWindow;
import obj.OpzioniObj;
import obj.PgDatiObj;

public class PgPuntiFeritaPanel extends JPanel implements FocusListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5735396096095264686L;
	Formati formati = new Formati();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	CalcolaDati calcolaDati = new CalcolaDati();

	private JLabel lblPuntiFeritaTotali;
	private JFormattedTextField formattedTextFieldPuntiFeritaTotali;
	private JLabel lblFeriteAttuali;
	private JFormattedTextField formattedTextFieldFeriteAttuali;
	private JLabel lblFerite;
	private JFormattedTextField formattedTextFieldFerite;
	private JButton btnAggiungiDanno;
	private JLabel lblRiduzioneDelDanno;
	private JTextField textFieldRiduzioneDelDanno;
	private JFormattedTextField formattedTextFieldDanniNonLetali;
	private JLabel lblResistenze;
	private JTextField textFieldResistenze1;
	private JTextField textFieldResistenze3;
	private JTextField textFieldResistenze4;
	private JTextField textFieldResistenze5;
	private JLabel lblStatoPg;
	private JTextField textFieldStatoPg;
	private JButton btnResetDanni;
	private JLabel lblDanniNonLetaliAttuali;
	private JFormattedTextField formattedTextFieldDanniNonLetaliAttuali;
	private JPanel panelResistenze;
	private JTextField textFieldResistenze2;
	private JButton btnAggiungiDannoNonLetale;
	private JButton btnResetDanniNonLetali;

	private PgDatiObj pgDatiObj;
	OpzioniObj opzioniObj;
	private MainWindow frame;
	private JButton btnCuraDanno;
	private JButton btnCuraDanniNonLetali;

	public PgPuntiFeritaPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.pgDatiObj = pgDatiObj;

		NumberFormatter soloNumeri = formati.getSoloNumeri();

		GridBagLayout gbl_panelPuntiFerita = new GridBagLayout();
		gbl_panelPuntiFerita.columnWidths = new int[] { 0, 0, 106, 0, 127, 0 };
		gbl_panelPuntiFerita.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 18, 0, 0, 0 };
		gbl_panelPuntiFerita.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelPuntiFerita.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		this.setLayout(gbl_panelPuntiFerita);
		lblPuntiFeritaTotali = new JLabel("Punti Ferita Totali");
		lblPuntiFeritaTotali.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblPuntiFeritaTotali = new GridBagConstraints();
		gbc_lblPuntiFeritaTotali.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntiFeritaTotali.gridx = 0;
		gbc_lblPuntiFeritaTotali.gridy = 0;
		this.add(lblPuntiFeritaTotali, gbc_lblPuntiFeritaTotali);
		formattedTextFieldPuntiFeritaTotali = new JFormattedTextField(soloNumeri);
		formattedTextFieldPuntiFeritaTotali.setEnabled(false);
		formattedTextFieldPuntiFeritaTotali.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldPuntiFeritaTotali = new GridBagConstraints();
		gbc_formattedTextFieldPuntiFeritaTotali.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldPuntiFeritaTotali.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldPuntiFeritaTotali.gridx = 0;
		gbc_formattedTextFieldPuntiFeritaTotali.gridy = 1;
		this.add(formattedTextFieldPuntiFeritaTotali, gbc_formattedTextFieldPuntiFeritaTotali);

		lblStatoPg = new JLabel("Stato Pg:");
		GridBagConstraints gbc_lblStatoPg = new GridBagConstraints();
		gbc_lblStatoPg.anchor = GridBagConstraints.EAST;
		gbc_lblStatoPg.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatoPg.gridx = 1;
		gbc_lblStatoPg.gridy = 1;
		this.add(lblStatoPg, gbc_lblStatoPg);

		textFieldStatoPg = new JTextField();
		textFieldStatoPg.setEnabled(false);
		textFieldStatoPg.setEditable(false);
		GridBagConstraints gbc_textFieldStatoPg = new GridBagConstraints();
		gbc_textFieldStatoPg.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldStatoPg.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldStatoPg.gridx = 2;
		gbc_textFieldStatoPg.gridy = 1;
		this.add(textFieldStatoPg, gbc_textFieldStatoPg);
		textFieldStatoPg.setColumns(10);
		lblFeriteAttuali = new JLabel("Ferite Attuali");
		lblFeriteAttuali.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPuntiFeritaAttuali = new GridBagConstraints();
		gbc_lblPuntiFeritaAttuali.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntiFeritaAttuali.gridx = 0;
		gbc_lblPuntiFeritaAttuali.gridy = 2;
		this.add(lblFeriteAttuali, gbc_lblPuntiFeritaAttuali);
		lblFerite = new JLabel("Ferite");
		lblFerite.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblFerite = new GridBagConstraints();
		gbc_lblFerite.insets = new Insets(0, 0, 5, 5);
		gbc_lblFerite.gridx = 1;
		gbc_lblFerite.gridy = 2;
		this.add(lblFerite, gbc_lblFerite);
		formattedTextFieldFeriteAttuali = new JFormattedTextField(soloNumeri);
		formattedTextFieldFeriteAttuali.setEnabled(false);
		formattedTextFieldFeriteAttuali.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldPuntiFeritaAttuali = new GridBagConstraints();
		gbc_formattedTextFieldPuntiFeritaAttuali.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldPuntiFeritaAttuali.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldPuntiFeritaAttuali.gridx = 0;
		gbc_formattedTextFieldPuntiFeritaAttuali.gridy = 3;
		this.add(formattedTextFieldFeriteAttuali, gbc_formattedTextFieldPuntiFeritaAttuali);
		formattedTextFieldFerite = new JFormattedTextField(soloNumeri);
		formattedTextFieldFerite.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldFerite = new GridBagConstraints();
		gbc_formattedTextFieldFerite.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldFerite.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldFerite.gridx = 1;
		gbc_formattedTextFieldFerite.gridy = 3;
		this.add(formattedTextFieldFerite, gbc_formattedTextFieldFerite);
		
		btnAggiungiDanno = new JButton("Aggiungi Danno");
		btnAggiungiDanno.addActionListener(this);
		GridBagConstraints gbc_btnAggiungiDanno = new GridBagConstraints();
		gbc_btnAggiungiDanno.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAggiungiDanno.insets = new Insets(0, 0, 5, 5);
		gbc_btnAggiungiDanno.gridx = 2;
		gbc_btnAggiungiDanno.gridy = 3;
		this.add(btnAggiungiDanno, gbc_btnAggiungiDanno);

		btnResetDanni = new JButton("Reset Danni");
		btnResetDanni.addActionListener(this);
		
		btnCuraDanno = new JButton("Cura Danno");
		btnCuraDanno.addActionListener(this);
		GridBagConstraints gbc_btnCuraDanno = new GridBagConstraints();
		gbc_btnCuraDanno.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCuraDanno.insets = new Insets(0, 0, 5, 5);
		gbc_btnCuraDanno.gridx = 3;
		gbc_btnCuraDanno.gridy = 3;
		add(btnCuraDanno, gbc_btnCuraDanno);
		GridBagConstraints gbc_btnResetDanni = new GridBagConstraints();
		gbc_btnResetDanni.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnResetDanni.insets = new Insets(0, 0, 5, 0);
		gbc_btnResetDanni.gridx = 4;
		gbc_btnResetDanni.gridy = 3;
		this.add(btnResetDanni, gbc_btnResetDanni);

		lblDanniNonLetaliAttuali = new JLabel("Danni Non Letali Attuali");
		lblDanniNonLetaliAttuali.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblDanniNonLetaliAttuali = new GridBagConstraints();
		gbc_lblDanniNonLetaliAttuali.insets = new Insets(0, 0, 5, 5);
		gbc_lblDanniNonLetaliAttuali.gridx = 0;
		gbc_lblDanniNonLetaliAttuali.gridy = 4;
		this.add(lblDanniNonLetaliAttuali, gbc_lblDanniNonLetaliAttuali);

		formattedTextFieldDanniNonLetaliAttuali = new JFormattedTextField(soloNumeri);
		formattedTextFieldDanniNonLetaliAttuali.setEnabled(false);
		formattedTextFieldDanniNonLetaliAttuali.setEditable(false);
		GridBagConstraints gbc_formattedTextFieldDanniNonLetaliAttuali = new GridBagConstraints();
		gbc_formattedTextFieldDanniNonLetaliAttuali.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldDanniNonLetaliAttuali.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldDanniNonLetaliAttuali.gridx = 0;
		gbc_formattedTextFieldDanniNonLetaliAttuali.gridy = 5;
		this.add(formattedTextFieldDanniNonLetaliAttuali, gbc_formattedTextFieldDanniNonLetaliAttuali);
		formattedTextFieldDanniNonLetali = new JFormattedTextField(soloNumeri);
		formattedTextFieldDanniNonLetali.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldDanniNonLetali = new GridBagConstraints();
		gbc_formattedTextFieldDanniNonLetali.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldDanniNonLetali.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldDanniNonLetali.gridx = 1;
		gbc_formattedTextFieldDanniNonLetali.gridy = 5;
		this.add(formattedTextFieldDanniNonLetali, gbc_formattedTextFieldDanniNonLetali);
		formattedTextFieldDanniNonLetali.setColumns(10);

		btnAggiungiDannoNonLetale = new JButton("Aggiungi Danno Non Letale");
		btnAggiungiDannoNonLetale.addActionListener(this);
		GridBagConstraints gbc_btnAggiungiDannoNon = new GridBagConstraints();
		gbc_btnAggiungiDannoNon.insets = new Insets(0, 0, 5, 5);
		gbc_btnAggiungiDannoNon.gridx = 2;
		gbc_btnAggiungiDannoNon.gridy = 5;
		this.add(btnAggiungiDannoNonLetale, gbc_btnAggiungiDannoNon);

		btnResetDanniNonLetali = new JButton("Reset Danni Non Letali");
		btnResetDanniNonLetali.addActionListener(this);
		
		btnCuraDanniNonLetali = new JButton("Cura Danni Non Letali");
		btnCuraDanniNonLetali.addActionListener(this);
		GridBagConstraints gbc_btnCuraDanniNon = new GridBagConstraints();
		gbc_btnCuraDanniNon.insets = new Insets(0, 0, 5, 5);
		gbc_btnCuraDanniNon.gridx = 3;
		gbc_btnCuraDanniNon.gridy = 5;
		add(btnCuraDanniNonLetali, gbc_btnCuraDanniNon);
		GridBagConstraints gbc_btnResetDanniNon = new GridBagConstraints();
		gbc_btnResetDanniNon.insets = new Insets(0, 0, 5, 0);
		gbc_btnResetDanniNon.gridx = 4;
		gbc_btnResetDanniNon.gridy = 5;
		this.add(btnResetDanniNonLetali, gbc_btnResetDanniNon);
		lblRiduzioneDelDanno = new JLabel("Riduzione del Danno");
		lblRiduzioneDelDanno.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblRiduzioneDelDanno = new GridBagConstraints();
		gbc_lblRiduzioneDelDanno.insets = new Insets(0, 0, 5, 5);
		gbc_lblRiduzioneDelDanno.gridx = 0;
		gbc_lblRiduzioneDelDanno.gridy = 6;
		this.add(lblRiduzioneDelDanno, gbc_lblRiduzioneDelDanno);
		textFieldRiduzioneDelDanno = new JTextField();
		textFieldRiduzioneDelDanno.addFocusListener(this);
		GridBagConstraints gbc_textFieldRiduzioneDelDanno = new GridBagConstraints();
		gbc_textFieldRiduzioneDelDanno.gridwidth = 4;
		gbc_textFieldRiduzioneDelDanno.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRiduzioneDelDanno.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRiduzioneDelDanno.gridx = 1;
		gbc_textFieldRiduzioneDelDanno.gridy = 6;
		this.add(textFieldRiduzioneDelDanno, gbc_textFieldRiduzioneDelDanno);
		textFieldRiduzioneDelDanno.setColumns(10);

		panelResistenze = new JPanel();
		GridBagConstraints gbc_panelResistenze = new GridBagConstraints();
		gbc_panelResistenze.insets = new Insets(0, 0, 5, 0);
		gbc_panelResistenze.gridwidth = 4;
		gbc_panelResistenze.fill = GridBagConstraints.BOTH;
		gbc_panelResistenze.gridx = 0;
		gbc_panelResistenze.gridy = 8;
		this.add(panelResistenze, gbc_panelResistenze);
		GridBagLayout gbl_panelResistenze = new GridBagLayout();
		gbl_panelResistenze.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panelResistenze.rowHeights = new int[] { 0, 0, 0 };
		gbl_panelResistenze.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelResistenze.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelResistenze.setLayout(gbl_panelResistenze);
		lblResistenze = new JLabel("Resistenze");
		GridBagConstraints gbc_lblResistenze = new GridBagConstraints();
		gbc_lblResistenze.gridwidth = 5;
		gbc_lblResistenze.insets = new Insets(0, 0, 5, 5);
		gbc_lblResistenze.gridx = 0;
		gbc_lblResistenze.gridy = 0;
		panelResistenze.add(lblResistenze, gbc_lblResistenze);
		lblResistenze.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldResistenze1 = new JTextField();
		textFieldResistenze1.addFocusListener(this);
		GridBagConstraints gbc_textFieldResistenze1 = new GridBagConstraints();
		gbc_textFieldResistenze1.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldResistenze1.gridx = 0;
		gbc_textFieldResistenze1.gridy = 1;
		panelResistenze.add(textFieldResistenze1, gbc_textFieldResistenze1);
		textFieldResistenze1.setColumns(10);

		textFieldResistenze2 = new JTextField();
		textFieldResistenze2.addFocusListener(this);
		GridBagConstraints gbc_textFieldResistenze2 = new GridBagConstraints();
		gbc_textFieldResistenze2.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldResistenze2.gridx = 1;
		gbc_textFieldResistenze2.gridy = 1;
		panelResistenze.add(textFieldResistenze2, gbc_textFieldResistenze2);
		textFieldResistenze2.setColumns(10);
		textFieldResistenze3 = new JTextField();
		textFieldResistenze3.addFocusListener(this);
		GridBagConstraints gbc_textFieldResistenze3 = new GridBagConstraints();
		gbc_textFieldResistenze3.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldResistenze3.gridx = 2;
		gbc_textFieldResistenze3.gridy = 1;
		panelResistenze.add(textFieldResistenze3, gbc_textFieldResistenze3);
		textFieldResistenze3.setColumns(10);
		textFieldResistenze4 = new JTextField();
		textFieldResistenze4.addFocusListener(this);
		GridBagConstraints gbc_textFieldResistenze4 = new GridBagConstraints();
		gbc_textFieldResistenze4.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldResistenze4.gridx = 3;
		gbc_textFieldResistenze4.gridy = 1;
		panelResistenze.add(textFieldResistenze4, gbc_textFieldResistenze4);
		textFieldResistenze4.setColumns(10);
		textFieldResistenze5 = new JTextField();
		textFieldResistenze5.addFocusListener(this);
		GridBagConstraints gbc_textFieldResistenze5 = new GridBagConstraints();
		gbc_textFieldResistenze5.gridx = 4;
		gbc_textFieldResistenze5.gridy = 1;
		panelResistenze.add(textFieldResistenze5, gbc_textFieldResistenze5);
		textFieldResistenze5.setColumns(10);

	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {
		
		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		
		// TODO Popolamento scheda "Punti Ferita"

		if (pgDatiObj.getPgPuntiFeritaObj().getPuntiFeritaTotali() > 0) {
			formattedTextFieldPuntiFeritaTotali.setValue(pgDatiObj.getPgPuntiFeritaObj().getPuntiFeritaTotali());
		} else {
			formattedTextFieldPuntiFeritaTotali.setValue(0);
		}
		textFieldStatoPg.setText(pgDatiObj.getPgPuntiFeritaObj().getStatoPg());

		if (pgDatiObj.getPgPuntiFeritaObj().getFeriteAttuali() != 0) {
			formattedTextFieldFeriteAttuali.setValue(pgDatiObj.getPgPuntiFeritaObj().getFeriteAttuali());
		} else {
			formattedTextFieldFeriteAttuali.setValue(0);
		}
		if (pgDatiObj.getPgPuntiFeritaObj().getFerite() != 0) {
			formattedTextFieldFerite.setValue(pgDatiObj.getPgPuntiFeritaObj().getFerite());
		} else {
			formattedTextFieldFerite.setValue(0);
		}
		if (pgDatiObj.getPgPuntiFeritaObj().getDanniNonLetaliAttuali() != 0) {
			formattedTextFieldDanniNonLetaliAttuali
					.setValue(pgDatiObj.getPgPuntiFeritaObj().getDanniNonLetaliAttuali());
		} else {
			formattedTextFieldDanniNonLetaliAttuali.setValue(0);
		}
		if (pgDatiObj.getPgPuntiFeritaObj().getDanniNonLetali() != 0) {
			formattedTextFieldDanniNonLetali.setValue(pgDatiObj.getPgPuntiFeritaObj().getDanniNonLetali());
		} else {
			formattedTextFieldDanniNonLetali.setValue(0);
		}
		textFieldRiduzioneDelDanno.setText(pgDatiObj.getPgPuntiFeritaObj().getRiduzioneDelDanno());
		textFieldResistenze1.setText(pgDatiObj.getPgPuntiFeritaObj().getResistenze1());
		textFieldResistenze2.setText(pgDatiObj.getPgPuntiFeritaObj().getResistenze2());
		textFieldResistenze3.setText(pgDatiObj.getPgPuntiFeritaObj().getResistenze3());
		textFieldResistenze4.setText(pgDatiObj.getPgPuntiFeritaObj().getResistenze4());
		textFieldResistenze5.setText(pgDatiObj.getPgPuntiFeritaObj().getResistenze5());


	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();

		if (component instanceof JTextField) {
			if ((JTextField) component == textFieldRiduzioneDelDanno) {
				pgDatiObj = aggiornaOggetti.aggiornaPuntiFerita(pgDatiObj, ListaPgPuntiFerita.RIDUZIONE_DEL_DANNO,
						textFieldRiduzioneDelDanno.getText());
			}
			if ((JTextField) component == textFieldResistenze1) {
				pgDatiObj = aggiornaOggetti.aggiornaPuntiFerita(pgDatiObj, ListaPgPuntiFerita.RESISTENZE1,
						textFieldResistenze1.getText());
			}
			if ((JTextField) component == textFieldResistenze2) {
				pgDatiObj = aggiornaOggetti.aggiornaPuntiFerita(pgDatiObj, ListaPgPuntiFerita.RESISTENZE2,
						textFieldResistenze2.getText());
			}
			if ((JTextField) component == textFieldResistenze3) {
				pgDatiObj = aggiornaOggetti.aggiornaPuntiFerita(pgDatiObj, ListaPgPuntiFerita.RESISTENZE3,
						textFieldResistenze3.getText());
			}
			if ((JTextField) component == textFieldResistenze4) {
				pgDatiObj = aggiornaOggetti.aggiornaPuntiFerita(pgDatiObj, ListaPgPuntiFerita.RESISTENZE4,
						textFieldResistenze4.getText());
			}
			if ((JTextField) component == textFieldResistenze5) {
				pgDatiObj = aggiornaOggetti.aggiornaPuntiFerita(pgDatiObj, ListaPgPuntiFerita.RESISTENZE5,
						textFieldResistenze5.getText());
			}
		}

		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldFerite) {
				pgDatiObj = aggiornaOggetti.aggiornaPuntiFerita(pgDatiObj, ListaPgPuntiFerita.FERITE,
						formattedTextFieldFerite.getText());
			}
			if ((JFormattedTextField) component == formattedTextFieldDanniNonLetali) {
				pgDatiObj = aggiornaOggetti.aggiornaPuntiFerita(pgDatiObj, ListaPgPuntiFerita.DANNI_NON_LETALI,
						formattedTextFieldDanniNonLetali.getText());
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

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == btnAggiungiDanno.getActionCommand()) {
				pgDatiObj = calcolaDati.aggiungiDanno(pgDatiObj);
				pgDatiObj = aggiornaOggetti.aggiornaPuntiFerita(pgDatiObj, ListaPgPuntiFerita.FERITE, "0");

				frame.popolaFrame(pgDatiObj);
			}
			if (((JButton) oggetto).getActionCommand() == btnCuraDanno.getActionCommand()) {
				pgDatiObj = calcolaDati.aggiungiCura(pgDatiObj);
				pgDatiObj = aggiornaOggetti.aggiornaPuntiFerita(pgDatiObj, ListaPgPuntiFerita.FERITE, "0");
				frame.popolaFrame(pgDatiObj);
			}
			if (((JButton) oggetto).getActionCommand() == btnResetDanni.getActionCommand()) {
				pgDatiObj = aggiornaOggetti.aggiornaPuntiFerita(pgDatiObj, ListaPgPuntiFerita.FERITE_ATTUALI, "0");
				frame.popolaFrame(pgDatiObj);
			}
			if (((JButton) oggetto).getActionCommand() == btnAggiungiDannoNonLetale.getActionCommand()) {
				pgDatiObj = calcolaDati.aggiungiDanniNonLetali(pgDatiObj);
				pgDatiObj = aggiornaOggetti.aggiornaPuntiFerita(pgDatiObj, ListaPgPuntiFerita.DANNI_NON_LETALI, "0");
				frame.popolaFrame(pgDatiObj);
			}
			if (((JButton) oggetto).getActionCommand() == btnCuraDanniNonLetali.getActionCommand()) {
				pgDatiObj = calcolaDati.curaDanniNonLetali(pgDatiObj);
				pgDatiObj = aggiornaOggetti.aggiornaPuntiFerita(pgDatiObj, ListaPgPuntiFerita.DANNI_NON_LETALI, "0");
				frame.popolaFrame(pgDatiObj);
			}
			if (((JButton) oggetto).getActionCommand() == btnResetDanniNonLetali.getActionCommand()) {
				pgDatiObj = aggiornaOggetti.aggiornaPuntiFerita(pgDatiObj, ListaPgPuntiFerita.DANNI_NON_LETALI_ATTUALI,
						"0");
				frame.popolaFrame(pgDatiObj);
			}
		}
	}

}
