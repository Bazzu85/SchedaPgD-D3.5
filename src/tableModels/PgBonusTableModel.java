package tableModels;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class PgBonusTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5814766138807624024L;

	public PgBonusTableModel() {
		super(new String[] { 
				"Bonus", // 0 String
				"Modificatore", // 1 Integer
				"Descrizione", // 2 String
				"Bonus Abilitato", // 3 Boolean
				"#" // 4 int
		}, 0);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class classe = String.class;
		switch (columnIndex) {
		case 0:
			classe = JComboBox.class;
			break;
		case 1:
			classe = Integer.class;
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
		if (column == 3){
			return true;
		}
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
