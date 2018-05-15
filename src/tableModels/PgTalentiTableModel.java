package tableModels;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class PgTalentiTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5814766138807624024L;

	public PgTalentiTableModel() {
		super(new String[] { 
				"Talento", // 0 String
				"Descrizione", // 1 String
				"#" // 2 int
		}, 0);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class classe = String.class;
		switch (columnIndex) {
		case 2:
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
