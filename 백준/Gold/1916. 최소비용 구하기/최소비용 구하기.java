import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static final int INF = 100_000_001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Node>[] adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, cost));
        }

        st = new StringTokenizer(br.readLine());
        System.out.println(dijkstra(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), adj));
    }

    private static int dijkstra(int from, int to, List<Node>[] adj) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[from] = 0;

        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(from, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.cost > dist[curr.idx]) {
                continue;
            }
            for (Node neighbor : adj[curr.idx]) {
                if (dist[neighbor.idx] > curr.cost + neighbor.cost) {
                    dist[neighbor.idx] = curr.cost + neighbor.cost;
                    pq.offer(new Node(neighbor.idx, curr.cost + neighbor.cost));
                }
            }
        }

        return dist[to];
    }
}

class Node implements Comparable<Node>{
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
