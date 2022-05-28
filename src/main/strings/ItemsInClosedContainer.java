package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class ItemsInClosedContainer {
	
	/**
	 * Find items '*' inside closed container '|', between given start and end
	 * indices. 
	 * 
	 * Eg 1: start index = 1 and end index = 4 , String s = "|**|"
	 * then 2 items present between 1 and 4
	 * 
	 * Eg 2: start index = 1 and end index = 5 , String s = "|**|*"
	 * then 2 items present between 1 and 5, 
	 * reason : last item '*' is not considered, since its not closed by '|'
	 * 
	 * Note : Items denoted as '*' and open/close container denoted as '|'
	 * Constraint : Atleast one open/close '|' container will be present
	 */

	public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
		List<Integer> result = new ArrayList<>();
		int itemsCount = 0;
		TreeMap<Integer, Integer> cntMap = new TreeMap<>();
		for (int i = 0; i < s.length(); i++) { // 5 , 6
			if (s.charAt(i) == '|') {
				cntMap.put(i, itemsCount);
			} else {
				itemsCount++;
			}
		}

		int left = 0;
		int right = 0;
		for (int i = 0; i < startIndices.size(); i++) { // 5 , 6
			int start = startIndices.get(i) - 1;
			int end = endIndices.get(i) - 1;
			if (cntMap.containsKey(start)) {
				left = cntMap.get(start);
			} else {
				if (cntMap.floorKey(start) != null) {
					left = cntMap.get(cntMap.floorKey(start));
				} else {
					left = cntMap.get(cntMap.ceilingKey(start));
				}
			}
			if (cntMap.containsKey(end)) {
				right = cntMap.get(end);
			} else {
				if (cntMap.floorKey(end) != null) {
					right = cntMap.get(cntMap.floorKey(end));
				}
			}
			if (right != left) {
				result.add(right - left);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> numberOfItems = numberOfItems("|**|*|", Arrays.asList(1, 1), Arrays.asList(5, 6));
		numberOfItems.stream().forEach(System.out::print);
		System.out.println();
		numberOfItems = numberOfItems("*|**|*|", Arrays.asList(1, 1), Arrays.asList(5, 6));
		numberOfItems.stream().forEach(System.out::print);
	}
}
