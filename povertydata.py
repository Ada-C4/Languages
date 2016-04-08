# from sys import argv
#
# script, filename = argv

print "Welcome to the US Poverty Data Portal"
print "Enter WA to view poverty data for Washington or OR to view poverty data for Oregon:"
state = raw_input("> ")

if state == "WA":
    state_file_path = "est14_WA.txt"
elif state == "OR":
    state_file_path = "est14_OR.txt"
else:
    print "Invalid input"

raw_state_data = open(state_file_path)

print raw_state_data.read()
