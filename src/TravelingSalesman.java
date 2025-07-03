
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import org.apache.commons.compress.utils.Sets;

public class TravelingSalesman {

	// Graph is represented by a HashMap
	private Map<String, Map<String, Integer>> graph = new HashMap<>();

	// Method to add a city and the distances to other cities
	public void addCity(String city, Map<String, Integer> distances) {
		graph.put(city, distances);
	}

	// Method to display the graph
	public void showGraph() {
		for (String city : graph.keySet()) {
			System.out.println("City: " + city + " -> Distances: " + graph.get(city));
		}
	}

	public static void main(String[] args) {
		// Create an instance of TravelingSalesman
		TravelingSalesman tsp = new TravelingSalesman();

		// Add cities and their distances to other cities
		Map<String, Integer> cityADistances = new HashMap<>();
		cityADistances.put("B", 10);
		cityADistances.put("C", 15);
		//cityADistances.put("D", 20);

		Map<String, Integer> cityBDistances = new HashMap<>();
		cityBDistances.put("A", 10);
		cityBDistances.put("C", 35);
		cityBDistances.put("D", 25);

		Map<String, Integer> cityCDistances = new HashMap<>();
		cityCDistances.put("A", 15);
		cityCDistances.put("B", 35);
		cityCDistances.put("D", 10);

		Map<String, Integer> cityDDistances = new HashMap<>();
		cityDDistances.put("A", 20);
		cityDDistances.put("B", 25);
		cityDDistances.put("C", 30);

		// Adding cities and their distances to the graph
		tsp.addCity("A", cityADistances);
		tsp.addCity("B", cityBDistances);
		tsp.addCity("C", cityCDistances);
		tsp.addCity("D", cityDDistances);

		// Display the graph (cities and distances)
		tsp.showGraph();

		int distance = tsp.minDistance("A");
		System.out.println("distance:" + distance);

		distance = tsp.minDijkstra("A", "D");
		System.out.println("distance:" + distance);
	}

	private int minDistance(String startCity) {
		Set<String> visitedCities = Sets.newHashSet();

		int totalCost = 0;
		String currentCity = startCity;
		visitedCities.add(currentCity);

		while (visitedCities.size() != graph.size()) {

			int minDistance = Integer.MAX_VALUE;
			String nearestCity = null;

			for (var entry : graph.get(currentCity).entrySet()) {
				var neighbourCity = entry.getKey();
				var distance = entry.getValue();

				if (!visitedCities.contains(neighbourCity) && distance < minDistance) {
					nearestCity = neighbourCity;
					minDistance = distance;
				}
			}
			if (nearestCity != null) {
				totalCost += minDistance;
				visitedCities.add(nearestCity);
				currentCity = nearestCity;
			}
		}

		totalCost += graph.get(currentCity).get(startCity);
		// TODO Auto-generated method stub
		return totalCost;
	}

	private int minDijkstra(String startCity, String destinationCity) {

		HashMap<String, Integer> distances = new HashMap<>();
		PriorityQueue<String> pq = new PriorityQueue(Comparator.comparing(distances::get));

		for (var cities : graph.keySet())
			distances.put(cities, Integer.MAX_VALUE);

		distances.put(startCity, 0);
		pq.offer(startCity);
	 
		while (!pq.isEmpty()) {

			String currentCity = pq.poll();

			for (var entry : graph.get(currentCity).entrySet()) {

				String neighbour = entry.getKey();
				int distance = entry.getValue();
				int edgeWeight = distance + distances.get(currentCity);

				if (edgeWeight < distances.get(neighbour)) {
					distances.put(neighbour, edgeWeight);
					pq.offer(neighbour);
				}
			}
		}
		System.out.println("distances" + distances);
		return distances.get(destinationCity);
	}

}
