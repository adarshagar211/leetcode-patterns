import java.util.Arrays;

public class CoinChangeDP {

	public static void main(String[] args) {
		int[] coins = { 1, 2,  5, }; // coin denominations
		int amount = 5; // target amount

		int[] dp = new int[amount + 1];
		dp[0] = 1;
		
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] += dp[i - coin] ;
			}
		}
		System.out.println("Minimum coins needed: " + dp[amount]);
	}
}
