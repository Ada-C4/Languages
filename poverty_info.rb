require 'pry'

STATE_FILES = { "Washington" => "povWA.txt", "South Dakota" => "povSD.txt"}

def print_child_poverty_info(state)
  File.open(STATE_FILES[state]) do |file|
    current_min = nil
    current_max = nil
    min_county_record = nil
    max_county_record = nil

    # get the values to compare against
    file.each_with_index do |record, i|
      if i == 1
        current_min = record[76..79].to_f
        min_county_record = record
        current_max = record[76..79].to_f
        max_county_record = record
        break
      end
    end

    file.each_with_index do |record, i|
      child_pov_percentage = record[76..79].to_f

      # change minimum as needed
      if child_pov_percentage < current_min
        current_min = child_pov_percentage
        min_county_record = record
      end

      # change maximum as needed
      if child_pov_percentage > current_max
        current_max = child_pov_percentage
        max_county_record = record
      end
    end

    puts "In #{state}:"
    puts "The county with the lowest percentage of children in poverty is #{min_county_record[193..237].strip}. In that county, #{min_county_record[49..56].strip} children (#{min_county_record[76..79].strip}%) are in poverty. The median household income is $#{min_county_record[133..138].strip}."
    puts "The county with the highest percentage of children in poverty is #{max_county_record[193..237].strip}. In that county, #{max_county_record[49..56].strip} children (#{max_county_record[76..79].strip}%) are in poverty. The median household income is $#{max_county_record[133..138].strip}."
  end
end

print_child_poverty_info("Washington")
print_child_poverty_info("South Dakota")
