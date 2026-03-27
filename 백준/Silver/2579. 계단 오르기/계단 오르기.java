import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][2]; // n번째 계단을 밟았을 때 1개 연속 or 2개 연속 밟았을 때 각각의 최대값
        int[] stairs = new int[N];

        for (int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(stairs[0]);
            return;
        }

        dp[0][0] = stairs[0];
        dp[1][0] = stairs[1];
        dp[1][1] = dp[0][0] + stairs[1];

        if (N == 2) {
            System.out.println(dp[1][1]);
            return;
        }

        for (int i = 2; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 2][1], dp[i - 2][0]) + stairs[i]; // 두칸 전 최대값 + 현재 계단
            dp[i][1] = dp[i - 1][0] + stairs[i]; // 한칸 전 최댓값(누적 1계단) + 현재 계단
        }

        System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));
    }
}
