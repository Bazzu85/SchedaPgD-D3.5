package tableModels;

import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.MouseEvent;
public class PgArmiTableModel extends DefaultTableModel {

	public PgArmiTableModel() {
		super(new String[] { 
				"Arma", // 0 String
				"Taglia", // 1 String
				"Qualità", // 2 String
				"Mod.", // 3 Integer
				"Incantamenti", // 4 String
				"<html>Bonus<br>Incantamenti</html>", // 5 String
				"Mod. al BAB", // 6 Integer
				"<html>Mod. al<br>Danno</html>", // 7 Integer
				"<html>Tenuta a<br>2 Mani</html>", // 8 Boolean
				"Doppia Arma", // 9 Boolean
				"<html>Primaria<br>Secondaria</html>", // 10 String
				"Equipaggiata", // 11 Boolean
				"Mod BAB Descrizione", //12 String
				"Mod Danno Descrizione", //13 String
				"Prg" // 14 Integer
		}, 0);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class classe = String.class;
		switch (columnIndex) {
		case 3:
			classe = Integer.class;
			break;
		case 6:
			classe = Integer.class;
			break;
		case 7:
			classe = Integer.class;
			break;
		case 8:
			classe = Boolean.class;
			break;
		case 9:
			classe = Boolean.class;
			break;
		case 11:
			classe = Boolean.class;
			break;
		case 13:
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
