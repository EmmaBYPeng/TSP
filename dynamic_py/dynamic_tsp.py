import itertools
from util import dist
from util import min_val_index
from util import min_val_index2

def solve_tsp(adjmatrix, num):
	S = []

	# All subsets of {0, 2, ..., N-1} containing 0
	# range(1, 4) = [1, 2, 3]
	for i in range(1, num):
		S += [ frozenset(C) | {0} for C in itertools.combinations(range(1, num), i) ]

	S += [frozenset([0])]

	A = {}
	path = {}
	path[(frozenset([0]), 0)] = 0

	# Initialize A indexed by subsets of {0, 1, ..., N-1} that contains 0 and destinations j (0, 1, ..., N-1)
	for s in S:
		for j in s:
			A[(s, j)] = dist(s, j, adjmatrix)

	for m in range(1, num): 
		for s in [ frozenset(C) | {0} for C in itertools.combinations(range(1, num), m) ]:
			for j in s - {0}:
				A[(s, j)], k = min_val_index(A, j, s, adjmatrix)
				path[(s, j)] = k

	# Get the overall min distance and corresponding destination
	min_dist, j = min_val_index2(A, num, adjmatrix)

	temp = num-1
	min_path = [j]
	s = frozenset(range(0, num))

	# Back track to find the whole path
	while temp:
		next = path[(s, j)]
		min_path.append(next)
		s -= {j}
		j = next
		temp -= 1

	return min_dist, [i for i in reversed(min_path)]	


	