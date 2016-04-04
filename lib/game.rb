module PlanetExpress
  class Game
    attr_accessor :bender, :fry, :hermes, :leela, :zoidberg

    def initialize
      @bender = Game::Bender.new
      @fry = Game::Fry.new(self)
      @hermes = Game::Hermes.new(self)
      @leela = Game::Leela.new(self)
      @zoidberg = Game::Zoidberg.new(self)
      @stable = true
    end

    def play_game

    end

    def score
      puts @fry.thirst
      puts @leela.work
      puts @bender.horde
      puts @zoidberg.hunger
      puts @hermes.receipts
      total_score = @fry.thirst + @leela.work + @bender.horde + @zoidberg.hunger + @hermes.receipts
      puts "This is your total score: " + total_score
    end

    def check
      if @fry.thirst > 95 || @leela.work > 95 || @bender.horde < 5 || @zoidberg.hunger > 95 || @hermes.receipts < 5

      end

      if @fry.thirst > 99 || @leela.work > 99 || @bender.horde < 1 || @zoidberg.hunger > 99 || @hermes.receipts < 1
        @stable = false
      end
    end

  end
end
