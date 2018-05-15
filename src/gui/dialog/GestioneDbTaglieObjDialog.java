package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaDbTaglie;
import ENUM.ListaGestioneDati;
import obj.DbTaglieObj;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.beans.Beans;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

public class GestioneDbTaglieObjDialog extends JDialog implements ActionListener, FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8589228780209458461L;
	DbTaglieObj dbTaglieObj = new DbTaglieObj();
	ArrayList<DbTaglieObj> arrayTaglie = new ArrayList<DbTaglieObj>();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	boolean rigaGestita = false;
	Formati formati = new Formati();

	
	ListaGestioneDati azione;
	private JFormattedTextField formattedTextFieldModTaglia;
	private JFormattedTextField formattedTextFieldModTagliaSpeciale;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DbTaglieObj dbTaglieObj = new DbTaglieObj();
			ArrayList<DbTaglieObj> arrayTaglie = new ArrayList<DbTaglieObj>();
			GestioneDbTaglieObjDialog dialog = new GestioneDbTaglieObjDialog(ListaGestioneDati.INSERISCI, dbTaglieObj, arrayTaglie);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param prg 
	 * @param azione 
	 */
	public GestioneDbTaglieObjDialog(ListaGestioneDati azione, DbTaglieObj dbTaglieObj, ArrayList<DbTaglieObj> arrayTaglie) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		setAzione(azione);
		setDbTaglieObj(dbTaglieObj);
		setArrayTaglie(arrayTaglie);
		
		NumberFormatter soloNumeriConSegno = formati.getSoloNumeriConSegno();

		switch (azione) {
		case INSERISCI:
			setTitle("Nuova Taglia");
			break;
		case MODIFICA:
			setTitle("Modifica Taglia");
			break;
		}
		setBounds(100, 100, 450, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			JLabel lblModTaglia = new JLabel("Mod. Taglia:");
			GridBagConstraints gbc_lblModTaglia = new GridBagConstraints();
			gbc_lblModTaglia.anchor = GridBagConstraints.EAST;
			gbc_lblModTaglia.insets = new Insets(0, 0, 5, 5);
			gbc_lblModTaglia.gridx = 0;
			gbc_lblModTaglia.gridy = 1;
			contentPanel.add(lblModTaglia, gbc_lblModTaglia);
		}
		{
			formattedTextFieldModTaglia = new JFormattedTextField(soloNumeriConSegno);
			formattedTextFieldModTaglia.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldModTaglia = new GridBagConstraints();
			gbc_formattedTextFieldModTaglia.insets = new Insets(0, 0, 5, 0);
			gbc_formattedTextFieldModTaglia.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldModTaglia.gridx = 1;
			gbc_formattedTextFieldModTaglia.gridy = 1;
			contentPanel.add(formattedTextFieldModTaglia, gbc_formattedTextFieldModTaglia);
		}
		{
			JLabel lblModTagliaSpeciale = new JLabel("Mod. Taglia Speciale: ");
			GridBagConstraints gbc_lblModTagliaSpeciale = new GridBagConstraints();
			gbc_lblModTagliaSpeciale.anchor = GridBagConstraints.EAST;
			gbc_lblModTagliaSpeciale.insets = new Insets(0, 0, 0, 5);
			gbc_lblModTagliaSpeciale.gridx = 0;
			gbc_lblModTagliaSpeciale.gridy = 2;
			contentPanel.add(lblModTagliaSpeciale, gbc_lblModTagliaSpeciale);
		}
		{
			formattedTextFieldModTagliaSpeciale = new JFormattedTextField(soloNumeriConSegno);
			formattedTextFieldModTagliaSpeciale.addFocusListener(this);
			GridBagConstraints gbc_formattedTextFieldModTagliaSpeciale = new GridBagConstraints();
			gbc_formattedTextFieldModTagliaSpeciale.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedTextFieldModTagliaSpeciale.gridx = 1;
			gbc_formattedTextFieldModTagliaSpeciale.gridy = 2;
			contentPanel.add(formattedTextFieldModTagliaSpeciale, gbc_formattedTextFieldModTagliaSpeciale);
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

		textFieldNome.setText(dbTaglieObj.getNome());
		formattedTextFieldModTaglia.setValue(dbTaglieObj.getModTaglia());
		formattedTextFieldModTagliaSpeciale.setValue(dbTaglieObj.getModTagliaSpeciale());
	}

	private void gestioneTaglia() {
		boolean datiOk = true;
		if (datiOk && dbTaglieObj.getNome().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Inserire il nome della taglia", "Errore", JOptionPane.ERROR_MESSAGE);
			datiOk = false;
		}
		if (datiOk && azione == ListaGestioneDati.INSERISCI) {
			for (int i = 0; i < arrayTaglie.size(); i++) {
				DbTaglieObj dbTaglieObjTemp = arrayTaglie.get(i);
				if (dbTaglieObjTemp.getNome().equals(dbTaglieObj.getNome())) {
					JOptionPane.showMessageDialog(this, "Taglia già presente nel DB", "Errore",
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
				dbTaglieObj = aggiornaOggetti.aggiornaTaglie(dbTaglieObj, ListaDbTaglie.NOME,
						textFieldNome.getText());
			}
		}
		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldModTaglia) {
				dbTaglieObj = aggiornaOggetti.aggiornaTaglie(dbTaglieObj, ListaDbTaglie.MOD_TAGLIA, formattedTextFieldModTaglia.getText());
			}
			if ((JFormattedTextField) component == formattedTextFieldModTagliaSpeciale) {
				dbTaglieObj = aggiornaOggetti.aggiornaTaglie(dbTaglieObj, ListaDbTaglie.MOD_TAGLIA_SPECIALE,
						formattedTextFieldModTagliaSpeciale.getText());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();
	
		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == okButton.getActionCommand()) {
				gestioneTaglia();
			}
			if (((JButton) oggetto).getActionCommand() == cancelButton.getActionCommand()) {
				setVisible(false);
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

	public DbTaglieObj getDbTaglieObj() {
		return dbTaglieObj;
	}

	public void setDbTaglieObj(DbTaglieObj dbTaglieObj) {
		this.dbTaglieObj = dbTaglieObj;
	}

	public ArrayList<DbTaglieObj> getArrayTaglie() {
		return arrayTaglie;
	}

	public void setArrayTaglie(ArrayList<DbTaglieObj> arrayTaglie) {
		this.arrayTaglie = arrayTaglie;
	}

}
