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
import comboBox.PgArmiComboBox;
import formatRenderer.DecimalWithSignFormatRenderer;
import gui.MainWindow;
import gui.dialog.GestionePgAbilitaObjDialog;
import json.GestioneJsonOpzioni;
import json.GestioneJsonPg;
import obj.OpzioniObj;
import obj.PgAbilitaObj;
import obj.PgDatiObj;
import tableModels.PgAbilitaTableModel;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
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
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;

public class PgAbilitaPanel extends JPanel implements ActionListener, FocusListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5221576706307921986L;
	GestioneJsonPg gestioneJsonPg = new GestioneJsonPg();
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	OpzioniObj opzioniObj = new OpzioniObj();
	PgArmiComboBox acb = new PgArmiComboBox();
	private AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	private JTable tableAbilita;
	private PgDatiObj pgDatiObj;
	private MainWindow frame;
	private JButton btnModificaAbilita;

	/**
	 * Create the panel.
	 * 
	 * @param pgDatiObj
	 */
	public PgAbilitaPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.pgDatiObj = pgDatiObj;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 183, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblListaAbilita = new JLabel("Lista Abilit\u00E0");
		lblListaAbilita.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblListaAbilita = new GridBagConstraints();
		gbc_lblListaAbilita.anchor = GridBagConstraints.WEST;
		gbc_lblListaAbilita.gridwidth = 2;
		gbc_lblListaAbilita.insets = new Insets(0, 0, 5, 0);
		gbc_lblListaAbilita.gridx = 0;
		gbc_lblListaAbilita.gridy = 0;
		add(lblListaAbilita, gbc_lblListaAbilita);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);

		tableAbilita = new JTable();
		tableAbilita.addMouseListener(this);
		tableAbilita.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableAbilita.addFocusListener(this);
		tableAbilita.setFillsViewportHeight(true);

		scrollPane.setViewportView(tableAbilita);
		PgAbilitaTableModel pgAbilitaTableModel = new PgAbilitaTableModel();
		tableAbilita.setModel(pgAbilitaTableModel);
		tableAbilita.getColumnModel().getColumn(4).setCellRenderer(new DecimalWithSignFormatRenderer());
		tableAbilita.getColumnModel().getColumn(5).setCellRenderer(new DecimalWithSignFormatRenderer());
		tableAbilita.getColumnModel().getColumn(6).setCellRenderer(new DecimalWithSignFormatRenderer());
		tableAbilita.getColumnModel().getColumn(7).setCellRenderer(new DecimalWithSignFormatRenderer());
		tableAbilita.getColumnModel().getColumn(8).setCellRenderer(new DecimalWithSignFormatRenderer());
		TableColumnModel tcm = tableAbilita.getColumnModel();
		tcm.removeColumn(tcm.getColumn(10));

		// tableArmi.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

		tableAbilita.getTableHeader().addMouseListener(this);
		tableAbilita.getTableHeader().setReorderingAllowed(false);

		btnModificaAbilita = new JButton("Modifica Abilita");
		btnModificaAbilita.addActionListener(this);
		GridBagConstraints gbc_btnModificaAbilita = new GridBagConstraints();
		gbc_btnModificaAbilita.anchor = GridBagConstraints.WEST;
		gbc_btnModificaAbilita.insets = new Insets(0, 0, 0, 5);
		gbc_btnModificaAbilita.gridx = 0;
		gbc_btnModificaAbilita.gridy = 2;
		add(btnModificaAbilita, gbc_btnModificaAbilita);

	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {

		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		caricaDimensioniTableAbilita(opzioniObj.getDimensioniTablePgAbilita());

		ArrayList<PgAbilitaObj> arrayPgAbilita = pgDatiObj.getArrayAbilita();

		TableModel modelAbilita = new DefaultTableModel();
		modelAbilita = tableAbilita.getModel();

		// Valorizzazione delle righe in tabella e ripristino della riga
		// selezionata
		int rigaSelezionataAbilita = tableAbilita.getSelectedRow();
		((DefaultTableModel) tableAbilita.getModel()).setRowCount(0);

		for (int i = 0; i < arrayPgAbilita.size(); i++) {
			PgAbilitaObj pgAbilitaObj = new PgAbilitaObj();
			pgAbilitaObj = arrayPgAbilita.get(i);
			((DefaultTableModel) modelAbilita)
					.addRow(new Object[] { pgAbilitaObj.isAbilitaDiClasse(), pgAbilitaObj.isAbilitaDiClasseIncrociata(),
							pgAbilitaObj.getNome(), pgAbilitaObj.getCaratteristica(), pgAbilitaObj.getTotale(),
							pgAbilitaObj.getModCaratteristica(), pgAbilitaObj.getGrado(), pgAbilitaObj.getAltro(),
							pgAbilitaObj.getBonus(), pgAbilitaObj.isRichiedeAddestramento(), pgAbilitaObj.getPrg() });

		}
		if (tableAbilita.getRowCount() > 0) {
			if (rigaSelezionataAbilita == -1) {

			} else {
				if (tableAbilita.getRowCount() > rigaSelezionataAbilita) {
					tableAbilita.setRowSelectionInterval(rigaSelezionataAbilita, rigaSelezionataAbilita);
				}
			}
		}

	}

	private ArrayList<PgAbilitaObj> creaArrayAbilita() {
		ArrayList<PgAbilitaObj> arrayAbilita = new ArrayList<PgAbilitaObj>();
		ArrayList<PgAbilitaObj> arrayAbilitaOriginale = new ArrayList<PgAbilitaObj>();
	
		// Recupero array abilita dal db
		PgDatiObj pgDatiObjTemp = gestioneJsonPg.getPgByFileName(pgDatiObj.getFileName());
		arrayAbilitaOriginale = pgDatiObjTemp.getArrayAbilita();
		for (int i = 0; i < tableAbilita.getRowCount(); i++) {
			// Pulizia campi della tabella che sono stati puliti
			if (tableAbilita.getModel().getValueAt(i, 4) == null) {
				tableAbilita.getModel().setValueAt(0, i, 4);
			}
			if (tableAbilita.getModel().getValueAt(i, 5) == null) {
				tableAbilita.getModel().setValueAt(0, i, 5);
			}
			if (tableAbilita.getModel().getValueAt(i, 6) == null) {
				tableAbilita.getModel().setValueAt(0, i, 6);
			}
			if (tableAbilita.getModel().getValueAt(i, 7) == null) {
				tableAbilita.getModel().setValueAt(0, i, 7);
			}
	
			// Recupero valorizzo oggetto pgAbilitaObj con i dati della JTable
			// Attenzione si usa getModel().getValueAt() per recuperare il
			// valore dal modello, visto che se una colonna è rimossa
			// dalla vista con il solo getValueAt() da un valore errato
			PgAbilitaObj pgAbilitaObj = new PgAbilitaObj();
			pgAbilitaObj.setAbilitaDiClasse((boolean) tableAbilita.getValueAt(i, 0));
			pgAbilitaObj.setAbilitaDiClasseIncrociata((boolean) tableAbilita.getValueAt(i, 1));
			pgAbilitaObj.setNome(tableAbilita.getValueAt(i, 2).toString());
			pgAbilitaObj.setCaratteristica(tableAbilita.getValueAt(i, 3).toString());
			pgAbilitaObj.setTotale(Integer.parseInt(tableAbilita.getValueAt(i, 4).toString()));
			pgAbilitaObj.setModCaratteristica(Integer.parseInt(tableAbilita.getValueAt(i, 5).toString()));
			pgAbilitaObj.setGrado(Integer.parseInt(tableAbilita.getValueAt(i, 6).toString()));
			pgAbilitaObj.setAltro(Integer.parseInt(tableAbilita.getValueAt(i, 7).toString()));
			pgAbilitaObj.setBonus(Integer.parseInt(tableAbilita.getValueAt(i, 8).toString()));
			pgAbilitaObj.setRichiedeAddestramento((boolean) tableAbilita.getValueAt(i, 9));
			pgAbilitaObj.setPrg(Integer.parseInt(tableAbilita.getModel().getValueAt(i, 10).toString()));
	
			// Se trovo il progressivo della riga che stiamo leggendo nell'array
			// del db e i dati sono variati attiviamo il flag
			for (int i2 = 0; i2 < arrayAbilitaOriginale.size(); i2++) {
				PgAbilitaObj pgAbilitaObjOriginale = new PgAbilitaObj();
				pgAbilitaObjOriginale = arrayAbilitaOriginale.get(i2);
				if (pgAbilitaObjOriginale.getPrg() == pgAbilitaObj.getPrg()) {
					if (pgAbilitaObj.isAbilitaDiClasse() == pgAbilitaObjOriginale.isAbilitaDiClasse()
							&& pgAbilitaObj.isAbilitaDiClasseIncrociata() == pgAbilitaObjOriginale
									.isAbilitaDiClasseIncrociata()
							&& pgAbilitaObj.getGrado() == pgAbilitaObjOriginale.getGrado()
							&& pgAbilitaObj.getAltro() == pgAbilitaObjOriginale.getAltro()) {
	
					} else {
						pgAbilitaObj.setDatiVariati(true);
					}
				}
			}
			arrayAbilita.add(pgAbilitaObj);
		}
		return arrayAbilita;
	}

	private void modificaAbilita() {

		if (tableAbilita.getSelectedRow() != -1) {
			ArrayList<PgAbilitaObj> arrayAbilita = creaArrayAbilita();

			GestionePgAbilitaObjDialog gestionePgAbilitaObjDialog = new GestionePgAbilitaObjDialog(
					ListaGestioneDati.MODIFICA, pgDatiObj.getId(), arrayAbilita.get(tableAbilita.getSelectedRow()));
			gestionePgAbilitaObjDialog.setVisible(true);
			if (gestionePgAbilitaObjDialog.isRigaGestita()) {
				PgAbilitaObj pgAbilitaObj = gestionePgAbilitaObjDialog.getPgAbilitaObj();
				for (int i = 0; i < arrayAbilita.size(); i++) {
					if (arrayAbilita.get(i).getPrg() == pgAbilitaObj.getPrg()) {
						arrayAbilita.set(i, pgAbilitaObj);
					}
				}
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_ABILITA, arrayAbilita);
			}
			frame.popolaFrame(pgDatiObj);
		}
	}
	
	private void caricaDimensioniTableAbilita(ArrayList<Integer> arrayDimensioni) {
		if (arrayDimensioni.size() > 0&& tableAbilita.getColumnCount() == arrayDimensioni.size()) {
			for (int i = 0; i < tableAbilita.getColumnCount(); i++) {
				tableAbilita.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			tableAbilita.getColumnModel().getColumn(0).setPreferredWidth(50);
			tableAbilita.getColumnModel().getColumn(1).setPreferredWidth(50);
			tableAbilita.getColumnModel().getColumn(2).setPreferredWidth(310);
			tableAbilita.getColumnModel().getColumn(3).setPreferredWidth(75);
			tableAbilita.getColumnModel().getColumn(4).setPreferredWidth(75);
			tableAbilita.getColumnModel().getColumn(5).setPreferredWidth(75);
			tableAbilita.getColumnModel().getColumn(6).setPreferredWidth(75);
			tableAbilita.getColumnModel().getColumn(7).setPreferredWidth(75);
			tableAbilita.getColumnModel().getColumn(8).setPreferredWidth(75);
			tableAbilita.getColumnModel().getColumn(9).setPreferredWidth(90);

		}
	}

	private void salvaDimensioniTableAbilita() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableAbilita.getColumnCount(); i++) {
			arrayDimensioni.add(tableAbilita.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTablePgAbilita(arrayDimensioni);
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
			if ((JTable) component == tableAbilita) {

				ArrayList<PgAbilitaObj> arrayAbilita = creaArrayAbilita();
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_ABILITA, arrayAbilita);
				frame.popolaFrame(pgDatiObj);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object oggetto = e.getSource();
		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == btnModificaAbilita.getActionCommand()) {
				modificaAbilita();
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