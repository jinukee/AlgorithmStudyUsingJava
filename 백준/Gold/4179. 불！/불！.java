import java.io.*;
import java.util.*;

public class Main {

    static final int[] DX = {0, 0, 1, -1};
    static final int[] DY = {1, -1, 0, 0};

    static int R, C;
    static char[][] grid;
    static List<int[]> firePlaces = new ArrayList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        visited = new boolean[R][C];

        int[] starts = new int[2];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                char value = input.charAt(j);
                if (value == 'F') {
                    firePlaces.add(new int[]{i, j});
                } else if (value == 'J') {
                    starts[0] = i;
                    starts[1] = j;
                }
                grid[i][j] = value;
            }
        }

        int ans = bfs(starts);
        if (ans == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(ans);
        }
    }

    static int bfs(int[] starts) {

        Queue<int[]> q = new ArrayDeque<>();
        visited[starts[0]][starts[1]] = true;
        q.offer(new int[]{starts[0], starts[1], 1});

        int flag = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            if (x == 0 || y == 0 || x == R - 1 || y == C - 1) {
                return cnt;
            }

            if (flag != cnt) {
                flag = cnt;
                if (!firePlaces.isEmpty()) {
                    firePlaces = fire();
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (inRange(nx, ny) && grid[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        return -1;
    }

    static List<int[]> fire() {
        List<int[]> nextPath = new ArrayList<>();
        for (int[] cur : firePlaces) {
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + DX[i];
                int ny = cur[1] + DY[i];

                if (inRange(nx, ny) && grid[nx][ny] == '.') {
                    grid[nx][ny] = 'F';
                    nextPath.add(new int[]{nx, ny});
                }
            }
        }

        return nextPath;
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
