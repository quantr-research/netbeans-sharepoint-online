// License : Apache License Version 2.0  https://www.apache.org/licenses/LICENSE-2.0
package com.github.quantrresearch.sharepoint.online;

import com.github.quantrresearch.sharepoint.online.dialog.SettingDialog;
import com.github.quantrresearch.sharepoint.online.panel.list.ListPanel;
import com.github.quantrresearch.sharepoint.online.panel.MainTopComponent;
import com.peterswing.CommonLib;
import hk.quantr.sharepoint.SPOnline;
import java.awt.BorderLayout;
import java.awt.Image;
import java.util.Arrays;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.apache.commons.lang3.tuple.Pair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.netbeans.api.keyring.Keyring;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.NbPreferences;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
		dtd = "-//com.github.quantrresearch.sharepoint.online//SharePoint//EN",
		autostore = false
)
@TopComponent.Description(
		preferredID = "SharePointTopComponent",
		iconBase = "com/github/quantrresearch/sharepoint/online/sharepoint icon.png",
		persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = false)
@ActionID(category = "Window", id = "com.github.quantrresearch.sharepoint.online.SharePointTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
		displayName = "#CTL_SharePointAction",
		preferredID = "SharePointTopComponent"
)
@Messages({
	"CTL_SharePointAction=SharePoint",
	"CTL_SharePointTopComponent=SharePoint",
	"HINT_SharePointTopComponent=This is a SharePoint window"
})
public final class SharePointTopComponent extends TopComponent {

	SharePointTreeNode rootNode = new SharePointTreeNode("Server", "servers", "server", null);
	SharePointTreeModel treeModel = new SharePointTreeModel(rootNode);

	public SharePointTopComponent() {
		initComponents();
		setName(Bundle.CTL_SharePointTopComponent());
		setToolTipText(Bundle.HINT_SharePointTopComponent());

		initTree();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settingPopupMenu = new javax.swing.JPopupMenu();
        addserverMenuItem = new javax.swing.JMenuItem();
        editServerMenuItem = new javax.swing.JMenuItem();
        deleteServerMenuItem = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        jToolBar1 = new javax.swing.JToolBar();
        expandTreeButton = new javax.swing.JButton();
        collapseButton = new javax.swing.JButton();

        addserverMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/quantrresearch/sharepoint/online/icon/add.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(addserverMenuItem, org.openide.util.NbBundle.getMessage(SharePointTopComponent.class, "SharePointTopComponent.addserverMenuItem.text")); // NOI18N
        addserverMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addserverMenuItemActionPerformed(evt);
            }
        });
        settingPopupMenu.add(addserverMenuItem);

        editServerMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/quantrresearch/sharepoint/online/icon/pencil.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(editServerMenuItem, org.openide.util.NbBundle.getMessage(SharePointTopComponent.class, "SharePointTopComponent.editServerMenuItem.text")); // NOI18N
        editServerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editServerMenuItemActionPerformed(evt);
            }
        });
        settingPopupMenu.add(editServerMenuItem);

        deleteServerMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/quantrresearch/sharepoint/online/icon/cross.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(deleteServerMenuItem, org.openide.util.NbBundle.getMessage(SharePointTopComponent.class, "SharePointTopComponent.deleteServerMenuItem.text")); // NOI18N
        deleteServerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteServerMenuItemActionPerformed(evt);
            }
        });
        settingPopupMenu.add(deleteServerMenuItem);

        setLayout(new java.awt.BorderLayout());

        tree.setRowHeight(24);
        tree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tree);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);

        org.openide.awt.Mnemonics.setLocalizedText(expandTreeButton, org.openide.util.NbBundle.getMessage(SharePointTopComponent.class, "SharePointTopComponent.expandTreeButton.text")); // NOI18N
        expandTreeButton.setFocusable(false);
        expandTreeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        expandTreeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        expandTreeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expandTreeButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(expandTreeButton);

        org.openide.awt.Mnemonics.setLocalizedText(collapseButton, org.openide.util.NbBundle.getMessage(SharePointTopComponent.class, "SharePointTopComponent.collapseButton.text")); // NOI18N
        collapseButton.setFocusable(false);
        collapseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        collapseButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        collapseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collapseButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(collapseButton);

        add(jToolBar1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void treeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeMouseClicked
		if (SwingUtilities.isRightMouseButton(evt)) {
			settingPopupMenu.show(tree, evt.getX(), evt.getY());
		} else if (evt.getClickCount() == 2) {
			SharePointTreeNode node = (SharePointTreeNode) tree.getLastSelectedPathComponent();
			if (node == null) {
				return;
			} else if (node.type.equals("list")) {
				MainTopComponent mainTopComponent = new MainTopComponent();
				mainTopComponent.setName(node.text);
				mainTopComponent.setIcon(CommonLib.iconToImage(SharePointTreeNode.iconRoot.get(node.icon)));
				mainTopComponent.add(new ListPanel(), BorderLayout.CENTER);
				mainTopComponent.open();
			}
		}
    }//GEN-LAST:event_treeMouseClicked

    private void addserverMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addserverMenuItemActionPerformed
		SettingDialog settingDialog = new SettingDialog(null, true);
		settingDialog.setLocationRelativeTo(null);
		settingDialog.setVisible(true);
		if (settingDialog.isSave) {
			String savedServers = NbPreferences.forModule(SharePointTopComponent.class).get("servers", "");
			TreeSet<String> set = new TreeSet<>(Arrays.asList(savedServers.split(",")));
			String serverName = settingDialog.domainTextField.getText();
			if (set.contains(serverName)) {
				JOptionPane.showMessageDialog(null, "Already added", "Errir", JOptionPane.ERROR_MESSAGE);
			} else {
				set.add(serverName);
				set.remove("");
				NbPreferences.forModule(SharePointTopComponent.class).put("servers", String.join(",", set));
				Keyring.save(serverName + "-sharepointDomain", serverName.toCharArray(), null);
				Keyring.save(serverName + "-sharepointUsername", settingDialog.usernameTextField.getText().toCharArray(), null);
				Keyring.save(serverName + "-sharepointPassword", settingDialog.passwordField.getText().toCharArray(), null);
				refreshTree();
			}
		}
    }//GEN-LAST:event_addserverMenuItemActionPerformed

    private void editServerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editServerMenuItemActionPerformed
		SettingDialog settingDialog = new SettingDialog(null, true);
		settingDialog.setLocationRelativeTo(null);

		SharePointTreeNode node = (SharePointTreeNode) tree.getLastSelectedPathComponent();
		if (node == null) {
			return;
		}
		String domain = Keyring.read(node.text + "-sharepointDomain") == null ? null : new String(Keyring.read(node.text + "-sharepointDomain"));
		String username = Keyring.read(node.text + "-sharepointUsername") == null ? null : new String(Keyring.read(node.text + "-sharepointUsername"));
		String password = Keyring.read(node.text + "-sharepointPassword") == null ? null : new String(Keyring.read(node.text + "-sharepointPassword"));
		settingDialog.domainTextField.setText(domain);
		settingDialog.usernameTextField.setText(username);
		settingDialog.passwordField.setText(password);
		settingDialog.setVisible(true);
		if (settingDialog.isSave) {
			Keyring.save(node.text + "-sharepointDomain", settingDialog.domainTextField.getText().toCharArray(), null);
			Keyring.save(node.text + "-sharepointUsername", settingDialog.usernameTextField.getText().toCharArray(), null);
			Keyring.save(node.text + "-sharepointPassword", settingDialog.passwordField.getText().toCharArray(), null);
		}
    }//GEN-LAST:event_editServerMenuItemActionPerformed

    private void deleteServerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteServerMenuItemActionPerformed
		SettingDialog settingDialog = new SettingDialog(null, true);
		settingDialog.setLocationRelativeTo(null);

		SharePointTreeNode node = (SharePointTreeNode) tree.getLastSelectedPathComponent();
		if (node == null) {
			return;
		}
		String savedServers = NbPreferences.forModule(SharePointTopComponent.class).get("servers", "");
		TreeSet<String> set = new TreeSet<>(Arrays.asList(savedServers.split(",")));
		set.remove(node.text);
		NbPreferences.forModule(SharePointTopComponent.class).put("servers", String.join(",", set));
		refreshTree();
    }//GEN-LAST:event_deleteServerMenuItemActionPerformed

    private void expandTreeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expandTreeButtonActionPerformed
		CommonLib.expandAll(tree, true);
    }//GEN-LAST:event_expandTreeButtonActionPerformed

    private void collapseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collapseButtonActionPerformed
		CommonLib.expandAll(tree, false);
    }//GEN-LAST:event_collapseButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addserverMenuItem;
    private javax.swing.JButton collapseButton;
    private javax.swing.JMenuItem deleteServerMenuItem;
    private javax.swing.JMenuItem editServerMenuItem;
    private javax.swing.JButton expandTreeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPopupMenu settingPopupMenu;
    private javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables
	@Override
	public void componentOpened() {
	}

	@Override
	public void componentClosed() {
	}

	void writeProperties(java.util.Properties p) {
		p.setProperty("version", "1.0");
	}

	void readProperties(java.util.Properties p) {
		String version = p.getProperty("version");
	}

	private void initTree() {
		try {
			tree.setModel(treeModel);
			tree.setCellRenderer(new SharePointTreeRenderer());
			tree.setShowsRootHandles(true);

			refreshTree();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void refreshTree() {
		rootNode.removeAllChildren();
		String savedServers = NbPreferences.forModule(SharePointTopComponent.class).get("servers", "");
		TreeSet<String> set = new TreeSet<>(Arrays.asList(savedServers.split(",")));
		set.remove("");
		for (String server : set) {
			String domain = Keyring.read(server + "-sharepointDomain") == null ? null : new String(Keyring.read(server + "-sharepointDomain"));
			String username = Keyring.read(server + "-sharepointUsername") == null ? null : new String(Keyring.read(server + "-sharepointUsername"));
			String password = Keyring.read(server + "-sharepointPassword") == null ? null : new String(Keyring.read(server + "-sharepointPassword"));
			SharePointTreeNode serverNode = new SharePointTreeNode(server, "server", "server", new ServerInfo(domain, username, password));
			rootNode.add(serverNode);
			initServerNode(serverNode);
		}
		treeModel.reload();
	}

	private void initServerNode(SharePointTreeNode serverNode) {
		SharePointTreeNode listsNode = new SharePointTreeNode("List", "lists", "table", null);
		serverNode.add(listsNode);
		initLists(listsNode);
		serverNode.add(new SharePointTreeNode("Page", "pages", "page", null));
		serverNode.add(new SharePointTreeNode("Document library", "Document libraries", "book", null));
		serverNode.add(new SharePointTreeNode("App", "app", "brick", null));
		serverNode.add(new SharePointTreeNode("Subsite", "subsites", "world", null));
	}

	private void initLists(SharePointTreeNode listsNode) {
		ServerInfo serverInfo = (ServerInfo) Helper.get(listsNode, ServerInfo.class);
		Pair<String, String> token = SPOnline.login(serverInfo.username, serverInfo.password, serverInfo.domain);

		if (token != null) {
			String jsonString = SPOnline.post(token, serverInfo.domain, "/_api/contextinfo", null, null);
			//String formDigestValue = json.getJSONObject("d").getJSONObject("GetContextWebInformation").getString("FormDigestValue");
			jsonString = SPOnline.get(token, serverInfo.domain, "/_api/web/lists?$select=ID,Title");
			if (jsonString != null) {
				JSONObject json = new JSONObject(jsonString);
				JSONArray array = json.getJSONObject("d").getJSONArray("results");
				for (int x = 0; x < array.length(); x++) {
					JSONObject j = array.getJSONObject(x);
					listsNode.add(new SharePointTreeNode(j.getString("Title"), "list", "table", null));
				}
			}
		}
	}
}
