import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void test() {
//		var response = new ThreeSum().threeSum(new int[]{0, 0, 0, 0, 0});
		var response = new ThreeSum().threeSum(new int[]{-4, -1, -1, -1, 0, 1, 2});
		System.out.println("Response: " + response);
	}


	// I don't know how to represent the items that should be skipped
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> returnList = new ArrayList<>();
		if (nums.length < 3) return returnList;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			int num = nums[i];
			boolean skip = false;
			if (i > 0) {
				skip = nums[i - 1] == num;
			}
			if (skip) continue;
			List<List<Integer>> twoSums = twoSum(nums, num * -1, i);
			if (!twoSums.isEmpty()) {
				returnList.addAll(twoSums);
			}
		}

		return returnList;
	}

	private List<List<Integer>> twoSum(int[] nums, int target, int indexToAvoid) {
		List<List<Integer>> returnList = new ArrayList<>();
		int highPointer = nums.length - 1;
		int lowPointer = indexToAvoid + 1;
		while (highPointer > lowPointer) {
			int high = nums[highPointer];
			int low = nums[lowPointer];
			if (highPointer < nums.length - 1 && nums[highPointer + 1] == high) {
				highPointer--;
				continue;
			}
			if (lowPointer > indexToAvoid + 1 && nums[lowPointer - 1] == low) {
				lowPointer++;
				continue;
			}
			if (high + low == target) {
				var list = new ArrayList<Integer>();
				list.add(high);
				list.add(low);
				list.add(target * -1);
				returnList.add(list);
				highPointer--;
			} else if (high + low > target) {
				highPointer--;
			} else if (high + low < target) {
				lowPointer++;
			}
		}

		return returnList;
	}
}
