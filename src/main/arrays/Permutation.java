package arrays;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		printAllRecursive(nums.length, nums, result);
		return result;
	}

	public void printAllRecursive(int n, int[] elements, List<List<Integer>> result) {

		if (n == 1) {
			printArray(elements, result);
		} else {
			for (int i = 0; i < n - 1; i++) {
				printAllRecursive(n - 1, elements, result);
				if (n % 2 == 0) {
					swap(elements, i, n - 1); // odd position, even index
				} else {
					swap(elements, 0, n - 1);
				}
			}
			printAllRecursive(n - 1, elements, result);
		}
	}

	private void swap(int[] input, int a, int b) {
		int tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}

	private void printArray(int[] input, List<List<Integer>> result) {
		List<Integer> combination = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			combination.add(input[i]);
		}
		result.add(combination);
	}

	public static void main(String[] args) {
		Permutation per = new Permutation();
		int[] arr = { 1, 2, 3 };
		per.permute(arr).stream().forEach(System.out::println);

//		Set<String> strResult = new HashSet<>();
//		String strArr[] = { "fooo", "barr", "wing", "ding", "wing" };
//		per.printAllRecursive(strArr.length, strArr, strResult);
//		strResult.stream().forEach(System.out::println);
	}

}
