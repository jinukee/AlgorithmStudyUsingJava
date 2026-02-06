import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Character, Integer> priority = new HashMap<>();
    private static final StringBuilder sb = new StringBuilder();

    static {
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('(', -1);
        priority.put(')', -1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        solution(input);
        System.out.println(sb);
    }

    private static void solution(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if (!priority.containsKey(now)) {
                sb.append(now);
            } else {
                if (now == '(') {
                    stack.push(now);
                } else if (now == ')') {
                    while (stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                } else {
                    if (stack.isEmpty() || priority.get(stack.peek()) < priority.get(now)) {
                        stack.push(now);
                    } else {
                        while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(now)) {
                            sb.append(stack.pop());
                        }
                        stack.push(now);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
