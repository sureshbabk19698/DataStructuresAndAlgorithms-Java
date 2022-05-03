package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestPalindromeOftheString {

	public static String longestPalindrome(String s) {
		// Input : babad 
		// 1. find streak breaak index
		// 2. if it is greater than previous palindrome string length, check for
		// palindrome
		// 3. replace the old palindrome string.
    
    // output can be any of these : bab or aba

		String result = "";
		Map<Character, List<Integer>> charIndexMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (!charIndexMap.containsKey(s.charAt(i))) {
				charIndexMap.put(s.charAt(i), new LinkedList<>());
			}
			charIndexMap.get(s.charAt(i)).add(i);
		}

		// handled rare cases, if all strings are same then return
		if (charIndexMap.size() == 1) {
			return s;
		}
    
     // if all characters are unique then return first string 
		if (charIndexMap.size() == s.length()) {
			 return s.charAt(0) + "";
		}

		Set<Character> processedChars = new HashSet<>();

		// babab
		for (int i = 0; i < s.length(); i++) {
			if (processedChars.contains(s.charAt(i))) {
				continue;
			}
			List<Integer> indexList = charIndexMap.get(s.charAt(i));
			if (indexList.size() >= 2) {
				int subStringLength = (indexList.get(indexList.size() - 1) - indexList.get(0)) + 1;
				if (result.length() < subStringLength) {
					for (int j = 0; j < indexList.size() - 1; j++) {
            // handled max Substrings length first 
						for (int k = indexList.size() - 1; k >= j; k--) {
							int currentSubStringLength = (indexList.get(k) - indexList.get(j)) + 1;
							if (result.length() < currentSubStringLength) {
								String temp = getPalindrome(s, indexList.get(j), indexList.get(k));
								if (!temp.equals("")) {
									result = temp;
								}
							} else {
								break;
							}
						}
					}
				}
			}
			processedChars.add(s.charAt(i));
		}

    return result;
	}

	public static String getPalindrome(String s, int startIndex, int endIndex) {

		boolean isPalindrome = true;
		int count = 0;
		for (int i = startIndex; i <= endIndex; i++) {
			if (s.charAt(i) != s.charAt(endIndex - count)) {
				isPalindrome = false;
				break;
			}
			count++;
		}
		if (isPalindrome) {
			return s.substring(startIndex, endIndex + 1);
		}
		return "";
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("ccc"));
		System.out.println(longestPalindrome("abc"));
		System.out.println(longestPalindrome(" "));
		System.out.println(longestPalindrome("aacabdkacaa"));
		System.out.println(longestPalindrome("babadada"));
		System.out.println(longestPalindrome(
				"civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
		System.out.println(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
}
