package Week1;

import java.util.Collections;
import java.util.List;

public class TwoArrayResult {

	public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
		String res = "YES";

		Collections.sort(A, Collections.reverseOrder());
		Collections.sort(B);

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) + B.get(i) < k) {
				res = "NO";
			}
		}
		return res;
	}

}
