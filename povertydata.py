from operator import attrgetter


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

class StateData:
    def __init__(self, state, state_data):
        self.state = state
        self.county_data = self.create_county_data(state_data)

    def create_county_data(self, state_data):
        all_county_data = []
        for county in state_data:
            children_count = county[49:56].strip()
            children_percentage = county[76:81].strip()
            median_income = county[133:139].strip()
            county_name = county[193:238].strip()
            county_data = CountyData(children_count, children_percentage, median_income, county_name)
            all_county_data.append(county_data)
        return all_county_data

    def lowest_percentage(self):
        county = min(self.county_data,key=attrgetter('children_percentage'))
        return county.print_data()

    def highest_percentage(self):
        county = max(self.county_data,key=attrgetter('children_percentage'))
        return county.print_data()

    def find_county(self, find_county):
        find_county = find_county.replace(" County", "")
        for county in self.county_data:
            county_name = county.county_name.replace(" County", "")
            if county_name.lower() == find_county.lower():
                return county.print_data()
        print "County Not Found"

    def print_counties(self):
        for county in self.county_data:
            print county.county_name



print "Welcome to the US Poverty Data Portal"
print "Enter WA to view poverty data for Washington or OR to view poverty data for Oregon:"
state = raw_input("> ")
state_file_path = None

while state_file_path == None:
    if state == "WA":
        state_file_path = "est14_WA.txt"
    elif state == "OR":
        state_file_path = "est14_OR.txt"
    else:
        print "Invalid input. Please Enter WA for Washington or OR for Oregon"
        state = raw_input("> ")

raw_state_data = open(state_file_path).read()
raw_state_data_list = raw_state_data.split('\n')
list_length = len(raw_state_data_list)
raw_state_data_list = raw_state_data_list[1:list_length - 1]

# print raw_state_data_list[0][193:237].strip()

state_data = StateData(state, raw_state_data_list)

# state_data.print_counties()
