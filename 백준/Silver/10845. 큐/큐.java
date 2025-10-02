import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        String prompt;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            prompt = st.nextToken();
            switch (prompt) {
                case "push":
                    q.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (q.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(q.pollFirst() + "\n");
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "empty":
                    int isEmpty = (q.isEmpty()) ? 1 : 0;
                    bw.write(isEmpty + "\n");
                    break;
                case "front":
                    int front = (q.peekFirst() != null) ? q.peekFirst() : -1;
                    bw.write(front + "\n");
                    break;
                case "back":
                    int back = (q.peekLast() != null) ? q.peekLast() : -1;
                    bw.write(back + "\n");
                    break;
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