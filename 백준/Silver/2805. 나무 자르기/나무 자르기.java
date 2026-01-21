import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(trees, M));
        br.close();
    }

    private static int solution(int[] trees, int target) {
        int left = 0;
        int right = Arrays.stream(trees).max().getAsInt();
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long len = 0;

            for (int tree : trees) {
                int degree = tree - mid;
                if (degree > 0) {
                    len += degree;
                }
            }

            if (len >= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
