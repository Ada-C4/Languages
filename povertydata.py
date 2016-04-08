# from sys import argv
#
# script, filename = argv

class CountyData:
    def __init__(self, children_count, children_percentage, median_income, county_name):
        self.children_count = children_count
        self.children_percentage = children_percentage
        self.median_income = median_income
        self.county_name = county_name

    def print_data(self):
        print  self.county_name
        print 'Percentage of Children in Poverty: %s' % self.children_percentage
        print 'Number of Children in Poverty: %s' % self.children_count
        print 'Median Household Income: %s' % self.median_income


print "Welcome to the US Poverty Data Portal"
print "Enter WA to view poverty data for Washington or OR to view poverty data for Oregon:"
state = raw_input("> ")

if state == "WA":
    state_file_path = "est14_WA.txt"
elif state == "OR":
    state_file_path = "est14_OR.txt"
else:
    print "Invalid input"

raw_state_data = open(state_file_path).read()
raw_state_data_list = raw_state_data.split('\n')

# print raw_state_data_list
