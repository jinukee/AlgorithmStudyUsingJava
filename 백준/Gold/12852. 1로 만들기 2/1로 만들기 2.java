import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 3];
        int[] path = new int[N + 3];

        dp[2] = 1;
        dp[3] = 1;
        path[2] = 1;
        path[3] = 1;
        if (N <= 3) {
            System.out.println(dp[N]);
            printResult(N, path);
            return;
        }

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            int prev = i - 1;
            if (i % 2 == 0) {
                if (dp[i] > dp[i / 2] + 1) {
                    dp[i] = dp[i / 2] + 1;
                    prev = i / 2;
                }
            }
            if (i % 3 == 0) {
                if (dp[i] > dp[i / 3] + 1) {
                    dp[i] = dp[i / 3] + 1;
                    prev = i / 3;
                }
            }
            path[i] = prev;
        }

        System.out.println(dp[N]);
        printResult(N, path);
    }

    static void printResult(int N, int[] path) {
        StringBuilder sb = new StringBuilder();
        while (N > 1) {
            sb.append(N).append(" ");
            N = path[N];
        }
        sb.append(1);
        System.out.println(sb);
    }
}
