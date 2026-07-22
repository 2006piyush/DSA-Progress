class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
         int curr_count = 0;
        for(int i=0;i<=nums.length-1;i++){
           
            if(nums[i]==0){
                curr_count = 0;
                continue;
            }
            curr_count++;
            count = Math.max(curr_count,count);
        }
        return count;
    }
}