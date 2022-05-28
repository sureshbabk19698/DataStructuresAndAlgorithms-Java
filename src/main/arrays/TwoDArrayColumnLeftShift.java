package arrays;

import java.util.Scanner;

public class TwoDArrayColumnLeftShift {

	public void shiftArray(int[][] arr, int noOfShifts) {
		int temp[] = new int[arr.length];

		if (noOfShifts == 0 || noOfShifts == arr.length) {
			print(arr);
			return;
		}

		int lastColumnIndex = arr[0].length - 1;
		// copy of last column
		for (int row = 0; row < arr.length; row++) {
			temp[row] = arr[row][lastColumnIndex];
		}
		for (int i = 1; i <= noOfShifts; i++) {
			for (int col = arr[i].length - 2; col >= 0; col--) {
				for (int row = 0; row < arr.length; row++) {
					int next = arr[row][col];
					arr[row][col] = temp[row]; // rigth shift
					temp[row] = next; // copy current data to temp
				}
			}

			// last iteration per shift
			for (int row = 0; row < arr.length; row++) {
				arr[row][lastColumnIndex] = temp[row];
			}
		}

		print(arr);
	}

	private void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] case1 = { { 1, 5, 9, 13 }, { 2, 6, 10, 14 }, { 3, 7, 11, 15 } };
		int[][] case2 = { { 1, 5, 9, 13 }, { 2, 6, 10, 14 }, { 3, 7, 11, 15 }, { 4, 8, 12, 16 } };
		Scanner sc = new Scanner(System.in);
		TwoDArrayColumnLeftShift shift = new TwoDArrayColumnLeftShift();
		// noOfShifts = 1
		// Input : case 1
		// Output :
		// 5	9	  13	1	
    // 6	10	14	2	
    // 7	11	15	3
		shift.shiftArray(case1, sc.nextInt());
		// noOfShifts = 2
		// Input : case 2
		// Output :
		// 9 13 1 5
		// 10 14 2 6
		// 11 15 3 7
		// 12 16 4 8
		shift.shiftArray(case2, sc.nextInt());
		sc.close();
	}

}
