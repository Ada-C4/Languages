module PlanetExpress
  class Leela

    attr_accessor :name, :work

    def initialize(game)
      @name = "Leela"
      @work = 50
      @game = game
    end
  end
end
