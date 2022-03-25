package AdjacencyMatrix;

import java.util.Arrays;

public class mainProg {

	public static void main(String[] args) {
		AdjMatrix graph01 = new AdjMatrix(6);

		graph01.AddEdge(1, 2);
		graph01.AddEdge(1, 3);
		graph01.AddEdge(2, 5);
		graph01.AddEdge(3, 4);
		graph01.AddEdge(3, 5);
		graph01.AddEdge(3, 6);

		graph01.PrintGraph();

		int[] dfsResult = graph01.DFS();
		System.out.println("DFS = " + Arrays.toString(dfsResult));
	}
}
