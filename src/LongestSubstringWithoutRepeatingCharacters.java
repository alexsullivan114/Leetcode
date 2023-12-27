import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void test() {
		int result = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew");
	}
	public int lengthOfLongestSubstring(String s) {
		if (s.isEmpty()) return 0;
		Set<Character> windowSet = new HashSet<>();
		int lowIndex = 0;
		int highIndex = 0;
		int maxSubstringLength = 0;
		while (lowIndex <= s.length() - 1 && highIndex <= s.length() - 1) {
			char highCharacter = s.charAt(highIndex);
			if (windowSet.contains(highCharacter)) {
				windowSet.remove(s.charAt(lowIndex));
				lowIndex++;
			} else {
				windowSet.add(highCharacter);
				maxSubstringLength = Math.max(maxSubstringLength, (highIndex - lowIndex) + 1);
				highIndex++;
			}
		}

		return maxSubstringLength;
	}
}
