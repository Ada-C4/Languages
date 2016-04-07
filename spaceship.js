var SpaceShip = function(start, end) {
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
};

SpaceShip.prototype.score = function(){
  if (this.totalScore < 0) {
    alert("You lost! Try again.");
    location.reload();
  }

  if (this.thirst > 70 && this.thirst < this.end) {
    this.totalScore --;
  } else if (this.thirst <= 70) {
    this.totalScore ++;
  } else if (this.thirst >= this.end) {
    alert("Your crew got too thirsty! You lose - try again.");
    location.reload();
  }

  if (this.work > 70) {
    this.totalScore --;
  } else if (this.work <= 70 && this.work < this.end) {
    this.totalScore ++;
  } else if (this.work >= this.end) {
    alert("Your crew got too hungry! You lose - try again.");
    location.reload();
  }

  if (this.receipts < 70) {
    this.totalScore ++;
  } else if (this.receipts >= 70 && this.receipts > this.end) {
    this.totalScore --;
  } else if (this.receipts > this.end) {
    alert("Your crew got too behind on receipts! You lose - try again.");
    location.reload();
}

if (this.horde < 70) {
  this.totalScore ++;
} else if (this.horde >= 70 && this.horde > this.end) {
  this.totalScore --;
} else if (this.horde > this.end) {
  alert("You didn't find enough treasure! You lose - try again.");
  location.reload();
}
  $("#score").text(this.totalScore);
};

var crew = new SpaceShip(0, 3);

$(document).ready(function(){
  crew.status();

  $("#drink").click(function(){
    crew.drink();
    alert("You drank something!");
    crew.score();
    crew.status();
  });

  $("#eat").click(function(){
    crew.eat();
    alert("You ate something!");
    crew.score();
    crew.status();
  });

  $("#deliver").click(function(){
    crew.deliver();
    alert("You delivered something!");
    crew.score();
    crew.status();
  });

  $("#account").click(function(){
    crew.account();
    alert("You did some accounting!");
    crew.score();
    crew.status();
  });

  $("#steal").click(function(){
    crew.steal();
    alert("You stole some treasure!");
    crew.score();
    crew.status();
  });
});
