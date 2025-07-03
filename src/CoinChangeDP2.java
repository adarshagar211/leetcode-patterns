import java.util.Arrays;

public class CoinChangeDP2 {

	public static void main(String[] args) {
		int[] coins = { 1, 2, 3, 5, 7 }; // coin denominations
		int amount = 11; // target amount

		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		System.out.println("Array: " + Arrays.toString(dp));
		
		for (int coin : coins) {
			for (int i = amount; i >= coin; i--) {
				if (dp[i - coin] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
					System.out.println("Array: " + Arrays.toString(dp));
				}
			}
			//System.out.println("Array: " + Arrays.toString(dp));
		}
		System.out.println("Minimum coins needed: " + dp[amount]);
	}
}
