STATE_FILES = {"Washington": "povWA.txt", "South Dakota": "povSD.txt"}

def get_minimum_child_poverty_record(state):
    data_file = open(STATE_FILES[state], 'r')
    current_min = None
    min_county_record = None

    for i, record in enumerate(data_file):
        if i > 0:
            if current_min is None:
                current_min = float(record[76:80])
            if float(record[76:80]) < current_min:
                current_min = float(record[76:80])
                min_county_record = record

    data_file.close()
    return min_county_record


def get_maximum_child_poverty_record(state):
    data_file = open(STATE_FILES[state], 'r')
    current_max = None
    max_county_record = None

    for i, record in enumerate(data_file):
        if i > 0:
            if current_max is None:
                current_max = float(record[76:80])
            if float(record[76:80]) > current_max:
                current_max = float(record[76:80])
                max_county_record = record

    data_file.close()
    return max_county_record

print get_minimum_child_poverty_record("Washington")
print get_maximum_child_poverty_record("Washington")
print get_minimum_child_poverty_record("South Dakota")
print get_maximum_child_poverty_record("South Dakota")


def print_child_poverty_info(state):
    min_county_record = get_minimum_child_poverty_record(state)
    max_county_record = get_maximum_child_poverty_record(state)

    print "In {0}:".format(state)
    print "The county with the lowest percentage of children in poverty is {0}. In that county, {1} children ({2}%) are in poverty. The median household income is ${3}.".format(min_county_record[193:239].strip(), min_county_record[49:57].strip(), min_county_record[76:80].strip(), min_county_record[133:139].strip())
    print "The county with the highest percentage of children in poverty is {0}. In that county, {1} children ({2}%) are in poverty. The median household income is ${3}.".format(max_county_record[193:239].strip(), max_county_record[49:57].strip(), max_county_record[76:80].strip(), max_county_record[133:139].strip())

print_child_poverty_info("Washington")
print_child_poverty_info("South Dakota")
