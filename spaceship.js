function SpaceShip(start, end) {
 this.work = start;
 this.thirst = start;
 this.horde = start;
 this.hunger = start;
 this.receipts = start;
 this.stable = true;
 this.end = end;
 this.totalScore = 0;
}

SpaceShip.prototype.drink = function(){
 this.thirst--;
 this.work++;
};

SpaceShip.prototype.eat = function(){
 this.thirst--;
 this.work++;
};

SpaceShip.prototype.work = function(){
 this.thirst--;
 this.work++;
};

SpaceShip.prototype.horde = function(){
 this.thirst--;
 this.work++;
};

SpaceShip.prototype.receipts = function(){
 this.thirst--;
 this.work++;
};

SpaceShip.prototype.score = function(){
  this.thirstLevel();
  this.workLevel();
  this.hordeLevel();
  this.receiptLevel();
  this.hungerLevel();
  return this.totalScore;
};

SpaceShip.prototype.receiptLevel = function(){
  if (this.receipts > 70) {
    this.totalScore ++;
  } else if (this.receipts <= 80) {
    this.totalScore --;
  }
};

// clicking on this will update the text in the drink id
SpaceShip.prototype.makeMoves = function(){
  $("#drink").text(crew.thirst);
  $("#eat").text(crew.hunger);
  $("#treasures").text(crew.horde);


}

var crew = new SpaceShip();

$(document).ready( function (){

});
