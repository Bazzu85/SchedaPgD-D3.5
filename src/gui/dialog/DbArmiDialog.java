package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ENUM.ListaGestioneDati;

import json.GestioneJsonItems;
import json.GestioneJsonOpzioni;
import obj.DbArmiObj;
import obj.OpzioniObj;

import tableModels.DbArmiTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.Beans;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DbArmiDialog extends JDialog implements ActionListener,
		FocusListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6313951734629761934L;
	GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	ArrayList<DbArmiObj> arrayArmi = new ArrayList<DbArmiObj>();
	OpzioniObj opzioniObj = new OpzioniObj();
	boolean result = false;
	private final JPanel contentPanel = new JPanel();
	private JTable tableArmi;
	private JButton btnCancellaRigaSelezionata;
	private JButton okButton;
	private JButton cancelButton;
	private JButton btnInserisciArma;
	private JButton btnModificaArma;

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
			DbArmiDialog dialog = new DbArmiDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DbArmiDialog() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				salvaDimensioniFinestra();
				setVisible(false);
			}
		});
		
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();

		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Gestione Armi");
		setBounds(100, 100, 1221, 703);
		if (opzioniObj.getDbArmiDialogX() > 0 && opzioniObj.getDbArmiDialogY() > 0
				&& opzioniObj.getDbArmiDialogWidth() > 0
				&& opzioniObj.getDbArmiDialogHeight() > 0) {
			setBounds(opzioniObj.getDbArmiDialogX(), opzioniObj.getDbArmiDialogY(), opzioniObj.getDbArmiDialogWidth(),
					opzioniObj.getDbArmiDialogHeight());
		}

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridwidth = 3;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				tableArmi = new JTable();
				tableArmi.addMouseListener(this);
				tableArmi.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				tableArmi.setFillsViewportHeight(true);
				DbArmiTableModel armiTableModel = new DbArmiTableModel();
				tableArmi.setModel(armiTableModel);

				TableColumnModel tcm = tableArmi.getColumnModel();
				tcm.removeColumn(tcm.getColumn(14));
				tcm.removeColumn(tcm.getColumn(13));
				tableArmi.setAutoCreateRowSorter(true);
				tableArmi.getTableHeader().addMouseListener(this);
				tableArmi.getTableHeader().setReorderingAllowed(false);

				scrollPane.setViewportView(tableArmi);
			}
		}
		{
			{
				btnInserisciArma = new JButton("Inserisci Arma");
				btnInserisciArma.addActionListener(this);
				GridBagConstraints gbc_btnInserisciArma = new GridBagConstraints();
				gbc_btnInserisciArma.insets = new Insets(0, 0, 0, 5);
				gbc_btnInserisciArma.gridx = 0;
				gbc_btnInserisciArma.gridy = 1;
				contentPanel.add(btnInserisciArma, gbc_btnInserisciArma);
			}
			{
				btnModificaArma = new JButton("Modifica Arma");
				btnModificaArma.addActionListener(this);
				GridBagConstraints gbc_btnModificaArma = new GridBagConstraints();
				gbc_btnModificaArma.insets = new Insets(0, 0, 0, 5);
				gbc_btnModificaArma.gridx = 1;
				gbc_btnModificaArma.gridy = 1;
				contentPanel.add(btnModificaArma, gbc_btnModificaArma);
			}
		}
		btnCancellaRigaSelezionata = new JButton(
				"Cancella Riga Selezionata");
		btnCancellaRigaSelezionata.addActionListener(this);
		GridBagConstraints gbc_btnCancellaRigaSelezionata = new GridBagConstraints();
		gbc_btnCancellaRigaSelezionata.anchor = GridBagConstraints.WEST;
		gbc_btnCancellaRigaSelezionata.gridx = 2;
		gbc_btnCancellaRigaSelezionata.gridy = 1;
		contentPanel.add(btnCancellaRigaSelezionata,
				gbc_btnCancellaRigaSelezionata);
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
		caricaDimensioniTableArmi(opzioniObj.getDimensioniTableDbArmi());

		if (!Beans.isDesignTime()) {
			arrayArmi = gestioneJsonItems.getListaArmi();

			caricaTabella(arrayArmi);
		}
	}

	private void caricaTabella(ArrayList<DbArmiObj> arrayArmi) {
		TableModel model = new DefaultTableModel();
		model = tableArmi.getModel();

		// Pulizia tabella
		((DefaultTableModel) model).setRowCount(0);

		for (int i = 0; i < arrayArmi.size(); i++) {
			DbArmiObj armiObj = new DbArmiObj();
			armiObj = arrayArmi.get(i);
			((DefaultTableModel) model).addRow(new Object[] {
					armiObj.getNome(), armiObj.getCategoria1(),
					armiObj.getCategoria2(), armiObj.isMischia(),
					armiObj.isDistanza(), armiObj.getCosto(),
					armiObj.getDanniP(), armiObj.getDanniM(),
					armiObj.getDanniG(), armiObj.getCritico(),
					armiObj.getIncrementoGittata(), armiObj.getPeso(),
					armiObj.getTipo(), armiObj.isRigaBloccata(),
					armiObj.getPrg() });
		}

	}

	private ArrayList<DbArmiObj> creaArrayArmi() {
		ArrayList<DbArmiObj> arrayArmi = new ArrayList<DbArmiObj>();

		for (int i = 0; i < tableArmi.getRowCount(); i++) {
			DbArmiObj dbArmiObj = new DbArmiObj();

			// Pulizia campi della tabella che sono stati puliti
			if (tableArmi.getValueAt(i, 9) == null) {
				tableArmi.setValueAt(0, i, 9);
			}

			dbArmiObj.setNome(tableArmi.getValueAt(i, 0).toString());
			dbArmiObj.setCategoria1(tableArmi.getValueAt(i, 1).toString());
			dbArmiObj.setCategoria2(tableArmi.getValueAt(i, 2).toString());
			dbArmiObj.setMischia((boolean) tableArmi.getValueAt(i, 3));
			dbArmiObj.setDistanza((boolean) tableArmi.getValueAt(i, 4));
			dbArmiObj.setCosto(tableArmi.getValueAt(i, 5).toString());
			dbArmiObj.setDanniP(tableArmi.getValueAt(i, 6).toString());
			dbArmiObj.setDanniM(tableArmi.getValueAt(i, 7).toString());
			dbArmiObj.setDanniG(tableArmi.getValueAt(i, 8).toString());
			dbArmiObj.setCritico(tableArmi.getValueAt(i, 9).toString());
			dbArmiObj.setIncrementoGittata(tableArmi.getValueAt(i, 10)
					.toString());
			dbArmiObj.setPeso(Double.parseDouble(tableArmi.getValueAt(i, 11)
					.toString()));
			dbArmiObj.setTipo(tableArmi.getValueAt(i, 12).toString());
			dbArmiObj.setRigaBloccata((boolean) tableArmi.getModel()
					.getValueAt(i, 13));
			dbArmiObj.setPrg(Integer.parseInt(tableArmi.getModel()
					.getValueAt(i, 14).toString()));
			arrayArmi.add(dbArmiObj);

		}
		return arrayArmi;
	}

	private void inserisciArma() {
		arrayArmi = creaArrayArmi();
		DbArmiObj dbArmiObj = new DbArmiObj();
		if (arrayArmi.size() == 0) {
			dbArmiObj.setPrg(1);
		} else {
			int ultimoRecord = arrayArmi.size() - 1;
			dbArmiObj.setPrg(arrayArmi.get(ultimoRecord).getPrg() + 1);
		}

		GestioneDbArmiObjDialog gestioneDbArmiObjDialog = new GestioneDbArmiObjDialog(
				ListaGestioneDati.INSERISCI, dbArmiObj, arrayArmi);
		gestioneDbArmiObjDialog.setVisible(true);
		if (gestioneDbArmiObjDialog.isRigaGestita()) {
			dbArmiObj = gestioneDbArmiObjDialog.getDbArmiObj();
			arrayArmi.add(dbArmiObj);
			caricaTabella(arrayArmi);
		}

	}

	private void modificaArma() {
		if (tableArmi.getSelectedRow() != -1) {
			ArrayList<DbArmiObj> arrayArmi = creaArrayArmi();
			DbArmiObj dbArmiObj = arrayArmi.get(tableArmi.getSelectedRow());
			if (!dbArmiObj.isRigaBloccata()) {
				GestioneDbArmiObjDialog gestioneDbArmiObjDialog = new GestioneDbArmiObjDialog(
						ListaGestioneDati.MODIFICA, dbArmiObj, arrayArmi);
				gestioneDbArmiObjDialog.setVisible(true);
				if (gestioneDbArmiObjDialog.isRigaGestita()) {
					dbArmiObj = gestioneDbArmiObjDialog.getDbArmiObj();
					for (int i = 0; i < arrayArmi.size(); i++) {
						if (arrayArmi.get(i).getPrg() == dbArmiObj.getPrg()) {
							arrayArmi.set(i, dbArmiObj);
						}
					}
				}
				caricaTabella(arrayArmi);
			}

		}

	}

	private void cancellaRiga() {

		if (tableArmi.getSelectedRow() != -1) {
			ArrayList<DbArmiObj> arrayArmi = creaArrayArmi();
			DbArmiObj dbArmiObj = arrayArmi.get(tableArmi.getSelectedRow());
			if (!dbArmiObj.isRigaBloccata()) {
				((DefaultTableModel) tableArmi.getModel()).removeRow(tableArmi
						.getSelectedRow());

				if (tableArmi.getRowCount() > 0) {
					tableArmi.setRowSelectionInterval(0, 0);
				}
			}
		}
	}

	private void salvaDimensioniFinestra() {
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		Rectangle dimensioniFinestra = this.getBounds();

		opzioniObj.setDbArmiDialogX(dimensioniFinestra.x);
		opzioniObj.setDbArmiDialogY(dimensioniFinestra.y);
		opzioniObj.setDbArmiDialogWidth(dimensioniFinestra.width);
		opzioniObj.setDbArmiDialogHeight(dimensioniFinestra.height);

		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);

	}
	
	private void caricaDimensioniTableArmi(ArrayList<Integer> arrayDimensioni) {
		if (arrayDimensioni.size() > 0 && tableArmi.getColumnCount() == arrayDimensioni.size()) {
			for (int i = 0; i < tableArmi.getColumnCount(); i++) {
				tableArmi.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			tableArmi.getColumnModel().getColumn(0).setPreferredWidth(300);
			tableArmi.getColumnModel().getColumn(3).setPreferredWidth(50);
			tableArmi.getColumnModel().getColumn(4).setPreferredWidth(50);
			tableArmi.getColumnModel().getColumn(5).setPreferredWidth(50);
			tableArmi.getColumnModel().getColumn(6).setPreferredWidth(50);
			tableArmi.getColumnModel().getColumn(7).setPreferredWidth(50);
			tableArmi.getColumnModel().getColumn(8).setPreferredWidth(50);
			tableArmi.getColumnModel().getColumn(9).setPreferredWidth(50);
			tableArmi.getColumnModel().getColumn(10).setPreferredWidth(50);
			tableArmi.getColumnModel().getColumn(11).setPreferredWidth(50);
			tableArmi.getColumnModel().getColumn(12).setPreferredWidth(100);
		}		
	}
	private void salvaDimensioniTableArmi() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableArmi.getColumnCount(); i++) {
			arrayDimensioni.add(tableArmi.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTableDbArmi(arrayDimensioni);
		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);			
	}

	
	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();
		if (oggetto instanceof JButton) {

			if (((JButton) oggetto).getActionCommand() == btnInserisciArma
					.getActionCommand()) {
				inserisciArma();
			}
			if (((JButton) oggetto).getActionCommand() == btnModificaArma
					.getActionCommand()) {
				modificaArma();
			}

			if (((JButton) oggetto).getActionCommand() == btnCancellaRigaSelezionata
					.getActionCommand()) {
				cancellaRiga();
			}
			if (((JButton) oggetto).getActionCommand() == okButton
					.getActionCommand()) {
				salvaDimensioniFinestra();
				ArrayList<DbArmiObj> arrayArmi = new ArrayList<DbArmiObj>();
				arrayArmi = creaArrayArmi();
				result = gestioneJsonItems.aggiornaArmi(arrayArmi);
				if (result) {
					setVisible(false);
				}
			}
			if (((JButton) oggetto).getActionCommand() == cancelButton
					.getActionCommand()) {
				salvaDimensioniFinestra();
				setVisible(false);
			}

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTable) {
			if ((JTable) component == tableArmi) {
				if (e.getClickCount() == 2 && tableArmi.getSelectedRow() != -1) {
					modificaArma();
				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTableHeader) {
			if ((JTableHeader) component == tableArmi.getTableHeader()) {
				salvaDimensioniTableArmi();
			}
		}

	}

}
