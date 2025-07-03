import java.util.Arrays;

public class JumpGame2 {

	/**
	 * Determines if you can reach the last index.
	 * 
	 * @param nums Array where each element represents max jump length.
	 * @return true if you can reach the last index, false otherwise.
	 */
	public static int jump(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= nums[i] && i + j < n; j++) {
				dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
			}
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[][] testInputs = { { 2, 3, 1, 1, 4 }, // true // false
				{ 0 }, // true (already at last index)
				{ 2, 0 }, // true
		};

		int[] expected = { 2, 0, 1 };

		for (int i = 0; i < testInputs.length; i++) {
			try {
				int result = jump(testInputs[i]);
				System.out.printf("Test %d: Expected = %b, Got = %b → %s%n", i + 1, expected[i], result,
						(result == expected[i] ? "PASS" : "FAIL"));
			} catch (UnsupportedOperationException e) {
				System.out.printf("Test %d: Method not implemented yet.%n", i + 1);
			}
		}
	}
}
