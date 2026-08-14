class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.first != b.first) {
                    return b.first - a.first;
                }
                return b.second.compareTo(a.second);
            }
        );
        Character[] keys = charFreq.keySet().toArray(new Character[0]);
        for (int i = 0; i < keys.length; i++) {
            char c = keys[i];
            pq.add(new Pair(charFreq.get(c), c));
        }

        int seat = 0;
        String res = "";
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (seat == 0 || res.charAt(seat - 1) != p.second) {
                res = res + p.second;
                seat++;
                p.first--;
                if (p.first > 0) {
                    pq.add(p);
                }

            }
            else {
                if (pq.isEmpty()) {
                    return "";
                }
                Pair next = pq.poll();
                res = res + next.second;
                seat++;
                next.first--;
                if (next.first > 0) {
                    pq.add(next);
                }
                pq.add(p);
            }
        }
        return res;
    }

    class Pair {
        int first;
        Character second;

        Pair(int f, Character s) {
            first = f;
            second = s;
        }
    }
}