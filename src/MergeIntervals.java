import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public static void test() {
		int[][] intervals = {{1, 4}, {2, 3}};
		new MergeIntervals().merge(intervals);
	}
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (t1, t2) -> {
			if (t1[0] - t2[0] != 0) {
				return t1[0] - t2[0];
			} else {
				return t1[1] - t2[1];
			}
		});

		if (intervals.length == 0) return new int[][]{};
		List<int[]> returnList = new ArrayList<>();
		int start = intervals[0][0];
		int endCandidate = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			int[] interval = intervals[i];
			if (interval[0] > endCandidate) {
				returnList.add(new int[]{start, endCandidate});
				start = interval[0];
			}
			if (interval[1] >= endCandidate) {
				endCandidate = interval[1];
			}
		}
		returnList.add(new int[]{start, endCandidate});
		int[][] returnArray = new int[returnList.size()][2];
		for (int i = 0; i < returnList.size(); i++) {
			returnArray[i] = returnList.get(i);
		}
		return returnArray;
	}
}
