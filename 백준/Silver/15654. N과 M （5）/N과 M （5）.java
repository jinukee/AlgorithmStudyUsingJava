import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static int[] nums;
    private static boolean[] visited;
    private static int[] outputs;
    private static int N;
    private static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        outputs = new int[M];
        visited = new boolean[N];

        choose(0);
        System.out.print(sb);
    }

    private static void choose(int now) {
        if (now == M) {
            for (int num : outputs) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                outputs[now] = nums[i];
                choose(now + 1);
                visited[i] = false;
            }
        }
    }
}
