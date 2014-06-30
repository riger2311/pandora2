/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pandora;


import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
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
    public static void main (String[] args) throws Exception {
    
    // Testcase    
    Game newGame = new Game();
    newGame.setNameOfGame("TestNamedesSpieles");
    
    FileWriter fileWriter = null;
    String project_name = newGame.getNameOfGame();
    
    String test = "hello";
    String shit = "Hallo5555";
    //Dynamic Variables in parsing text
    String background_file = "background.png";
    String pieces_file = "pieces.png";
    
    //Game variables for use to dynamiv parsing
    //TODO: change hardcoded values to game member values!
    int player = 2;

    String source;
    /*
        "var system = new Array();                       \n" +
        "system['foo'] = function(s) { return '"+test+"'; } \n" +
        "                                                \n" +
        "var results = system.foo('example');            \n" +
        "                                                \n" +
        "if(results == \"hello\") {                      \n" +
        "  print(\""+shit+".\");                        \n" +
        "}                                               \n";
    */
    String str01_draw =
        "var BLOCK_SIZE = 100;\n" +
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
    //TODO DYNAMIC
    //draw Tokens of each PLayer
    //number defines tokens of which players
    //using later in function "getImageCoords"
    for(int i = 1 ; i <= player; i++)
    {
        str02_drawAllTokens += "drawTeam(json.player" + Integer.toString(i) + ", "+Integer.toString(i)+");\n";
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
        "  //TODO how to change y \n" +
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
        "  //TODO DYNAMIC \n" +
        "  json =  \n" +
        "  { \n" +
        "    \"player1\":  \n" +
        "    [ \n" +
        "      { \n" +
        "        \"token\": 0, \n" +
        "        \"row\": 0, \n" +
        "        \"col\": 0, \n" +
        "        \"status\": IN_PLAY \n" +
        "      }, \n" +
        "      { \n" +
        "        \"token\": 1, \n" +
        "        \"row\": 0, \n" +
        "        \"col\": 1, \n" +
        "        \"status\": IN_PLAY \n" +
        "      }, \n" +
        "      { \n" +
        "        \"token\": 0, \n" +
        "        \"row\": 0, \n" +
        "        \"col\": 2, \n" +
        "        \"status\": IN_PLAY \n" +
        "      } \n" +
        "    ], \n" +
        "    \"player2\":  \n" +
        "    [ \n" +
        "      { \n" +
        "        \"token\": 2, \n" +
        "        \"row\": 3, \n" +
        "        \"col\": 1, \n" +
        "        \"status\": IN_PLAY \n" +
        "      }, \n" +
        "      { \n" +
        "        \"token\": 4, \n" +
        "        \"row\": 3, \n" +
        "        \"col\": 0, \n" +
        "        \"status\": IN_PLAY \n" +
        "      } \n" +
        "    ]    \n" +
        "  }; \n" +
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
        "  //TODO DYNAMIC  \n" +
        "  switch(currentTurn)  \n" +
        "  {  \n" +
        "    case 0:  \n" +
        "        team = json.player1;  \n" +
        "        break;  \n" +
        "    case 1:  \n" +
        "        team = json.player2;  \n" +
        "  }  \n" +
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
        "    //NOTE: pls uncomment if removeSelection implementation works\n" +
        "    //TODO\n" +
        "    //removeSelection(selectedToken);\n" +
        "    checkIfTokenClicked(clickedBlock);      \n" +
        "  }\n" +
        "  else if (checkMovement(selectedToken, clickedBlock) === true)\n" +
        "  {\n" +
        "    //TODO implement function \n" +
        "    moveToken(clickedBlock, enemyToken);\n" +
        "  }\n" +
        "}\n" ;
            
    String str14_getEnemy =
        "function getEnemy(clickedBlock) \n" +
        "{ \n" +
        "  var team; \n" +
        "  //BEWARE ORDER!!!! \n" +
        "  //change if more than 2 players \n" +
        "  //TODO DYNAMIC \n" +
        "  switch(currentTurn) \n" +
        "  { \n" +
        "    case 0: \n" +
        "        team = json.player2; \n" +
        "        break; \n" +
        "    case 1: \n" +
        "        team = json.player1; \n" +
        "  } \n" +
        "  return getTokenAtBlockForTeam(team, clickedBlock); \n" +
        "}             \n" ;
    
    
    String str15_removeSelection =
        "function removeSelection(selectedToken) \n" +
        "{ \n" +
        "  //TODO draw tiles at point selectedToken.col/.row \n" +
        "  //drawToken(selectedToken, currentTurn); \n" +
        "} \n" ;
    
    String str16_checkMovement =    
        "//press button dice to get a value \n" +
        "function checkMovement(selectedToken, clickedBlock) \n" +
        "{ \n" +
        "  var rowMoveTo = selectedToken.row; \n" +
        "  var colMoveTo = selectedToken.col; \n" +
        "  var dice = document.getElementById('textarea').value; \n" +
        "  document.getElementById('button').visibility = 'hidden'; \n" +
        "  return (((clickedBlock.row === (rowMoveTo.row - dice) \n" +
        "        ||(clickedBlock.row === (rowMoveTo.row + dice))) \n" +
        "        &&(clickedBlock.col === rowMoveTo.col)) \n" +
        "        ||((clickedBlock.col === (rowMoveTo.col - dice) \n" +
        "        ||(clickedBlock.col === (rowMoveTo.col + dice))) \n" +
        "        &&(clickedBlock.row === rowMoveTo.row))); \n" +
        "} \n" ;
    
    String str17_toDice =
        "function toDice(number) \n" +
        "{ \n" +
        "  //NOTE Math.random generates float values between 0 and 1 \n" +
        "  //TODO DYNAMIC \n" +
        "  var rnd = 1 + Math.floor(Math.random() * 6); \n" +
        "  document.getElementById('textarea').value = rnd; \n" +
        "  document.getElementById('button').style.visibility = 'hidden'; \n" +
        "  return rnd; \n" +
        "} \n" ;

            
    String str18_moveToken =
        "function moveToken(clickedBlock, enemyToken) \n" +
        "{ \n" +
        "  // Clear the block in the original position \n" +
        "  //TODO Implement due to missing draw tiles function \n" +
        "  //TODO implement rules and mission accomplished \n" +
        "  //drawBlock(selectedPiece.col, selectedPiece.row); \n" +
        "  var team = currentTurn; \n" +
        "  var opposite = getOwner(enemyToken); \n" +
        "  team[selectedToken.position].col = clickedBlock.col; \n" +
        "  team[selectedToken.position].row = clickedBlock.row; \n" +
        "  if (enemyToken !== null) \n" +
        "  { \n" +
        "    // Clear the piece your about to take \n" +
        "    //TODO implemt function due to missing draw tiles \n" +
        "    //drawBlock(enemyToken.col, enemyPiece.row);   \n" +
        "    opposite[enemyToken.position].status = LOST; \n" +
        "  } \n" +
        "  // Draw the piece in the new position \n" +
        "  drawToken(selectedToken, currentTurn);        \n" +
        "  currentTurn = (currentTurn + 1); \n" +
        "  document.getElementById('button').style.visibility = 'visible'; \n" +
        "  selectedtoken = null; \n" +
        "} \n" ;
        
        
    String str19_getOwner =
        "function getOwner(token) \n" +
        "{ \n" +
        "  //TODO DYNAMIC \n" +
        "  var count; \n" +
        "  var owner = null; \n" +
        "  for (count = 0; count < player1.length; count++)  \n" +
        "  { \n" +
        "    token = player1[count]; \n" +
        "    if(token.status === IN_PLAY && \n" +
        "      token.col === clickedBlock.col && \n" +
        "      token.row === clickedBlock.row) \n" +
        "    { \n" +
        "      count = player1.length; \n" +
        "      owner = player1; \n" +
        "    } \n" +
        "  } \n" +
        "  if(owner === null) \n" +
        "  {v \n" +
        "    for (count = 0; count < player2.length; count++)  \n" +
        "  { \n" +
        "    token = player2[count]; \n" +
        "    if(token.status === IN_PLAY && \n" +
        "      token.col === clickedBlock.col && \n" +
        "      token.row === clickedBlock.row) \n" +
        "    { \n" +
        "      count = player2.length; \n" +
        "      owner = player2; \n" +
        "    } \n" +
        "  } \n" +
        "  } \n" +
        "  return owner; \n" +
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
    
        String sourcehtml =
        "<!DOCTYPE html>                       \n" +
        "<html lang=\"en\">                      \n" +
        "<head>                                \n" +
        "<meta charset=\"utf-8\" />            \n" +
        "<title>HTML5 Canvas - "+project_name+"</title> \n" +
        "<script src='board.js'></script>         \n" +
        "</head>                                  \n" +
        "<body onload='draw();'>                  \n" +
        "<form>                                   \n" +
        "<button onclick=\"toDice()\"style = \"visibility:visible\" "
                + "id=\"button\" value=\"0\" type=\"button\">Dice</button> \n" +
          
         "<textarea style = \"resize:none\" rows=\"1\" cols=\"1\" id=\"textarea\" "
                + "name=\"text\"></textarea> \n"+
        "</form> \n"+
        "<div> \n"+
            "<canvas id=\"board\" width=\"800\" height=\"800\"></canvas> \n"+

        "</div> \n"+
        "</body> \n"+
        "</html> \n";

    //ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");

    
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        
        // create directory
        File directory = new File(project_name);
        if (directory.exists())
        {
                System.out.println("Cannot overwrite directory.");
        }
        else 
        {
            directory.mkdir();
        }
        
        // evaluate JavaScript code from String
         File newTextFile = new File("./" + project_name + "/" + project_name+".js");
            fileWriter = new FileWriter(newTextFile);
            fileWriter.write(source);
            fileWriter.close();
        engine.eval(source);
        //engine.eval("print('Hello, World')");
        
        File html5 = new File(project_name+".html");
            fileWriter = new FileWriter(html5);
            fileWriter.write(sourcehtml);
            fileWriter.close();
        
    }

    
    
    
    
}
