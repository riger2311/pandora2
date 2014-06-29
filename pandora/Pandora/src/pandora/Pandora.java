/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pandora;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import pandora.TileMap.*;



/**
 *
 * @author dominikmocher
 */
public class Pandora extends JApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } 
                catch (Exception e) {
                  System.out.println("Error happened...");
                }
                try{
                //initializing game class to store values
                Game gameValues = new Game();
                
                //creates the startdialog and the wizard
                Wizard newWizard = new Wizard(null, true, gameValues);
                StartDialog start = new StartDialog(null, true, newWizard, gameValues);
                
                start.setVisible(true);

                //Setting a Main JFrame to display the RulesEditor Panel
                Mainframe main = new Mainframe(gameValues);
                main.setSize(800,600);

                
                //TODO: add MapEditor to TabbedPanel
                //MapEditor mapEditor = new MapEditor(gameValues);
                //main.getjTabbedPane1().add("Map-Editor", mapEditor);

                RulesEditor rulesPanel = new RulesEditor(gameValues);
                
                //adding Tabbe Panel
                main.getjTabbedPane1().add("Regeln", rulesPanel);
                main.validate();
                //setting location of frame to center of screen
                main.setLocationRelativeTo(null);
                main.setVisible(true);
                
                }
                catch(Exception e)
                {
                    System.out.println("Exception: " + e.getMessage());
                }
            }
        });
    }
    
}
