public class RemoveElementSolution {

	public static void test() {
		int response = new RemoveElementSolution().removeElement(new int[]{1}, 2);
		assert(response == 6);
	}
	public int removeElement(int[] nums, int val) {
		// Two pointers - 1 increments up looking for instances of "val", the other increments up as well, looking for
		// non val instances to replace the first one with.

		// What happens if the last field is an instance of val??

		if (nums.length == 0) {
			return 0;
		}

		boolean hasSeenVal = false;
		for (int num : nums) {
			if (num == val) {
				hasSeenVal = true;
				break;
			}
		}

		if (!hasSeenVal) {
			return 0;
		}

		int valPointer = 0;
		int otherPointer = valPointer;

		while (otherPointer < nums.length) {
			for (int i = valPointer; i < nums.length; i++) {
				int value = nums[i];
				if (value == val) {
					valPointer = i;
					otherPointer = valPointer;
					break;
				}
			}
			for (int i = otherPointer; i < nums.length; i++) {
				otherPointer = i;
				int value = nums[i];
				if (value != val) {
					nums[valPointer] = value;
					nums[i] = val;
					break;
				}
			}
			if (otherPointer == nums.length - 1) {
				break;
			}
		}

		int k = 0;
		for (int num : nums) {
			if (num != val) {
				k++;
			}
		}
		return k;
	}
}
