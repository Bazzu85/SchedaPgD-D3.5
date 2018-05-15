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
import ENUM.ListaPgLingue;
import comboBox.PgBonusComboBox;
import obj.PgLingueObj;

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
import java.awt.event.FocusAdapter;

public class GestionePgLingueObjDialog extends JDialog implements FocusListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6422655944625143076L;
	int id = 0;
	PgLingueObj pgLingueObj = new PgLingueObj();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	boolean rigaGestita = false;
	Formati formati = new Formati();
	PgBonusComboBox bcb = new PgBonusComboBox();
	ListaGestioneDati azione;


	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldAlfabeto;
	private JTextField textFieldLinguaParlata;
	private JButton okButton;
	private JButton cancelButton;
	private JFormattedTextField formattedTextFieldPuntiAbilita;

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
			PgLingueObj pgLingueObj = new PgLingueObj();
			GestionePgLingueObjDialog dialog = new GestionePgLingueObjDialog(ListaGestioneDati.INSERISCI, 0, pgLingueObj);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionePgLingueObjDialog(ListaGestioneDati azione, int id, PgLingueObj pgLingueObj) {
		setModalityType(ModalityType.APPLICATION_MODAL);

		setAzione(azione);
		setId(id);
		setPgLingueObj(pgLingueObj);

		NumberFormatter soloNumeriConSegno = formati.getSoloNumeriConSegno();

		switch (azione) {
		case INSERISCI:
			setTitle("Nuovo Bonus");
			break;
		case MODIFICA:
			setTitle("Modifica Bonus");
			break;
		}
		setBounds(100, 100, 438, 157);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 281, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblPuntiAbilita = new JLabel("Punti Abilit\u00E0:");
			GridBagConstraints gbc_lblPuntiAbilita = new GridBagConstraints();
			gbc_lblPuntiAbilita.insets = new Insets(0, 0, 5, 5);
			gbc_lblPuntiAbilita.anchor = GridBagConstraints.EAST;
			gbc_lblPuntiAbilita.gridx = 0;
			gbc_lblPuntiAbilita.gridy = 0;
			contentPanel.add(lblPuntiAbilita, gbc_lblPuntiAbilita);
		}
		{
			formattedTextFieldPuntiAbilita = new JFormattedTextField(soloNumeriConSegno);
			formattedTextFieldPuntiAbilita.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldPuntiAbilita = new GridBagConstraints();
			gbc_formattedTextFieldPuntiAbilita.insets = new Insets(0, 0, 5, 0);
			gbc_formattedTextFieldPuntiAbilita.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldPuntiAbilita.gridx = 1;
			gbc_formattedTextFieldPuntiAbilita.gridy = 0;
			contentPanel.add(formattedTextFieldPuntiAbilita, gbc_formattedTextFieldPuntiAbilita);
		}
		{
			JLabel lblLinguaParlata = new JLabel("Lingua Parlata:");
			GridBagConstraints gbc_lblLinguaParlata = new GridBagConstraints();
			gbc_lblLinguaParlata.anchor = GridBagConstraints.EAST;
			gbc_lblLinguaParlata.insets = new Insets(0, 0, 5, 5);
			gbc_lblLinguaParlata.gridx = 0;
			gbc_lblLinguaParlata.gridy = 1;
			contentPanel.add(lblLinguaParlata, gbc_lblLinguaParlata);
		}
		{
			textFieldLinguaParlata = new JTextField();
			textFieldLinguaParlata.addFocusListener(this);
			GridBagConstraints gbc_textFieldLinguaParlata = new GridBagConstraints();
			gbc_textFieldLinguaParlata.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldLinguaParlata.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldLinguaParlata.gridx = 1;
			gbc_textFieldLinguaParlata.gridy = 1;
			contentPanel.add(textFieldLinguaParlata, gbc_textFieldLinguaParlata);
		}
		{
			JLabel lblAlfabeto = new JLabel("Alfabeto:");
			GridBagConstraints gbc_lblAlfabeto = new GridBagConstraints();
			gbc_lblAlfabeto.anchor = GridBagConstraints.EAST;
			gbc_lblAlfabeto.insets = new Insets(0, 0, 0, 5);
			gbc_lblAlfabeto.gridx = 0;
			gbc_lblAlfabeto.gridy = 2;
			contentPanel.add(lblAlfabeto, gbc_lblAlfabeto);
		}
		{
			textFieldAlfabeto = new JTextField();
			textFieldAlfabeto.addFocusListener(this);
			GridBagConstraints gbc_textFieldAlfabeto = new GridBagConstraints();
			gbc_textFieldAlfabeto.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldAlfabeto.gridx = 1;
			gbc_textFieldAlfabeto.gridy = 2;
			contentPanel.add(textFieldAlfabeto, gbc_textFieldAlfabeto);
			textFieldAlfabeto.setColumns(10);
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

	private void popolaFrame() {

		formattedTextFieldPuntiAbilita.setValue(pgLingueObj.getPuntiAbilita());
		textFieldLinguaParlata.setText(pgLingueObj.getLinguaParlata());
		textFieldAlfabeto.setText(pgLingueObj.getAlfabeto());
	}

	private void inserisciLingua() {
		boolean datiOk = true;
		if (datiOk && pgLingueObj.getLinguaParlata().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Inserire la lingua parlata", "Errore", JOptionPane.ERROR_MESSAGE);
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

	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();

		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldPuntiAbilita) {
				pgLingueObj = aggiornaOggetti.aggiornaLingua(pgLingueObj, ListaPgLingue.PUNTI_ABILITA,
						formattedTextFieldPuntiAbilita.getText());
			}
		}
		if (component instanceof JTextField) {
			if ((JTextField) component == textFieldLinguaParlata) {
				pgLingueObj = aggiornaOggetti.aggiornaLingua(pgLingueObj, ListaPgLingue.LINGUA_PARLATA,
						textFieldLinguaParlata.getText());
			}
			if ((JTextField) component == textFieldAlfabeto) {
				pgLingueObj = aggiornaOggetti.aggiornaLingua(pgLingueObj, ListaPgLingue.ALFABETO,
						textFieldAlfabeto.getText());
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == okButton.getActionCommand()) {
				inserisciLingua();
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




	public PgLingueObj getPgLingueObj() {
		return pgLingueObj;
	}

	public void setPgLingueObj(PgLingueObj pgLingueObj) {
		this.pgLingueObj = pgLingueObj;
	}

	public ListaGestioneDati getAzione() {
		return azione;
	}

	public void setAzione(ListaGestioneDati azione) {
		this.azione = azione;
	}

}
