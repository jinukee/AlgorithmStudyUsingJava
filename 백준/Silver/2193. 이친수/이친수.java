import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }

    static long solution(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        long[] dp = new long[n];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n - 1];
    }
}
