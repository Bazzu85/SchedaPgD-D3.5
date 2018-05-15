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
import ENUM.ListaDbAbilita;
import ENUM.ListaGestioneDati;
import comboBox.DbAbilitaComboBox;
import obj.DbAbilitaObj;
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
import javax.swing.JComboBox;

public class GestioneDbAbilitaObjDialog extends JDialog implements ActionListener, FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4764226690264377046L;
	DbAbilitaObj dbAbilitaObj = new DbAbilitaObj();
	ArrayList<DbAbilitaObj> arrayAbilita = new ArrayList<DbAbilitaObj>();

	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	DbAbilitaComboBox dacb = new DbAbilitaComboBox();

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	boolean rigaGestita = false;
	Formati formati = new Formati();

	ListaGestioneDati azione;
	private JButton okButton;
	private JButton cancelButton;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxCaratteristica;
	private JCheckBox chckbxRichiedeAddestramento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DbAbilitaObj dbAbilitaObj = new DbAbilitaObj();
			ArrayList<DbAbilitaObj> arrayAbilita = new ArrayList<DbAbilitaObj>();
			GestioneDbAbilitaObjDialog dialog = new GestioneDbAbilitaObjDialog(ListaGestioneDati.INSERISCI, dbAbilitaObj, arrayAbilita);
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
	@SuppressWarnings("rawtypes")
	public GestioneDbAbilitaObjDialog(ListaGestioneDati azione,
			DbAbilitaObj dbAbilitaObj, ArrayList<DbAbilitaObj> arrayAbilita) {
		setModalityType(ModalityType.APPLICATION_MODAL);

		setAzione(azione);
		setDbAbilitaObj(dbAbilitaObj);
		setArrayAbilita(arrayAbilita);
		
		switch (azione) {
		case INSERISCI:
			setTitle("Nuova Abilita");
			break;
		case MODIFICA:
			setTitle("Modifica Abilita");
			break;
		}
		setBounds(100, 100, 450, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
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
			if (azione == ListaGestioneDati.MODIFICA){
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
			chckbxRichiedeAddestramento = new JCheckBox("Richiede Addestramento");
			chckbxRichiedeAddestramento.addActionListener(this);
			GridBagConstraints gbc_chckbxRichiedeAddestramento = new GridBagConstraints();
			gbc_chckbxRichiedeAddestramento.gridwidth = 2;
			gbc_chckbxRichiedeAddestramento.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxRichiedeAddestramento.gridx = 0;
			gbc_chckbxRichiedeAddestramento.gridy = 1;
			contentPanel.add(chckbxRichiedeAddestramento, gbc_chckbxRichiedeAddestramento);
		}
		{
			JLabel lblCaratteristica = new JLabel("Caratteristica Chiave:");
			GridBagConstraints gbc_lblCaratteristica = new GridBagConstraints();
			gbc_lblCaratteristica.anchor = GridBagConstraints.EAST;
			gbc_lblCaratteristica.insets = new Insets(0, 0, 0, 5);
			gbc_lblCaratteristica.gridx = 0;
			gbc_lblCaratteristica.gridy = 2;
			contentPanel.add(lblCaratteristica, gbc_lblCaratteristica);
		}
		{
			comboBoxCaratteristica = new JComboBox();
			comboBoxCaratteristica.addFocusListener(this);
			GridBagConstraints gbc_comboBoxCaratteristica = new GridBagConstraints();
			gbc_comboBoxCaratteristica.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxCaratteristica.gridx = 1;
			gbc_comboBoxCaratteristica.gridy = 2;
			contentPanel.add(comboBoxCaratteristica, gbc_comboBoxCaratteristica);
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

		textFieldNome.setText(dbAbilitaObj.getNome());
		chckbxRichiedeAddestramento.setSelected(dbAbilitaObj.isRichiedeAddestramento());

		comboBoxCaratteristica.setModel(dacb.creaComboBoxCaratteristica().getModel());

		if (comboBoxCaratteristica.getItemCount() != 0) {
			comboBoxCaratteristica.setSelectedIndex(0);
			for (int i = 0; i < comboBoxCaratteristica.getItemCount(); i++) {
				if (comboBoxCaratteristica.getItemAt(i).toString().equals(dbAbilitaObj.getCaratteristica())) {
					comboBoxCaratteristica.setSelectedIndex(i);
				}
			}
		}
	}

	private void gestioneAbilita() {
		boolean datiOk = true;
		if (datiOk && dbAbilitaObj.getNome().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Inserire il nome dell'abilità", "Errore", JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && azione == ListaGestioneDati.INSERISCI) {
			for (int i = 0; i < arrayAbilita.size(); i++) {
				DbAbilitaObj dbAbilitaObjTemp = arrayAbilita.get(i);
				if (dbAbilitaObjTemp.getNome().equals(dbAbilitaObj.getNome())) {
					JOptionPane.showMessageDialog(this, "Abilita già presente nel DB", "Errore",
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
				dbAbilitaObj = aggiornaOggetti.aggiornaAbilita(dbAbilitaObj, ListaDbAbilita.NOME,
						textFieldNome.getText());
			}
		}
		if (component instanceof JComboBox) {
			if ((JComboBox) component == comboBoxCaratteristica) {
				dbAbilitaObj = aggiornaOggetti.aggiornaAbilita(dbAbilitaObj, ListaDbAbilita.CARATTERISTICA,
						comboBoxCaratteristica.getSelectedItem().toString());
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == okButton.getActionCommand()) {
				gestioneAbilita();
			}
			if (((JButton) oggetto).getActionCommand() == cancelButton.getActionCommand()) {
				setVisible(false);
			}
		}
		if (oggetto instanceof JCheckBox) {
			if (((JCheckBox) oggetto).getActionCommand() == chckbxRichiedeAddestramento.getActionCommand()) {
				dbAbilitaObj = aggiornaOggetti.aggiornaAbilita(dbAbilitaObj, ListaDbAbilita.RICHIEDE_ADDESTRAMENTO,
						Boolean.valueOf(chckbxRichiedeAddestramento.isSelected()).toString());
			}
		}
	}

	public ListaGestioneDati getAzione() {
		return azione;
	}

	public void setAzione(ListaGestioneDati azione) {
		this.azione = azione;
	}


	public ArrayList<DbAbilitaObj> getArrayAbilita() {
		return arrayAbilita;
	}

	public void setArrayAbilita(ArrayList<DbAbilitaObj> arrayAbilita) {
		this.arrayAbilita = arrayAbilita;
	}

	public boolean isRigaGestita() {
		return rigaGestita;
	}

	public void setRigaGestita(boolean rigaGestita) {
		this.rigaGestita = rigaGestita;
	}

	public DbAbilitaObj getDbAbilitaObj() {
		return dbAbilitaObj;
	}

	public void setDbAbilitaObj(DbAbilitaObj dbAbilitaObj) {
		this.dbAbilitaObj = dbAbilitaObj;
	}

}
