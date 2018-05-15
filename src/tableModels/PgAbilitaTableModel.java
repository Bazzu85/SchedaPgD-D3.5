package tableModels;

import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.MouseEvent;
public class PgAbilitaTableModel extends DefaultTableModel {

	public PgAbilitaTableModel() {
		super(new String[] { 
				"C", // 0 Boolean
				"Ci", // 1 Boolean
				"Abilità", // 2 String
				"<html>Caratteristica<br>Chiave</html>", //3 String
				"Totale", // 4 Integer
				"Caratteristica", // 5 Integer
				"Grado", // 6 Integer
				"Altro", // 7 Integer
				"Bonus", // 8 Integer
				"<html>Richiede<br>Addestramento</html>", // 9 Boolean
				"Prg" // 10 Integer
		}, 0);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class classe = String.class;
		switch (columnIndex) {
		case 0:
			classe = Boolean.class;
			break;
		case 1:
			classe = Boolean.class;
			break;
		case 4:
			classe = Integer.class;
			break;
		case 5:
			classe = Integer.class;
			break;
		case 6:
			classe = Integer.class;
			break;
		case 7:
			classe = Integer.class;
			break;
		case 8:
			classe = Integer.class;
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

//		if (column == 0){
//			return true;
//		}
//		if (column == 1){
//			return true;
//		}
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
