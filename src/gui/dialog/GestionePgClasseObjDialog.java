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
import ENUM.ListaPgClasse;
import obj.PgClasseObj;
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
import javax.swing.JCheckBox;

public class GestionePgClasseObjDialog extends JDialog implements FocusListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2963699703457964759L;
	int id = 0;
	int prg = 0;
	ListaGestioneDati azione;

	boolean rigaGestita = false;
	PgClasseObj pgClasseObj = new PgClasseObj();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	Formati formati = new Formati();

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldClasse;
	private JTextField textFieldDadoVita;
	private JFormattedTextField formattedTextFieldLivello;
	private JFormattedTextField formattedTextFieldPuntiFerita;
	private JButton okButton;
	private JButton cancelButton;
	private JCheckBox chckbxClasseDiPrestigio;
	private JLabel lblBonusAttaccoClasse;
	private JFormattedTextField formattedTextFieldBabClasse;

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
			PgClasseObj pgClasseObj = new PgClasseObj();
			GestionePgClasseObjDialog dialog = new GestionePgClasseObjDialog(ListaGestioneDati.INSERISCI, 0, pgClasseObj);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionePgClasseObjDialog(ListaGestioneDati azione, int id, PgClasseObj pgClasseObj) {
		setModalityType(ModalityType.APPLICATION_MODAL);

		setAzione(azione);
		setId(id);
		setPgClasseObj(pgClasseObj);

		NumberFormatter soloNumeri = formati.getSoloNumeri();


		switch (azione) {
		case INSERISCI:
			setTitle("Nuova Classe");
			break;
		case MODIFICA:
			setTitle("Modifica Classe");
			break;
		}
		setBounds(100, 100, 436, 272);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 281, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblClasse = new JLabel("Classe:");
			GridBagConstraints gbc_lblClasse = new GridBagConstraints();
			gbc_lblClasse.insets = new Insets(0, 0, 5, 5);
			gbc_lblClasse.anchor = GridBagConstraints.EAST;
			gbc_lblClasse.gridx = 0;
			gbc_lblClasse.gridy = 0;
			contentPanel.add(lblClasse, gbc_lblClasse);
		}
		{
			textFieldClasse = new JTextField();
			textFieldClasse.addFocusListener(this);
			GridBagConstraints gbc_textFieldClasse = new GridBagConstraints();
			gbc_textFieldClasse.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldClasse.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldClasse.gridx = 1;
			gbc_textFieldClasse.gridy = 0;
			contentPanel.add(textFieldClasse, gbc_textFieldClasse);
			textFieldClasse.setColumns(10);
		}
		{
			JLabel lblLivello = new JLabel("Livello:");
			GridBagConstraints gbc_lblLivello = new GridBagConstraints();
			gbc_lblLivello.anchor = GridBagConstraints.EAST;
			gbc_lblLivello.insets = new Insets(0, 0, 5, 5);
			gbc_lblLivello.gridx = 0;
			gbc_lblLivello.gridy = 1;
			contentPanel.add(lblLivello, gbc_lblLivello);
		}
		{
			formattedTextFieldLivello = new JFormattedTextField(soloNumeri);
			formattedTextFieldLivello.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldLivello = new GridBagConstraints();
			gbc_formattedTextFieldLivello.insets = new Insets(0, 0, 5, 0);
			gbc_formattedTextFieldLivello.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldLivello.gridx = 1;
			gbc_formattedTextFieldLivello.gridy = 1;
			contentPanel.add(formattedTextFieldLivello, gbc_formattedTextFieldLivello);
		}
		{
			JLabel lblDadoVita = new JLabel("Dado Vita:");
			GridBagConstraints gbc_lblDadoVita = new GridBagConstraints();
			gbc_lblDadoVita.anchor = GridBagConstraints.EAST;
			gbc_lblDadoVita.insets = new Insets(0, 0, 5, 5);
			gbc_lblDadoVita.gridx = 0;
			gbc_lblDadoVita.gridy = 2;
			contentPanel.add(lblDadoVita, gbc_lblDadoVita);
		}
		{
			textFieldDadoVita = new JTextField();
			textFieldDadoVita.addFocusListener(this);
			GridBagConstraints gbc_textFieldDadoVita = new GridBagConstraints();
			gbc_textFieldDadoVita.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldDadoVita.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldDadoVita.gridx = 1;
			gbc_textFieldDadoVita.gridy = 2;
			contentPanel.add(textFieldDadoVita, gbc_textFieldDadoVita);
			textFieldDadoVita.setColumns(10);
		}
		{
			JLabel lblPuntiFerita = new JLabel("Punti Ferita:");
			GridBagConstraints gbc_lblPuntiFerita = new GridBagConstraints();
			gbc_lblPuntiFerita.anchor = GridBagConstraints.EAST;
			gbc_lblPuntiFerita.insets = new Insets(0, 0, 5, 5);
			gbc_lblPuntiFerita.gridx = 0;
			gbc_lblPuntiFerita.gridy = 3;
			contentPanel.add(lblPuntiFerita, gbc_lblPuntiFerita);
		}
		{
			formattedTextFieldPuntiFerita = new JFormattedTextField(soloNumeri);
			formattedTextFieldPuntiFerita.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldPuntiFerita = new GridBagConstraints();
			gbc_formattedTextFieldPuntiFerita.insets = new Insets(0, 0, 5, 0);
			gbc_formattedTextFieldPuntiFerita.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldPuntiFerita.gridx = 1;
			gbc_formattedTextFieldPuntiFerita.gridy = 3;
			contentPanel.add(formattedTextFieldPuntiFerita, gbc_formattedTextFieldPuntiFerita);
		}
		{
			chckbxClasseDiPrestigio = new JCheckBox("Classe di Prestigio");
			chckbxClasseDiPrestigio.addActionListener(this);
			GridBagConstraints gbc_chckbxClasseDiPrestigio = new GridBagConstraints();
			gbc_chckbxClasseDiPrestigio.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxClasseDiPrestigio.gridwidth = 2;
			gbc_chckbxClasseDiPrestigio.gridx = 0;
			gbc_chckbxClasseDiPrestigio.gridy = 4;
			contentPanel.add(chckbxClasseDiPrestigio, gbc_chckbxClasseDiPrestigio);
		}
		{
			lblBonusAttaccoClasse = new JLabel("Bonus Attacco Classe:");
			GridBagConstraints gbc_lblBonusAttaccoClasse = new GridBagConstraints();
			gbc_lblBonusAttaccoClasse.anchor = GridBagConstraints.EAST;
			gbc_lblBonusAttaccoClasse.insets = new Insets(0, 0, 0, 5);
			gbc_lblBonusAttaccoClasse.gridx = 0;
			gbc_lblBonusAttaccoClasse.gridy = 5;
			contentPanel.add(lblBonusAttaccoClasse, gbc_lblBonusAttaccoClasse);
		}
		{
			formattedTextFieldBabClasse = new JFormattedTextField(soloNumeri);
			formattedTextFieldBabClasse.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldBabClasse = new GridBagConstraints();
			gbc_formattedTextFieldBabClasse.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldBabClasse.gridx = 1;
			gbc_formattedTextFieldBabClasse.gridy = 5;
			contentPanel.add(formattedTextFieldBabClasse, gbc_formattedTextFieldBabClasse);
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

		textFieldClasse.setText(pgClasseObj.getClasse());
		formattedTextFieldLivello.setValue(pgClasseObj.getLivello());
		textFieldDadoVita.setText(pgClasseObj.getDadoVita());
		formattedTextFieldPuntiFerita.setValue(pgClasseObj.getPuntiFerita());
		formattedTextFieldBabClasse.setValue(pgClasseObj.getBabClasse());
	}

	private void inserisciClasse() {
		boolean datiOk = true;
		if (datiOk && pgClasseObj.getClasse().trim().isEmpty()){
			JOptionPane.showMessageDialog(this, "Inserire il nome della Classe", "Errore", JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk){
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
			if ((JFormattedTextField) component == formattedTextFieldLivello) {
				pgClasseObj = aggiornaOggetti.aggiornaClasse(pgClasseObj,
						ListaPgClasse.LIVELLO,
						formattedTextFieldLivello.getText());
			}
			if ((JFormattedTextField) component == formattedTextFieldPuntiFerita) {
				pgClasseObj = aggiornaOggetti.aggiornaClasse(pgClasseObj,
						ListaPgClasse.PUNTI_FERITA,
						formattedTextFieldPuntiFerita.getText());
			}
			if ((JFormattedTextField) component == formattedTextFieldBabClasse) {
				pgClasseObj = aggiornaOggetti.aggiornaClasse(pgClasseObj,
						ListaPgClasse.BAB_CLASSE,
						formattedTextFieldBabClasse.getText());
			}
			
		}
		if (component instanceof JTextField) {
			if ((JTextField) component == textFieldClasse) {
				pgClasseObj = aggiornaOggetti.aggiornaClasse(pgClasseObj, ListaPgClasse.CLASSE,
						textFieldClasse.getText());
			}
			if ((JTextField) component == textFieldDadoVita) {
				pgClasseObj = aggiornaOggetti.aggiornaClasse(pgClasseObj, ListaPgClasse.DADO_VITA,
						textFieldDadoVita.getText());
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == okButton.getActionCommand()) {
				inserisciClasse();
			}
			if (((JButton) oggetto).getActionCommand() == cancelButton.getActionCommand()) {
				setVisible(false);
			}
		}
		if (oggetto instanceof JCheckBox) {
			if (((JCheckBox) oggetto).getActionCommand() == chckbxClasseDiPrestigio.getActionCommand()) {
				pgClasseObj = aggiornaOggetti.aggiornaClasse(pgClasseObj, ListaPgClasse.IS_CLASSE_DI_PRESTIGIO,
						Boolean.valueOf(chckbxClasseDiPrestigio.isSelected()).toString());
			}
		}
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

	public boolean isRigaGestita() {
		return rigaGestita;
	}

	public void setRigaGestita(boolean rigaGestita) {
		this.rigaGestita = rigaGestita;
	}

	public PgClasseObj getPgClasseObj() {
		return pgClasseObj;
	}

	public void setPgClasseObj(PgClasseObj pgClasseObj) {
		this.pgClasseObj = pgClasseObj;
	}

	public ListaGestioneDati getAzione() {
		return azione;
	}

	public void setAzione(ListaGestioneDati azione) {
		this.azione = azione;
	}

}
