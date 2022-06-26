package arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PhoneNumCombinations {

	String charMap[] = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		LinkedList<String> result = new LinkedList<>();
		if (digits.isEmpty()) {
			return result;
		}
		result.add("");
		for (int i = 0; i < digits.length(); i++) {
			int index = Character.getNumericValue(digits.charAt(i));
			while (result.peek().length() == i) {
				String intial = result.remove();
				for (char c : charMap[index].toCharArray()) {
					result.add(intial + c);
				}
			}
		}

		return result;
	}

	public void dfs(String digits, StringBuilder sb, int idx, List<String> result) {
		if (sb.length() == digits.length()) {
			result.add(sb.toString());
			return;
		}

		String s = charMap[Character.getNumericValue(digits.charAt(idx))];

		for (char c : s.toCharArray()) {

			sb.append(c);
			dfs(digits, sb, idx + 1, result);
			sb.deleteCharAt(sb.length() - 1);
		}

	}

	public static void main(String[] args) {
		PhoneNumCombinations pc = new PhoneNumCombinations();
		// using linked list
		System.out.println(pc.letterCombinations("23"));
		System.out.println(pc.letterCombinations("256"));

		// using recursive
		List<String> result = new ArrayList<>();
		pc.dfs("23", new StringBuilder(), 0, result);
		System.out.println(result);

		result = new ArrayList<>();
		pc.dfs("256", new StringBuilder(), 0, result);
		System.out.println(result);
	}

}
