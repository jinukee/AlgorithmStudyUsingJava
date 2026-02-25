import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Node>[] adj;
    private static int endpoint;
    private static int length = 0;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, cost));
            adj[v].add(new Node(u, cost));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        Arrays.fill(visited, false);
        length = 0;

        dfs(endpoint, 0);
        System.out.println(length);
    }

    private static void dfs(int curr, int temp) {
        visited[curr] = true;
        if (length < temp) {
            endpoint = curr;
            length = temp;
        }

        for (Node neighbor : adj[curr]) {
            if (!visited[neighbor.idx]) {
                dfs(neighbor.idx, temp + neighbor.cost);
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
