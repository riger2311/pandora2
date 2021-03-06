/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import pandora.TileMap.MapEditor;

/**
 *
 * @author dominikmocher
 */
public class Mainframe extends javax.swing.JFrame {

    Game game;
    private MapEditor map_editor;

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
        Export = new javax.swing.JMenu();
        GenerateGame = new javax.swing.JMenuItem();
        Map = new javax.swing.JMenu();
        NewBoard = new javax.swing.JMenuItem();
        SaveBoard = new javax.swing.JMenuItem();
        LoadBoard = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

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

        Export.setText("Export");

        GenerateGame.setText("Erstelle Spiel");
        GenerateGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateGameActionPerformed(evt);
            }
        });
        Export.add(GenerateGame);

        jMenuBar1.add(Export);

        Map.setText("Brett");

        NewBoard.setText("Neues Brett");
        NewBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewBoardActionPerformed(evt);
            }
        });
        Map.add(NewBoard);

        SaveBoard.setText("Brett speichern");
        SaveBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBoardActionPerformed(evt);
            }
        });
        Map.add(SaveBoard);

        LoadBoard.setText("Brett laden");
        LoadBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadBoardActionPerformed(evt);
            }
        });
        Map.add(LoadBoard);

        jMenuBar1.add(Map);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
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
        map_editor = new MapEditor(game);
        //TODO: add mapeditor
        this.jTabbedPane1.add(ConstantStrings.HEAD_MAP, map_editor);
        this.jTabbedPane1.add(ConstantStrings.HEAD_RULES, new RulesEditor(game));
    }//GEN-LAST:event_NewProjectActionPerformed

    private void LoadProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadProjectActionPerformed
        JFileChooser fc = new JFileChooser();
        File file = null;
        String fileName = "";

        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            fileName = file.getAbsolutePath().toString();
        }
        
        if(file != null)
        {
        game.loadProject(fileName);
        System.out.println("loaded " + fileName);
        //displays new rules panel after loading from a file, 
        //needed to display changes
        this.jTabbedPane1.removeAll();
        this.jTabbedPane1.add(ConstantStrings.HEAD_MAP, new MapEditor(game));
        this.jTabbedPane1.add(ConstantStrings.HEAD_RULES, new RulesEditor(game));
        

        JOptionPane.showMessageDialog(this, ConstantStrings.MSG_LOADED, "Pandora", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_LoadProjectActionPerformed

    private void SaveProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveProjectActionPerformed

        JFileChooser fc = new JFileChooser();
        File file = null;
        String fileName = "";

        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            fileName = file.getAbsolutePath().toString();
        }

        if(file != null)
        {
        game.saveProject(fileName);
        //System.out.println("saved");

        JOptionPane.showMessageDialog(this, ConstantStrings.MSG_SAVED, "Pandora", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_SaveProjectActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void ParseitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParseitActionPerformed

    }//GEN-LAST:event_ParseitActionPerformed

    private void GenerateGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateGameActionPerformed
        Parser newParser = new Parser(game);
        try {
            newParser.parseBoard();
            newParser.parseMain();
            newParser.parseReader();
            JOptionPane.showMessageDialog(this, ConstantStrings.MSG_PARSE_OK, "Pandora", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(this, ConstantStrings.MSG_PARSE_FAIL, "Pandora", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_GenerateGameActionPerformed

    private void NewBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewBoardActionPerformed

        //Create a MapEditor Dialog
        map_editor.createNewMapDialog();


    }//GEN-LAST:event_NewBoardActionPerformed

    private void SaveBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBoardActionPerformed
        //Save Map in XML
        map_editor.SaveMap();
    }//GEN-LAST:event_SaveBoardActionPerformed

    private void LoadBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadBoardActionPerformed
        map_editor.LoadMap();
    }//GEN-LAST:event_LoadBoardActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu Export;
    private javax.swing.JMenuItem GenerateGame;
    private javax.swing.JMenuItem LoadBoard;
    private javax.swing.JMenuItem LoadProject;
    private javax.swing.JMenu Map;
    private javax.swing.JMenu Menu;
    private javax.swing.JMenuItem NewBoard;
    private javax.swing.JMenuItem NewProject;
    private javax.swing.JMenuItem SaveBoard;
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

    /**
     * @return the map_editor
     */
    public MapEditor getMap_editor() {
        return map_editor;
    }

    /**
     * @param map_editor the map_editor to set
     */
    public void setMap_editor(MapEditor map_editor) {
        this.map_editor = map_editor;
    }

}
