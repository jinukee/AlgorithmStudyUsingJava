import java.io.*;
import java.util.*;

public class Main {

    static final int INF = (int) 1e7;
    static int[][] adj;
    static int V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        adj = new int[V + 1][V + 1];
        for (int[] row : adj) {
            Arrays.fill(row, INF);
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[u][v] = cost;
        }

        System.out.println(solution());
    }

    static int solution() {
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (adj[i][j] > adj[i][k] + adj[k][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }

        int ans = INF;
        for (int i = 1; i <= V; i++) {
            if (adj[i][i] < ans) {
                ans = adj[i][i];
            }
        }

        if (ans == INF) {
            return -1;
        }
        return ans;
    }
}
