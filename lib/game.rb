module PlanetExpress
  class Game
    attr_accessor :bender, :fry, :hermes, :leela, :zoidberg

    def initialize
      @bender = Bender.new
      @fry = Fry.new
      @hermes = Hermes.new
      @leela = Leela.new
      @zoidberg = Zoidberg.new
      @stable = true
    end

    def score

    end

    def check
      if @fry.thirst > 95 || @leela.work > 95 || @bender.horde < 5 || @zoidberg.hunger > 95 || @hermes.receipts < 5
        @stable = false
    end
  end
end
