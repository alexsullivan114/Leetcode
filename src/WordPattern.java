import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void test() {
        new WordPattern().wordPattern("abba", "dog cat cat dog");
    }
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(c)) {
                String mappedWord = map.get(c);
                if (!word.equals(mappedWord)) {
                    return false;
                }
            }
            if (reverseMap.containsKey(word)) {
                Character reverseChar = reverseMap.get(word);
                if (reverseChar != c) {
                    return false;
                }
            }
            map.put(c, word);
            reverseMap.put(word, c);
        }

        return true;
    }
}
