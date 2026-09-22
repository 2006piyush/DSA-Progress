class Solution {

    boolean possible = true;

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {
                dfs(graph, i, 0, color);
            }
        }

        return possible;
    }

    void dfs(int[][] graph, int node, int c, int[] color) {

        color[node] = c;

        for (int neighbor : graph[node]) {

            // Not colored
            if (color[neighbor] == -1) {

                dfs(graph, neighbor, 1 - c, color);
            }

            // Same color -> not bipartite
            else if (color[neighbor] == c) {

                possible = false;
                return;
            }
        }
    }
}