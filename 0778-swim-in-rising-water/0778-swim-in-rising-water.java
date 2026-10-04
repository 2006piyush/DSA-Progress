class Solution {
    static class Pair {
        int effort;
        int row;
        int col;

        Pair(int effort, int row, int col) {
            this.effort = effort;
            this.row = row;
            this.col = col;
        }
    }

    boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n &&
               col >= 0 && col < m;
    }

    public int swimInWater(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.effort - b.effort
        );

        pq.add(new Pair(heights[0][0], 0, 0));
        dist[0][0] = heights[0][0];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            int effort = curr.effort;
            int row = curr.row;
            int col = curr.col;

            if (effort > dist[row][col]) {
                continue;
            }

            if (row == n - 1 && col == m - 1) {
                return effort;
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (isValid(nr, nc, n, m)) {
                    int newEffort = Math.max(
                        effort, heights[nr][nc]
                    );

                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.add(new Pair(newEffort, nr, nc));
                    }
                }
            }
        }

        return -1;
    }
}