import crew

spaceship = crew.Crew()

print spaceship.check()
print spaceship.work
for i in range(0,7):
    spaceship.drink()
print spaceship.work
print spaceship.check()
for j in range(0,3):
    spaceship.drink()
print spaceship.work
print spaceship.current_score()
print spaceship.check()
