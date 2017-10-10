// License : Apache License Version 2.0  https://www.apache.org/licenses/LICENSE-2.0
package com.github.quantrresearch.sharepoint.online;

/**
 *
 * @author Peter <mcheung63@hotmail.com>
 */
public class ServerInfo {

	String domain;
	String username;
	String password;

	public ServerInfo(String domain, String username, String password) {
		this.domain = domain;
		this.username = username;
		this.password = password;
	}

}
