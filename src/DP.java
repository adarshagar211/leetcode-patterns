import java.util.Arrays;

public class DP {

	public static void main(String[] args) {

		System.out.println(fib(1)); // Output: 1
		System.out.println(fib(2)); // Output: 1
		System.out.println(fib(3)); // Output: 2
		System.out.println(fib(5)); // Output: 5
		System.out.println(fib(7));

		int[] cost = { 2, 7, 9, 3, 1 };
		int[] coins = { 1, 2, 5 };
		int amount = 11;

		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };

		System.out.println(maxCost(cost)); // Output: 5
		System.out.println(maxCost(cost));

		// System.out.println(coinChange(coins, 11));

		System.out.println(lengthOfLIS(nums));

	}

	public static int fib(int num) {
		int n = num;
		int[] arr = new int[n];

		if (num < 2)
			return 1;
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i < n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n - 1];

	}

	public static int maxCost(int[] cost) {
		int n = cost.length;
		int[] arr = new int[n];
		arr[0] = 2;
		arr[1] = 7;

		for (int i = 2; i < n; i++) {
			arr[i] = Math.max(arr[i - 2] + cost[i], arr[i - 1]);
		}
		return arr[n - 1];

	}

	public static int coinChange(int[] coins, int amount) {

		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);

		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
				System.out.println("amount " + i + " dp" + Arrays.toString(dp));
			}
		}

		return dp[amount] == amount + 1 ? -1 : dp[amount]; // placeholder return
	}

	public static int lengthOfLIS(int[] nums) {
		
		System.out.println("nums" + Arrays.toString(nums));
		
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		dp[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
				System.out.println("amount " + i + " dp" + Arrays.toString(dp));
			}
		}

		return dp[nums.length - 1];
	}

}
