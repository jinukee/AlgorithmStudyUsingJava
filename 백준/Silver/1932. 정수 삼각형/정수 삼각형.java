import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i][0] + dp[i - 1][0];
			for (int j = 1; j < i; j++) {
				dp[i][j] = dp[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
			}
			dp[i][i] = dp[i][i] + dp[i - 1][i - 1];
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (ans < dp[N - 1][i]) {
				ans = dp[N - 1][i];
			}
		}

		System.out.println(ans);
	}
}
