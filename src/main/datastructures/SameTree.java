package datastructures;

public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		TreeNode a = p;
		TreeNode b = q;

		if ((a != null && b == null) || (a == null && b != null)) {
			return false;
		}

		while (a != null && b != null) {
			// System.out.println("Printing A and B : " + a.val + " " + b.val);
			if (a.val != b.val) {
				return false;
			}
			if (!isSameTree(a.left, b.left)) {
				return false;
			}
			if (!isSameTree(a.right, b.right)) {
				return false;
			}
			break;
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode p = new TreeNode(2, new TreeNode(1), new TreeNode(3, null, new TreeNode(4)));
		TreeNode q = new TreeNode(2, new TreeNode(1), new TreeNode(3, null, new TreeNode(4)));

		SameTree st = new SameTree();
		System.out.println(st.isSameTree(p, q));
	}
}
