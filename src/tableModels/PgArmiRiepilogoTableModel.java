package tableModels;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PgArmiRiepilogoTableModel extends DefaultTableModel {

	public PgArmiRiepilogoTableModel() {
		super(new String[] { 
				"Arma", // 0 String
				"BAT Singolo Attacco", // 1 String
				"BAT Doppio Attacco", // 2 String
				"Incr. Gittata", // 3 String
				"Critico", // 4 String
				"Danno Totale", // 5 String
				"Tipo", // 6 String
		}, 0);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class classe = String.class;
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
	}

}
