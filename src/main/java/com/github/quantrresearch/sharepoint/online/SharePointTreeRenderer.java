package com.github.quantrresearch.sharepoint.online;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.TreeCellRenderer;

public class SharePointTreeRenderer extends JLabel implements TreeCellRenderer {

	Color background = UIManager.getColor("Tree.background");
	Color selectionBackground = UIManager.getColor("Tree.selectionBackground");

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		SharePointTreeNode node = (SharePointTreeNode) value;
		this.setIcon(node.getIcon());
		this.setText(node.toString());
		if (hasFocus) {
			if (sel) {
				this.setBackground(selectionBackground);
			} else {
				this.setBackground(background);
			}
		} else {
			if (sel) {
				this.setBackground(Color.lightGray);
			} else {
				this.setBackground(background);
			}
		}
		this.setOpaque(true);
		return this;
	}

}
