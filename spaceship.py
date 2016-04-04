class Spaceship:

    def __init__(self):
        self.thirst = 50
        self.work = 50
        self.horde = 50
        self.hunger = 50
        self.receipts = 50
        self.stable = True
        self.total = 0

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
        self.horde -= 10

        # the lower the thirst, work, and hunger, and the higher the horde
        # and receipts, the better the score.
        # as thirst, work, and hunger decrease
        # and as horde and receipts increase, the score increases
        # if thirst decreases, score increases
    def score(self):
        if self.thirst < 30:
            self.total += 1
            return self.total

    def stable(self):
        if any( [self.thirst > 99, self.work > 99, self.horde < 1, self.hunger > 99, self.receipts < 1] ):
            return False
        else:
            return True

    def check(self):
        self.alert()
        if self.stable:
            return True
        else:
            return False
            print "You lose! Try again!"

    # how to get this to string interpolate which value is greater than 90.
    def alert(self):
        if any( [self.thirst > 60, self.work > 60, self.horde > 60, self.hunger > 60, self.receipts > 60] ):
            print "Uh oh! Your ship is about to sink. Here's your current status of the boat. Remember, if any value reaches 100, you're DOOMED!"
            self.thirst
            print "Current thirst level: "
            print self.thirst
            print "Current work level:"
            print self.work
            print "Current hording level: "
            print self.horde
            print "Current hunger level: "
            print self.hunger
            print "Current receipt level: "
            print self.receipts
            # put all things in an array
            # iterate through the array and for only the values that have a value great than 90 have it print out a statement
