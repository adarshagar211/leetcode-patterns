import java.util.HashMap;
import java.util.Map;

public class PatternMatching {

	static Map<String, Integer> memo = new HashMap<>();

	public static void main(String[] args) {
		char[][] grid = { { 'A', 'B', 'C', 'D' }, { 'E', 'F', 'G', 'H' }, { 'I', 'J', 'K', 'L' },
				{ 'M', 'N', 'O', 'P' } };

		char[] word = { 'F', 'J', 'K', 'L' };

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == word[0]) {
					if (patternMatch(grid, word, i, j, 0)) {
						System.out.println(true);
						return;// Return starting coordinates
					}
				}
			}
		}
		System.out.println(false);
	}

	private static boolean patternMatch(char[][] grid, char[] word, int i, int j, int index) {
		if (index == word.length)
			return true;
		if (i == grid.length || j == grid[0].length || grid[i][j] != word[index])
			return false;
		boolean left = patternMatch(grid, word, i + 1, j, index + 1);
		boolean right = patternMatch(grid, word, i, j + 1, index + 1);
		return left || right;
	}
}
