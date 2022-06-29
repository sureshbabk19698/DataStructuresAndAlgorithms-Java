package arrays;

import java.util.LinkedList;

public class LongValidParentheses {
	private final static char OPEN_PARANTHESES = '(';
	private final static char CLOSE_PARANTHESES = ')';
	private final static char VISITED = 'V';

	public int longestValidParentheses(String s) {
		int length = 0;
		int tempMaxLength = 0;

		LinkedList<Character> chars = new LinkedList<>();
		char charArray[] = s.toCharArray();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == CLOSE_PARANTHESES) {
				if (!chars.isEmpty() && chars.peek() == OPEN_PARANTHESES) {
					charArray[i] = VISITED; // marked close brace index as Visited
					markOpenBraceIndexAsVisited(charArray, i - 1);
					chars.pop();
				}
			} else {
				chars.push(OPEN_PARANTHESES);
			}
		}

		for (char d : charArray) {
			if (d == VISITED) {
				tempMaxLength++;
			} else {
				length = Math.max(length, tempMaxLength);
				tempMaxLength = 0;
			}
		}
		length = Math.max(length, tempMaxLength);
		return length;
	}

	public void markOpenBraceIndexAsVisited(char[] c, int index) {
		for (int i = index; i >= 0; i--) {
			if (c[i] != VISITED) {
				c[i] = VISITED;
				break;
			}
		}
	}

	public static void main(String[] args) {
		LongValidParentheses lvp = new LongValidParentheses();
		System.out.println(lvp.longestValidParentheses("()")); // 2
		System.out.println(lvp.longestValidParentheses("(()")); // 2
		System.out.println(lvp.longestValidParentheses("(()()")); // 4
		System.out.println(lvp.longestValidParentheses(")()())")); // 4
		System.out.println(lvp.longestValidParentheses("()(()")); // 2
		System.out.println(lvp.longestValidParentheses("()(())")); // 6

	}
}
