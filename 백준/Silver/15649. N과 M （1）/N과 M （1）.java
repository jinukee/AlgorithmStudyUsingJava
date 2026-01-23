import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static int[] numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }

        permutation(new int[M], 0, M, new boolean[N]);
        System.out.println(sb);
        br.close();
    }

    private static void permutation(int[] out, int depth, int target, boolean[] visited) {
        if (depth == target) {
            for (int num : out) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = numbers[i];
                permutation(out, depth + 1, target, visited);
                visited[i] = false;
            }
        }
    }
}
