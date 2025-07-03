import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class GridGraphN {

	Map<Integer, List<Integer>> graph = new HashMap<>();

	public void addVertex(Integer vertex) {
		graph.putIfAbsent(vertex, new ArrayList<>());
	}

	public void addEdge(Integer source, Integer destination) {
		graph.putIfAbsent(source, new ArrayList<>());
		graph.putIfAbsent(destination, new ArrayList<>());
		graph.get(source).add(destination);
		graph.get(destination).add(source);
	}

	public void showAll() {
		System.out.println("graph : " + graph);
	}

	public void dfs(int vertex, boolean[] visited) {
		System.out.println("vertex  visited : " + vertex);
		visited[vertex - 1] = true;
		for (var next : graph.get(vertex))
			if (!visited[next - 1])
				dfs(next, visited);
	}

	public void BFS(int vertex, boolean[] visited) {
		Queue<Integer> queue = new PriorityQueue<>();
		queue.offer(vertex);
		visited[vertex - 1] = true;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println("vertex  visited : " + current);
			
			for (var next : graph.get(current)) {
				if (!visited[next - 1]) {
					visited[next - 1] = true;
					queue.offer(next);
				}
			}
		}
	}

	public static void main(String[] args) {

		GridGraphN graph = new GridGraphN();
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);

		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(1, 3);
		graph.addEdge(4, 2);

		graph.showAll();
		int size = graph.graph.keySet().size();

		boolean[] visited = new boolean[size];
		graph.dfs(1, visited);
		
		visited = new boolean[size];
		graph.BFS(1, visited);

	}
}
