import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SlidingWindow {

	static Map<String, Integer> memo = new HashMap<>();

	public static void main(String[] args) {
		var strArray = "asbdbdbadaad".toCharArray();
		var patternArray = "bdba".toCharArray();
        int left= -1 ; 

		int strArrayIndex = 0, patternIndex = 0;
		while (strArrayIndex < strArray.length) {
			if (strArray[strArrayIndex] == patternArray[patternIndex]) {
				left = patternIndex ; 
				if (patternIndex == patternArray.length) {
					System.out.println(true);
					return;
				}
			} else {
				while (patternIndex > 0) {
					patternIndex--;
				}
			}

			strArrayIndex++;
		}
		System.out.println(false);
	}
}
