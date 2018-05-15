package tableModels;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DbArmiTableModel extends DefaultTableModel {

	public DbArmiTableModel() {
		super(new String[] { 
				"Nome", 										//0 String
				"Categoria1", 									//1 String
				"Categoria2", 									//2 String
				"Mischia", 										//3 Boolean
				"Distanza", 									//4 Boolean
				"Costo" , 										//5 String
				"Danni (P)" ,									//6 String
				"Danni (M)" ,									//7 String 
				"Danni (G)" ,									//8 String 
				"Critico",										//9 String
				"Incr. Gittata",								//10 String
				"Peso" ,										//11 Double
				"Tipo",											//12 String
				"Riga Bloccata",								//13 Boolean
				"Prg"											//14 Integer
				}, 0);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class classe = String.class;
		switch (columnIndex) {
		case 3:
			classe = Boolean.class;
			break;
		case 4:
			classe = Boolean.class;
			break;
		case 11:
			classe = Double.class;
			break;
		case 13:
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
		if (valore instanceof Double) {
			Vector rowData = (Vector) getDataVector().get(row);
			rowData.set(column, valore);
			fireTableCellUpdated(row, column);
		}
		if (valore instanceof Boolean) {
			Vector rowData = (Vector) getDataVector().get(row);
			if (column == 1) {
				if ((boolean) valore && (boolean) rowData.get(2)) {
					JOptionPane.showMessageDialog(null, "L'arma non può essere sia Mischia che Distanza", "Errore", JOptionPane.ERROR_MESSAGE);
				} else {
					rowData.set(column, (boolean) valore);
					fireTableCellUpdated(row, column);
				}
			}
			if (column == 2) {
				if ((boolean) valore && (boolean) rowData.get(1)) {
					JOptionPane.showMessageDialog(null, "L'arma non può essere sia Mischia che Distanza", "Errore", JOptionPane.ERROR_MESSAGE);
				} else {
					rowData.set(column, (boolean) valore);
					fireTableCellUpdated(row, column);
				}
			}
			if (column == 11) {
				rowData.set(column, (boolean) valore);
				fireTableCellUpdated(row, column);
			}
		}
	}

}
