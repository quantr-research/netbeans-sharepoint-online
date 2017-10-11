// License : Apache License Version 2.0  https://www.apache.org/licenses/LICENSE-2.0
package com.github.quantrresearch.sharepoint.online.panel.list;

/**
 *
 * @author Peter <mcheung63@hotmail.com>
 */
public class ListPanel extends javax.swing.JPanel {

	public DataTableModel dataTableModel = new DataTableModel();
	public ColumnTableModel columnTableModel = new ColumnTableModel();

	/**
	 * Creates new form ListPanel
	 */
	public ListPanel() {
		initComponents();
		dataTable.setModel(dataTableModel);
		dataTable.setDefaultRenderer(Object.class, new DataTableCellRenderer());
		columnTable.setModel(columnTableModel);
		columnTable.setDefaultRenderer(Object.class, new ColumnTableCellRenderer());
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listTableCellRenderer1 = new com.github.quantrresearch.sharepoint.online.panel.list.DataTableCellRenderer();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        columnTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        org.openide.awt.Mnemonics.setLocalizedText(listTableCellRenderer1, org.openide.util.NbBundle.getMessage(ListPanel.class, "ListPanel.listTableCellRenderer1.text")); // NOI18N

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(dataTable);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(ListPanel.class, "ListPanel.jPanel1.TabConstraints.tabTitle"), jPanel1); // NOI18N

        jPanel3.setLayout(new java.awt.BorderLayout());

        columnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(columnTable);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(ListPanel.class, "ListPanel.jPanel3.TabConstraints.tabTitle"), jPanel3); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(ListPanel.class, "ListPanel.jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable columnTable;
    private javax.swing.JTable dataTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.github.quantrresearch.sharepoint.online.panel.list.DataTableCellRenderer listTableCellRenderer1;
    // End of variables declaration//GEN-END:variables
}
