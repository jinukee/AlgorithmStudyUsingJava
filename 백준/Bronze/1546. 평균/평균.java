import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            scores[i] = score;
            max = Math.max(max, score);
        }

        double sum = 0;
        for (int score : scores) {
            sum += ((double) score / max) * 100;
        }

        System.out.println(sum / N);
    }
}
