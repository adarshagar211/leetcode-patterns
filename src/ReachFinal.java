import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.math3.util.Pair;

public class ReachFinal {

	static Map<String, Integer> memo = new HashMap<>();

	public static void main(String[] args) {
		String s = "fool3e7bar";
		String strq = "leet";

		List<Pair<Character, Character>> mappings = List.of(new Pair('e', '3'), new Pair('t', '7'), new Pair('t', '8'));
		Set<String> substrs = new HashSet<>();

		Map<Character, List<Character>> map = mappings.stream()
				.collect(Collectors.groupingBy(Pair::getKey, Collectors.mapping(Pair::getSecond, Collectors.toList())));

			for (var entry : map.entrySet()) {
				char[] sub = strq.toCharArray();		
				for (int i = 0; i < strq.length(); i++) {
				if (entry.getKey() == sub[i]) {
					sub[i] = entry.getValue();
				}
			}
			substrs.add(new String(sub));
		}
		System.out.println(substrs);

		for (String str : substrs) {
			if (s.contains(str)) {
				System.out.println("true");
				return;
			}
		}
		System.out.println("false");
	}
}
