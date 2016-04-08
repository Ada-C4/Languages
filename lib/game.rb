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
      while @stable
        prompt
      end
    end

    def make_choice
      choice = gets.chomp.to_i
      if choice == 1
        steal
      elsif choice == 2
        drink
      elsif choice == 3
        account
      elsif choice == 4
        deliver
      elsif choice == 5
        hunger
      else
        puts "Please make a valid selection"
        prompt
      end
    end

    def score
      bender_horde = @bender.horde
      fry_thirst = @fry.thirst
      hermes_receipts = @hermes.receipts
      leela_work = @leela.work
      zoidberg_hunger = @zoidberg.hunger
      puts "Crew Status:"
      # puts "Bender has #{bender_horde} items in his horde."
      # puts "Fry has #{fry_thirst} units of thirst."
      # puts "Hermes has #{hermes_receipts} receipts to enter."
      # puts "Leela has #{leela_work} unfulfilled work orders."
      # puts "Zoidberg has #{zoidberg_hunger} units of hunger."

      total_score = bender_horde + fry_thirst + hermes_receipts + leela_work + zoidberg_hunger

      puts "Horde score for Bender (you want this to be high): #{bender_horde}"
      puts "Thirst score for Fry (you want this to be low): #{fry_thirst}"
      puts "Receipts score for Hermes (you want this to be high): #{hermes_receipts}"
      puts "Work Order score for Leela (you want this to be low): #{leela_work}"
      puts "Hunger score for Zoidberg (you want this to be low): #{zoidberg_hunger}"
      puts "Total score: #{total_score}"
    end

    def drink
      check
      if @fry.thirst <= 0
        check
        @fry.thirst = 0
      else
        @fry.thirst -= 10
      end

      if @leela.work <= 99
        check
        @leela.work += 3
      elsif @leela.work >= 100
          @leela.work = 100
      end


      prompt
    end

    def deliver
      check
      if @leela.work <= 0
        @leela.work = 0
      else
        @leela.work -= 3
      end

      if @hermes.receipts >= 100
        @hermes.receipts = 100
      else
        @hermes.receipts += 3
      end
      check
      prompt
    end

    def steal
      if @leela.work >= 100
        @leela.work = 100
      else
        @leela.work += 7
      end

      if @bender.horde >= 100
        @bender.horde = 100
      else
        @bender.horde += 7
      end
      check
      prompt
    end

    def hunger
        check
      if @zoidberg.hunger <= 0
        @zoidberg.hunger = 0
      else
        @zoidberg.hunger -= 12
      end

      if @leela.work <= 99
        check
        @leela.work += 5
      elsif @leela.work >= 100
        @leela.work = 100
      end

      prompt
    end

    def account
      check
      if @hermes.receipts < 0
        check
        @hermes.receipts = 0
      else
        @hermes.receipts -= 9
      end

      if @bender.horde <= 0
        check
        @bender.horde -= 9
      elsif @bender.horde < 0
        @bender.horde = 0
      else

      end
      check
      prompt
    end

    def prompt
      puts "You are the new captain of the Planet Express."
      puts "Its crew: Bender, Fry, Hermes, Leela, and Zoidberg are at your command."
      puts "Your direction is crucial to their survival."
      puts "If Bender's horde isn't big enough, Fry is too thirsty, Hermes has too few receipts, Leela has too much work, or Zoidberg is too hungry, the mission will be over."
      puts "Enter 1 to let Bender steal 7 things to add to his horde and create 7 more work orders for Leela."
      puts "Enter 2 to give Fry a can of Slurm to reduce his thirst by 10 and create 3 more work orders for Leela."
      puts "Enter 3 to give Hermes 9 receipts to keep track of Planet Express expenses and reduce Bender's horde by 9 items."
      puts "Enter 4 to have Leela complete 3 work orders."
      puts "Enter 5 to give Zoidberg a fish to eat to reduce his hunger by 12 and give Leela 5 more work orders."
      score
      puts "What is your choice?"
      make_choice
    end

    def check
      if ((@fry.thirst > 90 && @fry.thirst < 99) || (@leela.work > 90 && @leela.work < 99) || (@bender.horde < 10 && @bender.horde > 0) || (@zoidberg.hunger > 90 && @zoidberg.hunger < 99) || (@hermes.receipts < 10 && @hermes.receipts > 0))
        puts "Your crew is close to failure"
        prompt
      elsif @fry.thirst == 100 || @leela.work == 100 || @bender.horde == 0 || @zoidberg.hunger == 10 || @hermes.receipts == 0
        puts "Your crew is done for"
        @stable = false
      end
    end

  end
end
