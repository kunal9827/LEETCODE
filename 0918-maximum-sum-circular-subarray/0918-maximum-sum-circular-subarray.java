class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int max = 0;
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max + nums[i]);
            maxSum = Math.max(maxSum, max);
            min = Math.min(nums[i], min + nums[i]);
            minSum = Math.min(minSum, min);
            total += nums[i];
        }
        if (maxSum < 0) 
            return maxSum;
        return Math.max(maxSum, total - minSum);
    }
}