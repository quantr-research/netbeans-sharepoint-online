// License : Apache License Version 2.0  https://www.apache.org/licenses/LICENSE-2.0
package com.github.quantrresearch.sharepoint.online;

import com.peterswing.CommonLib;
import hk.quantr.sharepoint.SPOnline;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import org.apache.commons.lang3.tuple.Pair;
import org.json.JSONObject;
import org.junit.Test;

/**
 *
 * @author Peter <peter@quantr.hk>
 */
public class TestSharePoint {

	@Test
	public void test() {
		JPasswordField pwd = new JPasswordField(10);
		int action = JOptionPane.showConfirmDialog(null, pwd, "Please input office365 password", JOptionPane.OK_CANCEL_OPTION);
		String password = new String(pwd.getPassword());
		String domain = "quantr";
		Pair<String, String> token = SPOnline.login("peter@quantr.hk", password, domain);
		if (token != null) {
			String jsonString = SPOnline.post(token, domain, "/_api/contextinfo", null, null);
			System.out.println(CommonLib.prettyFormatJson(jsonString));
			JSONObject json = new JSONObject(jsonString);
			String formDigestValue = json.getJSONObject("d").getJSONObject("GetContextWebInformation").getString("FormDigestValue");
			System.out.println("FormDigestValue=" + formDigestValue);

			jsonString = SPOnline.get(token, domain, "/_api/web");
			if (jsonString != null) {
				System.out.println(CommonLib.prettyFormatJson(jsonString));
			}

		}
	}
}
