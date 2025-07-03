
public class JumpGameNew {

	/**
	 * Determines if you can reach the last index.
	 * 
	 * @param nums Array where each element represents max jump length.
	 * @return true if you can reach the last index, false otherwise.
	 */
	public static boolean canJump(int[] nums) {

		int maxReach = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > maxReach)
				return false;
			maxReach = Math.max(maxReach, i + nums[i]);
			if (maxReach > nums.length - 2) {
				return true;
			}
		}
		return true;
	}

	public static boolean canJumpNow(int[] nums, int index, Boolean[] memo) {
		if (index == nums.length - 1)
			return true;
		if (memo[index] != null)
			return memo[index];

		for (int i = 1; i <= nums[index]; i++) {
			if (canJumpNow(nums, index + i, memo)) {
				memo[index] = true;
				return true;
			}
		}

		memo[index] = false;
		return false;
	}

	public static void main(String[] args) {
		int[][] testInputs = { { 2, 3, 1, 1, 4 }, // true
				{ 3, 2, 1, 0, 4 }, // false
				{ 0 }, // true (already at last index)
				{ 2, 0 }, // true
				{ 1, 1, 0, 1 }, // false
		};

		boolean[] expected = { true, false, true, true, false };

		for (int i = 0; i < testInputs.length; i++) {
			try {
				boolean result = canJump(testInputs[i]);
				System.out.printf("Test %d: Expected = %b, Got = %b → %s%n", i + 1, expected[i], result,
						(result == expected[i] ? "PASS" : "FAIL"));
			} catch (UnsupportedOperationException e) {
				System.out.printf("Test %d: Method not implemented yet.%n", i + 1);
			}
		}
	}
}
