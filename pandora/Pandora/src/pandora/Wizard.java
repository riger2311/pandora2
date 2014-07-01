/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pandora;

import static java.lang.System.out;
import java.util.Arrays;
import javax.swing.JOptionPane;
/**
 *
 * @author projexter
 */
public class Wizard extends javax.swing.JDialog {

    private 
            Game game_;
            String game_name_;
            int number_of_players_;
            int width_;
            int height_;
            int dizes_;
            int dizes_count_;
            Boolean dizes_enabled = true;
            Boolean wizard_ok = false;
            int tokens_per_player_;
            int total_tokens_;
            
    /**
     * Creates new form Wizard
     */
    public Wizard(java.awt.Frame parent, boolean modal, Game game) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        game_ = game;
        t_number_of_players.removeAllItems();
        for(int i = Constants.LOWER_PLAYER_BOUND; i <= Constants.UPPER_PLAYER_BOUND; i++)
        {
          t_number_of_players.addItem(i);
        }
        game_name_ = "42"; //initialize to avoid exceptions
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        game_name_lab = new javax.swing.JLabel();
        t_game_name_ = new javax.swing.JTextField();
        number_of_players_lab = new javax.swing.JLabel();
        t_number_of_players = new javax.swing.JComboBox();
        number_of_players_lab1 = new javax.swing.JLabel();
        t_width = new javax.swing.JTextField();
        t_height = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        error_label = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        t_dizes = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        t_dizes_max_val = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        t_token = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        game_name_lab.setText(ConstantStrings.NAME_OF_GAME);

        t_game_name_.setText(ConstantStrings.NAME_OF_GAME_FIELD);

        number_of_players_lab.setText(ConstantStrings.NUMBER_OF_PLAYERS);

        t_number_of_players.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        t_number_of_players.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_number_of_playersActionPerformed(evt);
            }
        });

        number_of_players_lab1.setText(ConstantStrings.SIZE_OF_FIELD);

        t_width.setText("10");

        t_height.setText("10");
        t_height.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_heightActionPerformed(evt);
            }
        });

        jLabel2.setText("x");

        jLabel3.setText(ConstantStrings.SIZE_RESTRIC);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        error_label.setForeground(new java.awt.Color(204, 0, 0));

        jLabel4.setText(ConstantStrings.NUM_OF_DICE);

        t_dizes.setText("1");
        t_dizes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_dizesActionPerformed(evt);
            }
        });

        jLabel5.setText(ConstantStrings.EYE_OF_DICE);

        t_dizes_max_val.setText("6");
        t_dizes_max_val.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_dizes_max_valActionPerformed(evt);
            }
        });

        jLabel6.setText("(2 - 20)");

        jLabel7.setText(ConstantStrings.NUM_OF_TOKENS);

        t_token.setText("4");
        t_token.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_tokenActionPerformed(evt);
            }
        });

        jLabel8.setText("(1 - 128)");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pandora/gandalf.png"))); // NOI18N
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel9.setSize(new java.awt.Dimension(75, 113));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText(ConstantStrings.WIZARD_HEAD_LABEL);

        jLabel10.setText(ConstantStrings.WIZARD_INFO);

        jLabel11.setText("(0 - 7)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(number_of_players_lab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(number_of_players_lab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(game_name_lab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(76, 76, 76)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(t_number_of_players, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(t_width, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(20, 20, 20)
                                                            .addComponent(jLabel2)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(t_height, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jLabel3))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(t_dizes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jLabel11))
                                                        .addComponent(t_game_name_)))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(77, 77, 77)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(t_dizes_max_val, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jLabel6))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(t_token, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jLabel8))))))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel10))
                                .addGap(0, 173, Short.MAX_VALUE))
                            .addComponent(error_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(error_label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(game_name_lab)
                        .addComponent(t_game_name_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_number_of_players, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(number_of_players_lab))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_width, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number_of_players_lab1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_dizes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_dizes_max_val, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_token, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t_number_of_playersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_number_of_playersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_number_of_playersActionPerformed

    private void t_heightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_heightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_heightActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    game_name_ = t_game_name_.getText();
    number_of_players_ = t_number_of_players.getSelectedIndex() + 1;   
    
    try {      

    width_ = Integer.parseInt(t_width.getText());
    height_ = Integer.parseInt(t_height.getText());
    dizes_ = Integer.parseInt(t_dizes.getText());
    dizes_count_ = Integer.parseInt(t_dizes_max_val.getText());
    tokens_per_player_ = Integer.parseInt(t_token.getText());
    
    } catch (NumberFormatException e) {
        System.out.println(ConstantStrings.ERROR_INPUT);
        error_label.setText(ConstantStrings.ERROR_INPUT);
        return;
    }
    
    if(width_ > Constants.FIELD_SIZE || width_ < Constants.LOWER_BOUND)
    {     
        error_label.setText(ConstantStrings.ERROR_WIDTH);
        return;
    }
    else if(height_ > Constants.FIELD_SIZE || height_ < Constants.LOWER_BOUND)
    {
        error_label.setText(ConstantStrings.ERROR_HEIGHT);
        return;
    }
    else if(dizes_ > Constants.MAX_DICES || dizes_ < 0)
    {
        error_label.setText(ConstantStrings.ERROR_HEIGHT);
        return;
    }
    else if(dizes_count_ > Constants.MAX_EYES || dizes_count_ < Constants.LOWER_BOUND)
    {
        error_label.setText(ConstantStrings.ERROR_HEIGHT);
        return;
    }
    else if(tokens_per_player_ > Constants.MAX_TOKENS || tokens_per_player_ < 1)
    {
        error_label.setText(ConstantStrings.ERROR_HEIGHT);
        return;
    }
    
    //====================================================
    // Error Handling OK
    // Now save the members and
    //====================================================
    //
    if(dizes_ == 0)
    {
        dizes_enabled = false;
    }
    else
    {
        dizes_enabled = true;
    }
    // Set the variables to the game class
    game_.setNameOfGame(game_name_);
    game_.setDiceEnabled(dizes_enabled);
    game_.setDices(dizes_);
    game_.setEyesOfDice(dizes_count_);
    game_.setFieldHeight(height_);
    game_.setFieldWidth(width_);
    game_.setNumberOfPlayers(number_of_players_);
    game_.setTokensPerPlayer(tokens_per_player_);
        
    dispose();
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void t_dizesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_dizesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_dizesActionPerformed

    private void t_dizes_max_valActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_dizes_max_valActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_dizes_max_valActionPerformed

    private void t_tokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_tokenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_tokenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel error_label;
    private javax.swing.JLabel game_name_lab;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel number_of_players_lab;
    private javax.swing.JLabel number_of_players_lab1;
    private javax.swing.JTextField t_dizes;
    private javax.swing.JTextField t_dizes_max_val;
    private javax.swing.JTextField t_game_name_;
    private javax.swing.JTextField t_height;
    private javax.swing.JComboBox t_number_of_players;
    private javax.swing.JTextField t_token;
    private javax.swing.JTextField t_width;
    // End of variables declaration//GEN-END:variables
}
