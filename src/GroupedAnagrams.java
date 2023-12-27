import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupedAnagrams {
    public static void test() {
        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat"};
        new GroupedAnagrams().groupAnagrams(array);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String word : strs) {
            int[] chars = new int[26];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                chars[c - 'a'] = chars[c - 'a'] + 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                int repeated = chars[i];
                String segment = ("" + (char)('a' + i)).repeat(repeated);
                sb.append(segment);
            }
            List<String> mapValues;
            String key = sb.toString();
            if (anagramMap.containsKey(key)) {
                mapValues = anagramMap.get(key);
            } else {
                mapValues = new ArrayList<>();
            }
            mapValues.add(word);
            anagramMap.put(key, mapValues);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
