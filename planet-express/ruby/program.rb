require "./crew.rb"

spaceship = Crew.new

puts spaceship.check
puts spaceship.work
7.times do
  spaceship.drink
end
puts spaceship.work
puts spaceship.check
3.times do
  spaceship.drink
end
puts spaceship.work
puts spaceship.score
puts spaceship.check
