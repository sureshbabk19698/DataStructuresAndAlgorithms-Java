package datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortNodes {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode result = new ListNode();
		ListNode set1 = list1;
		ListNode set2 = list2;
		List<Integer> resultIntArray = new ArrayList<>(52);

		while (set1 != null || set2 != null) {
			if (set1 != null) {
				resultIntArray.add(set1.val);
				set1 = set1.next;
			}

			if (set2 != null) {
				resultIntArray.add(set2.val);
				set2 = set2.next;
			}
		}

		Collections.sort(resultIntArray);
		if (resultIntArray.isEmpty()) {
			return null;
		}
		ListNode temp = result;
		for (int i = 0; i < resultIntArray.size(); i++) {
			temp.val = resultIntArray.get(i);
      // To avoid creating node for last node, else the result ListNode will have zero at the end 
			if (i + 1 != resultIntArray.size()) {
				temp.next = new ListNode();
				temp = temp.next;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SortNodes sn = new SortNodes();

		// Example 1
		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		ListNode mergeTwoLists = sn.mergeTwoLists(list1, list2);
		printResult(mergeTwoLists);

		// Example 2
		list1 = null;
		list2 = null;
		mergeTwoLists = sn.mergeTwoLists(list1, list2);
		printResult(mergeTwoLists);

		// Example 3
		list1 = new ListNode(0);
		list2 = null;
		mergeTwoLists = sn.mergeTwoLists(list1, list2);
		printResult(mergeTwoLists);
	}

	private static void printResult(ListNode mergeTwoLists) {
		while (mergeTwoLists != null) {
			System.out.print(mergeTwoLists.val + ", ");
			mergeTwoLists = mergeTwoLists.next;
		}
		System.out.println();
	}
}
