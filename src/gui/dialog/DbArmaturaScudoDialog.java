package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Beans;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import ENUM.ListaGestioneDati;
import formatRenderer.DecimalWithSignFormatRenderer;
import formatRenderer.MetriFormatRenderer;
import formatRenderer.PercentageFormatRenderer;
import formatRenderer.PesoFormatRenderer;
import json.GestioneJsonItems;
import json.GestioneJsonOpzioni;
import obj.DbArmaturaScudoObj;
import obj.OpzioniObj;
import tableModels.DbArmaturaScudoTableModel;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DbArmaturaScudoDialog extends JDialog implements ActionListener, FocusListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 563770744196720858L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableArmatureScudi;
	static DbArmaturaScudoDialog dialog;
	GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo = new ArrayList<DbArmaturaScudoObj>();
	OpzioniObj opzioniObj = new OpzioniObj();
	boolean result = false;
	JButton btnCancellaRigaSelezionata;
	JButton okButton;
	JButton cancelButton;
	private JButton btnInsericiArmaturaScudo;
	private JButton btnModificaArmaturaScudo;

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
			dialog = new DbArmaturaScudoDialog();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Metodo " + new Object() {
			}.getClass().getEnclosingMethod().getName() + " in " + new Object() {
			}.getClass().getEnclosingClass().getName() + ": errore:" + e.getMessage());
		}
	}

	/**
	 * Create the dialog.
	 */
	public DbArmaturaScudoDialog() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				salvaDimensioniFinestra();
				setVisible(false);
			}
		});

		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();

		setTitle("Gestione Armature e Scudi");
		setBounds(100, 100, 1314, 703);
		if (opzioniObj.getDbArmaturaScudoDialogX() > 0 && opzioniObj.getDbArmaturaScudoDialogY() > 0
				&& opzioniObj.getDbArmaturaScudoDialogWidth() > 0 && opzioniObj.getDbArmaturaScudoDialogHeight() > 0) {
			setBounds(opzioniObj.getDbArmaturaScudoDialogX(), opzioniObj.getDbArmaturaScudoDialogY(),
					opzioniObj.getDbArmaturaScudoDialogWidth(), opzioniObj.getDbArmaturaScudoDialogHeight());
		}
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridwidth = 4;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				tableArmatureScudi = new JTable();
				tableArmatureScudi.addMouseListener(this);
				tableArmatureScudi.addFocusListener(this);
				tableArmatureScudi.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				tableArmatureScudi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				DbArmaturaScudoTableModel armaturaScudoTableModel = new DbArmaturaScudoTableModel();
				tableArmatureScudi.setModel(armaturaScudoTableModel);
				tableArmatureScudi.getColumnModel().getColumn(5).setCellRenderer(new DecimalWithSignFormatRenderer());
				tableArmatureScudi.getColumnModel().getColumn(6).setCellRenderer(new DecimalWithSignFormatRenderer());
				tableArmatureScudi.getColumnModel().getColumn(7).setCellRenderer(new DecimalWithSignFormatRenderer());
				tableArmatureScudi.getColumnModel().getColumn(8).setCellRenderer(new PercentageFormatRenderer());
				tableArmatureScudi.getColumnModel().getColumn(9).setCellRenderer(new MetriFormatRenderer());
				tableArmatureScudi.getColumnModel().getColumn(10).setCellRenderer(new MetriFormatRenderer());
				tableArmatureScudi.getColumnModel().getColumn(11).setCellRenderer(new PesoFormatRenderer());
				TableColumnModel tcm = tableArmatureScudi.getColumnModel();
				tcm.removeColumn(tcm.getColumn(13));
				tcm.removeColumn(tcm.getColumn(12));
				tableArmatureScudi.setAutoCreateRowSorter(true);
				tableArmatureScudi.getTableHeader().setReorderingAllowed(false);
				tableArmatureScudi.getTableHeader().addMouseListener(this);


				scrollPane.setViewportView(tableArmatureScudi);
			}
		}
		{
			btnCancellaRigaSelezionata = new JButton("Cancella Riga Selezionata");
			btnCancellaRigaSelezionata.addActionListener(this);
			{
				btnInsericiArmaturaScudo = new JButton("Inserici Arma/Scudo");
				btnInsericiArmaturaScudo.addActionListener(this);
				GridBagConstraints gbc_btnInsericiArmaturaScudo = new GridBagConstraints();
				gbc_btnInsericiArmaturaScudo.insets = new Insets(0, 0, 0, 5);
				gbc_btnInsericiArmaturaScudo.gridx = 1;
				gbc_btnInsericiArmaturaScudo.gridy = 1;
				contentPanel.add(btnInsericiArmaturaScudo, gbc_btnInsericiArmaturaScudo);
			}
			{
				btnModificaArmaturaScudo = new JButton("Modifica Armatura/Scudo");
				btnModificaArmaturaScudo.addActionListener(this);
				GridBagConstraints gbc_btnModificaArmaturaScudo = new GridBagConstraints();
				gbc_btnModificaArmaturaScudo.insets = new Insets(0, 0, 0, 5);
				gbc_btnModificaArmaturaScudo.gridx = 2;
				gbc_btnModificaArmaturaScudo.gridy = 1;
				contentPanel.add(btnModificaArmaturaScudo, gbc_btnModificaArmaturaScudo);
			}
			GridBagConstraints gbc_btnCancellaRigaSelezionata = new GridBagConstraints();
			gbc_btnCancellaRigaSelezionata.gridx = 3;
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
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		caricaDimensioniTableArmatureScudi(opzioniObj.getDimensioniTableDbArmatureScudi());

		if (!Beans.isDesignTime()) {
			arrayArmaturaScudo = gestioneJsonItems.getListaArmaturaScudo();

			caricaTabella(arrayArmaturaScudo);
		}
	}

	private void caricaTabella(ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo) {
		TableModel model = new DefaultTableModel();
		model = tableArmatureScudi.getModel();

		// Pulizia tabella
		((DefaultTableModel) model).setRowCount(0);

		for (int i = 0; i < arrayArmaturaScudo.size(); i++) {
			DbArmaturaScudoObj dbArmaturaScudoObj = new DbArmaturaScudoObj();
			dbArmaturaScudoObj = arrayArmaturaScudo.get(i);
			if (dbArmaturaScudoObj.getPrg() == 0) {
				dbArmaturaScudoObj.setPrg(i + 1);
			}

			((DefaultTableModel) model).addRow(new Object[] { dbArmaturaScudoObj.getNome(), dbArmaturaScudoObj.getCategoria(),
					dbArmaturaScudoObj.isArmatura(), dbArmaturaScudoObj.isScudo(), dbArmaturaScudoObj.getCosto(),
					dbArmaturaScudoObj.getBonus(), dbArmaturaScudoObj.getBonusDesMax(),
					dbArmaturaScudoObj.getPenalitaProvaArmatura(), dbArmaturaScudoObj.getFallimentoIncantesimiArcani(),
					dbArmaturaScudoObj.getVelocita9M(), dbArmaturaScudoObj.getVelocita6M(),
					dbArmaturaScudoObj.getPeso(), dbArmaturaScudoObj.isRigaBloccata(), dbArmaturaScudoObj.getPrg() });
		}

	}

	protected ArrayList<DbArmaturaScudoObj> creaArrayArmaturaScudo() {
		ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo = new ArrayList<DbArmaturaScudoObj>();
	
		for (int i = 0; i < tableArmatureScudi.getRowCount(); i++) {
			if (!tableArmatureScudi.getValueAt(i, 0).toString().trim().isEmpty()) {
				DbArmaturaScudoObj armaturaScudoObj = new DbArmaturaScudoObj();
	
				// Pulizia campi della tabella che sono stati puliti
				if (tableArmatureScudi.getValueAt(i, 5) == null) {
					tableArmatureScudi.setValueAt(0, i, 5);
				}
				if (tableArmatureScudi.getValueAt(i, 6) == null) {
					tableArmatureScudi.setValueAt(0, i, 6);
				}
				if (tableArmatureScudi.getValueAt(i, 7) == null) {
					tableArmatureScudi.setValueAt(0, i, 7);
				}
				if (tableArmatureScudi.getValueAt(i, 8) == null) {
					tableArmatureScudi.setValueAt(0, i, 8);
				}
				if (tableArmatureScudi.getValueAt(i, 9) == null) {
					tableArmatureScudi.setValueAt(0, i, 9);
				}
				if (tableArmatureScudi.getValueAt(i, 10) == null) {
					tableArmatureScudi.setValueAt(0, i, 10);
				}
				if (tableArmatureScudi.getValueAt(i, 11) == null) {
					tableArmatureScudi.setValueAt(0, i, 11);
				}
	
				armaturaScudoObj.setNome(tableArmatureScudi.getValueAt(i, 0).toString());
				armaturaScudoObj.setCategoria(tableArmatureScudi.getValueAt(i, 1).toString());
				armaturaScudoObj.setArmatura((boolean) tableArmatureScudi.getValueAt(i, 2));
				armaturaScudoObj.setScudo((boolean) tableArmatureScudi.getValueAt(i, 3));
				armaturaScudoObj.setCosto(tableArmatureScudi.getValueAt(i, 4).toString());
				armaturaScudoObj.setBonus(Integer.parseInt(tableArmatureScudi.getValueAt(i, 5).toString()));
				armaturaScudoObj.setBonusDesMax(Integer.parseInt(tableArmatureScudi.getValueAt(i, 6).toString()));
				armaturaScudoObj
						.setPenalitaProvaArmatura(Integer.parseInt(tableArmatureScudi.getValueAt(i, 7).toString()));
				armaturaScudoObj.setFallimentoIncantesimiArcani(
						Integer.parseInt(tableArmatureScudi.getValueAt(i, 8).toString()));
				armaturaScudoObj.setVelocita9M(Double.parseDouble(tableArmatureScudi.getValueAt(i, 9).toString()));
				armaturaScudoObj.setVelocita6M(Double.parseDouble(tableArmatureScudi.getValueAt(i, 10).toString()));
				armaturaScudoObj.setPeso(Double.parseDouble(tableArmatureScudi.getValueAt(i, 11).toString()));
				armaturaScudoObj.setRigaBloccata((boolean) tableArmatureScudi.getModel().getValueAt(i, 12));
				armaturaScudoObj.setPrg(Integer.parseInt(tableArmatureScudi.getModel().getValueAt(i, 13).toString()));
				arrayArmaturaScudo.add(armaturaScudoObj);
			}
		}
		return arrayArmaturaScudo;
	}

	private void inserisciArmaturaScudo() {
		ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo = creaArrayArmaturaScudo();
		DbArmaturaScudoObj dbArmaturaScudoObj = new DbArmaturaScudoObj();

		if (arrayArmaturaScudo.size() == 0) {
			dbArmaturaScudoObj.setPrg(1);
		} else {
			int ultimoRecord = arrayArmaturaScudo.size() - 1;
			dbArmaturaScudoObj.setPrg(arrayArmaturaScudo.get(ultimoRecord).getPrg() + 1);
		}

		GestioneDbArmaturaScudoObjDialog gestioneDbArmaturaScudoObjDialog = new GestioneDbArmaturaScudoObjDialog(
				ListaGestioneDati.INSERISCI, dbArmaturaScudoObj, arrayArmaturaScudo);
		gestioneDbArmaturaScudoObjDialog.setVisible(true);
		if (gestioneDbArmaturaScudoObjDialog.isRigaGestita()) {
			dbArmaturaScudoObj = gestioneDbArmaturaScudoObjDialog.getDbArmaturaScudoObj();
			arrayArmaturaScudo.add(dbArmaturaScudoObj);
		}

		caricaTabella(arrayArmaturaScudo);
	}

	private void modificaArmaturaScudo() {

		if (tableArmatureScudi.getSelectedRow() != -1) {
			ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo = creaArrayArmaturaScudo();
			DbArmaturaScudoObj dbArmaturaScudoObj = arrayArmaturaScudo.get(tableArmatureScudi.getSelectedRow());
			if (!dbArmaturaScudoObj.isRigaBloccata()) {

				GestioneDbArmaturaScudoObjDialog gestioneDbArmaturaScudoObjDialog = new GestioneDbArmaturaScudoObjDialog(
						ListaGestioneDati.MODIFICA, dbArmaturaScudoObj, arrayArmaturaScudo);
				gestioneDbArmaturaScudoObjDialog.setVisible(true);
				if (gestioneDbArmaturaScudoObjDialog.isRigaGestita()) {
					dbArmaturaScudoObj = gestioneDbArmaturaScudoObjDialog.getDbArmaturaScudoObj();
					for (int i = 0; i < arrayArmaturaScudo.size(); i++) {
						if (arrayArmaturaScudo.get(i).getPrg() == dbArmaturaScudoObj.getPrg()) {
							arrayArmaturaScudo.set(i, dbArmaturaScudoObj);
						}
					}
				}
				caricaTabella(arrayArmaturaScudo);
			}
		}
	}

	private void cancellaRiga() {

		if (tableArmatureScudi.getSelectedRow() != -1) {
			ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo = creaArrayArmaturaScudo();
			DbArmaturaScudoObj dbArmaturaScudoObj = arrayArmaturaScudo.get(tableArmatureScudi.getSelectedRow());
			if (!dbArmaturaScudoObj.isRigaBloccata()) {
				((DefaultTableModel) tableArmatureScudi.getModel()).removeRow(tableArmatureScudi.getSelectedRow());

				if (tableArmatureScudi.getRowCount() > 0) {
					tableArmatureScudi.setRowSelectionInterval(0, 0);
				}
			}
		}
	}

	private void salvaDimensioniFinestra() {
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		Rectangle dimensioniFinestra = this.getBounds();

		opzioniObj.setDbArmaturaScudoDialogX(dimensioniFinestra.x);
		opzioniObj.setDbArmaturaScudoDialogY(dimensioniFinestra.y);
		opzioniObj.setDbArmaturaScudoDialogWidth(dimensioniFinestra.width);
		opzioniObj.setDbArmaturaScudoDialogHeight(dimensioniFinestra.height);

		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);

	}
	
	private void caricaDimensioniTableArmatureScudi(ArrayList<Integer> arrayDimensioni) {
		if (arrayDimensioni.size() > 0 && tableArmatureScudi.getColumnCount() == arrayDimensioni.size()) {
			for (int i = 0; i < tableArmatureScudi.getColumnCount(); i++) {
//				if (i < arrayDimensioni.size()){
					tableArmatureScudi.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
//				}
			}
		} else {
			tableArmatureScudi.getColumnModel().getColumn(0).setPreferredWidth(200);
			tableArmatureScudi.getColumnModel().getColumn(1).setPreferredWidth(100);
			tableArmatureScudi.getColumnModel().getColumn(2).setPreferredWidth(75);
			tableArmatureScudi.getColumnModel().getColumn(3).setPreferredWidth(50);
			tableArmatureScudi.getColumnModel().getColumn(4).setPreferredWidth(50);
			tableArmatureScudi.getColumnModel().getColumn(5).setPreferredWidth(50);
			tableArmatureScudi.getColumnModel().getColumn(6).setPreferredWidth(120);
			tableArmatureScudi.getColumnModel().getColumn(7).setPreferredWidth(75);
			tableArmatureScudi.getColumnModel().getColumn(8).setPreferredWidth(150);
			tableArmatureScudi.getColumnModel().getColumn(9).setPreferredWidth(60);
			tableArmatureScudi.getColumnModel().getColumn(10).setPreferredWidth(50);
			tableArmatureScudi.getColumnModel().getColumn(11).setPreferredWidth(60);

		}		
	}
	private void salvaDimensioniTableArmatureScudi() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableArmatureScudi.getColumnCount(); i++) {
			arrayDimensioni.add(tableArmatureScudi.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTableDbArmatureScudi(arrayDimensioni);
		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();
		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == btnCancellaRigaSelezionata.getActionCommand()) {
				cancellaRiga();
			}
			if (((JButton) oggetto).getActionCommand() == btnInsericiArmaturaScudo.getActionCommand()) {
				inserisciArmaturaScudo();
			}
			if (((JButton) oggetto).getActionCommand() == btnModificaArmaturaScudo.getActionCommand()) {
				modificaArmaturaScudo();
			}
			if (((JButton) oggetto).getActionCommand() == okButton.getActionCommand()) {
				salvaDimensioniFinestra();
				ArrayList<DbArmaturaScudoObj> arrayArmaturaScudo = creaArrayArmaturaScudo();
				result = gestioneJsonItems.aggiornaArmaturaScudo(arrayArmaturaScudo);
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
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent e) {
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
			if ((JTable) component == tableArmatureScudi) {
				if (e.getClickCount() == 2 && tableArmatureScudi.getSelectedRow() != -1) {
					modificaArmaturaScudo();
				}
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTableHeader) {
			if ((JTableHeader) component == tableArmatureScudi.getTableHeader()) {
				salvaDimensioniTableArmatureScudi();
			}
		}		
	}

}
