package easy;

public class ClimbStairs {

	public int climbStairs(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		int current = 0;
		int prev2 = 2;
		int prev1 = 1;
		for (int i = 3; i <= n; i++) {
			current = prev2 + prev1;
			prev1 = prev2;
			prev2 = current;
		}

		return current;
	}

	public static void main(String[] args) {
		// Fibonacci
		// Based on the previous step , output is determined
		ClimbStairs cs = new ClimbStairs();
		// 1 step + 1 step
		// 2 step
		System.out.println(cs.climbStairs(2)); // 2
		// 1 step + 1 step + 1 step
		// 2 step + 1 step
		// 1 step + 2 step
		System.out.println(cs.climbStairs(3)); // 3
		// 1 step + 1 step + 1 step + 1 step
		// 1 step + 1 step + 2 step
		// 1 step + 2 step + 1 step
		// 2 step + 1 step + 1 step
		// 2 step + 2 step
		System.out.println(cs.climbStairs(4)); // 5
	}
}
