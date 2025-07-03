public class CoinChange {

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[] coins = { 1, 2, 3, 5, 7 }; // coin denominations
		int amount = 11; // target amount

		coinChange(coins, 0, 0, 0, amount);
		System.out.println("Minimum coins needed: " + min);
	}

	// Function to be implemented
	public static void coinChange(int[] coins, int index, int coin, int current, int amount) {
		if (amount == current) {
			min = Math.min(min, coin);
			return;
		}
		if (index < coins.length && current < amount) {
			coinChange(coins, index, coin + 1, current + coins[index], amount);
			coinChange(coins, index + 1, coin + 1, current + coins[index], amount);
			coinChange(coins, index + 1, coin, current, amount);
		}
	}
}
