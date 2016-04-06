require 'pry'
module PlanetExpress
  class Game

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
      check
      while @stable == true
        prompt
      end
    end

    def make_choice
      check
      while @stable == true
        i = gets.chomp
        if i == "1"
          steal
        elsif i == "2"
          drink
        elsif i == "3"
          account
        elsif i == "4"
          deliver
        elsif i == "5"
          hunger
        end
        prompt
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

    def drink
      @fry.thirst -= 10
      @leela.work += 3

      if @fry.thirst < 0
        @fry.thirst = 0
      end

      if @leela.work > 100
        @leela.work = 100
      end

      check
      make_choice
    end

    def deliver
      @leela.work -= 3
      @hermes.receipts += 3

      if @leela.work < 0
        @leela.work = 0
      end

      if @hermes.receipts > 100
        @hermes.receipts = 100
      end
      check
      make_choice
    end

    def steal
      @bender.horde += 7
      @leela.work += 7

      if @leela.work > 100
        @leela.work = 100
      end

      if @bender.horde > 100
        @bender.horde = 100
      end
      check
      make_choice
    end

    def hunger
      @zoidberg.hunger -= 12
      @leela.work = 5

      if @zoidberg.hunger < 0
        @zoidberg.hunger = 0
      end

      if @leela.work > 100
        @leela.work = 100
      end
      check
      make_choice
    end

    def account
      @hermes.receipts -= 9
      @bender.horde -= 9

      if @hermes.receipts < 0
        @hermes.receipts = 0
      end

      if @bender.horde < 0
        @bender.horde == 0
      end
      check
      make_choice
    end

    def prompt
      puts "You are the new captain of the Planet Express."
      puts "Its crew: Bender, Fry, Hermes, Leela, and Zoidberg are at your command."
      puts "Your direction is crucial to their survival."
      puts "If Bender's horde isn't big enough, Fry is too thirsty, Hermes has too few receipts, Leela has too much work, or Zoidberg is too hungry, the mission will be over."
      puts "Enter 1 to let Bender steal 7 things to add to his horde."
      puts "Enter 2 to give Fry a can of Slurm to reduce his thirst by 10."
      puts "Enter 3 to give Hermes 9 receipts to keep track of Planet Express expenses."
      puts "Enter 4 to give 3 unfulfilled work orders to Leela."
      puts "Enter 5 to give Zoidberg a fish to eat to reduce his hunger by 12."
      score
      puts "What is your choice?"
      make_choice
    end

    def check
      if @fry.thirst > 90 || @leela.work > 90 || @bender.horde < 10 || @zoidberg.hunger > 90 || @hermes.receipts < 10
        puts "Your crew is close to failure"
        make_choice
      end

      if @fry.thirst == 100 || @leela.work == 100 || @bender.horde == 0 || @zoidberg.hunger == 10 || @hermes.receipts == 0
        puts "Your crew is done for"
        @stable = false
      end
    end

  end
end
