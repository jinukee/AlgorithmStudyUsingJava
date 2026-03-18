import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] inDegree;
    private static int[] result;
    private static List<Integer>[] adj;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inDegree = new int[N + 1];
        result = new int[N + 1];
        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            inDegree[v]++;
        }

        solution();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.print(sb);
    }

    private static void solution() {
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(new int[]{i, 1}); // node, cnt
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            result[now[0]] = now[1];
            for (int neighbor : adj[now[0]]) {
                if (--inDegree[neighbor] == 0) {
                    q.offer(new int[]{neighbor, now[1] + 1});
                }
            }
        }
    }
}
