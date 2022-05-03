package ProgrammingSkills4;

import java.util.Arrays;

public class ArithmeticProgession {

	public static boolean canMakeArithmeticProgression(int[] arr) {
		Arrays.sort(arr);

		int diff = 0;
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i] - arr[i - 1];
			if (i == 1) {
				diff = temp;
			} else if (temp != diff) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(canMakeArithmeticProgression(new int[] { 1, 2, 3, 4, 5 }));
	}
}
