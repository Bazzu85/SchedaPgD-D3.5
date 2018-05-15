package gui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import json.GestioneJsonPg;

import obj.PgDatiObj;

public class CaricaPgDialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	PgDatiObj pgDatiObj = new PgDatiObj();
//	GestioneDbPgJson gestioneDbJson = new GestioneDbPgJson();
	GestioneJsonPg gestioneJsonPg = new GestioneJsonPg();

	private JTextField textFieldCreaPg;
	JComboBox comboBoxPg = new JComboBox();
	private JButton okButton;
	private JButton cancelButton;
	private JButton btnCancellaPg;
	private JButton btnCrea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			System.out.println(e.getMessage());
		}
		try {
			CaricaPgDialog dialog = new CaricaPgDialog();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Metodo " + new Object() {
			}.getClass().getEnclosingMethod().getName() + " in "
					+ new Object() {
					}.getClass().getEnclosingClass().getName() + ": errore:"
					+ e.getMessage());
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param id2
	 */
	public CaricaPgDialog() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Selezione PG");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
		setModal(true);
		setBounds(100, 100, 450, 135);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{

			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[] { 0, 54, 28, 0 };
			gbl_contentPanel.rowHeights = new int[] { 20, 0, 0 };
			gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, 0.0,
					Double.MIN_VALUE };
			gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0,
					Double.MIN_VALUE };
			contentPanel.setLayout(gbl_contentPanel);
		}
		{
			JLabel lblSelezionaUnPg = new JLabel("Seleziona un PG:");
			GridBagConstraints gbc_lblSelezionaUnPg = new GridBagConstraints();
			gbc_lblSelezionaUnPg.insets = new Insets(0, 0, 5, 5);
			gbc_lblSelezionaUnPg.anchor = GridBagConstraints.EAST;
			gbc_lblSelezionaUnPg.gridx = 0;
			gbc_lblSelezionaUnPg.gridy = 0;
			contentPanel.add(lblSelezionaUnPg, gbc_lblSelezionaUnPg);
		}

		GridBagConstraints gbc_comboBoxPg = new GridBagConstraints();
		gbc_comboBoxPg.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPg.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPg.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxPg.gridx = 1;
		gbc_comboBoxPg.gridy = 0;
		contentPanel.add(comboBoxPg, gbc_comboBoxPg);
		{
			btnCancellaPg = new JButton("Cancella PG");
			btnCancellaPg.addActionListener(this);
			GridBagConstraints gbc_btnCancellaPg = new GridBagConstraints();
			gbc_btnCancellaPg.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnCancellaPg.insets = new Insets(0, 0, 5, 0);
			gbc_btnCancellaPg.gridx = 2;
			gbc_btnCancellaPg.gridy = 0;
			contentPanel.add(btnCancellaPg, gbc_btnCancellaPg);
		}
		{
			JLabel lblOCreaneUno = new JLabel("O Creane uno:");
			GridBagConstraints gbc_lblOCreaneUno = new GridBagConstraints();
			gbc_lblOCreaneUno.anchor = GridBagConstraints.EAST;
			gbc_lblOCreaneUno.insets = new Insets(0, 0, 0, 5);
			gbc_lblOCreaneUno.gridx = 0;
			gbc_lblOCreaneUno.gridy = 1;
			contentPanel.add(lblOCreaneUno, gbc_lblOCreaneUno);
		}
		{
			textFieldCreaPg = new JTextField();
			GridBagConstraints gbc_textFieldCreaPg = new GridBagConstraints();
			gbc_textFieldCreaPg.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCreaPg.insets = new Insets(0, 0, 0, 5);
			gbc_textFieldCreaPg.gridx = 1;
			gbc_textFieldCreaPg.gridy = 1;
			contentPanel.add(textFieldCreaPg, gbc_textFieldCreaPg);
			textFieldCreaPg.setColumns(10);
		}
		{
			btnCrea = new JButton("Crea");
			btnCrea.addActionListener(this);
			GridBagConstraints gbc_btnCrea = new GridBagConstraints();
			gbc_btnCrea.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnCrea.gridx = 2;
			gbc_btnCrea.gridy = 1;
			contentPanel.add(btnCrea, gbc_btnCrea);
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
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		caricaComboBoxPg();

	}

	protected void cancellaPg() {
		if (comboBoxPg.getSelectedItem() != null) {
//			gestioneDb.cancellaPg(comboBoxPg.getSelectedItem().toString());
			gestioneJsonPg.deletePg(comboBoxPg.getSelectedItem().toString());
		}
	}

	protected void creaPg() {

		if (textFieldCreaPg.getText().equals("")) {
			JOptionPane.showMessageDialog(contentPanel,
					"Digitare il nome del PG", "Errore",
					JOptionPane.ERROR_MESSAGE);
		} else {
			PgDatiObj newPg = new PgDatiObj();
			newPg.setNomePg(textFieldCreaPg.getText());
//			gestioneDbJson.insertPg(newPg);
			gestioneJsonPg.createPg(newPg);

		}
	}

	private void caricaComboBoxPg() {
//		String[] pgList = gestioneDbJson.getPgList();
		String[] pgList = gestioneJsonPg.getPgList();
		if (pgList == null) {

		} else {
			comboBoxPg.setModel(new DefaultComboBoxModel(pgList));
		}
	}

	public PgDatiObj getPgDatiObj() {
		return pgDatiObj;
	}

	public void setPgDatiObj(PgDatiObj pgDatiObj) {
		this.pgDatiObj = pgDatiObj;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object oggetto = e.getSource();

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == btnCancellaPg
					.getActionCommand()) {
				if (comboBoxPg.getSelectedItem() != null) {
					cancellaPg();
					caricaComboBoxPg();
				}
			}
			if (((JButton) oggetto).getActionCommand() == btnCrea
					.getActionCommand()) {
				creaPg();
				caricaComboBoxPg();
				textFieldCreaPg.setText("");
			}
			if (((JButton) oggetto).getActionCommand() == okButton
					.getActionCommand()) {
				if (comboBoxPg.getSelectedItem() != null) {
//					setPgDatiObj(gestioneDbJson.getPgDatiByName(comboBoxPg
//							.getSelectedItem().toString()));
					setPgDatiObj(gestioneJsonPg.getPgByFileName(comboBoxPg
					.getSelectedItem().toString()));
					setVisible(false);
				}
			}
			if (((JButton) oggetto).getActionCommand() == cancelButton
					.getActionCommand()) {
				if (comboBoxPg.getSelectedItem() != null) {
					setVisible(false);

				}
			}
		}
	}
}
