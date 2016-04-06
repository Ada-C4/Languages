class Crew:
    'defines some properties about the crew of the spaceship'

    def __init__(self):
        self.thirst = 50
        self.work = 50
        self.horde = 50
        self.hunger = 50
        self.receipts = 50
        self.stable = true
        self.score = 50

    def drink:
        self.thirst -= 5
        self.work += 5

    def deliver:
        self.work -= 5
        self.receipts += 5

    def steal:
        self.horde += 5
        self.work += 5

    def eat:
        self.hunger -= 5
        self.work += 5

    def account:
        self.receipts -= 5
        self.horde -= 5

    def score:
        if self.thirst >= 100 or self.work >= 100 or self.horde <= 0 or self.hunger >= 100 or self.receipts <= 0:
            self.score = 0

    def check:
        # if score is too low, end the game
        if self.score <= 0:
            self.stable = false
            return true
        else:
            # check to see if you need to print warnings
            if self.thirst >= 85:
                print "Fry is scary thirsty!"

            if self.work >= 85:
                print "Leela is exhausted from all this work!"

            if self.horde <= 15:
                print "Bender is sad because he doesn't have enough treasure!"

            if self.hunger >= 85:
                print "Zoidberg is going to eat something and it's not going to be pretty!"

            if self.receipts <= 15:
                print "Hermes doesn't have enough receipts!"

            return false
