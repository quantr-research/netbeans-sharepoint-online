// License : Apache License Version 2.0  https://www.apache.org/licenses/LICENSE-2.0
package com.github.quantrresearch.sharepoint.online;

/**
 *
 * @author Peter <mcheung63@hotmail.com>
 */
public class Helper {
	
	static Object get(SharePointTreeNode node, Class c) {
		if (node.object != null && node.object.getClass() == c) {
			return node.object;
		} else {
			if (node.getParent() == null) {
				return null;
			} else {
				return get((SharePointTreeNode) node.getParent(), c);
			}
		}
	}
	
}
