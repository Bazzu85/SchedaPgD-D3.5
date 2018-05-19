package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaGestioneDati;
import ENUM.ListaPgArmi;
import ENUM.ListaPgManovre;
import comboBox.PgManovreComboBox;
import obj.PgManovreObj;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.Beans;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;

public class GestionePgManovreObjDialog extends JDialog implements FocusListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2383820238827879403L;
	private final JPanel contentPanel = new JPanel();
	int id = 0;
	PgManovreObj pgManovreObj = new PgManovreObj();
	boolean rigaGestita = false;
	ListaGestioneDati azione;
	PgManovreComboBox pgManovreComboBox = new PgManovreComboBox();

	Formati formati = new Formati();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textFieldNome;
	private JTextArea textAreaDescrizione;
	private JScrollPane scrollPane;
	private JLabel lblTipo;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxTipo;
	private JLabel lblDisciplina;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxDisciplina;
	private JLabel lblLvl;
	private JFormattedTextField formattedTextFieldLvl;
	private JCheckBox chckbxPronta;
	private JCheckBox chckbxDaUsare;

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
			PgManovreObj pgManovreObj = new PgManovreObj();
			GestionePgManovreObjDialog dialog = new GestionePgManovreObjDialog(ListaGestioneDati.INSERISCI, 0,
					pgManovreObj);
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
	 */
	@SuppressWarnings("rawtypes")
	public GestionePgManovreObjDialog(ListaGestioneDati azione, int id, PgManovreObj pgManovreObj) {

		setAzione(azione);
		setId(id);
		setPgManovreObj(pgManovreObj);
		switch (azione) {
		case INSERISCI:
			setTitle("Nuova Manovra");
			break;
		case MODIFICA:
			setTitle("Modifica Manovra");
			break;
		}

		NumberFormatter soloNumeri = formati.getSoloNumeri();

		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 439, 371);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 99, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNome = new JLabel("Nome:");
			GridBagConstraints gbc_lblNome = new GridBagConstraints();
			gbc_lblNome.insets = new Insets(0, 0, 5, 5);
			gbc_lblNome.anchor = GridBagConstraints.EAST;
			gbc_lblNome.gridx = 0;
			gbc_lblNome.gridy = 0;
			contentPanel.add(lblNome, gbc_lblNome);
		}
		{
			textFieldNome = new JTextField();
			textFieldNome.addFocusListener(this);
			GridBagConstraints gbc_textFieldManovra = new GridBagConstraints();
			gbc_textFieldManovra.gridwidth = 2;
			gbc_textFieldManovra.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldManovra.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldManovra.gridx = 1;
			gbc_textFieldManovra.gridy = 0;
			contentPanel.add(textFieldNome, gbc_textFieldManovra);
			textFieldNome.setColumns(10);
		}
		{
			lblTipo = new JLabel("Tipo:");
			GridBagConstraints gbc_lblTipo = new GridBagConstraints();
			gbc_lblTipo.anchor = GridBagConstraints.EAST;
			gbc_lblTipo.insets = new Insets(0, 0, 5, 5);
			gbc_lblTipo.gridx = 0;
			gbc_lblTipo.gridy = 1;
			contentPanel.add(lblTipo, gbc_lblTipo);
		}
		{
			comboBoxTipo = new JComboBox();
			comboBoxTipo.addFocusListener(this);
			GridBagConstraints gbc_comboBoxTipo = new GridBagConstraints();
			gbc_comboBoxTipo.gridwidth = 2;
			gbc_comboBoxTipo.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxTipo.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxTipo.gridx = 1;
			gbc_comboBoxTipo.gridy = 1;
			contentPanel.add(comboBoxTipo, gbc_comboBoxTipo);
		}
		{
			lblDisciplina = new JLabel("Disciplina:");
			GridBagConstraints gbc_lblDisciplina = new GridBagConstraints();
			gbc_lblDisciplina.anchor = GridBagConstraints.EAST;
			gbc_lblDisciplina.insets = new Insets(0, 0, 5, 5);
			gbc_lblDisciplina.gridx = 0;
			gbc_lblDisciplina.gridy = 2;
			contentPanel.add(lblDisciplina, gbc_lblDisciplina);
		}
		{
			comboBoxDisciplina = new JComboBox();
			comboBoxDisciplina.addFocusListener(this);
			GridBagConstraints gbc_comboBoxDisciplina = new GridBagConstraints();
			gbc_comboBoxDisciplina.gridwidth = 2;
			gbc_comboBoxDisciplina.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxDisciplina.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxDisciplina.gridx = 1;
			gbc_comboBoxDisciplina.gridy = 2;
			contentPanel.add(comboBoxDisciplina, gbc_comboBoxDisciplina);
		}
		{
			lblLvl = new JLabel("Lvl:");
			GridBagConstraints gbc_lblLvl = new GridBagConstraints();
			gbc_lblLvl.anchor = GridBagConstraints.EAST;
			gbc_lblLvl.insets = new Insets(0, 0, 5, 5);
			gbc_lblLvl.gridx = 0;
			gbc_lblLvl.gridy = 3;
			contentPanel.add(lblLvl, gbc_lblLvl);
		}
		{
			formattedTextFieldLvl = new JFormattedTextField(soloNumeri);
			formattedTextFieldLvl.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldLvl = new GridBagConstraints();
			gbc_formattedTextFieldLvl.gridwidth = 2;
			gbc_formattedTextFieldLvl.insets = new Insets(0, 0, 5, 0);
			gbc_formattedTextFieldLvl.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldLvl.gridx = 1;
			gbc_formattedTextFieldLvl.gridy = 3;
			contentPanel.add(formattedTextFieldLvl, gbc_formattedTextFieldLvl);
		}
		{
			chckbxPronta = new JCheckBox("Pronta");
			chckbxPronta.addActionListener(this);
			GridBagConstraints gbc_chckbxPronta = new GridBagConstraints();
			gbc_chckbxPronta.gridwidth = 2;
			gbc_chckbxPronta.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxPronta.gridx = 0;
			gbc_chckbxPronta.gridy = 4;
			contentPanel.add(chckbxPronta, gbc_chckbxPronta);
		}
		{
			chckbxDaUsare = new JCheckBox("Da Usare");
			chckbxDaUsare.addActionListener(this);
			GridBagConstraints gbc_chckbxDaUsare = new GridBagConstraints();
			gbc_chckbxDaUsare.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxDaUsare.gridx = 2;
			gbc_chckbxDaUsare.gridy = 4;
			contentPanel.add(chckbxDaUsare, gbc_chckbxDaUsare);
		}
		{
			JLabel lblDescrizione = new JLabel("Descrizione:");
			GridBagConstraints gbc_lblDescrizione = new GridBagConstraints();
			gbc_lblDescrizione.anchor = GridBagConstraints.EAST;
			gbc_lblDescrizione.insets = new Insets(0, 0, 0, 5);
			gbc_lblDescrizione.gridx = 0;
			gbc_lblDescrizione.gridy = 5;
			contentPanel.add(lblDescrizione, gbc_lblDescrizione);
		}
		{
			{
				scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridwidth = 2;
				gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 5;
				contentPanel.add(scrollPane, gbc_scrollPane);
				textAreaDescrizione = new JTextArea();
				scrollPane.setViewportView(textAreaDescrizione);
				textAreaDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 11));
				textAreaDescrizione.addFocusListener(this);
				textAreaDescrizione.setBorder(UIManager.getBorder("FormattedTextField.border"));
			}
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
				// Impostare a null per evitare che con ENTER venga chiuso il
				// dialog
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

		textFieldNome.setText(pgManovreObj.getNome());

		// Carica comboBoxTipo
		comboBoxTipo.setModel(pgManovreComboBox.creaComboBoxTipo().getModel());

		if (comboBoxTipo.getItemCount() != 0) {
			comboBoxTipo.setSelectedIndex(0);
			for (int i = 0; i < comboBoxTipo.getItemCount(); i++) {
				if (comboBoxTipo.getItemAt(i).toString().equals(pgManovreObj.getTipo())) {
					comboBoxTipo.setSelectedIndex(i);
				}
			}
		}

		// Carica comboBoxDisciplina
		comboBoxDisciplina.setModel(pgManovreComboBox.creaComboBoxDisciplina().getModel());

		if (comboBoxDisciplina.getItemCount() != 0) {
			comboBoxDisciplina.setSelectedIndex(0);
			for (int i = 0; i < comboBoxDisciplina.getItemCount(); i++) {
				if (comboBoxDisciplina.getItemAt(i).toString().equals(pgManovreObj.getDisciplina())) {
					comboBoxDisciplina.setSelectedIndex(i);
				}
			}
		}

		formattedTextFieldLvl.setValue(pgManovreObj.getLvl());
		chckbxPronta.setSelected(pgManovreObj.isPronta());
		if (pgManovreObj.getTipo().equals("Stance")) {
			chckbxDaUsare.setEnabled(false);
		} else {
			if (!chckbxPronta.isSelected()) {
				chckbxDaUsare.setEnabled(false);
			} else {
				chckbxDaUsare.setEnabled(true);
			}
		}
		chckbxDaUsare.setSelected(pgManovreObj.isDaUsare());
		textAreaDescrizione.setText(pgManovreObj.getDescrizione());

	}

	private void gestioneManovra() {
		boolean datiOk = true;

		if (datiOk && pgManovreObj.getNome().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Inserire il nome della manovra", "Errore", JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && pgManovreObj.getTipo().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Selezionare il tipo", "Errore", JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && pgManovreObj.getDisciplina().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Selezionare la disciplina", "Errore", JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && !pgManovreObj.isPronta() && pgManovreObj.isDaUsare()) {
			JOptionPane.showMessageDialog(this, "Per impostare una manovra come 'Da usare', impostarla come 'Pronta'",
					"Errore", JOptionPane.ERROR_MESSAGE);
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

		if (component instanceof JTextField) {
			if ((JTextField) component == textFieldNome) {
				pgManovreObj = aggiornaOggetti.aggiornaManovre(pgManovreObj, ListaPgManovre.NOME,
						textFieldNome.getText());
			}
		}
		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldLvl) {
				pgManovreObj = aggiornaOggetti.aggiornaManovre(pgManovreObj, ListaPgManovre.LVL,
						formattedTextFieldLvl.getText());
			}
		}
		if (component instanceof JTextArea) {
			if ((JTextArea) component == textAreaDescrizione) {
				pgManovreObj = aggiornaOggetti.aggiornaManovre(pgManovreObj, ListaPgManovre.DESCRIZIONE,
						textAreaDescrizione.getText());
			}
		}
		if (component instanceof JComboBox) {
			if ((JComboBox) component == comboBoxTipo) {
				pgManovreObj = aggiornaOggetti.aggiornaManovre(pgManovreObj, ListaPgManovre.TIPO,
						comboBoxTipo.getSelectedItem().toString());
				popolaFrame();
			}
			if ((JComboBox) component == comboBoxDisciplina) {
				pgManovreObj = aggiornaOggetti.aggiornaManovre(pgManovreObj, ListaPgManovre.DISCIPLINA,
						comboBoxDisciplina.getSelectedItem().toString());
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JCheckBox) {
			if (((JCheckBox) oggetto).getActionCommand() == chckbxPronta.getActionCommand()) {
				pgManovreObj = aggiornaOggetti.aggiornaManovre(pgManovreObj, ListaPgManovre.PRONTA,
						Boolean.valueOf(chckbxPronta.isSelected()).toString());
				popolaFrame();
			}
			if (((JCheckBox) oggetto).getActionCommand() == chckbxDaUsare.getActionCommand()) {
				pgManovreObj = aggiornaOggetti.aggiornaManovre(pgManovreObj, ListaPgManovre.DA_USARE,
						Boolean.valueOf(chckbxDaUsare.isSelected()).toString());
				popolaFrame();
			}
		}
		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == okButton.getActionCommand()) {
				gestioneManovra();
			}
			if (((JButton) oggetto).getActionCommand() == cancelButton.getActionCommand()) {
				setVisible(false);
			}
		}
	}

	public PgManovreObj getPgManovreObj() {
		return pgManovreObj;
	}

	public void setPgManovreObj(PgManovreObj pgManovreObj) {
		this.pgManovreObj = pgManovreObj;
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
