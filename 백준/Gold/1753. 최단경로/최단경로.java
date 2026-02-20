import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        List<Node>[] adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            adj[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        dijkstra(V, start, adj);
        System.out.print(sb);
    }

    private static void dijkstra(int V, int start, List<Node>[] adj) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);

        dist[start] = 0;

        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.idx] < now.dir) {
                continue;
            }

            for (Node neighbor : adj[now.idx]) {
                if (dist[neighbor.idx] > now.dir + neighbor.dir) {
                    dist[neighbor.idx] = now.dir + neighbor.dir;
                    pq.offer(new Node(neighbor.idx, now.dir + neighbor.dir));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
    }
}

class Node implements Comparable<Node> {
    int idx;
    int dir;

    public Node(int idx, int dir) {
        this.idx = idx;
        this.dir = dir;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.dir, other.dir);
    }
}
