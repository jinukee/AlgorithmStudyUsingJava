import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long ans = 0;

        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            heap.offer(Integer.parseInt(br.readLine()));
        }

        while (!heap.isEmpty()) {
            int top = heap.poll();
            if (heap.isEmpty()) {
                break;
            }
            int next = heap.poll();
            ans += (top + next);
            heap.offer(top + next);
        }

        System.out.println(ans);
    }
}
