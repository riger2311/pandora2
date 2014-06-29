/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pandora;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author dominikmocher
 */
public class Mainframe extends javax.swing.JFrame {

    Game game;
    /**
     * Creates new form Mainframe
     */
    public Mainframe(Game actualGame) {
        initComponents();
        game = actualGame;
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        NewProject = new javax.swing.JMenuItem();
        SaveProject = new javax.swing.JMenuItem();
        LoadProject = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Menu.setText("Pandora");
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed(evt);
            }
        });

        NewProject.setText("Neu");
        NewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewProjectActionPerformed(evt);
            }
        });
        Menu.add(NewProject);

        SaveProject.setText("Speichern");
        SaveProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveProjectActionPerformed(evt);
            }
        });
        Menu.add(SaveProject);

        LoadProject.setText("Laden");
        LoadProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadProjectActionPerformed(evt);
            }
        });
        Menu.add(LoadProject);

        Exit.setText("Schließen");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        Menu.add(Exit);

        jMenuBar1.add(Menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
       
    }//GEN-LAST:event_MenuActionPerformed

    private void NewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewProjectActionPerformed
        //resets game and starts new wizard
        game.reset();
        Wizard gandalf = new Wizard(null, true, game);
        gandalf.setVisible(true);
        
        //displays new panels after reset,
        //needed to display changes
        this.jTabbedPane1.removeAll();
        //TODO: add mapeditor
        this.jTabbedPane1.add("Regeln", new RulesEditor(game));
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
        
        game.loadProject(fileName);
        System.out.println("loaded " + fileName);
        //displays new rules panel after loading from a file, 
        //needed to display changes
        this.jTabbedPane1.removeAll();
        //TODO: add mapeditor
        this.jTabbedPane1.add("Regeln", new RulesEditor(game));
        
        
    }//GEN-LAST:event_LoadProjectActionPerformed

    private void SaveProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveProjectActionPerformed
       
       JFileChooser fc = new JFileChooser();
       File file = null;
       String fileName = "";
        
       if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
       {
          file = fc.getSelectedFile();
          fileName = file.getAbsolutePath().toString();
       }
        
       game.saveProject(fileName);
       System.out.println("saved");
    }//GEN-LAST:event_SaveProjectActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem LoadProject;
    private javax.swing.JMenu Menu;
    private javax.swing.JMenuItem NewProject;
    private javax.swing.JMenuItem SaveProject;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jTabbedPane1
     */
    public javax.swing.JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

}
