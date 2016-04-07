class County
  attr_accessor :name, :percent, :num, :median_income

  def initialize(name, percent, num, median_income)
    @name = name
    @percent = percent.to_f
    @num = num.to_i
    @median_income = median_income.to_i
  end

  def self.all_counties
    file_WA = File.open('est14_WA.txt')
    data_array = []
    file_WA.each do |line|
      data_array.push(County.new(line[193..217], line[76..79], line[49..56], line[133..138]))
    end
    return data_array
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
    return "#{highest}% poverty in #{county_name}. Count is #{count} and median income is $#{income}"
  end
  puts self.find_highest_pov

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
    return "#{lowest}% poverty in #{county_name}. Count is #{count} and median income is $#{income}"
  end
  puts self.find_lowest_pov
end
