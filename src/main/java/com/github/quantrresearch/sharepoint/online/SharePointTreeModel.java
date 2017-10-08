package com.github.quantrresearch.sharepoint.online;

import javax.swing.tree.DefaultTreeModel;

public class SharePointTreeModel extends DefaultTreeModel {

	SharePointTreeNode root;

	public SharePointTreeModel(SharePointTreeNode root) {
		super(root);
		this.root = root;
	}

	public void setRoot(SharePointTreeNode root) {
		this.root = root;
	}

	@Override
	public Object getRoot() {
		return root;
	}

	@Override
	public Object getChild(Object parent, int index) {
		SharePointTreeNode node = (SharePointTreeNode) parent;
		int count = 0;
		for (int x = 0; x < node.getChildCount(); x++) {
			if (((SharePointTreeNode) node.getChildAt(x)).visible) {
				count++;
			}
			if (index == count - 1) {
				return node.getChildAt(x);
			}
		}
		return null;
	}

	@Override
	public int getChildCount(Object parent) {
		SharePointTreeNode node = (SharePointTreeNode) parent;
		int count = 0;
		for (int x = 0; x < node.getChildCount(); x++) {
			if (((SharePointTreeNode) node.getChildAt(x)).visible) {
				count++;
			}
		}
		return count;
	}

	public void visibleNode(SharePointTreeNode node, boolean b) {
		node.visible = b;
		ModuleLib.log(node);
		for (int x = 0; x < node.getChildCount(); x++) {
			visibleNode((SharePointTreeNode) node.getChildAt(x), b);
		}
	}

	public void filterTreeNode(SharePointTreeNode node, String text) {
		if (node.text.toLowerCase().contains(text.toLowerCase())) {
			ModuleLib.log("\t\t\thit=" + node.text);
			SharePointTreeNode nn = node;
			do {
				ModuleLib.logNoNewLine(" >> " + nn.text);
				nn.visible = true;
				nn = (SharePointTreeNode) nn.getParent();
			} while (nn != null);
			ModuleLib.log(null);
		}
		for (int x = 0; x < node.getChildCount(); x++) {
			filterTreeNode((SharePointTreeNode) node.getChildAt(x), text);
		}
	}
}
