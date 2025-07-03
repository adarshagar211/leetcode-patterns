import java.util.LinkedList;

public class SlidingWindowMax {

	public static int[] maxSlidingWindow(int[] nums, int k) {

		if (nums == null || k < 0)
			return new int[0];

		int[] result = new int[nums.length - k + 1];
		LinkedList<Integer> deque = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {

			while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
				deque.pollFirst();
			}

			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			deque.offerLast(i);
			
			if(i >= k-1) {
				result[i-k+1] = nums[deque.peekFirst()];
			}

		}

		return result; // placeholder
	}

	public static void main(String[] args) {
		// Test Case 1
		int[] nums1 = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k1 = 3;
		printResult(maxSlidingWindow(nums1, k1)); // Expected: [3, 3, 5, 5, 6, 7]

		// Test Case 2
		int[] nums2 = { 9, 11 };
		int k2 = 2;
		printResult(maxSlidingWindow(nums2, k2)); // Expected: [11]

		// Test Case 3
		int[] nums3 = { 4, 2, 12, 3, 8 };
		int k3 = 1;
		printResult(maxSlidingWindow(nums3, k3)); // Expected: [4, 2, 12, 3, 8]

		// Test Case 4
		int[] nums4 = { 1 };
		int k4 = 1;
		printResult(maxSlidingWindow(nums4, k4)); // Expected: [1]
	}

	private static void printResult(int[] result) {
		System.out.print("Output: [");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
			if (i < result.length - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}
}
