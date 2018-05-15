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
import ENUM.ListaPgEquip;
import obj.PgEquipObj;
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
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;

public class GestionePgEquipObjDialog extends JDialog implements FocusListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2383820238827879403L;
	private final JPanel contentPanel = new JPanel();
	int id = 0;
	PgEquipObj pgEquipObj = new PgEquipObj();
	boolean rigaGestita = false;
	ListaGestioneDati azione;


	Formati formati = new Formati();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textFieldNome;
	private JLabel lblNumero;
	private JFormattedTextField formattedTextFieldNumero;
	private JLabel lblPeso;
	private JTextField textFieldPeso;
	private JCheckBox chckbxIndossato;
	private JCheckBox chckbxZaino;
	private JCheckBox chckbxTascaDaCintura;
	private JCheckBox chckbxAltro;

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
			PgEquipObj pgEquipObj = new PgEquipObj();
			GestionePgEquipObjDialog dialog = new GestionePgEquipObjDialog(ListaGestioneDati.INSERISCI, 0, pgEquipObj);
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
	public GestionePgEquipObjDialog(ListaGestioneDati azione, int id, PgEquipObj pgEquipObj) {

		setAzione(azione);
		setId(id);
		setPgEquipObj(pgEquipObj);
		switch (azione) {
		case INSERISCI:
			setTitle("Nuovo Oggetto");
			break;
		case MODIFICA:
			setTitle("Modifica Oggetto");
			break;
		}

		NumberFormatter soloNumeri = formati.getSoloNumeri();

		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 439, 186);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 99, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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
			GridBagConstraints gbc_textFieldEquip = new GridBagConstraints();
			gbc_textFieldEquip.gridwidth = 3;
			gbc_textFieldEquip.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldEquip.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldEquip.gridx = 1;
			gbc_textFieldEquip.gridy = 0;
			contentPanel.add(textFieldNome, gbc_textFieldEquip);
			textFieldNome.setColumns(10);
		}
		{
			{
				lblNumero = new JLabel("Numero:");
				GridBagConstraints gbc_lblNumero = new GridBagConstraints();
				gbc_lblNumero.anchor = GridBagConstraints.EAST;
				gbc_lblNumero.insets = new Insets(0, 0, 5, 5);
				gbc_lblNumero.gridx = 0;
				gbc_lblNumero.gridy = 1;
				contentPanel.add(lblNumero, gbc_lblNumero);
			}
		}
		{
			formattedTextFieldNumero = new JFormattedTextField(soloNumeri);
			formattedTextFieldNumero.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldNumero = new GridBagConstraints();
			gbc_formattedTextFieldNumero.gridwidth = 3;
			gbc_formattedTextFieldNumero.insets = new Insets(0, 0, 5, 0);
			gbc_formattedTextFieldNumero.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldNumero.gridx = 1;
			gbc_formattedTextFieldNumero.gridy = 1;
			contentPanel.add(formattedTextFieldNumero, gbc_formattedTextFieldNumero);
		}
		{
			lblPeso = new JLabel("Peso:");
			GridBagConstraints gbc_lblPeso = new GridBagConstraints();
			gbc_lblPeso.anchor = GridBagConstraints.EAST;
			gbc_lblPeso.insets = new Insets(0, 0, 5, 5);
			gbc_lblPeso.gridx = 0;
			gbc_lblPeso.gridy = 2;
			contentPanel.add(lblPeso, gbc_lblPeso);
		}
		{
			textFieldPeso = new JTextField();
			textFieldPeso.addFocusListener(this);
			GridBagConstraints gbc_textFieldPeso = new GridBagConstraints();
			gbc_textFieldPeso.gridwidth = 3;
			gbc_textFieldPeso.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldPeso.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldPeso.gridx = 1;
			gbc_textFieldPeso.gridy = 2;
			contentPanel.add(textFieldPeso, gbc_textFieldPeso);
			textFieldPeso.setColumns(10);
		}
		{
			{
				chckbxIndossato = new JCheckBox("Indossato");
				chckbxIndossato.addActionListener(this);
				GridBagConstraints gbc_chckbxIndossato = new GridBagConstraints();
				gbc_chckbxIndossato.insets = new Insets(0, 0, 0, 5);
				gbc_chckbxIndossato.gridx = 0;
				gbc_chckbxIndossato.gridy = 3;
				contentPanel.add(chckbxIndossato, gbc_chckbxIndossato);
			}
			{
				chckbxZaino = new JCheckBox("Zaino");
				chckbxZaino.addActionListener(this);
				GridBagConstraints gbc_chckbxZaino = new GridBagConstraints();
				gbc_chckbxZaino.insets = new Insets(0, 0, 0, 5);
				gbc_chckbxZaino.gridx = 1;
				gbc_chckbxZaino.gridy = 3;
				contentPanel.add(chckbxZaino, gbc_chckbxZaino);
			}
			{
				chckbxTascaDaCintura = new JCheckBox("Tasca Da Cintura");
				chckbxTascaDaCintura.addActionListener(this);
				GridBagConstraints gbc_chckbxTascaDaCintura = new GridBagConstraints();
				gbc_chckbxTascaDaCintura.insets = new Insets(0, 0, 0, 5);
				gbc_chckbxTascaDaCintura.gridx = 2;
				gbc_chckbxTascaDaCintura.gridy = 3;
				contentPanel.add(chckbxTascaDaCintura, gbc_chckbxTascaDaCintura);
			}
			{
				chckbxAltro = new JCheckBox("Altro");
				chckbxAltro.addActionListener(this);
				GridBagConstraints gbc_chckbxAltro = new GridBagConstraints();
				gbc_chckbxAltro.anchor = GridBagConstraints.WEST;
				gbc_chckbxAltro.gridx = 3;
				gbc_chckbxAltro.gridy = 3;
				contentPanel.add(chckbxAltro, gbc_chckbxAltro);
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

	private void popolaFrame() {

		textFieldNome.setText(pgEquipObj.getNome());
		formattedTextFieldNumero.setValue(pgEquipObj.getNumero());
		textFieldPeso.setText(String.valueOf(pgEquipObj.getPeso()));
		chckbxIndossato.setSelected(pgEquipObj.isIndossato());
		chckbxZaino.setSelected(pgEquipObj.isZaino());
		chckbxTascaDaCintura.setSelected(pgEquipObj.isTascaDaCintura());
		chckbxAltro.setSelected(pgEquipObj.isAltro());

	}

	private void gestioneEquip() {
		boolean datiOk = true;

		if (datiOk && pgEquipObj.getNome().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Inserire il nome dell'oggetto", "Errore", JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && !pgEquipObj.isIndossato() && !pgEquipObj.isZaino() && !pgEquipObj.isTascaDaCintura() && !pgEquipObj.isAltro()) {
			JOptionPane.showMessageDialog(this, "Selezionare se Indossato/Nello Zaino/Tasca Da Cintura/Altro", "Errore", JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk) {
			int selezionati = 0;
			if (pgEquipObj.isIndossato()){
				selezionati = selezionati + 1;
			}
			if (pgEquipObj.isZaino()){
				selezionati = selezionati + 1;
			}
			if (pgEquipObj.isTascaDaCintura()){
				selezionati = selezionati + 1;
			}
			if (pgEquipObj.isAltro()){
				selezionati = selezionati + 1;
			}
			if (selezionati > 1){
				JOptionPane.showMessageDialog(this, "Selezionare solo uno tra Indossato/Nello Zaino/Tasca Da Cintura/Altro", "Errore", JOptionPane.ERROR_MESSAGE);
				datiOk = false;
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
				pgEquipObj = aggiornaOggetti.aggiornaEquip(pgEquipObj, ListaPgEquip.NOME,
						textFieldNome.getText());
			}
			if ((JTextField) component == textFieldPeso) {
				try {
					textFieldPeso.setText(textFieldPeso.getText().replaceAll(",", "."));
					Double d = Double.parseDouble(textFieldPeso.getText());
					pgEquipObj = aggiornaOggetti.aggiornaEquip(pgEquipObj,
							ListaPgEquip.PESO,
							textFieldPeso.getText());

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(this, "Formato non valido", "Errore", JOptionPane.ERROR_MESSAGE);
					Double d = 0.0;
					textFieldPeso.setText(String.valueOf(d));
				}
			}
			
		}
		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldNumero) {
				pgEquipObj = aggiornaOggetti.aggiornaEquip(pgEquipObj, ListaPgEquip.NUMERO, formattedTextFieldNumero.getText());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JCheckBox) {
			if (((JCheckBox) oggetto).getActionCommand() == chckbxIndossato.getActionCommand()) {
				pgEquipObj = aggiornaOggetti.aggiornaEquip(pgEquipObj, ListaPgEquip.INDOSSATO,
						Boolean.valueOf(chckbxIndossato.isSelected()).toString());
			}
			if (((JCheckBox) oggetto).getActionCommand() == chckbxZaino.getActionCommand()) {
				pgEquipObj = aggiornaOggetti.aggiornaEquip(pgEquipObj, ListaPgEquip.ZAINO,
						Boolean.valueOf(chckbxZaino.isSelected()).toString());
			}
			if (((JCheckBox) oggetto).getActionCommand() == chckbxTascaDaCintura.getActionCommand()) {
				pgEquipObj = aggiornaOggetti.aggiornaEquip(pgEquipObj, ListaPgEquip.TRASPORTATO,
						Boolean.valueOf(chckbxTascaDaCintura.isSelected()).toString());
			}
			if (((JCheckBox) oggetto).getActionCommand() == chckbxAltro.getActionCommand()) {
				pgEquipObj = aggiornaOggetti.aggiornaEquip(pgEquipObj, ListaPgEquip.ALTRO,
						Boolean.valueOf(chckbxAltro.isSelected()).toString());
			}
		}
		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == okButton.getActionCommand()) {
				gestioneEquip();
			}
			if (((JButton) oggetto).getActionCommand() == cancelButton.getActionCommand()) {
				setVisible(false);
			}
		}
	}

	public PgEquipObj getPgEquipObj() {
		return pgEquipObj;
	}

	public void setPgEquipObj(PgEquipObj pgEquipObj) {
		this.pgEquipObj = pgEquipObj;
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
