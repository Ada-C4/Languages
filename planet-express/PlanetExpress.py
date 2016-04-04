class PlanetExpress:
    def __init__:
        self.thirst = 50
        self.work = 50
        self.receipts = 50
        self.horde = 50
        self.hunger = 50
        self.stable = True

    def drink():
        self.thirst -= 4
        self.work += 4

    def deliver():
        self.receipts += 4
        self.work -= 4

    def steal():
        self.horde += 4
        self.work += 4

    def eat():
        self.hunger -= 4
        self.work += 4

    def account():
        self.receipts -= 4
        self.horde -= 4

    def score():
        horde_score = self.horde * 1000
        thirst_score = self.thirst * -10
        receipts_score = self.receipts * -10
        work_score = self.work * -10
        hunger_score = self.hunger * -10
        return horde_score + thirst_score + receipts_score + work_score + hunger_score


    def check():
        if (self.thirst >= 90 and self.thirst < 100):
            print "Warning! Fry is very thirsty and is in danger of crashing the ship."
        if (self.work >= 90 and self.work < 100):
            print "Warning! Leela has tons of work and is in danger of crashing the ship."
        if (self.horde <= 10 and self.work > 0):
            print "Warning! Bender's horde is very low and is in danger of crashing the ship."
        if (self.hunger >= 90 and self.hunger < 100):
            print "Warning! Zoidberg is very hungry and is in danger of crashing the ship."
        if (self.receipts >= 90 and self.receipts < 100):
            print "Warning! Hermes' backlog of receipts is huge and is in danger of crashing the ship."
        if (self.thirst < 100 and self.work < 100 and self.hunger < 100 and self.horde > 0 and self.receipts < 100):
            self.stable = false
        return self.stable
