import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] grid;
    static final int INF = (int) 1e7;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        grid = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                grid[i][j] = INF;
            }
        }

        for (int i = 1; i <= N; i++) {
            grid[i][i] = 0;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            grid[u][v] = Math.min(cost, grid[u][v]);
        }

        System.out.print(floyd());
    }

    static String floyd() {
        StringBuilder sb = new StringBuilder();

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    grid[i][j] = Math.min(grid[i][k] + grid[k][j], grid[i][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (grid[i][j] == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(grid[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
