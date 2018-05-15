package gui.panel;

import javax.swing.JPanel;

import gui.MainWindow;
import gui.dialog.GestionePgEquipObjDialog;
import json.GestioneJsonOpzioni;
import json.GestioneJsonPg;
import obj.OpzioniObj;
import obj.PgDatiObj;
import obj.PgEquipObj;
import tableModels.PgEquipTableModel;

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
import formatRenderer.DecimalWithSignFormatRenderer;
import cellRenderer.TextAreaRenderer;

import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class PgEquipPanel extends JPanel implements FocusListener, ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainWindow frame;
	private JTable tableEquip;
	private PgDatiObj pgDatiObj = new PgDatiObj();
	GestioneJsonPg gestioneJsonPg = new GestioneJsonPg();
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	OpzioniObj opzioniObj = new OpzioniObj();
	PgBonusComboBox bcb = new PgBonusComboBox();

	private JButton btnInserisciOggetto;
	private JButton btnCancellaRigaSelezionata;
	private AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	private JButton btnModificaOggetto;
	private JPanel panelPesi;
	private JLabel lblTotalePesi;
	private JLabel lblIndossato;
	private JLabel lblZaino;
	private JLabel lblTascaDaCintura;
	private JLabel lblAltro;
	private JTextField textFieldTotalePesiIndossato;
	private JTextField textFieldTotalePesiZaino;
	private JTextField textFieldTotalePesiTascaDaCintura;
	private JTextField textFieldTotalePesiAltro;
	private JLabel lblTotalePesiSul;
	private JTextField textFieldTotalePesi;

	/**
	 * Create the panel.
	 * 
	 * @param pgDatiObj
	 */
	public PgEquipPanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.pgDatiObj = pgDatiObj;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 40, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JScrollPane scrollPaneEquip = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPaneEquip, gbc_scrollPane);

		tableEquip = new JTable();
		tableEquip.addMouseListener(this);
		tableEquip.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		tableEquip.setPreferredScrollableViewportSize(new Dimension(0, 0));

		tableEquip.setFillsViewportHeight(true);
		tableEquip.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableEquip.addFocusListener(this);
		PgEquipTableModel equipTableModel = new PgEquipTableModel();
		tableEquip.setModel(equipTableModel);
		

		scrollPaneEquip.setViewportView(tableEquip);
		TableColumnModel tcm = tableEquip.getColumnModel();
		tcm.removeColumn(tcm.getColumn(7));

		tableEquip.getTableHeader().addMouseListener(this);
		tableEquip.getTableHeader().setReorderingAllowed(false);

		btnInserisciOggetto = new JButton("Inserisci Oggetto");
		btnInserisciOggetto.addActionListener(this);
		GridBagConstraints gbc_btnInserisciOggetto = new GridBagConstraints();
		gbc_btnInserisciOggetto.anchor = GridBagConstraints.WEST;
		gbc_btnInserisciOggetto.insets = new Insets(0, 0, 5, 5);
		gbc_btnInserisciOggetto.gridx = 0;
		gbc_btnInserisciOggetto.gridy = 1;
		add(btnInserisciOggetto, gbc_btnInserisciOggetto);

		btnModificaOggetto = new JButton("Modifica Equip");
		btnModificaOggetto.addActionListener(this);
		GridBagConstraints gbc_btnModificaOggetto = new GridBagConstraints();
		gbc_btnModificaOggetto.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificaOggetto.gridx = 1;
		gbc_btnModificaOggetto.gridy = 1;
		add(btnModificaOggetto, gbc_btnModificaOggetto);

		btnCancellaRigaSelezionata = new JButton("Cancella Riga Selezionata");
		btnCancellaRigaSelezionata.addActionListener(this);
		GridBagConstraints gbc_btnCancellaRigaSelezionata = new GridBagConstraints();
		gbc_btnCancellaRigaSelezionata.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancellaRigaSelezionata.anchor = GridBagConstraints.WEST;
		gbc_btnCancellaRigaSelezionata.gridx = 2;
		gbc_btnCancellaRigaSelezionata.gridy = 1;
		add(btnCancellaRigaSelezionata, gbc_btnCancellaRigaSelezionata);
		
		panelPesi = new JPanel();
		GridBagConstraints gbc_panelPesi = new GridBagConstraints();
		gbc_panelPesi.gridwidth = 3;
		gbc_panelPesi.insets = new Insets(0, 0, 0, 5);
		gbc_panelPesi.fill = GridBagConstraints.BOTH;
		gbc_panelPesi.gridx = 0;
		gbc_panelPesi.gridy = 2;
		add(panelPesi, gbc_panelPesi);
		GridBagLayout gbl_panelPesi = new GridBagLayout();
		gbl_panelPesi.columnWidths = new int[]{0, 70, 70, 70, 70, 0, 0};
		gbl_panelPesi.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelPesi.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelPesi.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPesi.setLayout(gbl_panelPesi);
		
		lblIndossato = new JLabel("Indossato");
		GridBagConstraints gbc_lblIndossato = new GridBagConstraints();
		gbc_lblIndossato.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndossato.gridx = 1;
		gbc_lblIndossato.gridy = 0;
		panelPesi.add(lblIndossato, gbc_lblIndossato);
		
		lblZaino = new JLabel("Zaino");
		GridBagConstraints gbc_lblZaino = new GridBagConstraints();
		gbc_lblZaino.insets = new Insets(0, 0, 5, 5);
		gbc_lblZaino.gridx = 2;
		gbc_lblZaino.gridy = 0;
		panelPesi.add(lblZaino, gbc_lblZaino);
		
		lblTascaDaCintura = new JLabel("Tasca Da Cintura");
		GridBagConstraints gbc_lblTascaDaCintura = new GridBagConstraints();
		gbc_lblTascaDaCintura.insets = new Insets(0, 0, 5, 5);
		gbc_lblTascaDaCintura.gridx = 3;
		gbc_lblTascaDaCintura.gridy = 0;
		panelPesi.add(lblTascaDaCintura, gbc_lblTascaDaCintura);
		
		lblAltro = new JLabel("Altro");
		GridBagConstraints gbc_lblAltro = new GridBagConstraints();
		gbc_lblAltro.insets = new Insets(0, 0, 5, 5);
		gbc_lblAltro.gridx = 4;
		gbc_lblAltro.gridy = 0;
		panelPesi.add(lblAltro, gbc_lblAltro);
		
		lblTotalePesi = new JLabel("Totale Pesi:");
		GridBagConstraints gbc_lblTotalePesi = new GridBagConstraints();
		gbc_lblTotalePesi.anchor = GridBagConstraints.EAST;
		gbc_lblTotalePesi.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalePesi.gridx = 0;
		gbc_lblTotalePesi.gridy = 1;
		panelPesi.add(lblTotalePesi, gbc_lblTotalePesi);
		
		textFieldTotalePesiIndossato = new JTextField();
		textFieldTotalePesiIndossato.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalePesiIndossato.setEnabled(false);
		textFieldTotalePesiIndossato.setEditable(false);
		GridBagConstraints gbc_textFieldTotalePesiIndossato = new GridBagConstraints();
		gbc_textFieldTotalePesiIndossato.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTotalePesiIndossato.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTotalePesiIndossato.gridx = 1;
		gbc_textFieldTotalePesiIndossato.gridy = 1;
		panelPesi.add(textFieldTotalePesiIndossato, gbc_textFieldTotalePesiIndossato);
		textFieldTotalePesiIndossato.setColumns(10);
		
		textFieldTotalePesiZaino = new JTextField();
		textFieldTotalePesiZaino.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalePesiZaino.setEnabled(false);
		textFieldTotalePesiZaino.setEditable(false);
		textFieldTotalePesiZaino.setColumns(10);
		GridBagConstraints gbc_textFieldTotalePesiZaino = new GridBagConstraints();
		gbc_textFieldTotalePesiZaino.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTotalePesiZaino.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTotalePesiZaino.gridx = 2;
		gbc_textFieldTotalePesiZaino.gridy = 1;
		panelPesi.add(textFieldTotalePesiZaino, gbc_textFieldTotalePesiZaino);
		
		textFieldTotalePesiTascaDaCintura = new JTextField();
		textFieldTotalePesiTascaDaCintura.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalePesiTascaDaCintura.setEnabled(false);
		textFieldTotalePesiTascaDaCintura.setEditable(false);
		textFieldTotalePesiTascaDaCintura.setColumns(10);
		GridBagConstraints gbc_textFieldTotalePesiTascaDaCintura = new GridBagConstraints();
		gbc_textFieldTotalePesiTascaDaCintura.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTotalePesiTascaDaCintura.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTotalePesiTascaDaCintura.gridx = 3;
		gbc_textFieldTotalePesiTascaDaCintura.gridy = 1;
		panelPesi.add(textFieldTotalePesiTascaDaCintura, gbc_textFieldTotalePesiTascaDaCintura);
		
		textFieldTotalePesiAltro = new JTextField();
		textFieldTotalePesiAltro.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalePesiAltro.setEnabled(false);
		textFieldTotalePesiAltro.setEditable(false);
		textFieldTotalePesiAltro.setColumns(10);
		GridBagConstraints gbc_textFieldTotalePesiAltro = new GridBagConstraints();
		gbc_textFieldTotalePesiAltro.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTotalePesiAltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTotalePesiAltro.gridx = 4;
		gbc_textFieldTotalePesiAltro.gridy = 1;
		panelPesi.add(textFieldTotalePesiAltro, gbc_textFieldTotalePesiAltro);
		
		lblTotalePesiSul = new JLabel("Totale Pesi Sul Pg:");
		GridBagConstraints gbc_lblTotalePesiSul = new GridBagConstraints();
		gbc_lblTotalePesiSul.gridwidth = 2;
		gbc_lblTotalePesiSul.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotalePesiSul.gridx = 0;
		gbc_lblTotalePesiSul.gridy = 3;
		panelPesi.add(lblTotalePesiSul, gbc_lblTotalePesiSul);
		
		textFieldTotalePesi = new JTextField();
		textFieldTotalePesi.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalePesi.setEnabled(false);
		textFieldTotalePesi.setEditable(false);
		textFieldTotalePesi.setColumns(10);
		GridBagConstraints gbc_textFieldTotalePesi = new GridBagConstraints();
		gbc_textFieldTotalePesi.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTotalePesi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTotalePesi.gridx = 2;
		gbc_textFieldTotalePesi.gridy = 3;
		panelPesi.add(textFieldTotalePesi, gbc_textFieldTotalePesi);

	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {

		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		caricaDimensioniTableEquip(opzioniObj.getDimensioniTablePgEquip());

		// TODO Popolamento scheda "Equip"
		ArrayList<PgEquipObj> arrayPgEquip = new ArrayList<PgEquipObj>();
		arrayPgEquip = pgDatiObj.getArrayEquip();

		TableModel model = new DefaultTableModel();
		model = tableEquip.getModel();

		int rigaSelezionata = tableEquip.getSelectedRow();
		((DefaultTableModel) tableEquip.getModel()).setRowCount(0);

		for (int i = 0; i < arrayPgEquip.size(); i++) {
			PgEquipObj pgEquipObj = arrayPgEquip.get(i);
			((DefaultTableModel) model).addRow(new Object[] { pgEquipObj.getNome(), pgEquipObj.getNumero(),
					pgEquipObj.getPeso(), pgEquipObj.isIndossato(), pgEquipObj.isZaino(), pgEquipObj.isTascaDaCintura(),
					pgEquipObj.isAltro(), pgEquipObj.getPrg() });
		}
		if (tableEquip.getRowCount() > 0) {
			if (rigaSelezionata == -1) {

			} else {
				if (tableEquip.getRowCount() > rigaSelezionata) {
					tableEquip.setRowSelectionInterval(rigaSelezionata, rigaSelezionata);
				}
			}
		}
		tableEquip.setPreferredScrollableViewportSize(tableEquip.getPreferredSize());
		
		textFieldTotalePesiIndossato.setText(pgDatiObj.getTotalePesiIndossato().toString());
		textFieldTotalePesiZaino.setText(pgDatiObj.getTotalePesiZaino().toString());
		textFieldTotalePesiTascaDaCintura.setText(pgDatiObj.getTotalePesiTascaDaCintura().toString());
		textFieldTotalePesiAltro.setText(pgDatiObj.getTotalePesiAltro().toString());
		textFieldTotalePesi.setText(pgDatiObj.getTotalePesi().toString());

	}

	private ArrayList<PgEquipObj> creaArrayEquip() {
		ArrayList<PgEquipObj> arrayEquip = new ArrayList<PgEquipObj>();
		ArrayList<PgEquipObj> arrayEquipOriginale = new ArrayList<PgEquipObj>();

		// Recupero array bonus dal db
		PgDatiObj pgDatiObjTemp = gestioneJsonPg.getPgByFileName(pgDatiObj.getFileName());

		arrayEquipOriginale = pgDatiObjTemp.getArrayEquip();
		for (int i = 0; i < tableEquip.getRowCount(); i++) {
			// Pulizia campi della tabella che sono stati puliti
			if (tableEquip.getModel().getValueAt(i, 3) == null) {
				tableEquip.getModel().setValueAt(0, i, 3);
			}

			// Recupero valorizzo oggetto pgEquipObj con i dati della JTable
			// Attenzione si usa getModel().getValueAt() per recuperare il
			// valore dal modello, visto che se una colonna è rimossa
			// dalla vista con il solo getValueAt() da un valore errato
			PgEquipObj pgEquipObj = new PgEquipObj();
			pgEquipObj.setNome(tableEquip.getValueAt(i, 0).toString());
			pgEquipObj.setNumero(Integer.parseInt(tableEquip.getValueAt(i, 1).toString()));
			pgEquipObj.setPeso(Double.parseDouble(tableEquip.getValueAt(i, 2).toString()));
			pgEquipObj.setIndossato((boolean) tableEquip.getValueAt(i, 3));
			pgEquipObj.setZaino((boolean) tableEquip.getValueAt(i, 4));
			pgEquipObj.setTascaDaCintura((boolean) tableEquip.getValueAt(i, 5));
			pgEquipObj.setAltro((boolean) tableEquip.getValueAt(i, 6));
			pgEquipObj.setPrg(Integer.parseInt(tableEquip.getModel().getValueAt(i, 7).toString()));

			// Se trovo il progressivo della riga che stiamo leggendo nell'array
			// del db e i dati sono variati attiviamo il flag
			for (int i2 = 0; i2 < arrayEquipOriginale.size(); i2++) {
				PgEquipObj pgEquipObjOriginale = arrayEquipOriginale.get(i2);
				if (pgEquipObjOriginale.getPrg() == pgEquipObj.getPrg()) {
					if (pgEquipObj.getNome().equals(pgEquipObjOriginale.getNome())
							&& pgEquipObj.getNumero() == pgEquipObjOriginale.getNumero()
							&& pgEquipObj.getPeso() == pgEquipObjOriginale.getPeso()
							&& pgEquipObj.isIndossato() == pgEquipObjOriginale.isIndossato()
							&& pgEquipObj.isZaino() == pgEquipObjOriginale.isZaino()
							&& pgEquipObj.isTascaDaCintura() == pgEquipObjOriginale.isTascaDaCintura()
							&& pgEquipObj.isAltro() == pgEquipObjOriginale.isAltro()) {

					} else {
						pgEquipObj.setDatiVariati(true);
					}
				}
			}
			arrayEquip.add(pgEquipObj);
		}
		return arrayEquip;
	}

	private void inserisciOggetto() {

		ArrayList<PgEquipObj> arrayEquip = creaArrayEquip();
		PgEquipObj pgEquipObj = new PgEquipObj();
		if (arrayEquip.size() == 0) {
			pgEquipObj.setPrg(1);
		} else {
			int ultimoRecord = arrayEquip.size() - 1;
			pgEquipObj.setPrg(arrayEquip.get(ultimoRecord).getPrg() + 1);
		}

		GestionePgEquipObjDialog gestionePgEquipObjDialog = new GestionePgEquipObjDialog(ListaGestioneDati.INSERISCI,
				pgDatiObj.getId(), pgEquipObj);
		gestionePgEquipObjDialog.setVisible(true);
		if (gestionePgEquipObjDialog.isRigaGestita()) {
			pgEquipObj = gestionePgEquipObjDialog.getPgEquipObj();
			arrayEquip.add(pgEquipObj);
			pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_EQUIP, arrayEquip);
		}
		frame.popolaFrame(pgDatiObj);
	}

	private void modificaOggetto() {

		if (tableEquip.getSelectedRow() != -1) {

			ArrayList<PgEquipObj> arrayEquip = creaArrayEquip();

			GestionePgEquipObjDialog gestionePgEquipObjDialog = new GestionePgEquipObjDialog(ListaGestioneDati.MODIFICA,
					pgDatiObj.getId(), arrayEquip.get(tableEquip.getSelectedRow()));
			gestionePgEquipObjDialog.setVisible(true);
			if (gestionePgEquipObjDialog.isRigaGestita()) {
				PgEquipObj pgEquipObj = gestionePgEquipObjDialog.getPgEquipObj();
				for (int i = 0; i < arrayEquip.size(); i++) {
					if (arrayEquip.get(i).getPrg() == pgEquipObj.getPrg()) {
						arrayEquip.set(i, pgEquipObj);
					}
				}
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_EQUIP, arrayEquip);
			}
			frame.popolaFrame(pgDatiObj);
		}

	}

	private void cancellaRigaTableEquip() {

		if (tableEquip.getSelectedRow() != -1) {
			((DefaultTableModel) tableEquip.getModel()).removeRow(tableEquip.getSelectedRow());

			if (tableEquip.getRowCount() > 0) {
				tableEquip.setRowSelectionInterval(0, 0);
			}
			ArrayList<PgEquipObj> arrayEquip = creaArrayEquip();
			pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_EQUIP, arrayEquip);
			pgDatiObj.setDatiCommittati(false);
			frame.popolaFrame(pgDatiObj);

		}
	}

	private void caricaDimensioniTableEquip(ArrayList<Integer> arrayDimensioni) {
		if (arrayDimensioni.size() > 0 && tableEquip.getColumnCount() == arrayDimensioni.size()) {
			for (int i = 0; i < tableEquip.getColumnCount(); i++) {
				tableEquip.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			 tableEquip.getColumnModel().getColumn(0).setPreferredWidth(350);
			 tableEquip.getColumnModel().getColumn(1).setPreferredWidth(60);
			 tableEquip.getColumnModel().getColumn(2).setPreferredWidth(60);
			 tableEquip.getColumnModel().getColumn(3).setPreferredWidth(65);
			 tableEquip.getColumnModel().getColumn(4).setPreferredWidth(45);
			 tableEquip.getColumnModel().getColumn(5).setPreferredWidth(75);
			 tableEquip.getColumnModel().getColumn(6).setPreferredWidth(45);

		}
	}

	private void salvaDimensioniTableEquip() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableEquip.getColumnCount(); i++) {
			arrayDimensioni.add(tableEquip.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTablePgEquip(arrayDimensioni);
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
			if (((JButton) oggetto).getActionCommand() == btnInserisciOggetto.getActionCommand()) {
				inserisciOggetto();
			}
			if (((JButton) oggetto).getActionCommand() == btnCancellaRigaSelezionata.getActionCommand()) {
				cancellaRigaTableEquip();
			}
			if (((JButton) oggetto).getActionCommand() == btnModificaOggetto.getActionCommand()) {
				modificaOggetto();
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
			if ((JTable) component == tableEquip) {
				if (e.getClickCount() == 2 && tableEquip.getSelectedRow() != -1) {
					modificaOggetto();
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTableHeader) {
			if ((JTableHeader) component == tableEquip.getTableHeader()) {
				salvaDimensioniTableEquip();
			}
		}
	}

}
