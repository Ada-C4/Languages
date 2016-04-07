class County
  attr_accessor :county, :state, :percent, :child_poverty_count, :median_income

  def initialize(county, state, percent, child_poverty_count, median_income)
    @county = county
    @state = state
    @percent = percent
    @child_poverty_count = child_poverty_count
    @median_income = median_income
  end

  def self.all
    print "Please enter WA or CA for information:  "
    state = gets.chomp
    if state == "WA"
      @file= File.open('est14_WA.txt')
    elsif state == "CA"
      @file= File.open('est14_CA.txt')
    end
    array = []
    @file.each do |row|
      array.push(
      County.new(row[193..237], row[239..241], row[76..79], row[49..56], row[133..138]))
      end
    return array
  end

  def self.highest_poverty_WA
    percents = []
    all.each do |row|
      percents.push(row.percent)
    end
    return percents.max
  end
  puts self.highest_poverty_WA
end



#   def self.highest_poverty_CA
#     poverty_rate_CA = []
#     @file_CA.each_line do |line|
#       poverty_rate_CA << line.slice(76..80)
#     end
#     return poverty_rate_CA.max
#   end
# end
#
# def county_name
#   each_line = []
#   @file_WA.each_line do |line|
#     each_line << line
#   end
#   array = each_line[8].split(' ')
#   puts array[23..25].join(' ')
# end

# puts county_name
# puts find_highest_poverty_WA
# puts find_highest_poverty_CA
