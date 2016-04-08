from county import County

print "Welcome to the CA/WA Poverty Educator!"
print ""
ca_file_name = "california.txt"
wa_file_name = "washington.txt"

def find_extreme_county(file_name, highest):
    file = open(file_name)

    target_line = file.readline()
    target_pov_percent = float(target_line.split()[11])

    for line in file:
        line_pov_percent = float(line.split()[11])
        if (highest):
            if (line_pov_percent > target_pov_percent):
                target_line = line
                target_pov_percent = line_pov_percent
        else:
            if (line_pov_percent < target_pov_percent):
                target_line = line
                target_pov_percent = line_pov_percent
    file.close()
    return County(target_line)

def print_county(file_name, user_county):
    file = open(file_name)
    county_found = False
    for line in file:
        if (user_county in line.lower()):
            county = County(line)
            county_found = True
            print "County: " + county.name
            print "Percentage of children in poverty: " + county.pov_percent
            print "Number of children in poverty: " + county.pov_count
            print "Median household income: " + county.med_income
    file.close()
    return county_found

highest_ca_county = find_extreme_county(ca_file_name, True)
lowest_ca_county = find_extreme_county(ca_file_name, False)
highest_wa_county = find_extreme_county(wa_file_name, True);
lowest_wa_county = find_extreme_county(wa_file_name, False)

print "************"
print "*CALIFORNIA*"
print "************"
print "County with highest percent poverty: " + highest_ca_county.name
print "Percentage of children in poverty: " + highest_ca_county.pov_percent
print "Number of children in poverty: " + highest_ca_county.pov_count
print "Median household income: " + highest_ca_county.med_income
print "------------"
print "County with lowest percent poverty: " + lowest_ca_county.name
print "Percentage of children in poverty: " + lowest_ca_county.pov_percent
print "Number of children in poverty: " + lowest_ca_county.pov_count
print "Median household income: " + lowest_ca_county.med_income
print "************"
print "*WASHINGTON*"
print "************"
print "County with highest percent poverty: " + highest_wa_county.name
print "Percentage of children in poverty: " + highest_wa_county.pov_percent
print "Number of children in poverty: " + highest_wa_county.pov_count
print "Median household income: " + highest_wa_county.med_income
print "------------"
print "County with lowest percent poverty: " + lowest_wa_county.name
print "Percentage of children in poverty: " + lowest_wa_county.pov_percent
print "Number of children in poverty: " + lowest_wa_county.pov_count
print "Median household income: " + lowest_wa_county.med_income
print "***************************************************************"
print ""
state = raw_input("Enter 'CA' for California, 'WA' for Washington, or 'q' to quit: ").upper()
if (state == "WA"):
    file_name = "washington.txt"
elif (state == "CA"):
    file_name = "california.txt"
elif (state == "Q"):
    print "BYE."
    quit()

user_county = raw_input("Enter a county in " + state + " or 'q' to quit: ").lower()
if (user_county == "q"):
    print "BYE."
    quit()

success = print_county(file_name, user_county)
