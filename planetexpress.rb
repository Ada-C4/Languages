require ".lib/bender"
require ".lib/fry"
require ".lib/game"
require ".lib/hermes"
require ".lib/leela"
require ".lib/zoidberg"

game = PlanetExpress::Game.new
game.play_game
