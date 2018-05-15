package tableModels;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DbAbilitaTableModel extends DefaultTableModel {

	public DbAbilitaTableModel() {
		super(new String[] { "Abilità", // 0 String
				"Richiede Addestramento", // 1 Boolean
				"Caratteristica chiave", // 2 String
				"Riga Bloccata", // 3 Boolean
				"Prg" // 4 Integer
		}, 0);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class classe = String.class;
		switch (columnIndex) {
		case 1:
			classe = Boolean.class;
			break;
		case 3:
			classe = Boolean.class;
			break;
		case 4:
			classe = Integer.class;
			break;
		}
		return classe;
	}

	@Override
	public boolean isCellEditable(int row, int column) {

		return false;
	}

	@Override
	public void setValueAt(Object valore, int row, int column) {
		if (valore instanceof String) {
			Vector rowData = (Vector) getDataVector().get(row);
			rowData.set(column, valore);
			fireTableCellUpdated(row, column);
		}
		if (valore instanceof Integer) {
			Vector rowData = (Vector) getDataVector().get(row);
			rowData.set(column, valore);
			fireTableCellUpdated(row, column);
		}
		if (valore instanceof Boolean) {
			Vector rowData = (Vector) getDataVector().get(row);
			rowData.set(column, (boolean) valore);
			fireTableCellUpdated(row, column);
		}
	}

}
