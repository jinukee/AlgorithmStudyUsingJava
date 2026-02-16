import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] grid;
    private static int N, M;
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        List<int[]> starts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    starts.add(new int[]{i, j});
                }
                grid[i][j] = input;
            }
        }

        System.out.println(bfs(starts));
    }

    private static int bfs(List<int[]> starts) {
        Queue<int[]> q = new ArrayDeque<>(starts);
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + DX[i];
                int ny = now[1] + DY[i];
                if (canGo(nx, ny)) {
                    grid[nx][ny] = grid[now[0]][now[1]] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int ans = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0) {
                    return -1;
                }
                ans = Math.max(ans, grid[i][j]);
            }
        }

        return ans - 1;
    }

    private static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M && grid[x][y] == 0;
    }
}
