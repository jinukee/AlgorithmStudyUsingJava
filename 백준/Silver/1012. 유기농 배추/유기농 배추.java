import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};
    private static int N;
    private static int M;
    private static boolean[][] visisted;
    private static final StringBuilder sb = new StringBuilder();
    private static int[][] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            adj = new int[N][M];
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                adj[x][y] = 1;
            }

            visisted = new boolean[N][M];
            int count = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (dfs(x, y, visisted)) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean dfs(int x, int y, boolean[][] visited) {
        if (visited[x][y] || adj[x][y] != 1) {
            return false;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && adj[nx][ny] == 1) {
                dfs(nx, ny, visited);
            }
        }

        return true;
    }
}
