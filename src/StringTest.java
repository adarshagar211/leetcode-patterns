import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 1, 3, 2 };
		int k = 3;
		System.out.println(maxSumSubarray(arr, k));

		String s1 = "aabc";
		String s2 = "ahabgdc";
		System.out.println(isSubsequence(s1, s2));

		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
		int k1 = 3;
		rotate(arr1, k1);
		System.out.println(Arrays.toString(rotate(arr1, k1)));
	}

	private static int[] rotate(int[] arr1, int k1) {
		int[] arr3 = new int[arr1.length];
	    int n = arr1.length;
		for (int k = 0; k < n; k++) {
			arr3[(k + k1) % n] = arr1[k];  
		}
		return arr3;
	}

	private static boolean isSubsequence(String s1, String s2) {
		int i = 0, j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j))
				i++;
			j++;
		}

		return i == s1.length();
	}

	private static int maxSumSubarray(int[] arr, int k) {
		int sum = 0, maxSum = 0, i = 0;
		for (; i < k; i++) {
			sum += arr[i];
		}
		maxSum = sum;
		for (i = k; i < arr.length; i++) {
			sum += arr[i] - arr[i - k];
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

}
