import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 100;
    private static final int LENGTH = 10;
    private static final int[][] grid = new int[SIZE][SIZE];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            for (int x = X; x < X + LENGTH; x++) {
                for (int y = Y; y < Y + LENGTH; y++) {
                    grid[x][y] = 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                ans += grid[i][j];
            }
        }

        System.out.println(ans);
    }
}
