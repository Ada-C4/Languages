function SpaceShip(start, end) {
 this.thirst = start;
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

SpaceShip.prototype.deliver = function(){
 this.work--;
 this.receipts ++;
};

SpaceShip.prototype.steal = function(){
 this.horde++;
 this.work++;
};

SpaceShip.prototype.eat = function(){
 this.hunger--;
 this.work++;
};

SpaceShip.prototype.account = function(){
 this.receipts--;
 this.horde--;
 $("#receipts").text(crew.receipts);
};

SpaceShip.prototype.status = function(){
  $("#thirst").text(this.thirst);
  $("#work").text(this.work);
  $("#horde").text(this.horde);
  $("#hunger").text(this.hunger);
  $("#receipts").text(this.receipts);
}

SpaceShip.prototype.thirstLevel = function(){
  if (this.thirst > 70) {
    this.totalScore --;
  } else if (this.thirst <= 70) {
    this.totalScore ++;
  }
};

SpaceShip.prototype.workLevel = function(){
  if (this.work > 70) {
    this.totalScore --;
  } else if (this.work <= 70) {
    this.totalScore ++;
  }
};

SpaceShip.prototype.hordeLevel = function(){
  if (this.horde > 70) {
    this.totalScore ++;
  } else if (this.horde <= 70) {
    this.totalScore ++;
  }
};

SpaceShip.prototype.receiptLevel = function(){
  if (this.receipts > 70) {
    this.totalScore ++;
  } else if (this.receipts <= 80) {
    this.totalScore --;
  }
};

SpaceShip.prototype.hungerLevel = function(){
  if (this.work > 70) {
    this.totalScore --;
  } else if (this.work <= 70) {
    this.totalScore ++;
  }
};

SpaceShip.prototype.score = function(){
  console.log(this);
  this.thirstLevel();
  this.workLevel();
  this.hordeLevel();
  this.receiptLevel();
  this.hungerLevel();
  $("#score").text(crew.score);
};

var crew = new SpaceShip(50, 100);

$(document).ready(function(){
  crew.status();
  crew.score();

  $("#drink").click(function(){
    crew.drink();
    alert("You drank something!");
    crew.status();
    crew.score();
  });

  $("#eat").click(function(){
    crew.eat();
    alert("You eat something!");
    crew.status();
    crew.score();
  });

});
