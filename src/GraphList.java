import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphList {

	int numOfVertices;
	List<Integer>[] vertices;

	public GraphList(int numOfVertices) {
		this.numOfVertices = numOfVertices;
		vertices = new ArrayList[numOfVertices];
		for (int i = 0; i < numOfVertices; i++) {
			vertices[i] = new ArrayList<>(); // Initialize each adjacency list
		}
	}

	public void DFS(int startVertex) {
		boolean[] visited = new boolean[numOfVertices];
		System.out.println("\nDFS Traversal:");
		dfsRecursive(startVertex, visited);
		System.out.println();
	}

	private void dfsRecursive(int startVertex, boolean[] visited) {
		System.out.println("Visisted vertex:" + startVertex);
		visited[startVertex] = true;

		for (var vertice : vertices[startVertex]) {
			if (!visited[vertice]) {
				dfsRecursive(vertice, visited);
			}
		}
	}

	private void BFS(int startVertex) {
		boolean[] visited = new boolean[numOfVertices];
		System.out.println("BFS Traversal:");

		var queue = new LinkedList<Integer>();
		queue.add(startVertex);
		visited[startVertex] = true;

		while (!queue.isEmpty()) {

			var vertex = queue.poll();
			System.out.println("Visisted vertex:" + vertex);

			for (var vertice : vertices[vertex]) {
				if (!visited[vertice]) {
					visited[vertice] = true;
					queue.add(vertice);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GraphList g = new GraphList(5);
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);

		g.DFS(0);
		g.BFS(0);

	}

	private void addEdge(int i, int j) {
		vertices[i].add(j);
		vertices[j].add(i);
	}

}
