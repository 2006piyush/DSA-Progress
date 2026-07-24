class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
                continue;
            }
            if (st.peek() == s.charAt(i)) {
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        return result.reverse().toString();
    }
}