/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pandora;

import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author dominikmocher
 */
public class Game {
    
      private String nameOfGame;
      private int numberOfPlayers;
      private int fieldWidth;
      private int fieldHeight;
      private Boolean diceEnabled;
      private int eyesOfDice;
      private int dices;
      private int tokensPerPlayer;
      private int staticMovement; //movement, if dices are not enabled
      
      

    public Game() {
        nameOfGame = " ";
        numberOfPlayers = 2;
        fieldWidth = 2;
        fieldHeight = 2;
        diceEnabled = true;
        eyesOfDice = 6;
        dices = 1;
        tokensPerPlayer = 1;
        staticMovement = 1;
        
    }
      void reset()
      {
        nameOfGame = " ";
        numberOfPlayers = 2;
        fieldWidth = 2;
        fieldHeight = 2;
        diceEnabled = true;
        eyesOfDice = 6;
        dices = 1;
        tokensPerPlayer = 1;
        setStaticMovement(1);
        
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

    /**
     * @return the staticMovement
     */
    public int getStaticMovement() {
        return staticMovement;
    }

    /**
     * @param staticMovement the staticMovement to set
     */
    public void setStaticMovement(int staticMovement) {
        this.staticMovement = staticMovement;
    }
    
    /** loads game-class from xml-file
    * @param fileName the file name to load from
    */
    public void loadProject(String fileName)
    {
        //TODO include img
        SAXBuilder parser = new SAXBuilder();
        
        try
        {
	  Document doc = parser.build(new File(fileName));
	  Element root = doc.getRootElement();
                        
          //gets element, gets as string
          Element nameOfGame_ = root.getChild("NameOfGame");
          nameOfGame = nameOfGame_.getText();
          
          Element numberOfPlayers_= root.getChild("NumberOfPlayers");
          numberOfPlayers = Integer.parseInt(numberOfPlayers_.getText());

          Element fieldWidth_= root.getChild("FieldWitdth");
          fieldWidth = Integer.parseInt(fieldWidth_.getText());
          
          Element fieldHeight_= root.getChild("FieldHeight");
          fieldHeight = Integer.parseInt(fieldHeight_.getText());
          
          Element diceEnabled_= root.getChild("DiceEnabled");
          diceEnabled = Boolean.parseBoolean(diceEnabled_.getText());
          
          Element eyesOfDice_= root.getChild("EyesOfDice");
          eyesOfDice = Integer.parseInt(eyesOfDice_.getText());
          
          Element dices_= root.getChild("Dices");
          dices = Integer.parseInt(dices_.getText());

          Element tokensPerPlayer_= root.getChild("TokensPerPlayer");
          tokensPerPlayer = Integer.parseInt(tokensPerPlayer_.getText());
          
          Element staticMovement_= root.getChild("StaticMovement");
          staticMovement = Integer.parseInt(staticMovement_.getText());
          
          
        }
        catch(Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
                        
        
    }
    
    /** loads game-class from xml-file
    * @param fileName the file name to stor the project
    */
    public void saveProject(String fileName)
    {
        
        String xml =
                "<map>" +
                "   <NameOfGame></NameOfGame>" +
                "   <NumberOfPlayers></NumberOfPlayers>" +
                "   <FieldWitdth></FieldWitdth>" +
                "   <FieldHeight></FieldHeight>" +
                "   <DiceEnabled></DiceEnabled>" +
                "   <EyesOfDice> + </EyesOfDice>" +
                "   <Dices> + </Dices>" +
                "   <TokensPerPlayer> + </TokensPerPlayer>" +
                "   <StaticMovement> + </StaticMovement>" +
                "</map>";
        
        SAXBuilder builder = new SAXBuilder();
        
        try 
        {
          // Create XML document
          Document document = builder.build(new StringReader(xml));
            
          // Get root 
          Element root = document.getRootElement();
     
          Element nameOfGame_ = root.getChild("NameOfGame");
          nameOfGame_.setText(nameOfGame);                   
          
          Element numberOfPlayers_ = root.getChild("NumberOfPlayers");
          numberOfPlayers_.setText(Integer.toString(numberOfPlayers));

          Element fieldWidth_= root.getChild("FieldWitdth");
          fieldWidth_.setText(Integer.toString(fieldWidth));

          Element fieldHeight_= root.getChild("FieldHeight");
          fieldHeight_.setText(Integer.toString(fieldHeight));
          
          Element diceEnabled_= root.getChild("DiceEnabled");
          diceEnabled_.setText(Boolean.toString(diceEnabled));

          Element eyesOfDice_= root.getChild("EyesOfDice");
          eyesOfDice_.setText(Integer.toString(eyesOfDice));
          
          Element dices_= root.getChild("Dices");
          dices_.setText(Integer.toString(dices));

          Element tokensPerPlayer_= root.getChild("TokensPerPlayer");
          tokensPerPlayer_.setText(Integer.toString(tokensPerPlayer));
          
          Element staticMovement_= root.getChild("StaticMovement");
          staticMovement_.setText(Integer.toString(staticMovement));
            
            // Output the file
            FileWriter file;
            System.out.println("hi");
			
			// Check to see if the .box extension doesn't already exist on the file
			if (!fileName.contains(".box"))
			{
				// If it doesn't, add it
				file = new FileWriter(fileName + ".box");
			}
			else
			{
				// Otherwise, don't add it
				file = new FileWriter(fileName);
			}
			
            XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
            outputter.output(document, file);
            
        }
        catch(Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
        
    }
    
}
