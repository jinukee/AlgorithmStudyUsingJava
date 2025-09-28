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
        String str = br.readLine();
        boolean istag = false;
        Deque<Character> stack = new ArrayDeque<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == '<') {
                istag = true;
                clearStack(stack, bw);
            } else if (c == '>') {
                bw.write(c + "");
                istag = false;
                continue;
            }
            if (istag) bw.write(c + "");
            else {
                if (c != ' ') {
                    stack.push(c);
                }
            }
            if (!istag && (c == ' ' || i == len - 1)) {
                clearStack(stack, bw);
                bw.write(" ");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public void clearStack(Deque<Character> stack, BufferedWriter bw) throws Exception {
        while (!stack.isEmpty()) {
            bw.write(stack.pop() + "");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}