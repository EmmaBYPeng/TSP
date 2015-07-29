package greedy;

import java.util.ArrayList;

public class Main {
	
	public static void printMatrix(int matrix[][]) {
		int x = matrix.length;
		
		if (x == 1) {
			System.out.println("Empty matrix!");
			return;
		}
		
		int y = matrix[0].length;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void solveTSP(String file, int numNodes) {
		InputFileProcessor processor = new InputFileProcessor(file, numNodes);
		
		try {
			int adjMatrix[][] = processor.initializeMatrix();
			
			GreedyTSP greedy = new GreedyTSP(adjMatrix);
			ArrayList<Integer> path = greedy.shortestPath();
			path.forEach(x -> System.out.print(x + " "));
			System.out.println();
			
			TwoOpt optimizer = new TwoOpt(path, adjMatrix);
			ArrayList<Integer> newPath = optimizer.optimize();
			newPath.forEach(x -> System.out.print(x + " "));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String args[]) {
		
		String input = "/Users/Emma/GitHub/TSP/src/greedy/input.txt";
		InputFileProcessor processor = new InputFileProcessor(input, 4);
		
		try {
			int adjMatrix[][] = processor.initializeMatrix();
			
			GreedyTSP greedy = new GreedyTSP(adjMatrix);
			ArrayList<Integer> path = greedy.shortestPath();
			path.forEach(x -> System.out.print(x + " "));
			System.out.println();
			
			TwoOpt optimizer = new TwoOpt(path, adjMatrix);
			ArrayList<Integer> newPath = optimizer.optimize();
			newPath.forEach(x -> System.out.print(x + " "));
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
}
