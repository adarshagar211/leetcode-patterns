import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class SlidingWindow2 {

	static Map<String, Integer> memo = new HashMap<>();

	public static void main(String[] args) {
		var strArray = "abcabcbb".toCharArray();
        var set = new LinkedHashSet<Character>();
		int max = 0 ;
		for(char ch : strArray) {
			if(!set.contains(ch)) {
				set.add(ch);
				max = Math.max(set.size(), max);
			}else {
				while(set.size() != 0 && (set.removeFirst()) != ch);
				set.addLast(ch);
			}		
		}
		System.out.println(max);
	}
}
