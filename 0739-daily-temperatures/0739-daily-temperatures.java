class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        result[n - 1] = 0;
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.empty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            if (st.empty()) {
                result[i] = 0;
            } else {
                result[i] = st.peek()-i;
            }

            st.push(i);
        }
       return result;
    }
}