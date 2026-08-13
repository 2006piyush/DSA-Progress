import java.util.*;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.second != b.second) {
                    return a.second - b.second;
                }
                return b.first.compareTo(a.first);
            }
        );
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<String, Integer> entry = entries.get(i);
            pq.add(new Pair(entry.getKey(), entry.getValue()));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        int pqSize = pq.size();
        for (int i = 0; i < pqSize; i++) {
            ans.add(pq.poll().first);
        }
        Collections.reverse(ans);
        return ans;
    }

    class Pair {
        String first;
        int second;

        Pair(String f, int s) {
            first = f;
            second = s;
        }
    }
}