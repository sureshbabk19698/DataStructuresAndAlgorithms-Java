package arrays;

import java.util.Arrays;

public class FindMinMaxPositionOfSortedArray {
	public static int[] searchRange(int[] nums, int target) {

		int result[] = new int[2];
		result[0] = -1;
		result[1] = -1;

		boolean isMinIndexFound = false;
		boolean isMaxIndexFound = false;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) { // 5, 7, 7
				if (!isMinIndexFound) {
					result[0] = i;
					isMinIndexFound = true;
				} else {
					result[1] = i;
					isMaxIndexFound = true;
				}
			} else {
				if (isMinIndexFound) {
					break;
				}
			}
		}

		if (isMinIndexFound && isMaxIndexFound) {
			// if found both return
			return result;
		} else if (isMinIndexFound) {
			// if found only one element , then set min and max element index same
			result[1] = result[0];
		}
		// if no element found return -1 ,-1
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7 }, 7)));
		System.out.println(Arrays.toString(searchRange(new int[] { 6, 6 }, 6)));
		System.out.println(Arrays.toString(searchRange(new int[] { 1, 2, 3, 4, 5 }, 3))); // should return index 2 , 2

		System.out.println(Arrays.toString(searchRange(new int[] { 6, 6 }, 3))); // should return -1 , -1
	}
}
