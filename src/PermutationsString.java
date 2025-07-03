import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsString {

	public static void backtrack(char[] nums, List<Character> current, Set<List<Character>> result, boolean[] used) {
		if (current.size() == nums.length) {
			result.add(new ArrayList<>(current));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i])
				continue; // Skip if already used

			used[i] = true;
			current.add(nums[i]);
			backtrack(nums, current, result, used);
			current.remove(current.size() - 1);
			used[i] = false;
		}
	}

	public static Set<List<Character>> permute(char[] nums) {
		Set<List<Character>> result = new HashSet<>();
		boolean[] used = new boolean[nums.length];
		backtrack(nums, new ArrayList<>(), result, used);
		return result;
	}

	public static void main(String[] args) {
		char[] nums = "god".toCharArray();
		Set<List<Character>> result = permute(nums);
		System.out.println("Generated Permutations:");
		for (List<Character> perm : result) {
			System.out.println(perm);
		}
	}
}
