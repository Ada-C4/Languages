class Spaceship:

    def __init__(self):
        self.thirst = 50
        self.work = 50
        self.horde = 50
        self.hunger = 50
        self.receipts = 50
        self.stable = True

    def drink(self):
        self.thirst -= 10
        self.work += 2

    def deliver(self):
        self.work += 8
        self.receipts += 4

    def steal(self):
        self.horde += 10
        self.work += 7

    def eat(self):
        self.hunger -= 10
        self.work += 2

    def account(self):
        self.receipts -= 10
        self.horder -= 10

        # the lower the thirst, work, and hunger, and the higher the horde
        # and receipts, the better the score.
        # as thirst, work, and hunger decrease
        # and as horde and receipts increase, the score increases
    # def score(self):

    def stable(self):
        if score < 30:
            return false
        else:
            return true

    def check(self):
        self.alert()
            # It also needs to print out a warning for each value if it is
            # getting too high (or too low), such as if Hermes has too many
            # receipts (but not enough to crash the company). If it was enough
            # to crash the company (perhaps more than 100), then the function
            # would return false.

    # how to get this to string interpolate which value is greater than 90.
    def alert(self):
        if any( [self.thirst > 90, self.work > 90, self.horde > 90, self.hunger > 90, self.receipts > 90] ):
            print "Uh oh! Somethings off! Check the status!"
