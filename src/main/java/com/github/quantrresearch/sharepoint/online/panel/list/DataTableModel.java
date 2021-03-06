package com.github.quantrresearch.sharepoint.online.panel.list;

import com.github.quantrresearch.sharepoint.online.datastructure.Field;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Peter <peter@quantr.hk>
 */
public class DataTableModel extends DefaultTableModel {

	public ArrayList<Field> columns = new ArrayList<>();
	public ArrayList<ArrayList<Object>> data = new ArrayList<>();

	@Override
	public String getColumnName(int column) {
		if (columns == null) {
			return null;
		} else {
			return columns.get(column).title;
		}
	}

	@Override
	public int getColumnCount() {
		if (columns == null) {
			return 0;
		} else {
			return columns.size();
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
