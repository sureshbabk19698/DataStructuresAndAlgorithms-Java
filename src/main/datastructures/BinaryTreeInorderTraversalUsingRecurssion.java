package datastructures;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversalUsingRecurssion {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		inorderTraversal(root, result);
		return result;
	}

	public void inorderTraversal(TreeNode temp, List<Integer> result) {
		if (temp == null) {
			return;
		}
		inorderTraversal(temp.left, result);
		result.add(temp.val);
		inorderTraversal(temp.right, result);
	}

	public static void main(String[] args) {
		TreeNode p = new TreeNode(2, new TreeNode(1), new TreeNode(3, null, new TreeNode(4)));
		TreeNode q = new TreeNode(4, new TreeNode(1), new TreeNode(5, new TreeNode(3), new TreeNode(6)));

		BinaryTreeInorderTraversalUsingRecurssion st = new BinaryTreeInorderTraversalUsingRecurssion();
		System.out.println(st.inorderTraversal(p));
		System.out.println(st.inorderTraversal(q));
	}
}
