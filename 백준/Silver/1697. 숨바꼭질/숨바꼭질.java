import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = (int) 1e5 + 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    static int bfs(int n, int k) {
        boolean[] visited = new boolean[MAX + 1];
        visited[n] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{n, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == k) {
                return now[1];
            }

            int[] path = {now[0] + 1, now[0] - 1, now[0] * 2};

            for (int next : path) {
                if (canGo(next) && !visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, now[1] + 1});
                }
            }
        }

        return -1;
    }

    static boolean canGo(int x) {
        return x >= 0 && x < MAX;
    }
}
