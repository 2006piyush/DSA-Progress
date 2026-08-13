class Solution {
    public int[] topKFrequent(int[] nums, int k) {
          HashMap<Integer, Integer> map = new HashMap<>();
          for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
          }
          PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) ->  a.first - b.first      
        );
        List<Map.Entry<Integer, Integer>> entries =
         new ArrayList<>(map.entrySet());
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<Integer, Integer> entry = entries.get(i);
            pq.add(new Pair(entry.getValue(), entry.getKey()));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().second;
        }
        return ans;
    }
    class Pair {
    int first;
    int second;

    Pair(int f, int s) {
        first = f;
        second = s;
    }
}

}