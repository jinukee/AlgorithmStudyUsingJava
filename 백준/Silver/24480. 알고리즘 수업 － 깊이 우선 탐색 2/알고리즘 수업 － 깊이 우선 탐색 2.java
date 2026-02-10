import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static List<List<Integer>> adj = new ArrayList<>();
    private static boolean[] visited;
    private static int count = 1;
    private static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (List<Integer> neighbors : adj) {
            Collections.sort(neighbors, Collections.reverseOrder());
        }

        visited = new boolean[N + 1];
        result = new int[N + 1];
        dfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int now) {
        visited[now] = true;
        result[now] = count++;
        for (int neighbor : adj.get(now)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
