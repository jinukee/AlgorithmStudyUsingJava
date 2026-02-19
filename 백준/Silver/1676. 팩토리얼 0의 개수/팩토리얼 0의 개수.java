import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));
    }

    // 2의 배수는 매우 흔함.
    // factorial 의 곱을 구성하는 수들 중 5를 count해주는 방식으로 계산 가능.
    private static int solution(int N) {
        int now = 5;
        int ans = 0;
        while (true) {
            int temp = N / now;
            if (temp == 0) {
                return ans;
            }
            ans += temp;
            now *= 5;
        }
    }
}
