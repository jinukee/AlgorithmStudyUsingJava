import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited1 = new boolean[N + 1];
        boolean[] visited2 = new boolean[N + 1];
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!graph.get(a).contains(b)) graph.get(a).add(b);
            if (!graph.get(b).contains(a)) graph.get(b).add(a);
        }

        for (List<Integer> list : graph) {
            Collections.sort(list);
        }

        dfs(graph, visited1, V, bw);
        bw.write("\n");
        bfs(graph, visited2, V, bw);
        bw.flush();
        br.close();
        bw.close();
    }

    public void bfs(List<List<Integer>> graph, boolean[] visited, int start, BufferedWriter bw) throws Exception {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            bw.write(now + " ");
            for (Integer v : graph.get(now)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    public void dfs(List<List<Integer>> graph, boolean[] visited, int start, BufferedWriter bw) throws Exception {
        visited[start] = true;
        bw.write(start + " ");
        for (Integer v : graph.get(start)) {
            if (!visited[v]) {
                dfs(graph, visited, v, bw);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}