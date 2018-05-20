package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaGestioneDati;
import ENUM.ListaPgArmi;
import comboBox.PgArmiComboBox;
import obj.PgArmiObj;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.Beans;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;

public class GestionePgArmiObjDialog extends JDialog implements FocusListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5037386431755292296L;
	private final JPanel contentPanel = new JPanel();
	PgArmiComboBox acb = new PgArmiComboBox();
	int id = 0;
	int prg = 0;
	PgArmiObj pgArmiObj = new PgArmiObj();
	ArrayList<PgArmiObj> arrayArmi = new ArrayList<PgArmiObj>();

	boolean rigaGestita = false;
	ListaGestioneDati azione;

	private JTextField textFieldIncantamento;

	Formati formati = new Formati();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	private JFormattedTextField formattedTextFieldMod;
	private JTextField textFieldBonusIncantamento;
	private JFormattedTextField formattedTextFieldModBab;
	private JFormattedTextField formattedTextFieldModDanno;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxArma;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxTaglia;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxQualita;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxPrimariaSecondaria;
	private JCheckBox chckbxTenuta2Mani;
	private JCheckBox chckbxDoppiaArma;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textFieldModBabDescrizione;
	private JTextField textFieldModDannoDescrizione;
	private JCheckBox chckbxEquipaggiata;
	private JLabel lblNomeArma;
	private JTextField textFieldNomeArma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			System.out.println(e.getMessage());
		}

		try {
			PgArmiObj pgArmiObj = new PgArmiObj();
			ArrayList<PgArmiObj> arrayArmi = new ArrayList<PgArmiObj>();
			GestionePgArmiObjDialog dialog = new GestionePgArmiObjDialog(ListaGestioneDati.INSERISCI, 0, pgArmiObj, arrayArmi);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param id
	 * @param arrayArmi 
	 */
	@SuppressWarnings("rawtypes")
	public GestionePgArmiObjDialog(ListaGestioneDati azione, int id, PgArmiObj pgArmiObj, ArrayList<PgArmiObj> arrayArmi) {

		setAzione(azione);
		setId(id);
		setPgArmiObj(pgArmiObj);
		setArrayArmi(arrayArmi);
		
		NumberFormatter soloNumeriConSegno = formati.getSoloNumeriConSegno();

		switch (azione) {
		case INSERISCI:
			setTitle("Nuova Arma");
			break;
		case MODIFICA:
			setTitle("Modifica Arma");
			break;
		}

		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 451, 387);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 60, 130, 236, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblArma = new JLabel("Arma:");
			GridBagConstraints gbc_lblArma = new GridBagConstraints();
			gbc_lblArma.insets = new Insets(0, 0, 5, 5);
			gbc_lblArma.anchor = GridBagConstraints.EAST;
			gbc_lblArma.gridx = 0;
			gbc_lblArma.gridy = 0;
			contentPanel.add(lblArma, gbc_lblArma);
		}
		{
			comboBoxArma = new JComboBox();
			comboBoxArma.addFocusListener(this);
			GridBagConstraints gbc_comboBoxArma = new GridBagConstraints();
			gbc_comboBoxArma.gridwidth = 2;
			gbc_comboBoxArma.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxArma.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxArma.gridx = 1;
			gbc_comboBoxArma.gridy = 0;
			contentPanel.add(comboBoxArma, gbc_comboBoxArma);
		}
		{
			chckbxEquipaggiata = new JCheckBox("Equipaggiata");
			chckbxEquipaggiata.addActionListener(this);
			GridBagConstraints gbc_chckbxEquipaggiata = new GridBagConstraints();
			gbc_chckbxEquipaggiata.anchor = GridBagConstraints.WEST;
			gbc_chckbxEquipaggiata.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxEquipaggiata.gridx = 3;
			gbc_chckbxEquipaggiata.gridy = 0;
			contentPanel.add(chckbxEquipaggiata, gbc_chckbxEquipaggiata);
		}
		{
			lblNomeArma = new JLabel("Nome Arma:");
			GridBagConstraints gbc_lblNomeArma = new GridBagConstraints();
			gbc_lblNomeArma.anchor = GridBagConstraints.EAST;
			gbc_lblNomeArma.insets = new Insets(0, 0, 5, 5);
			gbc_lblNomeArma.gridx = 0;
			gbc_lblNomeArma.gridy = 1;
			contentPanel.add(lblNomeArma, gbc_lblNomeArma);
		}
		{
			textFieldNomeArma = new JTextField();
			textFieldNomeArma.addFocusListener(this);
			GridBagConstraints gbc_textFieldNomeArma = new GridBagConstraints();
			gbc_textFieldNomeArma.gridwidth = 3;
			gbc_textFieldNomeArma.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldNomeArma.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldNomeArma.gridx = 1;
			gbc_textFieldNomeArma.gridy = 1;
			contentPanel.add(textFieldNomeArma, gbc_textFieldNomeArma);
			textFieldNomeArma.setColumns(10);
		}
		{
			JLabel lblTaglia = new JLabel("Taglia:");
			GridBagConstraints gbc_lblTaglia = new GridBagConstraints();
			gbc_lblTaglia.anchor = GridBagConstraints.EAST;
			gbc_lblTaglia.insets = new Insets(0, 0, 5, 5);
			gbc_lblTaglia.gridx = 0;
			gbc_lblTaglia.gridy = 2;
			contentPanel.add(lblTaglia, gbc_lblTaglia);
		}
		{
			comboBoxTaglia = new JComboBox();
			comboBoxTaglia.addFocusListener(this);
			GridBagConstraints gbc_comboBoxTaglia = new GridBagConstraints();
			gbc_comboBoxTaglia.gridwidth = 2;
			gbc_comboBoxTaglia.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxTaglia.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxTaglia.gridx = 1;
			gbc_comboBoxTaglia.gridy = 2;
			contentPanel.add(comboBoxTaglia, gbc_comboBoxTaglia);
		}
		{
			JLabel lblQualita = new JLabel("Qualit\u00E0:");
			GridBagConstraints gbc_lblQualita = new GridBagConstraints();
			gbc_lblQualita.anchor = GridBagConstraints.EAST;
			gbc_lblQualita.insets = new Insets(0, 0, 5, 5);
			gbc_lblQualita.gridx = 0;
			gbc_lblQualita.gridy = 3;
			contentPanel.add(lblQualita, gbc_lblQualita);
		}
		{
			comboBoxQualita = new JComboBox();
			comboBoxQualita.addFocusListener(this);
			GridBagConstraints gbc_comboBoxQualita = new GridBagConstraints();
			gbc_comboBoxQualita.gridwidth = 2;
			gbc_comboBoxQualita.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxQualita.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxQualita.gridx = 1;
			gbc_comboBoxQualita.gridy = 3;
			contentPanel.add(comboBoxQualita, gbc_comboBoxQualita);
		}
		{
			JLabel lblMod = new JLabel("Mod:");
			GridBagConstraints gbc_lblMod = new GridBagConstraints();
			gbc_lblMod.anchor = GridBagConstraints.EAST;
			gbc_lblMod.insets = new Insets(0, 0, 5, 5);
			gbc_lblMod.gridx = 0;
			gbc_lblMod.gridy = 4;
			contentPanel.add(lblMod, gbc_lblMod);
		}
		{
			formattedTextFieldMod = new JFormattedTextField(soloNumeriConSegno);
			formattedTextFieldMod.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldMod = new GridBagConstraints();
			gbc_formattedTextFieldMod.insets = new Insets(0, 0, 5, 5);
			gbc_formattedTextFieldMod.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldMod.gridx = 1;
			gbc_formattedTextFieldMod.gridy = 4;
			contentPanel.add(formattedTextFieldMod, gbc_formattedTextFieldMod);
		}
		{
			JLabel lblIncantamento = new JLabel("Incantamento:");
			GridBagConstraints gbc_lblIncantamento = new GridBagConstraints();
			gbc_lblIncantamento.anchor = GridBagConstraints.EAST;
			gbc_lblIncantamento.insets = new Insets(0, 0, 5, 5);
			gbc_lblIncantamento.gridx = 0;
			gbc_lblIncantamento.gridy = 5;
			contentPanel.add(lblIncantamento, gbc_lblIncantamento);
		}
		{
			textFieldIncantamento = new JTextField();
			textFieldIncantamento.setToolTipText("Incantamenti (es Infuocata)");
			textFieldIncantamento.addFocusListener(this);
			GridBagConstraints gbc_textFieldIncantamento = new GridBagConstraints();
			gbc_textFieldIncantamento.gridwidth = 2;
			gbc_textFieldIncantamento.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldIncantamento.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldIncantamento.gridx = 1;
			gbc_textFieldIncantamento.gridy = 5;
			contentPanel.add(textFieldIncantamento, gbc_textFieldIncantamento);
			textFieldIncantamento.setColumns(10);
		}
		{
			JLabel lblBonusIncantamento = new JLabel("Bonus Incantamento:");
			GridBagConstraints gbc_lblBonusIncantamento = new GridBagConstraints();
			gbc_lblBonusIncantamento.anchor = GridBagConstraints.EAST;
			gbc_lblBonusIncantamento.insets = new Insets(0, 0, 5, 5);
			gbc_lblBonusIncantamento.gridx = 0;
			gbc_lblBonusIncantamento.gridy = 6;
			contentPanel.add(lblBonusIncantamento, gbc_lblBonusIncantamento);
		}
		{
			textFieldBonusIncantamento = new JTextField();
			textFieldBonusIncantamento.setToolTipText("Bonus incantamento (es 1d6)");
			textFieldBonusIncantamento.addFocusListener(this);
			GridBagConstraints gbc_textFieldBonusIncantamento = new GridBagConstraints();
			gbc_textFieldBonusIncantamento.gridwidth = 2;
			gbc_textFieldBonusIncantamento.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldBonusIncantamento.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldBonusIncantamento.gridx = 1;
			gbc_textFieldBonusIncantamento.gridy = 6;
			contentPanel.add(textFieldBonusIncantamento, gbc_textFieldBonusIncantamento);
		}
		{
			JLabel lblModBab = new JLabel("Mod. al Bab:");
			GridBagConstraints gbc_lblModBab = new GridBagConstraints();
			gbc_lblModBab.anchor = GridBagConstraints.EAST;
			gbc_lblModBab.insets = new Insets(0, 0, 5, 5);
			gbc_lblModBab.gridx = 0;
			gbc_lblModBab.gridy = 7;
			contentPanel.add(lblModBab, gbc_lblModBab);
		}
		{
			formattedTextFieldModBab = new JFormattedTextField(soloNumeriConSegno);
			formattedTextFieldModBab.setToolTipText("Modificatore al BAB specifico per l'arma");
			formattedTextFieldModBab.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldModBab = new GridBagConstraints();
			gbc_formattedTextFieldModBab.insets = new Insets(0, 0, 5, 5);
			gbc_formattedTextFieldModBab.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldModBab.gridx = 1;
			gbc_formattedTextFieldModBab.gridy = 7;
			contentPanel.add(formattedTextFieldModBab, gbc_formattedTextFieldModBab);
		}
		{
			textFieldModBabDescrizione = new JTextField();
			textFieldModBabDescrizione.addFocusListener(this);
			textFieldModBabDescrizione.setToolTipText("Descrizione del modificatore");
			GridBagConstraints gbc_textFieldModBabDescrizione = new GridBagConstraints();
			gbc_textFieldModBabDescrizione.gridwidth = 2;
			gbc_textFieldModBabDescrizione.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldModBabDescrizione.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldModBabDescrizione.gridx = 2;
			gbc_textFieldModBabDescrizione.gridy = 7;
			contentPanel.add(textFieldModBabDescrizione, gbc_textFieldModBabDescrizione);
			textFieldModBabDescrizione.setColumns(10);
		}
		{
			JLabel lblModDanno = new JLabel("Mod. al Danno:");
			GridBagConstraints gbc_lblModDanno = new GridBagConstraints();
			gbc_lblModDanno.anchor = GridBagConstraints.EAST;
			gbc_lblModDanno.insets = new Insets(0, 0, 5, 5);
			gbc_lblModDanno.gridx = 0;
			gbc_lblModDanno.gridy = 8;
			contentPanel.add(lblModDanno, gbc_lblModDanno);
		}
		{
			formattedTextFieldModDanno = new JFormattedTextField(soloNumeriConSegno);
			formattedTextFieldModDanno.setToolTipText("Modificare al danno specifico per l'arma");
			formattedTextFieldModDanno.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldModDanno = new GridBagConstraints();
			gbc_formattedTextFieldModDanno.insets = new Insets(0, 0, 5, 5);
			gbc_formattedTextFieldModDanno.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldModDanno.gridx = 1;
			gbc_formattedTextFieldModDanno.gridy = 8;
			contentPanel.add(formattedTextFieldModDanno, gbc_formattedTextFieldModDanno);
		}

		{
			chckbxTenuta2Mani = new JCheckBox("Tenuta a 2 Mani");
			chckbxTenuta2Mani.addActionListener(this);
			{
				textFieldModDannoDescrizione = new JTextField();
				textFieldModDannoDescrizione.addFocusListener(this);
				textFieldModDannoDescrizione.setToolTipText("Descrizione del modificatore");
				GridBagConstraints gbc_textFieldModDannoDescrizione = new GridBagConstraints();
				gbc_textFieldModDannoDescrizione.gridwidth = 2;
				gbc_textFieldModDannoDescrizione.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldModDannoDescrizione.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldModDannoDescrizione.gridx = 2;
				gbc_textFieldModDannoDescrizione.gridy = 8;
				contentPanel.add(textFieldModDannoDescrizione, gbc_textFieldModDannoDescrizione);
				textFieldModDannoDescrizione.setColumns(10);
			}
			GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
			gbc_chckbxNewCheckBox.gridwidth = 2;
			gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox.gridx = 0;
			gbc_chckbxNewCheckBox.gridy = 9;
			contentPanel.add(chckbxTenuta2Mani, gbc_chckbxNewCheckBox);
		}
		{
			chckbxDoppiaArma = new JCheckBox("Doppia Arma");
			chckbxDoppiaArma.addActionListener(this);
			GridBagConstraints gbc_chckbxDoppiaArma = new GridBagConstraints();
			gbc_chckbxDoppiaArma.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxDoppiaArma.anchor = GridBagConstraints.WEST;
			gbc_chckbxDoppiaArma.gridx = 2;
			gbc_chckbxDoppiaArma.gridy = 9;
			contentPanel.add(chckbxDoppiaArma, gbc_chckbxDoppiaArma);
		}
		{
			JLabel lblPrimariasecondaria = new JLabel("Primaria/Secondaria:");
			GridBagConstraints gbc_lblPrimariasecondaria = new GridBagConstraints();
			gbc_lblPrimariasecondaria.anchor = GridBagConstraints.EAST;
			gbc_lblPrimariasecondaria.insets = new Insets(0, 0, 0, 5);
			gbc_lblPrimariasecondaria.gridx = 0;
			gbc_lblPrimariasecondaria.gridy = 10;
			contentPanel.add(lblPrimariasecondaria, gbc_lblPrimariasecondaria);
		}
		{
			comboBoxPrimariaSecondaria = new JComboBox();
			comboBoxPrimariaSecondaria.addFocusListener(this);
			GridBagConstraints gbc_comboBoxPrimariaSecondaria = new GridBagConstraints();
			gbc_comboBoxPrimariaSecondaria.gridwidth = 2;
			gbc_comboBoxPrimariaSecondaria.insets = new Insets(0, 0, 0, 5);
			gbc_comboBoxPrimariaSecondaria.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxPrimariaSecondaria.gridx = 1;
			gbc_comboBoxPrimariaSecondaria.gridy = 10;
			contentPanel.add(comboBoxPrimariaSecondaria, gbc_comboBoxPrimariaSecondaria);
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
				//Impostare a null per evitare che con ENTER venga chiuso il dialog
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

		// Carica comboBoxArmi
		comboBoxArma.setModel(acb.creaComboBoxArmi().getModel());

		if (comboBoxArma.getItemCount() != 0) {
			comboBoxArma.setSelectedIndex(0);
			for (int i = 0; i < comboBoxArma.getItemCount(); i++) {
				if (comboBoxArma.getItemAt(i).toString().equals(pgArmiObj.getArma())) {
					comboBoxArma.setSelectedIndex(i);
				}
			}
		}
		chckbxEquipaggiata.setSelected(pgArmiObj.isEquipaggiata());
		textFieldNomeArma.setText(pgArmiObj.getNomeArma());

		comboBoxTaglia.setModel(acb.creaComboBoxTaglia().getModel());
		if (comboBoxTaglia.getItemCount() != 0) {
			comboBoxTaglia.setSelectedIndex(0);
			for (int i = 0; i < comboBoxTaglia.getItemCount(); i++) {
				if (comboBoxTaglia.getItemAt(i).toString().equals(pgArmiObj.getTaglia())) {
					comboBoxTaglia.setSelectedIndex(i);
				}
			}
		}
		comboBoxQualita.setModel(acb.creaComboBoxQualita().getModel());
		if (comboBoxQualita.getItemCount() != 0) {
			comboBoxQualita.setSelectedIndex(0);
			for (int i = 0; i < comboBoxQualita.getItemCount(); i++) {
				if (comboBoxQualita.getItemAt(i).toString().equals(pgArmiObj.getQualita())) {
					comboBoxQualita.setSelectedIndex(i);
				}
			}
		}
		formattedTextFieldMod.setValue(pgArmiObj.getMod());
		textFieldIncantamento.setText(pgArmiObj.getIncantamenti());
		textFieldBonusIncantamento.setText(pgArmiObj.getBonusIncantamenti());
		formattedTextFieldModBab.setValue(pgArmiObj.getModBab());
		textFieldModBabDescrizione.setText(pgArmiObj.getModBabDescrizione());
		formattedTextFieldModDanno.setValue(pgArmiObj.getModDanno());
		textFieldModDannoDescrizione.setText(pgArmiObj.getModDannoDescrizione());

		chckbxTenuta2Mani.setSelected(pgArmiObj.isA2Mani());
		chckbxDoppiaArma.setSelected(pgArmiObj.isDoppiaArma());
		comboBoxPrimariaSecondaria.setModel(acb.creaComboBoxPrimariaSecondaria().getModel());
		if (comboBoxPrimariaSecondaria.getItemCount() != 0) {
			comboBoxPrimariaSecondaria.setSelectedIndex(0);
			for (int i = 0; i < comboBoxPrimariaSecondaria.getItemCount(); i++) {
				if (comboBoxPrimariaSecondaria.getItemAt(i).toString().equals(pgArmiObj.getPrimariaSecondaria())) {
					comboBoxPrimariaSecondaria.setSelectedIndex(i);
				}
			}
		}
	}

	private void gestioneArma() {
		boolean datiOk = checkDati();
		
		if (datiOk) {
			rigaGestita = true;
			setVisible(false);
		}
	}

	private boolean checkDati() {
		if (pgArmiObj.getArma().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Selezionare un'arma", "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		//Controlliamo se esiste tra le armi altre selezionate e il tipo
		boolean primariaEquipaggiata = false;
		boolean secondariaEquipaggiata = false;
		for (int i=0; i < arrayArmi.size(); i++){
			PgArmiObj pgArmiObjTemp = arrayArmi.get(i);
			if (pgArmiObjTemp.getPrg() != pgArmiObj.getPrg()){
				if (pgArmiObjTemp.isEquipaggiata()){
					if (pgArmiObjTemp.getPrimariaSecondaria().equals("Primaria")){
						primariaEquipaggiata = true;
					}
					if (pgArmiObjTemp.getPrimariaSecondaria().equals("Secondaria")){
						secondariaEquipaggiata = true;
					}
				}
			}
		}
		

		if (pgArmiObj.getTaglia().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Selezionare la taglia dell'arma", "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (pgArmiObj.getQualita().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Selezionare la Qualita dell'arma", "Errore",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (pgArmiObj.getPrimariaSecondaria().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Selezionare se l'arma è Primaria o Secondaria", "Errore",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (pgArmiObj.getQualita().equals("Normale") && pgArmiObj.getMod() != 0) {
			JOptionPane.showMessageDialog(this, "Per applicare il mod al Bab l'arma deve essere di Qualità perfetta",
					"Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (pgArmiObj.getPrimariaSecondaria().equals("Secondaria") && !pgArmiObj.isDoppiaArma()){
			JOptionPane.showMessageDialog(this, "Se l'arma è Secondaria, selezionare Doppia Arma",
					"Errore", JOptionPane.ERROR_MESSAGE);
			return false;			
		}
		if (pgArmiObj.isEquipaggiata()){
			if (pgArmiObj.getPrimariaSecondaria().equals("Primaria") && primariaEquipaggiata){
				JOptionPane.showMessageDialog(this, "Esiste già un'arma primaria equipaggiata",
						"Errore", JOptionPane.ERROR_MESSAGE);
				return false;	
			}
			if (pgArmiObj.getPrimariaSecondaria().equals("Secondaria") && secondariaEquipaggiata){
				JOptionPane.showMessageDialog(this, "Esiste già un'arma secondaria equipaggiata",
						"Errore", JOptionPane.ERROR_MESSAGE);
				return false;	
			}
			if (pgArmiObj.getPrimariaSecondaria().equals("Secondaria") && !primariaEquipaggiata){
				JOptionPane.showMessageDialog(this, "Per equipaggiare un'arma secondaria equipaggiare prima la primaria",
						"Errore", JOptionPane.ERROR_MESSAGE);
				return false;	
			}
		}
		if (pgArmiObj.isA2Mani() && pgArmiObj.isDoppiaArma() ) {
			JOptionPane.showMessageDialog(this, "Selezionare o Tenuta a 2 Mani o Doppia Arma",
					"Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (pgArmiObj.isA2Mani() && pgArmiObj.getPrimariaSecondaria().equals("Secondaria") ) {
			JOptionPane.showMessageDialog(this, "Impossibile impostare un'arma tenuta a 2 mani come secondaria",
					"Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (pgArmiObj.getIncantamenti().trim().isEmpty() && !pgArmiObj.getBonusIncantamenti().trim().isEmpty() ) {
			JOptionPane.showMessageDialog(this, "Per applicare un bonus incantamento selezionare la descrizione",
					"Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
		
	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();

		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldMod) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.MOD, formattedTextFieldMod.getText());
			}
			if ((JFormattedTextField) component == formattedTextFieldModBab) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.MOD_BAB,
						formattedTextFieldModBab.getText());
			}
			if ((JFormattedTextField) component == formattedTextFieldModDanno) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.MOD_DANNO,
						formattedTextFieldModDanno.getText());
			}
		}
		if (component instanceof JComboBox) {
			if ((JComboBox) component == comboBoxArma) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.ARMA,
						comboBoxArma.getSelectedItem().toString());
			}
			if ((JComboBox) component == comboBoxTaglia) {

				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.TAGLIA,
						comboBoxTaglia.getSelectedItem().toString());
			}
			if ((JComboBox) component == comboBoxQualita) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.QUALITA,
						comboBoxQualita.getSelectedItem().toString());
			}
			if ((JComboBox) component == comboBoxPrimariaSecondaria) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.PRIMARIA_SECONDARIA,
						comboBoxPrimariaSecondaria.getSelectedItem().toString());
			}
		}
		if (component instanceof JTextField) {
			if ((JTextField) component == textFieldNomeArma) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.NOME_ARMA,
						textFieldNomeArma.getText());
			}
			
			if ((JTextField) component == textFieldIncantamento) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.INCANTAMENTI,
						textFieldIncantamento.getText());
			}
			if ((JTextField) component == textFieldBonusIncantamento) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.BONUS_INCANTAMENTI,
						textFieldBonusIncantamento.getText());
			}
			if ((JTextField) component == textFieldModBabDescrizione) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.MOD_BAB_DESCRIZIONE,
						textFieldModBabDescrizione.getText());
			}
			if ((JTextField) component == textFieldModBabDescrizione) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.MOD_BAB_DESCRIZIONE,
						textFieldModBabDescrizione.getText());
			}
			if ((JTextField) component == textFieldModDannoDescrizione) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.MOD_DANNO_DESCRIZIONE,
						textFieldModDannoDescrizione.getText());
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JCheckBox) {
			if (((JCheckBox) oggetto).getActionCommand() == chckbxTenuta2Mani.getActionCommand()) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.A_2MANI,
						Boolean.valueOf(chckbxTenuta2Mani.isSelected()).toString());
			}
			if (((JCheckBox) oggetto).getActionCommand() == chckbxDoppiaArma.getActionCommand()) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.DOPPIA_ARMA,
						Boolean.valueOf(chckbxDoppiaArma.isSelected()).toString());
			}
			if (((JCheckBox) oggetto).getActionCommand() == chckbxEquipaggiata.getActionCommand()) {
				pgArmiObj = aggiornaOggetti.aggiornaArmi(pgArmiObj, ListaPgArmi.EQUIPAGGIATA,
						Boolean.valueOf(chckbxEquipaggiata.isSelected()).toString());
			}
		}
		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == okButton.getActionCommand()) {
				gestioneArma();
			}
			if (((JButton) oggetto).getActionCommand() == cancelButton.getActionCommand()) {
				setVisible(false);
			}
		}
	}


	public PgArmiObj getPgArmiObj() {
		return pgArmiObj;
	}

	public void setPgArmiObj(PgArmiObj pgArmiObj) {
		this.pgArmiObj = pgArmiObj;
	}

	public ArrayList<PgArmiObj> getArrayArmi() {
		return arrayArmi;
	}

	public void setArrayArmi(ArrayList<PgArmiObj> arrayArmi) {
		this.arrayArmi = arrayArmi;
	}

	public boolean isRigaGestita() {
		return rigaGestita;
	}

	public void setRigaGestita(boolean rigaGestita) {
		this.rigaGestita = rigaGestita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ListaGestioneDati getAzione() {
		return azione;
	}

	public void setAzione(ListaGestioneDati azione) {
		this.azione = azione;
	}

}
