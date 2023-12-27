import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void test() {
        new HappyNumber().isHappy(19);
    }

    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> seen = new HashSet<>();
        while (true) {
            String s = String.valueOf(n);
            int total = 0;
            for (int i = 0; i < s.length(); i++) {
                String c = String.valueOf(s.charAt(i));
                int cVal = Integer.parseInt(c);
                total += (cVal * cVal);
            }
            if (total == 1) {
                return true;
            } else if (seen.contains(total)) {
                return false;
            } else {
                n = total;
                seen.add(total);
            }
        }
    }
}
