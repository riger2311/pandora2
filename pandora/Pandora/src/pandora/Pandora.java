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
                Wizard newWizard = new Wizard(null, true);
                StartDialog start = new StartDialog(null, true, newWizard);
                start.setLocationRelativeTo(null);
                newWizard.setLocationRelativeTo(null);
                start.setVisible(true);

                //Setting a Main JFrame to display the RulesEditor Panel
                //TEMPORARY CODE
                Mainframe main = new Mainframe();
                main.setSize(800,600);

                

                RulesEditor rulesPanel = new RulesEditor();
                
                main.getjTabbedPane1().add("Regeln", rulesPanel);
                main.validate();
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
