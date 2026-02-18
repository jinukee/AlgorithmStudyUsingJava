import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        K = Math.min(K, N - K);

        int dividend = 1;
        int divisor = 1;

        for (int i = N; i > N - K; i--) {
            dividend *= i;
        }

        for (int i = 1; i <= K; i++) {
            divisor *= i;
        }

        System.out.println(dividend / divisor);
    }
}
