package cellRenderer;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import obj.ComboBoxArmi;

public class ArmiListCellRenderer extends DefaultListCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6049611306984956691L;

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {

		if (value instanceof ComboBoxArmi) {
			value = ((ComboBoxArmi) value).getNome();
			if (isSelected){
				System.out.println(" value: " + value);
				System.out.println(" isSelected: " + isSelected);
				System.out.println(" cellHasFocus: " + cellHasFocus);
			}
		}
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		return this;
	}
}
