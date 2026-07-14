class Solution {
    public int maximumSum(int[] nums) {
        int oneDelete = nums[0];
        int noDelete = nums[0];
        int maxSum = nums[0];
      
        for(int i = 1; i<nums.length;i++){

           int prevNoDelete = noDelete;
           noDelete = Math.max(nums[i],noDelete+nums[i]);
           oneDelete = Math.max(prevNoDelete,oneDelete + nums[i] );
           maxSum = Math.max(maxSum,noDelete);
           maxSum = Math.max(maxSum,oneDelete);
        }
        return maxSum;
    }
}