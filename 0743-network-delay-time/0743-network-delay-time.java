class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build directed graph
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        dist[k] = 0;
        pq.add(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int d = curr[0];
            int u = curr[1];

            if (d > dist[u]) {
                continue;
            }

            for (int i = 0; i < adj.get(u).size(); i++) {
                int[] neighbor = adj.get(u).get(i);

                int v = neighbor[0];
                int weight = neighbor[1];

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}