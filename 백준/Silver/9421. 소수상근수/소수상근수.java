import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i] && isHappyPrime(i)) {
                sb.append(i);
                sb.append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    static boolean isHappyPrime(int n) {
        Set<Integer> unique = new HashSet<>();
        String rawNum = String.valueOf(n);
        int sum = 0;
        while (true) {
            for (char c : rawNum.toCharArray()) {
                int num = c - '0';
                sum += num * num;
            }
            if (sum == 1) {
                return true;
            }
            if (!unique.add(sum)) {
                return false;
            }
            rawNum = String.valueOf(sum);
            sum = 0;
        }
    }
}
