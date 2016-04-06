function SpaceShip(start, end) {
 this.work = start;
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

SpaceShip.protoype.score = function(){
  this.thirstLevel();
  this.hordeLevel();
  this.hordeLevel();
  this.receiptLevel();
  this.hungerLevel();
  return this.totalScore;
};

SpaceShip.protoype.receiptLevel = function(){
  if (this.receipts > 70) {
    this.totalScore ++;
  } else if (this.receipts <= 80) {
    this.totalScore --;
  }
};
