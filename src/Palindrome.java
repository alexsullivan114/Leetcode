public class Palindrome {
	public static void test() {
		new Palindrome().isPalindrome("A man, a plan, a canal: Panama");
	}

	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int beginningPointer = 0;
		int endingPointer = s.length() - 1;
		while (beginningPointer < endingPointer) {
			if (!Character.isLetterOrDigit(s.charAt(beginningPointer))) {
				beginningPointer++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(endingPointer))) {
				endingPointer--;
				continue;
			}
			if (s.charAt(beginningPointer) != s.charAt(endingPointer)) {
				return false;
			}
			beginningPointer++;
			endingPointer--;
		}

		return true;
	}
}
