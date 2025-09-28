import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while (!(str = br.readLine()).equals(".")) {
            bw.write(isBalanced(str));
            bw.flush();
        }
        bw.close();
    }

    public String isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (c == '[' || c == '(') stack.push(c);
            else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return "no\n";
                stack.pop();
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return "no\n";
                stack.pop();
            }
        }
        if (stack.isEmpty()) return "yes\n";
        return "no\n";
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}