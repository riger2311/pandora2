/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pandora;

/**
 *
 * @author dominikmocher
 */
public class Game {
    
      Boolean rolling;
      private String nameOfGame;
      private int numberOfPlayers;
      private int fieldWidth;
      private int fieldHeight;
      private Boolean diceEnabled;
      private int eyesOfDice;
      private int dices;
      private int tokensPerPlayer;
      
      

    public Game() {
        this.rolling = false;
    }
      
      
      void setRolling(Boolean value)
      {
          this.rolling = value;
      }
      
      Boolean getRolling()
      {
          return this.rolling;
      }

    /**
     * @return the nameOfGame
     */
    public String getNameOfGame() {
        return nameOfGame;
    }

    /**
     * @param nameOfGame the nameOfGame to set
     */
    public void setNameOfGame(String nameOfGame) {
        this.nameOfGame = nameOfGame;
    }

    /**
     * @return the numberOfPlayers
     */
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    /**
     * @param numberOfPlayers the numberOfPlayers to set
     */
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    /**
     * @return the fieldWidth
     */
    public int getFieldWidth() {
        return fieldWidth;
    }

    /**
     * @param fieldWidth the fieldWidth to set
     */
    public void setFieldWidth(int fieldWidth) {
        this.fieldWidth = fieldWidth;
    }

    /**
     * @return the fieldHeight
     */
    public int getFieldHeight() {
        return fieldHeight;
    }

    /**
     * @param fieldHeight the fieldHeight to set
     */
    public void setFieldHeight(int fieldHeight) {
        this.fieldHeight = fieldHeight;
    }

    /**
     * @return the diceEnabled
     */
    public Boolean getDiceEnabled() {
        return diceEnabled;
    }

    /**
     * @param diceEnabled the diceEnabled to set
     */
    public void setDiceEnabled(Boolean diceEnabled) {
        this.diceEnabled = diceEnabled;
    }

    /**
     * @return the eyesOfDice
     */
    public int getEyesOfDice() {
        return eyesOfDice;
    }

    /**
     * @param eyesOfDice the eyesOfDice to set
     */
    public void setEyesOfDice(int eyesOfDice) {
        this.eyesOfDice = eyesOfDice;
    }

    /**
     * @return the dices
     */
    public int getDices() {
        return dices;
    }

    /**
     * @param dices the dices to set
     */
    public void setDices(int dices) {
        this.dices = dices;
    }

    /**
     * @return the tokensPerPlayer
     */
    public int getTokensPerPlayer() {
        return tokensPerPlayer;
    }

    /**
     * @param tokensPerPlayer the tokensPerPlayer to set
     */
    public void setTokensPerPlayer(int tokensPerPlayer) {
        this.tokensPerPlayer = tokensPerPlayer;
    }
    
}
