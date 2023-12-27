public class RotateArray {
	public static void test() {
		new RotateArray().rotate(new int[]{1,2,3,4,5,6}, 4);
	}

	public void rotate(int[] nums, int k) {
		// if nums.length % k != 0 does our algorithm just work? And in that case can we just increment our pointer?
		if (k == 0) return;
		int updatingPosition = k % nums.length;
		int previousValue = nums[0];
		int numHops = 0;
		int offset = 0;
		while  (numHops < nums.length) {
			int value = nums[updatingPosition];
			int newPosition = (updatingPosition + k) % nums.length;
			nums[updatingPosition] = previousValue;
			updatingPosition = newPosition;
			previousValue = value;
			if (nums.length % k == 0 && numHops > 0 && updatingPosition == offset + k) {
				offset++;
				updatingPosition = offset + k % nums.length;
				previousValue = nums[offset];
			}
			numHops++;
		}
		System.out.println("Done");
	}
}
