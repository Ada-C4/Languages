def get_match(county):
    data_file = open('povWA.txt', 'r')
    for i, record in enumerate(data_file):
        if i > 0:
            if county + " County" == record[193:238].strip():
                match = record
                return match
    return None

def print_county_info(record):
    print "In {0}, {1} children ({2}%) are in poverty. The median household income is ${3}.".format(record[193:239].strip(), record[49:57].strip(), record[76:80].strip(), record[133:139].strip())

county = raw_input("Enter a county name in Washington (e.g., King), or type `quit` to quit: ").strip().capitalize()

while county != "Q" and county != "Quit":
    record = get_match(county)

    while record is None:
        county = raw_input("No match found. Try again, or type `quit` to quit: ").strip().capitalize()
        record = get_match(county)

    print_county_info(record)
    county = raw_input("Enter another county, or type `quit` to quit: ").strip().capitalize()
