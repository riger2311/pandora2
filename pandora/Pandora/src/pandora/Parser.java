/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pandora;


import java.io.File;
import java.io.FileWriter;
import javax.script.*;
/**
 *
 * @author projexter
 */
public class Parser {
    Game game;
    
    public Parser(Game game_){
      game = game_;  
      // To use the game members
    }
  
    
    //Parse
    public void parseBoard() throws Exception 
    {
    
    FileWriter fileWriter = null;
    String project_name = game.getNameOfGame();
    
    //Dynamic Variables in parsing text
    String background_file = ConstantStrings.BG_FILE;
    String pieces_file = ConstantStrings.PIECES_FILE;
    
    //Game variables for use to dynamic parsing
    int player = game.getNumberOfPlayers();

    String source;
   
    String str01_draw =
        "var BLOCK_SIZE = 75;\n" +
        "var IN_PLAY = 1;\n" +
        "var LOST = 0;\n" +
        "var currentTurn = 0; //starting with player 1\n" +
        "var selectedToken = null;\n" +
        "function draw()\n" +
        "{\n" +
        "   canvas = document.getElementById('board');\n" +
        "   if (canvas.getContext)\n" +
        "   {\n" +
        "      ctx = canvas.getContext('2d');\n" +
        "      document.body.background = \""+ background_file +"\";\n" +
        "      params();\n" +
        "      tokenIMG = new Image();\n" +
        "      tokenIMG.src = '" + pieces_file + "';\n" +
        "      tokenIMG.onload = drawAllTokens;\n" +
        "      canvas.addEventListener('click', click_on_board, false);\n" +
        "   }\n" +
        "else \n" +
        "   {\n" +
        "       alert(\"You are currently using IE.STOP!\");\n" +
        "   }\n" +
        "}\n" ;
       
    String str02_drawAllTokens = 
      
        "function drawAllTokens() \n" +
    "{\n";
    
    //draw Tokens of each Player
    //number defines tokens of which players
    //using later in function "getImageCoords"
    for(int i = 0 ; i < game.getNumberOfPlayers(); i++)
    {
        str02_drawAllTokens += "drawTeam(json.player" + Integer.toString(i+1) + ", "+Integer.toString(i+1)+");\n";
    }
    str02_drawAllTokens += "}\n" ;
    
    String str03_drawTeam =
        "function drawTeam(team, playerID) \n" +
        "{ \n" +
        "  var teamCounter;\n" +
        "  //loop through every single token to draw it\n" +
        "  for (teamCounter = 0; teamCounter < team.length; teamCounter++) \n" +
        "  { \n" +
        "    drawToken(team[teamCounter], playerID);\n" +
        "  } \n" +
        "}\n";
    
    String str04_drawtoken =
        "function drawToken(curToken, playerID) \n" +
        "{ \n" +
        "  //draw current token \n" +
        "  //get id of current token \n" +
        "  var imageCoords = getImageCoords(curToken.token, playerID); \n" +
        "  // Draw the piece onto the canvas \n" +
        "  ctx.drawImage \n" +
        "   (tokenIMG, //get image of all tokens \n" +
        "    imageCoords.x, //get start clipped image x Coord \n" +
        "    imageCoords.y, //get start clipped image y Coord \n" +
        "    BLOCK_SIZE, //width of clipped image \n" +
        "    BLOCK_SIZE, //height of clipped image \n" +
        "    curToken.col * BLOCK_SIZE, // Sarting X Coord of image \n" +
        "    curToken.row * BLOCK_SIZE, //Starting Y Coord of image \n" +
        "    BLOCK_SIZE, //width of used image(may be resized) \n" +
        "    BLOCK_SIZE); //height of used image(may also be resized) \n" +
        "} \n" ;
    
    String str05_getImageCoords =
        "function getImageCoords(token, playerID) \n" +
        "{ \n" +
        "  var imageCoords =  \n" +
        "  { \n" +
        "    \"x\": token * BLOCK_SIZE,  \n" +
        "    \"y\": ((playerID - 1) * BLOCK_SIZE) \n" +
        "  };  \n" +
        "  return imageCoords; \n" +
        "} \n" ;        
            
            
    String str06_params =  
        "function params() \n" +
        "{ \n" +
        "  json =  \n" +
        "  { \n";
        
        for(int i = 0 ; i < game.getNumberOfPlayers(); i++)
        {
            str06_params +="    \"player" + Integer.toString(i+1) + "\":  \n" +
                           "    [ \n";
            
                for(int j= 0 ; j < game.getTokensPerPlayer(); j++)
                {    
                str06_params += "      { \n" +
                                "        \"token\": 0, \n" + //Token Position in Tiles
                                "        \"row\": 0, \n" + //Starting Position 
                                "        \"col\": 0, \n" + //Starting Position
                                "        \"status\": IN_PLAY \n" + 
                                "      }, \n";
                }    
            str06_params += "    ], \n";
        }    
        
        str06_params += "  }; \n" +
                        "} \n" ;
    
    String str07_clickonboard =
        "function click_on_board(ev)  \n" +
        "{ \n" +
        "    //check x and y coord of clicked area \n" +
        "    //ev.clientX/ev.clientY = global x and y coords \n" +
        "    //canvas.offsetLeft/Top = local x and y coords(coords in one block) \n" +
        "    var x_coord = ev.clientX - canvas.offsetLeft; \n" +
        "    var y_coord = ev.clientY - canvas.offsetTop; \n" +
        "    var clickedBlock = block_coord(x_coord, y_coord); \n" +
        "    //if currently no block is selected DO \n" +
        "    //token in this block? \n" +
        "    if(selectedToken === null) \n" +
        "    { \n" +
        "        checkIfTokenClicked(clickedBlock); \n" +
        "    } \n" +
        "    else \n" +
        "    { \n" +
        "        processMove(clickedBlock); \n" +
        "    } \n" +
        "} \n" ;
    
    String str08_blockcoord =
        "function block_coord(x_coord, y_coord) \n" +
        "{ \n" +
        "  var block =  \n" +
        "  { \n" +
        "    \"row\": Math.floor(y_coord / BLOCK_SIZE), \n" +
        "    \"col\": Math.floor(x_coord / BLOCK_SIZE) \n" +
        "  };  \n" +
        "  return block;  \n" +
        "}         \n" ;
    
    String str09_checkIfTokenClicked =
        "function checkIfTokenClicked(clickedBlock)  \n" +
        "{  \n" +
        "  var tokenAtBlock = getTokenAtBlock(clickedBlock);  \n" +
        "  if (tokenAtBlock !== null)  \n" +
        "  {  \n" +
        "    selectToken(tokenAtBlock);  \n" +
        "  }  \n" +
        "}  \n" ;
    
   String str10_gettokenatblock =
        "function getTokenAtBlock(clickedBlock)  \n" +
        "{  \n" +
        "  var team;  \n" +
        "  //which team is selected  \n" +
        "  //global var currentTurn saves team which turn it is  \n" +
        "  switch(currentTurn)  \n" +
        "  {  \n";
        
        //loop
        for(int i = 0 ; i < game.getNumberOfPlayers(); i++)
        {
           str10_gettokenatblock += "    case " + Integer.toString(i) + ":  \n" +
           "        team = json.player" + Integer.toString(i+1) + ";  \n" ;
           if (i != game.getNumberOfPlayers() - 1)
           {
             str10_gettokenatblock += "        break;  \n";
           }
        }
        str10_gettokenatblock += "  }  \n" +   
        "  return getTokenAtBlockForTeam(team, clickedBlock);  \n" +
        "}  \n" ;
    
    String str11_getTokenAtBlockForTeam =
        "function getTokenAtBlockForTeam(team, clickedBlock)  \n" +
        "{  \n" +
        "  var curToken = null;  \n" +
        "  var counter = 0;  \n" +
        "  var tokenAtBlock = null;  \n" +
        "  //loop through all tokens of current team  \n" +
        "  for (counter = 0; counter < team.length; counter++)   \n" +
        "  {  \n" +
        "    curToken = team[counter];  \n" +
        "    //if currentToken is on board,  \n" +
        "   // and clicked coords of box are same as  \n" +
        "   //those of currentToken DO  \n" +
        "    if(curToken.status === IN_PLAY &&  \n" +
        "      curToken.col === clickedBlock.col &&  \n" +
        "      curToken.row === clickedBlock.row)  \n" +
        "    {  \n" +
        "      curToken.position = counter;  \n" +
        "      tokenAtBlock = curToken;  \n" +
        "      counter = team.length;  \n" +
        "    }  \n" +
        "  }  \n" +
        "  return tokenAtBlock;  \n" +
        "}  \n" ;
            
            
    String str12_selectToken =
        "function selectToken(tokenAtBlock) \n" +
        "{ \n" +
        "  // Draw outline \n" +
        "  ctx.lineWidth = 5; //if necessary change! \n" +
        "  ctx.strokeStyle = '#fb0006';// if necessary change! \n" +
        "  ctx.strokeRect((tokenAtBlock.col * BLOCK_SIZE) + 5,//x value start \n" +
        "                 (tokenAtBlock.row * BLOCK_SIZE) + 5,// y value start \n" +
        "                  BLOCK_SIZE - (5 * 2),              //width \n" +
        "                  BLOCK_SIZE - (5 * 2));             //height \n" +
        "  selectedToken = tokenAtBlock; \n" +
        "} \n" ;
    
    String str13_processMove =
        "function processMove(clickedBlock)\n" +
        "{\n" +
        "  var tokenAtBlock = getTokenAtBlock(clickedBlock);\n" +
        "  var enemyToken = getEnemy(clickedBlock);\n" +
        "  if (tokenAtBlock !== null)\n" +
        "  {\n" +
        "    //removeSelection(selectedToken);\n" +
        "    checkIfTokenClicked(clickedBlock);      \n" +
        "  }\n" +
        "  else if (checkMovement(selectedToken, clickedBlock) === true)\n" +
        "  {\n" +
        "    moveToken(clickedBlock, enemyToken);\n" +
        "  }\n" +
        "}\n" ;
            
    String str14_getEnemy =
        "function getEnemy(clickedBlock) \n" +
        "{ \n" +
        "  var team; \n" +
        "  //BEWARE ORDER!!!! \n" +
        "  //change if more than 2 players \n" +
        "  switch(currentTurn) \n" +
        "  { \n" +
        "    case 0: \n" +
                "team = json.player2; \n" +
                "break; \n" +
        "    case 1: \n" +
        "team = json.player1; \n" +
        "  } \n" +
        "  return getTokenAtBlockForTeam(team, clickedBlock); \n" +
        "}             \n" ;
    
    
    String str15_removeSelection =
        "function removeSelection(selectedToken) \n" +
        "{ \n" +
        "  //drawToken(selectedToken, currentTurn); \n" +
        "} \n" ;
    
    String str16_checkMovement =    
        "function checkMovement(selectedToken, clickedBlock) \n" +
        "{ \n" +
        "  var tokenrow = selectedToken.row; \n" +
        "  var tokencol = selectedToken.col; \n" +
        "  dice = document.getElementById('textarea').value; \n" +
        "  if (tokenrow === clickedBlock.row) \n" +
        "  { \n" +
        "    if (Math.abs(tokencol - clickedBlock.col) == dice) \n" +
        "    { \n" +
        "      return true; \n" +
        "    } \n" +
        "    else \n" +
        "    { \n" +
        "      return false; \n" +
        "    } \n" +
        "  } \n" +
        "  else if (tokencol === clickedBlock.col) \n" +
        "  { \n" +
        "    if (Math.abs(tokenrow - clickedBlock.row) == dice) \n" +
        "    { \n" +
        "      return true; \n" +
        "    } \n" +
        "    else \n" +
        "    { \n" +
        "      return false; \n" +
        "    } \n" +
        "  } \n" +
        "  else \n" +
        "  { \n" +
        "    return false \n" +
        "  } \n" +
        "} \n" ;
    
    String str17_toDice =
        "function toDice() \n" +
        "{ \n" +
        "  //NOTE Math.random generates float values between 0 and 1 \n" +
        "  var rnd = 1 + Math.floor(Math.random() * " + game.getEyesOfDice() + "); \n" +
        "  document.getElementById('textarea').value = rnd; \n" +
        "  document.getElementById('button').style.visibility = 'hidden'; \n" +
        "  return rnd; \n" +
        "} \n" ;

            
    String str18_moveToken =
        "function moveToken(clickedBlock, enemyToken) \n" +
        "{ \n" +
        "  // Clear the block in the original position \n" +
        "  // implement here rules and mission goal \n" +
        "  //drawBlock(selectedPiece.col, selectedPiece.row); \n" +
        "  var team = (currentTurn === 0 ? json.player1 : json.player2); \n" +
        "  var opposite = (currentTurn !== 1 ? json.player1 : json.player2); \n" +
        "  team[selectedToken.position].col = clickedBlock.col; \n" +
        "  team[selectedToken.position].row = clickedBlock.row; \n" +
            
        "  if (enemyToken !== null) \n" +
        "  { \n" +
        "    // Clear the piece your about to take \n" +
        "    //TODO implement function due to missing draw tiles \n" +
        "    //drawBlock(enemyToken.col, enemyPiece.row);   \n" +
        "    opposite[enemyToken.position].status = LOST; \n" +
        "  } \n" +
        "  // Draw the piece in the new position \n" +
        "  drawToken(selectedToken, currentTurn + 1); \n" +
            
        "  var goalRow = 2; \n" + // hier brauchen wir die coords des zielblocks
        "  var goalCol = 4; \n" +   
        "  if ((selectedToken.col === goalCol) && (selectedToken.row === goalRow)) \n" +
        "  {\n" +
        "    alert(\"Du gewinnst!\");\n" +
        "  } \n" +
            
        "  currentTurn = (currentTurn === 0 ? 1 : 0); \n" +
        "  document.getElementById('button').style.visibility = 'visible'; \n" +
        "  selectedtoken = null; \n" +
        "} \n" ;
        
        
    String str19_getOwner =
        "function getOwner(token) \n" +
        "{ \n" +
        "  var count; \n" +
        "  var owner = null; \n" +
        "  for (count = 0; count < " + game.getTokensPerPlayer() + "; count++)  \n" +
        "  { \n" +
        "    token = player1[count]; \n" +
        "    if(token.status === IN_PLAY && \n" +
        "      token.col === clickedBlock.col && \n" +
        "      token.row === clickedBlock.row) \n" +
        "    { \n" +
        "      count = player1.length; \n" +
        "      owner = player1; \n" +
        "    } \n" +
        "  } \n";
    
        for(int i = 1 ; i <= game.getNumberOfPlayers(); i++)
        {
        str19_getOwner +="  if(owner === null) \n" +
        "  { \n" +
        "    for (count = 0; count < player" + Integer.toString(i+1) + ".length; count++)  \n" +
        "  { \n" +
        "    token = player" + Integer.toString(i+1) + "[count]; \n" +
        "    if(token.status === IN_PLAY && \n" +
        "      token.col === clickedBlock.col && \n" +
        "      token.row === clickedBlock.row) \n" +
        "    { \n" +
        "      count = player" + Integer.toString(i+1) + ".length; \n" +
        "      owner = player" + Integer.toString(i+1) + "; \n" +
        "    } \n" +
        "  } \n" +
        "  } \n";
        }
        
        
        str19_getOwner += "  return owner; \n" +
        "} \n" ;
        
    
          
    // merges the function strings together to the parsed whole .js programm
    source = str01_draw + 
             str02_drawAllTokens + 
             str03_drawTeam + 
             str04_drawtoken +
             str05_getImageCoords +
             str06_params +
             str07_clickonboard +
             str08_blockcoord +
             str09_checkIfTokenClicked +
             str10_gettokenatblock +
             str11_getTokenAtBlockForTeam +
             str12_selectToken +
             str13_processMove +
             str14_getEnemy +
             str15_removeSelection +
             str16_checkMovement +
             str17_toDice +
             str18_moveToken +
             str19_getOwner;
  
    
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName(ConstantStrings.JAVA_ENGINE);
        
        // create directory
        File directory = new File(project_name);
        if (directory.exists())
        {
                System.out.println(ConstantStrings.DIRECTORY_EXISTS);
        }
        else 
        {
            directory.mkdir();
        }
        
        // evaluate JavaScript code from String
         File newTextFile = new File(ConstantStrings.DOT_SLASH + project_name + ConstantStrings.SLASH + project_name + ".js" /*ConstantStrings.BOARD +ConstantStrings.JS*/);
            fileWriter = new FileWriter(newTextFile);
            fileWriter.write(source);
            fileWriter.close();
        engine.eval(source);
        //engine.eval("print('Hello, World')");
        

        
    }

    public void parseMain() throws Exception
    {
        FileWriter fileWriter = null;
        String project_name = game.getNameOfGame();

        String sourcehtml
                = "<!DOCTYPE html>                       \n"
                + "<html lang=\"en\">                      \n"
                + "<head>                                \n"
                + "<meta charset=\"utf-8\" />            \n"
                + "<title>HTML5 Canvas - " + project_name + "</title> \n"
                + "<script src='" + project_name + ".js'></script>         \n"
                + "</head>                                  \n"
                + "<body onload='draw();'>                  \n"
                + "<form>                                   \n"
                + "<button onclick=\"toDice()\"style = \"visibility:visible\" "
                + "id=\"button\" value=\"0\" type=\"button\">Dice</button> \n"
                + "<textarea style = \"resize:none\" rows=\"1\" cols=\"1\" id=\"textarea\" "
                + "name=\"text\" disabled = \"disabled\"></textarea> \n"
                + "</form> \n"
                + "<div> \n"
                + "<canvas id=\"board\" width=\"800\" height=\"800\"></canvas> \n"
                + "</div> \n"
                + "</body> \n"
                + "</html> \n";

        // create directory
        File directory = new File(project_name);
        if (directory.exists()) {
            System.out.println(ConstantStrings.DIRECTORY_EXISTS);
        } else {
            directory.mkdir();
        }

        File html5 = new File(ConstantStrings.DOT_SLASH + project_name + ConstantStrings.SLASH + project_name + ConstantStrings.HTML);
        fileWriter = new FileWriter(html5);
        fileWriter.write(sourcehtml);
        fileWriter.close();
    }    
    
    public void parseReader() throws Exception 
    {
        FileWriter fileWriter = null;
        String project_name = game.getNameOfGame();
        
        String source = "var game_name = " + game.getNameOfGame() + ";\n" + //document.Wizard.getValue(giveName);
                        "var player_nr = " + game.getNumberOfPlayers() + ";\n" + //session.getValue(givePlayers);
                        "var width = " + game.getFieldWidth() + ";\n" + //Wizard.getValue(giveWidth);
                        "var height = " + game.getFieldHeight() + ";\n" + //Wizard.getValue(giveHeight);
                        "var dizes = " + game.getDices() + ";\n" + //Wizard.getValue(giveDizes);
                        "var dizes_count = " + game.getEyesOfDice() + ";\n"; //Wizard.getValue(giveDizesCount);

        
        // create directory
        File directory = new File(project_name);
        if (directory.exists()) {
            System.out.println(ConstantStrings.DIRECTORY_EXISTS);
        } else {
            directory.mkdir();
        }
        
        
        // evaluate JavaScript code from String
        File newTextFile = new File(ConstantStrings.DOT_SLASH + project_name + ConstantStrings.SLASH + ConstantStrings.READER /*+ ConstantStrings.JS*/);
          fileWriter = new FileWriter(newTextFile);
          fileWriter.write(source);
          fileWriter.close();

        
        
    }
    
}
