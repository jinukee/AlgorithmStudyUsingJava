import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private int result;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i < N + 1; i++) {
            if (dfs(i, graph, visited)) result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private boolean dfs(int v, List<List<Integer>> graph, boolean[] visited) {
        if (visited[v]) return false;
        visited[v] = true; // 방문 처리
        for (int next : graph.get(v)) { // 인접한 모든 node 에 대하여 dfs
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
