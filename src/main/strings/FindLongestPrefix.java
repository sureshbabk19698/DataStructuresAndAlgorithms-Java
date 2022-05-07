package ProblemSolving;

public class FindLongestPrefix {
	public String longestCommonPrefix(String[] strs) {
		// handled rare case
		if (strs.length == 1) {
			return strs[0];
		}

		String result = "";
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < strs.length; i++) {
			String curr = strs[i];
			if (i == 1) {
				// 1st iteration flower and flow
				String prev = strs[i - 1];
				sb = getCommonPrefix(prev, sb, curr);
			} else {
				// rest
				if (result.length() > 0) {
					sb = getCommonPrefix(result, sb, curr);
				} else {
					return "";
				}
			}
			result = sb.toString();
			sb = new StringBuilder();
		}
		return result;
	}

	private StringBuilder getCommonPrefix(String prev, StringBuilder sb, String curr) {
		for (int j = 0; j < prev.length() && j < curr.length(); j++) {
			if (prev.charAt(j) == curr.charAt(j)) {
				sb.append(curr.charAt(j));
			} else {
				break; // break prefix pattern
			}
		}
		return sb;
	}

	public static void main(String[] args) {
		FindLongestPrefix flp = new FindLongestPrefix();
		System.out.println(flp.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		System.out.println(flp.longestCommonPrefix(new String[] { "dog", "racecar", "car" }));

	}
}
