public class QueryOfCount {

	static int num = 0;

	public static void main(String[] args) {
		int[] stairs = { 0, 0, 1, 0, 0, 1, 0 };
		jump(stairs, 0);
	}

	private static void jump(int[] stairs, int index) {

		int n = stairs.length;

		// dp[i] will store the number of ways to reach stair i
		int[] dp = new int[n];

		// Base case: If the first stair is not blocked, we can start there
		dp[0] = (stairs[0] == 0) ? 1 : 0; // Only start if stair 0 is not blocked

		// Fill the dp array
		for (int i = 1; i < n; i++) {
			// Only proceed if the current stair is not blocked
			if (stairs[i] == 0) {
				// Check if we can jump 1 step back (to i-1)
				if (i - 1 >= 0 && stairs[i - 1] == 0) {
					dp[i] += dp[i - 1]; // Add the ways to reach the previous stair
				}

				// Check if we can jump 2 steps forward (to i+2)
				if (i + 2 < n && stairs[i + 2] == 0) {
					dp[i] += dp[i + 2]; // Add the ways to reach the step 2 ahead
				}
			}
		}

		// The last stair will contain the total number of ways to reach the last step
		System.out.println(dp[n - 1]);

	}
}
