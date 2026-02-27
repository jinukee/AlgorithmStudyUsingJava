import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<Integer>[] adj;
    private static int ans = 0;
    private static int target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int root = 0;
        for (int i = 0; i < N; i++) {
            int u = Integer.parseInt(st.nextToken());
            if (u == -1) {
                root = i;
            } else {
                adj[u].add(i);
            }
        }

        target = Integer.parseInt(br.readLine());

        dfs(root);
        System.out.println(ans);
    }

    private static void dfs(int now) {
        if (now == target) {
            return;
        }

        int childcount = 0;
        for (int neighbor : adj[now]) {
            if (neighbor == target) {
                continue;
            }

            childcount++;
            dfs(neighbor);
        }

        if (childcount == 0) {
            ans++;
        }
    }
}
