package strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public static int romanToInt(String s) {
		Map<Character, Integer> romanKeyToIntegerValue = new HashMap<>();
		romanKeyToIntegerValue.put('I', 1);
		romanKeyToIntegerValue.put('V', 5);
		romanKeyToIntegerValue.put('X', 10);
		romanKeyToIntegerValue.put('L', 50);
		romanKeyToIntegerValue.put('C', 100);
		romanKeyToIntegerValue.put('D', 500);
		romanKeyToIntegerValue.put('M', 1000);

		int sum = 0;
		int prev = 0;
		for (int i = 0; i < s.length(); i++) {
			int cur = romanKeyToIntegerValue.get(s.charAt(i));
			if (i != 0 && prev < cur) {
				sum += (cur - prev) - prev;
			} else {
				sum += cur;
			}
			prev = cur;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}
}
