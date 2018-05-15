package gui.panel;

import javax.swing.JPanel;

import gui.MainWindow;
import gui.dialog.GestionePgLingueObjDialog;
import json.GestioneJsonOpzioni;
import json.GestioneJsonPg;
import obj.OpzioniObj;
import obj.PgDatiObj;
import obj.PgLingueObj;
import tableModels.PgLingueTableModel;

import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import Classi.AggiornaOggetti;
import ENUM.ListaGestioneDati;
import ENUM.ListaPgDati;
import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import java.awt.Insets;
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

public class PgLinguePanel extends JPanel implements FocusListener, ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainWindow frame;
	private JTable tableLingue;
	private PgDatiObj pgDatiObj = new PgDatiObj();
	GestioneJsonPg gestioneJsonPg = new GestioneJsonPg();
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	OpzioniObj opzioniObj = new OpzioniObj();

	private JButton btnInserisciLingua;
	private JButton btnCancellaRigaSelezionata;
	private AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	private JButton btnModificaLingua;

	/**
	 * Create the panel.
	 * 
	 * @param pgDatiObj
	 */
	public PgLinguePanel(PgDatiObj pgDatiObj) {

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

		tableLingue = new JTable();
		tableLingue.addMouseListener(this);
		tableLingue.setFillsViewportHeight(true);
		tableLingue.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableLingue.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableLingue.addFocusListener(this);
		PgLingueTableModel lingueTableModel = new PgLingueTableModel();
		tableLingue.setModel(lingueTableModel);
		scrollPane.setViewportView(tableLingue);
		TableColumnModel tcm = tableLingue.getColumnModel();
		tcm.removeColumn(tcm.getColumn(3));

		tableLingue.getTableHeader().addMouseListener(this);
		tableLingue.getTableHeader().setReorderingAllowed(false);

		btnInserisciLingua = new JButton("Inserisci Lingua");
		btnInserisciLingua.addActionListener(this);
		GridBagConstraints gbc_btnInserisciLingua = new GridBagConstraints();
		gbc_btnInserisciLingua.anchor = GridBagConstraints.WEST;
		gbc_btnInserisciLingua.insets = new Insets(0, 0, 0, 5);
		gbc_btnInserisciLingua.gridx = 0;
		gbc_btnInserisciLingua.gridy = 1;
		add(btnInserisciLingua, gbc_btnInserisciLingua);

		btnModificaLingua = new JButton("Modifica Lingua");
		btnModificaLingua.addActionListener(this);
		GridBagConstraints gbc_btnModificaLingua = new GridBagConstraints();
		gbc_btnModificaLingua.insets = new Insets(0, 0, 0, 5);
		gbc_btnModificaLingua.gridx = 1;
		gbc_btnModificaLingua.gridy = 1;
		add(btnModificaLingua, gbc_btnModificaLingua);

		btnCancellaRigaSelezionata = new JButton("Cancella Riga Selezionata");
		btnCancellaRigaSelezionata.addActionListener(this);
		GridBagConstraints gbc_btnCancellaRigaSelezionata = new GridBagConstraints();
		gbc_btnCancellaRigaSelezionata.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancellaRigaSelezionata.gridx = 2;
		gbc_btnCancellaRigaSelezionata.gridy = 1;
		add(btnCancellaRigaSelezionata, gbc_btnCancellaRigaSelezionata);


	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {

		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		caricaDimensioniTableLingue(opzioniObj.getDimensioniTablePgLingue());

		ArrayList<PgLingueObj> arrayPgLingue = pgDatiObj.getArrayLingue();

		TableModel model = new DefaultTableModel();
		model = tableLingue.getModel();

		int rigaSelezionata = tableLingue.getSelectedRow();
		((DefaultTableModel) tableLingue.getModel()).setRowCount(0);

		for (int i = 0; i < arrayPgLingue.size(); i++) {
			PgLingueObj pgLingueObj = arrayPgLingue.get(i);

			((DefaultTableModel) model).addRow(new Object[] { pgLingueObj.getPuntiAbilita(), pgLingueObj.getLinguaParlata(),
					pgLingueObj.getAlfabeto(), pgLingueObj.getPrg() });
		}
		if (tableLingue.getRowCount() > 0) {
			if (rigaSelezionata == -1) {

			} else {
				if (tableLingue.getRowCount() > rigaSelezionata) {
					tableLingue.setRowSelectionInterval(rigaSelezionata, rigaSelezionata);
				}
			}
		}

	}

	private ArrayList<PgLingueObj> creaArrayLingue() {
		ArrayList<PgLingueObj> arrayLingue = new ArrayList<PgLingueObj>();
		ArrayList<PgLingueObj> arrayLingueOriginale = new ArrayList<PgLingueObj>();

		// Recupero array bonus dal db
		PgDatiObj pgDatiObjDaDb = gestioneJsonPg.getPgByFileName(pgDatiObj.getFileName());

		arrayLingueOriginale = pgDatiObjDaDb.getArrayLingue();

		for (int i = 0; i < tableLingue.getRowCount(); i++) {
			// Pulizia campi della tabella che sono stati puliti
			if (tableLingue.getModel().getValueAt(i, 0) == null) {
				tableLingue.getModel().setValueAt(0, i, 0);
			}
			if (tableLingue.getModel().getValueAt(i, 3) == null) {
				tableLingue.getModel().setValueAt(0, i, 3);
			}

			// Recupero valorizzo oggetto pgClasseObj con i dati della JTable
			// Attenzione si usa getModel().getValueAt() per recuperare il
			// valore dal modello, visto che se una colonna è rimossa
			// dalla vista con il solo getValueAt() da un valore errato
			PgLingueObj pgLingueObj = new PgLingueObj();
			pgLingueObj.setPuntiAbilita(Integer.parseInt(tableLingue.getModel().getValueAt(i, 0).toString()));
			pgLingueObj.setLinguaParlata(tableLingue.getValueAt(i, 1).toString());
			pgLingueObj.setAlfabeto(tableLingue.getValueAt(i, 2).toString());
			pgLingueObj.setPrg(Integer.parseInt(tableLingue.getModel().getValueAt(i, 3).toString()));

			// Se trovo il progressivo della riga che stiamo leggendo nell'array
			// del db e i dati sono variati attiviamo il flag
			for (int i2 = 0; i2 < arrayLingueOriginale.size(); i2++) {
				PgLingueObj pgLingueObjOriginale = arrayLingueOriginale.get(i2);
				if (pgLingueObjOriginale.getPrg() == pgLingueObj.getPrg()) {
					if (pgLingueObj.getPuntiAbilita() == pgLingueObjOriginale.getPuntiAbilita()
							&& pgLingueObj.getLinguaParlata().equals(pgLingueObjOriginale.getLinguaParlata())
							&& pgLingueObj.getAlfabeto().equals(pgLingueObjOriginale.getAlfabeto())) {

					} else {
						pgLingueObj.setDatiVariati(true);
					}
				}
			}
			arrayLingue.add(pgLingueObj);
		}
		
		return arrayLingue;
	}

	private void inserisciLingua() {

		ArrayList<PgLingueObj> arrayLingue = creaArrayLingue();
		PgLingueObj pgLingueObj = new PgLingueObj();
		if (arrayLingue.size() == 0) {
			pgLingueObj.setPrg(1);
		} else {
			int ultimoRecord = arrayLingue.size() - 1;
			pgLingueObj.setPrg(arrayLingue.get(ultimoRecord).getPrg() + 1);
		}

		GestionePgLingueObjDialog gestionePgLingueObjDialog = new GestionePgLingueObjDialog(ListaGestioneDati.INSERISCI,
				pgDatiObj.getId(), pgLingueObj);
		gestionePgLingueObjDialog.setVisible(true);
		if (gestionePgLingueObjDialog.isRigaGestita()) {
			pgLingueObj = gestionePgLingueObjDialog.getPgLingueObj();
			arrayLingue.add(pgLingueObj);
			pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_LINGUE, arrayLingue);
		}
		frame.popolaFrame(pgDatiObj);

	}

	private void modificaLingue() {

		if (tableLingue.getSelectedRow() != -1) {

			ArrayList<PgLingueObj> arrayLingue = creaArrayLingue();

			GestionePgLingueObjDialog gestionePgLingueObjDialog = new GestionePgLingueObjDialog(ListaGestioneDati.MODIFICA,
					pgDatiObj.getId(), arrayLingue.get(tableLingue.getSelectedRow()));
			gestionePgLingueObjDialog.setVisible(true);
			if (gestionePgLingueObjDialog.isRigaGestita()) {
				PgLingueObj pgLingueObj = gestionePgLingueObjDialog.getPgLingueObj();
				for (int i = 0; i < arrayLingue.size(); i++) {
					if (arrayLingue.get(i).getPrg() == pgLingueObj.getPrg()) {
						arrayLingue.set(i, pgLingueObj);
					}
				}
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_LINGUE, arrayLingue);
			}
			frame.popolaFrame(pgDatiObj);
		}

	}

	private void cancellaRiga() {

		if (tableLingue.getSelectedRow() != -1) {
			((DefaultTableModel) tableLingue.getModel()).removeRow(tableLingue.getSelectedRow());

			if (tableLingue.getRowCount() > 0) {
				tableLingue.setRowSelectionInterval(0, 0);
			}
			ArrayList<PgLingueObj> arrayLingue = creaArrayLingue();
			pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_LINGUE, arrayLingue);
			pgDatiObj.setDatiCommittati(false);
			frame.popolaFrame(pgDatiObj);

		}
	}

	private void caricaDimensioniTableLingue(ArrayList<Integer> arrayDimensioni) {
		if (arrayDimensioni.size() > 0 && tableLingue.getColumnCount() == arrayDimensioni.size()) {
			for (int i = 0; i < tableLingue.getColumnCount(); i++) {
				tableLingue.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			tableLingue.getColumnModel().getColumn(0).setPreferredWidth(70);
			tableLingue.getColumnModel().getColumn(1).setPreferredWidth(170);
			tableLingue.getColumnModel().getColumn(2).setPreferredWidth(190);
		}
	}

	private void salvaDimensioniTableLingue() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableLingue.getColumnCount(); i++) {
			arrayDimensioni.add(tableLingue.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTablePgLingue(arrayDimensioni);
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
			if ((JTable) component == tableLingue) {

				ArrayList<PgLingueObj> arrayLingue = creaArrayLingue();
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_LINGUE, arrayLingue);
				frame.popolaFrame(pgDatiObj);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == btnInserisciLingua.getActionCommand()) {
				inserisciLingua();
			}
			if (((JButton) oggetto).getActionCommand() == btnCancellaRigaSelezionata.getActionCommand()) {
				cancellaRiga();
			}
			if (((JButton) oggetto).getActionCommand() == btnModificaLingua.getActionCommand()) {
				modificaLingue();
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
			if ((JTable) component == tableLingue) {
				if (e.getClickCount() == 2 && tableLingue.getSelectedRow() != -1) {
					modificaLingue();
				}
			}
		}		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTableHeader) {
			if ((JTableHeader) component == tableLingue.getTableHeader()) {
				salvaDimensioniTableLingue();
			}
		}
		
	}

}
