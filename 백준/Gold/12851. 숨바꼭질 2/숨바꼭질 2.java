import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = (int) 1e5 + 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ans = bfs(N, K);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    // 방문 배열을 int로 관리(몇 번째 step에 해당 좌표에 방문했는지를 기록)
    // bfs 수행시 해당 좌표에 더 빨리 간 적이 있다면 skip하는 형태로 불필요한 탐색 제거
    static int[] bfs(int n, int k) {
        int[] visited = new int[MAX];
        Arrays.fill(visited, MAX + 1);
        visited[n] = 0;

        int cnt = 0;
        int shortestPath = MAX + 1;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{n, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int dist = now[1];

            if (dist > shortestPath) { // 최적 루트보다 긴 path들은 더 이상 탐색 가치가 없음.
                break;
            }

            if (x == k) { // 동생을 잡았으면 path갱신 후 다른 경로로 잡은 경우들 모두 집계.
                if (shortestPath > dist) {
                    shortestPath = dist;
                    cnt = 1;
                } else {
                    cnt++;
                }
            }

            int[] neighbor = {x - 1, x + 1, x * 2};
            for (int next : neighbor) {
                if (canGo(next) && visited[next] >= dist + 1) { // 해당 위치에 이전에 도착한 적이 있으면 추가 안하도록
                    visited[next] = dist + 1; // 해당 dist에서의 방문 처리 후 q 삽입.
                    q.offer(new int[]{next, dist + 1});
                }
            }
        }
        return new int[]{shortestPath, cnt};
    }

    static boolean canGo(int x) {
        return x >= 0 && x < MAX;
    }
}
