import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        makeStar(N);
        System.out.print(sb);
        br.close();
    }

    private static void makeStar(int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                sb.append("*");
            }
            for (int j = 0; j < 2 * (n - i - 1); j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i = 0; i < 2 * n; i++) {
            sb.append("*");
        }
        sb.append("\n");

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                sb.append("*");
            }
            for (int j = 0; j < 2 * (i + 1); j++) {
                sb.append(" ");
            }

            for (int j = 0; j < n - i - 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
    }
}
