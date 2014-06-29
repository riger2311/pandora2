/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pandora;

/**
 *
 * @author sarah
 */
public class SaveBoard {
    
  Game boardGame = new Game();
  String giveName = boardGame.getNameOfGame();
  String givePlayers = "" + boardGame.getNumberOfPlayers();
  String giveWidth = "" + boardGame.getFieldWidth();
  String giveHeight = "" + boardGame.getFieldHeight();
  String giveDiceYes = "" + boardGame.getDiceEnabled();
  String giveDiceNr = "" + boardGame.getDices();
  String giveDiceEyes = "" + boardGame.getEyesOfDice();
  
}
