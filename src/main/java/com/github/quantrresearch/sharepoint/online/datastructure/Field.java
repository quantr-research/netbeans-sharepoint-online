// License : Apache License Version 2.0  https://www.apache.org/licenses/LICENSE-2.0
package com.github.quantrresearch.sharepoint.online.datastructure;

/**
 *
 * @author Peter <mcheung63@hotmail.com>
 */
public class Field {

	public String title;
	public String type;
	public String internalName;
	public String staticName;

	public Field(String title, String type, String internalName, String staticName) {
		this.title = title;
		this.type = type;
		this.internalName = internalName;
		this.staticName = staticName;
	}

}
