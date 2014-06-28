
var BLOCK_SIZE = 100;
var IN_PLAY = 0;


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
    //canvas.addEventListener('click', board_click, false);
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
  drawteam(json.player2, 1);
  drawteam(json.player1, 2);
}
function drawteam(team, playerID)
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
