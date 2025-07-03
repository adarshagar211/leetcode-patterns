public class JumpGame {

	static Integer min = Integer.MAX_VALUE;

	public static void main(String[] args) {

		int[] word = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		jump(word, 0, 0);
		System.out.println(minJumps(word));

	}

	private static int jump(int[] word, int position, int jumps) {
		if (position == word.length - 1) {
			System.out.println("jumps" + jumps);
			min = Math.min(min, jumps);
			return jumps;
		} else if (position >= word.length)
			return word.length;

		else {
			if (word[position] != 0) {
				for (int i = word[position]; i >= 0; i--)
					if (jumps < min) {
						jump(word, position + i, jumps + 1);
					}
			}
		}
		return min;
	}

	public static int minJumps(int[] arr) {
		if (arr.length <= 1)
			return 0;
		if (arr[0] == 0)
			return -1;

		int maxReach = arr[0], steps = arr[0], jumps = 1;

		for (int i = 1; i < arr.length; i++) {
			if (i == arr.length - 1)
				return jumps;

			maxReach = Math.max(maxReach, i + arr[i]);
			steps--;

			if (steps == 0) {
				jumps++;
				if (i >= maxReach)
					return -1;
				steps = maxReach - i;
			}
		}
		return -1;
	}
}
