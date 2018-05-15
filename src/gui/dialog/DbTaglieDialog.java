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
import formatRenderer.DecimalWithSignFormatRenderer;
import json.GestioneJsonItems;
import json.GestioneJsonOpzioni;
import obj.DbTaglieObj;
import obj.OpzioniObj;
import tableModels.DbTaglieTableModel;

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

public class DbTaglieDialog extends JDialog implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9092547912179361341L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableTaglie;
	GestioneJsonItems gestioneJsonItems = new GestioneJsonItems();
	GestioneJsonOpzioni gestioneJsonOpzioni = new GestioneJsonOpzioni();
	OpzioniObj opzioniObj = new OpzioniObj();
	AggiornaOggetti aggiornaOggetti = new AggiornaOggetti();
	ArrayList<DbTaglieObj> arrayTaglie = new ArrayList<DbTaglieObj>();
	boolean result = false;

	private JButton btnInserisciTaglia;
	private JButton btnModificaTaglia;
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
			DbTaglieDialog dialog = new DbTaglieDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DbTaglieDialog() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				salvaDimensioniFinestra();
				setVisible(false);
			}
		});
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Gestione Taglie");
		setBounds(100, 100, 594, 300);
		if (opzioniObj.getDbTaglieDialogX() > 0 && opzioniObj.getDbTaglieDialogY() > 0
				&& opzioniObj.getDbTaglieDialogWidth() > 0 && opzioniObj.getDbTaglieDialogHeight() > 0) {
			setBounds(opzioniObj.getDbTaglieDialogX(), opzioniObj.getDbTaglieDialogY(),
					opzioniObj.getDbTaglieDialogWidth(), opzioniObj.getDbTaglieDialogHeight());
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
				tableTaglie = new JTable();
				tableTaglie.addMouseListener(this);
				tableTaglie.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				DbTaglieTableModel armiTableModel = new DbTaglieTableModel();
				tableTaglie.setModel(armiTableModel);
				tableTaglie.getColumnModel().getColumn(1).setCellRenderer(new DecimalWithSignFormatRenderer());
				tableTaglie.getColumnModel().getColumn(2).setCellRenderer(new DecimalWithSignFormatRenderer());
				TableColumnModel tcm = tableTaglie.getColumnModel();
				tcm.removeColumn(tcm.getColumn(4));
				tcm.removeColumn(tcm.getColumn(3));
				tableTaglie.getTableHeader().addMouseListener(this);
				tableTaglie.getTableHeader().setReorderingAllowed(false);

				scrollPane.setViewportView(tableTaglie);
			}
		}
		{
			btnInserisciTaglia = new JButton("Inserisci Taglia");
			btnInserisciTaglia.addActionListener(this);
			GridBagConstraints gbc_btnInserisciTaglia = new GridBagConstraints();
			gbc_btnInserisciTaglia.anchor = GridBagConstraints.WEST;
			gbc_btnInserisciTaglia.insets = new Insets(0, 0, 0, 5);
			gbc_btnInserisciTaglia.gridx = 0;
			gbc_btnInserisciTaglia.gridy = 1;
			contentPanel.add(btnInserisciTaglia, gbc_btnInserisciTaglia);
		}
		{
			btnModificaTaglia = new JButton("Modifica Taglia");
			btnModificaTaglia.addActionListener(this);
			GridBagConstraints gbc_btnModificaTaglia = new GridBagConstraints();
			gbc_btnModificaTaglia.insets = new Insets(0, 0, 0, 5);
			gbc_btnModificaTaglia.gridx = 1;
			gbc_btnModificaTaglia.gridy = 1;
			contentPanel.add(btnModificaTaglia, gbc_btnModificaTaglia);
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
		caricaDimensioniTableTaglie(opzioniObj.getDimensioniTableDbTaglie());

		if (!Beans.isDesignTime()) {
			arrayTaglie = gestioneJsonItems.getListaTaglie();

			caricaTabella(arrayTaglie);
		}
	}

	private void caricaTabella(ArrayList<DbTaglieObj> arrayTaglie) {
		TableModel model = new DefaultTableModel();
		model = tableTaglie.getModel();

		// Pulizia tabella
		((DefaultTableModel) model).setRowCount(0);

		for (int i = 0; i < arrayTaglie.size(); i++) {
			DbTaglieObj dbTaglieObj = arrayTaglie.get(i);
			((DefaultTableModel) model).addRow(new Object[] { dbTaglieObj.getNome(), dbTaglieObj.getModTaglia(),
					dbTaglieObj.getModTagliaSpeciale(), dbTaglieObj.isRigaBloccata(), dbTaglieObj.getPrg() });
		}

	}

	private ArrayList<DbTaglieObj> creaArrayTaglie() {
		ArrayList<DbTaglieObj> arrayTaglie = new ArrayList<DbTaglieObj>();
	
		for (int i = 0; i < tableTaglie.getRowCount(); i++) {
			if (!tableTaglie.getValueAt(i, 0).toString().trim().isEmpty()) {
				DbTaglieObj dbTaglieObj = new DbTaglieObj();
	
				dbTaglieObj.setNome(tableTaglie.getValueAt(i, 0).toString());
				dbTaglieObj.setModTaglia(Integer.parseInt(tableTaglie.getValueAt(i, 1).toString()));
				dbTaglieObj.setModTagliaSpeciale(Integer.parseInt(tableTaglie.getValueAt(i, 2).toString()));
				dbTaglieObj.setRigaBloccata((boolean) tableTaglie.getModel().getValueAt(i, 3));
				dbTaglieObj.setPrg(Integer.parseInt(tableTaglie.getModel().getValueAt(i, 4).toString()));
				arrayTaglie.add(dbTaglieObj);
			}
		}
		return arrayTaglie;
	}

	private void inserisciTaglia() {
		
		ArrayList<DbTaglieObj> arrayTaglie = creaArrayTaglie();
		DbTaglieObj dbTaglieObj = new DbTaglieObj();

		GestioneDbTaglieObjDialog gestioneDbTaglieObjDialog = new GestioneDbTaglieObjDialog(ListaGestioneDati.INSERISCI,
				dbTaglieObj, arrayTaglie);
		gestioneDbTaglieObjDialog.setVisible(true);
		if (gestioneDbTaglieObjDialog.isRigaGestita()) {
			dbTaglieObj = gestioneDbTaglieObjDialog.getDbTaglieObj();
			arrayTaglie.add(dbTaglieObj);
		}
		caricaTabella(arrayTaglie);	
	}

	private void modificaTaglia() {

		if (tableTaglie.getSelectedRow() != -1) {
			ArrayList<DbTaglieObj> arrayTaglie = creaArrayTaglie();
			DbTaglieObj dbTaglieObj = arrayTaglie.get(tableTaglie.getSelectedRow());
			if (!dbTaglieObj.isRigaBloccata()){

				GestioneDbTaglieObjDialog gestioneDbTaglieObjDialog = new GestioneDbTaglieObjDialog(ListaGestioneDati.MODIFICA,
						dbTaglieObj, arrayTaglie);
				gestioneDbTaglieObjDialog.setVisible(true);
				if (gestioneDbTaglieObjDialog.isRigaGestita()) {
					dbTaglieObj = gestioneDbTaglieObjDialog.getDbTaglieObj();
					for (int i = 0; i < arrayTaglie.size(); i++) {
						if (arrayTaglie.get(i).getPrg() == dbTaglieObj.getPrg()) {
							arrayTaglie.set(i, dbTaglieObj);
						}
					}
				}
			caricaTabella(arrayTaglie);	
			}
		}
	}

	private void cancellaRiga() {

		if (tableTaglie.getSelectedRow() != -1) {
			ArrayList<DbTaglieObj> arrayTaglie = creaArrayTaglie();
			DbTaglieObj dbTaglieObj = arrayTaglie.get(tableTaglie.getSelectedRow());
			if (!dbTaglieObj.isRigaBloccata()){
				((DefaultTableModel) tableTaglie.getModel()).removeRow(tableTaglie.getSelectedRow());

				if (tableTaglie.getRowCount() > 0) {
					tableTaglie.setRowSelectionInterval(0, 0);
				}
			}
		}
	}

	private void salvaDimensioniFinestra() {
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		Rectangle dimensioniFinestra = this.getBounds();

		opzioniObj.setDbTaglieDialogX(dimensioniFinestra.x);
		opzioniObj.setDbTaglieDialogY(dimensioniFinestra.y);
		opzioniObj.setDbTaglieDialogWidth(dimensioniFinestra.width);
		opzioniObj.setDbTaglieDialogHeight(dimensioniFinestra.height);

		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);

	}

	private void caricaDimensioniTableTaglie(ArrayList<Integer> arrayDimensioni) {
		if (arrayDimensioni.size() > 0 && tableTaglie.getColumnCount() == arrayDimensioni.size()) {
			for (int i = 0; i < tableTaglie.getColumnCount(); i++) {
				tableTaglie.getColumnModel().getColumn(i).setPreferredWidth(arrayDimensioni.get(i));
			}
		} else {
			// tableTaglie.getColumnModel().getColumn(0).setPreferredWidth(300);

		}
	}

	private void salvaDimensioniTableTaglie() {
		ArrayList<Integer> arrayDimensioni = new ArrayList<Integer>();
		for (int i = 0; i < tableTaglie.getColumnCount(); i++) {
			arrayDimensioni.add(tableTaglie.getColumnModel().getColumn(i).getWidth());
		}
		opzioniObj = gestioneJsonOpzioni.getOpzioniObj();
		opzioniObj.setDimensioniTableDbTaglie(arrayDimensioni);
		gestioneJsonOpzioni.salvaOpzioniObj(opzioniObj);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object oggetto = e.getSource();

		if (oggetto instanceof JButton) {
			if (((JButton) oggetto).getActionCommand() == btnInserisciTaglia.getActionCommand()) {
				inserisciTaglia();
			}
			if (((JButton) oggetto).getActionCommand() == btnModificaTaglia.getActionCommand()) {
				modificaTaglia();
			}
			if (((JButton) oggetto).getActionCommand() == btnCancellaRigaSelezionata.getActionCommand()) {
				cancellaRiga();
			}
			if (((JButton) oggetto).getActionCommand() == okButton.getActionCommand()) {
				ArrayList<DbTaglieObj> arrayTaglie = creaArrayTaglie();
				result = gestioneJsonItems.aggiornaTaglie(arrayTaglie);
				if (result) {
					setVisible(false);
				}			}
			if (((JButton) oggetto).getActionCommand() == cancelButton.getActionCommand()) {
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
			if ((JTable) component == tableTaglie) {
				if (e.getClickCount() == 2 && tableTaglie.getSelectedRow() != -1) {
					modificaTaglia();
				}
			}
		}
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Component component = e.getComponent();
		if (component instanceof JTableHeader) {
			if ((JTableHeader) component == tableTaglie.getTableHeader()) {
				salvaDimensioniTableTaglie();
			}
		}		
	}

}
