package com.github.quantrresearch.sharepoint.online.panel.doclib;

import com.github.quantrresearch.sharepoint.online.panel.list.*;
import com.github.quantrresearch.sharepoint.online.datastructure.Field;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Peter <peter@quantr.hk>
 */
public class FileTableModel extends DefaultTableModel {

	public String columnNames[] = {"Name", "Modified", "Created", "FieldValuesAsText"};
	public String columnFieldNames[] = {"Title", "Modified", "Created", "FieldValuesAsText"};
	public Class columnFieldtypes[] = {String.class, String.class, String.class, String.class};
	public ArrayList<ArrayList<Object>> data = new ArrayList<>();

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
			return data.get(row).get(column);
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

	public int getColumnIndex(String columnName) {
		for (int x = 0; x < columnNames.length; x++) {
			if (columnNames[x].equals(columnName)) {
				return x;
			}
		}
		return -1;
	}
}
