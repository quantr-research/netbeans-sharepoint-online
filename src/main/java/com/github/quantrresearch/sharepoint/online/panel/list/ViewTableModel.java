package com.github.quantrresearch.sharepoint.online.panel.list;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Peter <peter@quantr.hk>
 */
public class ViewTableModel extends DefaultTableModel {

	public String columnNames[] = {"Field"};
	public ArrayList<String> data = new ArrayList<>();

	@Override
	public String getColumnName(int column) {
		if (columnNames == null) {
			return null;
		} else {
			return columnNames[column];
		}
	}

	@Override
	public int getColumnCount() {
		if (columnNames == null) {
			return 0;
		} else {
			return columnNames.length;
		}
	}

	@Override
	public int getRowCount() {
		if (data == null) {
			return 0;
		} else {
			return data.size();
		}
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (data == null) {
			return null;
		} else {
			return data.get(row);
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return Object.class;
	}
}
