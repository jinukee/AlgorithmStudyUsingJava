import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static boolean[][] board;
    private static final int LEN = 8;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }

        int result = 64;
        for (int i = 0; i <= N - LEN; i++) {
            for (int j = 0; j <= M - LEN; j++) {
                result = Math.min(Math.min(fill1(i, j), fill2(i, j)), result);
            }
        }
        System.out.println(result);
    }

    private static int fill1(int x, int y) {
        int result = 0;
        for (int i = x; i < x + LEN; i++) {
            for (int j = y; j < y + LEN; j++) {
                if ((i + j) % 2 == 0 && board[i][j]) {
                    result += 1;
                } else if ((i + j) % 2 != 0 && !board[i][j]) {
                    result += 1;
                }
            }
        }
        return result;
    }

    private static int fill2(int x, int y) {
        int result = 0;
        for (int i = x; i < x + LEN; i++) {
            for (int j = y; j < y + LEN; j++) {
                if ((i + j) % 2 == 0 && !board[i][j]) {
                    result += 1;
                } else if ((i + j) % 2 != 0 && board[i][j]) {
                    result += 1;
                }
            }
        }
        return result;
    }
}
