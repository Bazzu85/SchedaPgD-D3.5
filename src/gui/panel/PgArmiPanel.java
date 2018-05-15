package gui.panel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import Classi.AggiornaOggetti;
import ENUM.ListaGestioneDati;
import ENUM.ListaPgDati;
import formatRenderer.DecimalWithSignFormatRenderer;
import gui.MainWindow;
import gui.dialog.GestionePgArmiObjDialog;
import json.GestioneJsonItems;
import json.GestioneJsonOpzioni;
import json.GestioneJsonPg;
import obj.DbArmiObj;
import obj.OpzioniObj;
import obj.PgArmiObj;
import obj.PgArmiRiepilogoObj;
import obj.PgDatiObj;
import tableModels.PgArmiRiepilogoTableModel;
import tableModels.PgArmiTableModel;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

public class PgArmiPanel extends JPanel implements ActionListener, FocusListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5221576706307921986L;
	GestioneJsonPg gestioneJsonPg = new GestioneJsonPg();
	GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	OpzioniObj opzioniObj = new OpzioniObj();
	private AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	private JTable tableArmi;
	private PgDatiObj pgDatiObj;
	private MainWindow frame;
	private JTable tableArmiRiepilogo;
	private JButton btnInserisciArma;
	private JButton btnCancellaRigaSelezionata;
	private JButton btnModificaArma;

	/**
	 * Create the panel.
	 * 
	 * @param pgDatiObj
	 */
	public PgArmiPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.pgDatiObj = pgDatiObj;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 113, 121, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 183, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblArmi = new JLabel("Armi");
		lblArmi.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblArmi = new GridBagConstraints();
		gbc_lblArmi.anchor = GridBagConstraints.WEST;
		gbc_lblArmi.gridwidth = 3;
		gbc_lblArmi.insets = new Insets(0, 0, 5, 0);
		gbc_lblArmi.gridx = 0;
		gbc_lblArmi.gridy = 0;
		add(lblArmi, gbc_lblArmi);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);

		tableArmi = new JTable();
		tableArmi.addMouseListener(this);

		tableArmi.addFocusListener(this);
		tableArmi.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableArmi.setFillsViewportHeight(true);

		scrollPane.setViewportView(tableArmi);
		PgArmiTableModel pgArmiTableModel = new PgArmiTableModel();
		tableArmi.setModel(pgArmiTableModel);

		tableArmi.getColumnModel().getColumn(3).setCellRenderer(new DecimalWithSignFormatRenderer());
		tableArmi.getColumnModel().getColumn(6).setCellRenderer(new DecimalWithSignFormatRenderer());
		tableArmi.getColumnModel().getColumn(7).setCellRenderer(new DecimalWithSignFormatRenderer());

		TableColumnModel tcm = tableArmi.getColumnModel();
		tcm.removeColumn(tcm.getColumn(14));
		tcm.removeColumn(tcm.getColumn(13));
		tcm.removeColumn(tcm.getColumn(12));

		tableArmi.getTableHeader().addMouseListener(this);
		tableArmi.getTableHeader().setReorderingAllowed(false);

		btnInserisciArma = new JButton("Inserisci Arma");
		btnInserisciArma.addActionListener(this);
		GridBagConstraints gbc_btnInserisciRigaVuota = new GridBagConstraints();
		gbc_btnInserisciRigaVuota.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInserisciRigaVuota.insets = new Insets(0, 0, 5, 5);
		gbc_btnInserisciRigaVuota.gridx = 0;
		gbc_btnInserisciRigaVuota.gridy = 2;
		add(btnInserisciArma, gbc_btnInserisciRigaVuota);

		btnCancellaRigaSelezionata = new JButton("Cancella Riga Selezionata");
		btnCancellaRigaSelezionata.addActionListener(this);

		btnModificaArma = new JButton("Modifica Arma");
		btnModificaArma.addActionListener(this);
		GridBagConstraints gbc_btnModificaArma = new GridBagConstraints();
		gbc_btnModificaArma.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModificaArma.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificaArma.gridx = 1;
		gbc_btnModificaArma.gridy = 2;
		add(btnModificaArma, gbc_btnModificaArma);
		GridBagConstraints gbc_btnCancellaRigaSelezionata = new GridBagConstraints();
		gbc_btnCancellaRigaSelezionata.anchor = GridBagConstraints.WEST;
		gbc_btnCancellaRigaSelezionata.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancellaRigaSelezionata.gridx = 2;
		gbc_btnCancellaRigaSelezionata.gridy = 2;
		add(btnCancellaRigaSelezionata, gbc_btnCancellaRigaSelezionata);

		JLabel lblRiepilogo = new JLabel("Riepilogo");
		lblRiepilogo.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblRiepilogo = new GridBagConstraints();
		gbc_lblRiepilogo.anchor = GridBagConstraints.WEST;
		gbc_lblRiepilogo.gridwidth = 3;
		gbc_lblRiepilogo.insets = new Insets(0, 0, 5, 0);
		gbc_lblRiepilogo.gridx = 0;
		gbc_lblRiepilogo.gridy = 3;
		add(lblRiepilogo, gbc_lblRiepilogo);

		JScrollPane scrollPaneRiepilogo = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 4;
		add(scrollPaneRiepilogo, gbc_scrollPane_1);

		tableArmiRiepilogo = new JTable();
		tableArmiRiepilogo.getTableHeader().addMouseListener(this);

		tableArmiRiepilogo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableArmiRiepilogo.setFillsViewportHeight(true);
		scrollPaneRiepilogo.setViewportView(tableArmiRiepilogo);
		PgArmiRiepilogoTableModel pgArmiRiepilogoTableModel = new PgArmiRiepilogoTableModel();
		tableArmiRiepilogo.setModel(pgArmiRiepilogoTableModel);


	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {

		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		caricaDimensioniTableArmi(opzioniObj.getDimensioniTablePgArmi());
		caricaDimensioniTableArmiRiepilogo(opzioniObj.getDimensioniTablePgArmiRiepilogo());

		ArrayList<PgArmiObj> arrayPgArmi = pgDatiObj.getArrayArmi();
		ArrayList<DbArmiObj> arrayPgArmiDaDb = gestioneJsonItems.getListaArmi();

		// Togliamo le righe non presenti nel db
		for (int i = 0; i < arrayPgArmi.size(); i++) {
			PgArmiObj pgArmiObj = new PgArmiObj();
			pgArmiObj = arrayPgArmi.get(i);
			boolean armaTrovata = false;
			for (int i2 = 0; i2 < arrayPgArmiDaDb.size(); i2++) {
				DbArmiObj dbArmiObj = arrayPgArmiDaDb.get(i2);
				if (pgArmiObj.getArma().equals(dbArmiObj.getNome())) {
					armaTrovata = true;
				}
			}
			if (!armaTrovata) {
				arrayPgArmi.remove(i);
			}
		}

		TableModel modelArmi = new DefaultTableModel();
		TableModel modelArmiRiepilogo = new DefaultTableModel();
		modelArmi = tableArmi.getModel();
		modelArmiRiepilogo = tableArmiRiepilogo.getModel();

		// Valorizzazione delle righe in tabella e ripristino della riga
		// selezionata
		int rigaSelezionataArmi = tableArmi.getSelectedRow();
		((DefaultTableModel) tableArmi.getModel()).setRowCount(0);
		int rigaSelezionataArmiRiepilogo = tableArmiRiepilogo.getSelectedRow();
		((DefaultTableModel) tableArmiRiepilogo.getModel()).setRowCount(0);

		for (int i = 0; i < arrayPgArmi.size(); i++) {
			PgArmiObj pgArmiObj = arrayPgArmi.get(i);
			((DefaultTableModel) modelArmi)
					.addRow(new Object[] { pgArmiObj.getArma(), pgArmiObj.getTaglia(), pgArmiObj.getQualita(),
							pgArmiObj.getMod(), pgArmiObj.getIncantamenti(), pgArmiObj.getBonusIncantamenti(),
							pgArmiObj.getModBab(), pgArmiObj.getModDanno(), pgArmiObj.isA2Mani(),
							pgArmiObj.isDoppiaArma(), pgArmiObj.getPrimariaSecondaria(), pgArmiObj.isEquipaggiata(),
							pgArmiObj.getModBabDescrizione(), pgArmiObj.getModDannoDescrizione(), pgArmiObj.getPrg() });

		}
		if (tableArmi.getRowCount() > 0) {
			if (rigaSelezionataArmi == -1) {

			} else {
				if (tableArmi.getRowCount() > rigaSelezionataArmi) {
					tableArmi.setRowSelectionInterval(rigaSelezionataArmi, rigaSelezionataArmi);
				}
			}
		}

		ArrayList<PgArmiRiepilogoObj> arrayPgArmiRiepilogo = pgDatiObj.getArrayArmiRiepilogo();

		for (int i = 0; i < arrayPgArmiRiepilogo.size(); i++) {
			PgArmiRiepilogoObj pgArmiRiepilogoObj = arrayPgArmiRiepilogo.get(i);
			((DefaultTableModel) modelArmiRiepilogo).addRow(new Object[] { pgArmiRiepilogoObj.getArmaRiepilogo(),
					pgArmiRiepilogoObj.getBatSingoloAttacco(), pgArmiRiepilogoObj.getBatDoppioAttacco(),
					pgArmiRiepilogoObj.getIncrementoGittata(), pgArmiRiepilogoObj.getCritico(),
					pgArmiRiepilogoObj.getDannoTotale(), pgArmiRiepilogoObj.getTipo() });
		}

		if (tableArmiRiepilogo.getRowCount() > 0) {
			if (rigaSelezionataArmiRiepilogo == -1) {

			} else {
				if (tableArmiRiepilogo.getRowCount() > rigaSelezionataArmiRiepilogo) {
					tableArmiRiepilogo.setRowSelectionInterval(rigaSelezionataArmiRiepilogo,
							rigaSelezionataArmiRiepilogo);
				}
			}
		}

	}

	private void inserisciArma() {

		ArrayList<PgArmiObj> arrayArmi = creaArrayArmi();
		PgArmiObj pgArmiObj = new PgArmiObj();
		if (arrayArmi.size() == 0) {
			pgArmiObj.setPrg(1);
		} else {
			int ultimoRecord = arrayArmi.size() - 1;
			pgArmiObj.setPrg(arrayArmi.get(ultimoRecord).getPrg() + 1);
		}

		GestionePgArmiObjDialog gestionePgArmiObjDialog = new GestionePgArmiObjDialog(ListaGestioneDati.INSERISCI,
				pgDatiObj.getId(), pgArmiObj, arrayArmi);
		gestionePgArmiObjDialog.setVisible(true);
		if (gestionePgArmiObjDialog.isRigaGestita()) {
			pgArmiObj = gestionePgArmiObjDialog.getPgArmiObj();
			arrayArmi.add(pgArmiObj);
			pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_ARMI, arrayArmi);
		}
		frame.popolaFrame(pgDatiObj);
	}

	private void modificaArma() {

		if (tableArmi.getSelectedRow() != -1) {
			ArrayList<PgArmiObj> arrayArmi = creaArrayArmi();

			GestionePgArmiObjDialog gestioneArmaDialog = new GestionePgArmiObjDialog(ListaGestioneDati.MODIFICA,
					pgDatiObj.getId(), arrayArmi.get(tableArmi.getSelectedRow()), arrayArmi);
			gestioneArmaDialog.setVisible(true);
			if (gestioneArmaDialog.isRigaGestita()) {
				PgArmiObj pgArmiObj = gestioneArmaDialog.getPgArmiObj();
				for (int i = 0; i < arrayArmi.size(); i++) {
					if (arrayArmi.get(i).getPrg() == pgArmiObj.getPrg()) {
						arrayArmi.set(i, pgArmiObj);
					}
				}
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_ARMI, arrayArmi);
			}
			frame.popolaFrame(pgDatiObj);
		}
	}

	private void cancellaRigaTableArmi() {

		if (tableArmi.getSelectedRow() != -1) {
			((DefaultTableModel) tableArmi.getModel()).removeRow(tableArmi.getSelectedRow());

			if (tableArmi.getRowCount() > 0) {
				tableArmi.setRowSelectionInterval(0, 0);
			}
			ArrayList<PgArmiObj> arrayArmi = creaArrayArmi();
			pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_ARMI, arrayArmi);
			pgDatiObj.setDatiCommittati(false);
			frame.popolaFrame(pgDatiObj);

		}
	}

	private ArrayList<PgArmiObj> creaArrayArmi() {
		ArrayList<PgArmiObj> arrayArmi = new ArrayList<PgArmiObj>();
		ArrayList<PgArmiObj> arrayArmiOriginale = new ArrayList<PgArmiObj>();

		// Recupero array classi dal db
		PgDatiObj pgDatiObjTemp = gestioneJsonPg.getPgByFileName(pgDatiObj.getFileName());
		arrayArmiOriginale = pgDatiObjTemp.getArrayArmi();
		for (int i = 0; i < tableArmi.getRowCount(); i++) {
			// Pulizia campi della tabella che sono stati puliti
			if (tableArmi.getModel().getValueAt(i, 3) == null) {
				tableArmi.getModel().setValueAt(0, i, 3);
			}
			if (tableArmi.getModel().getValueAt(i, 5) == null) {
				tableArmi.getModel().setValueAt(0, i, 5);
			}
			if (tableArmi.getModel().getValueAt(i, 6) == null) {
				tableArmi.getModel().setValueAt(0, i, 6);
			}
			if (tableArmi.getModel().getValueAt(i, 7) == null) {
				tableArmi.getModel().setValueAt(0, i, 7);
			}

			// Recupero valorizzo oggetto pgArmiObj con i dati della JTable
			// Attenzione si usa getModel().getValueAt() per recuperare il
			// valore dal modello, visto che se una colonna è rimossa
			// dalla vista con il solo getValueAt() da un valore errato
			PgArmiObj pgArmiObj = new PgArmiObj();
			pgArmiObj.setArma(tableArmi.getValueAt(i, 0).toString());
			pgArmiObj.setTaglia(tableArmi.getValueAt(i, 1).toString());
			pgArmiObj.setQualita(tableArmi.getValueAt(i, 2).toString());
			pgArmiObj.setMod(Integer.parseInt(tableArmi.getValueAt(i, 3).toString()));
			pgArmiObj.setIncantamenti(tableArmi.getValueAt(i, 4).toString());
			pgArmiObj.setBonusIncantamenti(tableArmi.getValueAt(i, 5).toString());
			pgArmiObj.setModBab(Integer.parseInt(tableArmi.getValueAt(i, 6).toString()));
			pgArmiObj.setModDanno(Integer.parseInt(tableArmi.getValueAt(i, 7).toString()));
			pgArmiObj.setA2Mani((boolean) tableArmi.getValueAt(i, 8));
			pgArmiObj.setDoppiaArma((boolean) tableArmi.getValueAt(i, 9));
			pgArmiObj.setPrimariaSecondaria(tableArmi.getValueAt(i, 10).toString());
			pgArmiObj.setEquipaggiata((boolean) tableArmi.getValueAt(i, 11));
			pgArmiObj.setModBabDescrizione(tableArmi.getModel().getValueAt(i, 12).toString());
			pgArmiObj.setModDannoDescrizione(tableArmi.getModel().getValueAt(i, 13).toString());
			pgArmiObj.setPrg(Integer.parseInt(tableArmi.getModel().getValueAt(i, 14).toString()));

			// Se trovo il progressivo della riga che stiamo leggendo nell'array
			// del db e i dati sono variati attiviamo il flag
			for (int i2 = 0; i2 < arrayArmiOriginale.size(); i2++) {
				PgArmiObj pgArmiObjOriginale = arrayArmiOriginale.get(i2);
				if (pgArmiObjOriginale.getPrg() == pgArmiObj.getPrg()) {
					if (pgArmiObj.getArma().equals(pgArmiObjOriginale.getArma())
							&& pgArmiObj.getTaglia().equals(pgArmiObjOriginale.getTaglia())
							&& pgArmiObj.getQualita().equals(pgArmiObjOriginale.getQualita())
							&& pgArmiObj.getMod() == pgArmiObjOriginale.getMod()
							&& pgArmiObj.getQualita().equals(pgArmiObjOriginale.getQualita())
							&& pgArmiObj.getIncantamenti().equals(pgArmiObjOriginale.getIncantamenti())
							&& pgArmiObj.getBonusIncantamenti().equals(pgArmiObjOriginale.getBonusIncantamenti())
							&& pgArmiObj.getModBab() == pgArmiObjOriginale.getModBab()
							&& pgArmiObj.getModBabDescrizione().equals(pgArmiObjOriginale.getModBabDescrizione())
							&& pgArmiObj.getModDanno() == pgArmiObjOriginale.getModDanno()
							&& pgArmiObj.getModDannoDescrizione().equals(pgArmiObjOriginale.getModDannoDescrizione())
							&& pgArmiObj.isA2Mani() == pgArmiObjOriginale.isA2Mani()
							&& pgArmiObj.isDoppiaArma() == pgArmiObjOriginale.isDoppiaArma()
							&& pgArmiObj.isA2Mani() == pgArmiObjOriginale.isA2Mani()
							&& pgArmiObj.getPrimariaSecondaria().equals(pgArmiObjOriginale.getPrimariaSecondaria())
							&& pgArmiObj.isEquipaggiata() == pgArmiObjOriginale.isEquipaggiata()) {

					} else {
						pgArmiObj.setDatiVariati(true);
					}
				}
			}
			arrayArmi.add(pgArmiObj);
		}
		return arrayArmi;
	}

	private void caricaDimensioniTableArmi(ArrayList<Integer> arrayDimensioni) {
		if (arrayDimensioni.size() > 0 && tableArmi.getColumnCount() == arrayDimensioni.size()) {
			for (int i = 0; i < tableArmi.getColumnCount(); i++) {
				tableArmi.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			tableArmi.getColumnModel().getColumn(0).setPreferredWidth(300);
			tableArmi.getColumnModel().getColumn(1).setPreferredWidth(50);
			tableArmi.getColumnModel().getColumn(2).setPreferredWidth(50);
			tableArmi.getColumnModel().getColumn(3).setPreferredWidth(50);
			tableArmi.getColumnModel().getColumn(4).setPreferredWidth(300);
			tableArmi.getColumnModel().getColumn(5).setPreferredWidth(80);
			tableArmi.getColumnModel().getColumn(6).setPreferredWidth(70);
			tableArmi.getColumnModel().getColumn(7).setPreferredWidth(50);
			tableArmi.getColumnModel().getColumn(8).setPreferredWidth(70);
			tableArmi.getColumnModel().getColumn(9).setPreferredWidth(90);
			tableArmi.getColumnModel().getColumn(10).setPreferredWidth(75);
		}
	}

	private void salvaDimensioniTableArmi() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableArmi.getColumnCount(); i++) {
			arrayDimensioni.add(tableArmi.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTablePgArmi(arrayDimensioni);
		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);
		frame.popolaFrame(pgDatiObj);
	}

	private void caricaDimensioniTableArmiRiepilogo(ArrayList<Integer> arrayDimensioni) {
		if (arrayDimensioni.size() > 0 && tableArmiRiepilogo.getColumnCount() == arrayDimensioni.size()) {
			for (int i = 0; i < tableArmiRiepilogo.getColumnCount(); i++) {
				tableArmiRiepilogo.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			tableArmiRiepilogo.getColumnModel().getColumn(0).setPreferredWidth(450);
			tableArmiRiepilogo.getColumnModel().getColumn(1).setPreferredWidth(120);
			tableArmiRiepilogo.getColumnModel().getColumn(2).setPreferredWidth(120);
			tableArmiRiepilogo.getColumnModel().getColumn(3).setPreferredWidth(100);
			tableArmiRiepilogo.getColumnModel().getColumn(4).setPreferredWidth(120);
			tableArmiRiepilogo.getColumnModel().getColumn(5).setPreferredWidth(110);
			tableArmiRiepilogo.getColumnModel().getColumn(6).setPreferredWidth(110);
		}
	}

	private void salvaDimensioniTableArmiRiepilogo() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableArmiRiepilogo.getColumnCount(); i++) {
			arrayDimensioni.add(tableArmiRiepilogo.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTablePgArmiRiepilogo(arrayDimensioni);
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
			if ((JTable) component == tableArmi) {
				// Salvataggio array armi
				ArrayList<PgArmiObj> arrayArmi = creaArrayArmi();
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_ARMI, arrayArmi);
				frame.popolaFrame(pgDatiObj);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object oggetto = e.getSource();

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == btnInserisciArma.getActionCommand()) {
				inserisciArma();
			}
			if (((JButton) oggetto).getActionCommand() == btnCancellaRigaSelezionata.getActionCommand()) {
				cancellaRigaTableArmi();
			}
			if (((JButton) oggetto).getActionCommand() == btnModificaArma.getActionCommand()) {
				modificaArma();
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
			if ((JTableHeader) component == tableArmiRiepilogo.getTableHeader()) {
				salvaDimensioniTableArmiRiepilogo();
			}
		}

	}

}