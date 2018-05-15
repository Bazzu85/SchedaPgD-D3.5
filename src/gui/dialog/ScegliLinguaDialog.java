package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;

import comboBox.DbArmiComboBox;
import comboBox.LinguaComboBox;

import ENUM.ListaDbArmi;

import obj.DbArmiObj;
import obj.OpzioniObj;

import java.awt.GridBagConstraints;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.Beans;
import java.util.ArrayList;

import json.GestioneJsonOpzioni;
import java.awt.event.FocusAdapter;

public class ScegliLinguaDialog extends JDialog implements ActionListener,
		FocusListener {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	OpzioniObj opzioniObj = new OpzioniObj();
	private JComboBox comboBoxLingua;
	String linguaSelezionata = "";
	LinguaComboBox linguaComboBox = new LinguaComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ScegliLinguaDialog dialog = new ScegliLinguaDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ScegliLinguaDialog() {
		setTitle("Cambio Lingua");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 252, 109);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			comboBoxLingua = new JComboBox();
			comboBoxLingua.addFocusListener(this);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 0;
			gbc_comboBox.gridy = 0;
			contentPanel.add(comboBoxLingua, gbc_comboBox);
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
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		// Carica comboBoxCategoria1
		comboBoxLingua.setModel(linguaComboBox.creaComboBoxLingua().getModel());

		if (comboBoxLingua.getItemCount() != 0) {
			comboBoxLingua.setSelectedIndex(0);
			for (int i = 0; i < comboBoxLingua.getItemCount(); i++) {
				if (comboBoxLingua.getItemAt(i).toString()
						.equals(opzioniObj.getLingua())) {
					comboBoxLingua.setSelectedIndex(i);
				}
			}
		}

	}

	private void valorizzaLingua(String linguaSelezionata) {

		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();

		if (opzioniObj.getLingua().equals(linguaSelezionata)) {
		} else {
			JOptionPane.showMessageDialog(this,
					"Riavviare il programma per applicare le modifiche",
					"Errore", JOptionPane.ERROR_MESSAGE);
		}
		opzioniObj.setLingua(linguaSelezionata);
		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();
		if (oggetto instanceof JButton) {

			if (((JButton) oggetto).getActionCommand() == okButton
					.getActionCommand()) {

				valorizzaLingua(linguaSelezionata);
			}
			if (((JButton) oggetto).getActionCommand() == cancelButton
					.getActionCommand()) {
				setVisible(false);
			}

		}
	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();
		if (component instanceof JComboBox) {
			if ((JComboBox) component == comboBoxLingua) {
				linguaSelezionata = comboBoxLingua.getSelectedItem().toString();
			}
		}

	}

}
