package com.github.quantrresearch.sharepoint.online;

import javax.swing.tree.DefaultTreeModel;

public class AntlrTreeModel extends DefaultTreeModel {

	AntlrTreeNode root;

	public AntlrTreeModel(AntlrTreeNode root) {
		super(root);
		this.root = root;
	}

	public void setRoot(AntlrTreeNode root) {
		this.root = root;
	}

	@Override
	public Object getRoot() {
		return root;
	}

	@Override
	public Object getChild(Object parent, int index) {
		AntlrTreeNode node = (AntlrTreeNode) parent;
		ModuleLib.log("getChild " + node.getChildCount() + " , " + index);
		int count = 0;
		for (int x = 0; x < node.getChildCount(); x++) {
			if (((AntlrTreeNode) node.getChildAt(x)).visible) {
				count++;
			}
			if (index == count - 1) {
				ModuleLib.log("getChild ok " + parent + " = " + node.getChildAt(x));
				return node.getChildAt(x);
			}
		}
		ModuleLib.log("getChild shit");
		return null;
	}

	@Override
	public int getChildCount(Object parent) {
		AntlrTreeNode node = (AntlrTreeNode) parent;
		int count = 0;
		for (int x = 0; x < node.getChildCount(); x++) {
			if (((AntlrTreeNode) node.getChildAt(x)).visible) {
				count++;
			}
		}
		ModuleLib.log("getChildCount " + parent + "=" + count);
		return count;

//		return node.getChildCount();
	}

//	@Override
//	public int getIndexOfChild(Object parent, Object child) {
//		AntlrTreeNode node = (AntlrTreeNode) parent;
////		int count = 0;
////		for (int x = 0; x < node.getChildCount(); x++) {
////			if (node.getChildAt(x) == child) {
////				ModuleLib.log("getIndexOfChild " + parent + " -> " + child + " = " + count);
////				return count;
////			}
////			if (((AntlrTreeNode) node.getChildAt(x)).visible) {
////				count++;
////			}
////		}
//
//		for (int x = 0; x < node.getChildCount(); x++) {
//			if (node.getChildAt(x) == child) {
//				return x;
//			}
//		}
//		return -1;
//
//		return ((AntlrTreeNode) parent).getIndex((javax.swing.tree.TreeNode) child);
//	}
//	@Override
//	public boolean isLeaf(Object node) {
////		AntlrTreeNode n = (AntlrTreeNode) node;
////		return !n.visible;
//		return false;
//	}
	public void visibleNode(AntlrTreeNode node, boolean b) {
		node.visible = b;
		ModuleLib.log(node);
		for (int x = 0; x < node.getChildCount(); x++) {
			visibleNode((AntlrTreeNode) node.getChildAt(x), b);
		}
	}

	public void filterTreeNode(AntlrTreeNode node, String text) {
		if (node.text.toLowerCase().contains(text.toLowerCase())) {
			ModuleLib.log("\t\t\thit=" + node.text);
			AntlrTreeNode nn = node;
			do {
				ModuleLib.logNoNewLine(" >> " + nn.text);
				nn.visible = true;
				nn = (AntlrTreeNode) nn.getParent();
			} while (nn != null);
			ModuleLib.log(null);
		}
		for (int x = 0; x < node.getChildCount(); x++) {
			filterTreeNode((AntlrTreeNode) node.getChildAt(x), text);
		}
	}

//	@Override
//	public void valueForPathChanged(TreePath path, Object newValue) {
//		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//	}
//
//	@Override
//	public void addTreeModelListener(TreeModelListener l) {
//		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//	}
//
//	@Override
//	public void removeTreeModelListener(TreeModelListener l) {
//		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//	}
}
