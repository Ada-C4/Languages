module PlanetExpress
  class Fry

    attr_accessor :name, :thirst

    def initialize(game)
      @name = "Fry"
      @thirst = 50
      @game = game
    end
  end
end
