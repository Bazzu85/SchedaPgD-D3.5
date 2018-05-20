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
				"Nome", // 1 String
				"Taglia", // 2 String
				"Qualità", // 3 String
				"Mod.", // 4 Integer
				"Incantamenti", // 5 String
				"<html>Bonus<br>Incantamenti</html>", // 6 String
				"Mod. al BAB", // 7 Integer
				"<html>Mod. al<br>Danno</html>", // 8 Integer
				"<html>Tenuta a<br>2 Mani</html>", // 9 Boolean
				"Doppia Arma", // 10 Boolean
				"<html>Primaria<br>Secondaria</html>", // 11 String
				"Equipaggiata", // 12 Boolean
				"Mod BAB Descrizione", //13 String
				"Mod Danno Descrizione", //14 String
				"Prg" // 15 Integer
		}, 0);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class classe = String.class;
		switch (columnIndex) {
		case 4:
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
			classe = Boolean.class;
			break;
		case 12:
			classe = Boolean.class;
			break;
		case 14:
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
