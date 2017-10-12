// License : Apache License Version 2.0  https://www.apache.org/licenses/LICENSE-2.0
package com.github.quantrresearch.sharepoint.online;

/**
 *
 * @author Peter <mcheung63@hotmail.com>
 */
public class Helper {

	public static Object getNode(SharePointTreeNode node, Class c) {
		if (node.object != null && node.object.getClass() == c) {
			return node;
		} else {
			if (node.getParent() == null) {
				return null;
			} else {
				return getNodeObject((SharePointTreeNode) node.getParent(), c);
			}
		}
	}

	public static Object getNodeObject(SharePointTreeNode node, Class c) {
		if (node.object != null && node.object.getClass() == c) {
			return node.object;
		} else {
			if (node.getParent() == null) {
				return null;
			} else {
				return getNodeObject((SharePointTreeNode) node.getParent(), c);
			}
		}
	}
}
