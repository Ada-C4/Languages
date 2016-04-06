@file_WA = File.open('est14_WA.txt')
@file_CA = File.open('est14_WA.txt')

data_array = []
  @file_WA.each do |line|
    data_array.push(line)
  end

  d = data_array[1].split(' ')

  if d[76..80] == "32.2"
    puts d[23]
  end
  puts d[2]
  puts d.class
  puts d[23..24].join(' ')


def highest_percent_poverty
  percent_array = []
  @file_WA.each do |line|
    percent_array.push(line.slice(76..80))
  end
  return percent_array.max
end

# puts highest_percent_poverty
# puts find_county
