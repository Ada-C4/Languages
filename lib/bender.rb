module PlanetExpress
  class Bender
    attr_accessor :name, :horde
    def initialize(game)
      @name = "Bender"
      @horde = 50
      @game = game
    end
  end
end
