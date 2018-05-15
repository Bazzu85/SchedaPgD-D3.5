package tableModels;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class PgLingueTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5814766138807624024L;

	public PgLingueTableModel() {
		super(new String[] { 
				"Punti Abilità", // 0 Integer
				"Lingua Parlata", // 1 String
				"Alfabeto", // 2 String
				"#" // 3 int
		}, 0);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class classe = String.class;
		switch (columnIndex) {
		case 0:
			classe = Integer.class;
			break;
		case 3:
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

	}

}
