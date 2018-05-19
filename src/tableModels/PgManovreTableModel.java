package tableModels;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PgManovreTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5814766138807624024L;

	public PgManovreTableModel() {
		super(new String[] { "Nome", // 0 String
				"Tipo", // 1 String
				"Disciplina", // 2 String
				"Lvl", // 3 Integer
				"Pronta", // 4 Boolean
				"Da Usare", // 5 Boolean
				"Descrizione", // 6 String
				"#" // 7 int
		}, 0);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class classe = String.class;
		switch (columnIndex) {
		case 3:
			classe = Integer.class;
			break;
		case 4:
			classe = Boolean.class;
			break;
		case 5:
			classe = Boolean.class;
			break;
		case 7:
			classe = Integer.class;
			break;
		}
		return classe;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		if (column == 5){
			return true;
		}
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

			if ((Boolean) valore){
				if (rowData.get(1).toString().equals("Stance")){
					JOptionPane.showMessageDialog(null, "Impossibile modificare il flag per una Stance", "Errore", JOptionPane.ERROR_MESSAGE);
				} else {
					if (!(boolean) rowData.get(4)){
						JOptionPane.showMessageDialog(null, "Impossibile modificare il flag per una Manovra non pronta", "Errore", JOptionPane.ERROR_MESSAGE);
					} else {
						rowData.set(column, (boolean) valore);
						fireTableCellUpdated(row, column);
					}
				}
			} else {
				rowData.set(column, (boolean) valore);
				fireTableCellUpdated(row, column);
			}
		}

	}

}
