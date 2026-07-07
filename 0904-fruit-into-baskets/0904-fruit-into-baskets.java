class Solution {
    public int totalFruit(int[] fruits) {
          int n = fruits.length;
        int l = 0, Len = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int r = 0; r < n; r++) {
            freq.put(fruits[r], freq.getOrDefault(fruits[r], 0) + 1);

            while (freq.size() > 2) {
                int lFruit = fruits[l];
                freq.put(lFruit, freq.get(lFruit) - 1);
                if (freq.get(lFruit) == 0)
                    freq.remove(lFruit);
                l++;
            }

            Len = Math.max(Len, r - l + 1);
        }

        return Len;
    



    }
}