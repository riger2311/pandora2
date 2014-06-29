/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pandora;

import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

/**
 *
 * @author dominikmocher
 */
public class StartDialog extends javax.swing.JDialog {

    JDialog gandalf;
    Game actualGame;
    /**
     * Creates new form StartDialog
     */
    public StartDialog(java.awt.Frame parent, boolean modal, JDialog wizard, Game game) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        gandalf = wizard;
        actualGame = game;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NewProject = new javax.swing.JButton();
        LoadProject = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Hallo zum Tabletop-Editor");

        jLabel2.setText("Bitte treffen Sie eine Auswahl");

        NewProject.setText("Neues Projekt");
        NewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewProjectActionPerformed(evt);
            }
        });

        LoadProject.setText("Projekt laden");
        LoadProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadProjectActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pandora/pandora.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoadProject, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewProject)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(NewProject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LoadProject)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewProjectActionPerformed
       gandalf.setVisible(true);
       dispose();
    }//GEN-LAST:event_NewProjectActionPerformed

    private void LoadProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadProjectActionPerformed
        JFileChooser fc = new JFileChooser();
        File file = null;
        String fileName = "";
        
        if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            file = fc.getSelectedFile();
            fileName = file.getAbsolutePath().toString();
        }
        
        actualGame.loadProject(fileName);
        dispose();
    }//GEN-LAST:event_LoadProjectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoadProject;
    private javax.swing.JButton NewProject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
