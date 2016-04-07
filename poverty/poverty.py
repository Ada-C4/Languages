

highest_percent_poverty_county = ""
highest_percent_poverty = 0
lowest_percent_poverty_county = ""
lowest_percent_poverty = 100
county_dict = {}

f = open('./WA_data.txt')
for line in f:
    if line[3:6].strip() != "0": # To exclude the overall state data
        count_poverty = line[52:58].strip()
        percent_poverty = float(line[76:80])
        median_income = line[135:140].strip()
        county_name = line[193:238].strip()

        if percent_poverty > highest_percent_poverty:
            highest_percent_poverty = percent_poverty
            highest_percent_poverty_county = county_name
        elif percent_poverty < lowest_percent_poverty:
            lowest_percent_poverty = percent_poverty
            lowest_percent_poverty_county = county_name

        county_dict[county_name] = {'count_poverty': count_poverty, 'percent_poverty': percent_poverty, 'median_income': median_income}


print "The highest percent of children in poverty is {}% in {}".format(highest_percent_poverty, highest_percent_poverty_county)
print "The count of children in poverty is {} and the median income is ${}".format(county_dict[highest_percent_poverty_county]['count_poverty'], county_dict[highest_percent_poverty_county]['median_income'])
