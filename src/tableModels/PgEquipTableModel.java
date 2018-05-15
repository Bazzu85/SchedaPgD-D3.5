package tableModels;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class PgEquipTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5814766138807624024L;

	public PgEquipTableModel() {
		super(new String[] { "Nome", // 0 String
				"Numero", // 1 Integer
				"Peso", // 2 Double
				"Indossato", // 3 Boolean
				"Zaino", // 4 Boolean
				"<html>Tasca da<br>Cintura</html>", // 5 Boolean
				"Altro", // 6 Boolean
				"#" // 7 Integer
		}, 0);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class classe = String.class;
		switch (columnIndex) {
		case 1:
			classe = Integer.class;
			break;
		case 2:
			classe = Double.class;
			break;
		case 3:
			classe = Boolean.class;
			break;
		case 4:
			classe = Boolean.class;
			break;
		case 5:
			classe = Boolean.class;
			break;
		case 6:
			classe = Boolean.class;
			break;
		case 7:
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
		if (valore instanceof Double) {
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
