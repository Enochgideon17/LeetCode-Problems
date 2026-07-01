// Using Priority Queue approach
class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        int[][] dist = new int[n][n];

        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();

        // Multi-source BFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            for (int[] d : dir) {

                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 &&
                    nx < n && ny < n &&
                    dist[nx][ny] == -1) {

                    dist[nx][ny] = dist[x][y] + 1;

                    q.offer(new int[]{nx, ny});
                }
            }
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> b[2] - a[2]);

        boolean[][] visited = new boolean[n][n];

        pq.offer(new int[]{0, 0, dist[0][0]});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int x = cur[0];
            int y = cur[1];
            int safe = cur[2];

            if (visited[x][y])
                continue;

            visited[x][y] = true;

            if (x == n - 1 && y == n - 1)
                return safe;

            for (int[] d : dir) {

                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 &&
                    nx < n && ny < n &&
                    !visited[nx][ny]) {

                    int newSafe = Math.min(safe, dist[nx][ny]);

                    pq.offer(new int[]{
                            nx,
                            ny,
                            newSafe
                    });
                }
            }
        }

        return 0;
    }
}