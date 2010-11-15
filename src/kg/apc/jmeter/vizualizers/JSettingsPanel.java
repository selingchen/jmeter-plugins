package kg.apc.jmeter.vizualizers;

import javax.swing.ToolTipManager;
import kg.apc.jmeter.charting.GraphPanelChart;

/**
 *
 * @author Stéphane Hoblingre
 */
public class JSettingsPanel extends javax.swing.JPanel {

    private SettingsInterface parent = null;
    private int originalTooltipDisplayTime = 0;

    /** Creates new form JSettingsPanel */
    public JSettingsPanel(SettingsInterface parent,
            boolean showTimelinePanel,
            boolean showGradientOption,
            boolean showCurrentXOption,
            boolean showFinalZeroingLinesOption,
            boolean showLimitPointOption) {
        initComponents();
        this.parent = parent;

        jPanelTimeLine.setVisible(showTimelinePanel);
        jCheckBoxPaintGradient.setVisible(showGradientOption);
        jCheckBoxDrawCurrentX.setVisible(showCurrentXOption);
        jCheckBoxDrawFinalZeroingLines.setVisible(showFinalZeroingLinesOption);
        jCheckBoxMaxPoints.setVisible(showLimitPointOption);
        jComboBoxMaxPoints.setVisible(showLimitPointOption);
        jLabelMaxPoints.setVisible(showLimitPointOption);
        jLabelInfoMaxPoint.setVisible(showLimitPointOption);

        originalTooltipDisplayTime=ToolTipManager.sharedInstance().getDismissDelay();

        //init default values from global config
        jCheckBoxPaintGradient.setSelected(parent.getGraphPanelChart().isSettingsDrawGradient());
        jCheckBoxDrawCurrentX.setSelected(parent.getGraphPanelChart().isSettingsDrawCurrentX());
        if(showFinalZeroingLinesOption)
        {
            jCheckBoxDrawFinalZeroingLines.setSelected(GraphPanelChart.isGlobalDrawFinalZeroingLines());
        }
    }

    private int getValueFromString(String sValue) {
        int ret;
        try {
            ret = Integer.valueOf(sValue);
            if(ret <= 0)
            {
                ret = -1;
            }
        } catch (NumberFormatException ex) {
            ret = -1;
        }

        return ret;
    }

    public void setGranulationValue(int value) {
        jComboBoxGranulation.setSelectedItem(Integer.toString(value));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelTimeLine = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jComboBoxGranulation = new javax.swing.JComboBox();
        jLabelInfoGrpValues = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jCheckBoxPaintGradient = new javax.swing.JCheckBox();
        jCheckBoxDrawFinalZeroingLines = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jCheckBoxDrawCurrentX = new javax.swing.JCheckBox();
        jCheckBoxMaxPoints = new javax.swing.JCheckBox();
        jLabelMaxPoints = new javax.swing.JLabel();
        jComboBoxMaxPoints = new javax.swing.JComboBox();
        jLabelInfoMaxPoint = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kg/apc/jmeter/vizualizers/logoSimple.png"))); // NOI18N
        jPanel1.add(jLabel1);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanelTimeLine.setBorder(javax.swing.BorderFactory.createTitledBorder("Timeline Settings"));
        jPanelTimeLine.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Group values for:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanelTimeLine.add(jLabel2, gridBagConstraints);

        jLabel3.setText("ms");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanelTimeLine.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelTimeLine.add(jPanel4, gridBagConstraints);

        jComboBoxGranulation.setEditable(true);
        jComboBoxGranulation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "100", "500", "1000", "2000", "5000", "10000", "30000", "60000" }));
        jComboBoxGranulation.setPreferredSize(new java.awt.Dimension(80, 20));
        jComboBoxGranulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGranulationActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanelTimeLine.add(jComboBoxGranulation, gridBagConstraints);

        jLabelInfoGrpValues.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kg/apc/jmeter/vizualizers/information.png"))); // NOI18N
        jLabelInfoGrpValues.setToolTipText("<html>You can specify here the duration used internally<br>\nby the plugin to combine the values received during<br>\nthe test. This will result in <b>more readable graphs</b> and<br>\n<b>less resources needs</b>. It <b>cannot be undo</b>.<br>\nYou can change the value during the test, but it is not<br>\nrecomended as it may produce inconsistant graphs.<br>\nThis parameter is saved with the test plan.");
        jLabelInfoGrpValues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                infoLabelMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanelTimeLine.add(jLabelInfoGrpValues, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jPanelTimeLine, gridBagConstraints);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Rendering Options"));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jCheckBoxPaintGradient.setText("Paint gradient");
        jCheckBoxPaintGradient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPaintGradientActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel5.add(jCheckBoxPaintGradient, gridBagConstraints);

        jCheckBoxDrawFinalZeroingLines.setText("Draw final zeroing lines");
        jCheckBoxDrawFinalZeroingLines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDrawFinalZeroingLinesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel5.add(jCheckBoxDrawFinalZeroingLines, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel5.add(jPanel6, gridBagConstraints);

        jCheckBoxDrawCurrentX.setText("Draw current X line");
        jCheckBoxDrawCurrentX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDrawCurrentXActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel5.add(jCheckBoxDrawCurrentX, gridBagConstraints);

        jCheckBoxMaxPoints.setText("Limit number of points in row to");
        jCheckBoxMaxPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMaxPointsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel5.add(jCheckBoxMaxPoints, gridBagConstraints);

        jLabelMaxPoints.setText("points");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel5.add(jLabelMaxPoints, gridBagConstraints);

        jComboBoxMaxPoints.setEditable(true);
        jComboBoxMaxPoints.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20", "50", "100", "150", "200" }));
        jComboBoxMaxPoints.setSelectedIndex(1);
        jComboBoxMaxPoints.setPreferredSize(new java.awt.Dimension(50, 20));
        jComboBoxMaxPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMaxPointsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel5.add(jComboBoxMaxPoints, gridBagConstraints);

        jLabelInfoMaxPoint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kg/apc/jmeter/vizualizers/information.png"))); // NOI18N
        jLabelInfoMaxPoint.setToolTipText("<html>This option will <b>dynamically</b> adjust the graph<br>\nrendering so it is <b>more readable</b>. It <b>can be undo</b>.<br>\nYou can change the value during the test.<br>\nThis parameter is not saved with the test plan.<br>");
        jLabelInfoMaxPoint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                infoLabelMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel5.add(jLabelInfoMaxPoint, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jPanel5, gridBagConstraints);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxGranulationActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBoxGranulationActionPerformed
    {//GEN-HEADEREND:event_jComboBoxGranulationActionPerformed
        //notify parent if value changed and valid
        int newValue = getValueFromString((String)jComboBoxGranulation.getSelectedItem());
        if(newValue != -1 && parent.getGranulation() != newValue)
        {
            parent.setGranulation(newValue);
        }
    }//GEN-LAST:event_jComboBoxGranulationActionPerformed

    private void jCheckBoxPaintGradientActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCheckBoxPaintGradientActionPerformed
    {//GEN-HEADEREND:event_jCheckBoxPaintGradientActionPerformed
        parent.getGraphPanelChart().setSettingsDrawGradient(jCheckBoxPaintGradient.isSelected());
    }//GEN-LAST:event_jCheckBoxPaintGradientActionPerformed

    private void jCheckBoxDrawFinalZeroingLinesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCheckBoxDrawFinalZeroingLinesActionPerformed
    {//GEN-HEADEREND:event_jCheckBoxDrawFinalZeroingLinesActionPerformed
        parent.getGraphPanelChart().setSettingsDrawFinalZeroingLines(jCheckBoxDrawFinalZeroingLines.isSelected());
    }//GEN-LAST:event_jCheckBoxDrawFinalZeroingLinesActionPerformed

    private void jCheckBoxDrawCurrentXActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCheckBoxDrawCurrentXActionPerformed
    {//GEN-HEADEREND:event_jCheckBoxDrawCurrentXActionPerformed
        parent.getGraphPanelChart().setSettingsDrawCurrentX(jCheckBoxDrawCurrentX.isSelected());
    }//GEN-LAST:event_jCheckBoxDrawCurrentXActionPerformed

    private void jCheckBoxMaxPointsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCheckBoxMaxPointsActionPerformed
    {//GEN-HEADEREND:event_jCheckBoxMaxPointsActionPerformed
        if(jCheckBoxMaxPoints.isSelected()) {
            parent.getGraphPanelChart().setMaxPoints(getValueFromString((String)jComboBoxMaxPoints.getSelectedItem()));
        } else {
            parent.getGraphPanelChart().setMaxPoints(-1);
        }
    }//GEN-LAST:event_jCheckBoxMaxPointsActionPerformed

    private void jComboBoxMaxPointsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBoxMaxPointsActionPerformed
    {//GEN-HEADEREND:event_jComboBoxMaxPointsActionPerformed
        if(jCheckBoxMaxPoints.isSelected()) {
            parent.getGraphPanelChart().setMaxPoints(getValueFromString((String)jComboBoxMaxPoints.getSelectedItem()));
        } 
    }//GEN-LAST:event_jComboBoxMaxPointsActionPerformed

    private void infoLabelMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_infoLabelMouseEntered
    {//GEN-HEADEREND:event_infoLabelMouseEntered
        //increase tooltip display duration
        ToolTipManager.sharedInstance().setDismissDelay(60000);
    }//GEN-LAST:event_infoLabelMouseEntered

    private void infoLabelMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_infoLabelMouseExited
    {//GEN-HEADEREND:event_infoLabelMouseExited
        ToolTipManager.sharedInstance().setDismissDelay(originalTooltipDisplayTime);
    }//GEN-LAST:event_infoLabelMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxDrawCurrentX;
    private javax.swing.JCheckBox jCheckBoxDrawFinalZeroingLines;
    private javax.swing.JCheckBox jCheckBoxMaxPoints;
    private javax.swing.JCheckBox jCheckBoxPaintGradient;
    private javax.swing.JComboBox jComboBoxGranulation;
    private javax.swing.JComboBox jComboBoxMaxPoints;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelInfoGrpValues;
    private javax.swing.JLabel jLabelInfoMaxPoint;
    private javax.swing.JLabel jLabelMaxPoints;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelTimeLine;
    // End of variables declaration//GEN-END:variables

}
