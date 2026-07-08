class Solution {

    public int find(int[] freq) {
        int maxCount = -1;
        for (int i = 0; i < 256; i++) {
            maxCount = Math.max(maxCount, freq[i]);
        }
        return maxCount;
    }

    public int characterReplacement(String s, int k) {

        int n = s.length();
        int[] freq = new int[256];

        int low = 0;
        int res = Integer.MIN_VALUE;

        for (int high = 0; high < n; high++) {

            freq[s.charAt(high)]++;

            int maxCount = find(freq);

            while ((high - low + 1) - maxCount > k) {
                freq[s.charAt(low)]--;
                low++;
                maxCount = find(freq);
            }

            res = Math.max(res, high - low + 1);
        }

        return res;
    }
}