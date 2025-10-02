import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nextPath = new int[N + 1]; // 풍선의 다음 이동 경로 저장
        for (int i = 1; i <= N; i++) {
            nextPath[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int now = deque.pollFirst();
        bw.write(now + " ");
        for (int i = 0; i < N - 1; i++) {
            int nextCount = nextPath[now];
            if (nextCount < 0) {
                now = goLeft(deque, nextCount);
            } else {
                now = goRight(deque, nextCount);
            }
            bw.write(now + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public int goLeft(Deque<Integer> deque, int n) {
        for (int i = 0; i < -n; i++) {
            deque.offerFirst(deque.pollLast());
        }
        return deque.pollFirst();
    }

    public int goRight(Deque<Integer> deque, int n) {
        for (int i = 0; i < n - 1; i++) {
            deque.offerLast(deque.pollFirst());
        }
        return deque.pollFirst();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}