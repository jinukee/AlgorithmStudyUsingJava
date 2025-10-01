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
        Deque<Integer> deque = new ArrayDeque<>();
        int result = 0;

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            Deque<Integer> left = new ArrayDeque<>(deque);
            Deque<Integer> right = new ArrayDeque<>(deque);

            while (true) {
                if (left.peekFirst() == target) {
                    left.pollFirst();
                    deque = left;
                    break;
                }
                if (right.peekFirst() == target) {
                    right.pollFirst();
                    deque = right;
                    break;
                }

                left.offerFirst(left.pollLast()); // 오른쪽 끝 왼쪽에 추가
                right.offerLast(right.pollFirst()); // 왼쪽 끝 오른쪽에 추가
                result++;
            }
        }

        bw.write(result + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}