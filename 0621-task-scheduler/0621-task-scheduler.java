class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charFreq = new HashMap<>();
        Map<Character, Integer> charFree = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            char c = tasks[i];
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
            charFree.put(c, 0);
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

        int time = 0;

        while (!pq.isEmpty()) {

            ArrayList<Pair> list = new ArrayList<>();
            boolean executed = false;

            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                char c = p.second;

                if (charFree.get(c) <= time) {

                    p.first--;
                    charFree.put(c, time + n + 1);

                    time++;
                    executed = true;

                    if (p.first > 0) {
                        list.add(p);
                    }

                    break;

                } else {
                    list.add(p);
                }
            }

            for (int i = 0; i < list.size(); i++) {
                pq.add(list.get(i));
            }

            if (!executed) {
                time++;
            }
        }

        return time;
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