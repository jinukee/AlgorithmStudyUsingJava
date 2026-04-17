import java.io.*;
import java.util.*;

public class Main {
    static final int[] DX = {0, 0, 1, -1};
    static final int[] DY = {1, -1, 0, 0};

    static int R, C;
    static char[][] grid;
    static int[][] fireTime;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        fireTime = new int[R][C];
        dist = new int[R][C];

        Queue<int[]> fireQ = new ArrayDeque<>();
        Queue<int[]> humanQ = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = input.charAt(j);
                fireTime[i][j] = -1;
                dist[i][j] = -1;

                if (grid[i][j] == 'F') {
                    fireQ.offer(new int[]{i, j});
                    fireTime[i][j] = 0;
                } else if (grid[i][j] == 'J') {
                    humanQ.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + DX[i];
                int ny = cur[1] + DY[i];
                if (inRange(nx, ny) && grid[nx][ny] != '#' && fireTime[nx][ny] == -1) {
                    fireTime[nx][ny] = fireTime[cur[0]][cur[1]] + 1;
                    fireQ.offer(new int[]{nx, ny});
                }
            }
        }

        while (!humanQ.isEmpty()) {
            int[] cur = humanQ.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == 0 || y == 0 || x == R - 1 || y == C - 1) {
                System.out.println(dist[x][y] + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (inRange(nx, ny) && grid[nx][ny] == '.' && dist[nx][ny] == -1) {
                    if (fireTime[nx][ny] == -1 || dist[x][y] + 1 < fireTime[nx][ny]) {
                        dist[nx][ny] = dist[x][y] + 1;
                        humanQ.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
