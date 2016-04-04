STATE_FILES = {"Washington": "povWA.txt", "South Dakota": "povSD.txt"}

def print_child_poverty_info(state):
    file = open(STATE_FILES[state], 'r')
    current_min = None
    current_max = None
    min_county_record = None
    max_county_record = None

    # get the values to compare against
    for i, record in enumerate(file):
        if i == 1:
            current_min = float(record[76:80])
            min_county_record = record
            current_max = float(record[76:80])
            max_county_record = record
            break

    # get max and min
    for i, record in enumerate(file):
        child_pov_percentage = float(record[76:80])

        # change minimum as needed
        if child_pov_percentage < current_min:
          current_min = child_pov_percentage
          min_county_record = record

        # change maximum as needed
        if child_pov_percentage > current_max:
          current_max = child_pov_percentage
          max_county_record = record

    print "In {0}:".format(state)
    print "The county with the lowest percentage of children in poverty is {0}. In that county, {1} children ({2}%) are in poverty. The median household income is ${3}.".format(min_county_record[193:239].strip(), min_county_record[49:57].strip(), min_county_record[76:80].strip(), min_county_record[133:139].strip())
    print "The county with the highest percentage of children in poverty is {0}. In that county, {1} children ({2}%) are in poverty. The median household income is ${3}.".format(max_county_record[193:239].strip(), max_county_record[49:57].strip(), max_county_record[76:80].strip(), max_county_record[133:139].strip())

print_child_poverty_info("Washington")
print_child_poverty_info("South Dakota")
