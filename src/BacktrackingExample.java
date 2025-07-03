import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;;

public class BacktrackingExample {

	static List<String> results = new ArrayList<>();

	public static void permutation(int[] nums, int start) {

		if (start == nums.length - 1) {
			results.add(Arrays.toString(nums));
			return;
		}
		
		for (int i = start; i < nums.length; i++) {
			System.out.println("before state :  i " + i  + "  start " +  start + " " +Arrays.toString(nums));
			swap(nums, start, i);
			permutation(nums, start + 1);
			swap(nums, start, i);
		}
	}

	private static void swap(int[] nums, int start, int i) {
		int temp = nums[start];
		nums[start] = nums[i];
		nums[i] = temp;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		permutation(nums, 0);
		results.stream().forEach(System.out::println);
	}

}
