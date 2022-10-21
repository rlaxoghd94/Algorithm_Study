import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {


    /*
     * 438. Find All Anagrams in a String
     */
    public static void main(String[] args) {
//        String s = "cbaebabacd", p = "abc";
        String s = "baa", p = "aa";

        List<Integer> ans;

        ans = findAnagrams(s, p);

    }

    public static List<Integer> findAnagrams(String s, String p) {


        return null;
    }

//    /*
//     * Approach: Sliding Window (Brute-Force Algorithm)
//     * Time-Complexity: O(n^2)
//     *
//     * Status: Time Limit Exceeded - Better algorithm approach needed
//     *
//     */
//    public static List<Integer> findAnagrams(String s, String p) {
//        int idx = 0, sLen = s.length(), pLen = p.length();
//        //sLen = 3, pLen = 2; idxRange = [0, 1]
//        List<Integer> ans = new ArrayList<>();
//        int windowRtn = -1;
//        while (idx <= sLen - pLen) {
//            windowRtn = smallWindow(s.substring(idx, pLen + idx), p, idx);
//            if (windowRtn != -1)
//                ans.add(idx);
//
//            idx++;
//        }
//
//        return ans;
//    }
//
//    public static int smallWindow(String s, String p, int idx) {
//        ArrayList<Character> exclusionList = new ArrayList<>();
//        for (char c : p.toCharArray())
//            exclusionList.add(c);
//
//        for (char c : s.toCharArray()) {
//            if (exclusionList.contains(c))
//                exclusionList.remove(new Character(c));
//        }
//
//        return exclusionList.isEmpty() ? idx : -1;
//    }
}