def highest_state_poverty(data):
    highest_name = ""
    highest_percent = 0
    highest_num = 0
    highest_median_income = 0
    file = open(data, 'r')
    for line in file:
        name = line[193:218].strip()
        percent = float(line[76:80])
        num = line[49:57].strip()
        median_income = line[133:139].strip()
        if percent > highest_percent:
            highest_percent = percent
            highest_name = name
            highest_num = num
            highest_median_income = median_income
    print "The county with the highest child poverty is %s, with %s percent. That amounts to %s children. The median_income for the county is $%s" % (highest_name, highest_percent, highest_num, highest_median_income)

def lowest_state_poverty(data):
    lowest_name = ""
    lowest_percent = 100
    lowest_num = 0
    lowest_median_income = 0
    file = open(data, 'r')
    for line in file:
        name = line[193:218].strip()
        percent = float(line[76:80])
        num = line[49:57].strip()
        median_income = line[133:139].strip()
        if percent < lowest_percent:
            lowest_percent = percent
            lowest_name = name
            lowest_num = num
            lowest_median_income = median_income
    print "The county with the lowest child poverty is %s, with %s percent. That amounts to %s children. The median_income for the county is $%s" % (lowest_name, lowest_percent, lowest_num, lowest_median_income)

print lowest_state_poverty('est14_GA.txt')
print highest_state_poverty('est14_GA.txt')
