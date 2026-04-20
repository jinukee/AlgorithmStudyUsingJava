import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] sour = new int[N];
        int[] bitter = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(sour, bitter, N));
    }

    static int solution(int[] sour, int[] bitter, int n) {
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < (1 << n); i++) {
            int sourSum = 1;
            int bitterSum = 0;
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) != 0) {
                    sourSum *= sour[j];
                    bitterSum += bitter[j];
                }
            }
            if (Math.abs(sourSum - bitterSum) < ans) {
                ans = Math.abs(sourSum - bitterSum);
            }
        }

        return ans;
    }
}
