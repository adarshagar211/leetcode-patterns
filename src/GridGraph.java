import java.util.*;

public class GridGraph {

    static class Vertex {
        int row, col;
        char value;

        Vertex(int row, int col, char value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Vertex vertex = (Vertex) obj;
            return row == vertex.row && col == vertex.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    // Construct the graph representation of the grid (same as before)
    public static Map<Vertex, List<Vertex>> constructGraph(char[][] grid) {
        Map<Vertex, List<Vertex>> graph = new HashMap<>();
        int rows = grid.length;
        int cols = grid[0].length;

        // Create vertices and add edges (right and down)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Vertex current = new Vertex(i, j, grid[i][j]);
                graph.putIfAbsent(current, new ArrayList<>());

                // Add right edge if possible
                if (j + 1 < cols) {
                    Vertex right = new Vertex(i, j + 1, grid[i][j + 1]);
                    graph.get(current).add(right);
                }

                // Add down edge if possible
                if (i + 1 < rows) {
                    Vertex down = new Vertex(i + 1, j, grid[i + 1][j]);
                    graph.get(current).add(down);
                }
            }
        }
        return graph;
    }

    // Search for the word in the graph using DFS with backtracking
    public static boolean patternMatch(Map<Vertex, List<Vertex>> graph, char[] word, Vertex start, int index, Set<Vertex> visited) {
        // Base case: If we have matched the whole word
        if (index == word.length) {
            return true;
        }

        // If the current vertex doesn't match the word or it's visited already, return false
        if (start.value != word[index] || visited.contains(start)) {
            return false;
        }

        // Mark the current vertex as visited
        visited.add(start);

        // Explore the neighbors (right and down)
        for (Vertex neighbor : graph.get(start)) {
            if (patternMatch(graph, word, neighbor, index + 1, visited)) {
                return true;
            }
        }

        // Backtrack: unmark the current vertex as visited
        visited.remove(start);

        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
            { 'A', 'B', 'C', 'D' },
            { 'E', 'F', 'G', 'H' },
            { 'I', 'J', 'K', 'L' },
            { 'M', 'N', 'O', 'P' }
        };

        char[] word = { 'B', 'G', 'P' };  // Word to search

        // Construct the graph from the grid
        Map<Vertex, List<Vertex>> graph = constructGraph(grid);

        // Start searching for the word from any vertex that matches the first character
        for (Vertex v : graph.keySet()) {
            if (v.value == word[0]) {  // If the current vertex matches the first character
                Set<Vertex> visited = new HashSet<>();
                if (patternMatch(graph, word, v, 0, visited)) {
                    System.out.println("Word found!");
                    return;
                }
            }
        }

        System.out.println("Word not found.");
    }
}
