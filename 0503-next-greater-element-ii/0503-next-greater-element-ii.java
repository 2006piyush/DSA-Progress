class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            while (!st.empty() && st.peek() <= nums[idx]) {
                st.pop();
            }
            if (i < n) {
                if (st.empty()) {
                    result[idx] = -1;
                } else {
                    result[idx] = st.peek();
                }
            }
            st.push(nums[idx]);
        }
        return result;
    }
}