import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = (int) 1e5 + 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, K));
    }

    static int solution(int n, int k) {
        boolean[] visited = new boolean[MAX];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{0, n});
        visited[n] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            visited[cur[1]] = true;

            if (cur[1] == k) {
                return cur[0];
            }

            if (inRange(cur[1] * 2) && !visited[cur[1] * 2]) {
                pq.offer(new int[]{cur[0], cur[1] * 2});
            }

            if (inRange(cur[1] - 1) && !visited[cur[1] - 1]) {
                pq.offer(new int[]{cur[0] + 1, cur[1] - 1});
            }

            if (inRange(cur[1] + 1) && !visited[cur[1] + 1]) {
                pq.offer(new int[]{cur[0] + 1, cur[1] + 1});
            }
        }

        return -1;
    }

    static boolean inRange(int x) {
        return x >= 0 && x < MAX;
    }
}
