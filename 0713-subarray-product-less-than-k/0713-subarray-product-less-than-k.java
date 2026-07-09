class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int low = 0;
        int res = 0;
        int prod = 1;
        for(int high=0;high<nums.length;high++){
               prod *= nums[high];
               while(prod>=k){
                 prod /= nums[low];
                 low ++;
               }
                res = res + (high - low + 1);
           }
           return res;
        }
    }
