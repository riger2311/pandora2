
var BLOCK_SIZE = 100;
//IN_PLAY = 1 if token is on board
var IN_PLAY = 1;
var LOST = 0;
var currentTurn = 0; //starting with player 1
var selectedToken = null;


function draw()
{
  // Main entry point got the HTML5 chess board example

  canvas = document.getElementById('board');

  // Canvas supported?
  if (canvas.getContext)
  {
    //canvas is in 2d, not 3d!
    ctx = canvas.getContext('2d');
    //draw background
    //TODO: write function that can read
    //backgorund from .tmx
    document.body.background = "background.png";
    //get params = tokens& positions
    params();
    // Draw tokens
    tokenIMG = new Image();
    tokenIMG.src = 'pieces.png';
    tokenIMG.onload = drawAllTokens;
    canvas.addEventListener('click', click_on_board, false);
  }
  else
  {
    alert("You are currently using IE.STOP!");
  }
}

function drawAllTokens()
{
  //TODO DYNAMIC
  //draw Tokens of each PLayer
  //number defines tokens of which players
  //using later in function "getImageCoords"
  drawTeam(json.player1, 1);
  drawTeam(json.player2, 2);
}
function drawTeam(team, playerID)
{
  var teamCounter;

  //loop through every single token to draw it
  for (teamCounter = 0; teamCounter < team.length; teamCounter++) 
  { 
    drawToken(team[teamCounter], playerID);
  } 
}
function drawToken(curToken, playerID)
{
  //draw current token
  //get id of current token
  var imageCoords = getImageCoords(curToken.token, playerID);
    
  // Draw the piece onto the canvas
  ctx.drawImage
   (tokenIMG, //get image of all tokens
    imageCoords.x, //get start clipped image x Coord
    imageCoords.y, //get start clipped image y Coord
    BLOCK_SIZE, //width of clipped image
    BLOCK_SIZE, //height of clipped image
    curToken.col * BLOCK_SIZE, // Sarting X Coord of image
    curToken.row * BLOCK_SIZE, //Starting Y Coord of image
    BLOCK_SIZE, //width of used image(may be resized)
    BLOCK_SIZE); //height of used image(may also be resized)
          
}

function getImageCoords(token, playerID)
{
  //TODO how to change y
  var imageCoords = 
  {
    "x": token * BLOCK_SIZE,
    "y": ((playerID - 1) * BLOCK_SIZE)
  }; 
  
  return imageCoords;
}

function params()
{
  //TODO DYNAMIC
  json = 
  {
    "player1": 
    [
      {
        "token": 0,
        "row": 0,
        "col": 0,
        "status": IN_PLAY
      },
      {
        "token": 1,
        "row": 0,
        "col": 1,
        "status": IN_PLAY
      },
            {
        "token": 0,
        "row": 0,
        "col": 2,
        "status": IN_PLAY
      }
    ],
    "player2": 
    [
      {
        "token": 2,
        "row": 3,
        "col": 1,
        "status": IN_PLAY
      },
      {
        "token": 4,
        "row": 3,
        "col": 0,
        "status": IN_PLAY
      }
    ]   
  };
}
function click_on_board(ev)
{
    //check x and y coord of clicked area
    //ev.clientX/ev.clientY = global x and y coords
    //canvas.offsetLeft/Top = local x and y coords(coords in one block)
    var x_coord = ev.clientX - canvas.offsetLeft;
    var y_coord = ev.clientY - canvas.offsetTop;
    var clickedBlock = block_coord(x_coord, y_coord);
     
    //if currently no block is selected DO
    //token in this block?
    if(selectedToken === null)
    {
        checkIfTokenClicked(clickedBlock);
    }
    else
    {
        processMove(clickedBlock);
    }
}
function block_coord(x_coord, y_coord)
{
  var block = 
  {
    "row": Math.floor(y_coord / BLOCK_SIZE),
    "col": Math.floor(x_coord / BLOCK_SIZE)
  }; 
  
  return block; 
}
function checkIfTokenClicked(clickedBlock)
{
  var tokenAtBlock = getTokenAtBlock(clickedBlock);
  
  if (tokenAtBlock !== null)
  {
    selectToken(tokenAtBlock);
  }
}
function getTokenAtBlock(clickedBlock)
{
  var team;
  //which team is selected
  //global var currentTurn saves team which turn it is
  //TODO DYNAMIC
  switch(currentTurn)
  {
    case 0:
        team = json.player1;
        break;
    case 1:
        team = json.player2;
  }
  return getTokenAtBlockForTeam(team, clickedBlock);
}
//check which token is clicked
function getTokenAtBlockForTeam(team, clickedBlock)
{
  var curToken = null;
  var counter = 0;
  var tokenAtBlock = null;
  
  //loop through all tokens of current team
  for (counter = 0; counter < team.length; counter++) 
  {
    curToken = team[counter];
    
    //if currentToken is on board,
   // and clicked coords of box are same as
   //those of currentToken DO
    if(curToken.status === IN_PLAY &&
      curToken.col === clickedBlock.col &&
      curToken.row === clickedBlock.row)
    {
      curToken.position = counter;
      
      tokenAtBlock = curToken;
      counter = team.length;
    }
  }
  
  return tokenAtBlock;
}
function selectToken(tokenAtBlock)
{
  // Draw outline
  ctx.lineWidth = 5; //if necessary change!
  ctx.strokeStyle = '#fb0006';// if necessary change!
  ctx.strokeRect((tokenAtBlock.col * BLOCK_SIZE) + 5,//x value start
                 (tokenAtBlock.row * BLOCK_SIZE) + 5,// y value start
                  BLOCK_SIZE - (5 * 2),              //width
                  BLOCK_SIZE - (5 * 2));             //height
  
  selectedToken = tokenAtBlock;
}
function processMove(clickedBlock)
{
  var tokenAtBlock = getTokenAtBlock(clickedBlock);
  var enemyToken = getEnemy(clickedBlock);
  
  if (tokenAtBlock !== null)
  {
    //NOTE: pls uncomment if removeSelection implementation works
    //TODO
    //removeSelection(selectedToken);
    checkIfTokenClicked(clickedBlock);      
  }
  else if (checkMovement(selectedToken, clickedBlock) === true)
  {
    //TODO implement function
    moveToken(clickedBlock, enemyToken);
  }
}
function getEnemy(clickedBlock)
{

  var team;
  //BEWARE ORDER!!!!
  //change if more than 2 players
  //TODO DYNAMIC
  switch(currentTurn)
  {
    case 0:
        team = json.player2;
        break;
    case 1:
        team = json.player1;
  }
  return getTokenAtBlockForTeam(team, clickedBlock);
}
//TODO Check functionality
//if piece of own team is selected and new selection is made
//remove old selection = remove frame
//to do that, draw tiles and token again!
function removeSelection(selectedToken)
{
  //TODO draw tiles at point selectedToken.col/.row
  //drawToken(selectedToken, currentTurn);
}
//press button dice to get a value
function checkMovement(selectedToken, clickedBlock)
{
  var rowMoveTo = selectedToken.row;
  var colMoveTo = selectedToken.col;

  var dice = document.getElementById('textarea').value;
  document.getElementById('button').visibility = 'hidden';
          
  return (((clickedBlock.row === (rowMoveTo.row - dice)
        ||(clickedBlock.row === (rowMoveTo.row + dice)))
        &&(clickedBlock.col === rowMoveTo.col))
        ||((clickedBlock.col === (rowMoveTo.col - dice)
        ||(clickedBlock.col === (rowMoveTo.col + dice)))
        &&(clickedBlock.row === rowMoveTo.row)));

}
function toDice(number)
{
  //NOTE Math.random generates float values between 0 and 1
  //TODO DYNAMIC
  var rnd = 1 + Math.floor(Math.random() * 6);
  document.getElementById('textarea').value = rnd;
  document.getElementById('button').style.visibility = 'hidden';
  return rnd;
}
function moveToken(clickedBlock, enemyToken)
{
  // Clear the block in the original position
  //TODO Implement due to missing draw tiles function
  //TODO implement rules and mission accomplished
  //drawBlock(selectedPiece.col, selectedPiece.row);
  
  var team = currentTurn;
  var opposite = getOwner(enemyToken);

  team[selectedToken.position].col = clickedBlock.col;
  team[selectedToken.position].row = clickedBlock.row;
  
  if (enemyToken !== null)
  {
    // Clear the piece your about to take
    //TODO implemt function due to missing draw tiles
    //drawBlock(enemyToken.col, enemyPiece.row);  
    opposite[enemyToken.position].status = LOST;
  }
  
  // Draw the piece in the new position
  drawToken(selectedToken, currentTurn);       
  
  currentTurn = (currentTurn + 1);
  document.getElementById('button').style.visibility = 'visible';
  selectedtoken = null;
}
function getOwner(token)
{
  //TODO DYNAMIC
  var count;
  var owner = null;
  for (count = 0; count < player1.length; count++) 
  {
    token = player1[count];
    
    if(token.status === IN_PLAY &&
      token.col === clickedBlock.col &&
      token.row === clickedBlock.row)
    {
      count = player1.length;
      owner = player1;
    }
  }
  if(owner === null)
  {
    for (count = 0; count < player2.length; count++) 
  {
    token = player1[count];
    
    if(token.status === IN_PLAY &&
      token.col === clickedBlock.col &&
      token.row === clickedBlock.row)
    {
      count = player2.length;
      owner = player2;
    }
  }

  }
  return owner;
}