import java.util.HashMap;
import java.util.Map;

public class Knapsack {

	static Map<String, Integer> memo = new HashMap<>();

	public static void main(String[] args) {
		int[] values = { 10, 40, 30, 50 };
		int[] weights = { 10, 10, 10, 10 };
		int capacity = 20;

		// Call the knapsack function and print the result
		int maxValue = knapsack(weights, values, capacity, 0, 0, 0);
		maxValue = knapsackOptimized(weights, values, capacity);
		System.out.println("Max Value: " + maxValue); // Expected: 90
	}

	private static int knapsackOptimized(int[] weights, int[] values, int capacity) {
		int[][] intArr = new int[weights.length + 1][capacity + 1];

		for (int i = 1; i <= weights.length; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (weights[i - 1] <= j) {
					intArr[i][j] = Math.max(intArr[i - 1][j], intArr[i - 1][j - weights[i - 1]] + values[i - 1]);
				}
			}
		}
		return intArr[weights.length][capacity];
	}

	public static int knapsack(int[] weights, int[] values, int capacity, int index, int sum, int totalWeight) {
		// Base case: If total weight exceeds capacity, return 0
		if (totalWeight > capacity)
			return 0;

		// Base case: If we have considered all items, return the sum of values
		if (index == weights.length)
			return sum;

		// Create a unique key for memoization using the index and totalWeight
		String key = index + "-" + totalWeight;

		// Check if the result is already computed and cached
		if (memo.containsKey(key)) {
			return memo.get(key);
		}

		// Option 1: Skip the current item
		int left = knapsack(weights, values, capacity, index + 1, sum, totalWeight);

		// Option 2: Take the current item (if it fits)
		int right = 0;
		if (totalWeight + weights[index] <= capacity) {
			right = knapsack(weights, values, capacity, index + 1, sum + values[index], totalWeight + weights[index]);
		}

		// Take the maximum of the two options (either taking or skipping the item)
		int result = Math.max(left, right);

		// Store the result in the memo table (max of both options)
		if (memo.containsKey(key) && memo.get(key) < result) {
			memo.put(key, result);
		}

		return result;
	}

	protected static void LCS() {
		String str = "abcbdab";
		var charArray = str.toCharArray();
		int len = 1;
		int max = 0;

		for (int i = 1; i < charArray.length; i++) {
			if (charArray[i - 1] > charArray[i]) {
				len++;
			} else {
				max = Math.max(max, len);
				len = 1;
			}
		}
		max = Math.max(max, len);

		System.out.println("result : " + max);
	}

}
