import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int input[] = {4, 3, 2, 7, 8, 2, 3, 1};

        findDisappearedNumbers(input);

    }


    /*
     * Approach: add all range into a HashSet and start excluding elements one by one
     * Time Complexity: n + n + n = O(3n) ~= O(n)
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null)
            return null;
        List<Integer> ansList;
        HashSet<Integer> exclusionSet = new HashSet<Integer>();

        int i, tmpVal;
        for (i = 1; i < nums.length + 1; i++)
            exclusionSet.add(i);

        for (i = 0; i < nums.length; i++) {
            tmpVal = nums[i];
            if ( exclusionSet.contains(tmpVal) )
                exclusionSet.remove(tmpVal);
        }

        ansList = new ArrayList<Integer>(exclusionSet);
//        System.out.println("  -> List contains: " + ansList);
        return ansList;
    }
}
