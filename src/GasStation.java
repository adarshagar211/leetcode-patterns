
public class GasStation {

	/**
	 * Returns the starting gas station index from which you can travel around the
	 * circuit once. If not possible, returns -1.
	 *
	 * @param gas  the amount of gas at each station
	 * @param cost the cost to travel to the next station
	 * @return the starting index or -1
	 */
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int[] diffArray = new int[gas.length];
		int maxIndex = 0;
		int sum = 0;
		for (int i = 0; i < cost.length; i++) {
			diffArray[i] = gas[i] - cost[i];
			sum += diffArray[i];
		}
		if (sum < 0)
			return -1;
		sum = 0;
		for (int i = 0; i < gas.length; i++) {
			sum += diffArray[i];
			if (sum < 0) {
				maxIndex = i + 1;
				sum = 0;
			}
		}
		return maxIndex;
	}

	// Example test cases
	public static void main(String[] args) {
		System.out.println(canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 })); // Expected: 3

		System.out.println(canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3 })); // Expected: -1

		System.out.println(canCompleteCircuit(new int[] { 5, 1, 2, 3, 4 }, new int[] { 4, 4, 1, 5, 1 })); // Expected: 4
	}
}
