import java.io.*;
import java.util.*;

public class Main {

    static final int[] DX = {1, -1, 0, 0};
    static final int[] DY = {0, 0, 1, -1};
    static final int INF = Integer.MAX_VALUE;

    static int N, M;
    static int visitId = 1;
    static int[][] grid;
    static int[][] visited;
    static List<int[]> startingPoints;
    static int ans = INF;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        visited = new int[N][N];
        startingPoints = new ArrayList<>();
        int targetCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 2) {
                    startingPoints.add(new int[]{i, j});
                } else if (value == 0) {
                    targetCount++;
                }
                grid[i][j] = value;
            }
        }

        System.out.println(solution(targetCount));
    }

    static int solution(int targetCount) {
        if (targetCount == 0) {
            return 0;
        }

        choose(0, 0, new ArrayList<>(), targetCount);

        if (ans == INF) {
            return -1;
        } else {
            return ans;
        }
    }

    // 바이러스 시작점 M개를 골라서 bfs(전파), backtracking 을 이용한 combination
    static void choose(int depth, int idx, List<int[]> starts, int targetCount) {
        if (depth == M) {
            bfs(starts, targetCount);
            return;
        }

        for (int i = idx; i < startingPoints.size(); i++) {
            starts.add(startingPoints.get(i));
            choose(depth + 1, i + 1, starts, targetCount);
            starts.remove(starts.size() - 1);
        }
    }

    static void bfs(List<int[]> starts, int targetCount) {

        int temp = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int[] cur : starts) {
            visited[cur[0]][cur[1]] = visitId;
            q.offer(new int[]{cur[0], cur[1], 0}); // x, y, time
        }

        while (!q.isEmpty() && targetCount > 0) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int time = now[2];
            if (grid[x][y] == 0) {
                targetCount--;
            }

            if (time > temp) {
                temp = time;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];
                if (canGo(nx, ny)) {
                    visited[nx][ny] = visitId;
                    q.offer(new int[]{nx, ny, time + 1});
                }
            }
        }

        if (contaminated()) {
            if (ans > temp) {
                ans = temp;
            }
        }

        visitId++;
    }

    // 벽이 아닌데 방문 안했으면 전파 실패한것임
    static boolean contaminated() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0 && visited[i][j] != visitId) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && visited[x][y] != visitId && grid[x][y] != 1;
    }
}
