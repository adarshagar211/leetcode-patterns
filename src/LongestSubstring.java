import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

	// TODO: Implement this method
	public static int lengthOfLongestSubstring(String s) {

		Set<Character> set = new HashSet<>();
	    int left = 0, max = 0;

	    for (int right = 0; right < s.length(); right++) {
	        while (set.contains(s.charAt(right))) {
	            set.remove(s.charAt(left++));
	        }
	        set.add(s.charAt(right));
	        max = Math.max(max, right - left + 1);
	    }

	    return max;
	}

	public static void main(String[] args) {
		runTests();
	}

	private static void runTests() {
		System.out.println("Test 1: " + (lengthOfLongestSubstring("abcabcbb") ));
		System.out.println("Test 2: " + (lengthOfLongestSubstring("bbbbb")));
		System.out.println("Test 3: " + (lengthOfLongestSubstring("pwwkew")));
		System.out.println("Test 4: " + (lengthOfLongestSubstring("") == 0));
		System.out.println("Test 5: " + (lengthOfLongestSubstring(" ") == 1));
		System.out.println("Test 6: " + (lengthOfLongestSubstring("au") == 2));
		System.out.println("Test 7: " + (lengthOfLongestSubstring("dvdf") == 3));
	}
}
