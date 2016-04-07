class County
  attr_accessor :name, :percent, :num, :median_income

  def initialize(name, percent, num, median_income)
    @name = name.strip
    @percent = percent.to_f
    @num = num.to_i
    @median_income = median_income.to_i
  end

  def self.all_counties
    puts "Choose a state: WA or CA: "
    @state = gets.chomp.upcase
    if @state == "WA"
      file = File.open('est14_WA.txt')
    elsif @state == "CA"
      file = File.open('est14_CA.txt')
    end
    data_array = []
    file.each do |line|
      data_array.push(County.new(line[193..217], line[76..79], line[49..56], line[133..138]))
    end
    return data_array
  end

  def self.find_by_county
    print "Search by counties in #{@state}. Type in a county: "
    county_input = gets.chomp.downcase
    all_counties.each do |county|
      if county.name.strip.downcase == county_input
        puts "There is #{county.percent}% poverty in #{county.name}. That amounts to #{county.num} people. The median income in #{county.median_income}"
      end
    end
  end

  def self.find_highest_pov
    highest = 0
    county_name = ""
    count = 0
    income = 0
    all_counties.each do |county|
      if county.percent > highest
        highest = county.percent
        county_name = county.name
        count = county.num
        income = county.median_income
      end
    end
    puts "#{highest}% poverty in #{county_name} is the highest in #{@state}. #{count} people live in poverty and the median income is $#{income}"
  end

  def self.find_lowest_pov
    lowest = 100
    county_name = ""
    count = 0
    income = 0
    all_counties.each do |county|
      if county.percent < lowest
        lowest = county.percent
        county_name = county.name
        count = county.num
        income = county.median_income
      end
    end
    puts "#{lowest}% poverty in #{county_name} is the lowest in #{@state}. #{count} people live in poverty and the median income is $#{income}"
  end

  self.find_by_county
  # self.find_highest_pov
  # self.find_lowest_pov
end
