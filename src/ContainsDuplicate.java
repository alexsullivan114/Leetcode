import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicate {
    public static void test() {
        int[] array = new int[]{1,0,1,1};
        new ContainsDuplicate().containsNearbyDuplicate(array, 1);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> list = new ArrayList<>();
            if (map.containsKey(num)) {
                list = map.get(num);
            }
            list.add(i);
            map.put(num, list);
        }
        for (List<Integer> list : map.values()) {
            if (list.size() < 2) continue;
            if (Math.abs(list.get(0) - list.get(list.size() - 1)) <= k) {
                return true;
            }
        }
        return false;
    }
}
