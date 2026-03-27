import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Gem {
        int weight, price;

        public Gem(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Gem[] gems = new Gem[N];
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gems[i] = new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(gems, (g1, g2) -> Integer.compare(g1.weight, g2.weight));

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        Queue<Gem> pq = new PriorityQueue<>((g1, g2) -> Integer.compare(g2.price, g1.price));

        int bagIdx = 0;
        int gemIdx = 0;
        long ans = 0;

        while (bagIdx < K) {
            int weightLimit = bags[bagIdx];
            while (gemIdx < N && gems[gemIdx].weight <= weightLimit) {
                pq.offer(gems[gemIdx++]);
            }
            if (!pq.isEmpty()) {
                ans += pq.poll().price;
            }
            bagIdx++;
        }

        System.out.println(ans);
    }
}
