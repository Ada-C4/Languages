from county import County

print "Welcome to the CA/WA Poverty Educator!"
print ""
ca_file = open("california.txt")
wa_file = open("washington.txt")

def find_extreme_county(file):
    target_line = file.readline()
    target_pov_percent = float(target_line.split()[11])

    for line in file:
        line_pov_percent = float(line.split()[11])
        if (line_pov_percent > target_pov_percent):
            target_line = line
            target_pov_percent = line_pov_percent

    return County(target_line)

highest_ca_county = find_extreme_county(ca_file)
# lowest_ca_county = find_extreme_county(ca_file, false)
highest_wa_county = find_extreme_county(wa_file);
# lowest_wa_county = find_extreme_county(wa_file, false)


print "************"
print "*CALIFORNIA*"
print "************"
print "County with highest percent poverty: " + highest_ca_county.name
print "Percentage of children in poverty: " + highest_ca_county.pov_percent
print "Number of children in poverty: " + highest_ca_county.pov_count
print "Median household income: " + highest_ca_county.med_income
print "------------"
# print "County with lowest percent poverty: " + lowest_ca_county.name
# print "Percentage of children in poverty: " + lowest_ca_county.pov_percent
# print "Number of children in poverty: " + lowest_ca_county.pov_count
# print "Median household income: " + lowest_ca_county.med_income
print "************"
print "*WASHINGTON*"
print "************"
print "County with highest percent poverty: " + highest_wa_county.name
print "Percentage of children in poverty: " + highest_wa_county.pov_percent
print "Number of children in poverty: " + highest_wa_county.pov_count
print "Median household income: " + highest_wa_county.med_income
print "------------"
# print "County with lowest percent poverty: " + lowest_wa_county.name
# print "Percentage of children in poverty: " + lowest_wa_county.pov_percent
# print "Number of children in poverty: " + lowest_wa_county.pov_count
# print "Median household income: " + lowest_wa_county.med_income
print "***************************************************************"
print ""


ca_file.close()
wa_file.close()
# file.close()
