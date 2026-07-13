class Solution {
    public int maxProduct(int[] nums) {
        int minSum = nums[0];
        int maxSum = nums[0];
        int res = nums[0];
        for(int i = 1; i<nums.length;i++){
            int v1 = minSum * nums[i];
            int v2 = maxSum * nums[i]; 
            int v3 = nums[i];
             maxSum = Math.max(v1,Math.max(v2,v3));
             minSum = Math.min(v1,Math.min(v2,v3));
             res    = Math.max(res,maxSum);
        }
        return res;
    }
}