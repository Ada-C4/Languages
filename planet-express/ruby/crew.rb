class Crew
  attr_accessor :thirst, :work, :horde, :hunger, :receipts, :stable

  def initialize
    @thirst = 50
    @work = 50
    @horde = 50
    @hunger = 50
    @receipts = 50
    @stable = true
    @score = 50
  end

  def drink
    @thirst -= 5
    @work += 5
  end

  def deliver
    @work -= 5
    @receipts += 5
  end

  def steal
    @horde += 5
    @work += 5
  end

  def eat
    @hunger -= 5
    @work += 5
  end

  def account
    @receipts -= 5
    @horde -= 5
  end

  def score
    if @thirst >= 100 || @work >= 100 || @horde <= 0 || @hunger >= 100 || @receipts <= 0
      @score = 0
    end
  end

  def check
    # if score is too low, end game
    if @score < 0
      @stable = false
      return false
    else
      # check to see if you need to print warnings
      if @thirst >= 85
        puts "Fry is scary-thirsty!"
      end

      if @work >= 85
        puts "Leela is exhausted from all this work!"
      end

      if @horde <= 15
        puts "Bender is sad because he doesn't have enough treasure!"
      end

      if @hunger >= 85
        puts "Zoidberg is going to eat something and it's not going to be pretty!"
      end

      if @receipts <= 15
        puts "Hermes doesn't have enough receipts!"
      end

      return true
    end
  end

end
