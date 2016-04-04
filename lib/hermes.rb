module PlanetExpress
  class Hermes

    attr_accessor :name, :receipts

    def initialize(game)
      @name = "Hermes"
      @receipts = 50
      @game = game
    end
  end
end
