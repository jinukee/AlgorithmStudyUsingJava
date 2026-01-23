import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] onePrime = {2, 3, 5, 7};
        for (int start : onePrime) {
            dfs(start, 1);
        }

        System.out.println(sb);
        br.close();
    }

    static void dfs(int num, int digitCount) {
        if (digitCount == N) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            int nextNum = num * 10 + i;
            if (isPrime(nextNum)) {
                dfs(nextNum, digitCount + 1);
            }
        }
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
