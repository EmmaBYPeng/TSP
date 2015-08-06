from input import process_input_file
from dynamic_tsp import solve_tsp

num_node = 4

adjamatrix = process_input_file("/Users/Emma/GitHub/TSP/input/input.txt", num_node)

dist, path = solve_tsp(adjamatrix, num_node)

print "Min distance: " + str(dist)
print "Shortest path: " + str(path)
