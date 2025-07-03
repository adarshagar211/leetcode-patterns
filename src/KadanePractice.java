
public class KadanePractice {

	// TODO: Implement this method yourself
	public static int maxSubArray(int[] nums) {
		int sum = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (sum + nums[i] > nums[i]) 
				sum = sum + nums[i];
			 else 
				sum = nums[i];
			max = Math.max(max, sum);
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] testInputs = { { 1, 2, 3, 4, 5 }, 
				               { -2, 1, -3, 4, -1, 2, 1, -5, 4 }, 
				               { -1, -2, -3, -4 }, 
				               { 5, -1, 5 },
				               { 0, 0, 0, 0 } };

		int[] expectedOutputs = { 15, 6, -1, 9, 0 };

		for (int i = 0; i < testInputs.length; i++) {
			try {
				int result = maxSubArray(testInputs[i]);
				System.out.printf("Test %d: Expected = %d, Got = %d -> %s%n", i + 1, expectedOutputs[i], result,
						(result == expectedOutputs[i]) ? "PASS" : "FAIL");
			} catch (UnsupportedOperationException e) {
				System.out.println("Test " + (i + 1) + ": Method not implemented yet.");
			}
		}
	}
}
