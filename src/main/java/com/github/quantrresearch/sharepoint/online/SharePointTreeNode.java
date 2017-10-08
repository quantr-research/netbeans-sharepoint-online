package com.github.quantrresearch.sharepoint.online;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;

public class SharePointTreeNode extends DefaultMutableTreeNode {

	String type;
	String text;
	public boolean visible;
	Icon iconRoot = new ImageIcon(getClass().getClassLoader().getResource("/com/github/quantrresearch/sharepoint/online/icon/server.png"));

	public SharePointTreeNode(String text, String type) {
		this.text = text;
		this.type = type;
		visible = true;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Icon getIcon() {
		if (type.equals("root")) {
			return iconRoot;
		} else {
			return null;
		}
	}

	public String toString() {
		return text;
	}

}
