package strings;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongSubstringWithoutRepeatingCharacter {
	public static int lengthOfLongestSubstring(String s) {
		// iterate and store in map
		// check if already present if same char came , streak broken
		// reset Map take the count once streak is broken and return max

		Map<Character, Integer> uniqueCharIndexmap = new HashMap<>(256);

		int length = 0;

		int resetIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			if (uniqueCharIndexmap.containsKey(s.charAt(i))) {
				// set streak(without repeating characters) broken index
				resetIndex = Math.max(resetIndex, uniqueCharIndexmap.get(s.charAt(i)) + 1);
			}
			// difference between last streak index and current index
			length = Math.max(length, i - resetIndex + 1);
			uniqueCharIndexmap.put(s.charAt(i), i);
		}

		return length;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb")); // expected - 3
		System.out.println(lengthOfLongestSubstring("dvdf")); // 3
		System.out.println(lengthOfLongestSubstring(" ")); // 1
		System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
		System.out.println(lengthOfLongestSubstring("nfpdmpi")); // 5
		System.out.println(lengthOfLongestSubstring("abba")); // 2
		System.out.println(lengthOfLongestSubstring("vqblqcb")); // 4
		System.out.println(lengthOfLongestSubstring("vqbblqcb")); // 4
	}
}
