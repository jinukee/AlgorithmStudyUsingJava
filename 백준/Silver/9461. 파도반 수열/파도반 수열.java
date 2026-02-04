import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final long[] DP = new long[101];
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DP[1] = DP[2] = DP[3] = 1;
        for (int i = 4; i <= 100; i++) {
            DP[i] = DP[i - 3] + DP[i - 2];
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            sb.append(DP[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.print(sb);
    }
}
