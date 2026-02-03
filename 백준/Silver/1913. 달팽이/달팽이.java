import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        solution(N, M);
        System.out.println(sb);
        br.close();
    }

    // U -> R -> D -> L 1,1,2,2,3,3,4,4,...
    private static void solution(int n, int m) {
        int direction = 0;
        int flag = 0;
        int moveCount = 1;
        int temp = 1;
        int x = n / 2;
        int y = n / 2;
        grid[x][y] = 1;
        int[] result = new int[2];
        if (m == 1) {
            result[0] = x;
            result[1] = y;
        }

        for (int i = 2; i <= n * n; i++) {
            if (moveCount == 0) {
                flag++;
                moveCount = temp;
                direction = (direction + 1) % 4;
            }
            if (flag == 2) {
                moveCount = ++temp;
                flag = 0;
            }
            x += DX[direction];
            y += DY[direction];
            grid[x][y] = i;
            if (i == m) {
                result[0] = x;
                result[1] = y;
            }
            moveCount--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(result[0] + 1).append(" ").append(result[1] + 1);
    }
}
