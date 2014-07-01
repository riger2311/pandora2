/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pandora;

import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.util.ArrayList;
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
      
      private ArrayList<ArrayList<String>> collisions;
      private ArrayList<Integer> map;
      

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
        collisions = new ArrayList<ArrayList<String>>();
        map = new ArrayList<Integer>();
        this.initMap();
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
        staticMovement = 1;
        collisions = new ArrayList<ArrayList<String>>();
        setMap(new ArrayList<Integer>());
        this.initMap();
      }
      

    /**
     * @return the nameOfGame
     */
    public String getNameOfGame() {
        return nameOfGame;
    }
    
    public void printMap()
    {
        int countmapy ;
        int countmapx ;
        int index=0;
        
        System.out.print("[");
        for (countmapx = 0; countmapx < (fieldWidth);countmapx++)
        {
            System.out.print("[");
            for(countmapy = 0; countmapy < fieldHeight;countmapy++)
            {
             if(countmapy != (fieldHeight-1))
             {
             System.out.print(map.get(index)+",");
             }
             else
             {
               System.out.print(map.get(index));//map.get(countmapy));
             }
             index++;
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
    
    public void initMap()
    {
        
        int countmap =0;
        int width = fieldWidth;
        int height = fieldHeight;
        int summe = width * height;
        while (countmap < summe)
        {
            map.add(countmap, 0);
            countmap++;
        }
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

          Element fieldWidth_= root.getChild("FieldWidth");
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
          
          //loads the collision arraylist
          //gets the size of the arraylist
          Element sizeOfCollision_= root.getChild("SizeOfCollision");
          int sizeOfCollision = Integer.parseInt(sizeOfCollision_.getText());
          
          //loads all elements
          for(int i = 0; i < sizeOfCollision; i++)
          {
              Element collision_= root.getChild("Collision" + i);
              Element collision0_ = collision_.getChild("Collision_0");
              Element collision1_ = collision_.getChild("Collision_1");
              Element collision2_ = collision_.getChild("Collision_2");
              
              ArrayList<String> tempArray = new ArrayList<String>();
              
              tempArray.add(0, collision0_.getText());
              tempArray.add(1, collision1_.getText());
              tempArray.add(2, collision2_.getText());
              
              collisions.add(i, tempArray);
          }
          
          
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
                "   <FieldWidth></FieldWidth>" +
                "   <FieldHeight></FieldHeight>" +
                "   <DiceEnabled></DiceEnabled>" +
                "   <EyesOfDice> + </EyesOfDice>" +
                "   <Dices> + </Dices>" +
                "   <TokensPerPlayer></TokensPerPlayer>" +
                "   <StaticMovement></StaticMovement>" +
                "   <SizeOfCollision></SizeOfCollision>";
              
               for(int i = 0; i < collisions.size(); i++)
               {
                  xml += "<Collision" + i + ">" +
                         "  <Collision_0></Collision_0>" +
                         "  <Collision_1></Collision_1>" +
                         "  <Collision_2></Collision_2>" +
                         "</Collision" + i + ">";
               }                
               
                xml += "</map>";
        
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

          Element fieldWidth_= root.getChild("FieldWidth");
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
          
          
          //saves the collision arraylist
          //saves the size of the arraylist for loading
          Element sizeOfCollision_= root.getChild("SizeOfCollision");
          sizeOfCollision_.setText(Integer.toString(collisions.size()));
          
          for(int i = 0; i < collisions.size(); i++)
          {
              Element collision_= root.getChild("Collision" + i);
              Element collision0_ = collision_.getChild("Collision_0");
              Element collision1_ = collision_.getChild("Collision_1");
              Element collision2_ = collision_.getChild("Collision_2");
              
              collision0_.setText(collisions.get(i).get(0));
              collision1_.setText(collisions.get(i).get(1));
              //no cast needed, is already a string
              collision2_.setText(collisions.get(i).get(2));
          }
          
            // Output the file
            FileWriter file;
			
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

    /**
     * @return the collisions
     */
    public ArrayList<ArrayList<String>> getCollisions() {
        return collisions;
    }

    /**
     * @param collisions the collisions to set
     */
    public void setCollisions(ArrayList<ArrayList<String>> collisions) {
        this.collisions = collisions;
    }

    /**
     * @return the map
     */
    public ArrayList<Integer> getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(ArrayList<Integer> map) {
        this.map = map;
    }
    
}
