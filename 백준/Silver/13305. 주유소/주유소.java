import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dist = new int[N - 1];
        int[] costs = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        long cost = 0;
        int i = 0;
        int j = 0;

        while (j < N - 1) {
            cost += (long) costs[i] * dist[j++];
            // 지금의 도시에서 기름을 채우는게 유리한 경우에만 기름 값 갱신(greedy)
            if (costs[i] > costs[i + 1]) {
                i++;
            }
        }

        System.out.println(cost);
    }
}
