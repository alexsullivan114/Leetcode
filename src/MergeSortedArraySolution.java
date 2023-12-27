import java.util.Arrays;

public class MergeSortedArraySolution {

	public static void test() {
		int[] array1 = new int[]{1, 2, 9, 12, 0};
		int[] array2 = new int[]{5};
		new MergeSortedArraySolution().merge3(array1, 4, array2, 1);
	}
	public void merge3(int[] nums1, int m, int[] nums2, int n) {
		if (n <= 0) {
			return;
		}
		if (m <= 0) {
			System.arraycopy(nums2, 0, nums1, 0, n);
			return;
		}

		int nums1pointer = m - 1;
		int nums2pointer = n - 1;
		int backwardsPointer = (m + n) - 1;
		while (backwardsPointer >= 0) {
			int num1 = Integer.MIN_VALUE;
			if (nums1pointer >= 0) {
				num1 = nums1[nums1pointer];
			}
			int num2 = Integer.MIN_VALUE;
			if (nums2pointer >= 0) {
				num2 = nums2[nums2pointer];
			}
			if (num1 > num2) {
				nums1[backwardsPointer] = num1;
				nums1pointer--;
			}
			else {
				nums1[backwardsPointer] = num2;
				nums2pointer--;
			}
			backwardsPointer--;
		}
	}
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		if (n <= 0) {
			return;
		}
		if (m <= 0) {
			System.arraycopy(nums2, 0, nums1, 0, n);
			return;
		}
		int[] storageArray = new int[m + n];
		int nums1pointer = 0;
		int nums2pointer = 0;
		int storagePopPointer = -1;
		int storagePushPointer = 0;

		while (nums1pointer < m + n) {
			int nums1int = Integer.MAX_VALUE;
			if (nums1pointer < m) {
				nums1int = nums1[nums1pointer];
			}
			int nums2int = Integer.MAX_VALUE;
			if (nums2pointer < n) {
				nums2int = nums2[nums2pointer];
			}
			int extraInt = Integer.MAX_VALUE;
			if (storagePopPointer != -1) {
				extraInt = storageArray[storagePopPointer];
			}

			if (nums1int < nums2int) {
				if (nums1int < extraInt) {
					nums1[nums1pointer] = nums1int;
				} else {
					nums1[nums1pointer] = extraInt;
					storageArray[storagePushPointer] = nums1int;
					storagePushPointer++;
					storagePopPointer++;
				}
			} else {
				if (nums2int < extraInt) {
					nums1[nums1pointer] = nums2int;
					nums2pointer++;
					storageArray[storagePushPointer] = nums1int;
					storagePushPointer++;
					if (storagePopPointer == -1) {
						storagePopPointer = 0;
					}
				} else {
					nums1[nums1pointer] = extraInt;
					storageArray[storagePushPointer] = nums1int;
					storagePushPointer++;
					storagePopPointer++;

				}
			}
			nums1pointer++;
		}
	}
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n <= 0) {
			return;
		}
		if (m <= 0) {
			System.arraycopy(nums2, 0, nums1, 0, n);
			return;
		}
		int nums1pointer = 0;
		int nums2pointer = 0;
		int extraPointer = -1;
		int nextEmptySpotPointer = m;

		while (nums1pointer < m + n) {
			int nums1int = Integer.MAX_VALUE;
			if (nums1pointer < m) {
				nums1int = nums1[nums1pointer];
			}
			int nums2int = Integer.MAX_VALUE;
			if (nums2pointer < n) {
				nums2int = nums2[nums2pointer];
			}
			int extraInt = Integer.MAX_VALUE;
			if (extraPointer != -1) {
				extraInt = nums1[extraPointer];
			}
			if (nums1int < nums2int) {
				if (nums1int < extraInt) {
					nums1[nums1pointer] = nums1int;
				} else {
					nums1[nums1pointer] = extraInt;
					nums1[extraPointer] = nums1int;
				}
			} else {
				if (nums2int < extraInt) {
					nums1[nums1pointer] = nums2int;
					nums2pointer++;
					nums1[nextEmptySpotPointer] = nums1int;
					if (extraPointer == -1) {
						extraPointer = nextEmptySpotPointer;
					}
					nextEmptySpotPointer++;
				} else {
					nums1[nums1pointer] = extraInt;
					if (nextEmptySpotPointer == extraPointer + 1) {
						extraPointer = -1;
					} else {
						extraPointer++;
					}
				}
			}
			nums1pointer++;
		}
	}
}
