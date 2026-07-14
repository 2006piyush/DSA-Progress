class Solution {
    public int maxAbsoluteSum(int[] nums) {
           int maxSum=0, minSum=0, ans=0;
         for(int x: nums){
            maxSum=Math.max(0, maxSum+x);
            minSum=Math.min(0, minSum+x);
            ans=Math.max(ans, maxSum-minSum);                                
        }
        return ans;
    }
}