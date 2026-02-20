import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int INF = 3_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Node>[] adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, cost));
            adj[v].add(new Node(u, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int v1Tov2 = dijkstra(adj, V, v1, v2);

        int result = Math.min(dijkstra(adj, V, 1, v1) + v1Tov2 + dijkstra(adj, V, v2, V), dijkstra(adj, V, 1, v2) + v1Tov2 + dijkstra(adj, V, v1, V));
        if (result >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static int dijkstra(List<Node>[] adj, int V, int start, int end) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.idx] < now.cost) {
                continue;
            }

            for (Node neighbor : adj[now.idx]) {
                if (dist[neighbor.idx] > now.cost + neighbor.cost) {
                    dist[neighbor.idx] = now.cost + neighbor.cost;
                    pq.offer(new Node(neighbor.idx, now.cost + neighbor.cost));
                }
            }
        }

        return dist[end];
    }
}

class Node implements Comparable<Node> {
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}
