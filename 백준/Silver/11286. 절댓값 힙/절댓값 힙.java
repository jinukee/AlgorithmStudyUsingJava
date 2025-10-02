import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> heapq = new PriorityQueue<>((n1, n2) -> {
            int result = Integer.compare(Math.abs(n1), Math.abs(n2));
            result = (result == 0) ? Integer.compare(n1, n2) : result;
            return result;
        });

        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(br.readLine());
            if (next == 0) {
                if (heapq.isEmpty()) bw.write(0 + "\n");
                else {
                    bw.write(heapq.poll() + "\n");
                }
            } else {
                heapq.offer(next);
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}