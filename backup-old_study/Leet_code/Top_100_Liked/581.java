import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        int diff = findUnsortedSubarray(arr);

        System.out.println(diff);
    }


    /*
     * 581. Shortest Unsorted Continuous Subarray
     * Approach: using Math.min and Math.min, find min and max range where an original array and a duplicated sorted array differs
     * Time Complexity: O(n + log(n) + n) ~= O(2n + log(n)) ~= O(2n) ~= O(n)
     */

    public static int findUnsortedSubarray(int[] nums) {
        int minDiffIdx = nums.length, maxDiffIdx = 0, result = 0;
        int[] copy = nums.clone();

        Arrays.sort(copy);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                minDiffIdx = Math.min(i, minDiffIdx);
                maxDiffIdx = Math.max(i, maxDiffIdx);
            }
        }

        result = maxDiffIdx - minDiffIdx + 1;

        return (result < 0) ? 0 : result;
    }

    public static void printArr(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

}
