import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] wires = new long[K];

        long high = 0;
        for (int i = 0; i < K; i++) {
            wires[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, wires[i]);
        }

        System.out.println(solution(wires, N, high));
    }

    private static long solution(long[] wires, int N, long high) {
        high++;
        long low = 1;

        while (low < high) {
            long mid = low + (high - low) / 2;

            long count = 0;
            for (long wire : wires) {
                count += wire / mid;
            }

            if (count >= N) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low - 1;
    }
}
