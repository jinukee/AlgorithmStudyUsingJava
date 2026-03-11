import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[][] grid;
    private static boolean[][][] visited;

    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new boolean[2][N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = row.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        visited[0][x][y] = true;
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{x, y, 0, 1});

        while (!q.isEmpty()) {
            int[] now = q.poll(); // x, y, cnt(벽을 부순 횟수), dist
            int cnt = now[2];
            int dist = now[3];

            if (now[0] == N - 1 && now[1] == M - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + DX[i];
                int ny = now[1] + DY[i];

                if (!canGo(nx, ny)) {
                    continue;
                }

                if (grid[nx][ny] == 0 && !visited[cnt][nx][ny]) {
                    visited[cnt][nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt, dist + 1});
                }

                if (cnt == 0 && grid[nx][ny] == 1 && !visited[cnt + 1][nx][ny]) {
                    visited[cnt + 1][nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt + 1, dist + 1});
                }
            }
        }

        return -1;
    }

    private static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
