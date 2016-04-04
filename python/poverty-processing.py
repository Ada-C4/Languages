# Take user input for the state

print "What state would you like to lean about?"
print "Options: 1) Massachusetts, 2) Washington"

acceptable = False
while acceptable == False:
    var = raw_input("Please enter 1 or 2 to make your choice: ")
    if var == "1":
        print "You have chosen to learn more about Massachusetts"
        file = open('../est14_MA.txt', 'r')
        acceptable = True
    elif var == "2":
        print "You have chosen to learn more about Washington"
        file = open('../est14_WA.txt', 'r')
        acceptable = True
    else:
        print "Hmm, that doesn't seem like a valid input. Try again."

# Initialize tracking variables

lowest_poverty_county = ""
lowest_youth_poverty = 100
lowest_median_income = ""
lowest_youth_count = ""
highest_poverty_county = ""
highest_youth_poverty = 0
highest_median_income = ""
highest_youth_count = ""

data_dic = {}


# Step through each line and keep track of the county with the highest youth poverty rate and the lowest youth poverty rate
for line in file:
    if line[3:6].strip() != "0":
        all_poverty = line[7:15].strip()
        county = line[193:238].strip()
        count_youth_poverty = float(line[49:57])
        percent_youth_poverty = float(line[76:80])
        median_household_income = line[133:139].strip()

        if percent_youth_poverty < lowest_youth_poverty:
            lowest_poverty_county = county
            lowest_youth_poverty = percent_youth_poverty
            lowest_youth_count = count_youth_poverty
            lowest_median_income = median_household_income
        if percent_youth_poverty > highest_youth_poverty:
            highest_poverty_county = county
            highest_youth_poverty = percent_youth_poverty
            highest_youth_count = count_youth_poverty
            highest_median_income = median_household_income

        # Keeping track of info for county search
        data_dic[county] = [percent_youth_poverty, count_youth_poverty, median_household_income]

# Print out details on the countys
print ""
print "The county with the highest percentage of children in poverty is " + str(highest_poverty_county)
print "This county has " + str(highest_youth_poverty) + "% of children in poverty."
print "The number of children in poverty is " + str(highest_youth_count)
print "The median household income for this county is " + str(highest_median_income)
print ""
print "The county with the lowest percentage of children in poverty is " + str(lowest_poverty_county)
print "This county has " + str(lowest_youth_poverty) + "% of children in poverty."
print "The number of children in poverty is " + str(lowest_youth_count)
print "The median household income for this county is " + str(lowest_median_income)

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
