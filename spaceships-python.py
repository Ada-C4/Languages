class PlanetExpress:
    def __init__(self):
        self.thirst = 5
        self.work = 5
        self.horde = 5
        self.hunger = 5
        self.receipts = 5
        self.stable = True

    def drink(self):
        # decreases thirst and increases work
        self.thirst -= 1
        self.work += 1

    def deliver(self):
        # decreases work and increases receipts
        self.work -= 1
        self.receipts =+ 1

    def steal(self):
        #increases horde and increases work
        self.horde += 1
        self.work += 1

    def eat(self):
        # decreases hunger and increases work
        self.hunger -= 1
        self.work += 1

    def account(self):
        # decreases receipts and decreases horde
        self.receipts -= 1
        self.horde -= 1

    def check_stability(self):
        if self.thirst > 10 or self.thirst < 0 or self.work > 10 or self.work < 0 or self.horde > 10 or self.horde < 0 or self.hunger > 10 or self.hunger < 0 or self.receipts > 10 or self.receipts < 0:
            self.stable = False

    def check(self):
        if self.stable == False:
            return False
        else:
            return True

    def score(self):
        score = (10-self.thirst) + (10-self.work) + (10-self.hunger) + self.horde + self.receipts
        return score



print "Welcome to Planet Express"
print "Let's get started"
print("""\
                     /\\
                    /''\\
                   /    \\
                  /      \\
                 /        \\
                /          \\
               '------------'
                |__________|
                /----/\----\\
               /|    ||    |\\
              //|____||____|\\\\
             //  |   ||   |  \\\\
            / |  |___||___|  | \\
            | |   '._||_.'   | |
            | |    |_||_|    | |
            | |  .'  ||  '.  | |
            | | /    ||    \ | |
            | ||     ||     || |
            | ||     ||     || |
            | | \    ||    / | |
            | |  '. _||_ .'  | |
            | | _    ||    _ | |
            | |/ \_.'||'._/ \| |
            | |\_/ '.||.' \_/| |
            | |     _||_     | |
           /| |  .'  ||  '.  | |\\
          / '.| /    ||    \ |.' \\
         /   |||     ||     |||   \\
        /    |||     ||     |||    \\
       /     || \    ||    / ||     \\
      /____/\||__'. _||_ .'__||/\____\\
             |_.--^--||--^--._|
            / .'/_'''||'''_\\'. \\
           / /   /___||___\   \ \\
          / /     /__||__\     \ \\
         / /         ||         \ \\
        /.'          ||          '.\\
       //            ||            \\\\
    __//_          __||__          _\\\__
   '====='        '======'        '====='
""")

keep_playing = True
game = PlanetExpress()
while keep_playing == True:
    success = False
    while success == False:
        print "You have the following options: drink, deliver, steal, eat, or account"
        var = raw_input("What would you like to do? ")
        var = var.lower()
        if var == "drink":
            game.drink()
            print "Drink completed successfully"
            print "Your current score is " + str(game.score())
            success = True
        elif var == "deliver":
            game.deliver()
            print "Deliver completed successfully"
            print "Your current score is " + str(game.score())
            success = True
        elif var == "steal":
            game.steal()
            print "Steal completed successfully"
            print "Your current score is " + str(game.score())
            success = True
        elif var == "eat":
            game.eat()
            print "Eat completed successfully"
            print "Your current score is " + str(game.score())
            success = True
        elif var == "account":
            game.account()
            print "Account completed successfully"
            print "Your current score is " + str(game.score())
            success = True
        else:
            print "Oops, that didn't seem like one of the options. Try again!"

        game.check()
        if game.stable == False:
            print "Game Over!"
            keep_playing = False
