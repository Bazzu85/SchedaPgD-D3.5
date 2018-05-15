package formatRenderer;

import java.awt.Component;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class PesoFormatRenderer extends DefaultTableCellRenderer {
	DecimalFormat formatConKg = new DecimalFormat("#.## 'Kg'");
	DecimalFormat formatSenzaKg = new DecimalFormat("#.##");

    @Override public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus,
        int row, int column) {
      JLabel cell = (JLabel) super.getTableCellRendererComponent(
          table, value, isSelected, hasFocus, row, column);

      //set Alignment
//      cell.setHorizontalAlignment(SwingConstants.CENTER);

      //set selection colors
//      if (isSelected) {
//        cell.setBackground(new Color(0x3399FF));
//        cell.setForeground(new Color(0x000000)); // AM
//      } else {
//        // set color
//        cell.setBackground(new Color(0xC8C8C8));
//        cell.setForeground(new Color(0xFFFFFF));
//      }

      return cell;
    }
    @Override public void setValue(Object value) {
    	if (value instanceof Double){
//    		setText(value instanceof Integer ? formatConSegno.format(value) : "");
    		if (Double.parseDouble(value.toString()) != 0){
        		setText(formatConKg.format(value));
    		} else {
        		setText(formatSenzaKg.format(value));
    		}

    	}
    }
  }
