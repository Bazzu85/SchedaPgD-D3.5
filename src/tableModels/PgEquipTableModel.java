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
				"Peso Unitario", // 1 Double
				"Valore Unitario", // 2 Double
				"Numero", // 3 Integer
				"Peso", // 4 Double
				"Valore", // 5 Double
				"Indossato", // 6 Boolean
				"Zaino", // 7 Boolean
				"<html>Tasca da<br>Cintura</html>", // 8 Boolean
				"Altro", // 9 Boolean
				"#" // 10 Integer
		}, 0);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class classe = String.class;
		switch (columnIndex) {
		case 1:
			classe = Double.class;
			break;
		case 2:
			classe = Double.class;
			break;
		case 3:
			classe = Integer.class;
			break;
		case 4:
			classe = Double.class;
			break;
		case 5:
			classe = Double.class;
			break;
		case 6:
			classe = Boolean.class;
			break;
		case 7:
			classe = Boolean.class;
			break;
		case 8:
			classe = Boolean.class;
			break;
		case 9:
			classe = Boolean.class;
			break;
		case 10:
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
