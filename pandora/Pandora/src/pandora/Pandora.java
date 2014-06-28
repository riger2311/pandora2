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
                //creates the startdialog and the wizard
                Wizard newWizard = new Wizard(null, true);
                StartDialog start = new StartDialog(null, true, newWizard);
                
                //Setting a Main JFrame to display the RulesEditor Panel
                //TEMPORARY CODE
                Mainframe main = new Mainframe();
                main.setSize(800,600);

                
                Game rules = new Game();
                RulesEditor rulesPanel = new RulesEditor();
                
                main.getjTabbedPane1().add("Regeln", rulesPanel);
                main.validate();
                
//main.setMapEditor(mapPanel);
                //main.
                //main.setRulesEditor(rulesPanel);
                  
                //methods to display the RulesEditor Panel
                //TEMPORARY CODE
                //main.add(mainframe);
                main.setVisible(true);
                //implement validate
                //main.pack(); // delete because of validate
                
                /*
                JFrame frame = new JFrame("JavaFX 2 in Swing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                JApplet applet = new Pandora();
                applet.init();
                
                frame.setContentPane(applet.getContentPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
                applet.start();
                
                Game rules = new Game();
                RulesEditor rules_editor = new RulesEditor();
                
                */
            }
        });
    }
    
}
