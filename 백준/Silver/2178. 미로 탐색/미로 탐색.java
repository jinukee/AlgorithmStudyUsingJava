import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        bw.write(String.valueOf(bfs(graph, N, M)));
        bw.flush();
        br.close();
        bw.close();
    }

    public int bfs(int[][] graph, int N, int M) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); // 시작 위치
        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); // 현재 탐색 지점
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) { // 상하 좌우 탐색
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // map 벗어나면 빠져나오기
                if (graph[nx][ny] == 1) { // 갈 수 있는 땅 중에 아직 방문 안 했다면 경로에 추가
                    graph[nx][ny] += graph[x][y];
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return graph[N - 1][M - 1]; // 목적지까지의 최단 거리 return
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}