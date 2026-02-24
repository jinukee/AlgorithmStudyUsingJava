import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int endpoint;
    private static int temp = 0;
    private static List<Node>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        adj = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) {
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                adj[u].add(new Node(v, cost));
            }
        }

        dfs(1, new boolean[V + 1], 0);
        temp = 0;
        dfs(endpoint, new boolean[V + 1], 0);
        System.out.println(temp);
    }

    private static void dfs(int now, boolean[] visited, int cost) {
        visited[now] = true;
        if (cost > temp) {
            temp = cost;
            endpoint = now;
        }
        for (Node neighbor : adj[now]) {
            if (!visited[neighbor.idx]) {
                dfs(neighbor.idx, visited, cost + neighbor.cost);
            }
        }
    }
}

class Node {
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}
