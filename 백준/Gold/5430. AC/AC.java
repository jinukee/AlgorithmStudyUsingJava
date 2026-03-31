import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            input = input.substring(1, input.length() - 1);

            int[] arr = new int[N];
            st = new StringTokenizer(input, ",");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(solution(command, arr)).append("\n");
        }

        System.out.print(sb);
    }

    static String solution(String command, int[] arr) {

        Deque<Integer> deque = new ArrayDeque<>();
        for (int n : arr) {
            deque.add(n);
        }

        boolean isHead = true;

        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);

            if (c == 'R') {
                isHead = !isHead;
            } else {
                if (deque.isEmpty()) {
                    return "error";
                }

                if (isHead) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (isHead) {
            while (deque.size() > 1) {
                sb.append(deque.pollFirst()).append(",");
            }
        } else {
            while (deque.size() > 1) {
                sb.append(deque.pollLast()).append(",");
            }
        }

        if (!deque.isEmpty()) {
            sb.append(deque.poll());
        }
        sb.append("]");

        return sb.toString();
    }
}
