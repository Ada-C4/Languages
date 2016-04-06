STATE_FILES = { "Washington" => "povWA.txt", "South Dakota" => "povSD.txt"}

def get_minimum_child_poverty_record(state)
  File.open(STATE_FILES[state]) do |file|
    current_min = nil
    min_county_record = nil
    file.each_with_index do |record, i|
      if i > 0 # skip the header row
        current_min ||= record[76..79].to_f
        min_county_record ||= record
        if record[76..79].to_f < current_min
          current_min = record[76..79].to_f
          min_county_record = record
        end
      end
    end
    return min_county_record
  end
end

def get_maximum_child_poverty_record(state)
  File.open(STATE_FILES[state]) do |file|
    current_max = nil
    max_county_record = nil
    file.each_with_index do |record, i|
      if i > 0 # skip the header row
        current_max ||= record[76..79].to_f
        max_county_record ||= record
        if record[76..79].to_f > current_max
          current_max = record[76..79].to_f
          max_county_record = record
        end
      end
    end
    return max_county_record
  end
end

def print_child_poverty_info(state)
  min_county_record = get_minimum_child_poverty_record(state)
  max_county_record = get_maximum_child_poverty_record(state)

  puts "In #{state}:"
  puts "The county with the lowest percentage of children in poverty is #{min_county_record[193..237].strip}. In that county, #{min_county_record[49..56].strip} children (#{min_county_record[76..79].strip}%) are in poverty. The median household income is $#{min_county_record[133..138].strip}."
  puts "The county with the highest percentage of children in poverty is #{max_county_record[193..237].strip}. In that county, #{max_county_record[49..56].strip} children (#{max_county_record[76..79].strip}%) are in poverty. The median household income is $#{max_county_record[133..138].strip}."
end

print_child_poverty_info("Washington")
print_child_poverty_info("South Dakota")
