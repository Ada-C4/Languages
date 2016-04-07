var Crew = function() {
    this.thirst = 50;
    this.work = 50;
    this.horde = 50;
    this.hunger = 50;
    this.receipts = 50;
    this.stable = true;
  };

Crew.prototype.drink = function() {
  this.thirst -= 5;
  this.work += 10;
};

Crew.prototype.deliver = function() {
  this.work -= 10;
  this.receipts += 10;
};

Crew.prototype.steal = function() {
  this.horde += 15;
  this.work += 30;
};

Crew.prototype.eat = function() {
  this.hunger -= 5;
  this.work += 10;
};

Crew.prototype.account = function() {
  this.receipts -= 10;
  this.horde -= 10;
};

Crew.prototype.score = function() {
  thirst_score = this.thirst * 5;
  work_score = this.work * 10;
  horde_score = this.horde * 50;
  hunger_score = this.hunger * 5;
  receipts_score = this.receipts * 50;
};

Crew.prototype.check = function() {
  if (this.thirst >= 85 && this.thirst < 100) {
    window.alert("Warning! Give Fry a drink before he crashes the ship!");
  }
  if (this.work >= 85 && this.work < 100) {
    window.alert("Warning! Leela is swamped with work and can't keep up!");
  }
  if (this.horde > 0 && this.horde <= 15) {
    window.alert("Warning! Bender's horde is rapidly depleting!");
  }
  if (this.hunger >= 85 && this.hunger < 100) {
    window.alert("Warning! Make Zoidberg's stomach stop growling, it's distracting the crew!");
  }
  if (this.receipts > 0 && this.receipts <= 15) {
    window.alert("Warning! Hermes needs more receipts to process!");
  }
  if (this.thirst > 100 || this.work > 100 || this.horde <= 0 || this.hunger > 100 || this.receipts <= 0) {
     window.alert("The crew fell apart under pressure.  You lose!");
    stable = false;
  }
};

var c = new Crew();

Crew.prototype.level = function() {
  $("#thirst").text(c.thirst);
  $("#work").text(c.work);
  $("#horde").text(c.horde);
  $("#hunger").text(c.hunger);
  $("#receipts").text(c.receipts);
};

Crew.prototype.checkLevel = function() {
  c.level();
  c.check();
}


$(document).ready(function(){
  c.level();

  $("#drink").click(function(){
    c.drink();
    c.checkLevel();
  });

  $("#deliver").click(function(){
    c.deliver();
    c.checkLevel();
  });

  $("#steal").click(function(){
    c.steal();
    c.checkLevel();
  });

  $("#eat").click(function(){
    c.eat();
    c.checkLevel();
  });

  $("#account").click(function(){
    c.account();
    c.checkLevel();
  });
});
