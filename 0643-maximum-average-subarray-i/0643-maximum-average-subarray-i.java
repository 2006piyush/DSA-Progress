class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        avg = sum/k;
        double maxAvg = avg;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            avg = sum/k;
            maxAvg = Math.max(maxAvg, avg);
        }
        return maxAvg;
    }
}