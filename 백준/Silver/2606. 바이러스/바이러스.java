import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private int count;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[] visited = new boolean[N + 1];

        dfs(graph, 1, visited);
        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();
    }

    private void dfs(List<List<Integer>> graph, int v, boolean[] visited) {
        visited[v] = true;
        for (int node : graph.get(v)) {
            if (!visited[node]) {
                count++;
                dfs(graph, node, visited);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}