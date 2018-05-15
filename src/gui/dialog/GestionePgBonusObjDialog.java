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
import ENUM.ListaPgBonus;
import comboBox.PgBonusComboBox;
import obj.PgBonusObj;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.Beans;

import javax.swing.JFormattedTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class GestionePgBonusObjDialog extends JDialog implements FocusListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6422655944625143076L;
	int id = 0;
	PgBonusObj pgBonusObj = new PgBonusObj();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	boolean rigaGestita = false;
	Formati formati = new Formati();
	PgBonusComboBox bcb = new PgBonusComboBox();
	ListaGestioneDati azione;


	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDescrizione;
	private JFormattedTextField formattedTextFieldModificatore;
	private JButton okButton;
	private JButton cancelButton;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxBonus;
	private JCheckBox chckbxBonusAbilitato;

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
			PgBonusObj pgBonusObj = new PgBonusObj();
			GestionePgBonusObjDialog dialog = new GestionePgBonusObjDialog(ListaGestioneDati.INSERISCI, 0, pgBonusObj);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("rawtypes")
	public GestionePgBonusObjDialog(ListaGestioneDati azione, int id, PgBonusObj pgBonusObj) {
		setModalityType(ModalityType.APPLICATION_MODAL);

		setAzione(azione);
		setId(id);
		setPgBonusObj(pgBonusObj);

		NumberFormatter soloNumeriConSegno = formati.getSoloNumeriConSegno();

		switch (azione) {
		case INSERISCI:
			setTitle("Nuovo Bonus");
			break;
		case MODIFICA:
			setTitle("Modifica Bonus");
			break;
		}
		setBounds(100, 100, 438, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 281, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblBonus = new JLabel("Bonus:");
			GridBagConstraints gbc_lblBonus = new GridBagConstraints();
			gbc_lblBonus.insets = new Insets(0, 0, 5, 5);
			gbc_lblBonus.anchor = GridBagConstraints.EAST;
			gbc_lblBonus.gridx = 0;
			gbc_lblBonus.gridy = 0;
			contentPanel.add(lblBonus, gbc_lblBonus);
		}
		{
			comboBoxBonus = new JComboBox();
			comboBoxBonus.addFocusListener(this);
			GridBagConstraints gbc_comboBoxBonus = new GridBagConstraints();
			gbc_comboBoxBonus.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxBonus.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxBonus.gridx = 1;
			gbc_comboBoxBonus.gridy = 0;
			contentPanel.add(comboBoxBonus, gbc_comboBoxBonus);
		}
		{
			JLabel lblModificatore = new JLabel("Modificatore:");
			GridBagConstraints gbc_lblModificatore = new GridBagConstraints();
			gbc_lblModificatore.anchor = GridBagConstraints.EAST;
			gbc_lblModificatore.insets = new Insets(0, 0, 5, 5);
			gbc_lblModificatore.gridx = 0;
			gbc_lblModificatore.gridy = 1;
			contentPanel.add(lblModificatore, gbc_lblModificatore);
		}
		{
			formattedTextFieldModificatore = new JFormattedTextField(soloNumeriConSegno);
			formattedTextFieldModificatore.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldModificatore = new GridBagConstraints();
			gbc_formattedTextFieldModificatore.insets = new Insets(0, 0, 5, 0);
			gbc_formattedTextFieldModificatore.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldModificatore.gridx = 1;
			gbc_formattedTextFieldModificatore.gridy = 1;
			contentPanel.add(formattedTextFieldModificatore, gbc_formattedTextFieldModificatore);
		}
		{
			JLabel lblDescrizione = new JLabel("Descrizione:");
			GridBagConstraints gbc_lblDescrizione = new GridBagConstraints();
			gbc_lblDescrizione.anchor = GridBagConstraints.EAST;
			gbc_lblDescrizione.insets = new Insets(0, 0, 5, 5);
			gbc_lblDescrizione.gridx = 0;
			gbc_lblDescrizione.gridy = 2;
			contentPanel.add(lblDescrizione, gbc_lblDescrizione);
		}
		{
			textFieldDescrizione = new JTextField();
			textFieldDescrizione.addFocusListener(this);
			GridBagConstraints gbc_textFieldDescrizione = new GridBagConstraints();
			gbc_textFieldDescrizione.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldDescrizione.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldDescrizione.gridx = 1;
			gbc_textFieldDescrizione.gridy = 2;
			contentPanel.add(textFieldDescrizione, gbc_textFieldDescrizione);
			textFieldDescrizione.setColumns(10);
		}
		{
			chckbxBonusAbilitato = new JCheckBox("Bonus Abilitato");
			chckbxBonusAbilitato.addActionListener(this);
			GridBagConstraints gbc_chckbxBonusAbilitato = new GridBagConstraints();
			gbc_chckbxBonusAbilitato.gridwidth = 2;
			gbc_chckbxBonusAbilitato.gridx = 0;
			gbc_chckbxBonusAbilitato.gridy = 3;
			contentPanel.add(chckbxBonusAbilitato, gbc_chckbxBonusAbilitato);
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
		comboBoxBonus.setModel(bcb.creaComboBoxBonus().getModel());

		if (comboBoxBonus.getItemCount() != 0) {
			comboBoxBonus.setSelectedIndex(0);
			for (int i = 0; i < comboBoxBonus.getItemCount(); i++) {
				if (comboBoxBonus.getItemAt(i).toString().equals(pgBonusObj.getBonus())) {
					comboBoxBonus.setSelectedIndex(i);
				}
			}
		}

		formattedTextFieldModificatore.setValue(pgBonusObj.getModificatore());
		textFieldDescrizione.setText(pgBonusObj.getDescrizione());
		chckbxBonusAbilitato.setSelected(pgBonusObj.isBonusAbilitato());
	}

	private void inserisciBonus() {
		boolean datiOk = true;
		if (datiOk && pgBonusObj.getBonus().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Selezionare il bonus", "Errore", JOptionPane.ERROR_MESSAGE);
			datiOk = false;
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

		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldModificatore) {
				pgBonusObj = aggiornaOggetti.aggiornaBonus(pgBonusObj, ListaPgBonus.MODIFICATORE,
						formattedTextFieldModificatore.getText());
			}
		}
		if (component instanceof JTextField) {
			if ((JTextField) component == textFieldDescrizione) {
				pgBonusObj = aggiornaOggetti.aggiornaBonus(pgBonusObj, ListaPgBonus.DESCRIZIONE,
						textFieldDescrizione.getText());
			}

		}
		if (component instanceof JComboBox) {
			if ((JComboBox) component == comboBoxBonus) {
				pgBonusObj = aggiornaOggetti.aggiornaBonus(pgBonusObj, ListaPgBonus.BONUS,
						comboBoxBonus.getSelectedItem().toString());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JCheckBox) {
			if (((JCheckBox) oggetto).getActionCommand() == chckbxBonusAbilitato.getActionCommand()) {
				pgBonusObj = aggiornaOggetti.aggiornaBonus(pgBonusObj, ListaPgBonus.BONUS_ABILITATO,
						Boolean.valueOf(chckbxBonusAbilitato.isSelected()).toString());
			}
		}

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == okButton.getActionCommand()) {
				inserisciBonus();
			}
			if (((JButton) oggetto).getActionCommand() == cancelButton.getActionCommand()) {
				setVisible(false);
			}
		}

	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isRigaGestita() {
		return rigaGestita;
	}

	public void setRigaGestita(boolean rigaGestita) {
		this.rigaGestita = rigaGestita;
	}


	public PgBonusObj getPgBonusObj() {
		return pgBonusObj;
	}
	public void setPgBonusObj(PgBonusObj pgBonusObj) {
		this.pgBonusObj = pgBonusObj;
	}

	public ListaGestioneDati getAzione() {
		return azione;
	}

	public void setAzione(ListaGestioneDati azione) {
		this.azione = azione;
	}

}
