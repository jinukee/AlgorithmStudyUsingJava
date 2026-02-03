import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static char[][] grid;
    private static final int[] DX = {0, 0, -1, 1};
    private static final int[] DY = {-1, 1, 0, 0};
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = input.charAt(j);
            }
        }

        boolean[][] visited1 = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];
        int count1 = 0;
        int count2 = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int[] start = new int[]{x, y};
                if (bfsNormal(start, visited1)) {
                    count1++;
                }
                if (bfsBlind(start, visited2)) {
                    count2++;
                }
            }
        }

        sb.append(count1).append(" ").append(count2);
        System.out.println(sb);
        br.close();
    }

    private static boolean bfsNormal(int[] start, boolean[][] visited) {
        if (visited[start[0]][start[1]]) {
            return false;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] loc = q.poll();
            char now = grid[loc[0]][loc[1]];
            for (int i = 0; i < 4; i++) {
                int nx = loc[0] + DX[i];
                int ny = loc[1] + DY[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && grid[nx][ny] == now && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return true;
    }

    private static boolean bfsBlind(int[] start, boolean[][] visited) {
        if (visited[start[0]][start[1]]) {
            return false;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] loc = q.poll();
            char now = grid[loc[0]][loc[1]];
            for (int i = 0; i < 4; i++) {
                int nx = loc[0] + DX[i];
                int ny = loc[1] + DY[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (now == 'R' || now == 'G') {
                        if (grid[nx][ny] != 'B') {
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    } else {
                        if (grid[nx][ny] == now) {
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        return true;
    }
}
