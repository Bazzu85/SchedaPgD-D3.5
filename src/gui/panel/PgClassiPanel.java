package gui.panel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.NumberFormatter;

import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaGestioneDati;
import ENUM.ListaPgDati;
import gui.MainWindow;
import gui.dialog.GestionePgClasseObjDialog;
import json.GestioneJsonOpzioni;
import json.GestioneJsonPg;
import obj.OpzioniObj;
import obj.PgClasseObj;
import obj.PgDatiObj;
import tableModels.PgClassiTableModel;
import java.awt.event.MouseAdapter;

public class PgClassiPanel extends JPanel implements FocusListener, ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1164262380983882766L;
	private JTable tableClassi;
	private JFormattedTextField formattedTextFieldLvlTotPg;
	private JFormattedTextField formattedTextFieldPx;
	private JFormattedTextField formattedTextFieldPxLvlSucc;
	private JFormattedTextField formattedTextFieldPxPenalita;
	private JPanel panel_1;
	private JButton btnInserisciClasse;
	private JButton btnCancellaRigaSelezionata;

	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	Formati formati = new Formati();
	GestioneJsonPg gestioneJsonPg = new GestioneJsonPg();
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	OpzioniObj opzioniObj = new OpzioniObj();
	private PgDatiObj pgDatiObj;
	private MainWindow frame;
	private JButton btnModificaClasse;

	/**
	 * Create the panel.
	 * 
	 * @param pgDatiObj
	 */
	public PgClassiPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.pgDatiObj = pgDatiObj;

		NumberFormatter soloNumeri = formati.getSoloNumeri();

		GridBagLayout gbl_panelClassiPx = new GridBagLayout();
		gbl_panelClassiPx.columnWidths = new int[] { 71, 82, 108, 112 };
		gbl_panelClassiPx.rowHeights = new int[] { 196, 0, 0, 0, 0 };
		gbl_panelClassiPx.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0 };
		gbl_panelClassiPx.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0 };
		this.setLayout(gbl_panelClassiPx);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		this.add(scrollPane, gbc_scrollPane);

		tableClassi = new JTable();
		tableClassi.addMouseListener(this);
		tableClassi.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableClassi.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableClassi.addFocusListener(this);
		tableClassi.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableClassi);
		PgClassiTableModel classiTableModel = new PgClassiTableModel();
		tableClassi.setModel(classiTableModel);
		TableColumnModel tcm = tableClassi.getColumnModel();
		tcm.removeColumn(tcm.getColumn(6));
		tableClassi.getTableHeader().setReorderingAllowed(false);
		tableClassi.getTableHeader().addMouseListener(this);

		btnInserisciClasse = new JButton("Inserisci Classe");
		btnInserisciClasse.addActionListener(this);
		GridBagConstraints gbc_btnInserisciRigaVuota = new GridBagConstraints();
		gbc_btnInserisciRigaVuota.anchor = GridBagConstraints.WEST;
		gbc_btnInserisciRigaVuota.insets = new Insets(0, 0, 5, 5);
		gbc_btnInserisciRigaVuota.gridx = 0;
		gbc_btnInserisciRigaVuota.gridy = 1;
		this.add(btnInserisciClasse, gbc_btnInserisciRigaVuota);

		btnModificaClasse = new JButton("Modifica Classe");
		btnModificaClasse.addActionListener(this);
		GridBagConstraints gbc_btnModificaClasse = new GridBagConstraints();
		gbc_btnModificaClasse.anchor = GridBagConstraints.WEST;
		gbc_btnModificaClasse.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificaClasse.gridx = 1;
		gbc_btnModificaClasse.gridy = 1;
		add(btnModificaClasse, gbc_btnModificaClasse);

		btnCancellaRigaSelezionata = new JButton("Cancella riga Selezionata");
		btnCancellaRigaSelezionata.addActionListener(this);
		GridBagConstraints gbc_btnCancellaRigaSelezionata = new GridBagConstraints();
		gbc_btnCancellaRigaSelezionata.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancellaRigaSelezionata.gridx = 2;
		gbc_btnCancellaRigaSelezionata.gridy = 1;
		this.add(btnCancellaRigaSelezionata, gbc_btnCancellaRigaSelezionata);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		this.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblLivelloTotalePg = new JLabel("Livello Totale Pg:");
		GridBagConstraints gbc_lblLivelloTotalePg = new GridBagConstraints();
		gbc_lblLivelloTotalePg.anchor = GridBagConstraints.EAST;
		gbc_lblLivelloTotalePg.insets = new Insets(0, 0, 5, 5);
		gbc_lblLivelloTotalePg.gridx = 0;
		gbc_lblLivelloTotalePg.gridy = 0;
		panel_1.add(lblLivelloTotalePg, gbc_lblLivelloTotalePg);

		formattedTextFieldLvlTotPg = new JFormattedTextField(soloNumeri);
		GridBagConstraints gbc_formattedTextFieldLvlTotPg = new GridBagConstraints();
		gbc_formattedTextFieldLvlTotPg.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldLvlTotPg.gridx = 1;
		gbc_formattedTextFieldLvlTotPg.gridy = 0;
		panel_1.add(formattedTextFieldLvlTotPg, gbc_formattedTextFieldLvlTotPg);
		formattedTextFieldLvlTotPg.setEditable(false);
		formattedTextFieldLvlTotPg.setColumns(10);

		JLabel lblPuntiEsperienza = new JLabel("Punti Esperienza:");
		GridBagConstraints gbc_lblPuntiEsperienza = new GridBagConstraints();
		gbc_lblPuntiEsperienza.anchor = GridBagConstraints.EAST;
		gbc_lblPuntiEsperienza.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntiEsperienza.gridx = 0;
		gbc_lblPuntiEsperienza.gridy = 1;
		panel_1.add(lblPuntiEsperienza, gbc_lblPuntiEsperienza);

		formattedTextFieldPx = new JFormattedTextField(soloNumeri);
		GridBagConstraints gbc_formattedTextFieldPx = new GridBagConstraints();
		gbc_formattedTextFieldPx.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldPx.gridx = 1;
		gbc_formattedTextFieldPx.gridy = 1;
		panel_1.add(formattedTextFieldPx, gbc_formattedTextFieldPx);
		formattedTextFieldPx.addFocusListener(this);
		formattedTextFieldPx.setColumns(10);

		JLabel lblPuntiEsperienza_1 = new JLabel("Punti Esperienza per livello successivo:");
		GridBagConstraints gbc_lblPuntiEsperienza_1 = new GridBagConstraints();
		gbc_lblPuntiEsperienza_1.anchor = GridBagConstraints.EAST;
		gbc_lblPuntiEsperienza_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntiEsperienza_1.gridx = 0;
		gbc_lblPuntiEsperienza_1.gridy = 2;
		panel_1.add(lblPuntiEsperienza_1, gbc_lblPuntiEsperienza_1);

		formattedTextFieldPxLvlSucc = new JFormattedTextField(soloNumeri);
		GridBagConstraints gbc_formattedTextFieldPxLvlSucc = new GridBagConstraints();
		gbc_formattedTextFieldPxLvlSucc.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldPxLvlSucc.gridx = 1;
		gbc_formattedTextFieldPxLvlSucc.gridy = 2;
		panel_1.add(formattedTextFieldPxLvlSucc, gbc_formattedTextFieldPxLvlSucc);
		formattedTextFieldPxLvlSucc.setEditable(false);
		formattedTextFieldPxLvlSucc.setColumns(10);

		JLabel lblPenalitAiPunti = new JLabel("Penalit\u00E0 ai Punti Esperienza:");
		GridBagConstraints gbc_lblPenalitAiPunti = new GridBagConstraints();
		gbc_lblPenalitAiPunti.anchor = GridBagConstraints.EAST;
		gbc_lblPenalitAiPunti.insets = new Insets(0, 0, 0, 5);
		gbc_lblPenalitAiPunti.gridx = 0;
		gbc_lblPenalitAiPunti.gridy = 3;
		panel_1.add(lblPenalitAiPunti, gbc_lblPenalitAiPunti);

		formattedTextFieldPxPenalita = new JFormattedTextField(soloNumeri);
		GridBagConstraints gbc_formattedTextFieldPxPenalita = new GridBagConstraints();
		gbc_formattedTextFieldPxPenalita.gridx = 1;
		gbc_formattedTextFieldPxPenalita.gridy = 3;
		panel_1.add(formattedTextFieldPxPenalita, gbc_formattedTextFieldPxPenalita);
		formattedTextFieldPxPenalita.addFocusListener(this);
		formattedTextFieldPxPenalita.setColumns(10);


	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {

		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		caricaDimensioniTableClassi(opzioniObj.getDimensioniTablePgClassi());

		// TODO Popolamento scheda "Classi e Px"
		ArrayList<PgClasseObj> arrayPgClassi = new ArrayList<PgClasseObj>();
		arrayPgClassi = pgDatiObj.getArrayClassi();

		TableModel model = new DefaultTableModel();
		model = tableClassi.getModel();
		int rigaSelezionata = tableClassi.getSelectedRow();

		((DefaultTableModel) tableClassi.getModel()).setRowCount(0);

		for (int i = 0; i < arrayPgClassi.size(); i++) {
			PgClasseObj pgClasseObj = new PgClasseObj();
			pgClasseObj = arrayPgClassi.get(i);
			((DefaultTableModel) model).addRow(new Object[] { pgClasseObj.getClasse(), pgClasseObj.getLivello(),
					pgClasseObj.getDadoVita(), pgClasseObj.getPuntiFerita(), pgClasseObj.isClasseDiPrestigio(),
					pgClasseObj.getBabClasse(), pgClasseObj.getPrg() });
		}
		if (tableClassi.getRowCount() > 0) {
			if (rigaSelezionata == -1) {

			} else {
				if (tableClassi.getRowCount() > rigaSelezionata) {
					tableClassi.setRowSelectionInterval(rigaSelezionata, rigaSelezionata);
				}
			}
		}

		formattedTextFieldLvlTotPg.setText(String.valueOf(pgDatiObj.getLvlTotPg()));
		formattedTextFieldPx.setValue(pgDatiObj.getPx());
		formattedTextFieldPxLvlSucc.setText(String.valueOf(pgDatiObj.getPxLvlSucc()));
		formattedTextFieldPxPenalita.setValue(pgDatiObj.getPxPenalita());

	}

	protected ArrayList<PgClasseObj> creaArrayClassi() {
		ArrayList<PgClasseObj> arrayClassi = new ArrayList<PgClasseObj>();
		ArrayList<PgClasseObj> arrayClassiOriginale = new ArrayList<PgClasseObj>();

		// Recupero array classi dal db
		PgDatiObj pgDatiObjDaDb = gestioneJsonPg.getPgByFileName(pgDatiObj.getFileName());
		arrayClassiOriginale = pgDatiObjDaDb.getArrayClassi();
		for (int i = 0; i < tableClassi.getRowCount(); i++) {
			// Pulizia campi della tabella che sono stati puliti
			if (tableClassi.getModel().getValueAt(i, 1) == null) {
				tableClassi.getModel().setValueAt(0, i, 1);
			}
			if (tableClassi.getModel().getValueAt(i, 3) == null) {
				tableClassi.getModel().setValueAt(0, i, 3);
			}
			if (tableClassi.getModel().getValueAt(i, 5) == null) {
				tableClassi.getModel().setValueAt(0, i, 5);
			}
			if (tableClassi.getModel().getValueAt(i, 6) == null) {
				tableClassi.getModel().setValueAt(0, i, 6);
			}

			// Recupero valorizzo oggetto pgClasseObj con i dati della JTable
			// Attenzione si usa getModel().getValueAt() per recuperare il
			// valore dal modello, visto che se una colonna è rimossa
			// dalla vista con il solo getValueAt() da un valore errato
			PgClasseObj pgClasseObj = new PgClasseObj();
			pgClasseObj.setClasse(tableClassi.getModel().getValueAt(i, 0).toString());
			pgClasseObj.setLivello(Integer.parseInt(tableClassi.getModel().getValueAt(i, 1).toString()));
			pgClasseObj.setDadoVita(tableClassi.getModel().getValueAt(i, 2).toString());
			pgClasseObj.setPuntiFerita(Integer.parseInt(tableClassi.getModel().getValueAt(i, 3).toString()));
			pgClasseObj.setClasseDiPrestigio((boolean) tableClassi.getValueAt(i, 4));
			pgClasseObj.setBabClasse(Integer.parseInt(tableClassi.getModel().getValueAt(i, 5).toString()));
			pgClasseObj.setPrg(Integer.parseInt(tableClassi.getModel().getValueAt(i, 6).toString()));

			// Se trovo il progressivo della riga che stiamo leggendo nell'array
			// del db e i dati sono variati attiviamo il flag
			for (int i2 = 0; i2 < arrayClassiOriginale.size(); i2++) {
				PgClasseObj pgClasseObjOriginale = new PgClasseObj();
				pgClasseObjOriginale = arrayClassiOriginale.get(i2);
				if (pgClasseObjOriginale.getPrg() == pgClasseObj.getPrg()) {

					if (pgClasseObj.getClasse().equals(pgClasseObjOriginale.getClasse())
							&& pgClasseObj.getLivello() == pgClasseObjOriginale.getLivello()
							&& pgClasseObj.getDadoVita().equals(pgClasseObjOriginale.getDadoVita())
							&& pgClasseObj.getPuntiFerita() == pgClasseObjOriginale.getPuntiFerita()
							&& pgClasseObj.isClasseDiPrestigio() == pgClasseObjOriginale.isClasseDiPrestigio()
							&& pgClasseObj.getBabClasse() == pgClasseObjOriginale.getBabClasse()) {

					} else {
						pgClasseObj.setDatiVariati(true);
					}
				}
			}
			arrayClassi.add(pgClasseObj);
		}
		return arrayClassi;

	}

	private void inserisciClasse() {

		ArrayList<PgClasseObj> arrayClassi = creaArrayClassi();
		if (arrayClassi.size() >= 6) {
			JOptionPane.showMessageDialog(this, "Impossibile inserire più di 6 classi", "Errore",
					JOptionPane.ERROR_MESSAGE);
		} else {
			PgClasseObj pgClasseObj = new PgClasseObj();
			if (arrayClassi.size() == 0) {
				pgClasseObj.setPrg(1);
			} else {
				int ultimoRecord = arrayClassi.size() - 1;
				pgClasseObj.setPrg(arrayClassi.get(ultimoRecord).getPrg() + 1);
			}

			GestionePgClasseObjDialog gestionePgClasseObjDialog = new GestionePgClasseObjDialog(
					ListaGestioneDati.INSERISCI, pgDatiObj.getId(), pgClasseObj);
			gestionePgClasseObjDialog.setVisible(true);
			if (gestionePgClasseObjDialog.isRigaGestita()) {
				pgClasseObj = gestionePgClasseObjDialog.getPgClasseObj();
				arrayClassi.add(pgClasseObj);
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_CLASSI, arrayClassi);
			}

			frame.popolaFrame(pgDatiObj);
		}

	}

	private void modificaClasse() {
		if (tableClassi.getSelectedRow() != -1) {

			ArrayList<PgClasseObj> arrayClassi = creaArrayClassi();

			GestionePgClasseObjDialog gestionePgClasseObjDialog = new GestionePgClasseObjDialog(
					ListaGestioneDati.MODIFICA, pgDatiObj.getId(), arrayClassi.get(tableClassi.getSelectedRow()));
			gestionePgClasseObjDialog.setVisible(true);
			if (gestionePgClasseObjDialog.isRigaGestita()) {
				PgClasseObj pgClasseObj = gestionePgClasseObjDialog.getPgClasseObj();
				for (int i = 0; i < arrayClassi.size(); i++) {
					if (arrayClassi.get(i).getPrg() == pgClasseObj.getPrg()) {
						arrayClassi.set(i, pgClasseObj);
					}
				}
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_CLASSI, arrayClassi);
			}
			frame.popolaFrame(pgDatiObj);
		}

	}

	private void cancellaRigaTableClassi() {

		if (tableClassi.getSelectedRow() != -1) {
			((DefaultTableModel) tableClassi.getModel()).removeRow(tableClassi.getSelectedRow());

			if (tableClassi.getRowCount() > 0) {
				tableClassi.setRowSelectionInterval(0, 0);
			}
			ArrayList<PgClasseObj> arrayClassi = creaArrayClassi();
			pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_CLASSI, arrayClassi);
			pgDatiObj.setDatiCommittati(false);
			frame.popolaFrame(pgDatiObj);

		}
	}

	private void caricaDimensioniTableClassi(ArrayList<Integer> arrayDimensioni) {
		if (arrayDimensioni.size() > 0 && tableClassi.getColumnCount() == arrayDimensioni.size()) {
			for (int i = 0; i < tableClassi.getColumnCount(); i++) {
				tableClassi.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			tableClassi.getColumnModel().getColumn(0).setPreferredWidth(280);
			tableClassi.getColumnModel().getColumn(1).setPreferredWidth(75);
			tableClassi.getColumnModel().getColumn(2).setPreferredWidth(75);
			tableClassi.getColumnModel().getColumn(3).setPreferredWidth(75);
			tableClassi.getColumnModel().getColumn(4).setPreferredWidth(100);
			tableClassi.getColumnModel().getColumn(5).setPreferredWidth(120);

		}
	}

	private void salvaDimensioniTableClassi() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableClassi.getColumnCount(); i++) {
			arrayDimensioni.add(tableClassi.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTablePgClassi(arrayDimensioni);
		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);
		frame.popolaFrame(pgDatiObj);

	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {

		Component component = e.getComponent();

		if (component instanceof JTable) {
			if ((JTable) component == tableClassi) {
				ArrayList<PgClasseObj> arrayClassi = new ArrayList<PgClasseObj>();
				arrayClassi = creaArrayClassi();
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_CLASSI, arrayClassi);
				frame.popolaFrame(pgDatiObj);
			}
		}
		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldPx) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.PX,
						formattedTextFieldPx.getText());
			}
			if ((JFormattedTextField) component == formattedTextFieldPxPenalita) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.PX_PENALITA,
						formattedTextFieldPxPenalita.getText());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == btnInserisciClasse.getActionCommand()) {
				inserisciClasse();
			}
			if (((JButton) oggetto).getActionCommand() == btnCancellaRigaSelezionata.getActionCommand()) {
				cancellaRigaTableClassi();
			}
			if (((JButton) oggetto).getActionCommand() == btnModificaClasse.getActionCommand()) {
				modificaClasse();
			}

		}
	}

	public MainWindow getFrame() {
		return frame;
	}

	public void setFrame(MainWindow frame) {
		this.frame = frame;
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
			if ((JTable) component == tableClassi) {
				if (e.getClickCount() == 2 && tableClassi.getSelectedRow() != -1) {
					modificaClasse();
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTableHeader) {
			if ((JTableHeader) component == tableClassi.getTableHeader()) {
				salvaDimensioniTableClassi();
			}
		}
	}

}
