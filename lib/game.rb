require 'pry'
module PlanetExpress
  class Game
    attr_accessor :bender, :fry, :hermes, :leela, :zoidberg

    def initialize
      @bender = PlanetExpress::Bender.new(self)
      @fry = PlanetExpress::Fry.new(self)
      @hermes = PlanetExpress::Hermes.new(self)
      @leela = PlanetExpress::Leela.new(self)
      @zoidberg = PlanetExpress::Zoidberg.new(self)
      @stable = true
    end

    def play_game
      loop do
        @bender = PlanetExpress::Bender.new(self)
        @fry = PlanetExpress::Fry.new(self)
        @hermes = PlanetExpress::Hermes.new(self)
        @leela = PlanetExpress::Leela.new(self)
        @zoidberg = PlanetExpress::Zoidberg.new(self)
        @stable = true
        do_play_game
        puts "Do you want to play again? (y/n)"
        break unless gets.chomp == "y"
      end
    end

    def do_play_game
      puts "You are the new captain of the Planet Express."
      puts "Its crew: Bender, Fry, Hermes, Leela, and Zoidberg are at your command."
      puts "Your direction is crucial to their survival."
      puts "If Bender's horde isn't big enough, Fry is too thirsty, Hermes has too few receipts, Leela has too much work, or Zoidberg is too hungry, the mission will be over."
      score
      puts "Enter 1 to let Bender steal 7 things to add to his horde."
      puts "Enter 2 to give Fry a can of Slurm to reduce his thirst by 10."
      puts "Enter 3 to give Hermes 9 receipts to keep track of Planet Express expenses."
      puts "Enter 4 to give 3 unfulfilled work orders to Leela."
      puts "Enter 5 to give Zoidberg a fish to eat to reduce his hunger by 12."
      puts "What is your choice?"
      make_choice





    end

    def make_choice
      i = gets.chomp
      if i == "1"
      elsif i == "2"
      elsif i == "3"
      elsif i == "4"
      elsif i == "5"
      else
        puts "Please enter a valid selection:"
        make_choice
      end
    end

    def score
      b = @bender.horde
      f = @fry.thirst
      h = @hermes.receipts
      l = @leela.work
      z = @zoidberg.hunger
      puts "Crew Status:"
      puts "Bender has #{b} items in his horde."
      puts "Fry has #{f} units of thirst."
      puts "Hermes has #{h} receipts to enter."
      puts "Leela has #{l} unfulfilled work orders."
      puts "Zoidberg has #{z} units of hunger."
      total_score = b + f + h + l + z
      puts "This is your total score: #{total_score}"
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
