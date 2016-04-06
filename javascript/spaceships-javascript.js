function PlanetExpress (max, start) {
    this.stable = true;
    this.thirst = start;
    this.work = start;
    this.horde = start;
    this.hunger = start;
    this.receipts = start;
    this.max = max;
}

PlanetExpress.prototype.drink = function(){
  this.thirst--;
  this.work++;
};

PlanetExpress.prototype.deliver = function(){
  this.work--;
  this.receipts++;
};

PlanetExpress.prototype.steal = function(){
  this.horde++;
  this.work++;
};

PlanetExpress.prototype.eat = function(){
  this.hunger--;
  this.work++;
};

PlanetExpress.prototype.account = function(){
  this.receipts--;
  this.horde--;
};

PlanetExpress.prototype.updateLevels = function(){
  $("#thirst").text(planet.thirst);
  $("#work").text(planet.work);
  $("#horde").text(planet.horde);
  $("#hunger").text(planet.hunger);
  $("#receipts").text(planet.receipts);
};

var planet = new PlanetExpress(10, 5);

$(document).ready(function(){
  planet.updateLevels();

  $("#drink").click(function(){
    planet.drink();
    planet.updateLevels();
  });

  $("#deliver").click(function(){
    planet.deliver();
    planet.updateLevels();
  });

  $("#steal").click(function(){
    planet.steal();
    planet.updateLevels();
  });

  $("#eat").click(function(){
    planet.eat();
    planet.updateLevels();
  });

  $("#account").click(function(){
    planet.account();
    planet.updateLevels();
  });
});
