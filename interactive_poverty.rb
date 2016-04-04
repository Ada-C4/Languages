print "Enter a county name in Washington: "
county = gets.chomp.capitalize
match = nil

File.open("povWA.txt") do |file|

  file.each_with_index do |record, i|
    if i > 0
      if county + " County" == record[193..237].strip
        match = record
        break
      end
    end
  end
end

if match.nil?
  puts "nope"
else
  puts match
end
