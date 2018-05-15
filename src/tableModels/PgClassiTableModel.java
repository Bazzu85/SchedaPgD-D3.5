package tableModels;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class PgClassiTableModel extends DefaultTableModel {

	public PgClassiTableModel() {
		super(new String[] { 
				"Classe", 				//0 String
				"Livello Classe", 		//1 Integer
				"Dado Vita", 			//2 String
				"Punti Ferita", 		//3 Integer
				"Classe di Prestigio",	//4 Boolean
				"Bonus Attacco Classe",	//5 Integer
				"#"						//6 Integer
				}, 0);
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class classe = String.class;
		switch (columnIndex) {
		case 1:
			classe = Integer.class;
			break;
		case 3:
			classe = Integer.class;
			break;
		case 4:
			classe = Boolean.class;
			break;
		case 5:
			classe = Integer.class;
			break;
		case 6:
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
