class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {             
            int mid = start + (end - start) / 2;
            if (mid == 0) {
                start = mid + 1;
                continue; 
            } else if (mid == nums.length - 1) {
                end = mid - 1;
                continue; 
            }
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            else if (nums[mid] < nums[mid-1]) {  
                end = mid - 1;
            }
            else {                          
                start = mid + 1;
            }
        }
        return -1;
    }
}