import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N;
        while ((N = Integer.parseInt(br.readLine())) != 0) {

            boolean[] isPrime = new boolean[2 * N + 1];
            Arrays.fill(isPrime, true);

            isPrime[0] = isPrime[1] = false;

            for (int i = 2; i * i <= 2 * N; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= 2 * N; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            int count = 0;
            for (int i = N + 1; i <= 2 * N; i++) {
                if (isPrime[i]) {
                    count++;
                }
            }
            sb.append(count);
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
