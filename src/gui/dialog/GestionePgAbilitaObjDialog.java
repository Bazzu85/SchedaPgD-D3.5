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
import ENUM.ListaPgAbilita;
import comboBox.PgArmiComboBox;
import obj.PgAbilitaObj;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.Beans;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionePgAbilitaObjDialog extends JDialog implements FocusListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7678726204148452351L;
	private final JPanel contentPanel = new JPanel();
	PgArmiComboBox acb = new PgArmiComboBox();
	int id = 0;
	int prg = 0;
	int modCaratteristica = 0;
	PgAbilitaObj pgAbilitaObj = new PgAbilitaObj();
	boolean rigaGestita = false;
	ListaGestioneDati azione;

	private JFormattedTextField formattedTextFieldGrado;

	Formati formati = new Formati();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	private JFormattedTextField formattedTextFieldCaratteristica;
	private JFormattedTextField formattedTextFieldAltro;
	private JCheckBox chckbxRichiedeAddestramento;
	private JButton okButton;
	private JButton cancelButton;
	private JCheckBox chckbxDiClasse;
	private JCheckBox chckbxDiClasseIncrociata;
	private JTextField textFieldAbilita;
	private JTextField textFieldCaratteristicaChiave;
	private JFormattedTextField formattedTextFieldTotale;
	private JTextField textFieldAltroDescrizione;

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
			PgAbilitaObj pgAbilitaObj = new PgAbilitaObj();
			GestionePgAbilitaObjDialog dialog = new GestionePgAbilitaObjDialog(ListaGestioneDati.INSERISCI, 0, pgAbilitaObj);
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
	public GestionePgAbilitaObjDialog(ListaGestioneDati azione, int id, PgAbilitaObj pgAbilitaObj) {

		setAzione(azione);
		setId(id);
		setPgAbilitaObj(pgAbilitaObj);
		setModCaratteristica(modCaratteristica);
		NumberFormatter soloNumeri = formati.getSoloNumeri();
		NumberFormatter soloNumeriConSegno = formati.getSoloNumeriConSegno();

		switch (azione) {
		case MODIFICA:
			setTitle("Modifica Abilità");
			break;
		}

		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 439, 290);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 99, 130, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			chckbxDiClasse = new JCheckBox("Di Classe");
			chckbxDiClasse.addActionListener(this);
			GridBagConstraints gbc_chckbxDiClasse = new GridBagConstraints();
			gbc_chckbxDiClasse.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxDiClasse.gridx = 0;
			gbc_chckbxDiClasse.gridy = 0;
			contentPanel.add(chckbxDiClasse, gbc_chckbxDiClasse);
		}
		{
			chckbxDiClasseIncrociata = new JCheckBox("Di Classe Incrociata");
			chckbxDiClasseIncrociata.addActionListener(this);
			GridBagConstraints gbc_chckbxDiClasseIncrociata = new GridBagConstraints();
			gbc_chckbxDiClasseIncrociata.gridwidth = 2;
			gbc_chckbxDiClasseIncrociata.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxDiClasseIncrociata.gridx = 1;
			gbc_chckbxDiClasseIncrociata.gridy = 0;
			contentPanel.add(chckbxDiClasseIncrociata, gbc_chckbxDiClasseIncrociata);
		}
		{
			JLabel lblAbilita = new JLabel("Abilit\u00E0:");
			GridBagConstraints gbc_lblAbilita = new GridBagConstraints();
			gbc_lblAbilita.insets = new Insets(0, 0, 5, 5);
			gbc_lblAbilita.anchor = GridBagConstraints.EAST;
			gbc_lblAbilita.gridx = 0;
			gbc_lblAbilita.gridy = 1;
			contentPanel.add(lblAbilita, gbc_lblAbilita);
		}
		{
			textFieldAbilita = new JTextField();
			textFieldAbilita.setEnabled(false);
			textFieldAbilita.setEditable(false);
			GridBagConstraints gbc_textFieldAbilita = new GridBagConstraints();
			gbc_textFieldAbilita.gridwidth = 2;
			gbc_textFieldAbilita.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldAbilita.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldAbilita.gridx = 1;
			gbc_textFieldAbilita.gridy = 1;
			contentPanel.add(textFieldAbilita, gbc_textFieldAbilita);
			textFieldAbilita.setColumns(10);
		}
		{
			JLabel lblCaratteristicaChiave = new JLabel("Caratteristica Chiave:");
			GridBagConstraints gbc_lblCaratteristicaChiave = new GridBagConstraints();
			gbc_lblCaratteristicaChiave.anchor = GridBagConstraints.EAST;
			gbc_lblCaratteristicaChiave.insets = new Insets(0, 0, 5, 5);
			gbc_lblCaratteristicaChiave.gridx = 0;
			gbc_lblCaratteristicaChiave.gridy = 2;
			contentPanel.add(lblCaratteristicaChiave, gbc_lblCaratteristicaChiave);
		}
		{
			textFieldCaratteristicaChiave = new JTextField();
			textFieldCaratteristicaChiave.setEnabled(false);
			textFieldCaratteristicaChiave.setEditable(false);
			GridBagConstraints gbc_textFieldCaratteristicaChiave = new GridBagConstraints();
			gbc_textFieldCaratteristicaChiave.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldCaratteristicaChiave.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCaratteristicaChiave.gridx = 1;
			gbc_textFieldCaratteristicaChiave.gridy = 2;
			contentPanel.add(textFieldCaratteristicaChiave, gbc_textFieldCaratteristicaChiave);
			textFieldCaratteristicaChiave.setColumns(10);
		}
		{
			JLabel lblTotale = new JLabel("Totale:");
			GridBagConstraints gbc_lblTotale = new GridBagConstraints();
			gbc_lblTotale.anchor = GridBagConstraints.EAST;
			gbc_lblTotale.insets = new Insets(0, 0, 5, 5);
			gbc_lblTotale.gridx = 0;
			gbc_lblTotale.gridy = 3;
			contentPanel.add(lblTotale, gbc_lblTotale);
		}
		{
			formattedTextFieldTotale = new JFormattedTextField(soloNumeri);
			formattedTextFieldTotale.setEnabled(false);
			formattedTextFieldTotale.setEditable(false);
			GridBagConstraints gbc_formattedTextFieldTotale = new GridBagConstraints();
			gbc_formattedTextFieldTotale.insets = new Insets(0, 0, 5, 5);
			gbc_formattedTextFieldTotale.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldTotale.gridx = 1;
			gbc_formattedTextFieldTotale.gridy = 3;
			contentPanel.add(formattedTextFieldTotale, gbc_formattedTextFieldTotale);
		}
		{
			JLabel lblMod = new JLabel("Caratteristica:");
			GridBagConstraints gbc_lblMod = new GridBagConstraints();
			gbc_lblMod.anchor = GridBagConstraints.EAST;
			gbc_lblMod.insets = new Insets(0, 0, 5, 5);
			gbc_lblMod.gridx = 0;
			gbc_lblMod.gridy = 4;
			contentPanel.add(lblMod, gbc_lblMod);
		}
		{
			formattedTextFieldCaratteristica = new JFormattedTextField(soloNumeriConSegno);
			formattedTextFieldCaratteristica.setEditable(false);
			formattedTextFieldCaratteristica.setEnabled(false);
			formattedTextFieldCaratteristica.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldCaratteristica = new GridBagConstraints();
			gbc_formattedTextFieldCaratteristica.insets = new Insets(0, 0, 5, 5);
			gbc_formattedTextFieldCaratteristica.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldCaratteristica.gridx = 1;
			gbc_formattedTextFieldCaratteristica.gridy = 4;
			contentPanel.add(formattedTextFieldCaratteristica, gbc_formattedTextFieldCaratteristica);
		}
		{
			JLabel lblGrado = new JLabel("Grado:");
			GridBagConstraints gbc_lblGrado = new GridBagConstraints();
			gbc_lblGrado.anchor = GridBagConstraints.EAST;
			gbc_lblGrado.insets = new Insets(0, 0, 5, 5);
			gbc_lblGrado.gridx = 0;
			gbc_lblGrado.gridy = 5;
			contentPanel.add(lblGrado, gbc_lblGrado);
		}
		{
			formattedTextFieldGrado = new JFormattedTextField(soloNumeriConSegno);
			formattedTextFieldGrado.addFocusListener(this);
			formattedTextFieldGrado.setToolTipText("");
			GridBagConstraints gbc_formattedTextFieldGrado = new GridBagConstraints();
			gbc_formattedTextFieldGrado.insets = new Insets(0, 0, 5, 5);
			gbc_formattedTextFieldGrado.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldGrado.gridx = 1;
			gbc_formattedTextFieldGrado.gridy = 5;
			contentPanel.add(formattedTextFieldGrado, gbc_formattedTextFieldGrado);
			formattedTextFieldGrado.setColumns(10);
		}
		{
			JLabel lblAltro = new JLabel("Altro:");
			GridBagConstraints gbc_lblAltro = new GridBagConstraints();
			gbc_lblAltro.anchor = GridBagConstraints.EAST;
			gbc_lblAltro.insets = new Insets(0, 0, 5, 5);
			gbc_lblAltro.gridx = 0;
			gbc_lblAltro.gridy = 6;
			contentPanel.add(lblAltro, gbc_lblAltro);
		}
		{
			formattedTextFieldAltro = new JFormattedTextField(soloNumeriConSegno);
			formattedTextFieldAltro.addFocusListener(this);
			formattedTextFieldAltro.setToolTipText("Bonus incantamento (es 1d6)");
			GridBagConstraints gbc_formattedTextFieldAltro = new GridBagConstraints();
			gbc_formattedTextFieldAltro.insets = new Insets(0, 0, 5, 5);
			gbc_formattedTextFieldAltro.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldAltro.gridx = 1;
			gbc_formattedTextFieldAltro.gridy = 6;
			contentPanel.add(formattedTextFieldAltro, gbc_formattedTextFieldAltro);
		}

		{
			chckbxRichiedeAddestramento = new JCheckBox("Richiede Addestramento");
			chckbxRichiedeAddestramento.setEnabled(false);
			chckbxRichiedeAddestramento.addActionListener(this);
			
			GridBagConstraints gbc_chckbxRichiedeAddestramento = new GridBagConstraints();
			gbc_chckbxRichiedeAddestramento.gridwidth = 3;
			gbc_chckbxRichiedeAddestramento.gridx = 0;
			gbc_chckbxRichiedeAddestramento.gridy = 7;
			contentPanel.add(chckbxRichiedeAddestramento, gbc_chckbxRichiedeAddestramento);
		}
		
		{
			textFieldAltroDescrizione = new JTextField();
			textFieldAltroDescrizione.addFocusListener(this);
			GridBagConstraints gbc_textFieldAltroDescrizione = new GridBagConstraints();
			gbc_textFieldAltroDescrizione.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldAltroDescrizione.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldAltroDescrizione.gridx = 2;
			gbc_textFieldAltroDescrizione.gridy = 6;
			contentPanel.add(textFieldAltroDescrizione, gbc_textFieldAltroDescrizione);
			textFieldAltroDescrizione.setColumns(10);
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

	private void popolaFrame() {

		chckbxDiClasse.setSelected(pgAbilitaObj.isAbilitaDiClasse());
		chckbxDiClasseIncrociata.setSelected(pgAbilitaObj.isAbilitaDiClasseIncrociata());
		textFieldAbilita.setText(pgAbilitaObj.getNome());
		textFieldCaratteristicaChiave.setText(pgAbilitaObj.getCaratteristica());
		formattedTextFieldCaratteristica.setValue(pgAbilitaObj.getModCaratteristica());
		formattedTextFieldGrado.setValue(pgAbilitaObj.getGrado());
		formattedTextFieldAltro.setValue(pgAbilitaObj.getAltro());
		textFieldAltroDescrizione.setText(pgAbilitaObj.getAltroDescrizione());

		int totale = modCaratteristica + pgAbilitaObj.getGrado() + pgAbilitaObj.getAltro();
		formattedTextFieldTotale.setValue(totale);
		chckbxRichiedeAddestramento.setSelected(pgAbilitaObj.isRichiedeAddestramento());

	}

	private void gestioneAbilita() {
		boolean datiOk = true;

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

		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldGrado) {
				pgAbilitaObj = aggiornaOggetti.aggiornaAbilita(pgAbilitaObj, ListaPgAbilita.GRADO,
						formattedTextFieldGrado.getText());
			}
			if ((JFormattedTextField) component == formattedTextFieldAltro) {
				pgAbilitaObj = aggiornaOggetti.aggiornaAbilita(pgAbilitaObj, ListaPgAbilita.ALTRO,
						formattedTextFieldAltro.getText());
			}
		}

		if (component instanceof JTextField) {
			if ((JTextField) component == textFieldAltroDescrizione) {
				pgAbilitaObj = aggiornaOggetti.aggiornaAbilita(pgAbilitaObj, ListaPgAbilita.ALTRO_DESCRIZIONE,
						textFieldAltroDescrizione.getText());
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JCheckBox) {
			if (((JCheckBox) oggetto).getActionCommand() == chckbxDiClasse.getActionCommand()) {
				pgAbilitaObj = aggiornaOggetti.aggiornaAbilita(pgAbilitaObj, ListaPgAbilita.DI_CLASSE,
						Boolean.valueOf(chckbxDiClasse.isSelected()).toString());
			}
			if (((JCheckBox) oggetto).getActionCommand() == chckbxDiClasseIncrociata.getActionCommand()) {
				pgAbilitaObj = aggiornaOggetti.aggiornaAbilita(pgAbilitaObj, ListaPgAbilita.DI_CLASSE_INCROCIATA,
						Boolean.valueOf(chckbxDiClasseIncrociata.isSelected()).toString());
			}
		}
		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == okButton.getActionCommand()) {
				gestioneAbilita();
			}
			if (((JButton) oggetto).getActionCommand() == cancelButton.getActionCommand()) {
				setVisible(false);
			}
		}
	}

	public PgAbilitaObj getPgAbilitaObj() {
		return pgAbilitaObj;
	}

	public void setPgAbilitaObj(PgAbilitaObj pgAbilitaObj) {
		this.pgAbilitaObj = pgAbilitaObj;
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

	public int getPrg() {
		return prg;
	}

	public void setPrg(int prg) {
		this.prg = prg;
	}

	public ListaGestioneDati getAzione() {
		return azione;
	}

	public void setAzione(ListaGestioneDati azione) {
		this.azione = azione;
	}

	public int getModCaratteristica() {
		return modCaratteristica;
	}

	public void setModCaratteristica(int modCaratteristica) {
		this.modCaratteristica = modCaratteristica;
	}

}
