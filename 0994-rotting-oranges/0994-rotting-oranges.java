class Solution {

    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};

    boolean valid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        // Put all rotten oranges into queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int k = 0; k < size; k++) {

                int[] curr = q.poll();

                int i = curr[0];
                int j = curr[1];

                for (int d = 0; d < 4; d++) {

                    int ni = i + x[d];
                    int nj = j + y[d];

                    if (valid(ni, nj, n, m) && grid[ni][nj] == 1) {

                        grid[ni][nj] = 2;
                        fresh--;

                        q.add(new int[]{ni, nj});
                    }
                }
            }

            time++;
        }

        if (fresh > 0) {
            return -1;
        }

        return time;
    }
}