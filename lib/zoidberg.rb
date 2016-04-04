module PlanetExpress
  class Zoidberg

    attr_accessor :name, :hunger

    def initialize(game)
      @name = "Zoidberg"
      @hunger = 50
      @game = game
    end
  end
end
