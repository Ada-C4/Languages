def build_county_dict(lowestfile):
    lpc = ""
    lowest_youth_poverty = 100
    hpc = ""
    highest_youth_poverty = 0
    data_dic = {}

    for line in file:
        if line[3:6].strip() != "0":
            all_poverty = line[7:15].strip()
            county = line[193:238].strip()
            count_youth_poverty = float(line[49:57])
            percent_youth_poverty = float(line[76:80])
            median_household_income = line[133:139].strip()

            if percent_youth_poverty < lowest_youth_poverty:
                lpc = county
                lowest_youth_poverty = percent_youth_poverty
            if percent_youth_poverty > highest_youth_poverty:
                hpc = county
                highest_youth_poverty = percent_youth_poverty

            data_dic[county] = [percent_youth_poverty, count_youth_poverty, median_household_income]

    return data_dic, hpc, lpc


print "What state would you like to lean about?"
print "Options: 1) Massachusetts, 2) Washington"

acceptable = False
while acceptable == False:
    var = raw_input("Please enter 1 or 2 to make your choice: ")
    if var == "1":
        print "You have chosen to learn more about Massachusetts"
        file = open('../est14_MA.txt', 'r')
        data_dic, highest_poverty_county, lowest_poverty_county = build_county_dict(file)
        # data_dic = result[0]
        # highest_poverty_county = result[1]
        # lowest_poverty_county = result[2]
        acceptable = True
    elif var == "2":
        print "You have chosen to learn more about Washington"
        file = open('../est14_WA.txt', 'r')
        result = build_county_dict(file)
        data_dic = result[0]
        highest_poverty_county = result[1]
        lowest_poverty_county = result[2]
        acceptable = True
    else:
        print "Hmm, that doesn't seem like a valid input. Try again."

print ""
print "The county with the highest percentage of children in poverty is " + str(highest_poverty_county)
print "This county has " + str(data_dic[highest_poverty_county][0]) + "% of children in poverty."
print "The number of children in poverty is " + str(data_dic[highest_poverty_county][1])
print "The median household income for this county is " + str(data_dic[highest_poverty_county][2])
print ""
print "The county with the lowest percentage of children in poverty is " + str(lowest_poverty_county)
print "This county has " + str(data_dic[lowest_poverty_county][0]) + "% of children in poverty."
print "The number of children in poverty is " + str(data_dic[lowest_poverty_county][1])
print "The median household income for this county is " + str(data_dic[lowest_poverty_county][2])
print ""

print "Would you like to learn about other counties in this state?"
print "Type 'quit' at any time to exit the program"

# Loop to handle input of single county and return information on the county
contin = True
while contin == True:
    var = raw_input("Enter a county name for more information: ")
    if var.lower() == "quit" or var.lower() == "q":
        contin = False
    else:
        var_new = var.lower()
        var_new = var_new.replace("county", "")
        var_new = var_new.strip().capitalize()
        var_new += " County"
        if var_new in data_dic.keys():
            print ""
            print "You have selected to learn more about " + var_new
            print "In " + var_new + ", " + str(data_dic[var_new][0]) + "% of youth live in poverty."
            print "The number of children in poverty is " + str(data_dic[var_new][1]) + "."
            print "The median household income for this county is " + str(data_dic[var_new][2]) + "."
            print ""
        else:
            print "That doesn't seem to be a valid county name. Try again."
