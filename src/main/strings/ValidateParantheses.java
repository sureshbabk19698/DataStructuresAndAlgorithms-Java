package strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidateParantheses {
	static Map<Character, Character> paranthesesMap = new HashMap<>();
	static {
		paranthesesMap.put('{', '}');
		paranthesesMap.put('[', ']');
		paranthesesMap.put('(', ')');
	}

	public boolean checkValidParenthsis(String paranthesis) {

		LinkedList<Character> stack = new LinkedList<>();
		for (int i = 0; i < paranthesis.length(); i++) {
			if (paranthesesMap.containsKey(paranthesis.charAt(i))) {
				stack.push(paranthesis.charAt(i));
			} else {
				if (stack.isEmpty() || paranthesis.charAt(i) != paranthesesMap.get(stack.peek())) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidateParantheses vp = new ValidateParantheses();
		System.out.println(vp.checkValidParenthsis("{{}}"));
		System.out.println(vp.checkValidParenthsis("{"));
		System.out.println(vp.checkValidParenthsis("[()]"));
		System.out.println(vp.checkValidParenthsis("[{]{"));
	}
}
