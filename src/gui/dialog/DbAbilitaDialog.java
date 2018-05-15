package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import Classi.AggiornaOggetti;
import ENUM.ListaGestioneDati;
import obj.DbAbilitaObj;
import obj.OpzioniObj;
import tableModels.DbAbilitaTableModel;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Beans;
import java.util.ArrayList;

import json.GestioneJsonItems;
import json.GestioneJsonOpzioni;

public class DbAbilitaDialog extends JDialog implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2056654536927708290L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableAbilita;
	GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	ArrayList<DbAbilitaObj> arrayAbilita = new ArrayList<DbAbilitaObj>();
	OpzioniObj opzioniObj = new OpzioniObj();
	boolean result = false;
	private JButton btnInserisciAbilita;
	private JButton btnModificaAbilita;
	private JButton btnCancellaRigaSelezionata;
	private JButton okButton;
	private JButton cancelButton;

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
			DbAbilitaDialog dialog = new DbAbilitaDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DbAbilitaDialog() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				salvaDimensioniFinestra();
				setVisible(false);
			}
		});
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();

		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Gestione Abilità");
		setBounds(100, 100, 594, 300);
		if (opzioniObj.getDbAbilitaDialogX() > 0 && opzioniObj.getDbAbilitaDialogY() > 0
				&& opzioniObj.getDbAbilitaDialogWidth() > 0 && opzioniObj.getDbAbilitaDialogHeight() > 0) {
			setBounds(opzioniObj.getDbAbilitaDialogX(), opzioniObj.getDbAbilitaDialogY(),
					opzioniObj.getDbAbilitaDialogWidth(), opzioniObj.getDbAbilitaDialogHeight());
		}
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridwidth = 3;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				tableAbilita = new JTable();
				tableAbilita.addMouseListener(this);
				tableAbilita.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				DbAbilitaTableModel abilitaTableModel = new DbAbilitaTableModel();
				tableAbilita.setModel(abilitaTableModel);
				TableColumnModel tcm = tableAbilita.getColumnModel();
				tcm.removeColumn(tcm.getColumn(4));
				tcm.removeColumn(tcm.getColumn(3));
				tableAbilita.getTableHeader().addMouseListener(this);
				tableAbilita.getTableHeader().setReorderingAllowed(false);
				scrollPane.setViewportView(tableAbilita);
			}
		}
		{
			btnInserisciAbilita = new JButton("Inserisci Abilità");
			btnInserisciAbilita.addActionListener(this);
			GridBagConstraints gbc_btnInserisciAbilita = new GridBagConstraints();
			gbc_btnInserisciAbilita.anchor = GridBagConstraints.WEST;
			gbc_btnInserisciAbilita.insets = new Insets(0, 0, 0, 5);
			gbc_btnInserisciAbilita.gridx = 0;
			gbc_btnInserisciAbilita.gridy = 1;
			contentPanel.add(btnInserisciAbilita, gbc_btnInserisciAbilita);
		}
		{
			btnModificaAbilita = new JButton("Modifica Abilità");
			btnModificaAbilita.addActionListener(this);
			GridBagConstraints gbc_btnModificaAbilita = new GridBagConstraints();
			gbc_btnModificaAbilita.insets = new Insets(0, 0, 0, 5);
			gbc_btnModificaAbilita.gridx = 1;
			gbc_btnModificaAbilita.gridy = 1;
			contentPanel.add(btnModificaAbilita, gbc_btnModificaAbilita);
		}
		{
			btnCancellaRigaSelezionata = new JButton("Cancella riga Selezionata");
			btnCancellaRigaSelezionata.addActionListener(this);
			GridBagConstraints gbc_btnCancellaRigaSelezionata = new GridBagConstraints();
			gbc_btnCancellaRigaSelezionata.anchor = GridBagConstraints.WEST;
			gbc_btnCancellaRigaSelezionata.gridx = 2;
			gbc_btnCancellaRigaSelezionata.gridy = 1;
			contentPanel.add(btnCancellaRigaSelezionata, gbc_btnCancellaRigaSelezionata);
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
		caricaDimensioniTableAbilita(opzioniObj.getDimensioniTableDbAbilita());

		if (!Beans.isDesignTime()) {
			arrayAbilita = gestioneJsonItems.getListaAbilita();

			caricaTabella(arrayAbilita);
		}

	}

	private void caricaTabella(ArrayList<DbAbilitaObj> arrayAbilita) {
		TableModel model = new DefaultTableModel();
		model = tableAbilita.getModel();

		// Pulizia tabella
		((DefaultTableModel) model).setRowCount(0);

		for (int i = 0; i < arrayAbilita.size(); i++) {
			DbAbilitaObj dbAbilitaObj = arrayAbilita.get(i);
			((DefaultTableModel) model)
					.addRow(new Object[] { dbAbilitaObj.getNome(), dbAbilitaObj.isRichiedeAddestramento(),
							dbAbilitaObj.getCaratteristica(), dbAbilitaObj.isRigaBloccata(), dbAbilitaObj.getPrg() });
		}

	}

	protected ArrayList<DbAbilitaObj> creaArrayAbilita() {
		ArrayList<DbAbilitaObj> arrayAbilita = new ArrayList<DbAbilitaObj>();

		for (int i = 0; i < tableAbilita.getRowCount(); i++) {
			if (!tableAbilita.getValueAt(i, 0).toString().trim().isEmpty()) {
				DbAbilitaObj abilitaObj = new DbAbilitaObj();

				// Pulizia campi della tabella che sono stati puliti
//				if (tableAbilita.getValueAt(i, 4) == null) {
//					tableAbilita.setValueAt(0, i, 4);
//				}

				abilitaObj.setNome(tableAbilita.getModel().getValueAt(i, 0).toString());
				abilitaObj.setRichiedeAddestramento((boolean) tableAbilita.getModel().getValueAt(i, 1));
				abilitaObj.setCaratteristica(tableAbilita.getModel().getValueAt(i, 2).toString());
				abilitaObj.setRigaBloccata((boolean) tableAbilita.getModel().getValueAt(i, 3));
				abilitaObj.setPrg(Integer.parseInt(tableAbilita.getModel().getValueAt(i, 4).toString()));
				arrayAbilita.add(abilitaObj);
			}
		}
		return arrayAbilita;
	}

	private void inserisciAbilita() {
		ArrayList<DbAbilitaObj> arrayAbilita = creaArrayAbilita();
		DbAbilitaObj dbAbilitaObj = new DbAbilitaObj();
		if (arrayAbilita.size() == 0) {
			dbAbilitaObj.setPrg(1);
		} else {
			int ultimoRecord = arrayAbilita.size() - 1;
			dbAbilitaObj.setPrg(arrayAbilita.get(ultimoRecord).getPrg() + 1);
		}

		GestioneDbAbilitaObjDialog gestioneDbAbilitaObjDialog = new GestioneDbAbilitaObjDialog(
				ListaGestioneDati.INSERISCI, dbAbilitaObj, arrayAbilita);
		gestioneDbAbilitaObjDialog.setVisible(true);
		if (gestioneDbAbilitaObjDialog.isRigaGestita()) {
			dbAbilitaObj = gestioneDbAbilitaObjDialog.getDbAbilitaObj();
			arrayAbilita.add(dbAbilitaObj);
		}

		caricaTabella(arrayAbilita);
	}

	private void modificaAbilita() {

		if (tableAbilita.getSelectedRow() != -1) {
			ArrayList<DbAbilitaObj> arrayAbilita = creaArrayAbilita();
			DbAbilitaObj dbAbilitaObj = arrayAbilita.get(tableAbilita.getSelectedRow());
			if (!dbAbilitaObj.isRigaBloccata()) {

				GestioneDbAbilitaObjDialog gestioneDbAbilitaObjDialog = new GestioneDbAbilitaObjDialog(
						ListaGestioneDati.MODIFICA, dbAbilitaObj, arrayAbilita);
				gestioneDbAbilitaObjDialog.setVisible(true);
				if (gestioneDbAbilitaObjDialog.isRigaGestita()) {
					dbAbilitaObj = gestioneDbAbilitaObjDialog.getDbAbilitaObj();
					for (int i = 0; i < arrayAbilita.size(); i++) {
						if (arrayAbilita.get(i).getPrg() == dbAbilitaObj.getPrg()) {
							arrayAbilita.set(i, dbAbilitaObj);
						}
					}
				}
				caricaTabella(arrayAbilita);
			}
		}

	}

	private void cancellaRigaSelezionata() {

		if (tableAbilita.getSelectedRow() != -1) {
			ArrayList<DbAbilitaObj> arrayAbilita = creaArrayAbilita();
			DbAbilitaObj dbAbilitaObj = arrayAbilita.get(tableAbilita.getSelectedRow());
			if (!dbAbilitaObj.isRigaBloccata()) {
				((DefaultTableModel) tableAbilita.getModel()).removeRow(tableAbilita.getSelectedRow());

				if (tableAbilita.getRowCount() > 0) {
					tableAbilita.setRowSelectionInterval(0, 0);
				}
			}
		}
	}

	private void salvaDimensioniFinestra() {
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		Rectangle dimensioniFinestra = this.getBounds();

		opzioniObj.setDbAbilitaDialogX(dimensioniFinestra.x);
		opzioniObj.setDbAbilitaDialogY(dimensioniFinestra.y);
		opzioniObj.setDbAbilitaDialogWidth(dimensioniFinestra.width);
		opzioniObj.setDbAbilitaDialogHeight(dimensioniFinestra.height);

		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);

	}

	private void caricaDimensioniTableAbilita(ArrayList<Integer> arrayDimensioni) {
		if (arrayDimensioni.size() > 0 && tableAbilita.getColumnCount() == arrayDimensioni.size()) {
			for (int i = 0; i < tableAbilita.getColumnCount(); i++) {
				tableAbilita.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			// tableAbilita.getColumnModel().getColumn(0).setPreferredWidth(300);

		}
	}

	private void salvaDimensioniTableAbilita() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableAbilita.getColumnCount(); i++) {
			arrayDimensioni.add(tableAbilita.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTableDbAbilita(arrayDimensioni);
		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == btnInserisciAbilita.getActionCommand()) {
				inserisciAbilita();
			}
			if (((JButton) oggetto).getActionCommand() == btnModificaAbilita.getActionCommand()) {
				modificaAbilita();
			}
			if (((JButton) oggetto).getActionCommand() == btnCancellaRigaSelezionata.getActionCommand()) {
				cancellaRigaSelezionata();
			}
			if (((JButton) oggetto).getActionCommand() == okButton.getActionCommand()) {
				salvaDimensioniFinestra();
				ArrayList<DbAbilitaObj> arrayAbilita = creaArrayAbilita();
				result = gestioneJsonItems.aggiornaAbilita(arrayAbilita);
				if (result) {
					setVisible(false);
				}
			}
			if (((JButton) oggetto).getActionCommand() == cancelButton.getActionCommand()) {
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
			if ((JTable) component == tableAbilita) {
				if (e.getClickCount() == 2 && tableAbilita.getSelectedRow() != -1) {
					modificaAbilita();
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTableHeader) {
			if ((JTableHeader) component == tableAbilita.getTableHeader()) {
				salvaDimensioniTableAbilita();
			}
		}
	}

}
