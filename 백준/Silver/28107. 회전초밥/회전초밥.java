import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] result = new int[N];
        int[] sushi = new int[M];

        // 스시 번호 : 먹고 싶은 사람(우선 순위 필요, 중복 안되므로 linkedHashSet 사용해봄) queue 쓰면 중복 체크 따로 해야하니까...
        Map<Integer, LinkedHashSet<Integer>> orderMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                int sushiNum = Integer.parseInt(st.nextToken());
                orderMap.putIfAbsent(sushiNum, new LinkedHashSet<>());
                orderMap.get(sushiNum).add(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sushi[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int order = sushi[i];
            LinkedHashSet<Integer> orderSet = orderMap.get(order);
            if (orderSet != null && !orderSet.isEmpty()) {
                Iterator<Integer> it = orderSet.iterator();
                int customer = it.next();
                it.remove();
                result[customer]++; // java 21 이상에서는 iterator 말고 removeFirst()로 코드 단축 가능함...
            }
        }

        for (int n : result) {
            bw.write(n + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}