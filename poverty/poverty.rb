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
      data_array.push(County.new(line[193..237], line[76..79], line[49..56], line[133..138]))
    end
    return data_array
  end
  # puts self.all_counties[3].name
  # puts self.all_counties[3].percent
  # puts self.all_counties[3].num
  # puts self.all_counties[3].median_income

  def self.find_highest_pov
    highest = 0
    county_name = ""
    all_counties.each do |county|
      if county.percent > highest
        highest = county.percent
        county_name = county.name
      end
    end
    return "highest is #{highest} and the name is #{county_name}"

  end
  puts self.find_highest_pov

end


# @file_WA = File.read('est14_WA.txt')
# @file_CA = File.read('est14_WA.txt')
#
# data_array = []
#   @file_WA.each do |line|
#     data_array.push(line)
#   end
#
#   d = data_array[1].split(' ')
#
#   if d[76..80] == "32.2"
#     puts d[23]
#   end
#   puts d[2]
#   puts d.class
#   puts d[23..24].join(' ')


# def highest_percent_poverty
#   percent_array = []
#   @file_WA.each do |line|
#     percent_array.push(line.slice(76..80))
#   end
#   return percent_array.max
# end

# puts highest_percent_poverty
# puts find_county
