import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] indegree;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(st.nextToken());
            K--;
            while (K-- > 0) {
                int next = Integer.parseInt(st.nextToken());
                indegree[next]++;
                adj[cur].add(next);
                cur = next;
            }
        }

        System.out.print(solution());
    }

    static String solution() {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append("\n");
            cnt++;

            for (int neighbor : adj[cur]) {
                if (--indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        if (cnt < N) {
            return "0";
        }

        return sb.toString();
    }
}
