package datastructures;

public class AddTwoNodesValue {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode nextL1 = l1;
		ListNode nextL2 = l2;

		int sum = 0;
		int rem = 0;
		ListNode result = new ListNode();
		ListNode next = result;
		ListNode last = result;

		while (nextL1 != null || nextL2 != null) {
			next.next = new ListNode();

			sum = 0;
			if (nextL1 != null) {
				sum += nextL1.val;
				nextL1 = nextL1.next;
			}

			if (nextL2 != null) {
				sum += nextL2.val;
				nextL2 = nextL2.next;
			}

			sum = rem != 0 ? rem + sum : sum;
			if (sum > 9) { // handling double digit sum value 
        // since input will always between 0 to 9 , rem will always be one, (Example: at max 9 + 9 = 18)  8 is added to current Node.val 
        // and rem is carry forward to next iteration
				sum = sum % 10; 
				rem = 1; 
			} else {
				rem = 0;
			}
			next.val = sum;
			last = next;
			next = next.next;
		}

    // if rem is present, then set next value , else remove last unused node from result
		if (rem != 0) {
			next.val = rem;
		} else {
			last.next = null;
		}
		return result;
	}

	public static void main(String[] args) {
		AddTwoNodesValue add = new AddTwoNodesValue();
		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		// 421 + 431 = 852
		printResult(add.addTwoNumbers(list1, list2)); // [2,5,8]

		list1 = new ListNode(9,
				new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
		list2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
		printResult(add.addTwoNumbers(list1, list2)); // [8,9,9,9,0,0,0,1]
	}

	private static void printResult(ListNode addTwoNumbers) {
		while (addTwoNumbers != null) {
			System.out.print(addTwoNumbers.val + ", ");
			addTwoNumbers = addTwoNumbers.next;
		}
		System.out.println();
	}
}
