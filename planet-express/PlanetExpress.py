class PlanetExpress:
    def __init__(self):
        self.thirst = 50
        self.work = 50
        self.receipts = 50
        self.horde = 50
        self.hunger = 50
        self.stable = True

    def drink(self):
        self.thirst -= 4
        self.work += 4

    def deliver(self):
        self.receipts += 4
        self.work -= 4

    def steal(self):
        self.horde += 4
        self.work += 4

    def eat(self):
        self.hunger -= 4
        self.work += 4

    def account(self):
        self.receipts -= 4
        self.horde -= 4

    def score(self):
        horde_score = self.horde * 1000
        thirst_score = self.thirst * -10
        receipts_score = self.receipts * -10
        work_score = self.work * -10
        hunger_score = self.hunger * -10
        return horde_score + thirst_score + receipts_score + work_score + hunger_score


    def check(self):
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
        if (self.thirst > 100 or self.work > 100 or self.hunger > 100 or self.horde <= 0 or self.receipts > 100):
            self.stable = False
        return self.stable

p = PlanetExpress()
print "Welcome to Planet Express!"
while p.stable:
    action = raw_input("Type drink, deliver, steal, eat, or account to continue playing.")
    if action == "drink":
        p.drink()
    elif action == "deliver":
        p.deliver()
    elif action == "steal":
        p.steal()
    elif action == "eat":
        p.eat()
    elif action == "account":
        p.account()
    else:
        print "That's not a valid choice. Try again."
    print "Score: {}".format(p.score())
    if not p.check():
        print "GAME OVER"
