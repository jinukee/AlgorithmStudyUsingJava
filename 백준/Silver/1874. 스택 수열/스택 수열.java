import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] targets = new int[n];
        for (int i = 0; i < n; i++) {
            targets[i] = Integer.parseInt(br.readLine());
        }
        System.out.print(solution(targets, n));
    }

    private static String solution(int[] targets, int n) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        int now = 1;
        int i = 0;
        while (i < n) {
            if (stack.isEmpty()) {
                stack.push(now++);
                sb.append("+").append("\n");
            } else {
                if (stack.peek() == targets[i]) {
                    stack.pop();
                    sb.append("-").append("\n");
                    i++;
                } else if (stack.peek() > targets[i]) {
                    return "NO";
                } else {
                    stack.push(now++);
                    sb.append("+").append("\n");
                }
            }
        }
        return sb.toString();
    }
}
