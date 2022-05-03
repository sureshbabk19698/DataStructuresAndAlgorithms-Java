package strings;

public class SwapString {
	public static boolean areAlmostEqual(String s1, String s2) {
		 //s1 = "ysmpagrkzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhqkxumonfgrczmjvbhwvhpnocz";
		 //s2 = "ysmpagrqzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhkkxumonfgrczmjvbhwvhpnocz";
		if (s1.equals(s2)) {
			return true;
		}

		int count = 0;
		int replaceIndex1 = -1;
		int replaceIndex2 = -1;
		char missedChar1 = ' ';
		char missedChar2 = ' ';
		for (int i = 0; i < s1.length(); i++) {
			char ch1 = s1.charAt(i); // Swap Char in s2
			char ch2 = s2.charAt(i);
			if (ch1 != ch2) {
				if (replaceIndex1 == -1) {
					replaceIndex1 = i;
					missedChar1 = ch2;
				} else {
					replaceIndex2 = i;
					missedChar2 = ch2;
				}
				count++;
				if (count > 2) {
					return false;
				}
			}
		}

		if (replaceIndex1 == -1 || replaceIndex2 == -1) {
			return false;
		}

		return (s1.charAt(replaceIndex2) == missedChar1) && s1.charAt(replaceIndex1) == missedChar2;
	}

	public static void main(String[] args) {
		System.out.println(areAlmostEqual("abcd", "dcba"));
	}

}
