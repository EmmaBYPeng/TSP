def dist(s, j, mat):
	# Base case
	if s == frozenset([0]) and j == 0:
		return 0
	elif j == 0:
		return 1;
	else:
		return mat[0][j]

def min_val_index(A, j, s, mat):
	min_index = -1
	min_val = 1
	for k in s:
		if k != j:
			val = A[(s-{j}, k)] + mat[k][j]
			if val < min_val:
				min_val = val
				min_index = k
	return min_val, min_index

def min_val_index2(A, num, mat):
	min_index = -1
	min_val = 1
	for j in range(1, num):
		val = A[(frozenset(range(0, num)), j)]
		if val < min_val:
			min_val = val
			min_index = j
	return min_val, min_index