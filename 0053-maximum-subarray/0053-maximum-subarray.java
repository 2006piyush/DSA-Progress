class Solution {
    public int maxSubArray(int[] nums) {
        int bestSum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i<nums.length;i++){
            int v1 = bestSum + nums[i];
            int v2 = nums[i];
             bestSum = Math.max(v1,v2);
             maxSum = Math.max(maxSum,bestSum);
        }
        return maxSum;
    }
}