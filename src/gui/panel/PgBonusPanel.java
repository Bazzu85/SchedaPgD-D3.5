package gui.panel;

import javax.swing.JPanel;

import gui.MainWindow;
import gui.dialog.GestionePgBonusObjDialog;
import json.GestioneJsonOpzioni;
import json.GestioneJsonPg;
import obj.OpzioniObj;
import obj.PgBonusObj;
import obj.PgDatiObj;
import tableModels.PgBonusTableModel;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import Classi.AggiornaOggetti;
import ENUM.ListaGestioneDati;
import ENUM.ListaPgDati;
import comboBox.PgBonusComboBox;
import formatRenderer.DecimalWithSignFormatRenderer;

import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;

public class PgBonusPanel extends JPanel implements FocusListener, ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainWindow frame;
	private JTable tableBonus;
	private PgDatiObj pgDatiObj = new PgDatiObj();
	GestioneJsonPg gestioneJsonPg = new GestioneJsonPg();
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	OpzioniObj opzioniObj = new OpzioniObj();
	PgBonusComboBox bcb = new PgBonusComboBox();

	private JButton btnInserisciBonus;
	private JButton btnCancellaRigaSelezionata;
	private AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	private JButton btnModificaBonus;

	/**
	 * Create the panel.
	 * 
	 * @param pgDatiObj
	 */
	public PgBonusPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.pgDatiObj = pgDatiObj;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 382, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);

		tableBonus = new JTable();
		tableBonus.addMouseListener(this);
		tableBonus.setFillsViewportHeight(true);
		tableBonus.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableBonus.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableBonus.addFocusListener(this);
		PgBonusTableModel bonusTableModel = new PgBonusTableModel();
		tableBonus.setModel(bonusTableModel);
		scrollPane.setViewportView(tableBonus);

		tableBonus.getColumnModel().getColumn(1).setCellRenderer(new DecimalWithSignFormatRenderer());
		tableBonus.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumnModel tcm = tableBonus.getColumnModel();
		tcm.removeColumn(tcm.getColumn(4));

		tableBonus.getTableHeader().addMouseListener(this);
		tableBonus.getTableHeader().setReorderingAllowed(false);

		btnInserisciBonus = new JButton("Inserisci Bonus");
		btnInserisciBonus.addActionListener(this);
		GridBagConstraints gbc_btnInserisciRigaVuota = new GridBagConstraints();
		gbc_btnInserisciRigaVuota.anchor = GridBagConstraints.WEST;
		gbc_btnInserisciRigaVuota.insets = new Insets(0, 0, 0, 5);
		gbc_btnInserisciRigaVuota.gridx = 0;
		gbc_btnInserisciRigaVuota.gridy = 1;
		add(btnInserisciBonus, gbc_btnInserisciRigaVuota);

		btnModificaBonus = new JButton("Modifica Bonus");
		btnModificaBonus.addActionListener(this);
		GridBagConstraints gbc_btnModificaBonus = new GridBagConstraints();
		gbc_btnModificaBonus.insets = new Insets(0, 0, 0, 5);
		gbc_btnModificaBonus.gridx = 1;
		gbc_btnModificaBonus.gridy = 1;
		add(btnModificaBonus, gbc_btnModificaBonus);

		btnCancellaRigaSelezionata = new JButton("Cancella Riga Selezionata");
		btnCancellaRigaSelezionata.addActionListener(this);
		GridBagConstraints gbc_btnCancellaRigaSelezionata = new GridBagConstraints();
		gbc_btnCancellaRigaSelezionata.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancellaRigaSelezionata.anchor = GridBagConstraints.WEST;
		gbc_btnCancellaRigaSelezionata.gridx = 2;
		gbc_btnCancellaRigaSelezionata.gridy = 1;
		add(btnCancellaRigaSelezionata, gbc_btnCancellaRigaSelezionata);

	}

	@SuppressWarnings("rawtypes")
	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {

		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;

		caricaDimensioniTableBonus(opzioniObj.getDimensioniTablePgBonus());

		// Aggiunta comboBox alla tabella
		TableColumn bonusColumn = tableBonus.getColumnModel().getColumn(0);
		JComboBox comboBoxArmi = bcb.creaComboBoxBonus();
		bonusColumn.setCellEditor(new DefaultCellEditor(comboBoxArmi));

		ArrayList<PgBonusObj> arrayPgBonus = new ArrayList<PgBonusObj>();
		arrayPgBonus = pgDatiObj.getArrayBonus();

		TableModel model = new DefaultTableModel();
		model = tableBonus.getModel();

		int rigaSelezionata = tableBonus.getSelectedRow();
		((DefaultTableModel) tableBonus.getModel()).setRowCount(0);

		for (int i = 0; i < arrayPgBonus.size(); i++) {
			PgBonusObj pgBonusObj = new PgBonusObj();
			pgBonusObj = arrayPgBonus.get(i);

			((DefaultTableModel) model).addRow(new Object[] { pgBonusObj.getBonus(), pgBonusObj.getModificatore(),
					pgBonusObj.getDescrizione(), pgBonusObj.isBonusAbilitato(), pgBonusObj.getPrg() });
		}
		if (tableBonus.getRowCount() > 0) {
			if (rigaSelezionata == -1) {

			} else {
				if (tableBonus.getRowCount() > rigaSelezionata) {
					tableBonus.setRowSelectionInterval(rigaSelezionata, rigaSelezionata);
				}
			}
		}

	}

	private ArrayList<PgBonusObj> creaArrayBonus() {
		ArrayList<PgBonusObj> arrayBonus = new ArrayList<PgBonusObj>();
		ArrayList<PgBonusObj> arrayBonusOriginale = new ArrayList<PgBonusObj>();

		// Recupero array bonus dal db
		PgDatiObj pgDatiObjDaDb = gestioneJsonPg.getPgByFileName(pgDatiObj.getFileName());

		arrayBonusOriginale = pgDatiObjDaDb.getArrayBonus();

		for (int i = 0; i < tableBonus.getRowCount(); i++) {
			// Pulizia campi della tabella che sono stati puliti
			if (tableBonus.getModel().getValueAt(i, 1) == null) {
				tableBonus.getModel().setValueAt(0, i, 1);
			}
			if (tableBonus.getModel().getValueAt(i, 4) == null) {
				tableBonus.getModel().setValueAt(0, i, 4);
			}

			// Recupero valorizzo oggetto pgClasseObj con i dati della JTable
			// Attenzione si usa getModel().getValueAt() per recuperare il
			// valore dal modello, visto che se una colonna è rimossa
			// dalla vista con il solo getValueAt() da un valore errato
			PgBonusObj pgBonusObj = new PgBonusObj();
			pgBonusObj.setBonus(tableBonus.getValueAt(i, 0).toString());
			pgBonusObj.setModificatore(Integer.parseInt(tableBonus.getModel().getValueAt(i, 1).toString()));
			pgBonusObj.setDescrizione(tableBonus.getValueAt(i, 2).toString());
			pgBonusObj.setBonusAbilitato((boolean) tableBonus.getValueAt(i, 3));
			pgBonusObj.setPrg(Integer.parseInt(tableBonus.getModel().getValueAt(i, 4).toString()));

			// Se trovo il progressivo della riga che stiamo leggendo nell'array
			// del db e i dati sono variati attiviamo il flag
			for (int i2 = 0; i2 < arrayBonusOriginale.size(); i2++) {
				PgBonusObj pgBonusObjOriginale = arrayBonusOriginale.get(i2);
				if (pgBonusObjOriginale.getPrg() == pgBonusObj.getPrg()) {
					if (pgBonusObj.getBonus().equals(pgBonusObjOriginale.getBonus())
							&& pgBonusObj.getModificatore() == pgBonusObjOriginale.getModificatore()
							&& pgBonusObj.getDescrizione().equals(pgBonusObjOriginale.getDescrizione())
							&& pgBonusObj.isBonusAbilitato() == pgBonusObjOriginale.isBonusAbilitato()) {

					} else {
						pgBonusObj.setDatiVariati(true);
					}
				}
			}
			arrayBonus.add(pgBonusObj);
		}

		return arrayBonus;
	}

	private void inserisciBonus() {

		ArrayList<PgBonusObj> arrayBonus = creaArrayBonus();
		PgBonusObj pgBonusObj = new PgBonusObj();
		if (arrayBonus.size() == 0) {
			pgBonusObj.setPrg(1);
		} else {
			int ultimoRecord = arrayBonus.size() - 1;
			pgBonusObj.setPrg(arrayBonus.get(ultimoRecord).getPrg() + 1);
		}

		GestionePgBonusObjDialog gestionePgBonusObjDialog = new GestionePgBonusObjDialog(ListaGestioneDati.INSERISCI,
				pgDatiObj.getId(), pgBonusObj);
		gestionePgBonusObjDialog.setVisible(true);
		if (gestionePgBonusObjDialog.isRigaGestita()) {
			pgBonusObj = gestionePgBonusObjDialog.getPgBonusObj();
			arrayBonus.add(pgBonusObj);
			pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_BONUS, arrayBonus);
		}
		frame.popolaFrame(pgDatiObj);

	}

	private void modificaBonus() {

		if (tableBonus.getSelectedRow() != -1) {

			ArrayList<PgBonusObj> arrayBonus = creaArrayBonus();

			GestionePgBonusObjDialog gestionePgBonusObjDialog = new GestionePgBonusObjDialog(ListaGestioneDati.MODIFICA,
					pgDatiObj.getId(), arrayBonus.get(tableBonus.getSelectedRow()));
			gestionePgBonusObjDialog.setVisible(true);
			if (gestionePgBonusObjDialog.isRigaGestita()) {
				PgBonusObj pgBonusObj = gestionePgBonusObjDialog.getPgBonusObj();
				for (int i = 0; i < arrayBonus.size(); i++) {
					if (arrayBonus.get(i).getPrg() == pgBonusObj.getPrg()) {
						arrayBonus.set(i, pgBonusObj);
					}
				}
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_BONUS, arrayBonus);
			}
			frame.popolaFrame(pgDatiObj);
		}

	}

	private void cancellaRigaTableBonus() {

		if (tableBonus.getSelectedRow() != -1) {
			((DefaultTableModel) tableBonus.getModel()).removeRow(tableBonus.getSelectedRow());

			if (tableBonus.getRowCount() > 0) {
				tableBonus.setRowSelectionInterval(0, 0);
			}
			ArrayList<PgBonusObj> arrayBonus = creaArrayBonus();
			pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_BONUS, arrayBonus);
			pgDatiObj.setDatiCommittati(false);
			frame.popolaFrame(pgDatiObj);

		}
	}

	private void caricaDimensioniTableBonus(ArrayList<Integer> arrayDimensioni) {
		if (arrayDimensioni.size() > 0 && tableBonus.getColumnCount() == arrayDimensioni.size()) {
			for (int i = 0; i < tableBonus.getColumnCount(); i++) {
				tableBonus.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			tableBonus.getColumnModel().getColumn(0).setPreferredWidth(300);
			tableBonus.getColumnModel().getColumn(1).setPreferredWidth(75);
			tableBonus.getColumnModel().getColumn(2).setPreferredWidth(300);
			tableBonus.getColumnModel().getColumn(3).setPreferredWidth(90);
		}
	}

	private void salvaDimensioniTableBonus() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableBonus.getColumnCount(); i++) {
			arrayDimensioni.add(tableBonus.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTablePgBonus(arrayDimensioni);
		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);
		frame.popolaFrame(pgDatiObj);
	}

	public MainWindow getFrame() {
		return frame;
	}

	public void setFrame(MainWindow frame) {
		this.frame = frame;
	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTable) {
			if ((JTable) component == tableBonus) {

				ArrayList<PgBonusObj> arrayBonus = creaArrayBonus();
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_BONUS, arrayBonus);
				frame.popolaFrame(pgDatiObj);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == btnInserisciBonus.getActionCommand()) {
				inserisciBonus();
			}
			if (((JButton) oggetto).getActionCommand() == btnCancellaRigaSelezionata.getActionCommand()) {
				cancellaRigaTableBonus();
			}
			if (((JButton) oggetto).getActionCommand() == btnModificaBonus.getActionCommand()) {
				modificaBonus();
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
			if ((JTable) component == tableBonus) {
				if (e.getClickCount() == 2 && tableBonus.getSelectedRow() != -1) {
					modificaBonus();
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTableHeader) {
			if ((JTableHeader) component == tableBonus.getTableHeader()) {
				salvaDimensioniTableBonus();
			}
		}

	}

}
