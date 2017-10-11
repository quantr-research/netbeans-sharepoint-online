package com.github.quantrresearch.sharepoint.online;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.TreeCellRenderer;

public class SharePointTreeRenderer extends JLabel implements TreeCellRenderer {

	Color background = UIManager.getColor("Tree.background");
	Color selectionBackground = UIManager.getColor("Tree.selectionBackground");
	Color foreground = UIManager.getColor("Tree.foreground");
	Color selectionForeground = UIManager.getColor("Tree.selectionForeground");

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		SharePointTreeNode node = (SharePointTreeNode) value;
		this.setIcon(node.getIcon());
		this.setText(node.toString());
		if (hasFocus) {
			if (sel) {
				this.setForeground(selectionForeground);
				this.setBackground(selectionBackground);
			} else {
				this.setForeground(foreground);
				this.setBackground(background);
			}
		} else {
			if (sel) {
				this.setForeground(foreground);
				this.setBackground(Color.lightGray);
			} else {
				this.setForeground(foreground);
				this.setBackground(background);
			}
		}
		this.setOpaque(true);
		return this;
	}

}
