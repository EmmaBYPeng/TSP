package greedy;

import java.io.File;
import java.util.Scanner;

public class InputFileProcessor {

	private File file;
	private int numNodes;
	private int adjMatrix[][];
	
	public InputFileProcessor (String fileName, int numNodes) {
		this.numNodes = numNodes;
		adjMatrix = new int[numNodes][numNodes];
		file = new File(fileName);
	}
	
	public int[][] initializeMatrix() throws Exception {
		Scanner scanner = new Scanner(file);
		
		int i = 0;
		while (scanner.hasNext() && i < numNodes) {
			String line[] = scanner.nextLine().split(" ");
			
			if (line.length != numNodes) {
				System.out.println(line.length);
				System.out.println("Invalid input matrix size -- should be numNodes * numNodes");
				break;
			}
			
			for (int j = 0; j < numNodes; j++) {
				adjMatrix[i][j] = Integer.parseInt(line[j]);
			}
			
			i++;
		}
		
		scanner.close();
		return adjMatrix;
	}
}
