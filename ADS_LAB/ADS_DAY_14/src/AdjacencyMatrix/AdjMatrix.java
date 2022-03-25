package AdjacencyMatrix;

import java.util.Arrays;

// For unweighted and undirected graph.
public class AdjMatrix {
	int[][] adjMat;
	int vertexCount;

	public AdjMatrix(int vertexCount) {
		this.vertexCount = vertexCount;

		adjMat = new int[vertexCount][];
		for (int i = 0; i < vertexCount; ++i) {
			adjMat[i] = new int[vertexCount];

			for (int j = 0; j < vertexCount; ++j) {
				adjMat[i][j] = 0;
			}
		}
	}

	public void AddEdge(int vi, int vj) {
		adjMat[vi - 1][vj - 1] = 1;
		adjMat[vj - 1][vi - 1] = 1; // Because its undirected graph.
	}

	private int DFSHelper(int startVertex, boolean[] isVisited, int[] result, int resultCount) {
		// Terminating condition - if startVertex is visited then Stop
		if (isVisited[startVertex] == true) {
			return resultCount;
		}

		System.out.println("Processing " + (startVertex + 1));
		// Mark startVertex as visited.
		isVisited[startVertex] = true;
		// Process startVertex.
		result[resultCount] = startVertex + 1;
		++resultCount;
		System.out.println(Arrays.toString(result));

		// For every adjacent vertex, vj, to startVertex that is not visited.
		for (int vj = 0; vj < vertexCount; ++vj) {
			if ((adjMat[startVertex][vj] != 0) && (!isVisited[vj])) {
				System.out.println("For startVerted - " + (startVertex + 1) + "vj is " + (vj + 1));
				resultCount = DFSHelper(vj, isVisited, result, resultCount);
			}
		}
		return resultCount;
	}

	public int[] DFS() {
		int[] result = new int[vertexCount];

		// Create isVisisted array of size vertexCount
		boolean[] isVisited = new boolean[vertexCount];
		// Set all elements in isVisited to FALSE
		for (int i = 0; i <  vertexCount; ++i) {
			isVisited[i] = false;
		}

		DFSHelper(0, isVisited, result, 0);

		return result;
	}

	public void PrintGraph() {
		// Print header
		System.out.print("\t");
		for (int i = 0; i < vertexCount; ++i) {
			System.out.print((i + 1) + " ");
		}
		System.out.println("");

		for (int i = 0; i < vertexCount; ++i) {
			System.out.print((i + 1) + " - \t");
			for (int j = 0; j < vertexCount; ++j) {
				System.out.print(adjMat[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
