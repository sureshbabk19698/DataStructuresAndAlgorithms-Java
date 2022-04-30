package arrays;

import java.util.Arrays;

/**
 * Merge Alternative values of array 1 and array 2 
 * Eg :- 
 * int a[] = { 1, 3, 5 }; 
 * int b[] = { 2, 4, 6};
 * result[] = {1, 2, 3, 4, 5, 6}; 
 * @author SureshBabu
 */
public class MergeAlternativeArray {

	public static void main(String[] args) {
		int a[] = { 1, 3, 5 };
		int b[] = { 2, 4, 6, 7, 8, 9 };

		int res[] = new int[a.length + b.length];
		int index = 0;
		for (int i = 0; i < (a.length < b.length ? b.length : a.length); i++) {
			if (i < a.length) {
				res[index++] = a[i];
			}
			if (i < b.length) {
				res[index++] = b[i];// 1
			}
		}

		System.out.println(Arrays.toString(res));
	}
}
