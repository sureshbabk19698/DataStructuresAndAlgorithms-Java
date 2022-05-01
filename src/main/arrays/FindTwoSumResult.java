package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTwoSumResult {
	public static int[] twoSum(int[] nums, int target) {
		// same element not repeat
		// two elements index

		// element order can be any way

		// sort to iterate one way
		Map<Integer, List<Integer>> map = new HashMap<>(nums.length, 1f);
		int res[] = new int[2];
		int i = 0;
		for (i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], new ArrayList<>());
			}
			map.get(nums[i]).add(i);
		}

		for (i = 0; i < nums.length; i++) {
			int balance = target - nums[i];
			if (map.containsKey(balance)) {
				res[0] = i;
				int firstIndex = map.get(balance).get(0);
				if (map.get(balance).size() == 1 && firstIndex != i) {
					// not same index as i
					res[1] = map.get(balance).get(0);
					break;
				} else if (map.get(balance).size() > 1) {
					// same value different index
					res[1] = map.get(balance).get(1);
					break;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 3 }, 6)));
	}
}
