import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] budgets = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }

        int money = Integer.parseInt(br.readLine());

        System.out.println(solution(budgets, money));
        br.close();
    }

    static int solution(int[] budgets, int money) {
        int sum = Arrays.stream(budgets).sum();
        int max = Arrays.stream(budgets).max().getAsInt();

        if (sum <= money) {
            return max;
        }

        int left = 1;
        int right = max;
        int answer = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            sum = 0;
            for (int budget : budgets) {
                sum += Math.min(budget, mid);
            }

            if (sum <= money) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
