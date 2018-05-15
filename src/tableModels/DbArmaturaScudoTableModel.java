package tableModels;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DbArmaturaScudoTableModel extends DefaultTableModel {

	public DbArmaturaScudoTableModel() {
		super(
				new String[] {
						"Nome", // 0 String
						"Categoria", // 1 String
						"Armatura", // 2 Boolean
						"Scudo", // 3 Boolean
						"Costo", // 4 String
						"Bonus", // 5 Integer
						"Bonus Destrezza MAX", // 6 Integer
						"<html>Penalita alla<br>Prova Armatura</html>", // 7 Integer
						"<html><center>Fallimento Incantesimi<br>Arcani</center></html>",// 8 Integer
						"<html>Velocità<br>(9M)</html>", // 9 Integer
						"<html>Velocità<br>(6M)</html>", // 10 Integer
						"Peso", // 11 Integer
						"Riga Bloccata", // 12 Boolean
						"Prg" // 13 Integer
				}, 0);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class classe = String.class;
		switch (columnIndex) {
		case 2:
			classe = Boolean.class;
			break;
		case 3:
			classe = Boolean.class;
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
			classe = Double.class;
			break;
		case 10:
			classe = Double.class;
			break;
		case 11:
			classe = Double.class;
			break;
		case 12:
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
