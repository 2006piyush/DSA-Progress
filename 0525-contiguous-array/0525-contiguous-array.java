class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int zeros = 0;
        int ones = 0;
        int maxLength = 0;

        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                ones++;
            }
            int difference = zeros - ones;
            if (map.containsKey(difference)) {
                int length = i - map.get(difference);
                if (length > maxLength) {
                    maxLength = length;
                }

            } else {
                map.put(difference, i);
            }
        }
        return maxLength;
    }
}