import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 100_000_000;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] adj = new int[N + 1][N + 1];
        for (int[] row : adj) {
            Arrays.fill(row, INF);
        }

        for (int i = 0; i <= N; i++) {
            adj[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[u][v] = Math.min(adj[u][v], cost);
        }

        floyd(adj, N);
        System.out.print(sb);
    }

    private static void floyd(int[][] adj, int N) {
        for (int k = 1; k <= N; k++) {
            for (int x = 1; x <= N; x++) {
                for (int y = 1; y <= N; y++) {
                    if (adj[x][y] > adj[x][k] + adj[k][y]) {
                        adj[x][y] = adj[x][k] + adj[k][y];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int now = adj[i][j];
                if (now == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(now).append(" ");
                }
            }
            sb.append("\n");
        }
    }
}
