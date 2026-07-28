class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int ans = 0;
        boolean isOdd = false;
        for (char ch = 0; ch < 128; ch++) {
            if (!map.containsKey(ch)) {
                continue;
            }
            int count = map.get(ch);
            if (count % 2 == 0) {
                ans += count;
            } else {
                ans += count - 1;
                isOdd = true;
            }
        }
        return isOdd ? ans + 1 : ans;
    }
}