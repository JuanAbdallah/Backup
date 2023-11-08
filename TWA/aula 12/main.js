// setup canvas

const canvas = document.querySelector('canvas');
const ctx = canvas.getContext('2d');

const width = (canvas.width = window.innerWidth);
const height = (canvas.height = window.innerHeight);

// function to generate random number

function random(min, max) {
  const num = Math.floor(Math.random() * (max - min + 1)) + min;
  return num;
}

// function to generate random color

function randomRGB() {
  return `rgb(${random(0, 255)},${random(0, 255)},${random(0, 255)})`;
}

function Shape(x,y,velX,velY) {
  this.x = x;
  this.y = y;
  this.velX = velX;
  this.velY = velY;
  this.exists = true;
}

function EvilCircle(x,y) {
  Shape.call(this,x,y,20,20);
  this.color = 'white';
  this.size = 10;
}

EvilCircle.prototype = Object.create(Shape.prototype);
Object.defineProperty(EvilCircle.prototype, `constructor`, {
  value: EvilCircle,
  enumerable: false,
  writable: true });

  EvilCircle.prototype.draw = function() {
    ctx.beginPath();
    ctx.strokeStyle = this.color;
    ctx.lineWidth = 3;
    ctx.arc(this.x,this.y,this.size,0,Math.PI * 2);
    ctx.stroke();
}

  EvilCircle.prototype.checkBounds = function(){

} 

EvilCircle.prototype.setControls = function(){

  var _this = this;

  window.onkeydown = function(event) {
    if (event.key === 'a') {
      _this.x -= _this.velX;
    }else if (event.key === 'd') {
      _this.x += _this.velX;
    }else if (event.key === 'w'){
      _this.y -= _this.velY;
    }else if (event.key === 's') {
      _this.y += _this.velY;
    }
  }
}

EvilCircle.prototype.collisionDetect = function () {
  balls.forEach((ball)=>{
    if(ball.exists){
      const dx = this.x - ball.x;
      const dy = this.y - ball.y;
      const distance = Math.sqrt(dx**2+dy**2);
      if (distance < this.size+ball.size){
        ball.exists = false;
      }
    }
  })
}


function Ball(x,y,velX,velY,color,size) {
  Shape.call(this,x,y,velX,velY);
  this.color = color;
  this.size = size;  
}

Ball.prototype = Object.create(Shape.prototype);
// Ball.protype.constructor = Ball;
Object.defineProperty(Ball.prototype, 'constructor',{
  value: Ball,
  enumerable: false,
  writable: true });


Ball.prototype.draw = function () {
  ctx.beginPath();
  ctx.fillStyle = this.color;
  ctx.arc(this.x,this.y,this.size,0,Math.PI * 2);
  ctx.fill();
}

Ball.prototype.update = function () {
  if ( (this.x+this.size) >= width ){
    this.velX = -(this.velX);
  }

  if ( (this.x+this.size) <= 0 ){
    this.velX = -(this.velX);
  }

  if ( (this.y+this.size) >= height ){
    this.velY = -(this.velY);
  }

  if ( (this.y+this.size) <= 0 ){
    this.velY = -(this.velY);
  }

  this.x += this.velX;
  this.y += this.velY;
}

Ball.prototype.collisionDetect = function () {
  balls.forEach((ball,j)=>{
    if(!(this == ball) && (ball.exists) && (this.exists)){
      const dx = this.x - ball.x;
      const dy = this.y - ball.y;
      const distance = Math.sqrt(dx**2+dy**2);
      if (distance < this.size+ball.size){
        this.color = ball.color = randomRGB();
        this.velX *= -1;
        this.velY *= -1;
        ball.velX *= -1;
        ball.velY *= -1;
      }
    }
  })
}


let balls = [];

while (balls.length < 25) {
  let size = random(10,20);
  let ball = new Ball(
    random(0+size,width-size),
    random(0+size,height-size),
    random(-7,7),
    random(-7,7),
    randomRGB(),
    size
  );
  balls.push(ball);
}

let evil = new EvilCircle(random(0,width), random(0,height));
evil.setControls();

function loop() {

  ctx.fillStyle = 'rgba(0,0,0,1)';
  ctx.fillRect(0,0,width,height);

  balls.forEach( ball =>{
    if(ball.exists){
        ball.draw();
        ball.update();
        ball.collisionDetect();
    }
   
  });
  evil.draw();
  evil.checkBounds();
  evil.collisionDetect();

  requestAnimationFrame(loop);  
}

loop();
