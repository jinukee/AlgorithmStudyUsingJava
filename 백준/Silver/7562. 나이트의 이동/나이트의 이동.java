import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] DX = {1, 1, 2, 2, -1, -1, -2, -2};
    private static int[] DY = {-2, 2, -1, 1, -2, 2, -1, 1};
    private static boolean[][] visited;
    private static int N;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            bfs(x, y, targetX, targetY);
        }

        System.out.print(sb);
    }

    private static void bfs(int x, int y, int targetX, int targetY) {
        visited[x][y] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, 0}); // x, y, cnt

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cnt = now[2];
            if (now[0] == targetX && now[1] == targetY) {
                sb.append(cnt).append("\n");
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + DX[i];
                int ny = now[1] + DY[i];
                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }
    }

    private static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N && !visited[x][y];
    }
}
