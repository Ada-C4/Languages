def get_poverty_data(file):
    highest_percent_poverty_county = ""
    highest_percent_poverty = 0
    lowest_percent_poverty_county = ""
    lowest_percent_poverty = 100
    county_dict = {}

    f = open(file)
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

    return county_dict, lowest_percent_poverty_county, highest_percent_poverty_county


wa_county_info, wa_lowest_pov_county, wa_highest_pov_county = get_poverty_data('./WA_data.txt')
or_county_info, or_lowest_pov_county, or_highest_pov_county = get_poverty_data('./OR_data.txt')



print "In Washington, the county with the highest percentage of children in poverty is {} with {}% of children in poverty".format(wa_highest_pov_county, wa_county_info[wa_highest_pov_county]['percent_poverty'])
print "The count of children in poverty is {} and the median income is ${}".format(wa_county_info[wa_highest_pov_county]['count_poverty'], wa_county_info[wa_highest_pov_county]['median_income'])
print "In Washington, the county with the lowest percentage of children in poverty is {} with {}% of children in poverty".format(wa_lowest_pov_county, wa_county_info[wa_lowest_pov_county]['percent_poverty'])
print "The count of children in poverty is {} and the median income is ${}".format(wa_county_info[wa_lowest_pov_county]['count_poverty'], wa_county_info[wa_lowest_pov_county]['median_income'])
