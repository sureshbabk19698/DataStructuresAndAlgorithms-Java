package strings;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
//		Input: s = "PAYPALISHIRING", numRows = 4
//				Output: "PINALSIGYAHRPI"
//				Explanation:
//				P     I    N
//				A   L S  I G
//				Y A   H R
//				P     I

		StringBuilder result = new StringBuilder(s.length());
		int diff = (numRows * 2) - 2;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < s.length(); j = (j + diff)) {
				result.append(s.charAt(j + i));
				if (i != 0 && i != numRows - 1 && j + diff - i < s.length()) {
					result.append(s.charAt(j + diff - i));
				}
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion zzc = new ZigZagConversion();
		System.out.println(zzc.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
		System.out.println(zzc.convert("AB", 1).equals("AB"));
	}
}
