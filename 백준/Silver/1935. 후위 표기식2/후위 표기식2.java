import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static double[] operands;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        operands = new double[N];
        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            operands[i] = Integer.parseInt(br.readLine());
        }
        System.out.printf("%.2f", solution(input));
    }

    private static double solution(String input) {
        Deque<Double> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if (now - 'A' <= N && now - 'A' >= 0) {
                stack.push(operands[now - 'A']);
            } else {
                double second = stack.pop();
                double first = stack.pop();
                switch (now) {
                    case '+':
                        stack.push(first + second);
                        break;
                    case '-':
                        stack.push(first - second);
                        break;
                    case '*':
                        stack.push(first * second);
                        break;
                    case '/':
                        stack.push(first / second);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
