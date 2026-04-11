import java.io.*;
import java.util.*;

public class Main {

    static final int[] Monkey_X = {1, -1, 0, 0};
    static final int[] Monkey_Y = {0, 0, 1, -1};
    static final int[] Horse_X = {1, 1, 2, 2, -1, -1, -2, -2};
    static final int[] Horse_Y = {-2, 2, 1, -1, 2, -2, 1, -1};

    static int[][] grid;
    static boolean[][][] visited;

    static int W, H, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        grid = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }

    static int solution() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0, 0}); // x, y, k, cnt
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int k = now[2];
            int cnt = now[3];

            if (x == H - 1 && y == W - 1) {
                return cnt;
            }

            if (k < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + Horse_X[i];
                    int ny = y + Horse_Y[i];
                    if (canGo(nx, ny, k + 1)) {
                        visited[nx][ny][k + 1] = true;
                        q.offer(new int[]{nx, ny, k + 1, cnt + 1});
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + Monkey_X[i];
                int ny = y + Monkey_Y[i];
                if (canGo(nx, ny, k)) {
                    visited[nx][ny][k] = true;
                    q.offer(new int[]{nx, ny, k, cnt + 1});
                }
            }
        }

        return -1;
    }

    static boolean canGo(int x, int y, int k) {
        return x >= 0 && x < H && y >= 0 && y < W && !visited[x][y][k] && grid[x][y] != 1;
    }
}
