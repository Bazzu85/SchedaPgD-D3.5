package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaDbArmaturaScudo;
import ENUM.ListaDbArmi;
import ENUM.ListaGestioneDati;
import comboBox.DbAbilitaComboBox;
import comboBox.DbArmaturaScudoComboBox;
import comboBox.DbArmiComboBox;
import obj.DbArmaturaScudoObj;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.beans.Beans;
import java.util.ArrayList;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;

@SuppressWarnings("serial")
public class GestioneDbArmaturaScudoObjDialog extends JDialog implements ActionListener, FocusListener {

	DbArmaturaScudoObj dbArmaturaScudoObj = new DbArmaturaScudoObj();
	ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo = new ArrayList<DbArmaturaScudoObj>();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	DbArmaturaScudoComboBox dbArmaturaScudoComboBox = new DbArmaturaScudoComboBox();

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	boolean rigaGestita = false;
	Formati formati = new Formati();

	ListaGestioneDati azione;
	private JButton okButton;
	private JButton cancelButton;
	private JCheckBox chckbxArmatura;
	private JCheckBox chckbxScudo;
	private JTextField textFieldCosto;
	private JFormattedTextField formattedTextFieldBonus;
	private JLabel lblBonus;
	private JLabel lblBonusDesMax;
	private JFormattedTextField formattedTextFieldBonusDesMax;
	private JLabel lblPenalitAllaProva;
	private JFormattedTextField formattedTextFieldPenalitaProvaArmatura;
	private JLabel lblFallimentoIncantesimiArcani;
	private JFormattedTextField formattedTextFieldFallimentoIncantesimiArcani;
	private JLabel lblVelocitm;
	private JTextField textFieldVelocita9M;
	private JLabel lblVelocitm_1;
	private JTextField textFieldVelocita6M;
	private JLabel lblPeso;
	private JTextField textFieldPeso;
	private JLabel lblCategoria;
	private JComboBox comboBoxCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DbArmaturaScudoObj dbArmaturaScudoObj = new DbArmaturaScudoObj();
			ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo = new ArrayList<DbArmaturaScudoObj>();

			GestioneDbArmaturaScudoObjDialog dialog = new GestioneDbArmaturaScudoObjDialog(ListaGestioneDati.INSERISCI,
					dbArmaturaScudoObj, arrayArmaturaScudo);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param prg
	 * @param azione
	 */
	public GestioneDbArmaturaScudoObjDialog(ListaGestioneDati azione, DbArmaturaScudoObj dbArmaturaScudoObj,
			ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo) {
		setModalityType(ModalityType.APPLICATION_MODAL);

		setAzione(azione);
		setDbArmaturaScudoObj(dbArmaturaScudoObj);
		setArrayArmaturaScudo(arrayArmaturaScudo);

		NumberFormatter soloNumeriConSegno = formati.getSoloNumeriConSegno();
		switch (azione) {
		case INSERISCI:
			setTitle("Nuova Armatura/Scudo");
			break;
		case MODIFICA:
			setTitle("Modifica Armatura/Scudo");
			break;
		}
		setBounds(100, 100, 487, 375);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNome = new JLabel("Nome:");
			GridBagConstraints gbc_lblNome = new GridBagConstraints();
			gbc_lblNome.anchor = GridBagConstraints.EAST;
			gbc_lblNome.insets = new Insets(0, 0, 5, 5);
			gbc_lblNome.gridx = 0;
			gbc_lblNome.gridy = 0;
			contentPanel.add(lblNome, gbc_lblNome);
		}
		{
			textFieldNome = new JTextField();
			if (azione == ListaGestioneDati.MODIFICA) {
				textFieldNome.setEnabled(false);
				textFieldNome.setEditable(false);
			}
			textFieldNome.addFocusListener(this);
			GridBagConstraints gbc_textFieldNome = new GridBagConstraints();
			gbc_textFieldNome.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldNome.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldNome.gridx = 1;
			gbc_textFieldNome.gridy = 0;
			contentPanel.add(textFieldNome, gbc_textFieldNome);
			textFieldNome.setColumns(10);
		}
		{
			chckbxArmatura = new JCheckBox("Armatura");
			chckbxArmatura.addActionListener(this);
			{
				lblCategoria = new JLabel("Categoria:");
				GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
				gbc_lblCategoria.anchor = GridBagConstraints.EAST;
				gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
				gbc_lblCategoria.gridx = 0;
				gbc_lblCategoria.gridy = 1;
				contentPanel.add(lblCategoria, gbc_lblCategoria);
			}
			{
				comboBoxCategoria = new JComboBox();
				comboBoxCategoria.addFocusListener(this);
				GridBagConstraints gbc_comboBoxCategoria = new GridBagConstraints();
				gbc_comboBoxCategoria.insets = new Insets(0, 0, 5, 0);
				gbc_comboBoxCategoria.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBoxCategoria.gridx = 1;
				gbc_comboBoxCategoria.gridy = 1;
				contentPanel.add(comboBoxCategoria, gbc_comboBoxCategoria);
			}
			GridBagConstraints gbc_chckbxArmatura = new GridBagConstraints();
			gbc_chckbxArmatura.anchor = GridBagConstraints.EAST;
			gbc_chckbxArmatura.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxArmatura.gridx = 0;
			gbc_chckbxArmatura.gridy = 2;
			contentPanel.add(chckbxArmatura, gbc_chckbxArmatura);
		}
		{
			chckbxScudo = new JCheckBox("Scudo");
			chckbxScudo.addActionListener(this);
			GridBagConstraints gbc_chckbxScudo = new GridBagConstraints();
			gbc_chckbxScudo.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxScudo.gridx = 1;
			gbc_chckbxScudo.gridy = 2;
			contentPanel.add(chckbxScudo, gbc_chckbxScudo);
		}
		{
			JLabel lblCaratteristica = new JLabel("Costo:");
			GridBagConstraints gbc_lblCaratteristica = new GridBagConstraints();
			gbc_lblCaratteristica.anchor = GridBagConstraints.EAST;
			gbc_lblCaratteristica.insets = new Insets(0, 0, 5, 5);
			gbc_lblCaratteristica.gridx = 0;
			gbc_lblCaratteristica.gridy = 3;
			contentPanel.add(lblCaratteristica, gbc_lblCaratteristica);
		}
		{
			textFieldCosto = new JTextField();
			textFieldCosto.addFocusListener(this);
			GridBagConstraints gbc_textFieldCosto = new GridBagConstraints();
			gbc_textFieldCosto.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldCosto.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCosto.gridx = 1;
			gbc_textFieldCosto.gridy = 3;
			contentPanel.add(textFieldCosto, gbc_textFieldCosto);
			textFieldCosto.setColumns(10);
		}
		{
			lblBonus = new JLabel("Bonus:");
			GridBagConstraints gbc_lblBonus = new GridBagConstraints();
			gbc_lblBonus.insets = new Insets(0, 0, 5, 5);
			gbc_lblBonus.anchor = GridBagConstraints.EAST;
			gbc_lblBonus.gridx = 0;
			gbc_lblBonus.gridy = 4;
			contentPanel.add(lblBonus, gbc_lblBonus);
		}
		{
			formattedTextFieldBonus = new JFormattedTextField(soloNumeriConSegno);
			formattedTextFieldBonus.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldBonus = new GridBagConstraints();
			gbc_formattedTextFieldBonus.insets = new Insets(0, 0, 5, 0);
			gbc_formattedTextFieldBonus.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldBonus.gridx = 1;
			gbc_formattedTextFieldBonus.gridy = 4;
			contentPanel.add(formattedTextFieldBonus, gbc_formattedTextFieldBonus);
		}
		{
			lblBonusDesMax = new JLabel("Bonus Des. Max:");
			GridBagConstraints gbc_lblBonusDesMax = new GridBagConstraints();
			gbc_lblBonusDesMax.anchor = GridBagConstraints.EAST;
			gbc_lblBonusDesMax.insets = new Insets(0, 0, 5, 5);
			gbc_lblBonusDesMax.gridx = 0;
			gbc_lblBonusDesMax.gridy = 5;
			contentPanel.add(lblBonusDesMax, gbc_lblBonusDesMax);
		}
		{
			formattedTextFieldBonusDesMax = new JFormattedTextField(soloNumeriConSegno);
			formattedTextFieldBonusDesMax.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldBonusDesMax = new GridBagConstraints();
			gbc_formattedTextFieldBonusDesMax.insets = new Insets(0, 0, 5, 0);
			gbc_formattedTextFieldBonusDesMax.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldBonusDesMax.gridx = 1;
			gbc_formattedTextFieldBonusDesMax.gridy = 5;
			contentPanel.add(formattedTextFieldBonusDesMax, gbc_formattedTextFieldBonusDesMax);
		}
		{
			lblPenalitAllaProva = new JLabel("Penalit\u00E0 alla Prova Armatura:");
			GridBagConstraints gbc_lblPenalitAllaProva = new GridBagConstraints();
			gbc_lblPenalitAllaProva.anchor = GridBagConstraints.EAST;
			gbc_lblPenalitAllaProva.insets = new Insets(0, 0, 5, 5);
			gbc_lblPenalitAllaProva.gridx = 0;
			gbc_lblPenalitAllaProva.gridy = 6;
			contentPanel.add(lblPenalitAllaProva, gbc_lblPenalitAllaProva);
		}
		{
			formattedTextFieldPenalitaProvaArmatura = new JFormattedTextField(soloNumeriConSegno);
			formattedTextFieldPenalitaProvaArmatura.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldPenalitaProvaArmatura = new GridBagConstraints();
			gbc_formattedTextFieldPenalitaProvaArmatura.insets = new Insets(0, 0, 5, 0);
			gbc_formattedTextFieldPenalitaProvaArmatura.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldPenalitaProvaArmatura.gridx = 1;
			gbc_formattedTextFieldPenalitaProvaArmatura.gridy = 6;
			contentPanel.add(formattedTextFieldPenalitaProvaArmatura, gbc_formattedTextFieldPenalitaProvaArmatura);
		}
		{
			lblFallimentoIncantesimiArcani = new JLabel("Fallimento Incantesimi Arcani:");
			GridBagConstraints gbc_lblFallimentoIncantesimiArcani = new GridBagConstraints();
			gbc_lblFallimentoIncantesimiArcani.anchor = GridBagConstraints.EAST;
			gbc_lblFallimentoIncantesimiArcani.insets = new Insets(0, 0, 5, 5);
			gbc_lblFallimentoIncantesimiArcani.gridx = 0;
			gbc_lblFallimentoIncantesimiArcani.gridy = 7;
			contentPanel.add(lblFallimentoIncantesimiArcani, gbc_lblFallimentoIncantesimiArcani);
		}
		{
			formattedTextFieldFallimentoIncantesimiArcani = new JFormattedTextField(soloNumeriConSegno);
			formattedTextFieldFallimentoIncantesimiArcani.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldFallimentoIncantesimiArcani = new GridBagConstraints();
			gbc_formattedTextFieldFallimentoIncantesimiArcani.insets = new Insets(0, 0, 5, 0);
			gbc_formattedTextFieldFallimentoIncantesimiArcani.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldFallimentoIncantesimiArcani.gridx = 1;
			gbc_formattedTextFieldFallimentoIncantesimiArcani.gridy = 7;
			contentPanel.add(formattedTextFieldFallimentoIncantesimiArcani,
					gbc_formattedTextFieldFallimentoIncantesimiArcani);
		}
		{
			lblVelocitm = new JLabel("Velocit\u00E0 9M:");
			GridBagConstraints gbc_lblVelocitm = new GridBagConstraints();
			gbc_lblVelocitm.anchor = GridBagConstraints.EAST;
			gbc_lblVelocitm.insets = new Insets(0, 0, 5, 5);
			gbc_lblVelocitm.gridx = 0;
			gbc_lblVelocitm.gridy = 8;
			contentPanel.add(lblVelocitm, gbc_lblVelocitm);
		}
		{
			textFieldVelocita9M = new JTextField();
			textFieldVelocita9M.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldVelocita9M = new GridBagConstraints();
			gbc_formattedTextFieldVelocita9M.insets = new Insets(0, 0, 5, 0);
			gbc_formattedTextFieldVelocita9M.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldVelocita9M.gridx = 1;
			gbc_formattedTextFieldVelocita9M.gridy = 8;
			contentPanel.add(textFieldVelocita9M, gbc_formattedTextFieldVelocita9M);
		}
		{
			lblVelocitm_1 = new JLabel("Velocit\u00E0 6M:");
			GridBagConstraints gbc_lblVelocitm_1 = new GridBagConstraints();
			gbc_lblVelocitm_1.anchor = GridBagConstraints.EAST;
			gbc_lblVelocitm_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblVelocitm_1.gridx = 0;
			gbc_lblVelocitm_1.gridy = 9;
			contentPanel.add(lblVelocitm_1, gbc_lblVelocitm_1);
		}
		{
			textFieldVelocita6M = new JTextField();
			textFieldVelocita6M.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldVelocita6M = new GridBagConstraints();
			gbc_formattedTextFieldVelocita6M.insets = new Insets(0, 0, 5, 0);
			gbc_formattedTextFieldVelocita6M.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldVelocita6M.gridx = 1;
			gbc_formattedTextFieldVelocita6M.gridy = 9;
			contentPanel.add(textFieldVelocita6M, gbc_formattedTextFieldVelocita6M);
		}
		{
			lblPeso = new JLabel("Peso:");
			GridBagConstraints gbc_lblPeso = new GridBagConstraints();
			gbc_lblPeso.anchor = GridBagConstraints.EAST;
			gbc_lblPeso.insets = new Insets(0, 0, 0, 5);
			gbc_lblPeso.gridx = 0;
			gbc_lblPeso.gridy = 10;
			contentPanel.add(lblPeso, gbc_lblPeso);
		}
		{
			textFieldPeso = new JTextField();
			textFieldPeso.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldPeso = new GridBagConstraints();
			gbc_formattedTextFieldPeso.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldPeso.gridx = 1;
			gbc_formattedTextFieldPeso.gridy = 10;
			contentPanel.add(textFieldPeso, gbc_formattedTextFieldPeso);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(null);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		if (!Beans.isDesignTime()) {
			popolaFrame();
		}
	}

	@SuppressWarnings("unchecked")
	private void popolaFrame() {

		textFieldNome.setText(dbArmaturaScudoObj.getNome());
		// Carica comboBoxCategoria1
		comboBoxCategoria.setModel(dbArmaturaScudoComboBox.creaComboBoxCategoria().getModel());

		if (comboBoxCategoria.getItemCount() != 0) {
			comboBoxCategoria.setSelectedIndex(0);
			for (int i = 0; i < comboBoxCategoria.getItemCount(); i++) {
				if (comboBoxCategoria.getItemAt(i).toString().equals(dbArmaturaScudoObj.getCategoria())) {
					comboBoxCategoria.setSelectedIndex(i);
				}
			}
		}
		chckbxArmatura.setSelected(dbArmaturaScudoObj.isArmatura());
		chckbxScudo.setSelected(dbArmaturaScudoObj.isScudo());
		textFieldCosto.setText(dbArmaturaScudoObj.getCosto());
		formattedTextFieldBonus.setValue(dbArmaturaScudoObj.getBonus());
		formattedTextFieldBonusDesMax.setValue(dbArmaturaScudoObj.getBonusDesMax());
		formattedTextFieldPenalitaProvaArmatura.setValue(dbArmaturaScudoObj.getPenalitaProvaArmatura());
		formattedTextFieldFallimentoIncantesimiArcani.setValue(dbArmaturaScudoObj.getFallimentoIncantesimiArcani());
		textFieldVelocita9M.setText(String.valueOf(dbArmaturaScudoObj.getVelocita9M()));
		textFieldVelocita6M.setText(String.valueOf(dbArmaturaScudoObj.getVelocita6M()));
		textFieldPeso.setText(String.valueOf(dbArmaturaScudoObj.getPeso()));
	}

	private void gestioneArmaturaScudo() {
		boolean datiOk = true;
		if (datiOk && dbArmaturaScudoObj.getNome().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Inserire il nome", "Errore", JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && dbArmaturaScudoObj.getCategoria().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Selezionare la categoria", "Errore", JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && !dbArmaturaScudoObj.isArmatura() && !dbArmaturaScudoObj.isScudo()) {
			JOptionPane.showMessageDialog(this, "Selezionare se l'oggetto è una Armatura o uno Scudo", "Errore",
					JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && dbArmaturaScudoObj.isArmatura() && dbArmaturaScudoObj.isScudo()) {
			JOptionPane.showMessageDialog(this, "L'oggetto non può essere sia Armatura che Scudo", "Errore",
					JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && azione == ListaGestioneDati.INSERISCI) {
			for (int i = 0; i < arrayArmaturaScudo.size(); i++) {
				DbArmaturaScudoObj dbAbilitaObjTemp = arrayArmaturaScudo.get(i);
				if (dbAbilitaObjTemp.getNome().equals(dbArmaturaScudoObj.getNome())) {
					JOptionPane.showMessageDialog(this, "Armatura/Scudo già presente nel DB", "Errore",
							JOptionPane.ERROR_MESSAGE);
					datiOk = false;
				}
			}
		}

		if (datiOk) {
			rigaGestita = true;
			setVisible(false);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTextField) {
			if ((JTextField) component == textFieldNome) {
				dbArmaturaScudoObj = aggiornaOggetti.aggiornaDbArmaturaScudo(dbArmaturaScudoObj,
						ListaDbArmaturaScudo.NOME, textFieldNome.getText());
			}
			if ((JTextField) component == textFieldCosto) {
				dbArmaturaScudoObj = aggiornaOggetti.aggiornaDbArmaturaScudo(dbArmaturaScudoObj,
						ListaDbArmaturaScudo.COSTO, textFieldCosto.getText());
			}
			if ((JTextField) component == textFieldVelocita9M) {
				try {
					textFieldVelocita9M.setText(textFieldVelocita9M.getText().replaceAll(",", "."));
					Double d = Double.parseDouble(textFieldVelocita9M.getText());
					dbArmaturaScudoObj = aggiornaOggetti.aggiornaDbArmaturaScudo(dbArmaturaScudoObj,
							ListaDbArmaturaScudo.VELOCITA_9M, textFieldVelocita9M.getText());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(this, "Formato non valido", "Errore", JOptionPane.ERROR_MESSAGE);
					Double d = 0.0;
					textFieldVelocita9M.setText(String.valueOf(d));

				}
			}
			if ((JTextField) component == textFieldVelocita6M) {
				try {
					textFieldVelocita6M.setText(textFieldVelocita6M.getText().replaceAll(",", "."));
					Double d = Double.parseDouble(textFieldVelocita6M.getText());
					dbArmaturaScudoObj = aggiornaOggetti.aggiornaDbArmaturaScudo(dbArmaturaScudoObj,
							ListaDbArmaturaScudo.VELOCITA_6M, textFieldVelocita6M.getText());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(this, "Formato non valido", "Errore", JOptionPane.ERROR_MESSAGE);
					Double d = 0.0;
					textFieldVelocita6M.setText(String.valueOf(d));

				}
			}

			if ((JTextField) component == textFieldPeso) {
				try {
					textFieldPeso.setText(textFieldPeso.getText().replaceAll(",", "."));
					Double d = Double.parseDouble(textFieldPeso.getText());
					dbArmaturaScudoObj = aggiornaOggetti.aggiornaDbArmaturaScudo(dbArmaturaScudoObj,
							ListaDbArmaturaScudo.PESO, textFieldPeso.getText());

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(this, "Formato non valido", "Errore", JOptionPane.ERROR_MESSAGE);
					Double d = 0.0;
					textFieldPeso.setText(String.valueOf(d));
				}
			}
		}

		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldBonus) {
				dbArmaturaScudoObj = aggiornaOggetti.aggiornaDbArmaturaScudo(dbArmaturaScudoObj,
						ListaDbArmaturaScudo.BONUS, formattedTextFieldBonus.getText());
			}
			if ((JFormattedTextField) component == formattedTextFieldBonusDesMax) {
				dbArmaturaScudoObj = aggiornaOggetti.aggiornaDbArmaturaScudo(dbArmaturaScudoObj,
						ListaDbArmaturaScudo.BONUS_DES_MAX, formattedTextFieldBonusDesMax.getText());
			}
			if ((JFormattedTextField) component == formattedTextFieldPenalitaProvaArmatura) {
				dbArmaturaScudoObj = aggiornaOggetti.aggiornaDbArmaturaScudo(dbArmaturaScudoObj,
						ListaDbArmaturaScudo.PENALITA_PROVA_ARMATURA,
						formattedTextFieldPenalitaProvaArmatura.getText());
			}
			if ((JFormattedTextField) component == formattedTextFieldFallimentoIncantesimiArcani) {
				dbArmaturaScudoObj = aggiornaOggetti.aggiornaDbArmaturaScudo(dbArmaturaScudoObj,
						ListaDbArmaturaScudo.FALLIMENTO_INCANTESIMI_ARCANI,
						formattedTextFieldFallimentoIncantesimiArcani.getText());
			}
		}
		if (component instanceof JComboBox) {
			if ((JComboBox) component == comboBoxCategoria) {
				dbArmaturaScudoObj = aggiornaOggetti.aggiornaDbArmaturaScudo(dbArmaturaScudoObj,
						ListaDbArmaturaScudo.CATEGORIA, comboBoxCategoria.getSelectedItem().toString());
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == okButton.getActionCommand()) {
				gestioneArmaturaScudo();
			}
			if (((JButton) oggetto).getActionCommand() == cancelButton.getActionCommand()) {
				setVisible(false);
			}
		}
		if (oggetto instanceof JCheckBox) {
			if (((JCheckBox) oggetto).getActionCommand() == chckbxArmatura.getActionCommand()) {
				dbArmaturaScudoObj = aggiornaOggetti.aggiornaDbArmaturaScudo(dbArmaturaScudoObj,
						ListaDbArmaturaScudo.ARMATURA, Boolean.valueOf(chckbxArmatura.isSelected()).toString());
			}
			if (((JCheckBox) oggetto).getActionCommand() == chckbxScudo.getActionCommand()) {
				dbArmaturaScudoObj = aggiornaOggetti.aggiornaDbArmaturaScudo(dbArmaturaScudoObj,
						ListaDbArmaturaScudo.SCUDO, Boolean.valueOf(chckbxScudo.isSelected()).toString());
			}
		}
	}

	public ListaGestioneDati getAzione() {
		return azione;
	}

	public void setAzione(ListaGestioneDati azione) {
		this.azione = azione;
	}

	public boolean isRigaGestita() {
		return rigaGestita;
	}

	public void setRigaGestita(boolean rigaGestita) {
		this.rigaGestita = rigaGestita;
	}

	public DbArmaturaScudoObj getDbArmaturaScudoObj() {
		return dbArmaturaScudoObj;
	}

	public void setDbArmaturaScudoObj(DbArmaturaScudoObj dbArmaturaScudoObj) {
		this.dbArmaturaScudoObj = dbArmaturaScudoObj;
	}

	public ArrayList<DbArmaturaScudoObj> getArrayArmaturaScudo() {
		return arrayArmaturaScudo;
	}

	public void setArrayArmaturaScudo(ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo) {
		this.arrayArmaturaScudo = arrayArmaturaScudo;
	}

}
