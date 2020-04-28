package leetcode_challenges.april.day3;

public class LC53MaximumSubarray {
    //    Given an integer array nums, find the contiguous subarray (containing at least one number)
//    which has the largest sum and return its sum.
//
//    Example:
//
//    Input: [-2,1,-3,4,-1,2,1,-5,4],
//    Output: 6
//    Explanation: [4,-1,2,1] has the largest sum = 6.
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return Integer.MIN_VALUE;

        int currentWindowSum = nums[0];
        int largestSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //start a new window , if starting is a better option than extending
            currentWindowSum = Math.max(currentWindowSum + nums[i], nums[i]);
            largestSum = Math.max(largestSum, currentWindowSum);
        }
        return largestSum;
    }
}
