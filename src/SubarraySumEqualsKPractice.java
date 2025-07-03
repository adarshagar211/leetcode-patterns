import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsKPractice {

	// TODO: Implement this method yourself
	public static int subarraySum(int[] nums, int k) {
		// Your implementation here
		int sum = 0;
		int count = 0;
		Map<Integer, Integer> sumSet = new HashMap<>();
		sumSet.put(0, 1);
		for (int num : nums) {
			sum = sum + num;
			if (sumSet.containsKey(sum - k)) {
				count += sumSet.get(sum - k);
			}
			sumSet.put(sum, sumSet.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] testInputs = { { 1, 1, 1 }, { 1, 2, 3 }, { 1, -1, 0 }, { 3, 4, 7, 2, -3, 1, 4, 2 }, { 1, 2, 1, 2, 1 } };

		int[] ks = { 2, 3, 0, 7, 3 };

		int[] expectedOutputs = { 2, 2, 3, 4, 4 };

		for (int i = 0; i < testInputs.length; i++) {
			try {
				int result = subarraySum(testInputs[i], ks[i]);
				System.out.printf("Test %d: Expected = %d, Got = %d -> %s%n", i + 1, expectedOutputs[i], result,
						(result == expectedOutputs[i]) ? "PASS" : "FAIL");
			} catch (UnsupportedOperationException e) {
				System.out.println("Test " + (i + 1) + ": Method not implemented yet.");
			}
		}
	}
}
