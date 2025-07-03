import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class GraphNew {

	Map<Integer, List<Integer>> graph = new HashMap<>();

	public void addVertices(Integer source) {
		graph.put(source, new ArrayList<>());
	}

	public void addEdge(Integer source, Integer destination) {
		graph.get(source).add(destination);
		graph.putIfAbsent(destination, new ArrayList<>()).add(source);
	}

	public void displayAll() {
		for (var entry : graph.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

	public void BFS(Integer source) {
		int size = graph.size();
		boolean[] visited = new boolean[size];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(source);
		visited[source -1] = true;

		while (!queue.isEmpty()) {
			Integer visitVertices = queue.poll();		
			System.out.println("visited vertices : " + visitVertices);

			for (var vertice : graph.get(visitVertices)) {
				if (!visited[vertice - 1]) {
					queue.offer(vertice);
					visited[vertice -1] = true;
				}
			}
		}
	}
	
	public void DFS(Integer source) {
		int size = graph.size();
		boolean[] visited = new boolean[size];
		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		visited[source -1] = true;

		while (!stack.isEmpty()) {
			Integer visitVertices = stack.pop();		
			System.out.println("visited vertices : " + visitVertices);

			for (var vertice : graph.get(visitVertices)) {
				if (!visited[vertice - 1]) {
					stack.push(vertice);
					visited[vertice -1] = true;
				}
			}
		}
	}
	
	public void DFS() {
		for (var entry : graph.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		var graph = new GraphNew();

		graph.addVertices(1);
		graph.addVertices(2);
		graph.addVertices(3);
		graph.addVertices(4);

		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 1);
		graph.addEdge(1, 4);

		graph.displayAll();
		
		graph.BFS(1);
		
		graph.DFS(1);
	}

}
