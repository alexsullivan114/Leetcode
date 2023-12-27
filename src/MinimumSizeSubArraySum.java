public class MinimumSizeSubArraySum {
	public static void test() {
		int result = new MinimumSizeSubArraySum().minSubArrayLen(7, new int[]{1,1,1,1,7});
		System.out.println("Result: " + result);
	}
	public int minSubArrayLen(int target, int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) {
			if (nums[0] >= target) {
				return 1;
			} else {
				return 0;
			}
		}
		int lowIndex = 0;
		int highIndex = 0;
		int bestLength = 0;
		int runningTotal = nums[0];
		while (highIndex <= nums.length -1 && lowIndex <= nums.length - 1) {
			if (runningTotal >= target) {
				if (bestLength > 0) {
					bestLength = Math.min(bestLength, (highIndex - lowIndex) + 1);
				} else {
					bestLength = (highIndex - lowIndex) + 1;
				}
				if (lowIndex == highIndex) {
					highIndex++;
					if (highIndex <= nums.length - 1) {
						runningTotal += nums[highIndex];
					}
				} else {
					runningTotal -= nums[lowIndex];
					lowIndex++;
				}
			} else {
				highIndex++;
				if (highIndex <= nums.length - 1) {
					runningTotal += nums[highIndex];
				}
			}
		}

		return bestLength;
	}
}
