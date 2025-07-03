import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {

		if (k == 0 || nums.length < 1)
			return List.of();

		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
				(a, b) -> b.getValue().compareTo(a.getValue()));

		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			queue.offer(entry);
		}
		return queue.stream().map(x -> x.getKey()).limit(2).toList(); // placeholder
	}

	// --- Test cases ---
	public static void main(String[] args) {
		TopKFrequentElements solver = new TopKFrequentElements();

		// Test case 1
		int[] nums1 = { 1, 1, 1, 2, 2, 3 };
		int k1 = 2;
		System.out.println("Expected: [1,2], Got: " + solver.topKFrequent(nums1, k1));

		// Test case 2
		int[] nums2 = { 1 };
		int k2 = 1;
		System.out.println("Expected: [1], Got: " + solver.topKFrequent(nums2, k2));

		// Test case 3 (empty array)
		int[] nums3 = {};
		int k3 = 0;
		System.out.println("Expected: [], Got: " + solver.topKFrequent(nums3, k3));
	}
}
