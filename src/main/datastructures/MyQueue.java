package datastructures;

public class MyQueue {

	private Node head;
	private Node tail;
	private int size;

	public MyQueue() {

	}

	public void push(int x) {
		Node node = new Node();
		node.setVal(x);
		if (tail != null) {
			node.setPrevious(tail);
			tail.setNext(node);
			if (head == null) {
				head = node;
			}
		} else {
			head = node; // 1st Element Stored
		}
		tail = node;
		size++;
	}

	public int pop() {
		Node t = head;
		head = head.getNext();
		size--;
		t.setNext(null);
		return t.getVal();
	}

	public int peek() {
		int res = 0;
		if (head != null) {
			res = head.getVal();
		}
		return res;
	}

	public boolean empty() {
		return size <= 0;
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		System.out.println(queue.pop());

		queue.push(2);
		System.out.println(queue.peek());

		System.out.println(queue.empty());

	}

}

class Node {

	private int val;
	private Node previous;
	private Node next;

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
