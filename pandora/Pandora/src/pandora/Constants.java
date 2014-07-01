/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pandora;

/** class for constants in the whole program
 * use it like the #define in c
 *
 * @author dominikmocher
 */
public class Constants {
    
    //constants for movement check in RulesEditor
    public static final int LOWER_MOVEMENT_BOUND = 1;
    public static final int UPPER_MOVEMENT_BOUND = 10;
    
    //boundaries for number of players in Wizard 
    public static final int LOWER_PLAYER_BOUND = 2;
    public static final int UPPER_PLAYER_BOUND = 6;
    
    //minimum value in Wizard
    public static final int LOWER_BOUND = 2;
    
    //field size in Wizard
    public static final int FIELD_SIZE = 42;
    //number of dices in Wizard
    public static final int MAX_DICES = 7;
    //number of eyes of the dices
    public static final int MAX_EYES = 20;
    //maximum amount of tokens per player
    public static final int MAX_TOKENS = 6;
    
    
    //no objects of this class allowed
    private void Constant(){}
    
}
