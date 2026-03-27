import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 3];

        dp[2] = 1;
        dp[3] = 1;

        if (N <= 3) {
            System.out.println(dp[N]);
            printResult(N, dp);
            return;
        }

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[N]);
        printResult(N, dp);
    }

    static void printResult(int N, int[] dp) {
        StringBuilder sb = new StringBuilder();

        while (N > 1) {
            sb.append(N).append(" ");
            int next = N - 1;
            if (N % 2 == 0 && dp[next] > dp[N / 2]) {
                next = N / 2;
            }
            if (N % 3 == 0 && dp[next] > dp[N / 3]) {
                next = N / 3;
            }
            N = next;
        }

        sb.append(1);
        System.out.println(sb);
    }
}
