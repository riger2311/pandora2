
var BLOCK_SIZE = 75;
//IN_PLAY = 1 if token is on board
var IN_PLAY = 1;
var currentTurn = 0;
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
    //TODO add click event
    canvas.addEventListener('click', click_on_board, false);
  }
  else
  {
    alert("You are currently using IE.STOP!");
  }
}

function drawAllTokens()
{
  //draw Tokens of each PLayer
  //number defines tokens of which players
  //using later in function "getImageCoords"
  drawTeam(json.player2, 1);
  drawTeam(json.player1, 2);
}
function drawTeam(team, playerID)
{
  var teamCounter;

  //loop through every single token to draw it
  for (teamCounter = 0; teamCounter < team.length; teamCounter++) 
  { 
    drawPiece(team[teamCounter], playerID);
  } 
}
function drawPiece(curToken, playerID)
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
    if(selectedToken == null)
    {
        checkIfTokenClicked(clickedBlock);
    }
    else
    {
       //TODO Implement
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
  var enemyPiece = blockOccupiedByEnemy(clickedBlock);
  
  if (tokenAtBlock !== null)
  {
    removeSelection(selectedToken);
    checkIfTokenClicked(clickedBlock);      
  }
  //TODO implement function
  else if (canSelectedMoveToBlock(selectedToken, clickedBlock, enemyPiece) === true)
  {
    //TODO implement function
    moveToken(clickedBlock, enemyToken);
  }
}
function blockOccupiedByEnemy(clickedBlock)
{
  var team;
  //BEWARE ORDER!!!!
  //change if more than 2 players
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
//add new selection = add frame
function removeSelection(selectedToken)
{
  //TODO draw tiles at point selectedToken.col/.row
  drawPiece(selectedToken, currentTurn);
}

