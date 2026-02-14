import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            sb.append(solution(br.readLine())).append("\n");
        }
        System.out.print(sb);
    }

    private static int solution(String input) {
        int result = 0;

        int score = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'X') {
                score = 0;
            } else {
                result += ++score;
            }
        }

        return result;
    }
}
