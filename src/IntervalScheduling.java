
import java.util.*;

import java.util.*;

public class IntervalScheduling {

	/**
	 * Returns the maximum number of non-overlapping intervals.
	 *
	 * @param intervals 2D array of [start, end] intervals
	 * @return maximum count of non-overlapping intervals
	 */
	public static int maxNonOverlappingIntervals(int[][] intervals) {
		// TODO: Greedy approach: sort by end time
		Queue<Pair> queue =  new PriorityQueue<>(Comparator.comparing(Pair::getSecond)); 
		for (int i = 0; i < intervals.length; i++) {
			queue.add(new Pair(intervals[i][0], intervals[i][1]));
		}
		 
	 	int count = 0;
		int lastEnd = Integer.MIN_VALUE;

		while (!queue.isEmpty()) {
		    Pair curr = queue.poll();
		    if (curr.first >= lastEnd) {
		        count++;
		        lastEnd = curr.second;
		    }
		}
		return count;
	}

	public static void main(String[] args) {
		int[][][] testInputs = { { { 1, 3 }, { 2, 4 }, { 3, 5 } }, // 2
				{ { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }, // 3
				{ { 1, 10 }, { 2, 3 }, { 4, 5 } }, // 2
				{ { 1, 2 } }, // 1
				{} // 0
		};

		int[] expected = { 2, 3, 2, 1, 0 };

		for (int i = 0; i < testInputs.length; i++) {
			try {
				int result = maxNonOverlappingIntervals(testInputs[i]);
				System.out.printf("Test %d: Expected = %d, Got = %d → %s%n", i + 1, expected[i], result,
						(result == expected[i] ? "PASS" : "FAIL"));
			} catch (UnsupportedOperationException e) {
				System.out.printf("Test %d: Method not implemented yet.%n", i + 1);
			}
		}
	}

	static class Pair {
		int first;
		int second;

		public Pair(int i, int j) {
			this.first = i;
			this.second = j;
		}

		public int getFirst() {
			return first;
		}

		public int getSecond() {
			return second;
		}
	}
}
