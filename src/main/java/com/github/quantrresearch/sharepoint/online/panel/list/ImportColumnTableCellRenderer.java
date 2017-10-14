// License : Apache License Version 2.0  https://www.apache.org/licenses/LICENSE-2.0
package com.github.quantrresearch.sharepoint.online.panel.list;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Peter <peter@quantr.hk>
 */
public class ImportColumnTableCellRenderer extends JLabel implements TableCellRenderer {

	static Color selectionForeground = UIManager.getColor("Table.selectionForeground");
	static Color foreground = UIManager.getColor("Table.foreground");
	static Color selectionBackground = UIManager.getColor("Table.selectionBackground");
	static Color background = UIManager.getColor("Table.background");
	static Color tableHeaderBackground = UIManager.getColor("TableHeader.background");

	public ImportColumnTableCellRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//		if (column == 0) {
//			setHorizontalAlignment(SwingConstants.RIGHT);
//		} else if (column == 1) {
//			setHorizontalAlignment(SwingConstants.LEFT);
//		} else {
		setHorizontalAlignment(SwingConstants.LEFT);
//		}
		if (value instanceof String) {
			setText((String) value);
		} else if (value != null) {
			setText(value.toString());
		} else {
			setText(null);
		}
		if (isSelected) {
			setBackground(selectionBackground);
			setForeground(selectionForeground);
		} else {
			setForeground(foreground);
			setBackground(background);
		}
		return this;
	}

}
