import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] numbers;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }

        combination(new int[M], 0, 0, M);
        System.out.println(sb);
        br.close();
    }

    private static void combination(int[] out, int start, int depth, int target) {
        if (depth == target) {
            for (int num : out) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            out[depth] = numbers[i];
            combination(out, i, depth + 1, target);
        }
    }
}
