package gui.panel;

import javax.swing.JPanel;

import gui.MainWindow;
import gui.dialog.GestionePgManovreObjDialog;
import json.GestioneJsonOpzioni;
import json.GestioneJsonPg;
import obj.OpzioniObj;
import obj.PgDatiObj;
import obj.PgManovreObj;
import tableModels.PgManovreTableModel;


import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.NumberFormatter;

import Classi.AggiornaOggetti;
import Classi.Formati;
import ENUM.ListaGestioneDati;
import ENUM.ListaPgDati;
import comboBox.PgBonusComboBox;
import formatRenderer.DecimalWithSignFormatRenderer;
import cellRenderer.TextAreaRenderer;

import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JComboBox;

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
import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;

public class PgManovrePanel extends JPanel implements FocusListener, ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainWindow frame;
	private JTable tableManovre;
	private PgDatiObj pgDatiObj = new PgDatiObj();
	Formati formati = new Formati();

	GestioneJsonPg gestioneJsonPg = new GestioneJsonPg();
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	OpzioniObj opzioniObj = new OpzioniObj();
	PgBonusComboBox bcb = new PgBonusComboBox();

	private JButton btnInserisciManovra;
	private JButton btnCancellaRigaSelezionata;
	private AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	private JButton btnModificaManovra;
	private JPanel panel;
	private JLabel lblManovreConosciute;
	private JFormattedTextField formattedTextFieldManovreConosciute;
	private JLabel lblManovrePronte;
	private JFormattedTextField formattedTextFieldManovrePronte;
	private JLabel lblStanceConosciute;
	private JFormattedTextField formattedTextFieldStanceConosciute;

	/**
	 * Create the panel.
	 * 
	 * @param pgDatiObj
	 */
	public PgManovrePanel(PgDatiObj pgDatiObj) {

		frame = getFrame();
		this.pgDatiObj = pgDatiObj;

		NumberFormatter soloNumeri = formati.getSoloNumeri();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 382, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);

		tableManovre = new JTable();
		tableManovre.addMouseListener(this);
		tableManovre.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableManovre.setFillsViewportHeight(true);
		tableManovre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableManovre.addFocusListener(this);
		PgManovreTableModel manovreTableModel = new PgManovreTableModel();
		tableManovre.setModel(manovreTableModel);
		tableManovre.getColumnModel().getColumn(6).setCellRenderer(new TextAreaRenderer());

		scrollPane.setViewportView(tableManovre);
		TableColumnModel tcm = tableManovre.getColumnModel();
		tcm.removeColumn(tcm.getColumn(7));

		tableManovre.getTableHeader().addMouseListener(this);
		tableManovre.getTableHeader().setReorderingAllowed(false);

		btnInserisciManovra = new JButton("Inserisci Manovra");
		btnInserisciManovra.addActionListener(this);
		GridBagConstraints gbc_btnInserisciManovra = new GridBagConstraints();
		gbc_btnInserisciManovra.anchor = GridBagConstraints.WEST;
		gbc_btnInserisciManovra.insets = new Insets(0, 0, 5, 5);
		gbc_btnInserisciManovra.gridx = 0;
		gbc_btnInserisciManovra.gridy = 1;
		add(btnInserisciManovra, gbc_btnInserisciManovra);

		btnModificaManovra = new JButton("Modifica Manovra");
		btnModificaManovra.addActionListener(this);
		GridBagConstraints gbc_btnModificaManovra = new GridBagConstraints();
		gbc_btnModificaManovra.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificaManovra.gridx = 1;
		gbc_btnModificaManovra.gridy = 1;
		add(btnModificaManovra, gbc_btnModificaManovra);

		btnCancellaRigaSelezionata = new JButton("Cancella Riga Selezionata");
		btnCancellaRigaSelezionata.addActionListener(this);
		GridBagConstraints gbc_btnCancellaRigaSelezionata = new GridBagConstraints();
		gbc_btnCancellaRigaSelezionata.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancellaRigaSelezionata.anchor = GridBagConstraints.WEST;
		gbc_btnCancellaRigaSelezionata.gridx = 2;
		gbc_btnCancellaRigaSelezionata.gridy = 1;
		add(btnCancellaRigaSelezionata, gbc_btnCancellaRigaSelezionata);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 50, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblManovreConosciute = new JLabel("Manovre Conosciute:");
		GridBagConstraints gbc_lblManovreConosciute = new GridBagConstraints();
		gbc_lblManovreConosciute.insets = new Insets(0, 0, 5, 5);
		gbc_lblManovreConosciute.anchor = GridBagConstraints.EAST;
		gbc_lblManovreConosciute.gridx = 0;
		gbc_lblManovreConosciute.gridy = 0;
		panel.add(lblManovreConosciute, gbc_lblManovreConosciute);
		
		formattedTextFieldManovreConosciute = new JFormattedTextField(soloNumeri);
		formattedTextFieldManovreConosciute.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldManovreConosciute = new GridBagConstraints();
		gbc_formattedTextFieldManovreConosciute.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldManovreConosciute.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldManovreConosciute.gridx = 1;
		gbc_formattedTextFieldManovreConosciute.gridy = 0;
		panel.add(formattedTextFieldManovreConosciute, gbc_formattedTextFieldManovreConosciute);
		
		lblManovrePronte = new JLabel("Manovre Pronte:");
		GridBagConstraints gbc_lblManovrePronte = new GridBagConstraints();
		gbc_lblManovrePronte.anchor = GridBagConstraints.EAST;
		gbc_lblManovrePronte.insets = new Insets(0, 0, 5, 5);
		gbc_lblManovrePronte.gridx = 0;
		gbc_lblManovrePronte.gridy = 1;
		panel.add(lblManovrePronte, gbc_lblManovrePronte);
		
		formattedTextFieldManovrePronte = new JFormattedTextField(soloNumeri);
		formattedTextFieldManovrePronte.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldManovrePronte = new GridBagConstraints();
		gbc_formattedTextFieldManovrePronte.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextFieldManovrePronte.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldManovrePronte.gridx = 1;
		gbc_formattedTextFieldManovrePronte.gridy = 1;
		panel.add(formattedTextFieldManovrePronte, gbc_formattedTextFieldManovrePronte);
		
		lblStanceConosciute = new JLabel("Stance Conosciute:");
		GridBagConstraints gbc_lblStanceConosciute = new GridBagConstraints();
		gbc_lblStanceConosciute.anchor = GridBagConstraints.EAST;
		gbc_lblStanceConosciute.insets = new Insets(0, 0, 0, 5);
		gbc_lblStanceConosciute.gridx = 0;
		gbc_lblStanceConosciute.gridy = 2;
		panel.add(lblStanceConosciute, gbc_lblStanceConosciute);
		
		formattedTextFieldStanceConosciute = new JFormattedTextField(soloNumeri);
		formattedTextFieldStanceConosciute.addFocusListener(this);
		GridBagConstraints gbc_formattedTextFieldStanceConosciute = new GridBagConstraints();
		gbc_formattedTextFieldStanceConosciute.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldStanceConosciute.gridx = 1;
		gbc_formattedTextFieldStanceConosciute.gridy = 2;
		panel.add(formattedTextFieldStanceConosciute, gbc_formattedTextFieldStanceConosciute);


	}

	public void popolaPanel(PgDatiObj pgDatiObj, OpzioniObj opzioniObj) {

		// Salvataggio dell'oggetto nella classe per giri successivi (chiamati
		// da altri panels)
		this.pgDatiObj = pgDatiObj;
		this.opzioniObj = opzioniObj;
		caricaDimensioniTableManovre(opzioniObj.getDimensioniTablePgManovre());

		// TODO Popolamento scheda "Manovre"
		ArrayList<PgManovreObj> arrayPgManovre = new ArrayList<PgManovreObj>();
		arrayPgManovre = pgDatiObj.getArrayManovre();

		TableModel model = new DefaultTableModel();
		model = tableManovre.getModel();

		int rigaSelezionata = tableManovre.getSelectedRow();
		((DefaultTableModel) tableManovre.getModel()).setRowCount(0);

		for (int i = 0; i < arrayPgManovre.size(); i++) {
			PgManovreObj pgManovreObj = arrayPgManovre.get(i);
			((DefaultTableModel) model).addRow(
					new Object[] { 
							pgManovreObj.getNome(), 
							pgManovreObj.getTipo(), 
							pgManovreObj.getDisciplina(), 
							pgManovreObj.getLvl(), 
							pgManovreObj.isPronta(), 
							pgManovreObj.isDaUsare(), 
							pgManovreObj.getDescrizione(), 
							pgManovreObj.getPrg() 
							});
		}
		if (tableManovre.getRowCount() > 0) {
			if (rigaSelezionata == -1) {

			} else {
				if (tableManovre.getRowCount() > rigaSelezionata) {
					tableManovre.setRowSelectionInterval(rigaSelezionata, rigaSelezionata);
				}
			}
		}

		// Calcolo altezza riga sulla base del contenuto della descrizione
		for (int i=0; i < tableManovre.getRowCount(); i++){
			JTextArea jTextArea = new JTextArea();
			jTextArea.setText(tableManovre.getModel().getValueAt(i, 6).toString());
			//L'altezza base della riga è 16 (almeno da quanto testato). Moltiplichiamo per il numero righe
			int rowHeight = 16 * jTextArea.getLineCount();
			tableManovre.setRowHeight(i, rowHeight);

		}

		formattedTextFieldManovreConosciute.setValue(pgDatiObj.getManovreConosciute());
		formattedTextFieldManovrePronte.setValue(pgDatiObj.getManovrePronte());
		formattedTextFieldStanceConosciute.setValue(pgDatiObj.getStanceConosciute());

	}

	private ArrayList<PgManovreObj> creaArrayManovre() {
		ArrayList<PgManovreObj> arrayManovre = new ArrayList<PgManovreObj>();
		ArrayList<PgManovreObj> arrayManovreOriginale = new ArrayList<PgManovreObj>();

		// Recupero array bonus dal db
		PgDatiObj pgDatiObjTemp = gestioneJsonPg.getPgByFileName(pgDatiObj.getFileName());

		arrayManovreOriginale = pgDatiObjTemp.getArrayManovre();
		for (int i = 0; i < tableManovre.getRowCount(); i++) {
			// Pulizia campi della tabella che sono stati puliti
			if (tableManovre.getModel().getValueAt(i, 3) == null) {
				tableManovre.getModel().setValueAt(0, i, 3);
			}

			// Recupero valorizzo oggetto pgManovreObj con i dati della JTable
			// Attenzione si usa getModel().getValueAt() per recuperare il
			// valore dal modello, visto che se una colonna è rimossa
			// dalla vista con il solo getValueAt() da un valore errato
			PgManovreObj pgManovreObj = new PgManovreObj();
			pgManovreObj.setNome(tableManovre.getValueAt(i, 0).toString());
			pgManovreObj.setTipo(tableManovre.getValueAt(i, 1).toString());
			pgManovreObj.setDisciplina(tableManovre.getValueAt(i, 2).toString());
			pgManovreObj.setLvl(Integer.parseInt(tableManovre.getValueAt(i, 3).toString()));
			pgManovreObj.setPronta((boolean) tableManovre.getValueAt(i, 4));
			pgManovreObj.setDaUsare((boolean) tableManovre.getValueAt(i, 5));
			pgManovreObj.setDescrizione(tableManovre.getValueAt(i, 6).toString());
			pgManovreObj.setPrg(Integer.parseInt(tableManovre.getModel().getValueAt(i, 7).toString()));

			// Se trovo il progressivo della riga che stiamo leggendo nell'array
			// del db e i dati sono variati attiviamo il flag
			for (int i2 = 0; i2 < arrayManovreOriginale.size(); i2++) {
				PgManovreObj pgManovreObjOriginale = arrayManovreOriginale.get(i2);
				if (pgManovreObjOriginale.getPrg() == pgManovreObj.getPrg()) {
					if (pgManovreObj.getNome().equals(pgManovreObjOriginale.getNome())
							&& pgManovreObj.getTipo().equals(pgManovreObjOriginale.getTipo())
							&& pgManovreObj.getDisciplina().equals(pgManovreObjOriginale.getDisciplina())
							&& pgManovreObj.getLvl() == pgManovreObjOriginale.getLvl()
							&& pgManovreObj.isPronta() == pgManovreObjOriginale.isPronta()
							&& pgManovreObj.isDaUsare() == pgManovreObjOriginale.isDaUsare()
							&& pgManovreObj.getDescrizione().equals(pgManovreObjOriginale.getDescrizione())
							) {

					} else {
						pgManovreObj.setDatiVariati(true);
					}
				}
			}
			arrayManovre.add(pgManovreObj);
		}
		return arrayManovre;
	}

	private void inserisciManovra() {

		ArrayList<PgManovreObj> arrayManovre = creaArrayManovre();
		PgManovreObj pgManovreObj = new PgManovreObj();
		if (arrayManovre.size() == 0) {
			pgManovreObj.setPrg(1);
		} else {
			int ultimoRecord = arrayManovre.size() - 1;
			pgManovreObj.setPrg(arrayManovre.get(ultimoRecord).getPrg() + 1);
		}

		GestionePgManovreObjDialog gestionePgManovreObjDialog = new GestionePgManovreObjDialog(ListaGestioneDati.INSERISCI,
				pgDatiObj.getId(), pgManovreObj);
		gestionePgManovreObjDialog.setVisible(true);
		if (gestionePgManovreObjDialog.isRigaGestita()) {
			pgManovreObj = gestionePgManovreObjDialog.getPgManovreObj();
			arrayManovre.add(pgManovreObj);
			pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_MANOVRE, arrayManovre);
		}
		frame.popolaFrame(pgDatiObj);
	}

	private void modificaManovra() {
				
		if (tableManovre.getSelectedRow() != -1) {

			ArrayList<PgManovreObj> arrayManovre = creaArrayManovre();

			GestionePgManovreObjDialog gestionePgManovreObjDialog = new GestionePgManovreObjDialog(ListaGestioneDati.MODIFICA,
					pgDatiObj.getId(), arrayManovre.get(tableManovre.getSelectedRow()));
			gestionePgManovreObjDialog.setVisible(true);
			if (gestionePgManovreObjDialog.isRigaGestita()) {
				PgManovreObj pgManovreObj = gestionePgManovreObjDialog.getPgManovreObj();
				for (int i = 0; i < arrayManovre.size(); i++) {
					if (arrayManovre.get(i).getPrg() == pgManovreObj.getPrg()) {
						arrayManovre.set(i, pgManovreObj);
					}
				}
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_MANOVRE, arrayManovre);
			}
			frame.popolaFrame(pgDatiObj);
		}

	}

	private void cancellaRigaTableManovre() {
		
		if (tableManovre.getSelectedRow() != -1) {
			((DefaultTableModel) tableManovre.getModel()).removeRow(tableManovre.getSelectedRow());

			if (tableManovre.getRowCount() > 0) {
				tableManovre.setRowSelectionInterval(0, 0);
			}
			ArrayList<PgManovreObj> arrayManovre = creaArrayManovre();
			pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj, ListaPgDati.ARRAY_MANOVRE, arrayManovre);
			pgDatiObj.setDatiCommittati(false);
			frame.popolaFrame(pgDatiObj);

		}
	}

	private void caricaDimensioniTableManovre(ArrayList<Integer> arrayDimensioni) {
		if (arrayDimensioni.size() > 0 && tableManovre.getColumnCount() == arrayDimensioni.size()) {
			for (int i = 0; i < tableManovre.getColumnCount(); i++) {
				tableManovre.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			tableManovre.getColumnModel().getColumn(0).setPreferredWidth(200);
			tableManovre.getColumnModel().getColumn(1).setPreferredWidth(80);
			tableManovre.getColumnModel().getColumn(2).setPreferredWidth(90);
			tableManovre.getColumnModel().getColumn(3).setPreferredWidth(75);
			tableManovre.getColumnModel().getColumn(4).setPreferredWidth(60);
			tableManovre.getColumnModel().getColumn(5).setPreferredWidth(60);
			tableManovre.getColumnModel().getColumn(6).setPreferredWidth(300);

		}
	}

	private void salvaDimensioniTableManovre() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableManovre.getColumnCount(); i++) {
			arrayDimensioni.add(tableManovre.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTablePgManovre(arrayDimensioni);
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
		
		if (component instanceof JFormattedTextField) {
			if ((JFormattedTextField) component == formattedTextFieldManovreConosciute) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.MANOVRE_CONOSCIUTE,
						formattedTextFieldManovreConosciute.getText());
			}
			if ((JFormattedTextField) component == formattedTextFieldManovrePronte) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.MANOVRE_PRONTE,
						formattedTextFieldManovrePronte.getText());
			}
			if ((JFormattedTextField) component == formattedTextFieldStanceConosciute) {
				pgDatiObj = aggiornaOggetti.aggiornaPgDatiObj(pgDatiObj,
						ListaPgDati.STANCE_CONOSCIUTE,
						formattedTextFieldStanceConosciute.getText());
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == btnInserisciManovra.getActionCommand()) {
				inserisciManovra();
			}
			if (((JButton) oggetto).getActionCommand() == btnCancellaRigaSelezionata.getActionCommand()) {
				cancellaRigaTableManovre();
			}
			if (((JButton) oggetto).getActionCommand() == btnModificaManovra.getActionCommand()) {
				modificaManovra();
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
			if ((JTable) component == tableManovre) {
				if (e.getClickCount() == 2 && tableManovre.getSelectedRow() != -1) {
					modificaManovra();
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTableHeader) {
			if ((JTableHeader) component == tableManovre.getTableHeader()) {
				salvaDimensioniTableManovre();
			}
		}		
	}

}
