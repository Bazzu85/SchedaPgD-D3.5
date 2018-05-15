package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaDbArmi;
import ENUM.ListaGestioneDati;
import obj.DbArmiObj;

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

import comboBox.DbArmiComboBox;
import comboBox.PgArmiComboBox;
import java.awt.event.FocusAdapter;

public class GestioneDbArmiObjDialog extends JDialog implements ActionListener, FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7843222803300542368L;
	DbArmiObj dbArmiObj = new DbArmiObj();
	ArrayList<DbArmiObj> arrayArmi = new ArrayList<DbArmiObj>();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	DbArmiComboBox dbArmiComboBox = new DbArmiComboBox();


	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	boolean rigaGestita = false;
	Formati formati = new Formati();

	ListaGestioneDati azione;
	private JButton okButton;
	private JButton cancelButton;
	private JCheckBox chckbxMischia;
	private JCheckBox chckbxDistanza;
	private JTextField textFieldCosto;
	private JLabel lblDanniP;
	private JLabel lblBonusDesMax;
	private JLabel lblDanniG;
	private JLabel lblCritico;
	private JLabel lblIncrementoGittata;
	private JLabel lblPeso;
	private JTextField textFieldPeso;
	private JTextField textFieldDanniP;
	private JTextField textFieldDanniM;
	private JTextField textFieldDanniG;
	private JTextField textFieldCritico;
	private JTextField textFieldIncrementoGittata;
	private JLabel lblTipo;
	private JTextField textFieldTipo;
	private JLabel lblCategoria;
	private JComboBox comboBoxCategoria1;
	private JLabel lblCategoria_1;
	private JComboBox comboBoxCategoria2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DbArmiObj dbArmiObj = new DbArmiObj();
			ArrayList<DbArmiObj> arrayArmi = new ArrayList<DbArmiObj>();

			GestioneDbArmiObjDialog dialog = new GestioneDbArmiObjDialog(ListaGestioneDati.INSERISCI,
					dbArmiObj, arrayArmi);
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
	public GestioneDbArmiObjDialog(ListaGestioneDati azione, DbArmiObj dbArmiObj,
			ArrayList<DbArmiObj> arrayArmi) {
		setModalityType(ModalityType.APPLICATION_MODAL);

		setAzione(azione);
		setDbArmiObj(dbArmiObj);
		setArrayArmaturaScudo(arrayArmi);

		switch (azione) {
		case INSERISCI:
			setTitle("Nuova Armatura/Scudo");
			break;
		case MODIFICA:
			setTitle("Modifica Armatura/Scudo");
			break;
		}
		setBounds(100, 100, 487, 415);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
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
			chckbxMischia = new JCheckBox("Mischia");
			chckbxMischia.addActionListener(this);
			{
				lblCategoria = new JLabel("Categoria 1:");
				GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
				gbc_lblCategoria.anchor = GridBagConstraints.EAST;
				gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
				gbc_lblCategoria.gridx = 0;
				gbc_lblCategoria.gridy = 1;
				contentPanel.add(lblCategoria, gbc_lblCategoria);
			}
			{
				comboBoxCategoria1 = new JComboBox();
				comboBoxCategoria1.addFocusListener(this);
				GridBagConstraints gbc_comboBoxCategoria1 = new GridBagConstraints();
				gbc_comboBoxCategoria1.insets = new Insets(0, 0, 5, 0);
				gbc_comboBoxCategoria1.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBoxCategoria1.gridx = 1;
				gbc_comboBoxCategoria1.gridy = 1;
				contentPanel.add(comboBoxCategoria1, gbc_comboBoxCategoria1);
			}
			{
				lblCategoria_1 = new JLabel("Categoria 2:");
				GridBagConstraints gbc_lblCategoria_1 = new GridBagConstraints();
				gbc_lblCategoria_1.anchor = GridBagConstraints.EAST;
				gbc_lblCategoria_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblCategoria_1.gridx = 0;
				gbc_lblCategoria_1.gridy = 2;
				contentPanel.add(lblCategoria_1, gbc_lblCategoria_1);
			}
			{
				comboBoxCategoria2 = new JComboBox();
				comboBoxCategoria2.addFocusListener(this);
				GridBagConstraints gbc_comboBoxCategoria2 = new GridBagConstraints();
				gbc_comboBoxCategoria2.insets = new Insets(0, 0, 5, 0);
				gbc_comboBoxCategoria2.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBoxCategoria2.gridx = 1;
				gbc_comboBoxCategoria2.gridy = 2;
				contentPanel.add(comboBoxCategoria2, gbc_comboBoxCategoria2);
			}
			GridBagConstraints gbc_chckbxMischia = new GridBagConstraints();
			gbc_chckbxMischia.anchor = GridBagConstraints.EAST;
			gbc_chckbxMischia.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxMischia.gridx = 0;
			gbc_chckbxMischia.gridy = 3;
			contentPanel.add(chckbxMischia, gbc_chckbxMischia);
		}
		{
			chckbxDistanza = new JCheckBox("Distanza");
			chckbxDistanza.addActionListener(this);
			GridBagConstraints gbc_chckbxDistanza = new GridBagConstraints();
			gbc_chckbxDistanza.anchor = GridBagConstraints.WEST;
			gbc_chckbxDistanza.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxDistanza.gridx = 1;
			gbc_chckbxDistanza.gridy = 3;
			contentPanel.add(chckbxDistanza, gbc_chckbxDistanza);
		}
		{
			JLabel lblCaratteristica = new JLabel("Costo:");
			GridBagConstraints gbc_lblCaratteristica = new GridBagConstraints();
			gbc_lblCaratteristica.anchor = GridBagConstraints.EAST;
			gbc_lblCaratteristica.insets = new Insets(0, 0, 5, 5);
			gbc_lblCaratteristica.gridx = 0;
			gbc_lblCaratteristica.gridy = 4;
			contentPanel.add(lblCaratteristica, gbc_lblCaratteristica);
		}
		{
			textFieldCosto = new JTextField();
			textFieldCosto.addFocusListener(this);
			GridBagConstraints gbc_textFieldCosto = new GridBagConstraints();
			gbc_textFieldCosto.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldCosto.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCosto.gridx = 1;
			gbc_textFieldCosto.gridy = 4;
			contentPanel.add(textFieldCosto, gbc_textFieldCosto);
			textFieldCosto.setColumns(10);
		}
		{
			lblDanniP = new JLabel("DanniP:");
			GridBagConstraints gbc_lblDanniP = new GridBagConstraints();
			gbc_lblDanniP.insets = new Insets(0, 0, 5, 5);
			gbc_lblDanniP.anchor = GridBagConstraints.EAST;
			gbc_lblDanniP.gridx = 0;
			gbc_lblDanniP.gridy = 5;
			contentPanel.add(lblDanniP, gbc_lblDanniP);
		}
		{
			textFieldDanniP = new JTextField();
			textFieldDanniP.addFocusListener(this);
			GridBagConstraints gbc_textFieldDanniP = new GridBagConstraints();
			gbc_textFieldDanniP.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldDanniP.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldDanniP.gridx = 1;
			gbc_textFieldDanniP.gridy = 5;
			contentPanel.add(textFieldDanniP, gbc_textFieldDanniP);
			textFieldDanniP.setColumns(10);
		}
		{
			lblBonusDesMax = new JLabel("DanniM:");
			GridBagConstraints gbc_lblBonusDesMax = new GridBagConstraints();
			gbc_lblBonusDesMax.anchor = GridBagConstraints.EAST;
			gbc_lblBonusDesMax.insets = new Insets(0, 0, 5, 5);
			gbc_lblBonusDesMax.gridx = 0;
			gbc_lblBonusDesMax.gridy = 6;
			contentPanel.add(lblBonusDesMax, gbc_lblBonusDesMax);
		}
		{
			textFieldDanniM = new JTextField();
			textFieldDanniM.addFocusListener(this);
			GridBagConstraints gbc_textFieldDanniM = new GridBagConstraints();
			gbc_textFieldDanniM.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldDanniM.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldDanniM.gridx = 1;
			gbc_textFieldDanniM.gridy = 6;
			contentPanel.add(textFieldDanniM, gbc_textFieldDanniM);
			textFieldDanniM.setColumns(10);
		}
		{
			lblDanniG = new JLabel("Danni G:");
			GridBagConstraints gbc_lblDanniG = new GridBagConstraints();
			gbc_lblDanniG.anchor = GridBagConstraints.EAST;
			gbc_lblDanniG.insets = new Insets(0, 0, 5, 5);
			gbc_lblDanniG.gridx = 0;
			gbc_lblDanniG.gridy = 7;
			contentPanel.add(lblDanniG, gbc_lblDanniG);
		}
		{
			textFieldDanniG = new JTextField();
			textFieldDanniG.addFocusListener(this);
			GridBagConstraints gbc_textFieldDanniG = new GridBagConstraints();
			gbc_textFieldDanniG.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldDanniG.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldDanniG.gridx = 1;
			gbc_textFieldDanniG.gridy = 7;
			contentPanel.add(textFieldDanniG, gbc_textFieldDanniG);
			textFieldDanniG.setColumns(10);
		}
		{
			lblCritico = new JLabel("Critico:");
			GridBagConstraints gbc_lblCritico = new GridBagConstraints();
			gbc_lblCritico.anchor = GridBagConstraints.EAST;
			gbc_lblCritico.insets = new Insets(0, 0, 5, 5);
			gbc_lblCritico.gridx = 0;
			gbc_lblCritico.gridy = 8;
			contentPanel.add(lblCritico, gbc_lblCritico);
		}
		{
			textFieldCritico = new JTextField();
			textFieldCritico.addFocusListener(this);
			GridBagConstraints gbc_textFieldCritico = new GridBagConstraints();
			gbc_textFieldCritico.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldCritico.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCritico.gridx = 1;
			gbc_textFieldCritico.gridy = 8;
			contentPanel.add(textFieldCritico, gbc_textFieldCritico);
			textFieldCritico.setColumns(10);
		}
		{
			lblIncrementoGittata = new JLabel("Incremento Gittata:");
			GridBagConstraints gbc_lblIncrementoGittata = new GridBagConstraints();
			gbc_lblIncrementoGittata.anchor = GridBagConstraints.EAST;
			gbc_lblIncrementoGittata.insets = new Insets(0, 0, 5, 5);
			gbc_lblIncrementoGittata.gridx = 0;
			gbc_lblIncrementoGittata.gridy = 9;
			contentPanel.add(lblIncrementoGittata, gbc_lblIncrementoGittata);
		}
		{
			textFieldIncrementoGittata = new JTextField();
			textFieldIncrementoGittata.addFocusListener(this);
			GridBagConstraints gbc_textFieldIncrementoGittata = new GridBagConstraints();
			gbc_textFieldIncrementoGittata.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldIncrementoGittata.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldIncrementoGittata.gridx = 1;
			gbc_textFieldIncrementoGittata.gridy = 9;
			contentPanel.add(textFieldIncrementoGittata, gbc_textFieldIncrementoGittata);
			textFieldIncrementoGittata.setColumns(10);
		}
		{
			{
				lblPeso = new JLabel("Peso:");
				GridBagConstraints gbc_lblPeso = new GridBagConstraints();
				gbc_lblPeso.anchor = GridBagConstraints.EAST;
				gbc_lblPeso.insets = new Insets(0, 0, 5, 5);
				gbc_lblPeso.gridx = 0;
				gbc_lblPeso.gridy = 10;
				contentPanel.add(lblPeso, gbc_lblPeso);
			}
		}
		textFieldPeso = new JTextField();
		textFieldPeso.addFocusListener(this);
		GridBagConstraints gbc_textFieldPeso = new GridBagConstraints();
		gbc_textFieldPeso.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPeso.gridx = 1;
		gbc_textFieldPeso.gridy = 10;
		contentPanel.add(textFieldPeso, gbc_textFieldPeso);
		{
			lblTipo = new JLabel("Tipo:");
			GridBagConstraints gbc_lblTipo = new GridBagConstraints();
			gbc_lblTipo.anchor = GridBagConstraints.EAST;
			gbc_lblTipo.insets = new Insets(0, 0, 0, 5);
			gbc_lblTipo.gridx = 0;
			gbc_lblTipo.gridy = 11;
			contentPanel.add(lblTipo, gbc_lblTipo);
		}
		{
			textFieldTipo = new JTextField();
			textFieldTipo.addFocusListener(this);
			GridBagConstraints gbc_textFieldTipo = new GridBagConstraints();
			gbc_textFieldTipo.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldTipo.gridx = 1;
			gbc_textFieldTipo.gridy = 11;
			contentPanel.add(textFieldTipo, gbc_textFieldTipo);
			textFieldTipo.setColumns(10);
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

	private void popolaFrame() {

		textFieldNome.setText(dbArmiObj.getNome());
		
		// Carica comboBoxCategoria1
		comboBoxCategoria1.setModel(dbArmiComboBox.creaComboBoxCategoria1().getModel());

		if (comboBoxCategoria1.getItemCount() != 0) {
			comboBoxCategoria1.setSelectedIndex(0);
			for (int i = 0; i < comboBoxCategoria1.getItemCount(); i++) {
				if (comboBoxCategoria1.getItemAt(i).toString().equals(dbArmiObj.getCategoria1())) {
					comboBoxCategoria1.setSelectedIndex(i);
				}
			}
		}
		// Carica comboBoxCategoria2
		comboBoxCategoria2.setModel(dbArmiComboBox.creaComboBoxCategoria2().getModel());

		if (comboBoxCategoria2.getItemCount() != 0) {
			comboBoxCategoria2.setSelectedIndex(0);
			for (int i = 0; i < comboBoxCategoria2.getItemCount(); i++) {
				if (comboBoxCategoria2.getItemAt(i).toString().equals(dbArmiObj.getCategoria2())) {
					comboBoxCategoria2.setSelectedIndex(i);
				}
			}
		}
		chckbxMischia.setSelected(dbArmiObj.isMischia());
		chckbxDistanza.setSelected(dbArmiObj.isDistanza());
		textFieldCosto.setText(dbArmiObj.getCosto());
		textFieldDanniP.setText(dbArmiObj.getDanniP());
		textFieldDanniM.setText(dbArmiObj.getDanniM());
		textFieldDanniG.setText(dbArmiObj.getDanniG());
		textFieldCritico.setText(dbArmiObj.getCritico());
		textFieldIncrementoGittata.setText(dbArmiObj.getIncrementoGittata());
		textFieldPeso.setText(String.valueOf(dbArmiObj.getPeso()));
		textFieldTipo.setText(dbArmiObj.getTipo());
	}

	private void gestioneArmaturaScudo() {
		boolean datiOk = true;
		if (datiOk && dbArmiObj.getNome().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Inserire il nome dell'Arma", "Errore",
					JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && dbArmiObj.getCategoria1().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Selezionare la prima categoria dell'arma", "Errore", JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && dbArmiObj.getCategoria2().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Selezionare la seconda categoria dell'arma", "Errore", JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && !dbArmiObj.isMischia() && !dbArmiObj.isDistanza()) {
			JOptionPane.showMessageDialog(this, "Selezionare se l'oggetto è Mischia o Distanza", "Errore",
					JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && dbArmiObj.isMischia() && dbArmiObj.isDistanza()) {
			JOptionPane.showMessageDialog(this, "L'oggetto non può essere sia Mischia che Distanza", "Errore",
					JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && azione == ListaGestioneDati.INSERISCI) {
			for (int i = 0; i < arrayArmi.size(); i++) {
				DbArmiObj dbArmiObjTemp = arrayArmi.get(i);
				if (dbArmiObjTemp.getNome().equals(dbArmiObj.getNome())) {
					JOptionPane.showMessageDialog(this, "Arma già presente nel DB", "Errore",
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

	@SuppressWarnings("rawtypes")
	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();
		
		if (component instanceof JTextField) {
			if ((JTextField) component == textFieldNome) {
				dbArmiObj = aggiornaOggetti.aggiornaDbArmi(dbArmiObj,
						ListaDbArmi.NOME, textFieldNome.getText());
			}
			if ((JTextField) component == textFieldCosto) {
				dbArmiObj = aggiornaOggetti.aggiornaDbArmi(dbArmiObj,
						ListaDbArmi.COSTO, textFieldCosto.getText());
			}
			if ((JTextField) component == textFieldDanniP) {
				dbArmiObj = aggiornaOggetti.aggiornaDbArmi(dbArmiObj,
						ListaDbArmi.DANNIP, textFieldDanniP.getText());
			}
			if ((JTextField) component == textFieldDanniM) {
				dbArmiObj = aggiornaOggetti.aggiornaDbArmi(dbArmiObj,
						ListaDbArmi.DANNIM, textFieldDanniM.getText());
			}
			if ((JTextField) component == textFieldDanniG) {
				dbArmiObj = aggiornaOggetti.aggiornaDbArmi(dbArmiObj,
						ListaDbArmi.DANNIG, textFieldDanniG.getText());
			}
			if ((JTextField) component == textFieldCritico) {
				dbArmiObj = aggiornaOggetti.aggiornaDbArmi(dbArmiObj,
						ListaDbArmi.CRITICO, textFieldCritico.getText());
			}
			if ((JTextField) component == textFieldIncrementoGittata) {
				dbArmiObj = aggiornaOggetti.aggiornaDbArmi(dbArmiObj,
						ListaDbArmi.INCREMENTO_GITTATA, textFieldIncrementoGittata.getText());
			}
			if ((JTextField) component == textFieldTipo) {
				dbArmiObj = aggiornaOggetti.aggiornaDbArmi(dbArmiObj,
						ListaDbArmi.TIPO, textFieldTipo.getText());
			}
			if ((JTextField) component == textFieldPeso) {
				try {
					textFieldPeso.setText(textFieldPeso.getText().replaceAll(",", "."));
					Double d = Double.parseDouble(textFieldPeso.getText());
					dbArmiObj = aggiornaOggetti.aggiornaDbArmi(dbArmiObj,
							ListaDbArmi.PESO,
							textFieldPeso.getText());

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(this, "Formato non valido", "Errore", JOptionPane.ERROR_MESSAGE);
					Double d = 0.0;
					textFieldPeso.setText(String.valueOf(d));
				}
			}
		}
		if (component instanceof JComboBox) {
			if ((JComboBox) component == comboBoxCategoria1) {
				dbArmiObj = aggiornaOggetti.aggiornaDbArmi(dbArmiObj,
						ListaDbArmi.CATEGORIA1, comboBoxCategoria1.getSelectedItem().toString());
			}
			if ((JComboBox) component == comboBoxCategoria2) {
				dbArmiObj = aggiornaOggetti.aggiornaDbArmi(dbArmiObj,
						ListaDbArmi.CATEGORIA2, comboBoxCategoria2.getSelectedItem().toString());
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
			if (((JCheckBox) oggetto).getActionCommand() == chckbxMischia.getActionCommand()) {
				dbArmiObj = aggiornaOggetti.aggiornaDbArmi(dbArmiObj, ListaDbArmi.MISCHIA,
						Boolean.valueOf(chckbxMischia.isSelected()).toString());
			}
			if (((JCheckBox) oggetto).getActionCommand() == chckbxDistanza.getActionCommand()) {
				dbArmiObj = aggiornaOggetti.aggiornaDbArmi(dbArmiObj, ListaDbArmi.DISTANZA,
						Boolean.valueOf(chckbxDistanza.isSelected()).toString());
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

	public DbArmiObj getDbArmiObj() {
		return dbArmiObj;
	}

	public void setDbArmiObj(DbArmiObj dbArmiObj) {
		this.dbArmiObj = dbArmiObj;
	}

	public ArrayList<DbArmiObj> getArrayArmaturaScudo() {
		return arrayArmi;
	}

	public void setArrayArmaturaScudo(ArrayList<DbArmiObj> arrayArmi) {
		this.arrayArmi = arrayArmi;
	}

}
