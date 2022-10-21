import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

    }

    /*
     * 3. Longest Substring Without Repeating Characters
     * Goal: Find the longest substring without repeating characters
     *   - ex) input S = "abcabc", ans = "abc", ans.length = 3; therefore, returns 3
     *
     * Approach: Sliding Window
     */
    public static int lengthOfLongestSubstring(String s) {
        if ( s == null || s.length() == 0)
            return 0;

        int maxVal = Integer.MIN_VALUE;
        int i, j;
        boolean isSingle;
        i = j = 0;
        j += 1;
        Set<Character> characterSet = new HashSet<Character>();
        characterSet.add(s.charAt(i));

        while (j < s.length()) {
            isSingle = characterSet.add(s.charAt(j));

            if (isSingle) {
                j++;
            } else {
                maxVal = Math.max( maxVal, j-i );
                i++;
                j = i+1;
                characterSet.clear();
                characterSet.add(s.charAt(i));
            }
        }
        maxVal = Math.max( maxVal, j-i );
        return maxVal;
    }
}
