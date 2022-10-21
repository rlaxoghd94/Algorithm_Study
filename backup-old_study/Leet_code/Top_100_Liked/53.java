import java.util.Arrays;

public class Main {

    /*
     * 53. Maximum Subarray
     * Problem: Given an integer array `nums`, find contiguous subarray(containing at least one number) which has the largest sum and return its sum
     */
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        return DP(nums);
    }


    /*
     * Approach: Dynamic Programming
     * Time Complexity: O(3n) ~= O(n)
     */
    public static int DP(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);     // O(n)

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {         // O(n)
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
        }

        int maxSum = Integer.MIN_VALUE;

        for (int val : dp)                  // O(n)
            maxSum = Math.max(maxSum, val);

        return maxSum;
    }
}