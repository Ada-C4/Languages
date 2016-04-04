def get_match(county)
  File.open("povWA.txt") do |file|
    file.each_with_index do |record, i|
      if i > 0
        if county + " County" == record[193..237].strip
          match = record
          return match
        end
      end
    end
  end
  return nil
end

def print_county_info(record)
  puts "In #{record[193..237].strip}, #{record[49..56].strip} children (#{record[76..79].strip}%) are in poverty. The median household income is $#{record[133..138].strip}."
end


print "Enter a county name in Washington (e.g., King), or type `quit` to quit: "
county = gets.chomp.capitalize

while county != "Q" && county != "Quit"
  record = get_match(county)

  while record.nil?
    print "No match found. Try again: "
    county = gets.chomp.capitalize
    record = get_match(county)
  end

  print_county_info(record)
  print "Enter another county, or type `quit` to quit: "
  county = gets.chomp.capitalize
end
