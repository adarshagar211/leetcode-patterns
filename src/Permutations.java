import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

	public static void backtrack(int[] nums, List<Integer> current, Set<List<Integer>> result, boolean[] used) {
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

	public static Set<List<Integer>> permute(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		boolean[] used = new boolean[nums.length];
		backtrack(nums, new ArrayList<>(), result, used);
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 3 };
		Set<List<Integer>> result = permute(nums);
		System.out.println("Generated Permutations:");
		for (List<Integer> perm : result) {
			System.out.println(perm);
		}
	}
}
