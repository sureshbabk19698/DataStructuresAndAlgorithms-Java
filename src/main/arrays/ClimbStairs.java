package easy;

public class ClimbStairs {

	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int[] steps = new int[n + 1];
		steps[1] = 1;
		steps[2] = 2;
		for (int i = 3; i <= n; i++) {
			steps[i] = steps[i - 1] + steps[i - 2];
		}

		return steps[n];
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
