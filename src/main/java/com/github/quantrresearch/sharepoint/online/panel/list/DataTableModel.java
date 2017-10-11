package com.github.quantrresearch.sharepoint.online.panel.list;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Peter <peter@quantr.hk>
 */
public class DataTableModel extends DefaultTableModel {

	public ArrayList<String> columnNames = new ArrayList<>();
	public ArrayList<List<Object>> data = new ArrayList<>();

	@Override
	public String getColumnName(int column) {
		if (columnNames == null) {
			return null;
		} else {
			return columnNames.get(column);
		}
	}

	@Override
	public int getColumnCount() {
		if (columnNames == null) {
			return 0;
		} else {
			return columnNames.size();
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
			return data.get(row).get(column);
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return true;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return Object.class;
	}
}
