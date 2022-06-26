package arrays;

public class FindMissingPositive {
	public int firstMissingPositive(int[] nums) {

		int posIndexSize = 0;
		// shifting non-negative and non-zero values to front of the array
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				nums[posIndexSize] = nums[i];
				posIndexSize++;
			}
		}

		// marking visited index as negative
		for (int i = 0; i < posIndexSize; i++) {
			int x = Math.abs(nums[i]); // to convert visited index values to positive, nums[i] = -4 , then x = 4
			if (x - 1 < posIndexSize && nums[x - 1] > 0) // if nums[i] value is less than positive index length, and
															// if the nums[i] is not visited yet
				nums[x - 1] = -nums[x - 1]; // mark index as visited by making the nums[i] value as negative
		}

		// if i=0, nums[i] is marked as negative(visited), then the nums[] array has value one
		// if i=0, nums[i] is positive, then nums[] array doesnot have value one in it ,
		// hence return the smallest positive integer
		for (int i = 0; i < posIndexSize; i++) {
			if (nums[i] > 0)
				return i + 1;
		}

		return posIndexSize + 1;
	}

	public static void main(String[] args) {
		FindMissingPositive fmp = new FindMissingPositive();
		System.out.println(fmp.firstMissingPositive(new int[] { 3, 4, -1, 1 }));
		System.out.println(fmp.firstMissingPositive(new int[] { 1, 2, 3, 4 }));
		System.out.println(fmp.firstMissingPositive(new int[] { 0, 1, 2 }));
	}

}
