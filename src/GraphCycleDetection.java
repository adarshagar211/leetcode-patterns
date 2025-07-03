import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class GraphCycleDetection {

	Map<Integer, List<Integer>> graph = new HashMap<>();

	public void addVertex(Integer node) {
		graph.putIfAbsent(node, new ArrayList<>());
	}

	public void addEdge(Integer source, Integer destination) {
		graph.putIfAbsent(source, new ArrayList<>());
		graph.putIfAbsent(destination, new ArrayList<>());
		graph.get(source).add(destination); // Directed edge
	}

	public void displayAll() {
		for (var entry : graph.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

	public int DFS() {

		int count = 0;
		Set<Integer> unVisitedNode = new HashSet<>(graph.keySet());

		while (!unVisitedNode.isEmpty()) {
			Stack<Integer> stack = new Stack<>();
			count++;
			Integer start = unVisitedNode.iterator().next();
			stack.push(start);
			unVisitedNode.remove(start);

			while (!stack.isEmpty()) {
				Integer visitVertices = stack.pop();
				System.out.println("visited vertices : " + visitVertices);

				for (var vertice : graph.get(visitVertices)) {
					if (unVisitedNode.contains(vertice)) {
						stack.push(vertice);
						unVisitedNode.remove(vertice);
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		var graph = new GraphCycleDetection();

		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 2);
		// graph.addEdge(4, 2);

		graph.displayAll();

		System.out.println("result : " + graph.DFS());
	}

}
