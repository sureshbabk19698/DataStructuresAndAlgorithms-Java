public class MoveZeroes {
	public static void moveZeroes(int[] nums) {
		int k = 0;

		// Move values to front
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[k] = nums[i];
				k++;
			}
		}

		// Rest of the arrays are marked as zero
		for (int i = k; i < nums.length; i++) {
			nums[i] = 0;
		}

		for (int num : nums) {
			System.out.print(num + ",");
		}
	}

	public static void shiftArray(int[] nums, int index) {
		for (int i = index; i < nums.length - 1; i++) {
			nums[i] = nums[i + 1];
		}
		nums[nums.length - 1] = 0;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 0, 1 };
		moveZeroes(nums);
//		nums = new int[] { 0 };
//		moveZeroes(nums);

	}
}
