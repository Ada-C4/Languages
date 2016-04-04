require_relative "./lib/bender"
require_relative "./lib/fry"
require_relative "./lib/game"
require_relative "./lib/hermes"
require_relative "./lib/leela"
require_relative "./lib/zoidberg"

game = PlanetExpress::Game.new
game.play_game
