package arrays;

public class MaxArea {

	public int maxArea(int[] height) {
		int maxArea = 0;
		int tempMax = 0;

		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			if (height[left] < height[right]) {
         // left block is minimum, hence multiplying the area(difference btw left and right block) with the minimum block height
				tempMax = ((right - left) * height[left]);
				if (tempMax > maxArea) {
					maxArea = tempMax;
				}
				left++;
			} else {
         // right block is minimum, hence multiplying the area(difference btw left and right block) with the minimum block height
				tempMax = ((right - left) * height[right]);
				if (tempMax > maxArea) {
					maxArea = tempMax;
				}
				right--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		MaxArea mx = new MaxArea();
		System.out.println(mx.maxArea(new int[] { 3, 9, 3, 4, 7, 2, 12, 6 })); // 45
		System.out.println(mx.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 })); // 49
		System.out.println(mx.maxArea(new int[] { 1, 1 })); // 1
	}
}
