package gui.panel;

import javax.swing.JPanel;

import gui.MainWindow;
import gui.dialog.GestionePgTalentiObjDialog;
import json.GestioneJsonOpzioni;
import json.GestioneJsonPg;
import obj.OpzioniObj;
import obj.PgDatiObj;
import obj.PgTalentiObj;
import tableModels.PgTalentiTableModel;

import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import Classi.AggiornaOggetti;
import ENUM.ListaGestioneDati;
import ENUM.ListaPgDati;
import comboBox.PgBonusComboBox;
import cellRenderer.TextAreaRenderer;

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

public class PgTalentiPanel extends JPanel implements FocusListener, ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainWindow frame;
	private JTable tableTalenti;
	private PgDatiObj pgDatiObj = new PgDatiObj();
	GestioneJsonPg gestioneJsonPg = new GestioneJsonPg();
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	OpzioniObj opzioniObj = new OpzioniObj();
	PgBonusComboBox bcb = new PgBonusComboBox();

	private JButton btnInserisciTalento;
	private JButton btnCancellaRigaSelezionata;
	private AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	private JButton btnModificaTalento;

	/**
	 * Create the panel.
	 * 
	 * @param pgDatiObj
	 */
	public PgTalentiPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.pgDatiObj = pgDatiObj;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 382, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);

		tableTalenti = new JTable();
		tableTalenti.addMouseListener(this);
		tableTalenti.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableTalenti.setFillsViewportHeight(true);
		tableTalenti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableTalenti.addFocusListener(this);
		PgTalentiTableModel talentiTableModel = new PgTalentiTableModel();
		tableTalenti.setModel(talentiTableModel);
		tableTalenti.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());

		scrollPane.setViewportView(tableTalenti);
		TableColumnModel tcm = tableTalenti.getColumnModel();
		tcm.removeColumn(tcm.getColumn(2));

		tableTalenti.getTableHeader().addMouseListener(this);
		tableTalenti.getTableHeader().setReorderingAllowed(false);

		btnInserisciTalento = new JButton("Inserisci Talento");
		btnInserisciTalento.addActionListener(this);
		GridBagConstraints gbc_btnInserisciTalento = new GridBagConstraints();
		gbc_btnInserisciTalento.anchor = GridBagConstraints.WEST;
		gbc_btnInserisciTalento.insets = new Insets(0, 0, 0, 5);
		gbc_btnInserisciTalento.gridx = 0;
		gbc_btnInserisciTalento.gridy = 1;
		add(btnInserisciTalento, gbc_btnInserisciTalento);

		btnModificaTalento = new JButton("Modifica Talento");
		btnModificaTalento.addActionListener(this);
		GridBagConstraints gbc_btnModificaTalento = new GridBagConstraints();
		gbc_btnModificaTalento.insets = new Insets(0, 0, 0, 5);
		gbc_btnModificaTalento.gridx = 1;
		gbc_btnModificaTalento.gridy = 1;
		add(btnModificaTalento, gbc_btnModificaTalento);

		btnCancellaRigaSelezionata = new JButton("Cancella Riga Selezionata");
		btnCancellaRigaSelezionata.addActionListener(this);
		GridBagConstraints gbc_btnCancellaRigaSelezionata = new GridBagConstraints();
		gbc_btnCancellaRigaSelezionata.anchor = GridBagConstraints.WEST;
		gbc_btnCancellaRigaSelezionata.gridx = 2;
		gbc_btnCancellaRigaSelezionata.gridy = 1;
		add(btnCancellaRigaSelezionata, gbc_btnCancellaRigaSelezionata);


	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {

		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		caricaDimensioniTableTalenti(opzioniObj.getDimensioniTablePgTalenti());

		// TODO Popolamento scheda "Talenti"
		ArrayList<PgTalentiObj> arrayPgTalenti = new ArrayList<PgTalentiObj>();
		arrayPgTalenti = pgDatiObj.getArrayTalenti();

		TableModel model = new DefaultTableModel();
		model = tableTalenti.getModel();

		int rigaSelezionata = tableTalenti.getSelectedRow();
		((DefaultTableModel) tableTalenti.getModel()).setRowCount(0);

		for (int i = 0; i < arrayPgTalenti.size(); i++) {
			PgTalentiObj pgTalentiObj = arrayPgTalenti.get(i);
			((DefaultTableModel) model).addRow(
					new Object[] { pgTalentiObj.getNome(), pgTalentiObj.getDescrizione(), pgTalentiObj.getPrg() });
		}
		if (tableTalenti.getRowCount() > 0) {
			if (rigaSelezionata == -1) {

			} else {
				if (tableTalenti.getRowCount() > rigaSelezionata) {
					tableTalenti.setRowSelectionInterval(rigaSelezionata, rigaSelezionata);
				}
			}
		}

		// Calcolo altezza riga sulla base del contenuto della descrizione
		for (int i=0; i < tableTalenti.getRowCount(); i++){
			JTextArea jTextArea = new JTextArea();
			jTextArea.setText(tableTalenti.getModel().getValueAt(i, 1).toString());
			//L'altezza base della riga è 16 (almeno da quanto testato). Moltiplichiamo per il numero righe
			int rowHeight = 16 * jTextArea.getLineCount();
			tableTalenti.setRowHeight(i, rowHeight);

		}


	}

	private ArrayList<PgTalentiObj> creaArrayTalenti() {
		ArrayList<PgTalentiObj> arrayTalenti = new ArrayList<PgTalentiObj>();
		ArrayList<PgTalentiObj> arrayTalentiOriginale = new ArrayList<PgTalentiObj>();

		// Recupero array bonus dal db
		PgDatiObj pgDatiObjTemp = gestioneJsonPg.getPgByFileName(pgDatiObj.getFileName());

		arrayTalentiOriginale = pgDatiObjTemp.getArrayTalenti();
		for (int i = 0; i < tableTalenti.getRowCount(); i++) {
			// Pulizia campi della tabella che sono stati puliti
			if (tableTalenti.getModel().getValueAt(i, 2) == null) {
				tableTalenti.getModel().setValueAt(0, i, 2);
			}

			// Recupero valorizzo oggetto pgTalentiObj con i dati della JTable
			// Attenzione si usa getModel().getValueAt() per recuperare il
			// valore dal modello, visto che se una colonna è rimossa
			// dalla vista con il solo getValueAt() da un valore errato
			PgTalentiObj pgTalentiObj = new PgTalentiObj();
			pgTalentiObj.setNome(tableTalenti.getValueAt(i, 0).toString());
			pgTalentiObj.setDescrizione(tableTalenti.getValueAt(i, 1).toString());
			pgTalentiObj.setPrg(Integer.parseInt(tableTalenti.getModel().getValueAt(i, 2).toString()));

			// Se trovo il progressivo della riga che stiamo leggendo nell'array
			// del db e i dati sono variati attiviamo il flag
			for (int i2 = 0; i2 < arrayTalentiOriginale.size(); i2++) {
				PgTalentiObj pgTalentiObjOriginale = arrayTalentiOriginale.get(i2);
				if (pgTalentiObjOriginale.getPrg() == pgTalentiObj.getPrg()) {
					if (pgTalentiObj.getNome().equals(pgTalentiObjOriginale.getNome())
							&& pgTalentiObj.getDescrizione().equals(pgTalentiObjOriginale.getDescrizione())) {

					} else {
						pgTalentiObj.setDatiVariati(true);
					}
				}
			}
			arrayTalenti.add(pgTalentiObj);
		}
		return arrayTalenti;
	}

	private void inserisciTalento() {

		ArrayList<PgTalentiObj> arrayTalenti = creaArrayTalenti();
		PgTalentiObj pgTalentiObj = new PgTalentiObj();
		if (arrayTalenti.size() == 0) {
			pgTalentiObj.setPrg(1);
		} else {
			int ultimoRecord = arrayTalenti.size() - 1;
			pgTalentiObj.setPrg(arrayTalenti.get(ultimoRecord).getPrg() + 1);
		}

		GestionePgTalentiObjDialog gestionePgTalentiObjDialog = new GestionePgTalentiObjDialog(ListaGestioneDati.INSERISCI,
				pgDatiObj.getId(), pgTalentiObj);
		gestionePgTalentiObjDialog.setVisible(true);
		if (gestionePgTalentiObjDialog.isRigaGestita()) {
			pgTalentiObj = gestionePgTalentiObjDialog.getPgTalentiObj();
			arrayTalenti.add(pgTalentiObj);
			pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_TALENTI, arrayTalenti);
		}
		frame.popolaFrame(pgDatiObj);
	}

	private void modificaTalento() {
				
		if (tableTalenti.getSelectedRow() != -1) {

			ArrayList<PgTalentiObj> arrayTalenti = creaArrayTalenti();

			GestionePgTalentiObjDialog gestionePgTalentiObjDialog = new GestionePgTalentiObjDialog(ListaGestioneDati.MODIFICA,
					pgDatiObj.getId(), arrayTalenti.get(tableTalenti.getSelectedRow()));
			gestionePgTalentiObjDialog.setVisible(true);
			if (gestionePgTalentiObjDialog.isRigaGestita()) {
				PgTalentiObj pgTalentiObj = gestionePgTalentiObjDialog.getPgTalentiObj();
				for (int i = 0; i < arrayTalenti.size(); i++) {
					if (arrayTalenti.get(i).getPrg() == pgTalentiObj.getPrg()) {
						arrayTalenti.set(i, pgTalentiObj);
					}
				}
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_TALENTI, arrayTalenti);
			}
			frame.popolaFrame(pgDatiObj);
		}

	}

	private void cancellaRigaTableTalenti() {
		
		if (tableTalenti.getSelectedRow() != -1) {
			((DefaultTableModel) tableTalenti.getModel()).removeRow(tableTalenti.getSelectedRow());

			if (tableTalenti.getRowCount() > 0) {
				tableTalenti.setRowSelectionInterval(0, 0);
			}
			ArrayList<PgTalentiObj> arrayTalenti = creaArrayTalenti();
			pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_TALENTI, arrayTalenti);
			pgDatiObj.setDatiCommittati(false);
			frame.popolaFrame(pgDatiObj);

		}
	}

	private void caricaDimensioniTableTalenti(ArrayList<Integer> arrayDimensioni) {
		if (arrayDimensioni.size() > 0 && tableTalenti.getColumnCount() == arrayDimensioni.size()) {
			for (int i = 0; i < tableTalenti.getColumnCount(); i++) {
				tableTalenti.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			tableTalenti.getColumnModel().getColumn(0).setPreferredWidth(200);
			tableTalenti.getColumnModel().getColumn(1).setPreferredWidth(800);

		}
	}

	private void salvaDimensioniTableTalenti() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableTalenti.getColumnCount(); i++) {
			arrayDimensioni.add(tableTalenti.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTablePgTalenti(arrayDimensioni);
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


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == btnInserisciTalento.getActionCommand()) {
				inserisciTalento();
			}
			if (((JButton) oggetto).getActionCommand() == btnCancellaRigaSelezionata.getActionCommand()) {
				cancellaRigaTableTalenti();
			}
			if (((JButton) oggetto).getActionCommand() == btnModificaTalento.getActionCommand()) {
				modificaTalento();
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
			if ((JTable) component == tableTalenti) {
				if (e.getClickCount() == 2 && tableTalenti.getSelectedRow() != -1) {
					modificaTalento();
				}
			}
		}		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTableHeader) {
			if ((JTableHeader) component == tableTalenti.getTableHeader()) {
				salvaDimensioniTableTalenti();
			}
		}		
	}

}
