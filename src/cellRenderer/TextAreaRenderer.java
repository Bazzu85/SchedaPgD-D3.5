package cellRenderer;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DefaultCaret;

public class TextAreaRenderer implements TableCellRenderer {
	JTextArea textArea;

	public TextAreaRenderer() {
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
//		textArea.setBorder(UIManager.getBorder("JTable.border"));


//		textarea.setBorder(new TitledBorder("This is a JTextArea"));
//		getViewport().add(textArea);
//		getViewport().setBorder(null);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if (isSelected) {
//			setForeground(table.getSelectionForeground());
//			setBackground(table.getSelectionBackground());
			textArea.setForeground(table.getSelectionForeground());
			textArea.setBackground(table.getSelectionBackground());
		} else {
//			setForeground(table.getForeground());
//			setBackground(table.getBackground());
			textArea.setForeground(table.getForeground());
			textArea.setBackground(table.getBackground());
		}

		textArea.setText((String) value);
		textArea.setCaretPosition(0);
		return textArea;
	}
}