package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagaram {

	public static void main(String[] args) {
		GroupAnagaram ga = new GroupAnagaram();
		// Output : [["bat"],["nat","tan"],["ate","eat","tea"]]
		System.out.println(ga.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
	}

	public List<List<String>> groupAnagrams(String[] input) {
		HashMap<String, List<String>> groupMap = new HashMap<>();
		char freq[];
		for (int i = 0; i < input.length; i++) {
			freq = new char[26];
			for (int j = 0; j < input[i].length(); j++) {
				freq[input[i].charAt(j) - 'a']++;
			}

			String key = new String(freq);
			if (!groupMap.containsKey(key)) {
				groupMap.put(key, new ArrayList<>());
			}
			groupMap.get(key).add(input[i]);

		}
		return new ArrayList<>(groupMap.values());
	}

}
