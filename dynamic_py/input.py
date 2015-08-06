import numpy

def process_input_file(filename, num):
	inputfile = open(filename)
	adjmatrix = numpy.zeros((num, num))

	i = 0;
	for line in inputfile:
		adjmatrix[i][:] = map(lambda c: int(c), line.split('\n')[0].split(' '))
		i += 1

	return adjmatrix