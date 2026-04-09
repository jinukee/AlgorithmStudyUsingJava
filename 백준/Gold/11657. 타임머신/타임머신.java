import java.io.*;
import java.util.*;

public class Main {

    static final int INF = (int) 1e7;
    static int N, M;
    static List<Edge>[] adj;
    static long[] dist;

    static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            adj[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        dist = new long[N + 1];
        Arrays.fill(dist, INF);

        if (spfa()) {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append(-1);
                } else {
                    sb.append(dist[i]);
                }
                sb.append("\n");
            }
        } else {
            sb.append(-1);
        }
        System.out.print(sb);
    }

    static boolean spfa() {
        int[] cnt = new int[N + 1];
        boolean[] inQueue = new boolean[N + 1];
        dist[1] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        inQueue[1] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            inQueue[curr] = false;

            for (Edge edge : adj[curr]) {
                if (dist[curr] + edge.cost < dist[edge.to]) { // 해당 노드로부터 더 빠르게 갈 수 있으면
                    dist[edge.to] = dist[curr] + edge.cost; // 거리 갱신

                    if (!inQueue[edge.to]) { // next 방문 큐에 없다면 추가
                        if (++cnt[edge.to] >= N) { // N번 이상 갱신되면 음의 사이클로 간주.
                            return false;
                        }

                        q.offer(edge.to);
                        inQueue[edge.to] = true;
                    }
                }
            }
        }

        return true;
    }
}
