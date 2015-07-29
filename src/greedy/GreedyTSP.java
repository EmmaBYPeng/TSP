package greedy;

import java.util.Stack;
import java.util.ArrayList;

public class GreedyTSP {
	
	private final int DIST_TO_SELF = 1;
	private int numNodes;
	private int adjMatrix[][];
	private Stack<Integer> stack;
	private ArrayList<Integer> path;

	public GreedyTSP(int adjMatrix[][]) {
		this.adjMatrix = adjMatrix;
		numNodes = adjMatrix.length;
		stack = new Stack<Integer>();
		path = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> shortestPath() {
		int visited[] = new int[numNodes];
		
		visited[0] = 1;
		stack.push(0);
		path.add(0);
		// System.out.print(0 + "\t");
		
		int currentNode, nextNode = 0;
		boolean minFlag = false;
		
		while (!stack.isEmpty()) {
			currentNode = stack.peek();
			int min = DIST_TO_SELF; // All distance values should be negative
			
			for (int i = 0; i < numNodes; i++) {
				int dist = adjMatrix[currentNode][i];
				
				if (dist < DIST_TO_SELF && visited[i] == 0) {		
					if (dist < min) {
						min = dist;
						nextNode = i;
						minFlag = true;
					}
				}
			}
			
			if (minFlag) {
				// System.out.print(nextNode + "\t");
				visited[nextNode] = 1;
				stack.push(nextNode);
				path.add(nextNode);
				minFlag = false;
				continue;
			}
			stack.pop();
		}
		
		return path;
	}
}
