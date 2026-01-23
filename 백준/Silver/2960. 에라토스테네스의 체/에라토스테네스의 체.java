import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, K));
    }

    static int solution(int N, int K) {
        boolean[] visited = new boolean[N + 1];

        int count = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if (!visited[j]) {
                    visited[j] = true;
                    count++;
                }

                if (count == K) {
                    return j;
                }
            }
        }
        return -1;
    }
}
